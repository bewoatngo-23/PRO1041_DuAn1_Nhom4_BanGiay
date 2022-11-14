/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import customModel.DeGiayCustomModel;
import domainModel.DeGiay;
import java.util.List;

/**
 *
 * @author admin
 * 
 */
public interface IDeGiayRes {
    List<DeGiayCustomModel> getAll();
    
    boolean add(DeGiay obj);
    
    boolean update(DeGiay obj);
    
    boolean delete(DeGiay obj);
            
}
