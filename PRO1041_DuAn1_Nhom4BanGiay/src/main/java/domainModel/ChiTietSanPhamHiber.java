/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModel;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "ChiTietSP")
@Getter
@Setter
@ToString
public class ChiTietSanPhamHiber {
    @Id
    @GenericGenerator(name = "Generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id")
    private String id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdSP", referencedColumnName = "Id")
    private SanPhamHiber idSP;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdDongSP", referencedColumnName = "Id")
    private DongSPHiber idDongSP;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdDeGiay", referencedColumnName = "Id")
    private DeGiayHiber idDeGiay;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdMauSac", referencedColumnName = "Id")
    private MauSacHiber idMauSac;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNhaCC", referencedColumnName = "Id")
    private NhaCungCapHiber idNhaCC;
    
    @Column(name = "NgayNhapHang")
    private String ngayNhapHang;
    
    @Column(name = "GiaNhap")
    private double giaNhap;
    
    @Column(name = "GiaBan")
    private double giaBan;
    
    @Column(name = "SoLuong")
    private int soLuong;
    
    @Column(name = "XuatXu")
    private String xuatXu;
    
    @Column(name = "KichCo")
    private String kichCo;
    
    @Column(name = "TrangThai")
    private int trangThai;

    public ChiTietSanPhamHiber() {
    }

    public ChiTietSanPhamHiber(String id, SanPhamHiber idSP, DongSPHiber idDongSP, DeGiayHiber idDeGiay, MauSacHiber idMauSac, NhaCungCapHiber idNhaCC, String ngayNhapHang, double giaNhap, double giaBan, int soLuong, String xuatXu, String kichCo, int trangThai) {
        this.id = id;
        this.idSP = idSP;
        this.idDongSP = idDongSP;
        this.idDeGiay = idDeGiay;
        this.idMauSac = idMauSac;
        this.idNhaCC = idNhaCC;
        this.ngayNhapHang = ngayNhapHang;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.xuatXu = xuatXu;
        this.kichCo = kichCo;
        this.trangThai = trangThai;
    }

    

   
    
    
}
