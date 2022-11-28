/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import customModel.NhanVienCustomModel;
import domainModel.NhanVien;
import java.util.ArrayList;
import java.util.List;
import repository.INhanVienRes;
import repository.impl.NhanVienRepository;
import service.INhanVienService;

/**
 *
 * @author ADMIN
 */
public class NhanVienServiceImpl implements INhanVienService {

    private NhanVienRepository NhanVienRes = new NhanVienRepository();

    @Override
    public List<NhanVien> getAll() {
        return NhanVienRes.getAll();
    }

    @Override
    public NhanVien getOne(String ma) {
        NhanVien nv = NhanVienRes.getOne(ma);
        return nv;
    }

    @Override
    public String add(NhanVien t) {
        if (NhanVienRes.add(t)) {
            return "Add thành công";
        }
        return "Add thất bại";
    }

    @Override
    public String update(NhanVien t, String id) {
        if (NhanVienRes.update(t, id)) {
            return "Update thành công";
        }
        return "Update thất bại";
    }

    @Override
    public String delete(String id) {
        if (NhanVienRes.delete(id)) {
            return "Delete thành công";
        }
        return "Delete thất bại";
    }

    @Override
    public List<NhanVienCustomModel> getAllCustom() {
        return NhanVienRes.getAllCustomModel();
    }

    @Override
    public List<NhanVienCustomModel> Search(String ten) {
        return NhanVienRes.search(ten);
    }

    @Override
    public List<NhanVienCustomModel> SearchNV(String input) {
        List<NhanVienCustomModel> listNV = new ArrayList<>();
        if (input == null) {
            return NhanVienRes.getAllCustomModel();
        }
        for (NhanVienCustomModel x : NhanVienRes.getAllCustomModel()) {
            if (x.getTenCV().contains(input) || x.getMa().contains(input) || x.getHoTen().contains(input) || x.getSdt().contains(input) || x.getTaiKhoan().contains(input)
                    || x.getMatKhau().contains(input) || x.getEmail().contains(input) || x.getGioiTinh().contains(input) || x.getNgaySinh().equals(input)
                    || x.getDiaChi().contains(input)) {
                listNV.add(x);
            }
        }
        return listNV;
    }

    @Override
    public List<NhanVienCustomModel> getAllCustomByMaNV() {
        return NhanVienRes.getAllCustomByMaNV();
    }

}
