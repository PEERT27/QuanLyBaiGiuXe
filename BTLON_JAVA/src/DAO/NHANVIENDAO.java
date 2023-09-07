/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import HAM.LOAIXE;
import HAM.NHANVIEN;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class NHANVIENDAO {
     public static ArrayList<NHANVIEN>GetListNhanVien(){
        ArrayList<NHANVIEN>dsPBan =new ArrayList<NHANVIEN>();
        try{
            String sql="Select *from NHANVIEN";
            ConnectionDB pro  = new ConnectionDB();
            pro.getCn();
             ResultSet rs= pro.executeQuery(sql);
            while(rs.next()){
              NHANVIEN nv =new NHANVIEN();
              nv.setID(rs.getString("ID"));
              nv.setHOTEN(rs.getString("HOTEN"));
              nv.setSDT(rs.getString("SDT"));
              nv.setEMAIL(rs.getString("EMAIL"));
              nv.setDIACHI(rs.getString("DIACHI"));            
              nv.setTAIKHOAN(rs.getString("TAIKHOAN"));
              nv.setMATKHAU(rs.getString("MATKHAU"));
              nv.setID_PQ(rs.getString("ID_PQ"));
                dsPBan.add(nv);

            }
            pro.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return dsPBan;
    }
     
    public void AddNV(String ID, String HOTEN, String SDT,String EMAIL, String DIACHI, String TAIKHOAN, String MATKHAU, String ID_PQ){
        String sql="Insert into NHANVIEN VALUES ('"+ID+"',N'"+HOTEN+"','"+SDT+"','"+EMAIL+"','"+DIACHI+"','"+TAIKHOAN+"','"+MATKHAU+"','"+ID_PQ+"')";
        ConnectionDB pro  = new ConnectionDB();
          pro.getCn();
          int n= pro.executeUpdate(sql);
          pro.close();
    }
     
    public void DeleteNV(String ID){
         String sql="delete from NHANVIEN where ID='"+ID+"'";
          ConnectionDB pro  = new ConnectionDB();
        pro.getCn();
        int n= pro.executeUpdate(sql);
        pro.close();
     } 
     
     public void UpdateNV(String ID, String HOTEN, String SDT,String EMAIL, String DIACHI, String TAIKHOAN, String MATKHAU, String ID_PQ){
        String Sql = "update  NHANVIEN set HOTEN=(N'"+HOTEN+"') ,SDT=('"+SDT+"') ,EMAIL=('"+EMAIL+"') ,DIACHI=('"+DIACHI+"') ,TAIKHOAN=('"+TAIKHOAN+"') ,MATKHAU=('"+MATKHAU+"') ,ID_PQ=('"+ID_PQ+"') where ID =('"+ID+"')";
         ConnectionDB pro  = new ConnectionDB();
       pro.getCn();
       int n= pro.executeUpdate(Sql);
       pro.close();
    }
     
     public static void FindNV(String ID){
         String Name="";
            try{
                String sql="select * from NHANVIEN where ID = '"+ID+"' ";
                  ConnectionDB pro  = new ConnectionDB();
                pro.getCn();
                ResultSet rs = pro.executeQuery(sql);
                while(rs.next()){
                     Name=rs.getString(1);
            }
             pro.close();
            }catch(Exception ex){
                System.out.print("Lỗi không thấy dữ liệu");
            }

    }
     
    public static ArrayList<NHANVIEN>GetListNhanVien2(String t){
        ArrayList<NHANVIEN>dsPBan =new ArrayList<NHANVIEN>();
        try{
            String sql="Select *from NHANVIEN WHERE ID = '"+t+"'";
            ConnectionDB pro  = new ConnectionDB();
            pro.getCn();
             ResultSet rs= pro.executeQuery(sql);
            while(rs.next()){
              NHANVIEN nv =new NHANVIEN();
              nv.setID(rs.getString("ID"));
              nv.setHOTEN(rs.getString("HOTEN"));
              nv.setSDT(rs.getString("SDT"));
              nv.setEMAIL(rs.getString("EMAIL"));
              nv.setDIACHI(rs.getString("DIACHI"));            
              nv.setTAIKHOAN(rs.getString("TAIKHOAN"));
              nv.setMATKHAU(rs.getString("MATKHAU"));
              nv.setID_PQ(rs.getString("ID_PQ"));
                dsPBan.add(nv);

            }
            pro.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return dsPBan;
    }  
     
}
