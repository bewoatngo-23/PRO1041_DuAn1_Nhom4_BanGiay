/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import customModelDoiTra.HDCTDoiTraCustomModel;
import customModelDoiTra.HoaDonDoiTraCustomModel;
import java.util.ArrayList;
import java.util.List;
import repository.impl.DoiTraReposytory;
import service.IDoiTraService;

/**
 *
 * @author ADMIN
 */
public class DoiTraServiceImpl implements IDoiTraService {

    private DoiTraReposytory dtr = new DoiTraReposytory();

    @Override
    public List<HoaDonDoiTraCustomModel> getHoaDonDoiTra() {
        return dtr.getHoaDonDoiTra();
    }

    @Override
    public List<HDCTDoiTraCustomModel> getHDCTDoiTra(String id) {
        return dtr.getHDCTDoiTra(id);
    }

    @Override
    public List<HoaDonDoiTraCustomModel> SearchHDDT(String input) {
        List<HoaDonDoiTraCustomModel> listHDDT = new ArrayList<>();
        if (input == null) {
            return dtr.getHoaDonDoiTra();
        }
        for (HoaDonDoiTraCustomModel x : dtr.getHoaDonDoiTra()) {
            if (x.getMaHD().contains(input) || x.getTenNV().contains(input) || x.getTenKH().contains(input) || String.valueOf(x.getNgayThanhToan()).contains(input) || x.getSdt().contains(input)) {
                listHDDT.add(x);
            }
        }
        return listHDDT;
    }

    @Override
    public String doiTra(HoaDonDoiTraCustomModel hd) {
        return dtr.doiTra(hd);
    }

    @Override
    public String capNhatSoLuong(HDCTDoiTraCustomModel hdct, String id) {
        return dtr.capNhatSoLuong(hdct, id);
    }

}
