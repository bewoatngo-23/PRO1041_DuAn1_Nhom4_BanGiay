/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import customModel.HDCTCustoModelHD;
import customModel.HoaDonCustomModelHD;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import service.IHoaDonHDService;
import service.IHoaDonHDServiceThongKe;
import service.impl.HoaDonHDServiceImpl;
import service.impl.HoaDonHDServiceImplThongKe;

/**
 *
 * @author ADMIN
 */
public class ViewThongKe extends javax.swing.JFrame {

    private IHoaDonHDServiceThongKe hoaDonHDServiceThongKe = new HoaDonHDServiceImplThongKe();

    /**
     * Creates new form ViewThongKe
     */
    public ViewThongKe() {
        initComponents();

        setDoanhThuTheoNgay(year+"",month+"",day+"");
        setHoaDonTheoNgay(year+"",month+"",day+"");
        setSanPhamTheoNgay(year+"",month+"",day+"");
        setKhachHangTheoNgay(year+"",month+"",day+"");
        txt_thangDT.setText(month+"");
        txt_thangKH.setText(month+"");
        txt_namDT.setText(year+"");
        txt_namKH.setText(year+"");
        setBieuDoDTTheoThang(pnl_doanhThu, month+"" , year+"");
    }
            Calendar instance = Calendar.getInstance();
        int year = instance.get(Calendar.YEAR);
        int month = instance.get(Calendar.MONTH);
        int day = instance.get(Calendar.DATE);

        
    public void setDoanhThuTheoNgay(String year,String month,String day) {
        double sum = 0;
        for (HoaDonCustomModelHD x : hoaDonHDServiceThongKe.getHoaDon()) {
            if (x.getNgayThanhToan().equals(year+"-"+month+"-"+day)) {
                sum = sum + x.getTongTien();
            }
        }
        lbl_doanhThu.removeAll();
        lbl_doanhThu.setText(sum + "");
    }

    public void setHoaDonTheoNgay(String year,String month,String day) {
        int sum = 0;
        for (HoaDonCustomModelHD x : hoaDonHDServiceThongKe.getHoaDon()) {
            if (x.getNgayThanhToan().equals(year+"-"+month+"-"+day)) {
               sum++;
            }           
        }
        lbl_hoaDon.removeAll();
        lbl_hoaDon.setText(sum + "");
    }

    public void setSanPhamTheoNgay(String year,String month,String day) {
        int sum = 0;
        for (HoaDonCustomModelHD x : hoaDonHDServiceThongKe.getHoaDon()) {
            if (x.getNgayThanhToan().equals(year+"-"+month+"-"+day)) {
                sum = sum + x.getTongSP();
            } 
           
        }
        lbl_sanPham.removeAll();
        lbl_sanPham.setText(sum + "");
    }

    public void setKhachHangTheoNgay(String year,String month,String day) {
        int sum = 0;
        for (HoaDonCustomModelHD x : hoaDonHDServiceThongKe.getHoaDon()) {
            if (x.getNgayThanhToan().equals(year+"-"+month+"-"+day)) {
               sum++;
            } 
        }
        lbl_khachHang.removeAll();
        lbl_khachHang.setText(sum + "");
    }
    
    // thêm phần set sản phẩm lỗi

    public void setDoanhThuTheoThang(String year,String month) {
        double sum = 0;
        int thang = Integer.parseInt(month)+1;
        for (HoaDonCustomModelHD x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'"+year+"-"+month+"-01'","'"+year+"-"+ thang +"-01'" )) {    
                sum = sum + x.getTongTien();     
        }
        lbl_doanhThu.removeAll();
        lbl_doanhThu.setText(sum + "");
    }

    public void setHoaDonTheoThang(String year,String month) {
        int sum = 0;
        int thang = Integer.parseInt(month)+1;
        for (HoaDonCustomModelHD x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'"+year+"-"+month+"-01'","'"+year+"-"+ thang +"-01'" )) {    
                sum++;
        }
        lbl_hoaDon.removeAll();
        lbl_hoaDon.setText(sum + "");
    }

    public void setSanPhamTheoThang(String year,String month) {
        int sum = 0;
        int thang = Integer.parseInt(month)+1;
        for (HoaDonCustomModelHD x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'"+year+"-"+month+"-01'","'"+year+"-"+ thang +"-01'" )) {    
                sum = sum + x.getTongSP();     
        }
        lbl_sanPham.removeAll();
        lbl_sanPham.setText(sum + "");
    }

