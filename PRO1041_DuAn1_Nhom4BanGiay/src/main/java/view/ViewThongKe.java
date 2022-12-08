/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import customModel.HDCTCustoModelHD;
import customModel.HoaDonCustomModelHD;
import customModel.HoaDonCustomModelHDThongKe;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import service.IDoiTraService;
import service.IHoaDonHDService;
import service.IHoaDonHDServiceThongKe;
import service.impl.DoiTraServiceImpl;
import service.impl.HoaDonHDServiceImpl;
import service.impl.HoaDonHDServiceImplThongKe;
import utilities.Utility;
import repository.IDoiTraThongKeRes;
import service.IDoiTraThongKeService;
import service.impl.DoiTraThongKeServiceImpl;

/**
 *
 * @author ADMIN
 */
public class ViewThongKe extends javax.swing.JFrame {

    private IHoaDonHDServiceThongKe hoaDonHDServiceThongKe = new HoaDonHDServiceImplThongKe();
    private IDoiTraThongKeService doiTraThongKe = new DoiTraThongKeServiceImpl();
    private utilities.Utility utility = new Utility();

    /**
     * Creates new form ViewThongKe
     */
    public ViewThongKe() {
        initComponents();
        setDoanhThuTheoNgay(year + "", month + "", day + "");
        setHoaDonTheoNgay(year + "", month + "", day + "");
        setSanPhamTheoNgay(year + "", month + "", day + "");
        setKhachHangTheoNgay(year + "", month + "", day + "");
        setDoiTraTheoNgay(year + "", month + "", day + "");
        setBieuDoDTTheoThang(pnl_doanhThu, month + "", year + "");
        setBieuDoKHTronTheoThang(pnl_khachHangTron, month + "", year + "");
        setBieuDoKHTheoThang(pnl_khachHang, month + "", year + "");
        setTronDoiTraTheoThang(pnl_doiTra, month + "", year + "");

        txt_ngayTK.setText(day + "");
        txt_thangTK.setText(month + "");
        txt_namTK.setText(year + "");
        txt_thangDT.setText(month + "");
        txt_thangKH.setText(month + "");
        txt_namDT.setText(year + "");
        txt_namKH.setText(year + "");
        txt_namDoiTra.setText(year + "");
        txt_thangDoiTra.setText(month + "");

    }
    Calendar instance = Calendar.getInstance();
    int year = instance.get(Calendar.YEAR);
    int month = instance.get(Calendar.MONTH) + 1;
    int day = instance.get(Calendar.DATE);

    public void setDoanhThuTheoNgay(String year, String month, String day) {
        double sum = 0;
        String ngay = null;
        if (day.equals("1") || day.equals("2") || day.equals("3") || day.equals("4") || day.equals("5") || day.equals("6") || day.equals("7") || day.equals("8") || day.equals("9")) {
            ngay = "0" + String.valueOf(day);
        } else {
            ngay = day;
        }
        for (HoaDonCustomModelHDThongKe x : hoaDonHDServiceThongKe.getHoaDonByNgay("'" + year + "-" + month + "-" + ngay + "'")) {
            sum = sum + x.getTongTien();
        }
        lbl_doanhThu.setText(String.format("%.2f", sum));
    }

    public void setHoaDonTheoNgay(String year, String month, String day) {
        int sum = 0;
        String ngay = null;
        if (day.equals("1") || day.equals("2") || day.equals("3") || day.equals("4") || day.equals("5") || day.equals("6") || day.equals("7") || day.equals("8") || day.equals("9")) {
            ngay = "0" + String.valueOf(day);
        } else {
            ngay = day;
        }
        for (var x : hoaDonHDServiceThongKe.getHoaDonByNgay("'" + year + "-" + month + "-" + ngay + "'")) {
            sum++;
        }
        lbl_hoaDon.removeAll();
        lbl_hoaDon.setText(sum + "");

    }

    public void setSanPhamTheoNgay(String year, String month, String day) {
        int sum = 0;
        String ngay = null;
        if (day.equals("1") || day.equals("2") || day.equals("3") || day.equals("4") || day.equals("5") || day.equals("6") || day.equals("7") || day.equals("8") || day.equals("9")) {
            ngay = "0" + String.valueOf(day);
        } else {
            ngay = day;
        }
        for (var x : hoaDonHDServiceThongKe.getHoaDonByNgay("'" + year + "-" + month + "-" + ngay + "'")) {
            sum += x.getTongSP();
        }
        lbl_sanPham.removeAll();
        lbl_sanPham.setText(sum + "");
    }

    public void setKhachHangTheoNgay(String year, String month, String day) {
        int sum = 0;
        String ngay = null;
        if (day.equals("1") || day.equals("2") || day.equals("3") || day.equals("4") || day.equals("5") || day.equals("6") || day.equals("7") || day.equals("8") || day.equals("9")) {
            ngay = "0" + String.valueOf(day);
        } else {
            ngay = day;
        }
        for (var x : hoaDonHDServiceThongKe.getHoaDonByNgay("'" + year + "-" + month + "-" + ngay + "'")) {
            sum++;
        }
        lbl_khachHang.removeAll();
        lbl_khachHang.setText(sum + "");
    }

