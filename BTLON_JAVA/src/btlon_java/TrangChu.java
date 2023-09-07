/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package btlon_java;


import DAO.BAIXEDAO;
import DAO.ConnectionDB;
import DAO.GUIXEDAO;
import DAO.HOADONDAO;
import DAO.LOAIXEDAO;
import DAO.NHANVIENDAO;
import HAM.BAIXE;
import HAM.GUIXE;
import HAM.HoaDon;
import HAM.LOAIXE;
import HAM.MyCombobox;
import HAM.NHANVIEN;
import HAM.THEXE;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;




/**
 *
 * @author Admin
 */
public class TrangChu extends javax.swing.JFrame {

    ArrayList<GUIXE> dsSV = new ArrayList<GUIXE>();
    int index = 0;

    /**
     * Creates new form TrangChu
     */
    public TrangChu() {
        initComponents();

        TableGX();
        TableLX();
        TableNV();
        TableBX();
        LoaiXeCbx();
        NhanVienCbx();
        BaiXeCbx();
        TableLayXe();
        TheXeCbx();
        BaiXeCbxGX();
        NhanVienCbxGX();
        
        jButton7.setText(login.fullname);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS", Locale.US);
        datetgvao.setDateFormatString(dateFormat.toPattern());
        Date now = new Date();
        datetgvao.setDate(now);
        
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS", Locale.US);
        datengayvaolx.setDateFormatString(dateFormat1.toPattern());
        
        
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS", Locale.US);
        datengayragx.setDateFormatString(dateFormat2.toPattern());
        Date now2= new Date();
        datengayragx.setDate(now2);
        
    }

// GUI XE NHA QUAN
    public void TableGX() {
        ArrayList<GUIXE> dsSinhVien1 = GUIXEDAO.GetListGuiXe();
        DefaultTableModel dtmSinhVien = (DefaultTableModel) tbguixe.getModel();
        dtmSinhVien.setRowCount(0);
        for (GUIXE sv1 : dsSinhVien1) {
            Vector<Object> vec = new Vector<Object>();
            vec.add(sv1.getID());
            vec.add(sv1.getBIENSOXE());
            vec.add(sv1.getTHOIGIANVAO());
            vec.add(sv1.getGHICHU());
            vec.add(sv1.getLOAIXE());
            vec.add(sv1.getNHANVIEN());
            vec.add(sv1.getBAIXE());
            dtmSinhVien.addRow(vec);
        }
        tbguixe.setModel(dtmSinhVien);
    }

    
    DefaultComboBoxModel cbbModel = new DefaultComboBoxModel();
    public void LoaiXeCbx() {

        ArrayList<LOAIXE> dsPBan2 = new ArrayList<LOAIXE>();

        String sql = "Select *from LOAIXE";
        ConnectionDB pro = new ConnectionDB();
        pro.getCn();
        ResultSet rs = pro.executeQuery(sql);

        cbbModel = (DefaultComboBoxModel) cbxloaixegx.getModel();
        cbbModel.removeAllElements();

        try {
            while (rs.next()) {
                String ID = rs.getString("ID");
                String TENLOAI = rs.getString("TENLOAI").trim();

                MyCombobox mycbb = new MyCombobox(ID, ID);

                cbbModel.addElement(mycbb);
            }
            cbxloaixegx.setModel(cbbModel);
        } catch (Exception e) {

        }
    }
    
    DefaultComboBoxModel cbbModel1 = new DefaultComboBoxModel();
    public void NhanVienCbx() {

        ArrayList<NHANVIEN> dsPBan2 = new ArrayList<NHANVIEN>();

        String sql = "Select *from NHANVIEN";
        ConnectionDB pro = new ConnectionDB();
        pro.getCn();
        ResultSet rs = pro.executeQuery(sql);

        cbbModel1 = (DefaultComboBoxModel) cbxnhanviengx.getModel();
        cbbModel1.removeAllElements();

        try {
            while (rs.next()) {
                String ID = rs.getString("ID");
                String HOTEN = rs.getString("HOTEN").trim();

                MyCombobox mycbb = new MyCombobox(ID, ID);

                cbbModel1.addElement(mycbb);
            }
            cbxnhanviengx.setModel(cbbModel1);
        } catch (Exception e) {

        }
    }
    
    
    
