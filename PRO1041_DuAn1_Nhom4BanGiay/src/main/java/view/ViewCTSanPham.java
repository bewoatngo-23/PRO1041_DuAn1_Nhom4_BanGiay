/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import customModel.DeGiayCustomModel;
import domainModel.ChiTietSanPhamHiber;
import domainModel.DongSPHiber;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.IDeGiayService;
import service.IDongSPService;
import service.IKhachHangService;
import service.IMauSacService;
import service.INhaCungCapService;
import service.ISanPhamService;
import service.impl.DeGiayServiecImpl;
import service.impl.DongSPServiceImpl;
import service.impl.KhachHangServiceImpl;
import service.impl.MauSacServiceImpl;
import service.impl.NhaCungCapServiceImpl;
import service.impl.SanPhamServiceImpl;
import service.IChiTietSanPhamService;
import service.IDongSPHiberService;
import service.IMauSacHiberService;
import service.INhaCungCapHiberService;
import service.ISanPhamHiberService;
import service.impl.ChiTietSanPhamServiceImpl;
import service.impl.DongSPHiberServiceImpl;
import service.impl.MauSacHiberServiecImpl;
import service.impl.NhaCungCapHiberServiceImpl;
import service.impl.SanPhamHiberServiceImpl;
import utilities.Utility;

/**
 *
 * @author admin
 */
public class ViewCTSanPham extends javax.swing.JFrame {

    private IDeGiayService deGiayService = new DeGiayServiecImpl();
    private IDongSPService dongSPService = new DongSPServiceImpl();
    private IKhachHangService khachHangService = new KhachHangServiceImpl();
    private IMauSacService mauSacService = new MauSacServiceImpl();
    private INhaCungCapService nhaCungCapService = new NhaCungCapServiceImpl();
    private ISanPhamService sanPhamService = new SanPhamServiceImpl();
    private IChiTietSanPhamService chiTietSanPhamService = new ChiTietSanPhamServiceImpl();

    private IDongSPHiberService dongSPHiberService = new DongSPHiberServiceImpl();
    private IMauSacHiberService mauSacHiberService = new MauSacHiberServiecImpl();
    private INhaCungCapHiberService nhaCungCapHiberService = new NhaCungCapHiberServiceImpl();
    private ISanPhamHiberService sanPhamHiberService = new SanPhamHiberServiceImpl();
    private utilities.Utility uti = new Utility();