    public void setDoiTraTheoNgay(String year, String month, String day) {
        int sum = 0;
        String ngay = null;
        if (day.equals("1") || day.equals("2") || day.equals("3") || day.equals("4") || day.equals("5") || day.equals("6") || day.equals("7") || day.equals("8") || day.equals("9")) {
            ngay = "0" + String.valueOf(day);
        } else {
            ngay = day;
        }
        for (var x : doiTraThongKe.getAllWhere("'" + year + "-" + month + "-" + ngay + "'")) {
            sum++;
        }
        lbl_doiTra.removeAll();
        lbl_doiTra.setText(sum + "");
    }

    public void setDoanhThuTheoThang(String nam, String thang) {
        double sum = 0;
        int Thang = 0;
        int Nam = 0;
        if (Integer.parseInt(thang) == 12) {
            Thang = 1;
            Nam = Integer.parseInt(nam) + 1;
        } else {
            Thang = Integer.parseInt(thang) + 1;
            Nam = Integer.parseInt(nam);
        }
        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + nam + "-" + thang + "-01'", "'" + Nam + "-" + Thang + "-01'")) {
            sum = sum + x.getTongTien();
        }
        lbl_doanhThu.removeAll();
        lbl_doanhThu.setText(String.format("%.2f", sum));

    }

    public void setHoaDonTheoThang(String nam, String thang) {
        int sum = 0;
        int Thang = 0;
        int Nam = 0;
        if (Integer.parseInt(thang) == 12) {
            Thang = 1;
            Nam = Integer.parseInt(nam) + 1;
        } else {
            Thang = Integer.parseInt(thang) + 1;
            Nam = Integer.parseInt(nam);
        }
        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + nam + "-" + thang + "-01'", "'" + Nam + "-" + Thang + "-01'")) {
            sum++;
        }
        lbl_hoaDon.removeAll();
        lbl_hoaDon.setText(sum + "");
    }

    public void setSanPhamTheoThang(String nam, String thang) {
        int sum = 0;
        int Thang = 0;
        int Nam = 0;
        if (Integer.parseInt(thang) == 12) {
            Thang = 1;
            Nam = Integer.parseInt(nam) + 1;
        } else {
            Thang = Integer.parseInt(thang) + 1;
            Nam = Integer.parseInt(nam);
        }
        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + nam + "-" + thang + "-01'", "'" + Nam + "-" + Thang + "-01'")) {
            sum = sum + x.getTongSP();
        }
        lbl_sanPham.removeAll();
        lbl_sanPham.setText(sum + "");
    }

    public void setKhachHangTheoThang(String nam, String thang) {
        int sum = 0;
        int Thang = 0;
        int Nam = 0;
        if (Integer.parseInt(thang) == 12) {
            Thang = 1;
            Nam = Integer.parseInt(nam) + 1;
        } else {
            Thang = Integer.parseInt(thang) + 1;
            Nam = Integer.parseInt(nam);
        }
        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + nam + "-" + thang + "-01'", "'" + Nam + "-" + Thang + "-01'")) {
            sum++;
        }
        lbl_khachHang.removeAll();
        lbl_khachHang.setText(sum + "");
    }

    public void setDoiTraTheoThang(String nam, String thang) {
        int sum = 0;
        int Thang = 0;
        int Nam = 0;
        if (Integer.parseInt(thang) == 12) {
            Thang = 1;
            Nam = Integer.parseInt(nam) + 1;
        } else {
            Thang = Integer.parseInt(thang) + 1;
            Nam = Integer.parseInt(nam);
        }
        for (var x : doiTraThongKe.getAll("'" + nam + "-" + thang + "-01'", "'" + Nam + "-" + Thang + "-01'")) {
            sum++;
        }
        lbl_doiTra.removeAll();
        lbl_doiTra.setText(sum + "");
    }

    public void setDoanhThuTheoNam(String year) {
        double sum = 0;

        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + year + "-01-01'", "'" + year + "-12-31'")) {
            sum = sum + x.getTongTien();
        }
        lbl_doanhThu.removeAll();
         lbl_doanhThu.setText(String.format("%.2f", sum));

    }

    public void setHoaDonTheoNam(String year) {
        int sum = 0;
        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + year + "-01-01'", "'" + year + "-12-31'")) {
            sum++;
        }
        lbl_hoaDon.removeAll();
        lbl_hoaDon.setText(sum + "");
    }

    public void setSanPhamTheoNam(String year) {
        int sum = 0;
        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + year + "-01-01'", "'" + year + "-12-31'")) {
            sum = sum + x.getTongSP();
        }
        lbl_sanPham.removeAll();
        lbl_sanPham.setText(sum + "");
    }

    public void setKhachHangTheoNam(String year) {
        int sum = 0;
        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + year + "-01-01'", "'" + year + "-12-31'")) {
            sum++;
        }
        lbl_khachHang.removeAll();
        lbl_khachHang.setText(sum + "");
    }

    public void setDoiTraTheoNam(String year) {
        int sum = 0;
        for (var x : doiTraThongKe.getAll("'" + year + "-01-01'", "'" + year + "-12-31'")) {
            sum++;
        }
        lbl_doiTra.removeAll();
        lbl_doiTra.setText(sum + "");
    }

    public void setBieuDoDTTheoNam(JPanel input, String batDau) {
        double thang1 = 0;
        double thang2 = 0;
        double thang3 = 0;
        double thang4 = 0;
        double thang5 = 0;
        double thang6 = 0;
        double thang7 = 0;
        double thang8 = 0;
        double thang9 = 0;
        double thang10 = 0;
        double thang11 = 0;
        double thang12 = 0;
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + batDau + "-01-01'", "'" + batDau + "-02-01'")) {
            if (x.getTrangThai() == 3) {
                thang1 += x.getTongTien();
                dataset.addValue(thang1, "Doang Thu Năm " + batDau, "Tháng 1");
            }
        }

        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + batDau + "-02-02'", "'" + batDau + "-03-01'")) {
            if (x.getTrangThai() == 3) {
                thang2 += x.getTongTien();
                dataset.addValue(thang2, "Doang Thu Năm " + batDau, "Tháng 2");
            }
        }

        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + batDau + "-03-02'", "'" + batDau + "-04-01'")) {
            if (x.getTrangThai() == 3) {
                thang3 += x.getTongTien();
                dataset.addValue(thang3, "Doang Thu Năm " + batDau, "Tháng 3");
            }
        }

        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + batDau + "-04-02'", "'" + batDau + "-05-01'")) {
            if (x.getTrangThai() == 3) {
                thang4 += x.getTongTien();
                dataset.addValue(thang4, "Doang Thu Năm " + batDau, "Tháng 4");
            }
        }

        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + batDau + "-05-02'", "'" + batDau + "-06-01'")) {
            if (x.getTrangThai() == 3) {
                thang5 += x.getTongTien();
                dataset.addValue(thang5, "Doang Thu Năm " + batDau, "Tháng 5");
            }
        }

        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + batDau + "-06-02'", "'" + batDau + "-07-01'")) {
            if (x.getTrangThai() == 3) {
                thang6 += x.getTongTien();
                dataset.addValue(thang6, "Doang Thu Năm " + batDau, "Tháng 6");
            }
        }

        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + batDau + "-07-02'", "'" + batDau + "-08-01'")) {
            if (x.getTrangThai() == 3) {
                thang7 += x.getTongTien();
                dataset.addValue(thang7, "Doang Thu Năm " + batDau, "Tháng 7");
            }
        }

        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + batDau + "-08-02'", "'" + batDau + "-09-01'")) {
            if (x.getTrangThai() == 3) {
                thang8 += x.getTongTien();
                dataset.addValue(thang8, "Doang Thu Năm " + batDau, "Tháng 8");
            }
        }

        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + batDau + "-09-02'", "'" + batDau + "-10-01'")) {
            thang9 += x.getTongTien();
            dataset.addValue(thang9, "Doang Thu Năm " + batDau, "Tháng 9");
        }

        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + batDau + "-10-02'", "'" + batDau + "-11-01'")) {
            if (x.getTrangThai() == 3) {
                thang10 += x.getTongTien();
                dataset.addValue(thang10, "Doang Thu Năm " + batDau, "Tháng 10");
            }
        }

        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + batDau + "-11-02'", "'" + batDau + "-12-01'")) {
            if (x.getTrangThai() == 3) {
                thang11 += x.getTongTien();
                dataset.addValue(thang11, "Doang Thu Năm " + batDau, "Tháng 11");
            }
        }

        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + batDau + "-12-02'", "'" + batDau + "-12-31'")) {
            if (x.getTrangThai() == 3) {
                thang12 += x.getTongTien();
                dataset.addValue(thang12, "Doang Thu Năm " + batDau, "Tháng 12");
            }
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

    public void setBieuDoDTTheoThang(JPanel input, String thang, String nam) {
        double thang1 = 0;
        double thang2 = 0;
        double thang3 = 0;
        double thang4 = 0;
        double thang5 = 0;
        double thang6 = 0;
        double thang7 = 0;
        double thang8 = 0;
        double thang9 = 0;
        double thang10 = 0;
        double thang11 = 0;
        double thang12 = 0;
        int Thang = 0;
        int Nam = 0;
        if (Integer.parseInt(thang) == 12) {
            Thang = 1;
            Nam = Integer.parseInt(nam) + 1;
        } else {
            Thang = Integer.parseInt(thang) + 1;
            Nam = Integer.parseInt(nam);
        }
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + nam + "-" + thang + "-01'", "'" + Nam + "-" + Thang + "-01'")) {
            if (x.getTrangThai() == 3) {
                thang1 += x.getTongTien();
                dataset.addValue(thang1, "Doang Thu Tháng " + Integer.parseInt(thang), x.getNgayThanhToan());
            }
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

    public void setBieuDoTheoThang(JPanel input, String thang, String nam) {
        double sum = 0;
        String batDau = "'" + nam + "-" + thang + "-01'";
        String ketThuc = "'" + nam + "-" + Integer.parseInt(thang) + 1 + "-01'";
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen(batDau, ketThuc)) {
            if (x.getTrangThai() == 3) {
                sum = sum + x.getTongTien();
                dataset.addValue(sum, "Doang Thu ", x.getNgayThanhToan());
            }
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

    public void setBieuDoKHTronTheoThang(JPanel input, String thang, String nam) {
        int nho = 0;
        int tre = 0;
        int trung = 0;
        int gia = 0;
        int Thang = 0;
        int Nam = 0;
        if (Integer.parseInt(thang) == 12) {
            Thang = 1;
            Nam = Integer.parseInt(nam) + 1;
        } else {
            Thang = Integer.parseInt(thang) + 1;
            Nam = Integer.parseInt(nam);
        }
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + nam + "-" + thang + "-01'", "'" + Nam + "-" + Thang + "-01'")) {
            if (x.getTrangThai() == 3 && x.getTuoiKH() > 14 && x.getTuoiKH() <= 20) {
                nho++;
                dataset.setValue("Tuổi từ 14-20", nho);
            }
        }
        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + nam + "-" + thang + "-01'", "'" + Nam + "-" + Thang + "-01'")) {
            if (x.getTrangThai() == 3 && x.getTuoiKH() > 20 && x.getTuoiKH() <= 40) {
                tre++;
                dataset.setValue("Tuổi từ 20-40", tre);
            }

        }
        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + nam + "-" + thang + "-01'", "'" + Nam + "-" + Thang + "-01'")) {
            if (x.getTrangThai() == 3 && x.getTuoiKH() > 40 && x.getTuoiKH() <= 60) {
                trung++;
                dataset.setValue("Tuổi từ 40-60", trung);
            }

        }
        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + nam + "-" + thang + "-01'", "'" + Nam + "-" + Thang + "-01'")) {
            if (x.getTrangThai() == 3 && x.getTuoiKH() > 60) {
                gia++;
                dataset.setValue("Tuổi trên 60", gia);
            }
        }

        JFreeChart cha = ChartFactory.createPieChart("Biểu Đồ Thống Kê Tuổi Khách Hàng Tháng " + thang, dataset);
        ChartPanel chartPanel = new ChartPanel(cha);;
        chartPanel.setPreferredSize(new Dimension(input.getWidth(), 470));

        input.removeAll();
        input.setLayout(new CardLayout());
        input.add(chartPanel);
        input.validate();
        input.repaint();
    }

    public void setBieuDoKHTronTheoNam(JPanel input, String batDau) {
        int nho = 0;
        int tre = 0;
        int trung = 0;
        int gia = 0;

        DefaultPieDataset dataset = new DefaultPieDataset();
        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + batDau + "-01-01'", "'" + batDau + "-12-31'")) {
            if (x.getTrangThai() == 3 && x.getTuoiKH() > 14 && x.getTuoiKH() <= 20) {
                nho++;
                dataset.setValue("Tuổi từ 14-20", nho);
            }
        }
        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + batDau + "-01-01'", "'" + batDau + "-12-31'")) {
            if (x.getTrangThai() == 3 && x.getTuoiKH() > 20 && x.getTuoiKH() <= 40) {
                tre++;
                dataset.setValue("Tuổi từ 20-40", tre);
            }

        }
        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + batDau + "-01-01'", "'" + batDau + "-12-31'")) {
            if (x.getTrangThai() == 3 && x.getTuoiKH() > 40 && x.getTuoiKH() <= 60) {
                trung++;
                dataset.setValue("Tuổi từ 40-60", trung);
            }

        }
        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + batDau + "-01-01'", "'" + batDau + "-12-31'")) {
            if (x.getTrangThai() == 3 && x.getTuoiKH() > 60) {
                gia++;
                dataset.setValue("Tuổi trên 60", gia);
            }
        }

        JFreeChart cha = ChartFactory.createPieChart("Biểu Đồ Thống Kê Tuổi Khách Hàng Năm " + batDau, dataset);
        ChartPanel chartPanel = new ChartPanel(cha);;
        chartPanel.setPreferredSize(new Dimension(input.getWidth(), 5));

        input.removeAll();
        input.setLayout(new CardLayout());
        input.add(chartPanel);
        input.validate();
        input.repaint();
    }

    public void setTronDoiTraTheoNam(JPanel input, String batDau) {
        int chatLuong = 0;
        int mauSac = 0;
        int kichCo = 0;

        DefaultPieDataset dataset = new DefaultPieDataset();
        for (var x : doiTraThongKe.getAll("'" + batDau + "-01-01'", "'" + batDau + "-12-31'")) {
            if (x.getLiDoDoi().equals("Chat Luong")) {
                chatLuong++;
                dataset.setValue("Chất lượng", chatLuong);
            }
        }
        for (var x : doiTraThongKe.getAll("'" + batDau + "-01-01'", "'" + batDau + "-12-31'")) {
            if (x.getLiDoDoi().equals("Mau Sac")) {
                mauSac++;
                dataset.setValue("Màu Sắc", chatLuong);
            }
        }
        for (var x : doiTraThongKe.getAll("'" + batDau + "-01-01'", "'" + batDau + "-12-31'")) {
            if (x.getLiDoDoi().equals("Kich Co")) {
                kichCo++;
                dataset.setValue("Kích Cỡ", chatLuong);
            }
        }

        JFreeChart cha = ChartFactory.createPieChart("Biểu Đồ Thống Kê Sản Phẩm Đổi Trả ", dataset);
        ChartPanel chartPanel = new ChartPanel(cha);;
        chartPanel.setPreferredSize(new Dimension(input.getWidth(), 470));

        input.removeAll();
        input.setLayout(new CardLayout());
        input.add(chartPanel);
        input.validate();
        input.repaint();
    }

    public void setTronDoiTraTheoThang(JPanel input, String thang, String nam) {
        int chatLuong = 0;
        int mauSac = 0;
        int kichCo = 0;
        int Thang = 0;
        int Nam = 0;
        if (Integer.parseInt(thang) == 12) {
            Thang = 1;
            Nam = Integer.parseInt(nam) + 1;
        } else {
            Thang = Integer.parseInt(thang) + 1;
            Nam = Integer.parseInt(nam);
        }
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (var x : doiTraThongKe.getAll("'" + nam + "-" + thang + "-01'", "'" + Nam + "-" + Thang + "-01'")) {
            if (x.getLiDoDoi().equals("Chat Luong")) {
                chatLuong++;
                dataset.setValue("Chất lượng", chatLuong);
            }
        }
        for (var x : doiTraThongKe.getAll("'" + nam + "-" + thang + "-01'", "'" + Nam + "-" + Thang + "-01'")) {
            if (x.getLiDoDoi().equals("Mau Sac")) {
                mauSac++;
                dataset.setValue("Màu Sắc", mauSac);
            }
        }
        for (var x : doiTraThongKe.getAll("'" + nam + "-" + thang + "-01'", "'" + Nam + "-" + Thang + "-01'")) {
            if (x.getLiDoDoi().equals("Kich Co")) {
                kichCo++;
                dataset.setValue("Kích Cỡ", kichCo);
            }
        }

        JFreeChart cha = ChartFactory.createPieChart("Biểu Đồ Thống Kê Sản Phẩm Đổi Trả ", dataset);
        ChartPanel chartPanel = new ChartPanel(cha);;
        chartPanel.setPreferredSize(new Dimension(input.getWidth(), 470));

        input.removeAll();
        input.setLayout(new CardLayout());
        input.add(chartPanel);
        input.validate();
        input.repaint();
    }

    public void setBieuDoKHTheoNam(JPanel input, String batDau) {
        double thang1 = 0;
        double thang2 = 0;
        double thang3 = 0;
        double thang4 = 0;
        double thang5 = 0;
        double thang6 = 0;
        double thang7 = 0;
        double thang8 = 0;
        double thang9 = 0;
        double thang10 = 0;
        double thang11 = 0;
        double thang12 = 0;
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + batDau + "-01-01'", "'" + batDau + "-02-01'")) {
            if (x.getTrangThai() == 3) {
                thang1++;
                dataset.addValue(thang1, "Lượng Khách Hàng Năm " + batDau, "Tháng 1");
            }
        }

        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + batDau + "-02-02'", "'" + batDau + "-03-01'")) {
            if (x.getTrangThai() == 3) {
                thang2++;
                dataset.addValue(thang2, "Lượng Khách Hàng Năm " + batDau, "Tháng 2");
            }
        }

        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + batDau + "-03-02'", "'" + batDau + "-04-01'")) {
            if (x.getTrangThai() == 3) {
                thang3++;
                dataset.addValue(thang3, "Lượng Khách Hàng Năm " + batDau, "Tháng 3");
            }
        }

        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + batDau + "-04-02'", "'" + batDau + "-05-01'")) {
            if (x.getTrangThai() == 3) {
                thang4++;
                dataset.addValue(thang4, "Lượng Khách Hàng Năm " + batDau, "Tháng 4");
            }
        }

        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + batDau + "-05-02'", "'" + batDau + "-06-01'")) {
            if (x.getTrangThai() == 3) {
                thang5++;
                dataset.addValue(thang5, "Lượng Khách Hàng Năm " + batDau, "Tháng 5");
            }
        }

        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + batDau + "-06-02'", "'" + batDau + "-07-01'")) {
            if (x.getTrangThai() == 3) {
                thang6++;
                dataset.addValue(thang6, "Lượng Khách Hàng Năm " + batDau, "Tháng 6");
            }
        }

        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + batDau + "-07-02'", "'" + batDau + "-08-01'")) {
            if (x.getTrangThai() == 3) {
                thang7++;
                dataset.addValue(thang7, "Lượng Khách Hàng Năm " + batDau, "Tháng 7");
            }
        }

        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + batDau + "-08-02'", "'" + batDau + "-09-01'")) {
            if (x.getTrangThai() == 3) {
                thang8++;
                dataset.addValue(thang8, "Lượng Khách Hàng Năm " + batDau, "Tháng 8");
            }
        }

        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + batDau + "-09-02'", "'" + batDau + "-10-01'")) {
            thang9++;
            dataset.addValue(thang9, "Lượng Khách Hàng Năm " + batDau, "Tháng 9");
        }

        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + batDau + "-10-02'", "'" + batDau + "-11-01'")) {
            if (x.getTrangThai() == 3) {
                thang10++;
                dataset.addValue(thang10, "Lượng Khách Hàng Năm " + batDau, "Tháng 10");
            }
        }

        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + batDau + "-11-02'", "'" + batDau + "-12-01'")) {
            if (x.getTrangThai() == 3) {
                thang11++;
                dataset.addValue(thang11, "Lượng Khách Hàng Năm " + batDau, "Tháng 11");
            }
        }

        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + batDau + "-12-02'", "'" + batDau + "-12-31'")) {
            if (x.getTrangThai() == 3) {
                thang12++;
                dataset.addValue(thang12, "Lượng Khách Hàng Năm " + batDau, "Tháng 12");
            }
        }

        JFreeChart cha = ChartFactory.createBarChart("Biểu Đồ Thống Kê Khách Hàng Năm " + batDau, null, "Khách Hàng", dataset);
        ChartPanel chartPanel = new ChartPanel(cha);
        chartPanel.setPreferredSize(new Dimension(input.getWidth(), 10));

        input.removeAll();
        input.setLayout(new CardLayout());
        input.add(chartPanel);
        input.validate();
        input.repaint();

    }

    public void setBieuDoKHTheoThang(JPanel input, String thang, String nam) {
        double thang1 = 0;
        double thang2 = 0;
        double thang3 = 0;
        double thang4 = 0;
        double thang5 = 0;
        double thang6 = 0;
        double thang7 = 0;
        double thang8 = 0;
        double thang9 = 0;
        double thang10 = 0;
        double thang11 = 0;
        double thang12 = 0;
        int Thang = 0;
        int Nam = 0;
        if (Integer.parseInt(thang) == 12) {
            Thang = 1;
            Nam = Integer.parseInt(nam) + 1;
        } else {
            Thang = Integer.parseInt(thang) + 1;
            Nam = Integer.parseInt(nam);
        }
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (var x : hoaDonHDServiceThongKe.getHoaDonBetWeen("'" + nam + "-" + thang + "-01'", "'" + Nam + "-" + Thang + "-01'")) {
            if (x.getTrangThai() == 3) {
                thang1++;
                dataset.addValue(thang1, "Khách Hàng Tháng " + Integer.parseInt(thang), x.getNgayThanhToan());
            }
        }

        JFreeChart cha = ChartFactory.createBarChart("Biểu Đồ Thống Kê Khách Hàng Tháng " + thang, null, "Khách Hàng", dataset);
        ChartPanel chartPanel = new ChartPanel(cha);
        chartPanel.setPreferredSize(new Dimension(input.getWidth(), 10));

        input.removeAll();
        input.setLayout(new CardLayout());
        input.add(chartPanel);
        input.validate();
        input.repaint();

    }

    public boolean checkNgayThang(JTextField input) {
        if (input.getText().isEmpty() || input.getText().isBlank()) {
            return false;
        }
        if (utility.CheckSo(input.getText())) {
            JOptionPane.showMessageDialog(this, "Ngày Tháng không đúng kiểu dữ liệu");
            input.requestFocus();
            input.setText("");
            return true;
        }
        if (utility.DemChuoi(input.getText()) >= 3) {
            JOptionPane.showMessageDialog(this, "Ngày Tháng không đúng kiểu dữ liệu");
            input.requestFocus();
            input.setText("");
            return true;
        }
        return false;
    }

    public boolean checkNam(JTextField input) {
        if (utility.CheckSo(input.getText())) {
            JOptionPane.showMessageDialog(this, "Năm không đúng kiểu dữ liệu");
            input.requestFocus();
            input.setText("");
            return true;
        }
        if (utility.DemChuoi(input.getText()) < 4 || utility.DemChuoi(input.getText()) > 4) {
            JOptionPane.showMessageDialog(this, "Năm không đúng kiểu dữ liệu");
            input.requestFocus();
            input.setText("");
            return true;
        }
        return false;
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
        pnl_khachHangTron = new javax.swing.JPanel();
        lbl_thangKH = new javax.swing.JLabel();
        lbl_namKH = new javax.swing.JLabel();
        txt_namKH = new javax.swing.JTextField();
        btn_thongKeKH = new javax.swing.JButton();
        txt_thangKH = new javax.swing.JTextField();
        pnl_khachHang = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        pnl_doiTra = new javax.swing.JPanel();
        lbl_thangKH1 = new javax.swing.JLabel();
        txt_thangDoiTra = new javax.swing.JTextField();
        lbl_namKH1 = new javax.swing.JLabel();
        txt_namDoiTra = new javax.swing.JTextField();
        btn_thongKeDoiTra = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lbl_doiTra = new javax.swing.JLabel();
        btn_reset = new javax.swing.JButton();
        btn_thongKeLBL = new javax.swing.JButton();
        lbl_thangDT1 = new javax.swing.JLabel();
        txt_ngayTK = new javax.swing.JTextField();
        lbl_thangDT2 = new javax.swing.JLabel();
        txt_thangTK = new javax.swing.JTextField();
        lbl_namDT1 = new javax.swing.JLabel();
        txt_namTK = new javax.swing.JTextField();

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_doanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(27, Short.MAX_VALUE))
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
            .addGap(0, 490, Short.MAX_VALUE)
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
                        .addGap(0, 847, Short.MAX_VALUE)))
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

        javax.swing.GroupLayout pnl_khachHangTronLayout = new javax.swing.GroupLayout(pnl_khachHangTron);
        pnl_khachHangTron.setLayout(pnl_khachHangTronLayout);
        pnl_khachHangTronLayout.setHorizontalGroup(
            pnl_khachHangTronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
        );
        pnl_khachHangTronLayout.setVerticalGroup(
            pnl_khachHangTronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 487, Short.MAX_VALUE)
        );

        lbl_thangKH.setText("Tháng");

        lbl_namKH.setText("Năm");

        txt_namKH.setText("2022");

        btn_thongKeKH.setText("Thống Kê");
        btn_thongKeKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thongKeKHActionPerformed(evt);
            }
        });

        txt_thangKH.setText("2022");

        javax.swing.GroupLayout pnl_khachHangLayout = new javax.swing.GroupLayout(pnl_khachHang);
        pnl_khachHang.setLayout(pnl_khachHangLayout);
        pnl_khachHangLayout.setHorizontalGroup(
            pnl_khachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnl_khachHangLayout.setVerticalGroup(
            pnl_khachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addContainerGap(851, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(pnl_khachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl_khachHangTron, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_khachHangTron, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_khachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane4.addTab("Biểu Đồ Thống Kê Khách Hàng", jPanel7);

        javax.swing.GroupLayout pnl_doiTraLayout = new javax.swing.GroupLayout(pnl_doiTra);
        pnl_doiTra.setLayout(pnl_doiTraLayout);
        pnl_doiTraLayout.setHorizontalGroup(
            pnl_doiTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnl_doiTraLayout.setVerticalGroup(
            pnl_doiTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 524, Short.MAX_VALUE)
        );

        lbl_thangKH1.setText("Tháng");

        txt_thangDoiTra.setText("2022");

        lbl_namKH1.setText("Năm");

        txt_namDoiTra.setText("2022");

        btn_thongKeDoiTra.setText("Thống Kê");
        btn_thongKeDoiTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thongKeDoiTraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbl_thangKH1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_thangDoiTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_namKH1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_namDoiTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_thongKeDoiTra)
                .addContainerGap(892, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_doiTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_thangKH1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_thangDoiTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_namKH1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_namDoiTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_thongKeDoiTra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnl_doiTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Sản Phẩm Đổi Trả", jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 51));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Sản Phẩm Đổi Trả");

        lbl_doiTra.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        lbl_doiTra.setForeground(new java.awt.Color(204, 0, 0));
        lbl_doiTra.setText("200");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(lbl_doiTra, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_doiTra)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        btn_reset.setText("Reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        btn_thongKeLBL.setText("Thống Kê");
        btn_thongKeLBL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thongKeLBLActionPerformed(evt);
            }
        });

        lbl_thangDT1.setText("Ngày");

        txt_ngayTK.setText("2022");

        lbl_thangDT2.setText("Tháng");

        txt_thangTK.setText("2022");

        lbl_namDT1.setText("Năm");

        txt_namTK.setText("2022");

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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_thangDT1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(txt_ngayTK, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_thangDT2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_thangTK, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addComponent(lbl_namDT1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_namTK, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_thongKeLBL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_reset)
                                .addGap(56, 56, 56)))))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ngayTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_thangDT1)
                            .addComponent(lbl_thangDT2)
                            .addComponent(txt_thangTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_namDT1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_namTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_thongKeLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(btn_reset)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
        } else if (txt_thangDT.getText().isEmpty() || txt_thangDT.getText().isBlank()) {
            setBieuDoDTTheoNam(pnl_doanhThu, txt_namDT.getText());
            setDoanhThuTheoNam(txt_namDT.getText());
            setHoaDonTheoNam(txt_namDT.getText());
            setSanPhamTheoNam(txt_namDT.getText());
            setKhachHangTheoNam(txt_namDT.getText());
            setDoiTraTheoNam(txt_namDT.getText());

        } else {
            setBieuDoDTTheoThang(pnl_doanhThu, txt_thangDT.getText(), txt_namDT.getText());
            setDoanhThuTheoThang(txt_namDT.getText(), txt_thangDT.getText());
            setKhachHangTheoThang(txt_namDT.getText(), txt_thangDT.getText());
            setSanPhamTheoThang(txt_namDT.getText(), txt_thangDT.getText());
            setHoaDonTheoThang(txt_namDT.getText(), txt_thangDT.getText());
            setDoiTraTheoThang(txt_namDT.getText(), txt_thangDT.getText());
        }

    }//GEN-LAST:event_btn_thongKeDTActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        // TODO add your handling code here:
        txt_thangDT.setText(month + "");
        txt_thangKH.setText(month + "");
        txt_namDT.setText(year + "");
        txt_namKH.setText(year + "");
        txt_ngayTK.setText(day + "");
        txt_thangTK.setText(month + "");
        txt_namTK.setText(year + "");
        setDoanhThuTheoNgay(year + "", month + "", day + "");
        setHoaDonTheoNgay(year + "", month + "", day + "");
        setSanPhamTheoNgay(year + "", month + "", day + "");
        setKhachHangTheoNgay(year + "", month + "", day + "");
        setBieuDoDTTheoThang(pnl_doanhThu, month + "", year + "");
        setBieuDoKHTheoThang(pnl_khachHang, month + "", year + "");
        setBieuDoKHTronTheoNam(pnl_khachHangTron, year + "");
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_thongKeKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thongKeKHActionPerformed
        // TODO add your handling code here:
        if (txt_namKH.getText().isEmpty() || txt_namKH.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Năm thống kê không được bỏ trông");
            txt_namKH.requestFocus();
            txt_namKH.setText("");
        } else if (txt_thangKH.getText().isEmpty() || txt_thangKH.getText().isBlank()) {
            setBieuDoKHTheoNam(pnl_khachHang, txt_namKH.getText());
            setBieuDoKHTronTheoNam(pnl_khachHangTron, txt_namKH.getText());
            setKhachHangTheoNam(txt_namKH.getText());
        } else {
            setBieuDoKHTheoThang(pnl_khachHang, txt_thangKH.getText(), txt_namKH.getText());
            setBieuDoKHTronTheoThang(pnl_khachHangTron, txt_thangKH.getText(), txt_namKH.getText());
        }

    }//GEN-LAST:event_btn_thongKeKHActionPerformed

    private void btn_thongKeLBLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thongKeLBLActionPerformed
        // TODO add your handling code here:
        if (checkNgayThang(txt_ngayTK) == false && checkNgayThang(txt_thangTK) == false && checkNam(txt_namTK) == false) {

            if (txt_ngayTK.getText().isEmpty() && txt_thangTK.getText().isEmpty()) {
                setDoanhThuTheoNam(txt_namTK.getText());
                setHoaDonTheoNam(txt_namTK.getText());
                setKhachHangTheoNam(txt_namTK.getText());
                setSanPhamTheoNam(txt_namTK.getText());
                setDoiTraTheoNam(txt_namTK.getText());
            } else if (txt_ngayTK.getText().isBlank() && txt_thangTK.getText().isBlank()) {
                setDoanhThuTheoNam(txt_namTK.getText());
                setHoaDonTheoNam(txt_namTK.getText());
                setKhachHangTheoNam(txt_namTK.getText());
                setSanPhamTheoNam(txt_namTK.getText());
                setDoiTraTheoNam(txt_namTK.getText());
            } else if (txt_ngayTK.getText().isBlank() || txt_ngayTK.getText().isEmpty()) {
                setDoanhThuTheoThang(txt_namTK.getText(), txt_thangTK.getText());
                setHoaDonTheoThang(txt_namTK.getText(), txt_thangTK.getText());
                setKhachHangTheoThang(txt_namTK.getText(), txt_thangTK.getText());
                setSanPhamTheoThang(txt_namTK.getText(), txt_thangTK.getText());
                setDoiTraTheoThang(txt_namTK.getText(), txt_thangTK.getText());
            } else if (txt_namTK.getText().isBlank() || txt_namTK.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng điền năm cần thống kê");
            } else {
                setDoanhThuTheoNgay(txt_namTK.getText(), txt_thangTK.getText(), txt_ngayTK.getText());
                setHoaDonTheoNgay(txt_namTK.getText(), txt_thangTK.getText(), txt_ngayTK.getText());
                setSanPhamTheoNgay(txt_namTK.getText(), txt_thangTK.getText(), txt_ngayTK.getText());
                setKhachHangTheoNgay(txt_namTK.getText(), txt_thangTK.getText(), txt_ngayTK.getText());
                setDoiTraTheoNgay(txt_namTK.getText(), txt_thangTK.getText(), txt_ngayTK.getText());
            }
        }


    }//GEN-LAST:event_btn_thongKeLBLActionPerformed

    private void btn_thongKeDoiTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thongKeDoiTraActionPerformed
        // TODO add your handling code here:
        if (txt_namDoiTra.getText().isEmpty() || txt_namDoiTra.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Năm thống kê không được bỏ trông");
            txt_namDoiTra.requestFocus();
            txt_namDoiTra.setText("");
        } else if (txt_thangDoiTra.getText().isEmpty() || txt_thangDoiTra.getText().isBlank()) {
            setTronDoiTraTheoNam(pnl_doiTra, txt_namDoiTra.getText());
            setDoiTraTheoNam(txt_namDoiTra.getText());
        } else {
            setTronDoiTraTheoThang(pnl_doiTra, txt_thangDoiTra.getText(), txt_namDoiTra.getText());
            setDoiTraTheoNam(txt_namDoiTra.getText());
        }
    }//GEN-LAST:event_btn_thongKeDoiTraActionPerformed

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
    private javax.swing.JButton btn_thongKeDoiTra;
    private javax.swing.JButton btn_thongKeKH;
    private javax.swing.JButton btn_thongKeLBL;
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
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JLabel lbl_doanhThu;
    private javax.swing.JLabel lbl_doiTra;
    private javax.swing.JLabel lbl_hoaDon;
    private javax.swing.JLabel lbl_khachHang;
    private javax.swing.JLabel lbl_namDT;
    private javax.swing.JLabel lbl_namDT1;
    private javax.swing.JLabel lbl_namKH;
    private javax.swing.JLabel lbl_namKH1;
    private javax.swing.JLabel lbl_sanPham;
    private javax.swing.JLabel lbl_thangDT;
    private javax.swing.JLabel lbl_thangDT1;
    private javax.swing.JLabel lbl_thangDT2;
    private javax.swing.JLabel lbl_thangKH;
    private javax.swing.JLabel lbl_thangKH1;
    private javax.swing.JPanel pnl_doanhThu;
    private javax.swing.JPanel pnl_doiTra;
    private javax.swing.JPanel pnl_khachHang;
    private javax.swing.JPanel pnl_khachHangTron;
    private javax.swing.JTextField txt_namDT;
    private javax.swing.JTextField txt_namDoiTra;
    private javax.swing.JTextField txt_namKH;
    private javax.swing.JTextField txt_namTK;
    private javax.swing.JTextField txt_ngayTK;
    private javax.swing.JTextField txt_thangDT;
    private javax.swing.JTextField txt_thangDoiTra;
    private javax.swing.JTextField txt_thangKH;
    private javax.swing.JTextField txt_thangTK;
    // End of variables declaration//GEN-END:variables
}
