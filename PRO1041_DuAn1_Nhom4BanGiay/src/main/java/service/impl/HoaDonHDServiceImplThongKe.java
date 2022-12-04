/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import customModel.HDCTCustoModelHD;
import customModel.HDCTCustoModelHDThongKe;
import customModel.HoaDonCustomModelHD;
import customModel.HoaDonCustomModelHDThongKe;
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
    public List<HDCTCustoModelHDThongKe> getHDCT(String id) {
        return hdbhr.getHDCT(id);
    }

    @Override
    public List<HoaDonCustomModelHDThongKe> getHoaDon() {
        return hdbhr.getHoaDon();
    }

    @Override
    public List<HoaDonCustomModelHDThongKe> SearchHD(String input) {
        List<HoaDonCustomModelHDThongKe> listHD = new ArrayList<>();
        if (input == null) {
            return hdbhr.getHoaDon();
        }
        for (HoaDonCustomModelHDThongKe x : hdbhr.getHoaDon()) {
            if (x.getMaHD().contains(input) || x.getMaNV().contains(input) || x.getTenNV().contains(input) || x.getMaKH().contains(input)
                    || x.getTenKH().contains(input) || String.valueOf(x.getTongTien()).contains(input) || String.valueOf(x.getTongSP()).contains(input) || String.valueOf(x.getTrangThai()).contains(input)) {
                listHD.add(x);
            }
        }
        return listHD;
    }

    @Override
    public List<HoaDonCustomModelHDThongKe> SearchCBB(String input) {
        List<HoaDonCustomModelHDThongKe> listHD = new ArrayList<>();
        if (input == null) {
            return hdbhr.getHoaDon();
        }
        for (HoaDonCustomModelHDThongKe x : hdbhr.getHoaDon()) {
            if (String.valueOf(x.getTrangThai()).contains(input)) {
                listHD.add(x);
            }
        }
        return listHD;
    }

    @Override
    public List<HDCTCustoModelHDThongKe> getAllHDCT() {
        return hdbhr.getALLHDCT();
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<HoaDonCustomModelHDThongKe> getHoaDonBetWeen(String batDau, String ketThuc) {
        return hdbhr.getHoaDonBetWeen(batDau, ketThuc);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
