/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import HAM.GUIXE;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class GUIXEDAO {
    public static ArrayList<GUIXE>GetListGuiXe(){
        ArrayList<GUIXE>dsPBan =new ArrayList<GUIXE>();
        try{
            String sql="Select *from XE";
            ConnectionDB pro  = new ConnectionDB();
            pro.getCn();
             ResultSet rs= pro.executeQuery(sql);
            while(rs.next()){
              GUIXE sp =new GUIXE();
              sp.setID(rs.getString("ID"));
              sp.setBIENSOXE(rs.getString("BIENSOXE"));
              sp.setTHOIGIANVAO(rs.getString("THOIGIANVAO"));
              sp.setGHICHU(rs.getString("GHICHU"));
              sp.setLOAIXE(rs.getString("ID_LOAIXE"));
              sp.setNHANVIEN(rs.getString("ID_NV"));
              sp.setBAIXE(rs.getString("ID_BAIXE"));
                dsPBan.add(sp);

            }
            pro.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return dsPBan;
    }
    
    public void AddGX(String ID, String BIENSOXE, String THOIGIANVAO, String GHICHU, String ID_LOAIXE, String ID_NV, String ID_BAIXE) {

        String sql = "set dateformat dmy INSERT INTO XE VALUES('" + ID + "','" + BIENSOXE + "','" + THOIGIANVAO + "','"+GHICHU+"','"+ID_LOAIXE+"','"+ID_NV+"','"+ID_BAIXE+"')";
        
        String sql1 = "INSERT INTO XE(ID,BIENSOXE,THOIGIANVAO,GHICHU,ID_LOAIXE,ID_NV,ID_BAIXE) VALUES('"+ID+"','"+BIENSOXE+"','"+THOIGIANVAO+"',N'"+GHICHU+"','"+ID_LOAIXE+"','"+ID_NV+"','"+ID_BAIXE+"')";
        ConnectionDB pro = new ConnectionDB();
        pro.getCn();
        int n = pro.executeUpdate(sql1);
        pro.close();
    }
    
    public void DeleteGX(String ID){
         String sql="delete from XE where ID='"+ID+"'";
          ConnectionDB pro  = new ConnectionDB();
        pro.getCn();
        int n= pro.executeUpdate(sql);
        pro.close();
     } 
    
     public void UpdateGX(String ID, String BIENSOXE, String THOIGIANVAO, String GHICHU, String ID_LOAIXE, String ID_NV, String ID_BAIXE){
        String Sql = "update  XE set BIENSOXE=(N'"+BIENSOXE+"') ,THOIGIANVAO=('"+THOIGIANVAO+"') ,GHICHU=('"+GHICHU+"') ,ID_LOAIXE=('"+ID_LOAIXE+"') ,ID_NV=('"+ID_NV+"') ,ID_BAIXE=('"+ID_BAIXE+"') where ID =('"+ID+"')";
         ConnectionDB pro  = new ConnectionDB();
       pro.getCn();
       int n= pro.executeUpdate(Sql);
       pro.close();
    }
     
     public static void FindNV(String ID){
         String Name="";
            try{
                String sql="select * from XE where ID = '"+ID+"' ";
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
     
    
    public static ArrayList<GUIXE>GetListGuiXe2(String t){
        ArrayList<GUIXE>dsPBan =new ArrayList<GUIXE>();
        try{
            String sql="Select *from XE  WHERE ID = '"+t+"'";
            ConnectionDB pro  = new ConnectionDB();
            pro.getCn();
             ResultSet rs= pro.executeQuery(sql);
            while(rs.next()){
              GUIXE sp =new GUIXE();
              sp.setID(rs.getString("ID"));
              sp.setBIENSOXE(rs.getString("BIENSOXE"));
              sp.setTHOIGIANVAO(rs.getString("THOIGIANVAO"));
              sp.setGHICHU(rs.getString("GHICHU"));
              sp.setLOAIXE(rs.getString("ID_LOAIXE"));
              sp.setNHANVIEN(rs.getString("ID_NV"));
              sp.setBAIXE(rs.getString("ID_BAIXE"));
                dsPBan.add(sp);

            }
            pro.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return dsPBan;
    }
}