    public void setKhachHangTheoThang(String year,String month) {
        int sum = 0;
        int thang = Integer.parseInt(month)+1;
        for (HoaDonCustomModelHD x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'"+year+"-"+month+"-01'","'"+year+"-"+ thang +"-01'" )) {    
                sum++;    
        }
        lbl_khachHang.removeAll();
        lbl_khachHang.setText(sum + "");
    }
    
    // thêm phần set sản phẩm lỗi

    
    public void setBieuDoDTTheoNam(JPanel input,String batDau){
        double thang1 =0;
        double thang2 =0;
        double thang3 =0;
        double thang4 =0;
        double thang5 =0;
        double thang6 =0;
        double thang7 =0;
        double thang8 =0;
        double thang9 =0;
        double thang10 =0;
        double thang11 =0;
        double thang12 =0;
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (var x: hoaDonHDServiceThongKe.getHoaDonBetWeen("'"+batDau+"-01-01'", "'"+batDau+"-02-01'")) {
             thang1 += x.getTongTien();
            dataset.addValue(thang1, "Doang Thu năm "+batDau, "Tháng 1");
        }
        
        for (var x: hoaDonHDServiceThongKe.getHoaDonBetWeen("'"+batDau+"-02-02'", "'"+batDau+"-03-01'")) {
            thang2 += x.getTongTien();
            dataset.addValue(thang2, "Doang Thu năm "+batDau, "Tháng 2");
        }
        
        for (var x: hoaDonHDServiceThongKe.getHoaDonBetWeen("'"+batDau+"-03-02'", "'"+batDau+"-04-01'")) {
            thang3 += x.getTongTien();
            dataset.addValue(thang3, "Doang Thu năm "+batDau, "Tháng 3");
        }
        
        for (var x: hoaDonHDServiceThongKe.getHoaDonBetWeen("'"+batDau+"-04-02'", "'"+batDau+"-05-01'")) {
           thang4 += x.getTongTien();
            dataset.addValue(thang4, "Doang Thu năm "+batDau, "Tháng 4");
        }
        
        for (var x: hoaDonHDServiceThongKe.getHoaDonBetWeen("'"+batDau+"-05-02'", "'"+batDau+"-06-01'")) {
            thang5 += x.getTongTien();
            dataset.addValue(thang5, "Doang Thu năm "+batDau, "Tháng 5");
        }
        
        for (var x: hoaDonHDServiceThongKe.getHoaDonBetWeen("'"+batDau+"-06-02'", "'"+batDau+"-07-01'")) {
            thang6 += x.getTongTien();
            dataset.addValue(thang6, "Doang Thu năm "+batDau, "Tháng 6");
        }
        
        for (var x: hoaDonHDServiceThongKe.getHoaDonBetWeen("'"+batDau+"-07-02'", "'"+batDau+"-08-01'")) {
            thang7 += x.getTongTien();
            dataset.addValue(thang7, "Doang Thu năm "+batDau, "Tháng 7");
        }
        
        for (var x: hoaDonHDServiceThongKe.getHoaDonBetWeen("'"+batDau+"-08-02'", "'"+batDau+"-09-01'")) {
            thang8 += x.getTongTien();
            dataset.addValue(thang8, "Doang Thu năm "+batDau, "Tháng 8");
        }
        
        for (var x: hoaDonHDServiceThongKe.getHoaDonBetWeen("'"+batDau+"-09-02'", "'"+batDau+"-10-01'")) {
            thang9 += x.getTongTien();
            dataset.addValue(thang9, "Doang Thu năm "+batDau, "Tháng 9");
        }
        
        for (var x: hoaDonHDServiceThongKe.getHoaDonBetWeen("'"+batDau+"-10-02'", "'"+batDau+"-11-01'")) {
            thang10 += x.getTongTien();
            dataset.addValue(thang10, "Doang Thu năm "+batDau, "Tháng 10");
        }
        
        for (var x: hoaDonHDServiceThongKe.getHoaDonBetWeen("'"+batDau+"-11-02'", "'"+batDau+"-12-01'")) {
            thang11 += x.getTongTien();
            dataset.addValue(thang11, "Doang Thu năm "+batDau, "Tháng 11");
        }
        
        for (var x: hoaDonHDServiceThongKe.getHoaDonBetWeen("'"+batDau+"-12-02'", "'"+batDau+"-12-31'")) {
            thang12 += x.getTongTien();
            dataset.addValue(thang12, "Doang Thu năm "+batDau, "Tháng 12");
        }
        
        
        JFreeChart cha = ChartFactory.createBarChart("Thống kê sản phẩm", null, "Doanh Thu", dataset);
        ChartPanel chartPanel = new ChartPanel(cha);
        chartPanel.setPreferredSize(new Dimension(input.getWidth(), 10));

        input.removeAll();
        input.setLayout(new CardLayout());
        input.add(chartPanel);
        input.validate();
        input.repaint();

    }
    
