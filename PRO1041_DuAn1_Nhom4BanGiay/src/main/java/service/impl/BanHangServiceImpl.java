/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import customModelBanHang.GioHangModel;
import customModelBanHang.HoaDonViewModel;
import customModelBanHang.SanPhamViewModel;
import java.util.List;
import repository.impl.BanHangRepository;
import service.IBanHangService;

/**
 *
 * @author Admin
 */
public class BanHangServiceImpl implements IBanHangService {

    private BanHangRepository banHangRes = new BanHangRepository();

    @Override
    public List<SanPhamViewModel> getSanPhamVM() {
        return banHangRes.getSanPhamVM();
    }

    @Override
    public List<GioHangModel> getGioHang(String id) {
        return banHangRes.getGioHang(id);
    }

    @Override
    public List<HoaDonViewModel> getHoaDon() {
        return banHangRes.getHoaDon();
    }

}
