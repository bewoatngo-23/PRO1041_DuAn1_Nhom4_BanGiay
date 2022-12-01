/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import customModelDoiTra.DoiTraCustomModel;
import customModelDoiTra.HDCTDoiTraCustomModel;
import customModelDoiTra.HoaDonDoiTraCustomModel;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import service.impl.DoiTraServiceImpl;

/**
 *
 * @author ADMIN
 */
public class viewDoiTra extends javax.swing.JFrame {

    private DefaultTableModel tblModelHDDT = new DefaultTableModel();
    private DefaultTableModel tblModelHDCTDT = new DefaultTableModel();
    private DefaultTableModel tblModelDoiTra = new DefaultTableModel();
    private List<HoaDonDoiTraCustomModel> listHDDT = new ArrayList<>();
    private List<HDCTDoiTraCustomModel> listHDCTDT = new ArrayList<>();
    private List<DoiTraCustomModel> listDoiTra = new ArrayList<>();
    private DoiTraServiceImpl dts = new DoiTraServiceImpl();
    private final JPopupMenu ppMenu = new JPopupMenu();
    private JMenuItem mnItem = null;
    String soLuong = "";

    public viewDoiTra() {
        initComponents();
        tblHoaDonDoiTra.setModel(tblModelHDDT);
        tblHDCTDoiTra.setModel(tblModelHDCTDT);
        tblDoiTra.setModel(tblModelDoiTra);
        String headerHDDT[] = {"Mã HĐ", "Tên nhân viên", "Tên khách hàng", "Sđt", "Ngày thanh toán", "Hạn đổi"};
        tblModelHDDT.setColumnIdentifiers(headerHDDT);
        String headersHDCTDT[] = {"Mã SP", "Tên SP", "Dòng SP", "Đế giầy", "Màu sắc", "Size", "Số luọng"};
        tblModelHDCTDT.setColumnIdentifiers(headersHDCTDT);
        String headerDT[] = {"Mã HĐ", "Tên khách hàng", "Sản phẩm đổi", "Số lượng"};
        tblModelDoiTra.setColumnIdentifiers(headerDT);
        listHDDT = dts.getHoaDonDoiTra();
        showDataHDDoiTra(listHDDT);

    }

    private void showDataHDDoiTra(List<HoaDonDoiTraCustomModel> lists) {
        tblModelHDDT.setRowCount(0);
        for (HoaDonDoiTraCustomModel x : lists) {
            tblModelHDDT.addRow(x.toRowData());
        }
    }

    private void showDataHDCTDoiTra(List<HDCTDoiTraCustomModel> listss) {
        tblModelHDCTDT.setRowCount(0);
        for (HDCTDoiTraCustomModel x : listss) {
            tblModelHDCTDT.addRow(x.toRowData());
        }
    }

    private void showDataDoiTra(List<DoiTraCustomModel> listsss) {
        tblModelDoiTra.setRowCount(0);
        for (DoiTraCustomModel x : listsss) {
            tblModelDoiTra.addRow(x.toRowData());
        }
    }

