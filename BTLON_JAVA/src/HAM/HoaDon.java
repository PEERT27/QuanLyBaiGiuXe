package HAM;

public class HoaDon {

    public HoaDon() {
    }

    public String getId() {
        return id;
    }

    public String getBiensoxe() {
        return biensoxe;
    }

    public String getIdthexe() {
        return idthexe;
    }

    public String getIdnv() {
        return idnv;
    }

    public String getIdbaixe() {
        return idbaixe;
    }

    public String getIdnhanvien() {
        return idnhanvien;
    }

    public String getTHOIGIANVAO() {
        return THOIGIANVAO;
    }

    public String getTHOIGIANRA() {
        return THOIGIANRA;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBiensoxe(String biensoxe) {
        this.biensoxe = biensoxe;
    }

    public void setIdthexe(String idthexe) {
        this.idthexe = idthexe;
    }

    public void setIdnv(String idnv) {
        this.idnv = idnv;
    }

    public void setIdbaixe(String idbaixe) {
        this.idbaixe = idbaixe;
    }

    public void setIdnhanvien(String idnhanvien) {
        this.idnhanvien = idnhanvien;
    }

    public void setTHOIGIANVAO(String THOIGIANVAO) {
        this.THOIGIANVAO = THOIGIANVAO;
    }

    public void setTHOIGIANRA(String THOIGIANRA) {
        this.THOIGIANRA = THOIGIANRA;
    }
    String id, biensoxe, idthexe, idnv, idbaixe, idnhanvien;
    String  THOIGIANVAO, THOIGIANRA;
    int thanhtien;

    public int getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }

    public HoaDon(String id, String biensoxe, String idthexe, String idnv, String idbaixe, String idnhanvien, String THOIGIANVAO, String THOIGIANRA, int thanhtien) {
        this.id = id;
        this.biensoxe = biensoxe;
        this.idthexe = idthexe;
        this.idnv = idnv;
        this.idbaixe = idbaixe;
        this.idnhanvien = idnhanvien;
        this.THOIGIANVAO = THOIGIANVAO;
        this.THOIGIANRA = THOIGIANRA;
        this.thanhtien = thanhtien;
    }
    
 

    
    
}