    DefaultComboBoxModel cbbModel3 = new DefaultComboBoxModel();
    public void BaiXeCbx() {

        ArrayList<BAIXE> dsPBan2 = new ArrayList<BAIXE>();

        String sql = "Select *from BAIXE";
        ConnectionDB pro = new ConnectionDB();
        pro.getCn();
        ResultSet rs = pro.executeQuery(sql);

        cbbModel3 = (DefaultComboBoxModel) cbxbaixegx.getModel();
        cbbModel3.removeAllElements();

        try {
            while (rs.next()) {
                String ID = rs.getString("ID");
              

                MyCombobox mycbb = new MyCombobox(ID, ID);

                cbbModel3.addElement(mycbb);
            }
            cbxbaixegx.setModel(cbbModel3);
        } catch (Exception e) {

        }
    }
    
    
    public void AddGX() {
        SimpleDateFormat dateFormat10= new SimpleDateFormat("yyyy-MM-dd HH:MM:SS", Locale.US);
        String day = dateFormat10.format(datetgvao.getDate());

        try {

            GUIXEDAO hd = new GUIXEDAO();
            hd.AddGX(txtmagx.getText().trim(),
                    txtbsx.getText().trim(),
                    day,
                    txtghichugx.getText().trim(),
                    cbxloaixegx.getSelectedItem().toString(),
                    cbxnhanviengx.getSelectedItem().toString(),
                    cbxbaixegx.getSelectedItem().toString()

            );
            JOptionPane.showMessageDialog(this, "ok");
            TableGX();
        } catch (Exception ex) {

            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "lỗi");
        }
    }
    
    public void DeleteGX() {
        try {
            GUIXEDAO kh = new GUIXEDAO();
            kh.DeleteGX(txtmagx.getText().trim());
            JOptionPane.showMessageDialog(this, "Xoá Thành Công");
            TableGX();
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "lỗi");

        }
    }
    
   public void UpdateGX() {
        SimpleDateFormat dateFormat2= new SimpleDateFormat("yyyy-MM-dd HH:MM:SS", Locale.US);
        String day = dateFormat2.format(datetgvao.getDate());
        try {
            GUIXEDAO sv = new GUIXEDAO();

            sv.UpdateGX(txtmagx.getText().trim(),
                    txtbsx.getText().trim(),
                    day,
                    txtghichugx.getText().trim(),
                    cbxloaixegx.getSelectedItem().toString(),
                    cbxnhanviengx.getSelectedItem().toString(),
                    cbxbaixegx.getSelectedItem().toString()

            );
            JOptionPane.showMessageDialog(this, "Cập Nhật Thành Công");
            TableGX();
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Không Tìm Thấy");
        }

    }

    public void FindGX() {
        try {
            GUIXEDAO sv = new GUIXEDAO();

            sv.FindNV(idnv.getText().trim());
            JOptionPane.showMessageDialog(this, "Tìm kiếm Thành Công");
            TableNV2(nvsearch.getText().trim());
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Không Tìm Thấy");
        }

    }
    
    public void TableGX2(String ID) {
        ArrayList<GUIXE> dsSinhVien1 = GUIXEDAO.GetListGuiXe2(ID);
        DefaultTableModel dtmSinhVien = (DefaultTableModel) tbguixe.getModel();
        dtmSinhVien.setRowCount(0);
        for (GUIXE sv1 : dsSinhVien1) {
            Vector<Object> vec = new Vector<Object>();
            vec.add(sv1.getID());
            vec.add(sv1.getBIENSOXE());
            vec.add(sv1.getTHOIGIANVAO());
            vec.add(sv1.getGHICHU());
            vec.add(sv1.getLOAIXE());
            vec.add(sv1.getNHANVIEN());
            vec.add(sv1.getBAIXE());
            dtmSinhVien.addRow(vec);
        }
        tbguixe.setModel(dtmSinhVien);
    }
   
 //LOAI XE
    public void TableLX() {
        ArrayList<LOAIXE> dsSinhVien1 = LOAIXEDAO.GetListLoaiXe();
        DefaultTableModel dtmSinhVien = (DefaultTableModel) tbloaixe.getModel();
        dtmSinhVien.setRowCount(0);
        for (LOAIXE sv1 : dsSinhVien1) {
            Vector<Object> vec = new Vector<Object>();
            vec.add(sv1.getID());
            vec.add(sv1.getTENLOAI());
            vec.add(sv1.getDONGIA());
          
            dtmSinhVien.addRow(vec);
        }
        tbloaixe.setModel(dtmSinhVien);
    }
   
    public void AddLX() {
        try {
            LOAIXEDAO sv = new LOAIXEDAO();

            sv.AddLX(idlx.getText().trim(), tlx.getText().trim(), Integer.parseInt(dglx.getText().trim()));
            JOptionPane.showMessageDialog(this, "Thêm Thành Công");
            TableLX();
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "lỗi");
        }
    }
    
    public void DeleteLX() {
        try {
            LOAIXEDAO kh = new LOAIXEDAO();
            kh.DeleteLX(idlx.getText().trim());
            JOptionPane.showMessageDialog(this, "Xoá Thành Công");
            TableLX();
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "lỗi");

        }
    }
    
   public void UpdateLX() {

        try {
            LOAIXEDAO sv = new LOAIXEDAO();

            sv.UpdateLX(idlx.getText().trim(), tlx.getText().trim(), Integer.parseInt(dglx.getText().trim()));
            JOptionPane.showMessageDialog(this, "Cập Nhật Thành Công");
            TableLX();
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Không Tìm Thấy");
        }

    }

    public void FindLX() {
        try {
            LOAIXEDAO sv = new LOAIXEDAO();

            sv.FindLX(idlx.getText().trim());
            JOptionPane.showMessageDialog(this, "Tìm kiếm Thành Công");
            TableLX2(lxsearch.getText().trim());
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Không Tìm Thấy");
        }

    }
    
    public void TableLX2(String ID) {
        ArrayList<LOAIXE> dsSinhVien1 = LOAIXEDAO.GetListLoaiXe2( ID);
        DefaultTableModel dtmSinhVien = (DefaultTableModel) tbloaixe.getModel();
        dtmSinhVien.setRowCount(0);
        for (LOAIXE sv1 : dsSinhVien1) {
            Vector<Object> vec = new Vector<Object>();
            vec.add(sv1.getID());
            vec.add(sv1.getTENLOAI());
            vec.add(sv1.getDONGIA());
          
            dtmSinhVien.addRow(vec);
        }
        tbloaixe.setModel(dtmSinhVien);
    }
   
 //NHAN VIEN
    public void TableNV() {
        ArrayList<NHANVIEN> dsSinhVien1 = NHANVIENDAO.GetListNhanVien();
        DefaultTableModel dtmSinhVien = (DefaultTableModel) tbnvxe.getModel();
        dtmSinhVien.setRowCount(0);
        for (NHANVIEN sv1 : dsSinhVien1) {
            Vector<Object> vec = new Vector<Object>();
            vec.add(sv1.getID());
            vec.add(sv1.getHOTEN());
            vec.add(sv1.getSDT());
            vec.add(sv1.getEMAIL());
            vec.add(sv1.getDIACHI());
            vec.add(sv1.getTAIKHOAN());
            vec.add(sv1.getMATKHAU());
            vec.add(sv1.getID_PQ());
            dtmSinhVien.addRow(vec);
        }
        tbnvxe.setModel(dtmSinhVien);
    }
    
    public void AddNV() {
        try {
            NHANVIENDAO sv = new NHANVIENDAO();

            sv.AddNV(idnv.getText().trim(), htnv.getText().trim(), sdtnv.getText().trim(), emailnv.getText().trim(), diachinv.getText().trim(), tknv.getText().trim(), mknv.getText().trim(), pqnv.getText().trim());
            JOptionPane.showMessageDialog(this, "Thêm Thành Công");
            TableNV();
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "lỗi");
        }
    }
    
    public void DeleteNV() {
        try {
            NHANVIENDAO kh = new NHANVIENDAO();
            kh.DeleteNV(idnv.getText().trim());
            JOptionPane.showMessageDialog(this, "Xoá Thành Công");
            TableNV();
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "lỗi");

        }
    }
    
   public void UpdateNV() {

        try {
            NHANVIENDAO sv = new NHANVIENDAO();

            sv.UpdateNV(idnv.getText().trim(), htnv.getText().trim(), sdtnv.getText().trim(), emailnv.getText().trim(), diachinv.getText().trim(), tknv.getText().trim(), mknv.getText().trim(), pqnv.getText().trim());
            JOptionPane.showMessageDialog(this, "Cập Nhật Thành Công");
            TableNV();
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Không Tìm Thấy");
        }

    }

    public void FindNV() {
        try {
            NHANVIENDAO sv = new NHANVIENDAO();

            sv.FindNV(idnv.getText().trim());
            JOptionPane.showMessageDialog(this, "Tìm kiếm Thành Công");
            TableNV2(nvsearch.getText().trim());
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Không Tìm Thấy");
        }

    }
    
    public void TableNV2(String ID) {
        ArrayList<NHANVIEN> dsSinhVien1 = NHANVIENDAO.GetListNhanVien2(ID);
        DefaultTableModel dtmSinhVien = (DefaultTableModel) tbnvxe.getModel();
        dtmSinhVien.setRowCount(0);
        for (NHANVIEN sv1 : dsSinhVien1) {
            Vector<Object> vec = new Vector<Object>();
            vec.add(sv1.getID());
            vec.add(sv1.getHOTEN());
            vec.add(sv1.getSDT());
            vec.add(sv1.getEMAIL());
            vec.add(sv1.getDIACHI());
            vec.add(sv1.getTAIKHOAN());
            vec.add(sv1.getMATKHAU());
            vec.add(sv1.getID_PQ());
            dtmSinhVien.addRow(vec);
        }
        tbnvxe.setModel(dtmSinhVien);
    }

  
    
   //BAI XE
    public void TableBX() {
        ArrayList<BAIXE> dsSinhVien1 = BAIXEDAO.GetListBaiXe();
        DefaultTableModel dtmSinhVien = (DefaultTableModel) tbbaixe.getModel();
        dtmSinhVien.setRowCount(0);
        for (BAIXE sv1 : dsSinhVien1) {
            Vector<Object> vec = new Vector<Object>();
            vec.add(sv1.getID());
            vec.add(sv1.getTENBAI());
            vec.add(sv1.getSOLUONG());
            
          
            dtmSinhVien.addRow(vec);
        }
        tbbaixe.setModel(dtmSinhVien);
    }
    
    public void AddBX() {
        try {
            BAIXEDAO sv = new BAIXEDAO();

            sv.AddBX(idbx.getText().trim(), tbx.getText().trim(), Integer.parseInt(slbx.getText().trim()));
            JOptionPane.showMessageDialog(this, "Thêm Thành Công");
            TableBX();
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "lỗi");
        }
    }
    
    public void DeleteBX() {
        try {
            BAIXEDAO kh = new BAIXEDAO();
            kh.DeleteBX(idbx.getText().trim());
            JOptionPane.showMessageDialog(this, "Xoá Thành Công");
            TableBX();
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "lỗi");

        }
    }
    
   public void UpdateBX() {

        try {
            BAIXEDAO sv = new BAIXEDAO();

            sv.UpdateBX(idbx.getText().trim(), tbx.getText().trim(), Integer.parseInt(slbx.getText().trim()));
            JOptionPane.showMessageDialog(this, "Cập Nhật Thành Công");
            TableBX();
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Không Tìm Thấy");
        }

    }

    public void FindBX() {
        try {
            BAIXEDAO sv = new BAIXEDAO();

            sv.FindBX(idbx.getText().trim());
            JOptionPane.showMessageDialog(this, "Tìm kiếm Thành Công");
            TableBX2(bxsearch.getText().trim());
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Không Tìm Thấy");
        }

    }
    
    public void TableBX2(String ID) {
        ArrayList<BAIXE> dsSinhVien1 = BAIXEDAO.GetListBaiXe(ID);
        DefaultTableModel dtmSinhVien = (DefaultTableModel) tbbaixe.getModel();
        dtmSinhVien.setRowCount(0);
        for (BAIXE sv1 : dsSinhVien1) {
            Vector<Object> vec = new Vector<Object>();
            vec.add(sv1.getID());
            vec.add(sv1.getTENBAI());
            vec.add(sv1.getSOLUONG());
            
          
            dtmSinhVien.addRow(vec);
        }
        tbbaixe.setModel(dtmSinhVien);
    }
    
    
