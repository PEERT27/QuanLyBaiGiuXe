﻿DROP DATABASE  QUANLIBAIGIUXE1
--
GO
create database QUANLIBAIGIUXE1
GO
USE QUANLIBAIGIUXE1
GO
---

CREATE TABLE LOAIXE
(
	ID VARCHAR(11) PRIMARY KEY,
	TENLOAI NVARCHAR(50) NOT NULL,
	DONGIA FLOAT
)
GO
INSERT INTO LOAIXE(ID,TENLOAI,DONGIA)
	  VALUES('LX01',N'XE 2 CHỖ',5000),
			('LX02',N'XE 4 CHỖ',30000),
			('LX03',N'XE 7 CHỖ',50000)

CREATE TABLE PHANQUYEN
(
	ID VARCHAR(11) PRIMARY KEY,
	TENQUYEN NVARCHAR(20)

)
GO
INSERT INTO PHANQUYEN(ID,TENQUYEN)
   	  VALUES('Q01',N'ADMIN'),
			('Q02',N'NHÂN VIÊN')


CREATE TABLE NHANVIEN
(
	ID VARCHAR(11) PRIMARY KEY,
	HOTEN NVARCHAR(50) NOT NULL,
	SDT VARCHAR(11),
	EMAIL VARCHAR(50),
	DIACHI NVARCHAR(200),
	TAIKHOAN VARCHAR(50),
	MATKHAU VARCHAR(50),
	ID_PQ VARCHAR(11),
	CONSTRAINT FK_NV_PQ FOREIGN KEY(ID_PQ) REFERENCES PHANQUYEN(ID)
)
GO
INSERT INTO NHANVIEN(ID,HOTEN,SDT,EMAIL,DIACHI,TAIKHOAN,MATKHAU,ID_PQ)
   	  VALUES('NV01',N'NGUYỄN NHỌC NIÊN',0889263674,'NIENGA@GMAIL.COM',N'HCM','NIEN123','123','Q02'),
			('NV02',N'ĐÀO ĐỨC HUY',0347536533,'HUYDAOA@GMAIL.COM',N'HCM','HUY123','123','Q02'),
			('NV03',N'CHÂU MINH QUÂN',0347653873,'MINHQUAN@GMAIL.COM',N'HCM','QUAN123','123','Q02')
		
CREATE TABLE BAIXE
(
	ID VARCHAR(11) PRIMARY KEY,
	TENBAI NVARCHAR(50) NOT NULL,
	SOLUONG INT
)
INSERT INTO BAIXE(ID,TENBAI,SOLUONG)
	  VALUES('BX01',N'BÃI XE 2 CHỖ',200),
			('BX02',N'BÃI XE 4 CHỖ',70),
			('BX03',N'BÃI XE 7 CHỖ',50)
			
GO
CREATE TABLE XE
(
	ID VARCHAR(11) PRIMARY KEY,
	BIENSOXE VARCHAR(11) NOT NULL,
	THOIGIANVAO DATETIME,
	GHICHU NVARCHAR(100),
	ID_LOAIXE VARCHAR(11),
	ID_NV VARCHAR(11),
	ID_BAIXE VARCHAR(11),
	CONSTRAINT FK_XE_BAIXE FOREIGN KEY(ID_BAIXE) REFERENCES BAIXE(ID),
	CONSTRAINT FK_XE_LOAIXE FOREIGN KEY(ID_LOAIXE) REFERENCES LOAIXE(ID),
	CONSTRAINT FK_XE_NHANVIEN FOREIGN KEY(ID_NV) REFERENCES NHANVIEN(ID)
)
GO
INSERT INTO XE(ID,BIENSOXE,THOIGIANVAO,GHICHU,ID_LOAIXE,ID_NV,ID_BAIXE)
	  VALUES('X01','93-F284304','2023-06-06 12:30',N'KHÔNG CÓ GHI CHÚ','LX01','NV01','BX01'),
		    ('X02','59-A256789','2023-06-06 08:20',N'KHÔNG CÓ GHI CHÚ','LX02','NV02','BX02'),
		    ('X03','93-L153245','2023-06-06 17:10',N'KHÔNG CÓ GHI CHÚ','LX01','NV03','BX01'),
		    ('X04','77-B284304','2023-06-06 13:30',N'KHÔNG CÓ GHI CHÚ','LX03','NV03','BX03'),
			('X05','59-A199999','2023-06-06 09:00',N'KHÔNG CÓ GHI CHÚ','LX02','NV02','BX02'),
		    ('X06','51-B411111','2023-06-06 19:50',N'KHÔNG CÓ GHI CHÚ','LX03','NV01','BX03')
			
