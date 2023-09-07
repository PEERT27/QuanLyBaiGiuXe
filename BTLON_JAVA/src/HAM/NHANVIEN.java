/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HAM;

/**
 *
 * @author Admin
 */
public class NHANVIEN {

    public void setID_PQ(String ID_PQ) {
        this.ID_PQ = ID_PQ;
    }

    public NHANVIEN() {
    }

    public NHANVIEN(String ID, String HOTEN, String SDT, String EMAIL, String DIACHI, String TAIKHOAN, String MATKHAU, String ID_PQ) {
        this.ID = ID;
        this.HOTEN = HOTEN;
        this.SDT = SDT;
        this.EMAIL = EMAIL;
        this.DIACHI = DIACHI;
        this.TAIKHOAN = TAIKHOAN;
        this.MATKHAU = MATKHAU;
        this.ID_PQ = ID_PQ;
    }

    public String getID() {
        return ID;
    }

    public String getHOTEN() {
        return HOTEN;
    }

    public String getSDT() {
        return SDT;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public String getDIACHI() {
        return DIACHI;
    }

    public String getTAIKHOAN() {
        return TAIKHOAN;
    }

    public String getMATKHAU() {
        return MATKHAU;
    }

    public String getID_PQ() {
        return ID_PQ;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setHOTEN(String HOTEN) {
        this.HOTEN = HOTEN;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public void setDIACHI(String DIACHI) {
        this.DIACHI = DIACHI;
    }

    public void setTAIKHOAN(String TAIKHOAN) {
        this.TAIKHOAN = TAIKHOAN;
    }

    public void setMATKHAU(String MATKHAU) {
        this.MATKHAU = MATKHAU;
    }

 
    private String ID, HOTEN, SDT, 
            EMAIL, DIACHI, TAIKHOAN,
            MATKHAU, ID_PQ;
}
