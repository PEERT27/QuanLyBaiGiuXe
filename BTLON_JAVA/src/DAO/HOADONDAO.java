package DAO;

import HAM.GUIXE;
import HAM.HoaDon;
import java.sql.ResultSet;
import java.util.ArrayList;

public class HOADONDAO {

    public static ArrayList<HoaDon> GetListLayXe() {
        ArrayList<HoaDon> dsPBan = new ArrayList<HoaDon>();
        try {
            String sql = "SELECT\n" +
"    hd.ID,\n" +
"    x.THOIGIANVAO,\n" +
"    hd.THOIGIANRA,\n" +
"    x.BIENSOXE,\n" +
"    hd.ID_XE,\n" +
"    hd.ID_NV,\n" +
"    hd.ID_BAIXE,\n" +
"    CASE\n" +
"        WHEN DATEDIFF(MINUTE, x.THOIGIANVAO, hd.THOIGIANRA) < 60 THEN (DATEDIFF(MINUTE, x.THOIGIANVAO, hd.THOIGIANRA) + 1) * l.DONGIA\n" +
"        WHEN DATEDIFF(HOUR, x.THOIGIANVAO, hd.THOIGIANRA) < 24 THEN (DATEDIFF(HOUR, x.THOIGIANVAO, hd.THOIGIANRA) + 1) * l.DONGIA\n" +
"        ELSE (DATEDIFF(DAY, x.THOIGIANVAO, hd.THOIGIANRA) + 1) * l.DONGIA\n" +
"    END AS TIENTHUE\n" +
"FROM\n" +
"    HOADON hd\n" +
"INNER JOIN\n" +
"    XE x ON hd.ID_XE = x.ID\n" +
"INNER JOIN\n" +
"    LOAIXE l ON x.ID_LOAIXE = l.ID";
            ConnectionDB pro = new ConnectionDB();
            pro.getCn();
            ResultSet rs = pro.executeQuery(sql);
            while (rs.next()) {
                HoaDon sp = new HoaDon();
                sp.setId(rs.getString(1));
                sp.setTHOIGIANVAO(rs.getString(2));
                sp.setTHOIGIANRA(rs.getString(3));
                sp.setBiensoxe(rs.getString(4));
                sp.setIdthexe(rs.getString(5));
                sp.setIdnhanvien(rs.getString(6));
                sp.setIdbaixe(rs.getString(7));
                sp.setThanhtien(rs.getInt(8));
                dsPBan.add(sp);
            }
            pro.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dsPBan;
    }
    
    
    
     public void AddLayXe(String ID, String THOIGIANRA, String ID_XE, String ID_NV, String ID_BAIXE) {


        
        String sql1 = "INSERT INTO HOADON(ID,THOIGIANRA,ID_XE,ID_NV,ID_BAIXE) VALUES ('"+ID+"','"+THOIGIANRA+"','"+ID_XE+"','"+ID_NV+"','"+ID_BAIXE+"')";
        ConnectionDB pro = new ConnectionDB();
        pro.getCn();
        int n = pro.executeUpdate(sql1);
        pro.close();
    }
     
     
}
