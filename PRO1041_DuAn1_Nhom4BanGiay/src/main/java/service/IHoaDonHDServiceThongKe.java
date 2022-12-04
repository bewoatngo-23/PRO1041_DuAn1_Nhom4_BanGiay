/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import customModel.HDCTCustoModelHD;
import customModel.HoaDonCustomModelHD;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface IHoaDonHDServiceThongKe {

    List<HDCTCustoModelHD> getHDCT(String id);
    
    List<HDCTCustoModelHD> getAllHDCT();

    List<HoaDonCustomModelHD> getHoaDon();
    
    List<HoaDonCustomModelHD> getHoaDonBetWeen(String batDau,String ketThuc);

    List<HoaDonCustomModelHD> SearchHD(String input);

    List<HoaDonCustomModelHD> SearchCBB(String input);
}
