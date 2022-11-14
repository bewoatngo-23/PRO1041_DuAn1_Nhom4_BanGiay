/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import customModel.DeGiayCustomModel;
import domainModel.DeGiay;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import repository.IDeGiayRes;
import utilities.DBContext;
import utilities.HibernateUtil;

/**
 *
 * @author admin
 */
public class DeGiayRepository implements IDeGiayRes {

    private static final Session session = HibernateUtil.getFACTORY().openSession();

    @Override
    public List<DeGiayCustomModel> getAll() {
        List<DeGiayCustomModel> list_deGiay = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select id,ma,ten from degiay");
            while (rs.next()) {
                list_deGiay.add(new DeGiayCustomModel(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            conn.close();
            st.close();
            rs.close();
            
        } catch (Exception e) {
            System.out.println("Lỗi kết nối tại getAll");
        }
        return list_deGiay;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(DeGiay obj) {
        try (Session se = HibernateUtil.getFACTORY().openSession()){           
            Transaction tran = se.getTransaction();
            tran.begin();
            try {
                se.save(obj);
                tran.commit();
                return true;
            } catch (Exception e) {
                e.printStackTrace(System.out);
                tran.rollback();
            }
        } 
        return false;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(DeGiay obj) {
        int check = 0;
        try {           
            Session session = HibernateUtil.getFACTORY().openSession();
            Transaction tran = session.getTransaction();
            tran.begin();
            try {
                Query query = session.createQuery("update DeGiay set Ma = :ma , Ten = :ten where Id = :id ");
                query.setParameter("ma", obj.getMa());
                query.setParameter("ten", obj.getTen());
                query.setParameter("id", obj.getId());
                check = query.executeUpdate();
                tran.commit();
                        
            } catch (Exception e) {
                e.printStackTrace(System.out);
                tran.rollback();
            }
        } finally {
            return check > 0;
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(DeGiay obj) {
        int check = 0;
        try {
            Session session = HibernateUtil.getFACTORY().openSession();
            Transaction tran = session.getTransaction();
            tran.begin();
            try {
                Query query = session.createQuery("delete from DeGiay where Id = :id");
                query.setParameter("id", obj.getId());
                check = query.executeUpdate();
                tran.commit();
                
            } catch (Exception e) {               
                e.printStackTrace(System.out);
                tran.rollback();
            }
        } finally {
            return check > 0;
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

}
