/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import customModel.SanPhamCustomModel;
import domainModel.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import repository.IInterface;
import utilities.DBContext;

public class SanPhamRepository implements IInterface<SanPham> {

    @Override
    public List<SanPham> getAll() {
        String query = "Select * from SanPham";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<SanPham> listMS = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listMS.add(new SanPham(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            return listMS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<SanPhamCustomModel> getAllCustom() {
        String query = "Select * from SanPham";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<SanPhamCustomModel> listMS = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listMS.add(new SanPhamCustomModel(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            return listMS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public SanPham getOne(String ma) {
        String query = "Select * from SanPham Where Ma = ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            List<SanPham> listMS = new ArrayList<>();
            while (rs.next()) {
                listMS.add(new SanPham(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            return (SanPham) listMS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String add(SanPham ms) {
        String query = "INSERT INTO [dbo].[SanPham]\n"
                + "           (\n"
                + "            [Ma]\n"
                + "           ,[Ten]\n"
                + "           )\n"
                + "     VALUES\n"
                + "           (?,?)";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {

            ps.setObject(1, ms.getMa());
            ps.setObject(2, ms.getTen());

            if (ps.executeUpdate() > 0) {
                return "Th??m th??nh c??ng";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Th??m th???t b???i";
    }

    @Override
    public String update(SanPham ms, String ma) {
        String query = "UPDATE [dbo].[SanPham]\n"
                + "   SET \n"
                + "      [Ten] = ?\n"
                + "      \n"
                + " WHERE Ma = ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(2, ma);
            ps.setObject(1, ms.getTen());

            if (ps.executeUpdate() > 0) {
                return "s???a th??nh c??ng";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "S???a th???t b???i";
    }

    @Override
    public String delete(String ma) {
        String query = "Delete from SanPham where ma = ?";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);

            if (ps.executeUpdate() > 0) {
                return "X??a th??nh c??ng";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "X??a th???t b???i,s???n ph???m ???? ???????c th??m v??o s???n ph???m chi ti???t kh??ng th??? x??a";
    }

    public static void main(String[] args) {
        new SanPhamRepository().getAll().forEach((t) -> {
            System.out.println(t.toString());
        });
    }

}
