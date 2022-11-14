/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import customModel.DeGiayCustomModel;
import domainModel.DeGiay;
import java.util.ArrayList;
import java.util.List;
import repository.IDeGiayRes;
import repository.impl.DeGiayRepository;
import service.IDeGiayService;

/**
 *
 * @author admin
 */
public class DeGiayServiecImpl implements IDeGiayService{
    private IDeGiayRes DeGiayRepository = new DeGiayRepository();

    @Override
    public List<DeGiayCustomModel> getAll(String input) {
        List<DeGiayCustomModel> list_deGiay = new ArrayList<>();
        if (input == null) {
            return DeGiayRepository.getAll();
        }
        for (DeGiayCustomModel x : DeGiayRepository.getAll()) {
            if (x.getMa().contains(input) || x.getTen().contains(input)) {
                list_deGiay.add(x);
            }
        }
        return list_deGiay;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
   
    
    @Override
    public String getIdbyIndex(int input) {
        return DeGiayRepository.getAll().get(input).getId();
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String add(DeGiay obj) {
        if (DeGiayRepository.add(obj)) {
            return "Thêm thành công";
        }
        return "Thêm thất bại";
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public String update(DeGiay obj ){
        if (DeGiayRepository.update(obj)) {
            return "Sửa thành công";
        }
        return "Sửa thất bại";
    }
    
    @Override
    public String delete(DeGiay obj ){
        if (DeGiayRepository.delete(obj)) {
            return "Xóa thành công";
        }
        return "Xóa thất bại";
    }

    

    
    
    
}
