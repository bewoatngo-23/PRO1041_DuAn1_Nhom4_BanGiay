/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import customModel.HDCTCustoModelHD;
import customModel.HoaDonCustomModelHD;
import java.util.ArrayList;
import java.util.List;
import repository.impl.HoaDonBanHangRepository;
import repository.impl.HoaDonBanHangRepositoryThongKe;
import service.IHoaDonHDService;
import service.IHoaDonHDServiceThongKe;

/**
 *
 * @author ADMIN
 */
public class HoaDonHDServiceImplThongKe implements IHoaDonHDServiceThongKe {

    private HoaDonBanHangRepositoryThongKe hdbhr = new HoaDonBanHangRepositoryThongKe();

    @Override
    public List<HDCTCustoModelHD> getHDCT(String id) {
        return hdbhr.getHDCT(id);
    }

    @Override
    public List<HoaDonCustomModelHD> getHoaDon() {
        return hdbhr.getHoaDon();
    }

    @Override
    public List<HoaDonCustomModelHD> SearchHD(String input) {
        List<HoaDonCustomModelHD> listHD = new ArrayList<>();
        if (input == null) {
            return hdbhr.getHoaDon();
        }
        for (HoaDonCustomModelHD x : hdbhr.getHoaDon()) {
            if (x.getMaHD().contains(input) || x.getMaNV().contains(input) || x.getTenNV().contains(input) || x.getMaKH().contains(input)
                    || x.getTenKH().contains(input) || String.valueOf(x.getTongTien()).contains(input) || String.valueOf(x.getTongSP()).contains(input) || String.valueOf(x.getTrangThai()).contains(input)) {
                listHD.add(x);
            }
        }
        return listHD;
    }

    @Override
    public List<HoaDonCustomModelHD> SearchCBB(String input) {
        List<HoaDonCustomModelHD> listHD = new ArrayList<>();
        if (input == null) {
            return hdbhr.getHoaDon();
        }
        for (HoaDonCustomModelHD x : hdbhr.getHoaDon()) {
            if (String.valueOf(x.getTrangThai()).contains(input)) {
                listHD.add(x);
            }
        }
        return listHD;
    }

    @Override
    public List<HDCTCustoModelHD> getAllHDCT() {
        return hdbhr.getALLHDCT();
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<HoaDonCustomModelHD> getHoaDonBetWeen(String batDau, String ketThuc) {
        return hdbhr.getHoaDonBetWeen(batDau, ketThuc);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
