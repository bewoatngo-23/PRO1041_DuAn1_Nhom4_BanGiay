/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModel;

/**
 *
 * @author ADMIN
 */
public class KhachHang {

    private String id;
    private String ma;
    private String hoTen;
    private String sdt;

    public KhachHang() {
    }

    public KhachHang(String id, String ma, String hoTen, String sdt) {
        this.id = id;
        this.ma = ma;
        this.hoTen = hoTen;
        this.sdt = sdt;
    }

    public KhachHang(String ma, String hoTen, String sdt) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.sdt = sdt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "id=" + id + ", ma=" + ma + ", hoTen=" + hoTen + ", sdt=" + sdt + '}';
    }

}
