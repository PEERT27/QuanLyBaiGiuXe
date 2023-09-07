/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HAM;

/**
 *
 * @author Admin
 */
public class BAIXE {

    public BAIXE() {
    }

    public BAIXE(String ID, String TENBAI, int SOLUONG) {
        this.ID = ID;
        this.TENBAI = TENBAI;
        this.SOLUONG = SOLUONG;
    }

    public String getID() {
        return ID;
    }

    public String getTENBAI() {
        return TENBAI;
    }

    public int getSOLUONG() {
        return SOLUONG;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setTENBAI(String TENBAI) {
        this.TENBAI = TENBAI;
    }

    public void setSOLUONG(int SOLUONG) {
        this.SOLUONG = SOLUONG;
    }
    private String ID, TENBAI;
    private int SOLUONG;
}
