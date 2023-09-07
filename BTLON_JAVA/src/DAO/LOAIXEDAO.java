/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import HAM.GUIXE;
import HAM.LOAIXE;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class LOAIXEDAO {
     public static ArrayList<LOAIXE>GetListLoaiXe(){
        ArrayList<LOAIXE>dsPBan =new ArrayList<LOAIXE>();
        try{
            String sql="Select *from LOAIXE";
            ConnectionDB pro  = new ConnectionDB();
            pro.getCn();
             ResultSet rs= pro.executeQuery(sql);
            while(rs.next()){
              LOAIXE lx =new LOAIXE();
              lx.setID(rs.getString("ID"));
              lx.setTENLOAI(rs.getString("TENLOAI"));
              lx.setDONGIA(rs.getFloat("DONGIA"));
                dsPBan.add(lx);

            }
            pro.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return dsPBan;
    }
     
     public void AddLX(String ID,String TENLOAI, float DONGIA){
        String sql="Insert into LOAIXE VALUES ('"+ID+"',N'"+TENLOAI+"','"+DONGIA+"')";
        ConnectionDB pro  = new ConnectionDB();
          pro.getCn();
          int n= pro.executeUpdate(sql);
          pro.close();
    }
     
    public void DeleteLX(String ID){
         String sql="delete from LOAIXE where ID='"+ID+"'";
          ConnectionDB pro  = new ConnectionDB();
        pro.getCn();
        int n= pro.executeUpdate(sql);
        pro.close();
     } 
     
     public void UpdateLX(String ID,String TENLOAI, float DONGIA){
        String Sql = "update  LOAIXE set TENLOAI=(N'"+TENLOAI+"') ,DONGIA=('"+DONGIA+"') where ID =('"+ID+"')";
         ConnectionDB pro  = new ConnectionDB();
       pro.getCn();
       int n= pro.executeUpdate(Sql);
       pro.close();
    }
     
     public static void FindLX(String ID){
         String Name="";
            try{
                String sql="select * from LOAIXE where ID = '"+ID+"' ";
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
     
    public static ArrayList<LOAIXE>GetListLoaiXe2(String t){
        ArrayList<LOAIXE>dsPBan =new ArrayList<LOAIXE>();
        try{
            String sql="Select *from LOAIXE WHERE ID = '"+t+"'";
            ConnectionDB pro  = new ConnectionDB();
            pro.getCn();
             ResultSet rs= pro.executeQuery(sql);
            while(rs.next()){
              LOAIXE lx =new LOAIXE();
              lx.setID(rs.getString("ID"));
              lx.setTENLOAI(rs.getString("TENLOAI"));
              lx.setDONGIA(rs.getFloat("DONGIA"));
                dsPBan.add(lx);

            }
            pro.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return dsPBan;
    } 
     
    
    
}
