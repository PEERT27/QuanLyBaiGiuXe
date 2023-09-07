/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HAM;

/**
 *
 * @author Admin
 */
public class LOAIXE {

    public LOAIXE() {
    }

    public LOAIXE(String ID, String TENLOAI, float DONGIA) {
        this.ID = ID;
        this.TENLOAI = TENLOAI;
        this.DONGIA = DONGIA;
    }

    public String getID() {
        return ID;
    }

    public String getTENLOAI() {
        return TENLOAI;
    }

    public float getDONGIA() {
        return DONGIA;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setTENLOAI(String TENLOAI) {
        this.TENLOAI = TENLOAI;
    }

    public void setDONGIA(float DONGIA) {
        this.DONGIA = DONGIA;
    }
   private String ID, TENLOAI;
   private float DONGIA;
}
