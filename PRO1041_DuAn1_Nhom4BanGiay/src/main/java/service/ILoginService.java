/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainModel.Login;

/**
 *
 * @author ADMIN
 */
public interface ILoginService {

    public Login login(String user, String pass);
}