    private void createPPMenu(JFrame frame) {
        mnItem = new JMenuItem("Đổi sản phẩm");
        mnItem.getAccessibleContext().setAccessibleDescription("Đổi sản phẩm");
        mnItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "con cặc");
            }
        });
        ppMenu.add(mnItem);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtTimKiemDoiTra = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDonDoiTra = new javax.swing.JTable();
        cbbHanDoi = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHDCTDoiTra = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnDoiSanPham = new javax.swing.JButton();
        lblTenKHDoiTra = new javax.swing.JLabel();
        lblMaHDDoiTra = new javax.swing.JLabel();
        lblNgaDoiHangDT = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDoiTra = new javax.swing.JTable();
        btnXoaDoiTra = new javax.swing.JButton();
        btnCapNhatDoiTra = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btnQuayLai = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 1, 24)); // NOI18N
        jLabel1.setText("Quản lý đổi sản phẩm");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtTimKiemDoiTra.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemDoiTraCaretUpdate(evt);
            }
        });

        tblHoaDonDoiTra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblHoaDonDoiTra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblHoaDonDoiTra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonDoiTraMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHoaDonDoiTra);

        cbbHanDoi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Còn hạn", "Hết hạn " }));
        cbbHanDoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbHanDoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtTimKiemDoiTra, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbbHanDoi, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemDoiTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbHanDoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel2.setText("Hóa đơn");

        jLabel3.setText("Hóa đơn chi tiết");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblHDCTDoiTra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblHDCTDoiTra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblHDCTDoiTra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHDCTDoiTraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHDCTDoiTra);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setText("Tên khách hàng:");

        jLabel6.setText("Mã hóa đơn");

        jLabel9.setText("Ngày đổi hàng:");

        btnDoiSanPham.setText("Đổi sản phẩm");
        btnDoiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiSanPhamActionPerformed(evt);
            }
        });

        lblTenKHDoiTra.setText("_____");

        lblMaHDDoiTra.setText("_____");

        lblNgaDoiHangDT.setText("_____");

        jLabel11.setText("Ghi chú:");

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane4.setViewportView(txtGhiChu);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTenKHDoiTra, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblMaHDDoiTra, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNgaDoiHangDT, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDoiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblTenKHDoiTra))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblMaHDDoiTra))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblNgaDoiHangDT))
                .addGap(30, 30, 30)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDoiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setText("Hoàn trả");

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblDoiTra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblDoiTra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblDoiTra);

        btnXoaDoiTra.setText("Xóa");
        btnXoaDoiTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDoiTraActionPerformed(evt);
            }
        });

        btnCapNhatDoiTra.setText("Cập nhật");
        btnCapNhatDoiTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatDoiTraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnXoaDoiTra, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCapNhatDoiTra)
                .addContainerGap(240, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(14, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaDoiTra)
                    .addComponent(btnCapNhatDoiTra))
                .addGap(22, 22, 22))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(52, 52, 52)))
        );

        jLabel10.setText("Hóa đơn đổi hàng");

        btnQuayLai.setText("Quay lại");
        btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(692, 692, 692)
                        .addComponent(jLabel4)
                        .addContainerGap(255, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(214, 214, 214)
                        .addComponent(btnQuayLai)
                        .addGap(85, 85, 85))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnQuayLai)
                    .addComponent(jLabel1))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnQuayLaiActionPerformed

    private void tblHoaDonDoiTraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonDoiTraMouseClicked
        int index = tblHoaDonDoiTra.getSelectedRow();
        HoaDonDoiTraCustomModel hd = listHDDT.get(index);

        long millis = System.currentTimeMillis();
        Timestamp t = new Timestamp(millis);
        Date ngayTT = hd.getNgayThanhToan();
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(ngayTT);
        c2.setTime(t);

        long noDay = (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);
        if (noDay > 1) {
            JOptionPane.showMessageDialog(this, "Hóa đơn đã quá hạn đổi");
        } else {

            String idHD = hd.getId();
            listHDCTDT = dts.getHDCTDoiTra(idHD);
            showDataHDCTDoiTra(listHDCTDT);
            lblTenKHDoiTra.setText(hd.getTenKH());
            lblMaHDDoiTra.setText(hd.getMaHD());
            lblNgaDoiHangDT.setText(String.valueOf(new Date(millis)));
        }


    }//GEN-LAST:event_tblHoaDonDoiTraMouseClicked

    private void tblHDCTDoiTraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHDCTDoiTraMouseClicked
        int index = tblHDCTDoiTra.getSelectedRow();
        HDCTDoiTraCustomModel hdct = listHDCTDT.get(index);
        DoiTraCustomModel dt = new DoiTraCustomModel();
        int indexHD = tblHoaDonDoiTra.getSelectedRow();
        if (indexHD < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn muốn đổi sản phẩm");
        } else {
            boolean trung = false;
            for (DoiTraCustomModel x : listDoiTra) {
                if (x.getSanPhamDoi().equals(hdct.getTenSP())) {
                    trung = true;
                }
            }

            if (trung) {
                JOptionPane.showMessageDialog(this, "Sản phẩm đã có trong hóa đơn đổi hàng, để cập nhật vui lòng xóa đi chọn lại");
            } else {
                if (listDoiTra.size() == 1) {
                    JOptionPane.showMessageDialog(this, "Để thêm sản phẩm, hãy đổi sản phẩm trước đó");
                } else {
                    soLuong = JOptionPane.showInputDialog("Mời nhập số lượng: ");
                    if (soLuong != null) {
                        if (!soLuong.matches("[0-9]+")) {
                            JOptionPane.showMessageDialog(this, "Nhập đúng định dạng");
                        } else if (Integer.valueOf(soLuong) > hdct.getSoLuong()) {
                            JOptionPane.showMessageDialog(this, "Số lượng vượt quá");
                        } else {

                            var chon = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn đổi sản phẩm");

                            if (chon == 0) {
                                HoaDonDoiTraCustomModel hd = listHDDT.get(indexHD);
                                dt.setMaHD(lblMaHDDoiTra.getText());
                                dt.setTenKH(lblTenKHDoiTra.getText());
                                dt.setSanPhamDoi(hdct.getTenSP());
                                dt.setSoLuongDoi(Integer.valueOf(soLuong));

                                listDoiTra.add(dt);
                                showDataDoiTra(listDoiTra);

                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_tblHDCTDoiTraMouseClicked

    private void btnDoiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiSanPhamActionPerformed
        int indexHDCT = tblHDCTDoiTra.getSelectedRow();
        int indexDT = tblDoiTra.getSelectedRow();
        long millis = System.currentTimeMillis();
        DoiTraCustomModel dt = new DoiTraCustomModel();
        int indexHD = tblHoaDonDoiTra.getSelectedRow();
        if (indexHD < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn muốn đổi sản phẩm");
        } else if (indexHDCT < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phảm muốn đổi");
        } else if (txtGhiChu.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền ghi chú");
        } else {
            HDCTDoiTraCustomModel hdctc = listHDCTDT.get(indexHDCT);
            HoaDonDoiTraCustomModel hdc = listHDDT.get(indexHD);
            String idCTSP = hdctc.getIdCTSP();
            String idHD = hdc.getId();
            String idKH = hdc.getIdKH();
            Date ngayDoi = new Date(millis);
            String ghiChu = txtGhiChu.getText();
            HoaDonDoiTraCustomModel hd = new HoaDonDoiTraCustomModel(idCTSP, idHD, idKH, ngayDoi, Integer.valueOf(soLuong), ghiChu);
            HDCTDoiTraCustomModel hdct = new HDCTDoiTraCustomModel(Integer.valueOf(soLuong));
            JOptionPane.showMessageDialog(this, dts.doiTra(hd));
            dts.capNhatSoLuong(hdct, idCTSP);
            listDoiTra.clear();
            showDataDoiTra(listDoiTra);
            lblMaHDDoiTra.setText("_____");
            lblNgaDoiHangDT.setText("_____");
            lblTenKHDoiTra.setText("_____");
            txtGhiChu.setText("");
        }
    }//GEN-LAST:event_btnDoiSanPhamActionPerformed

    private void txtTimKiemDoiTraCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemDoiTraCaretUpdate
        listHDDT = dts.SearchHDDT(txtTimKiemDoiTra.getText());
        showDataHDDoiTra(listHDDT);
    }//GEN-LAST:event_txtTimKiemDoiTraCaretUpdate

    private void btnXoaDoiTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDoiTraActionPerformed
        int index = tblDoiTra.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần xóa");
        } else {
            var chon = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa sản phẩm");
            if (chon == 0) {

                listDoiTra.remove(index);
                showDataDoiTra(listDoiTra);
            }
        }
    }//GEN-LAST:event_btnXoaDoiTraActionPerformed

    private void btnCapNhatDoiTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatDoiTraActionPerformed
        int indexHDCT = tblHDCTDoiTra.getSelectedRow();
        int indexDT = tblDoiTra.getSelectedRow();
        if (indexDT < 0) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn sàn phẩm cần cập nhật");
        } else {

            String soLuong = JOptionPane.showInputDialog("Mời nhập số lượng: ");
            HDCTDoiTraCustomModel hdct = listHDCTDT.get(indexHDCT);
            DoiTraCustomModel dt = new DoiTraCustomModel();

            if (soLuong != null) {
                if (!soLuong.matches("[0-9]+")) {
                    JOptionPane.showMessageDialog(this, "Nhập đúng định dạng");
                } else if (Integer.valueOf(soLuong) > hdct.getSoLuong()) {
                    JOptionPane.showMessageDialog(this, "Số lượng vượt quá");
                } else if (Integer.valueOf(soLuong) == 0) {
                    JOptionPane.showMessageDialog(this, "Vui lòng chọn chức năng xóa");
                } else {
                    var chon = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn cập nhật");
                    if (chon == 0) {
                        dt.setMaHD(lblMaHDDoiTra.getText());
                        dt.setTenKH(lblTenKHDoiTra.getText());
                        dt.setSanPhamDoi(hdct.getTenSP());
                        dt.setSoLuongDoi(Integer.valueOf(soLuong));

                        listDoiTra.set(indexDT, dt);
                        showDataDoiTra(listDoiTra);
                    }

                }
            }
        }
    }//GEN-LAST:event_btnCapNhatDoiTraActionPerformed

    private void cbbHanDoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbHanDoiActionPerformed
