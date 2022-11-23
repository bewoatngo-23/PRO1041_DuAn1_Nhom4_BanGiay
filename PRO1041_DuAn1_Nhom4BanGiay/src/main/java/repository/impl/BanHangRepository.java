/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import customModelBanHang.GioHangModel;
import customModelBanHang.HoaDonViewModel;
import customModelBanHang.SanPhamViewModel;
import domainModel.HoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utilities.DBContext;

/**
 *
 * @author ADMIN
 */
public class BanHangRepository {

    public List<SanPhamViewModel> getSanPhamVM() {
        String sql = "SELECT dbo.ChiTietSP.Id, dbo.SanPham.Ma, dbo.SanPham.Ten, dbo.DongSP.Ten AS DSP, dbo.DeGiay.Ten AS DG, dbo.MauSac.Ten AS MS, dbo.ChiTietSP.DonGia, dbo.ChiTietSP.SoLuong, dbo.ChiTietSP.XuatXu, dbo.ChiTietSP.KichCo\n"
                + "FROM     dbo.ChiTietSP INNER JOIN\n"
                + "                  dbo.DeGiay ON dbo.ChiTietSP.IdDeGiay = dbo.DeGiay.Id INNER JOIN\n"
                + "                  dbo.DongSP ON dbo.ChiTietSP.IdDongSP = dbo.DongSP.Id INNER JOIN\n"
                + "                  dbo.MauSac ON dbo.ChiTietSP.IdMauSac = dbo.MauSac.Id INNER JOIN\n"
                + "                  dbo.SanPham ON dbo.ChiTietSP.IdSP = dbo.SanPham.Id";

        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<SanPhamViewModel> listSPVM = new ArrayList<>();
            while (rs.next()) {
                listSPVM.add(new SanPhamViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getInt(8), rs.getString(9), rs.getString(10)));
            }
            return listSPVM;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public List<GioHangModel> getGioHang(String id) {
        String sql = " SELECT dbo.ChiTietSP.Id, dbo.SanPham.Ma, dbo.SanPham.Ten,dbo.HoaDonChiTiet.SoLuong, dbo.ChiTietSP.DonGia\n"
                + "                FROM     dbo.ChiTietSP INNER JOIN\n"
                + "                                dbo.HoaDonChiTiet ON dbo.ChiTietSP.Id = dbo.HoaDonChiTiet.IdChiTietSP inner join           \n"
                + "                                 dbo.SanPham ON dbo.ChiTietSP.IdSP = dbo.SanPham.Id\n"
                + "								  where IdHoaDon like ?";

        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            List<GioHangModel> listGHMD = new ArrayList<>();
            while (rs.next()) {
                listGHMD.add(new GioHangModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5)));
            }
            return listGHMD;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public List<HoaDonViewModel> getHoaDon() {
        String sql = "SELECT dbo.HoaDon.Id, dbo.HoaDon.Ma, dbo.HoaDon.NgayTao, dbo.NhanVien.HoTen, dbo.KhachHang.HoTen AS Expr1, dbo.HoaDon.TrangThai\n"
                + "FROM     dbo.HoaDon INNER JOIN\n"
                + "                  dbo.KhachHang ON dbo.HoaDon.IdKH = dbo.KhachHang.Id INNER JOIN\n"
                + "                  dbo.NhanVien ON dbo.HoaDon.IdNV = dbo.NhanVien.Id order by dbo.HoaDon.Ma asc";

        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<HoaDonViewModel> listHD = new ArrayList<>();
            while (rs.next()) {
                listHD.add(new HoaDonViewModel(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
            }
            return listHD;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public static void main(String[] args) {
        new BanHangRepository().getHoaDon().forEach((t) -> {
            System.out.println(t.toString());
        });
    }
}
