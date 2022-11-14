/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import customModel.DeGiayCustomModel;
import domainModel.DeGiay;
import java.util.List;

/**
 *
 * @author admin
 */
public interface IDeGiayService {
    List<DeGiayCustomModel> getAll(String input);
    
    String getIdbyIndex (int input);
    
    String add(DeGiay obj);
    
    String update(DeGiay obj);
    
    String delete(DeGiay obj);
}