//         int index = tblHoaDonDoiTra.getSelectedRow();
//        HoaDonDoiTraCustomModel hd = listHDDT.get(index);
//
//        long millis = System.currentTimeMillis();
//        Timestamp t = new Timestamp(millis);
//        Date ngayTT = hd.getNgayThanhToan();
//        Calendar c1 = Calendar.getInstance();
//        Calendar c2 = Calendar.getInstance();
//        c1.setTime(ngayTT);
//        c2.setTime(t);
//
//        long noDay = (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);
        
        
    }//GEN-LAST:event_cbbHanDoiActionPerformed

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
            java.util.logging.Logger.getLogger(viewDoiTra.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewDoiTra.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewDoiTra.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewDoiTra.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewDoiTra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhatDoiTra;
    private javax.swing.JButton btnDoiSanPham;
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JButton btnXoaDoiTra;
    private javax.swing.JComboBox<String> cbbHanDoi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblMaHDDoiTra;
    private javax.swing.JLabel lblNgaDoiHangDT;
    private javax.swing.JLabel lblTenKHDoiTra;
    private javax.swing.JTable tblDoiTra;
    private javax.swing.JTable tblHDCTDoiTra;
    private javax.swing.JTable tblHoaDonDoiTra;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtTimKiemDoiTra;
    // End of variables declaration//GEN-END:variables
}