    public void setBieuDoDTTheoThang(JPanel input,String thang,String nam){
        double thang1 =0;
        double thang2 =0;
        double thang3 =0;
        double thang4 =0;
        double thang5 =0;
        double thang6 =0;
        double thang7 =0;
        double thang8 =0;
        double thang9 =0;
        double thang10 =0;
        double thang11 =0;
        double thang12 =0;
        int Thang = Integer.parseInt(thang)+1;
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (var x: hoaDonHDServiceThongKe.getHoaDonBetWeen("'"+nam+"-"+thang+"-01'", "'"+nam+"-"+Thang+"-01'")) {
             thang1 += x.getTongTien();
            dataset.addValue(thang1, "Doang Thu ", x.getNgayThanhToan());
        }
 
        
        
        JFreeChart cha = ChartFactory.createBarChart("Thống kê sản phẩm", null, "Doanh Thu", dataset);
        ChartPanel chartPanel = new ChartPanel(cha);
        chartPanel.setPreferredSize(new Dimension(input.getWidth(), 10));

        input.removeAll();
        input.setLayout(new CardLayout());
        input.add(chartPanel);
        input.validate();
        input.repaint();

    }
    
    
//    public void setBieuDoKH(JPanel input,String thang, String nam){
//        double thang1 =0;
//        double thang2 =0;
//        double thang3 =0;
//        double thang4 =0;
//        double thang5 =0;
//        double thang6 =0;
//        double thang7 =0;
//        double thang8 =0;
//        double thang9 =0;
//        double thang10 =0;
//        double thang11 =0;
//        double thang12 =0;
//        String batDau=  
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        for (var x: hoaDonHDService.getHoaDonBetWeen("'"+nam+"-"+thang+"-01'", "'"+nam+"-"+thang)) {
//             thang1++;
//             dataset.addValue(thang1, "Doang Thu năm 2022", "Tháng 1");
//        }
//        
//        for (var x: hoaDonHDService.getHoaDonBetWeen(batDau, ketThuc)) {
//            thang2++;
//            dataset.addValue(thang2, "Doang Thu năm 2022", "Tháng 2");
//        }
//        
//        for (var x: hoaDonHDService.getHoaDonBetWeen(batDau, ketThuc)) {
//            thang3++;
//            dataset.addValue(thang3, "Doang Thu năm 2022", "Tháng 3");
//        }
//        
//        for (var x: hoaDonHDService.getHoaDonBetWeen(batDau, ketThuc)) {
//           thang4++;
//            dataset.addValue(thang4, "Doang Thu năm 2022", "Tháng 4");
//        }
//        
//        for (var x: hoaDonHDService.getHoaDonBetWeen(batDau, ketThuc)) {
//            thang5++;
//            dataset.addValue(thang5, "Doang Thu năm 2022", "Tháng 5");
//        }
//        
//        for (var x: hoaDonHDService.getHoaDonBetWeen(batDau, ketThuc)) {
//            thang6++;
//            dataset.addValue(thang6, "Doang Thu năm 2022", "Tháng 6");
//        }
//        
//        for (var x: hoaDonHDService.getHoaDonBetWeen(batDau, ketThuc)) {
//            thang7++;
//            dataset.addValue(thang7, "Doang Thu năm 2022", "Tháng 7");
//        }
//        
//        for (var x: hoaDonHDService.getHoaDonBetWeen(batDau, ketThuc)) {
//            thang8++;
//            dataset.addValue(thang8, "Doang Thu năm 2022", "Tháng 8");
//        }
//        
//        for (var x: hoaDonHDService.getHoaDonBetWeen(batDau, ketThuc)) {
//            thang9++;
//            dataset.addValue(thang9, "Doang Thu năm 2022", "Tháng 9");
//        }
//        
//        for (var x: hoaDonHDService.getHoaDonBetWeen(batDau, ketThuc)) {
//            thang10++;
//            dataset.addValue(thang10, "Doang Thu năm 2022", "Tháng 10");
//        }
//        
//        for (var x: hoaDonHDService.getHoaDonBetWeen(batDau, ketThuc)) {
//            thang11++;
//            dataset.addValue(thang11, "Doang Thu năm 2022", "Tháng 11");
//        }
//        
//        for (var x: hoaDonHDService.getHoaDonBetWeen(batDau, ketThuc)) {
//            thang12++;
//            dataset.addValue(thang12, "Doang Thu năm 2022", "Tháng 12");
//        }
//        
//        
//        JFreeChart cha = ChartFactory.createBarChart("Thống kê sản phẩm", null, "Khách Hàng", dataset);
//        ChartPanel chartPanel = new ChartPanel(cha);
//        chartPanel.setPreferredSize(new Dimension(input.getWidth(), 10));
//
//        input.removeAll();
//        input.setLayout(new CardLayout());
//        input.add(chartPanel);
//        input.validate();
//        input.repaint();
//
//    }
    
    public void setBieuDoTheoThang(JPanel input, String thang, String nam){
        double sum = 0;
        String batDau = "'"+nam+"-"+thang+"-01'";
        String ketThuc = "'"+nam+"-"+ Integer.parseInt(thang)+1 +"-01'";
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (var x: hoaDonHDServiceThongKe.getHoaDonBetWeen(batDau, ketThuc)) {
            sum = sum + x.getTongTien();
             dataset.addValue(sum, "Doang Thu ", x.getNgayThanhToan());
        }
        
        JFreeChart cha = ChartFactory.createBarChart("Thống kê sản phẩm", null, "Doanh Thu", dataset);
        ChartPanel chartPanel = new ChartPanel(cha);
        chartPanel.setPreferredSize(new Dimension(input.getWidth(), 10));

        input.removeAll();
        input.setLayout(new CardLayout());
        input.add(chartPanel);
        input.validate();
        input.repaint();
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
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl_doanhThu = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbl_hoaDon = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbl_sanPham = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbl_khachHang = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnQuayLai = new javax.swing.JButton();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        pnl_doanhThu = new javax.swing.JPanel();
        lbl_namDT = new javax.swing.JLabel();
        lbl_thangDT = new javax.swing.JLabel();
        txt_namDT = new javax.swing.JTextField();
        btn_thongKeDT = new javax.swing.JButton();
        txt_thangDT = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        pnl_khachHang = new javax.swing.JPanel();
        lbl_thangKH = new javax.swing.JLabel();
        lbl_namKH = new javax.swing.JLabel();
        txt_namKH = new javax.swing.JTextField();
        btn_thongKeKH = new javax.swing.JButton();
        txt_thangKH = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_sanPhamLoi = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lbl_spLoi = new javax.swing.JLabel();
        btn_reset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Doanh Thu");

        lbl_doanhThu.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        lbl_doanhThu.setForeground(new java.awt.Color(204, 0, 0));
        lbl_doanhThu.setText("20.000.000");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("VNĐ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(lbl_doanhThu)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_doanhThu)
                    .addComponent(jLabel9))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Hóa đơn");

        lbl_hoaDon.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        lbl_hoaDon.setForeground(new java.awt.Color(204, 0, 0));
        lbl_hoaDon.setText("209");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(lbl_hoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(lbl_hoaDon)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Sản phẩm bán ra");

        lbl_sanPham.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        lbl_sanPham.setForeground(new java.awt.Color(204, 0, 0));
        lbl_sanPham.setText("270");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_sanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(lbl_sanPham)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 51));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Lượng khách hàng");

        lbl_khachHang.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        lbl_khachHang.setForeground(new java.awt.Color(204, 0, 0));
        lbl_khachHang.setText("200");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(22, 22, 22))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(lbl_khachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(lbl_khachHang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 102));
        jLabel10.setText("Thống Kê");