CREATE TABLE HOADON
(
	ID VARCHAR(11) PRIMARY KEY,
	THOIGIANRA DATETIME,
	ID_XE VARCHAR(11),
	ID_NV VARCHAR(11),
	ID_THEXE VARCHAR(11),
	ID_BAIXE VARCHAR(11),
	CONSTRAINT FK_HD_NV FOREIGN KEY(ID_NV) REFERENCES NHANVIEN(ID),
	CONSTRAINT FK_HD_XE FOREIGN KEY(ID_XE) REFERENCES XE(ID),
	CONSTRAINT FK_HD_BAIXE FOREIGN KEY(ID_BAIXE) REFERENCES BAIXE(ID)
)

GO
INSERT INTO HOADON(ID,THOIGIANRA,ID_XE,ID_NV,ID_BAIXE)
	  VALUES('HD01','2023-06-06 13:30','X01','NV01','BX01'),
		    ('HD02','2023-06-06 10:20','X02','NV02','BX02'),
		    ('HD03','2023-06-06 19:10','X03','NV03','BX01'),
		    ('HD04','2023-06-06 18:30','X04','NV03','BX03'),
			('HD05','2023-06-06 12:00','X05','NV02','BX02'),
		    ('HD06','2023-06-06 21:50','X06','NV01','BX03')


SELECT hd.ID, x.THOIGIANVAO, hd.THOIGIANRA, x.BIENSOXE, hd.ID_XE, hd.ID_NV, hd.ID_BAIXE
FROM HOADON hd
INNER JOIN XE x ON hd.ID_XE = x.ID

SELECT
    hd.ID,
    x.THOIGIANVAO,
    hd.THOIGIANRA,
    x.BIENSOXE,
    hd.ID_XE,
    hd.ID_NV,
    hd.ID_BAIXE,
    CASE
        WHEN DATEDIFF(MINUTE, x.THOIGIANVAO, hd.THOIGIANRA) < 60 THEN (DATEDIFF(MINUTE, x.THOIGIANVAO, hd.THOIGIANRA) + 1) * l.DONGIA
        WHEN DATEDIFF(HOUR, x.THOIGIANVAO, hd.THOIGIANRA) < 24 THEN (DATEDIFF(HOUR, x.THOIGIANVAO, hd.THOIGIANRA) + 1) * l.DONGIA
        ELSE (DATEDIFF(DAY, x.THOIGIANVAO, hd.THOIGIANRA) + 1) * l.DONGIA
    END AS TIENTHUE
FROM
    HOADON hd
INNER JOIN
    XE x ON hd.ID_XE = x.ID
INNER JOIN
    LOAIXE l ON x.ID_LOAIXE = l.ID;


INSERT INTO HOADON(ID,THOIGIANRA,ID_XE,ID_NV,ID_BAIXE) VALUES ('HD07','2023-06-07  21:30','X07','NV01','BX03')

select*from XE

INSERT INTO XE(ID,BIENSOXE,THOIGIANVAO,GHICHU,ID_LOAIXE,ID_NV,ID_BAIXE) VALUES('X07','93-F284304','2023-06-06 12:30',N'KHÔNG CÓ GHI CHÚ','LX01','NV01','BX01')