    /**
     * Creates new form ViewCTSanPham
     */
    public ViewCTSanPham() {
        initComponents();
        setLocationRelativeTo(null);
        txt_ngayNhapHang.setText(java.time.LocalDate.now()+"");
        loadCBB();
        loadTable(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_CTSanPham = new javax.swing.JTable();
        lbl_sanPham = new javax.swing.JLabel();
        cbo_sanPham = new javax.swing.JComboBox<>();
        lbl_deGiay = new javax.swing.JLabel();
        cbo_deGiay = new javax.swing.JComboBox<>();
        cbo_dongSanPham = new javax.swing.JComboBox<>();
        cbo_mauSac = new javax.swing.JComboBox<>();
        cbo_nhaCungCap = new javax.swing.JComboBox<>();
        lbl_mauSac = new javax.swing.JLabel();
        lbl_nhaCC = new javax.swing.JLabel();
        lbl_dongSP = new javax.swing.JLabel();
        lbl_ngayNhapHang = new javax.swing.JLabel();
        txt_giaNhap = new javax.swing.JTextField();
        txt_giaBan = new javax.swing.JTextField();
        lbl_giaNhap = new javax.swing.JLabel();
        lbl_giaBan = new javax.swing.JLabel();
        lbl_soLuong = new javax.swing.JLabel();
        lbl_xuatXu = new javax.swing.JLabel();
        lbl_kichCo = new javax.swing.JLabel();
        lbl_trangThai = new javax.swing.JLabel();
        txt_soLuong = new javax.swing.JTextField();
        txt_xuatXu = new javax.swing.JTextField();
        txt_kichCo = new javax.swing.JTextField();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        txt_timKiem = new javax.swing.JTextField();
        cbo_trangThai = new javax.swing.JComboBox<>();
        txt_ngayNhapHang = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbl_CTSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ID", "Sản Phẩm", "Màu Sắc", "Đế Giày", "Dòng Sản Phẩm", "Nhà Cung Cấp", "Ngày Nhập Hàng", "Giá Nhập", "Giá Bán", "Số Lượng", "Kích Cỡ", "Xuất Xứ", "Trạng Thái"
            }
        ));
        tbl_CTSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_CTSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_CTSanPham);

        lbl_sanPham.setText("Sản phẩm");

        lbl_deGiay.setText("Đế giày");

        lbl_mauSac.setText("Màu sắc");

        lbl_nhaCC.setText("Nhà cung cấp");

        lbl_dongSP.setText("Dòng sản phẩm");

        lbl_ngayNhapHang.setText("Ngày nhập hàng");

        lbl_giaNhap.setText("Giá nhập ");

        lbl_giaBan.setText("Giá bán");

        lbl_soLuong.setText("Số lượng");

        lbl_xuatXu.setText("Xuất xứ");

        lbl_kichCo.setText("Kích cỡ");

        lbl_trangThai.setText("Trạng thái");

        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        txt_timKiem.setText("Tìm Kiếm...");
        txt_timKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_timKiemCaretUpdate(evt);
            }
        });
        txt_timKiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_timKiemFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_timKiemFocusLost(evt);
            }
        });

        txt_ngayNhapHang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_ngayNhapHangFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_ngayNhapHangFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_sanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_mauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_giaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_giaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_xuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbo_sanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_deGiay))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txt_xuatXu)
                                        .addComponent(txt_soLuong)
                                        .addComponent(txt_giaBan)
                                        .addComponent(txt_giaNhap)
                                        .addComponent(cbo_mauSac, 0, 205, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(55, 55, 55)
                                        .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbl_ngayNhapHang)
                                            .addComponent(lbl_dongSP)
                                            .addComponent(lbl_nhaCC)
                                            .addComponent(lbl_kichCo)
                                            .addComponent(lbl_trangThai))))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbo_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbo_dongSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbo_deGiay, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbo_nhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_kichCo, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_ngayNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_sanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_sanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_deGiay, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_deGiay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_dongSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_mauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_mauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_dongSP, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nhaCC, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_nhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_giaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_giaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_ngayNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_giaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_giaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ngayNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_kichCo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_kichCo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_xuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_xuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_timKiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_timKiemFocusGained
        // TODO add your handling code here:
        txt_timKiem.setText("");
    }//GEN-LAST:event_txt_timKiemFocusGained

    private void txt_timKiemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_timKiemFocusLost
        // TODO add your handling code here:
        txt_timKiem.setText("Tìm Kiếm...");
    }//GEN-LAST:event_txt_timKiemFocusLost

    private void txt_timKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_timKiemCaretUpdate
        // TODO add your handling code here:
        if (txt_timKiem.getText().isEmpty()) {
            loadTable("Tìm Kiếm...");
        }
        loadTable(txt_timKiem.getText());
    }//GEN-LAST:event_txt_timKiemCaretUpdate

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
        if (checkDL()==false) {
            var temp = JOptionPane.showConfirmDialog(this, "Bạn có chăc muốn thêm mới không ?");
        if (temp == 0) {
            JOptionPane.showMessageDialog(this, chiTietSanPhamService.add(getForm()));
            loadTable(null);
        }
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void tbl_CTSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_CTSanPhamMouseClicked
        // TODO add your handling code here:
        var row = tbl_CTSanPham.getSelectedRow();
        click = tbl_CTSanPham.getModel().getValueAt(row, 1).toString();
        var temp = chiTietSanPhamService.getById(click);
        cbo_sanPham.setSelectedItem(temp.getTenSP());
        cbo_mauSac.setSelectedItem(temp.getTenMauSac());
        cbo_deGiay.setSelectedItem(temp.getTenDeGiay());
        cbo_dongSanPham.setSelectedItem(temp.getTenDongSP());
        cbo_nhaCungCap.setSelectedItem(temp.getTenNhaCC());
        txt_ngayNhapHang.setText(temp.getNgayNhapHang());
        txt_giaNhap.setText(String.valueOf(temp.getGiaNhap()));
        txt_giaBan.setText(String.valueOf(temp.getGiaBan()));
        txt_soLuong.setText(String.valueOf(temp.getSoLuong()));
        txt_kichCo.setText(temp.getKichCo());
        txt_xuatXu.setText(temp.getXuatXu());
        cbo_trangThai.setSelectedIndex(temp.getTrangThai());
    }//GEN-LAST:event_tbl_CTSanPhamMouseClicked

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        // TODO add your handling code here:
        if (checkDL()==false) {
            var temp = JOptionPane.showConfirmDialog(this, "Bạn có chăc chắn muốn sửa thông tin không ?");
        if (temp == 0) {
            var row = tbl_CTSanPham.getSelectedRow();
            var chitietSP = getForm();
            chitietSP.setId(click);
            JOptionPane.showMessageDialog(this, chiTietSanPhamService.update(chitietSP));
            loadTable(null);
        }
        }


    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        var temp = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa thông tin không ?");
        if (temp == 0) {
            var chitietSP = new ChiTietSanPhamHiber();
            chitietSP.setId(click);
            JOptionPane.showMessageDialog(this, chiTietSanPhamService.delete(chitietSP));
            loadTable(null);
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // TODO add your handling code here:
        cbo_sanPham.setSelectedIndex(0);
        cbo_mauSac.setSelectedIndex(0);
        cbo_deGiay.setSelectedIndex(0);
        cbo_dongSanPham.setSelectedIndex(0);
        cbo_nhaCungCap.setSelectedIndex(0);
        txt_ngayNhapHang.setText(null);
        txt_giaNhap.setText(null);
        txt_giaBan.setText(null);
        txt_soLuong.setText(null);
        txt_kichCo.setText(null);
        txt_xuatXu.setText(null);
        cbo_trangThai.setSelectedIndex(0);
    }//GEN-LAST:event_btn_clearActionPerformed

    private void txt_ngayNhapHangFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_ngayNhapHangFocusGained
        // TODO add your handling code here:
        txt_ngayNhapHang.setText("");
    }//GEN-LAST:event_txt_ngayNhapHangFocusGained

    private void txt_ngayNhapHangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_ngayNhapHangFocusLost
        // TODO add your handling code here:
        txt_ngayNhapHang.setText(java.time.LocalDate.now()+"");
    }//GEN-LAST:event_txt_ngayNhapHangFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewCTSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCTSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCTSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCTSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCTSanPham().setVisible(true);
            }
        });
    }

    private String click;

    public void loadTable(String input) {
        DefaultTableModel mol = (DefaultTableModel) tbl_CTSanPham.getModel();
        mol.setRowCount(0);
        int stt = 1;
        for (var x : chiTietSanPhamService.getAllCustomModel(input)) {
            mol.addRow(new Object[]{
                stt++,
                x.getId(),
                x.getTenSP(),
                x.getTenMauSac(),
                x.getTenDeGiay(),
                x.getTenDongSP(),
                x.getTenNhaCC(),
                x.getNgayNhapHang(),
                x.getGiaNhap(),
                x.getGiaBan(),
                x.getSoLuong(),
                x.getKichCo(),
                x.getXuatXu(),
                x.getTrangThai() == 0 ? "Đang Bán" : "Dừng Bán"

            });
        }
    }

    public void loadCBB() {
        cbo_deGiay.removeAllItems();
        for (DeGiayCustomModel x : deGiayService.getAll(null)) {
            cbo_deGiay.addItem(x.getTen());
        }
        cbo_deGiay.setSelectedIndex(0);

        cbo_dongSanPham.removeAllItems();
        for (var x : dongSPService.getAll()) {
            cbo_dongSanPham.addItem(x.getTen());
        }
        cbo_dongSanPham.setSelectedIndex(0);

        cbo_mauSac.removeAllItems();
        for (var x : mauSacService.getAll()) {
            cbo_mauSac.addItem(x.getTen());
        }
        cbo_mauSac.setSelectedIndex(0);

        cbo_nhaCungCap.removeAllItems();
        for (var x : nhaCungCapService.getAll()) {
            cbo_nhaCungCap.addItem(x.getHoTen());
        }
        cbo_nhaCungCap.setSelectedIndex(0);

        cbo_sanPham.removeAllItems();
        for (var x : sanPhamService.getAll()) {
            cbo_sanPham.addItem(x.getTen());
        }
        cbo_sanPham.setSelectedIndex(0);

        cbo_trangThai.removeAllItems();
        cbo_trangThai.addItem("Đang Bán");
        cbo_trangThai.addItem("Dừng Bán");
        cbo_trangThai.setSelectedIndex(0);

    }

    public ChiTietSanPhamHiber getForm() {
        return new ChiTietSanPhamHiber(null,
                sanPhamHiberService.getByIndex(cbo_sanPham.getSelectedIndex()),
                dongSPHiberService.getByIndex(cbo_dongSanPham.getSelectedIndex()),
                deGiayService.getDeGiayHiberbyIndex(cbo_deGiay.getSelectedIndex()),
                mauSacHiberService.getByIndex(cbo_mauSac.getSelectedIndex()),
                nhaCungCapHiberService.getByIndex(cbo_nhaCungCap.getSelectedIndex()),
                txt_ngayNhapHang.getText(),
                Double.parseDouble(txt_giaNhap.getText()),
                Double.parseDouble(txt_giaBan.getText()),
                Integer.parseInt(txt_soLuong.getText()),
                txt_xuatXu.getText(),
                txt_kichCo.getText(),
                cbo_trangThai.getSelectedIndex());
    }

    public boolean checkDL() {
        // check giá nhập
        if (uti.CheckRong(txt_giaNhap.getText())) {
            JOptionPane.showMessageDialog(this, "Giá Nhập không được bỏ trống");
            txt_giaNhap.requestFocus();
            txt_giaNhap.setText("");
            return true;
        }

        if (uti.CheckSoThapPhan(txt_giaNhap.getText())) {
            JOptionPane.showMessageDialog(this, "Giá Nhập không đúng kiểu dữ liệu");
            txt_giaNhap.requestFocus();
            txt_giaNhap.setText("");
            return true;
        }

        // check giá bán
        if (uti.CheckRong(txt_giaBan.getText())) {
            JOptionPane.showMessageDialog(this, "Giá Bán không được bỏ trống");
            txt_giaBan.requestFocus();
            txt_giaBan.setText("");
            return true;
        }

        if (uti.CheckSoThapPhan(txt_giaBan.getText())) {
            JOptionPane.showMessageDialog(this, "Giá Bán không đúng kiểu dữ liệu");
            txt_giaBan.requestFocus();
            txt_giaBan.setText("");
            return true;
        }
        
        // check số lượng
        if (uti.CheckRong(txt_soLuong.getText())) {
            JOptionPane.showMessageDialog(this, "Số lượng không được bỏ trống");
            txt_soLuong.requestFocus();
            txt_soLuong.setText("");
            return true;
        }

        if (uti.CheckSo(txt_soLuong.getText())) {
            JOptionPane.showMessageDialog(this, "Số lượng không đúng kiểu dữ liệu");
            txt_soLuong.requestFocus();
            txt_soLuong.setText("");
            return true;
        }
        
        // check xuất xứ
        if (uti.CheckRong(txt_xuatXu.getText())) {
            JOptionPane.showMessageDialog(this, "Xuất xứ không được bỏ trống");
            txt_xuatXu.requestFocus();
            txt_xuatXu.setText("");
            return true;
        }

        if (uti.CheckChu(txt_xuatXu.getText())) {
            JOptionPane.showMessageDialog(this, "Xuất xứ không đúng kiểu dữ liệu");
            txt_xuatXu.requestFocus();
            txt_xuatXu.setText("");
            return true;
        }
        
        // check ngày nhập hàng
        
        if (uti.CheckNgayThang(txt_ngayNhapHang.getText())) {
            JOptionPane.showMessageDialog(this, "Ngày nhập hàng không đúng kiểu dữ liệu");
            txt_ngayNhapHang.requestFocus();
            txt_ngayNhapHang.setText("");
            return true;
        }
        
        // check kích cỡ
        if (uti.CheckRong(txt_kichCo.getText())) {
            JOptionPane.showMessageDialog(this, "Kích cỡ không được bỏ trống");
            txt_kichCo.requestFocus();
            txt_kichCo.setText("");
            return true;
        }

        if (uti.CheckSo(txt_kichCo.getText())) {
            JOptionPane.showMessageDialog(this, "Kích cỡ không đúng kiểu dữ liệu");
            txt_kichCo.requestFocus();
            txt_kichCo.setText("");
            return true;
        }
        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JComboBox<String> cbo_deGiay;
    private javax.swing.JComboBox<String> cbo_dongSanPham;
    private javax.swing.JComboBox<String> cbo_mauSac;
    private javax.swing.JComboBox<String> cbo_nhaCungCap;
    private javax.swing.JComboBox<String> cbo_sanPham;
    private javax.swing.JComboBox<String> cbo_trangThai;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_deGiay;
    private javax.swing.JLabel lbl_dongSP;
    private javax.swing.JLabel lbl_giaBan;
    private javax.swing.JLabel lbl_giaNhap;
    private javax.swing.JLabel lbl_kichCo;
    private javax.swing.JLabel lbl_mauSac;
    private javax.swing.JLabel lbl_ngayNhapHang;
    private javax.swing.JLabel lbl_nhaCC;
    private javax.swing.JLabel lbl_sanPham;
    private javax.swing.JLabel lbl_soLuong;
    private javax.swing.JLabel lbl_trangThai;
    private javax.swing.JLabel lbl_xuatXu;
    private javax.swing.JTable tbl_CTSanPham;
    private javax.swing.JTextField txt_giaBan;
    private javax.swing.JTextField txt_giaNhap;
    private javax.swing.JTextField txt_kichCo;
    private javax.swing.JTextField txt_ngayNhapHang;
    private javax.swing.JTextField txt_soLuong;
    private javax.swing.JTextField txt_timKiem;
    private javax.swing.JTextField txt_xuatXu;
    // End of variables declaration//GEN-END:variables

}
