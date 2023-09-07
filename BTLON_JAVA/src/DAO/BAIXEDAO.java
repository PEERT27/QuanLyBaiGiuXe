/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import HAM.BAIXE;
import HAM.LOAIXE;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class BAIXEDAO {
     public static ArrayList<BAIXE>GetListBaiXe(){
        ArrayList<BAIXE>dsPBan =new ArrayList<BAIXE>();
        try{
            String sql="Select *from BAIXE";
            ConnectionDB pro  = new ConnectionDB();
            pro.getCn();
             ResultSet rs= pro.executeQuery(sql);
            while(rs.next()){
              BAIXE nv =new BAIXE();
              nv.setID(rs.getString("ID"));
              nv.setTENBAI(rs.getString("TENBAI"));
              nv.setSOLUONG(rs.getInt("SOLUONG"));
                dsPBan.add(nv);

            }
            pro.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return dsPBan;
    }
     
     
     public void AddBX(String ID,String TENBAI, int SOLUONG){
        String sql="Insert into BAIXE VALUES ('"+ID+"',N'"+TENBAI+"','"+SOLUONG+"')";
        ConnectionDB pro  = new ConnectionDB();
          pro.getCn();
          int n= pro.executeUpdate(sql);
          pro.close();
    }
     
    public void DeleteBX(String ID){
         String sql="delete from BAIXE where ID='"+ID+"'";
          ConnectionDB pro  = new ConnectionDB();
        pro.getCn();
        int n= pro.executeUpdate(sql);
        pro.close();
     } 
     
     public void UpdateBX(String ID,String TENBAI, int SOLUONG){
        String Sql = "update  BAIXE set TENBAI=(N'"+TENBAI+"') ,SOLUONG=('"+SOLUONG+"') where ID =('"+ID+"')";
         ConnectionDB pro  = new ConnectionDB();
       pro.getCn();
       int n= pro.executeUpdate(Sql);
       pro.close();
    }
     
     public static void FindBX(String ID){
         String Name="";
            try{
                String sql="select * from BAIXE where ID = '"+ID+"' ";
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
     
    public static ArrayList<BAIXE>GetListBaiXe(String t){
        ArrayList<BAIXE>dsPBan =new ArrayList<BAIXE>();
        try{
            String sql="Select *from BAIXE WHERE ID = '"+t+"'";
            ConnectionDB pro  = new ConnectionDB();
            pro.getCn();
             ResultSet rs= pro.executeQuery(sql);
            while(rs.next()){
              BAIXE nv =new BAIXE();
              nv.setID(rs.getString("ID"));
              nv.setTENBAI(rs.getString("TENBAI"));
              nv.setSOLUONG(rs.getInt("SOLUONG"));
                dsPBan.add(nv);

            }
            pro.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return dsPBan;
    } 
    
    
}