        btnQuayLai.setText("Quay lại");
        btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_doanhThuLayout = new javax.swing.GroupLayout(pnl_doanhThu);
        pnl_doanhThu.setLayout(pnl_doanhThuLayout);
        pnl_doanhThuLayout.setHorizontalGroup(
            pnl_doanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnl_doanhThuLayout.setVerticalGroup(
            pnl_doanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 466, Short.MAX_VALUE)
        );

        lbl_namDT.setText("Năm");

        lbl_thangDT.setText("Tháng");

        txt_namDT.setText("2022");

        btn_thongKeDT.setText("Thống Kê");
        btn_thongKeDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thongKeDTActionPerformed(evt);
            }
        });

        txt_thangDT.setText("2022");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_doanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lbl_thangDT, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_thangDT, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(lbl_namDT, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_namDT, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(btn_thongKeDT)
                        .addGap(0, 823, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_namDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_namDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_thongKeDT)
                    .addComponent(txt_thangDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_thangDT))
                .addGap(18, 18, 18)
                .addComponent(pnl_doanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Biểu Đồ Thống Kê Doanh Thu", jPanel6);

        javax.swing.GroupLayout pnl_khachHangLayout = new javax.swing.GroupLayout(pnl_khachHang);
        pnl_khachHang.setLayout(pnl_khachHangLayout);
        pnl_khachHangLayout.setHorizontalGroup(
            pnl_khachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1166, Short.MAX_VALUE)
        );
        pnl_khachHangLayout.setVerticalGroup(
            pnl_khachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 463, Short.MAX_VALUE)
        );

        lbl_thangKH.setText("Tháng");

        lbl_namKH.setText("Năm");

        txt_namKH.setText("2022");

        btn_thongKeKH.setText("Thống Kê");

        txt_thangKH.setText("2022");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_khachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(lbl_thangKH, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txt_thangKH, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_namKH, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_namKH, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btn_thongKeKH)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_thangKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_namKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_namKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_thongKeKH)
                    .addComponent(txt_thangKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(pnl_khachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Biểu Đồ Thống Kê Khách Hàng", jPanel7);

        tbl_sanPhamLoi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Hóa Đơn", "Khách Hàng", "Sản Phẩm", "Ngày Đổi", "Số Lượng", "Ghi Chú"
            }
        ));
        jScrollPane2.setViewportView(tbl_sanPhamLoi);

        jTextField1.setText("Tìm Kiếm...");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1166, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Sản Phẩm Lỗi", jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 51));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Sản phẩm lỗi");

        lbl_spLoi.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        lbl_spLoi.setForeground(new java.awt.Color(204, 0, 0));
        lbl_spLoi.setText("200");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(lbl_spLoi, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_spLoi)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        btn_reset.setText("Reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(434, 434, 434)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnQuayLai)
                .addGap(71, 71, 71))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_reset)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10))
                    .addComponent(btnQuayLai))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(48, 48, 48))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(46, 46, 46)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(btn_reset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jTabbedPane4)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnQuayLaiActionPerformed

    private void btn_thongKeDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thongKeDTActionPerformed
        // TODO add your handling code here:
        if (txt_namDT.getText().isEmpty() || txt_namDT.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Năm thống kê không được bỏ trông");
            txt_namDT.requestFocus();
            txt_namDT.setText("");
        }
        else if (txt_thangDT.getText().isEmpty() || txt_thangDT.getText().isBlank()) {
            setBieuDoDTTheoNam(pnl_doanhThu, txt_namDT.getText()); 
                    
        }
        else{
            setBieuDoDTTheoThang(pnl_doanhThu, txt_thangDT.getText(), txt_namDT.getText());
//            setDoanhThuTheoThang( txt_thangDT.getText(), txt_namDT.getText());
//            setKhachHangTheoThang( txt_thangDT.getText(), txt_namDT.getText());
//            setSanPhamTheoThang( txt_thangDT.getText(), txt_namDT.getText());
//            setHoaDonTheoThang( txt_thangDT.getText(), txt_namDT.getText());
        }
       
    }//GEN-LAST:event_btn_thongKeDTActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        // TODO add your handling code here:
        setDoanhThuTheoNgay(year+"",month+"",day+"");
        setHoaDonTheoNgay(year+"",month+"",day+"");
        setSanPhamTheoNgay(year+"",month+"",day+"");
        setKhachHangTheoNgay(year+"",month+"",day+"");
    }//GEN-LAST:event_btn_resetActionPerformed

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
            java.util.logging.Logger.getLogger(ViewThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewThongKe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_thongKeDT;
    private javax.swing.JButton btn_thongKeKH;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbl_doanhThu;
    private javax.swing.JLabel lbl_hoaDon;
    private javax.swing.JLabel lbl_khachHang;
    private javax.swing.JLabel lbl_namDT;
    private javax.swing.JLabel lbl_namKH;
    private javax.swing.JLabel lbl_sanPham;
    private javax.swing.JLabel lbl_spLoi;
    private javax.swing.JLabel lbl_thangDT;
    private javax.swing.JLabel lbl_thangKH;
    private javax.swing.JPanel pnl_doanhThu;
    private javax.swing.JPanel pnl_khachHang;
    private javax.swing.JTable tbl_sanPhamLoi;
    private javax.swing.JTextField txt_namDT;
    private javax.swing.JTextField txt_namKH;
    private javax.swing.JTextField txt_thangDT;
    private javax.swing.JTextField txt_thangKH;
    // End of variables declaration//GEN-END:variables
}