//LAY XE LAY XE
    
    public void TableLayXe() {
        ArrayList<HoaDon> dsSinhVien1 = HOADONDAO.GetListLayXe();
        DefaultTableModel dtmSinhVien = (DefaultTableModel) tblayxe.getModel();
        dtmSinhVien.setRowCount(0);
        for (HoaDon sv1 : dsSinhVien1) {
            Vector<Object> vec = new Vector<Object>();
            vec.add(sv1.getId());
            vec.add(sv1.getTHOIGIANVAO());
            vec.add(sv1.getTHOIGIANRA());
            vec.add(sv1.getBiensoxe());
            vec.add(sv1.getIdthexe());
            vec.add(sv1.getIdnhanvien());
            vec.add(sv1.getIdbaixe());
            vec.add(sv1.getThanhtien());
            dtmSinhVien.addRow(vec);
        }
        tblayxe.setModel(dtmSinhVien);
    }
    
    DefaultComboBoxModel cbbModel4 = new DefaultComboBoxModel();
    public void TheXeCbx() {

        ArrayList<GUIXE> dsPBan2 = new ArrayList<GUIXE>();

        String sql = "Select *from XE";
        ConnectionDB pro = new ConnectionDB();
        pro.getCn();
        ResultSet rs = pro.executeQuery(sql);

        cbbModel4 = (DefaultComboBoxModel) cbbtenkh.getModel();
        cbbModel4.removeAllElements();

        try {
            while (rs.next()) {
                String ID = rs.getString("ID");

                MyCombobox mycbb = new MyCombobox(ID, ID);

                cbbModel4.addElement(mycbb);
            }
            cbbtenkh.setModel(cbbModel4);
        } catch (Exception e) {

        }
    }
    
    DefaultComboBoxModel cbbModel5 = new DefaultComboBoxModel();
    public void BaiXeCbxGX() {

        ArrayList<BAIXE> dsPBan2 = new ArrayList<BAIXE>();

        String sql = "Select *from BAIXE";
        ConnectionDB pro = new ConnectionDB();
        pro.getCn();
        ResultSet rs = pro.executeQuery(sql);

        cbbModel5 = (DefaultComboBoxModel) cbbsp.getModel();
        cbbModel5.removeAllElements();

        try {
            while (rs.next()) {
                String ID = rs.getString("ID");

                MyCombobox mycbb = new MyCombobox(ID, ID);

                cbbModel5.addElement(mycbb);
            }
            cbbsp.setModel(cbbModel5);
        } catch (Exception e) {

        }
    }
    
    DefaultComboBoxModel cbbModel6 = new DefaultComboBoxModel();
    public void NhanVienCbxGX() {

        ArrayList<NHANVIEN> dsPBan2 = new ArrayList<NHANVIEN>();

        String sql = "Select *from NHANVIEN";
        ConnectionDB pro = new ConnectionDB();
        pro.getCn();
        ResultSet rs = pro.executeQuery(sql);

        cbbModel6 = (DefaultComboBoxModel) cbbsp1.getModel();
        cbbModel6.removeAllElements();

        try {
            while (rs.next()) {
                String ID = rs.getString("ID");

                MyCombobox mycbb = new MyCombobox(ID, ID);

                cbbModel6.addElement(mycbb);
            }
            cbbsp1.setModel(cbbModel6);
        } catch (Exception e) {

        }
    }
    
     public void AddLayXe() {
        SimpleDateFormat dateFormat10= new SimpleDateFormat("yyyy-MM-dd HH:MM:SS", Locale.US);
        String day = dateFormat10.format(datetgvao.getDate());

        try {

            HOADONDAO hd = new HOADONDAO();
            hd.AddLayXe(txtmahd.getText().trim(),
                    day,
                    cbbtenkh.getSelectedItem().toString(),
                    cbbsp1.getSelectedItem().toString(),
                    cbbsp.getSelectedItem().toString()

            );
            JOptionPane.showMessageDialog(this, "ok");
            TableLayXe();
        } catch (Exception ex) {

            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "lỗi");
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtmagx = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtbsx = new javax.swing.JTextField();
        txtghichugx = new javax.swing.JTextField();
        btnaddsp = new javax.swing.JButton();
        btndeletesp = new javax.swing.JButton();
        btnrepairsp = new javax.swing.JButton();
        btnresetsp = new javax.swing.JButton();
        btnsearchsp = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtspsearch = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbguixe = new javax.swing.JTable();
        jLabel34 = new javax.swing.JLabel();
        cbxloaixegx = new javax.swing.JComboBox<>();
        cbxnhanviengx = new javax.swing.JComboBox<>();
        cbxbaixegx = new javax.swing.JComboBox<>();
        datetgvao = new com.toedter.calendar.JDateChooser();
        jButton7 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbloaixe = new javax.swing.JTable();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        idlx = new javax.swing.JTextField();
        tlx = new javax.swing.JTextField();
        btnaddlsp = new javax.swing.JButton();
        btndeletesp1 = new javax.swing.JButton();
        btnrepairsp1 = new javax.swing.JButton();
        btnresetsp1 = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        lxsearch = new javax.swing.JTextField();
        btnsearchsp1 = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        dglx = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tbnvxe = new javax.swing.JTable();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        idnv = new javax.swing.JTextField();
        htnv = new javax.swing.JTextField();
        btnaddlsp1 = new javax.swing.JButton();
        btndeletesp2 = new javax.swing.JButton();
        btnrepairsp2 = new javax.swing.JButton();
        btnresetsp2 = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        nvsearch = new javax.swing.JTextField();
        btnsearchsp2 = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        emailnv = new javax.swing.JTextField();
        sdtnv = new javax.swing.JTextField();
        diachinv = new javax.swing.JTextField();
        tknv = new javax.swing.JTextField();
        mknv = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        pqnv = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tbbaixe = new javax.swing.JTable();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        idbx = new javax.swing.JTextField();
        tbx = new javax.swing.JTextField();
        btnaddlsp4 = new javax.swing.JButton();
        btndeletesp5 = new javax.swing.JButton();
        btnrepairsp5 = new javax.swing.JButton();
        btnresetsp5 = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        bxsearch = new javax.swing.JTextField();
        btnsearchsp5 = new javax.swing.JButton();
        jLabel51 = new javax.swing.JLabel();
        slbx = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblayxe = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        b = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        lblMaHoaDon_HoaDon = new javax.swing.JLabel();
        txtmahd = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cbbtenkh = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        cbbsp = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtsolghd = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txttongtienhd = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        datengayvaolx = new com.toedter.calendar.JDateChooser();
        jLabel26 = new javax.swing.JLabel();
        datengayragx = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txthienthua = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        cbbsp1 = new javax.swing.JComboBox<>();
        txtsolghd1 = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblayxe1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane2.setBackground(new java.awt.Color(255, 153, 51));
        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane2.setPreferredSize(new java.awt.Dimension(1000, 520));
        jTabbedPane2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jTabbedPane2ComponentResized(evt);
            }
        });

        jPanel2.setPreferredSize(new java.awt.Dimension(900, 498));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/tcxe.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("", new javax.swing.ImageIcon(getClass().getResource("/hinh/LOGO1.png")), jPanel2); // NOI18N

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, -1, -1));
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 400, -1, -1));
        jPanel4.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel8.setBackground(new java.awt.Color(204, 204, 255));

        jLabel2.setText("Mã:");

        jLabel3.setText("Biển số xe:");

        jLabel5.setText("Thời gian vào:");

        jLabel8.setText("Ghi chú:");

        jLabel9.setText("Loại xe:");

        jLabel23.setText("Nhân viên:");

        btnaddsp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnaddsp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/add.png"))); // NOI18N
        btnaddsp.setText("THÊM");
        btnaddsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddspActionPerformed(evt);
            }
        });

        btndeletesp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btndeletesp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/remove.png"))); // NOI18N
        btndeletesp.setText("XÓA");
        btndeletesp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeletespActionPerformed(evt);
            }
        });

        btnrepairsp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnrepairsp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/repair.png"))); // NOI18N
        btnrepairsp.setText("SỬA");
        btnrepairsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrepairspActionPerformed(evt);
            }
        });

        btnresetsp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnresetsp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/reset.png"))); // NOI18N
        btnresetsp.setText("RESET");
        btnresetsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetspActionPerformed(evt);
            }
        });

        btnsearchsp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnsearchsp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/search.png"))); // NOI18N
        btnsearchsp.setText("SEARCH");
        btnsearchsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchspActionPerformed(evt);
            }
        });

        jLabel4.setText("Nhập xe bạn muốm tìm kiếm:");

        jLabel22.setText(": Đang đăng nhập");

        tbguixe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Biển số xe", "Thơi gian vào", "Ghi chú", "Loại xe", "Nhân viên", "Bãi xe"
            }
        ));
        tbguixe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbguixeMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbguixe);

        jLabel34.setText("Bãi xe:");

        cbxloaixegx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxloaixegx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxloaixegxActionPerformed(evt);
            }
        });

        cbxnhanviengx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxnhanviengx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxnhanviengxActionPerformed(evt);
            }
        });

        cbxbaixegx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxbaixegx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxbaixegxActionPerformed(evt);
            }
        });

        jButton7.setText("jButton7");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(23, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel23)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel34)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(datetgvao, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtmagx, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                            .addComponent(txtbsx, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(78, 78, 78)
                                            .addComponent(btnaddsp)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btndeletesp, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                            .addGap(237, 237, 237)
                                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel8Layout.createSequentialGroup()
                                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtspsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel22)))))))
                            .addComponent(txtghichugx, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxloaixegx, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxnhanviengx, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxbaixegx, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnrepairsp, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(btnresetsp)
                                .addGap(157, 157, 157))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(btnsearchsp, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtmagx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtbsx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(datetgvao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(txtghichugx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cbxloaixegx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(cbxnhanviengx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(cbxbaixegx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnaddsp)
                            .addComponent(btndeletesp)
                            .addComponent(btnrepairsp)
                            .addComponent(btnresetsp, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(txtspsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton7)
                                    .addComponent(jLabel22)))
                            .addComponent(btnsearchsp, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Gửi xe", new javax.swing.ImageIcon(getClass().getResource("/hinh/pkgo.png")), jPanel8); // NOI18N

        jPanel9.setBackground(new java.awt.Color(204, 204, 255));

        tbloaixe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Tên loại xe", "Đơn giá"
            }
        ));
        tbloaixe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbloaixeMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbloaixe);

        jLabel29.setText("ID:");

        jLabel30.setText("Tên loại xe:");

        idlx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idlxActionPerformed(evt);
            }
        });

        btnaddlsp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnaddlsp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/add.png"))); // NOI18N
        btnaddlsp.setText("THÊM");
        btnaddlsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddlspActionPerformed(evt);
            }
        });

        btndeletesp1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btndeletesp1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/remove.png"))); // NOI18N
        btndeletesp1.setText("XÓA");
        btndeletesp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeletesp1ActionPerformed(evt);
            }
        });

        btnrepairsp1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnrepairsp1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/repair.png"))); // NOI18N
        btnrepairsp1.setText("SỬA");
        btnrepairsp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrepairsp1ActionPerformed(evt);
            }
        });

        btnresetsp1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnresetsp1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/reset.png"))); // NOI18N
        btnresetsp1.setText("RESET");
        btnresetsp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetsp1ActionPerformed(evt);
            }
        });

        jLabel31.setText("Nhập loại xe bạn muốm tìm kiếm:");

        btnsearchsp1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnsearchsp1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/search.png"))); // NOI18N
        btnsearchsp1.setText("SEARCH");
        btnsearchsp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchsp1ActionPerformed(evt);
            }
        });

        jLabel38.setText("Đơn giá:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(271, 271, 271))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel29))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(idlx, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                    .addComponent(tlx))
                                .addGap(82, 82, 82)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(btnrepairsp1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnresetsp1))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(btnaddlsp)
                                        .addGap(75, 75, 75)
                                        .addComponent(btndeletesp1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel38)
                                .addGap(18, 18, 18)
                                .addComponent(dglx, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(lxsearch)
                                .addGap(271, 271, 271))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnsearchsp1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel29)
                                    .addComponent(idlx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel30)
                                    .addComponent(tlx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnaddlsp)
                                    .addComponent(btndeletesp1))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(dglx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnrepairsp1)
                            .addComponent(btnresetsp1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jLabel31)
                        .addGap(18, 18, 18)
                        .addComponent(lxsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnsearchsp1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Loại xe", jPanel9);

        jPanel13.setBackground(new java.awt.Color(204, 204, 255));

        tbnvxe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Họ Tên", "Số điện thoại", "Email", "Địa chỉ", "Tài hoản", "Mật khẩu", "ID_PQ"
            }
        ));
        tbnvxe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbnvxeMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tbnvxe);

        jLabel35.setText("ID:");

        jLabel36.setText("Họ và tên:");

        btnaddlsp1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnaddlsp1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/add.png"))); // NOI18N
        btnaddlsp1.setText("THÊM");
        btnaddlsp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddlsp1ActionPerformed(evt);
            }
        });

        btndeletesp2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btndeletesp2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/remove.png"))); // NOI18N
        btndeletesp2.setText("XÓA");
        btndeletesp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeletesp2ActionPerformed(evt);
            }
        });

        btnrepairsp2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnrepairsp2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/repair.png"))); // NOI18N
        btnrepairsp2.setText("SỬA");
        btnrepairsp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrepairsp2ActionPerformed(evt);
            }
        });

        btnresetsp2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnresetsp2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/reset.png"))); // NOI18N
        btnresetsp2.setText("RESET");
        btnresetsp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetsp2ActionPerformed(evt);
            }
        });

        jLabel37.setText("Nhập loại xe bạn muốm tìm kiếm:");

        btnsearchsp2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnsearchsp2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/search.png"))); // NOI18N
        btnsearchsp2.setText("SEARCH");
        btnsearchsp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchsp2ActionPerformed(evt);
            }
        });

        jLabel39.setText("Số điện thoại:");

        jLabel40.setText("Email:");

        jLabel47.setText("Địa chỉ:");

        jLabel48.setText("Tài khoản:");

        jLabel49.setText("Mật khẩu:");

        jLabel50.setText("Phân quyền:");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel39)
                                .addGap(18, 18, 18)
                                .addComponent(sdtnv, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel36)
                                    .addComponent(jLabel35))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(htnv, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                    .addComponent(idnv)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel40)
                                    .addComponent(jLabel47))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(emailnv)
                                    .addComponent(diachinv, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel48)
                                    .addComponent(jLabel49))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tknv, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(mknv)
                            .addComponent(pqnv))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnrepairsp2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnaddlsp1))
                                .addGap(74, 74, 74)
                                .addComponent(btnresetsp2))
                            .addComponent(btndeletesp2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nvsearch)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnsearchsp2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel35)
                                    .addComponent(idnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel48)
                                    .addComponent(tknv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel36)
                                    .addComponent(htnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btndeletesp2)
                                    .addComponent(btnaddlsp1)
                                    .addComponent(mknv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel49))
                                .addGap(2, 2, 2)))
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(sdtnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel50)
                            .addComponent(pqnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnrepairsp2)
                                    .addComponent(btnresetsp2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel40)
                                    .addComponent(emailnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel47)
                                    .addComponent(diachinv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jLabel37)
                        .addGap(18, 18, 18)
                        .addComponent(nvsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnsearchsp2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1150, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 451, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Nhân viên", jPanel10);

        jPanel16.setBackground(new java.awt.Color(204, 204, 255));

        tbbaixe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Tên bãi", "Số lượng"
            }
        ));
        tbbaixe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbbaixeMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tbbaixe);

        jLabel44.setText("ID:");

        jLabel45.setText("Tễn bãi:");

        btnaddlsp4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnaddlsp4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/add.png"))); // NOI18N
        btnaddlsp4.setText("THÊM");
        btnaddlsp4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddlsp4ActionPerformed(evt);
            }
        });

        btndeletesp5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btndeletesp5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/remove.png"))); // NOI18N
        btndeletesp5.setText("XÓA");
        btndeletesp5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeletesp5ActionPerformed(evt);
            }
        });

        btnrepairsp5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnrepairsp5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/repair.png"))); // NOI18N
        btnrepairsp5.setText("SỬA");
        btnrepairsp5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrepairsp5ActionPerformed(evt);
            }
        });

        btnresetsp5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnresetsp5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/reset.png"))); // NOI18N
        btnresetsp5.setText("RESET");
        btnresetsp5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetsp5ActionPerformed(evt);
            }
        });

        jLabel46.setText("Nhập loại xe bạn muốm tìm kiếm:");

        btnsearchsp5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnsearchsp5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/search.png"))); // NOI18N
        btnsearchsp5.setText("SEARCH");
        btnsearchsp5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchsp5ActionPerformed(evt);
            }
        });

        jLabel51.setText("Số lượng:");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(271, 271, 271))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel45)
                                    .addComponent(jLabel44))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(idbx, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                    .addComponent(tbx)))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel51)
                                .addGap(18, 18, 18)
                                .addComponent(slbx)))
                        .addGap(80, 80, 80)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(btnrepairsp5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnresetsp5))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(btnaddlsp4)
                                .addGap(75, 75, 75)
                                .addComponent(btndeletesp5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(bxsearch)
                                .addGap(271, 271, 271))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnsearchsp5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel44)
                                    .addComponent(idbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel45)
                                    .addComponent(tbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnaddlsp4)
                                    .addComponent(btndeletesp5))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel51)
                            .addComponent(slbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnrepairsp5)
                            .addComponent(btnresetsp5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jLabel46)
                        .addGap(18, 18, 18)
                        .addComponent(bxsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnsearchsp5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1150, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 451, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Bãi xe", jPanel12);

        jPanel4.add(jTabbedPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 520));

        jTabbedPane2.addTab("Gửi xe", new javax.swing.ImageIcon(getClass().getResource("/hinh/stock.png")), jPanel4); // NOI18N

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));

        tblayxe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã lấy xe", "Thời gian vào", "Thời gian ra", "Biển số xe", "Thẻ xe", "Nhân viên", "Bãi xe", "Tiền thuê"
            }
        ));
        tblayxe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblayxeMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblayxe);

        b.setColumns(20);
        b.setRows(5);
        jScrollPane1.setViewportView(b);

        jButton3.setText("TẤT CÃ HÓA ĐƠN");

        jButton4.setText("HÓA ĐƠN CỦA BẠN");

        lblMaHoaDon_HoaDon.setText("Mã Hóa Đơn:");

        jLabel16.setText("Thẻ xe:");

        cbbtenkh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel17.setText("Tiền thuê:");

        cbbsp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbspMouseClicked(evt);
            }
        });
        cbbsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbspActionPerformed(evt);
            }
        });

        jLabel19.setText("Bãi xe:");

        jLabel21.setText("Nhân viên:");

        txtsolghd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtsolghdFocusLost(evt);
            }
        });

        jLabel24.setText("Biểm số xe:");

        txttongtienhd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttongtienhdActionPerformed(evt);
            }
        });

        jLabel25.setText("Thời gian vào:");

        datengayvaolx.setDateFormatString("yyyy-MM-dd");

        jLabel26.setText("Thời gian ra:");

        datengayragx.setDateFormatString("yyyy-MM-dd");

        jButton1.setText("Thêm hóa đơn của bạn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("In Hóa Đơn");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel27.setText("Tiền thừa:");

        jLabel28.setText("Tiền khách đưa:");

        jButton6.setText("Thanh Toán");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        cbbsp1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbsp1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbsp1MouseClicked(evt);
            }
        });
        cbbsp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbsp1ActionPerformed(evt);
            }
        });

        txtsolghd1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtsolghd1FocusLost(evt);
            }
        });

        tblayxe1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã lấy xe", "Thời gian vào", "Thời gian ra", "Biển số xe", "Thẻ xe", "Nhân viên", "Bãi xe", "Tiền thuê"
            }
        ));
        jScrollPane7.setViewportView(tblayxe1);

        jButton5.setText("Xóa");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(datengayvaolx, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                    .addComponent(lblMaHoaDon_HoaDon)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtmahd, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel26)
                                        .addComponent(jLabel24)
                                        .addComponent(jLabel16))
                                    .addGap(21, 21, 21)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txttongtienhd, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbbtenkh, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(datengayragx, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(75, 75, 75)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel27)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel21)
                                    .addGap(35, 35, 35)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel28))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txthienthua, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbsp, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbsp1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsolghd, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsolghd1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(371, 371, 371)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(71, 71, 71))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jButton4)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblMaHoaDon_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtmahd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel21)
                                            .addComponent(cbbsp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(datengayvaolx, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cbbsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(12, 12, 12))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(datengayragx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel17)
                                        .addComponent(txtsolghd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel24)
                                    .addComponent(txttongtienhd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel28)
                                    .addComponent(txthienthua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel27)
                                    .addComponent(txtsolghd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbtenkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(87, 87, 87))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))))
        );

        jTabbedPane2.addTab("HÓA ĐƠN", new javax.swing.ImageIcon(getClass().getResource("/hinh/shopping.png")), jPanel6); // NOI18N

        jPanel7.setBackground(new java.awt.Color(204, 204, 255));
        jPanel7.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel7ComponentShown(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/hinhsp.png"))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Đăng xuất ", new javax.swing.ImageIcon(getClass().getResource("/hinh/log-out.png")), jPanel7); // NOI18N

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel3ComponentShown(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/hinhsp.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Thoát", new javax.swing.ImageIcon(getClass().getResource("/hinh/exit.png")), jPanel3); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1397, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane2ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTabbedPane2ComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane2ComponentResized


    private void jPanel7ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel7ComponentShown
        // TODO add your handling code here:
 
    }//GEN-LAST:event_jPanel7ComponentShown

    private void jPanel3ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel3ComponentShown
        // TODO add your handling code here:

    }//GEN-LAST:event_jPanel3ComponentShown

    private void tblayxeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblayxeMouseClicked
         int i = tblayxe.getSelectedRow();
         
        txtmahd.setText(tblayxe.getValueAt(i, 0).toString());
        
        String dateString1 = tblayxe.getValueAt(i, 1).toString();
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = null;
        try {
            date1 = dateFormat1.parse(dateString1);
        } catch (ParseException ex) {}
        datengayvaolx.setDate(date1);
        
        
        String dateString2 = tblayxe.getValueAt(i, 2).toString();
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date1 = dateFormat2.parse(dateString2);
        } catch (ParseException ex) {}
        datengayragx.setDate(date1);
        
        txttongtienhd.setText(tblayxe.getValueAt(i, 3).toString());
        
        cbbModel4.setSelectedItem(tblayxe.getValueAt(i, 4).toString().trim());
        cbbtenkh.setModel(cbbModel4);
        
        cbbModel6.setSelectedItem(tblayxe.getValueAt(i, 5).toString().trim());
        cbbsp1.setModel(cbbModel6);
        
        cbbModel5.setSelectedItem(tblayxe.getValueAt(i, 6).toString().trim());
        cbbsp.setModel(cbbModel5);
        
        txtsolghd1.setText(tblayxe.getValueAt(i, 7).toString());
    }//GEN-LAST:event_tblayxeMouseClicked

    
    private void txttongtienhdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttongtienhdActionPerformed
     
    }//GEN-LAST:event_txttongtienhdActionPerformed

    private void cbbspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbspMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_cbbspMouseClicked

   

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

    AddLayXe();
    TableLayXe();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbbspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbspActionPerformed
      

    }//GEN-LAST:event_cbbspActionPerformed

    

    
     // print bill
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          try {
            
           b.setText("                         CONG TY KCQ \n");
            b.setText(b.getText() + "                         688/2/40, \n");
            b.setText(b.getText() + "                         HL2, HO CHI MINH CITY, \n");
            b.setText(b.getText() + "                         +84 123456789, \n");
            b.setText(b.getText() + "---------------------------------------------------------------------\n");
            b.setText(b.getText() + "  Xe \t\tBãi xe \tTiền thuê" +"\n");
            b.setText(b.getText() + "---------------------------------------------------------------------\n");
            
            DefaultTableModel df = (DefaultTableModel) tblayxe.getModel();
            
            // get table Product details
            
            for (int i = 0; i < tblayxe.getRowCount(); i++) {
                
                String Name = cbbsp.getSelectedItem().toString();
                String Qty = df.getValueAt(i, 4).toString();
                String Price = df.getValueAt(i, 3).toString();
                
                b.setText(b.getText() +"  "+ Name+"\t\t"+Qty +"\t"+Price + "\n");
            }
            
            b.setText(b.getText() + "---------------------------------------------------------------------\n");
            b.setText(b.getText() + "Tổng hóa đơn     : " + txtsolghd1.getText() +"\n");
            b.setText(b.getText() + "Tiền khách đưa   : " + txthienthua.getText() +"\n");
            b.setText(b.getText() + "Tiền thói        : " + txtsolghd.getText() +"\n");
            b.setText(b.getText() + "---------------------------------------------------------------------\n");
            b.setText(b.getText() + "                     Thanks For Your Business...!"+"\n");
            b.setText(b.getText() + "---------------------------------------------------------------------\n");
           
            
           
        b.print(); //print
            
            
        } catch (Exception e) {
            
            System.out.println(e);
            
            
        }
        
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        double tot = Double.valueOf(txtsolghd1.getText());
        double paid = Double.valueOf(txthienthua.getText());
        double balance = paid - tot ;
                
        DecimalFormat df = new DecimalFormat("00.00") ;   
       
       
        txtsolghd.setText(String.valueOf(df.format(balance)));
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnsearchsp5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchsp5ActionPerformed
        // TODO add your handling code here:\
        if (bxsearch.getText().isEmpty()) {
            TableBX();
        } else {
            FindBX();
        }
    }//GEN-LAST:event_btnsearchsp5ActionPerformed

    private void btnresetsp5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetsp5ActionPerformed
        // TODO add your handling code here:
          idbx.setText("");
        tbx.setText("");
        slbx.setText("");
    }//GEN-LAST:event_btnresetsp5ActionPerformed

    private void btnrepairsp5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrepairsp5ActionPerformed
        // TODO add your handling code here:
        UpdateBX();
    }//GEN-LAST:event_btnrepairsp5ActionPerformed

    private void btndeletesp5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeletesp5ActionPerformed
        // TODO add your handling code here:
        DeleteBX();
    }//GEN-LAST:event_btndeletesp5ActionPerformed

    private void btnaddlsp4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddlsp4ActionPerformed
        // TODO add your handling code here:
        AddBX();
    }//GEN-LAST:event_btnaddlsp4ActionPerformed

    private void tbbaixeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbbaixeMouseClicked
        // TODO add your handling code here:
         int i = tbbaixe.getSelectedRow();
 
        idbx.setText(tbbaixe.getValueAt(i, 0).toString().trim());
        tbx.setText(tbbaixe.getValueAt(i, 1).toString().trim());
        slbx.setText(tbbaixe.getValueAt(i, 2).toString().trim());
  
    }//GEN-LAST:event_tbbaixeMouseClicked

    private void btnsearchsp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchsp2ActionPerformed
        // TODO add your handling code here:
        if (nvsearch.getText().isEmpty()) {
            TableNV();
        } else {
            FindNV();
        }
    }//GEN-LAST:event_btnsearchsp2ActionPerformed

    private void btnresetsp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetsp2ActionPerformed
        // TODO add your handling code here:
        idnv.setText("");
        htnv.setText("");
        sdtnv.setText("");
        emailnv.setText("");
        diachinv.setText("");
        tknv.setText("");
        mknv.setText("");
        pqnv.setText("");
        
    }//GEN-LAST:event_btnresetsp2ActionPerformed

    private void btnrepairsp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrepairsp2ActionPerformed
        // TODO add your handling code here:
        UpdateNV();
    }//GEN-LAST:event_btnrepairsp2ActionPerformed

    private void btndeletesp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeletesp2ActionPerformed
        // TODO add your handling code here:
        DeleteNV();
    }//GEN-LAST:event_btndeletesp2ActionPerformed

    private void btnaddlsp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddlsp1ActionPerformed
        // TODO add your handling code here:
        AddNV();
    }//GEN-LAST:event_btnaddlsp1ActionPerformed

    private void tbnvxeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbnvxeMouseClicked
        // TODO add your handling code here:
        int i = tbnvxe.getSelectedRow();
 
        idnv.setText(tbnvxe.getValueAt(i, 0).toString().trim());
        htnv.setText(tbnvxe.getValueAt(i, 1).toString().trim());
        sdtnv.setText(tbnvxe.getValueAt(i, 2).toString().trim());
        emailnv.setText(tbnvxe.getValueAt(i, 3).toString().trim());
        diachinv.setText(tbnvxe.getValueAt(i, 4).toString().trim());
        tknv.setText(tbnvxe.getValueAt(i, 5).toString().trim());
        mknv.setText(tbnvxe.getValueAt(i, 6).toString().trim());
        pqnv.setText(tbnvxe.getValueAt(i, 7).toString().trim());

    }//GEN-LAST:event_tbnvxeMouseClicked

    private void btnsearchsp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchsp1ActionPerformed
        
        if (lxsearch.getText().isEmpty()) {
            TableLX();
        } else {
            FindLX();
        }
    }//GEN-LAST:event_btnsearchsp1ActionPerformed

    private void btnresetsp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetsp1ActionPerformed
        // TODO add your handling code here:
        idlx.setText("");
        tlx.setText("");
        dglx.setText("");
    }//GEN-LAST:event_btnresetsp1ActionPerformed

    private void btnrepairsp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrepairsp1ActionPerformed
        // TODO add your handling code here:
        UpdateLX();
    }//GEN-LAST:event_btnrepairsp1ActionPerformed

    private void btndeletesp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeletesp1ActionPerformed
        DeleteLX();
        // TODO add your handling code here:
    }//GEN-LAST:event_btndeletesp1ActionPerformed

    private void btnaddlspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddlspActionPerformed
        // TODO add your handling code here:
        AddLX();
    }//GEN-LAST:event_btnaddlspActionPerformed

    private void tbloaixeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbloaixeMouseClicked

           int i = tbloaixe.getSelectedRow();
 
        idlx.setText(tbloaixe.getValueAt(i, 0).toString().trim());
        tlx.setText(tbloaixe.getValueAt(i, 1).toString().trim());
        dglx.setText(tbloaixe.getValueAt(i, 2).toString().trim());
    }//GEN-LAST:event_tbloaixeMouseClicked

    private void cbxbaixegxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxbaixegxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxbaixegxActionPerformed

    private void cbxnhanviengxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxnhanviengxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxnhanviengxActionPerformed

    private void cbxloaixegxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxloaixegxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxloaixegxActionPerformed

    private void tbguixeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbguixeMouseClicked
        int i = tbguixe.getSelectedRow();
        txtmagx.setText(tbguixe.getValueAt(i, 0).toString());
        txtbsx.setText(tbguixe.getValueAt(i, 1).toString());
        
        String dateString1 = tbguixe.getValueAt(i, 2).toString();
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = null;
        try {
            date1 = dateFormat1.parse(dateString1);
        } catch (ParseException ex) {}
        datetgvao.setDate(date1);
        
        txtghichugx.setText(tbguixe.getValueAt(i, 3).toString());
        
        cbbModel.setSelectedItem(tbguixe.getValueAt(i, 4).toString().trim());
        cbxloaixegx.setModel(cbbModel);
        
        cbbModel1.setSelectedItem(tbguixe.getValueAt(i, 5).toString().trim());
        cbxnhanviengx.setModel(cbbModel1);
        
        cbbModel3.setSelectedItem(tbguixe.getValueAt(i, 6).toString().trim());
        cbxbaixegx.setModel(cbbModel3);
    }//GEN-LAST:event_tbguixeMouseClicked

    private void btnsearchspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchspActionPerformed
                    // TODO add your handling code here:
    if (txtspsearch.getText().isEmpty()) {
            TableLX();
        } else {
            FindGX();
        }
    }//GEN-LAST:event_btnsearchspActionPerformed

    private void btnresetspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetspActionPerformed
        // TODO add your handling code here:
        txtmagx.setText("");
        txtbsx.setText("");
        txtghichugx.setText("");
    }//GEN-LAST:event_btnresetspActionPerformed

    private void btnrepairspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrepairspActionPerformed
        UpdateGX();
    }//GEN-LAST:event_btnrepairspActionPerformed

    private void btndeletespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeletespActionPerformed
        DeleteGX();
    }//GEN-LAST:event_btndeletespActionPerformed

    private void btnaddspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddspActionPerformed
        AddGX();
    }//GEN-LAST:event_btnaddspActionPerformed

    private void idlxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idlxActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_idlxActionPerformed

    private void txtsolghdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtsolghdFocusLost

    }//GEN-LAST:event_txtsolghdFocusLost

    private void cbbsp1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbsp1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbsp1MouseClicked

    private void cbbsp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbsp1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbsp1ActionPerformed

    private void txtsolghd1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtsolghd1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsolghd1FocusLost

    
    
 
    
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangChu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea b;
    private javax.swing.JButton btnaddlsp;
    private javax.swing.JButton btnaddlsp1;
    private javax.swing.JButton btnaddlsp4;
    private javax.swing.JButton btnaddsp;
    private javax.swing.JButton btndeletesp;
    private javax.swing.JButton btndeletesp1;
    private javax.swing.JButton btndeletesp2;
    private javax.swing.JButton btndeletesp5;
    private javax.swing.JButton btnrepairsp;
    private javax.swing.JButton btnrepairsp1;
    private javax.swing.JButton btnrepairsp2;
    private javax.swing.JButton btnrepairsp5;
    private javax.swing.JButton btnresetsp;
    private javax.swing.JButton btnresetsp1;
    private javax.swing.JButton btnresetsp2;
    private javax.swing.JButton btnresetsp5;
    private javax.swing.JButton btnsearchsp;
    private javax.swing.JButton btnsearchsp1;
    private javax.swing.JButton btnsearchsp2;
    private javax.swing.JButton btnsearchsp5;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField bxsearch;
    private javax.swing.JComboBox<String> cbbsp;
    private javax.swing.JComboBox<String> cbbsp1;
    private javax.swing.JComboBox<String> cbbtenkh;
    private javax.swing.JComboBox<String> cbxbaixegx;
    private javax.swing.JComboBox<String> cbxloaixegx;
    private javax.swing.JComboBox<String> cbxnhanviengx;
    private com.toedter.calendar.JDateChooser datengayragx;
    private com.toedter.calendar.JDateChooser datengayvaolx;
    private com.toedter.calendar.JDateChooser datetgvao;
    private javax.swing.JTextField dglx;
    private javax.swing.JTextField diachinv;
    private javax.swing.JTextField emailnv;
    private javax.swing.JTextField htnv;
    private javax.swing.JTextField idbx;
    private javax.swing.JTextField idlx;
    private javax.swing.JTextField idnv;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblMaHoaDon_HoaDon;
    private javax.swing.JTextField lxsearch;
    private javax.swing.JTextField mknv;
    private javax.swing.JTextField nvsearch;
    private javax.swing.JTextField pqnv;
    private javax.swing.JTextField sdtnv;
    private javax.swing.JTextField slbx;
    private javax.swing.JTable tbbaixe;
    private javax.swing.JTable tbguixe;
    private javax.swing.JTable tblayxe;
    private javax.swing.JTable tblayxe1;
    private javax.swing.JTable tbloaixe;
    private javax.swing.JTable tbnvxe;
    private javax.swing.JTextField tbx;
    private javax.swing.JTextField tknv;
    private javax.swing.JTextField tlx;
    private javax.swing.JTextField txtbsx;
    private javax.swing.JTextField txtghichugx;
    private javax.swing.JTextField txthienthua;
    private javax.swing.JTextField txtmagx;
    private javax.swing.JTextField txtmahd;
    private javax.swing.JTextField txtsolghd;
    private javax.swing.JTextField txtsolghd1;
    private javax.swing.JTextField txtspsearch;
    private javax.swing.JTextField txttongtienhd;
    // End of variables declaration//GEN-END:variables

}
