/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import customModel.ChucVuCustomModel;
import domainModel.ChucVu;
import java.util.ArrayList;
import java.util.List;
import repository.impl.ChucVuRepository;
import service.IChucVuService;

/**
 *
 * @author ADMIN
 */
public class ChucVuServiceImpl implements IChucVuService {

    private ChucVuRepository ChucVuRes = new ChucVuRepository();

    @Override
    public List<ChucVu> getAll() {

        return ChucVuRes.getAll();
    }

    @Override
    public ChucVu getOne(String ma) {
        return ChucVuRes.getOne(ma);

    }

    @Override
    public String add(ChucVu t) {
        if (ChucVuRes.add(t)) {
            return "Add thành công";
        } else {
            return "Add thất bại";
        }
    }

    @Override
    public String update(ChucVu t, String id) {
        if (ChucVuRes.update(t, id)) {
            return "Update thành công";
        } else {
            return "Update thất bại";
        }
    }

    @Override
    public String delete(String ma) {
        if (ChucVuRes.delete(ma)) {
            return "Delete thành công";
        } else {
            return "Delete thất bại";
        }
    }

    @Override
    public List<ChucVuCustomModel> getAllCustom() {
        return ChucVuRes.getAllCustom();

    }

    @Override
    public List<ChucVuCustomModel> Search(String ten) {
        return ChucVuRes.search(ten);
    }

}
