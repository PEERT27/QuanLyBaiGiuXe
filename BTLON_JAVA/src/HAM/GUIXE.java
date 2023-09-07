/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HAM;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class GUIXE {

    public GUIXE(String ID, String BIENSOXE, String GHICHU, String LOAIXE, String BAIXE, String NHANVIEN, String THOIGIANVAO) {
        this.ID = ID;
        this.BIENSOXE = BIENSOXE;
        this.GHICHU = GHICHU;
        this.LOAIXE = LOAIXE;
        this.BAIXE = BAIXE;
        this.NHANVIEN = NHANVIEN;
        this.THOIGIANVAO = THOIGIANVAO;
    }

    public String getNHANVIEN() {
        return NHANVIEN;
    }

    public void setNHANVIEN(String NHANVIEN) {
        this.NHANVIEN = NHANVIEN;
    }

    public GUIXE() {
    }

    

    public String getID() {
        return ID;
    }

    public String getBIENSOXE() {
        return BIENSOXE;
    }

    public String getGHICHU() {
        return GHICHU;
    }

    public String getLOAIXE() {
        return LOAIXE;
    }



    public String getBAIXE() {
        return BAIXE;
    }

    public String getTHOIGIANVAO() {
        return THOIGIANVAO;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setBIENSOXE(String BIENSOXE) {
        this.BIENSOXE = BIENSOXE;
    }

    public void setGHICHU(String GHICHU) {
        this.GHICHU = GHICHU;
    }

    public void setLOAIXE(String LOAIXE) {
        this.LOAIXE = LOAIXE;
    }

 

    public void setBAIXE(String BAIXE) {
        this.BAIXE = BAIXE;
    }

    public void setTHOIGIANVAO(String THOIGIANVAO) {
        this.THOIGIANVAO = THOIGIANVAO;
    }

   
    private String ID, BIENSOXE,GHICHU, LOAIXE, BAIXE, NHANVIEN;
    private String THOIGIANVAO; 
}
