/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import customModel.DeGiayCustomModel;
import customModel.KhachHangCustomModel;
import customModel.NhanVienCustomModel;
import domainModel.ChiTietSanPhamHiber;
import domainModel.ChucVu;
import domainModel.KhachHang;
import domainModel.NhanVien;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.DefaultTableModel;
import service.IChiTietSanPhamService;
import service.IDeGiayService;
import service.IDongSPHiberService;
import service.IDongSPService;
import service.IKhachHangService;
import service.IMauSacHiberService;
import service.IMauSacService;
import service.INhaCungCapHiberService;
import service.INhaCungCapService;
import service.ISanPhamHiberService;
import service.ISanPhamService;
import service.impl.ChiTietSanPhamServiceImpl;
import service.impl.ChucVuServiceImpl;
import service.impl.DeGiayServiecImpl;
import service.impl.DongSPHiberServiceImpl;
import service.impl.DongSPServiceImpl;
import service.impl.KhachHangServiceImpl;
import service.impl.MauSacHiberServiecImpl;
import service.impl.MauSacServiceImpl;
import service.impl.NhaCungCapHiberServiceImpl;
import service.impl.NhaCungCapServiceImpl;
import service.impl.NhanVienServiceImpl;
import service.impl.SanPhamHiberServiceImpl;
import service.impl.SanPhamServiceImpl;

import utilities.Utility;

/**
 *
 * @author ADMIN
 */
public class HomeQuanLyBG extends javax.swing.JFrame {
    
    private DefaultTableModel tblmodel = new DefaultTableModel();
    private List<KhachHang> listKH = new ArrayList<>();
    private List<KhachHangCustomModel> listKHCM = new ArrayList<>();
    private IKhachHangService khs = new KhachHangServiceImpl();
    private DefaultTableModel dtm = new DefaultTableModel();
    private List<NhanVien> listNhanViens = new ArrayList<>();
    private List<NhanVienCustomModel> listNhanVienCustom = new ArrayList<>();
    private NhanVienServiceImpl nhanVienServiceImpl = new NhanVienServiceImpl();
    private List<ChucVu> listChucVus = new ArrayList<>();
    private DefaultComboBoxModel dfcbCV = new DefaultComboBoxModel();
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
    private ChucVuServiceImpl chucVuService = new ChucVuServiceImpl();
    private utilities.Utility uti = new Utility();
    private CardLayout cardLayout;
    
    public HomeQuanLyBG() {
        initComponents();
        
        cardLayout = (CardLayout) (pnlcards.getLayout());
        tblKhachHang.setModel(tblmodel);
        String headerKH[] = {"STT", "ID", "Mã", "HọTên", "Sđt"};
        tblmodel.setColumnIdentifiers(headerKH);
        showData(listKHCM = khs.getAllCustom());
        setTitle("Hệ thống quản lý bán giày");
        setLocationRelativeTo(null);
        setResizable(false);
        tbHienThi.setModel(dtm);
        String headerNV[] = {"Chức Vụ", "Mã", "Họ Tên", "Tài khoản", "Mật khẩu", "Sdt", "Email", "Giới tính", "Ngày sinh", "Địa chỉ"};
        dtm.setColumnIdentifiers(headerNV);
        cbbChucVu.setModel(dfcbCV);
        listNhanVienCustom = nhanVienServiceImpl.getAllCustom();
        listChucVus = chucVuService.getAll();
        listChucVus.forEach(chucVu -> cbbChucVu.addItem(chucVu.getMa()));
        showDataNV(listNhanVienCustom);
        txt_ngayNhapHang.setText(java.time.LocalDate.now() + "");
        loadCBB();
        loadTable(null);
    }
    
    private void showData(List<KhachHangCustomModel> lists) {
        tblmodel.setRowCount(0);
        int i = 1;
        for (KhachHangCustomModel kh : lists) {
            Object[] data = new Object[]{
                i++, kh.getId(), kh.getMa(), kh.getHoTen(), kh.getSdt()
            };
            tblmodel.addRow(data);
        }
    }
    
    private void fillData(int index) {
        KhachHangCustomModel kh = listKHCM.get(index);
        txtMaKH.setText(kh.getMa());
        txtTenKH.setText(kh.getHoTen());
        txtSdt.setText(kh.getSdt());
        
    }
    
    private void showDataNV(List<NhanVienCustomModel> listNhanVienCustom) {
        dtm.setRowCount(0);
        for (NhanVienCustomModel listNhanViens : listNhanVienCustom) {
            dtm.addRow(listNhanViens.toRowData());
        }
    }
    
    private void fillDataNV(int index) {
        NhanVienCustomModel kh = listNhanVienCustom.get(index);
        lbID.setText(kh.getId());
        txtMa.setText(kh.getMa());
        txtTen.setText(kh.getHoTen());
        txtTaiKhoan.setText(kh.getTaiKhoan());
        txtMatKhau.setText(kh.getMatKhau());
        txtNgaySinh.setText(String.valueOf(kh.getNgaySinh()));
        txtDiaChi.setText(kh.getDiaChi());
        txtSdtNV.setText(kh.getSdt());
        txtEmail.setText(kh.getEmail());
        
        if (kh.getGioiTinh().equalsIgnoreCase("Nam")) {
            radioNam.setSelected(true);
        } else {
            radioNu.setSelected(true);
        }
        cbbChucVu.setSelectedItem(kh.getTenCV());
        lbTenChucVu.setText(kh.getTenCV());
        
    }
    
    public boolean CheckDL() {
        if (uti.CheckRong(txtMa.getText())) {
            JOptionPane.showMessageDialog(this, "Mã không được để trống");
            txtMa.requestFocus();
            txtMa.setText("");
            return true;
        }
        if (uti.CheckRong(txtTen.getText())) {
            JOptionPane.showMessageDialog(this, "Họ tên không được để trống");
            txtTen.requestFocus();
            txtTen.setText("");
            return true;
        }
        if (uti.CheckRong(txtTaiKhoan.getText())) {
            JOptionPane.showMessageDialog(this, "Tài khoản không được để trống");
            txtTaiKhoan.requestFocus();
            txtTaiKhoan.setText("");
            return true;
        }
        if (uti.CheckRong(txtMatKhau.getText())) {
            JOptionPane.showMessageDialog(this, "Mật khảu không được để trống");
            txtMatKhau.requestFocus();
            txtMatKhau.setText("");
            return true;
        }
        if (uti.CheckRong(txtNgaySinh.getText())) {
            JOptionPane.showMessageDialog(this, "Ngày sinh không được để trống");
            txtNgaySinh.requestFocus();
            txtNgaySinh.setText("");
            return true;
        }
        if (uti.CheckRong(txtDiaChi.getText())) {
            JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống");
            txtDiaChi.requestFocus();
            txtDiaChi.setText("");
            return true;
        }
        if (uti.CheckRong(txtSdtNV.getText())) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống");
            txtSdt.requestFocus();
            txtSdt.setText("");
            return true;
        }
        if (uti.CheckRong(txtEmail.getText())) {
            JOptionPane.showMessageDialog(this, "Email không được để trống");
            txtEmail.requestFocus();
            txtEmail.setText("");
            return true;
        }
        
        return false;
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
                //                x.getTenNhaCC(),
                x.getNgayNhapHang(),
                //                x.getGiaNhap(),
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


//        cbo_nhaCungCap.removeAllItems();
//        for (var x : nhaCungCapService.getAll()) {
//            cbo_nhaCungCap.addItem(x.getHoTen());
//        }
//        cbo_nhaCungCap.setSelectedIndex(0);

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
                null,
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnKhachhang = new javax.swing.JButton();
        btnNhanVien = new javax.swing.JButton();

        btnSanPham = new javax.swing.JButton();

        btnThongKe = new javax.swing.JButton();
        btnBanHang = new javax.swing.JButton();
        btnDoiTra = new javax.swing.JButton();
        btnKetThuc = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        pnlcards = new javax.swing.JPanel();
        pnlMain = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTenQuanLy = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        pnlKhachHang = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        txtMaKH = new javax.swing.JTextField();
        txtSdt = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        btnClear = new javax.swing.JButton();

        pnlNhanVien = new javax.swing.JPanel();

        btnUpdateNV = new javax.swing.JButton();
        btnDeleteNV = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnClearNV = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbHienThi = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbbChucVu = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        lbTenChucVu = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbTenCuaHang = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtTimKiem1 = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtTaiKhoan = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtSdtNV = new javax.swing.JTextField();
        radioNam = new javax.swing.JRadioButton();
        radioNu = new javax.swing.JRadioButton();
        lbID = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btnAddNV = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnThemCV = new javax.swing.JButton();
        pnlCTSP = new javax.swing.JPanel();
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
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_CTSanPham = new javax.swing.JTable();
        txt_xuatXu = new javax.swing.JTextField();
        txt_kichCo = new javax.swing.JTextField();
        lbl_sanPham = new javax.swing.JLabel();
        btn_them = new javax.swing.JButton();
        cbo_sanPham = new javax.swing.JComboBox<>();
        btn_sua = new javax.swing.JButton();
        lbl_deGiay = new javax.swing.JLabel();
        btn_xoa = new javax.swing.JButton();
        cbo_deGiay = new javax.swing.JComboBox<>();
        btn_clear = new javax.swing.JButton();
        cbo_dongSanPham = new javax.swing.JComboBox<>();
        txt_timKiem = new javax.swing.JTextField();
        cbo_mauSac = new javax.swing.JComboBox<>();
        cbo_trangThai = new javax.swing.JComboBox<>();
        txt_ngayNhapHang = new javax.swing.JTextField();
        lbl_mauSac = new javax.swing.JLabel();
        lbl_dongSP = new javax.swing.JLabel();
        btnThemSP = new javax.swing.JButton();
        btnThemMS = new javax.swing.JButton();
        btnThemDG = new javax.swing.JButton();
        btnThemDSP = new javax.swing.JButton();
        pnlBanHang = new javax.swing.JPanel();
        pnlDoiTra = new javax.swing.JPanel();
        pnlThongKe = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1187, 730));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(204, 0, 0));

        btnKhachhang.setBackground(new java.awt.Color(215, 215, 207));
        btnKhachhang.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnKhachhang.setForeground(new java.awt.Color(0, 51, 51));
        btnKhachhang.setText("Khách hàng");
        btnKhachhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachhangActionPerformed(evt);
            }
        });

        btnNhanVien.setBackground(new java.awt.Color(215, 215, 207));
        btnNhanVien.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnNhanVien.setForeground(new java.awt.Color(0, 51, 51));
        btnNhanVien.setText("Nhân viên");
        btnNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienActionPerformed(evt);
            }
        });

        btnSanPham.setBackground(new java.awt.Color(215, 215, 207));
        btnSanPham.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnSanPham.setForeground(new java.awt.Color(0, 51, 51));
        btnSanPham.setText("Sản phẩm");
        btnSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSanPhamActionPerformed(evt);
            }
        });

        btnThongKe.setBackground(new java.awt.Color(215, 215, 207));
        btnThongKe.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnThongKe.setForeground(new java.awt.Color(0, 51, 51));
        btnThongKe.setText("Thống Kê");
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        btnBanHang.setBackground(new java.awt.Color(215, 215, 207));
        btnBanHang.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnBanHang.setForeground(new java.awt.Color(0, 51, 51));
        btnBanHang.setText("Bán hàng");
        btnBanHang.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanHangActionPerformed(evt);
            }
        });

        btnDoiTra.setBackground(new java.awt.Color(215, 215, 207));
        btnDoiTra.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnDoiTra.setForeground(new java.awt.Color(0, 51, 51));
        btnDoiTra.setText("Đổi trả");
        btnDoiTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiTraActionPerformed(evt);
            }
        });

        btnKetThuc.setBackground(new java.awt.Color(215, 215, 207));
        btnKetThuc.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnKetThuc.setForeground(new java.awt.Color(0, 51, 51));
        btnKetThuc.setText("Kết thúc");
        btnKetThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                btnKetThucActionPerformed(evt);
            }
        });

        btnLogout.setBackground(new java.awt.Color(215, 215, 207));
        btnLogout.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(0, 51, 51));
        btnLogout.setIcon(new javax.swing.ImageIcon("D:\\FPT_POLY_IV\\DuAn1\\CodeHeThongDuAnBanGiay\\PRO1041_DuAn1_Nhom4_BanGiay\\PRO1041_DuAn1_Nhom4BanGiay\\src\\main\\resources\\icon\\Exit.png")); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblTitle.setText("6G SNEAKER");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnKhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)

                            .addComponent(btnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)

                            .addComponent(btnBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDoiTra, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()

                .addComponent(lblTitle)
                .addGap(41, 41, 41)
                .addComponent(btnKhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDoiTra, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))

        );

        jPanel1.add(jPanel2);

        jSplitPane1.setLeftComponent(jPanel1);

        pnlcards.setBackground(new java.awt.Color(51, 51, 51));
        pnlcards.setLayout(new java.awt.CardLayout());

        pnlMain.setBackground(new java.awt.Color(255, 204, 0));

        jLabel1.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Welcome Quản lý - ");

        txtTenQuanLy.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        txtTenQuanLy.setForeground(new java.awt.Color(0, 102, 102));
        txtTenQuanLy.setText("Ngô Vũ Ngọc Hào");

        jLabel17.setFont(new java.awt.Font("Serif", 1, 45)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 0));
        jLabel17.setText("Quản lý");

        jLabel18.setFont(new java.awt.Font("Serif", 1, 45)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 0));
        jLabel18.setText("Bán giày");

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Serif", 1, 45)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 0));
        jLabel19.setText("6G Sneaker");

        jLabel20.setFont(new java.awt.Font("Serif", 1, 45)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 102, 0));
        jLabel20.setText("Hệ thống ");

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addGroup(pnlMainLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTenQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGap(351, 351, 351)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(204, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(270, 270, 270))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTenQuanLy))
                .addGap(149, 149, 149)
                .addComponent(jLabel20)
                .addGap(37, 37, 37)
                .addComponent(jLabel17)
                .addGap(35, 35, 35)
                .addComponent(jLabel18)
                .addGap(36, 36, 36)
                .addComponent(jLabel19)
                .addContainerGap(175, Short.MAX_VALUE))
        );

        pnlcards.add(pnlMain, "card8");


        pnlKhachHang.setBackground(new java.awt.Color(0, 153, 153));
        pnlKhachHang.setForeground(new java.awt.Color(255, 255, 255));

        jPanel11.setBackground(new java.awt.Color(255, 204, 0));


        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        jLabel5.setText("Mã Khách Hàng");

        jLabel2.setText("Tên Khách Hàng");

        jLabel3.setText("Số điện thoại");

        btnUpdate.setText("Sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnAdd.setText("Thêm ");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        tblKhachHang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
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
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        jLabel17.setText("Khách hàng");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(98, 98, 98)
                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel11Layout.createSequentialGroup()

                        .addGap(58, 58, 58)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(258, Short.MAX_VALUE))

        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addGap(19, 19, 19)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenKH)
                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaKH))
                .addGap(40, 40, 40)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlKhachHangLayout = new javax.swing.GroupLayout(pnlKhachHang);
        pnlKhachHang.setLayout(pnlKhachHangLayout);
        pnlKhachHangLayout.setHorizontalGroup(
            pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlKhachHangLayout.setVerticalGroup(
            pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

        );

        pnlcards.add(pnlKhachHang, "cardKH");

        pnlNhanVien.setBackground(new java.awt.Color(255, 204, 0));

        btnUpdateNV.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdateNV.setForeground(new java.awt.Color(0, 153, 0));
        btnUpdateNV.setText("Update");
        btnUpdateNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateNVActionPerformed(evt);
            }
        });

        btnDeleteNV.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDeleteNV.setForeground(new java.awt.Color(0, 153, 0));
        btnDeleteNV.setText("Delete");
        btnDeleteNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteNVActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        jLabel4.setText("Họ Tên");

        btnClearNV.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClearNV.setForeground(new java.awt.Color(0, 153, 0));
        btnClearNV.setText("Clear");
        btnClearNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearNVActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        jLabel6.setText("Giới tính");

        tbHienThi.setModel(new javax.swing.table.DefaultTableModel(
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
        tbHienThi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHienThiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbHienThi);

        jLabel7.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        jLabel7.setText("Tài khoản");

        jLabel8.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        jLabel8.setText("Mật khẩu");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Chức Vụ");

        jLabel9.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        jLabel9.setText("Ngày sinh");

        cbbChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbChucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbChucVuActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        jLabel10.setText("Địa chỉ");

        jLabel11.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        jLabel11.setText("Sdt");

        txtMa.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N

        txtTimKiem1.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N

        txtTen.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N

        txtTaiKhoan.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N

        txtMatKhau.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N

        txtNgaySinh.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N

        txtDiaChi.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N

        txtSdtNV.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N

        radioNam.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        radioNam.setSelected(true);
        radioNam.setText("Nam");

        radioNu.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        radioNu.setText("Nữ");

        lbID.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        jLabel13.setText("Email");

        txtEmail.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jLabel14.setText("NHÂN VIÊN");

        btnAddNV.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddNV.setForeground(new java.awt.Color(0, 153, 0));
        btnAddNV.setText("Add");
        btnAddNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNVActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        jLabel15.setText("Id");

        jLabel16.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        jLabel16.setText("Mã");

        btnThemCV.setIcon(new javax.swing.ImageIcon("D:\\FPT_POLY_IV\\DuAn1\\CodeHeThongDuAnBanGiay\\PRO1041_DuAn1_Nhom4_BanGiay\\PRO1041_DuAn1_Nhom4BanGiay\\src\\main\\resources\\icon\\Add.png")); // NOI18N
        btnThemCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlNhanVienLayout = new javax.swing.GroupLayout(pnlNhanVien);
        pnlNhanVien.setLayout(pnlNhanVienLayout);
        pnlNhanVienLayout.setHorizontalGroup(
            pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNhanVienLayout.createSequentialGroup()
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                    .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel16)
                                        .addComponent(jLabel15))
                                    .addGap(31, 31, 31)
                                    .addComponent(lbID, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(103, 103, 103)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                        .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addComponent(radioNam)
                                .addGap(18, 18, 18)
                                .addComponent(radioNu))
                            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                        .addGap(145, 145, 145)
                                        .addComponent(lbTenCuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtMa, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))))
                            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel12)
                                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                        .addGap(121, 121, 121)
                                        .addComponent(btnUpdateNV))
                                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(cbbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnThemCV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbTenChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(5, 5, 5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8)
                        .addComponent(jLabel7))
                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                        .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDeleteNV)
                            .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10)
                                .addComponent(jLabel9)
                                .addComponent(jLabel11)
                                .addComponent(jLabel13)))
                        .addGap(4, 4, 4)))
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtSdtNV, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(btnClearNV)))
                .addGap(168, 168, 168))
            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                        .addGap(74, 74, 74)

                        .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)

                            .addComponent(btnAddNV)
                            .addComponent(txtTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        pnlNhanVienLayout.setVerticalGroup(
            pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(lbID, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel8)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioNam)
                    .addComponent(radioNu))
                .addGap(18, 18, 18)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                        .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtSdtNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                        .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbTenChucVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbChucVu, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThemCV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(lbTenCuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddNV)
                    .addComponent(btnUpdateNV)
                    .addComponent(btnDeleteNV)
                    .addComponent(btnClearNV))
                .addGap(29, 29, 29)
                .addComponent(txtTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)

                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addGap(68, 68, 68))

        );

        pnlcards.add(pnlNhanVien, "cardNV");

        pnlCTSP.setBackground(new java.awt.Color(255, 204, 0));

        lbl_ngayNhapHang.setText("Ngày nhập hàng");

        lbl_giaNhap.setText("Giá nhập ");

        lbl_giaBan.setText("Giá bán");

        lbl_soLuong.setText("Số lượng");

        lbl_xuatXu.setText("Xuất xứ");

        lbl_kichCo.setText("Kích cỡ");

        lbl_trangThai.setText("Trạng thái");

        tbl_CTSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ID", "Sản Phẩm", "Màu Sắc", "Đế Giày", "Dòng Sản Phẩm", "Ngày Nhập Hàng", "Đon giá", "Số Lượng", "Kích Cỡ", "Xuất Xứ", "Trạng Thái"
            }
        ));
        tbl_CTSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_CTSanPhamMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_CTSanPham);

        lbl_sanPham.setText("Sản phẩm");

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

        lbl_deGiay.setText("Đế giày");

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

        lbl_mauSac.setText("Màu sắc");

        lbl_dongSP.setText("Dòng sản phẩm");

        btnThemSP.setIcon(new javax.swing.ImageIcon("D:\\FPT_POLY_IV\\DuAn1\\CodeHeThongDuAnBanGiay\\PRO1041_DuAn1_Nhom4_BanGiay\\PRO1041_DuAn1_Nhom4BanGiay\\src\\main\\resources\\icon\\Add.png")); // NOI18N
        btnThemSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSPActionPerformed(evt);
            }
        });

        btnThemMS.setIcon(new javax.swing.ImageIcon("D:\\FPT_POLY_IV\\DuAn1\\CodeHeThongDuAnBanGiay\\PRO1041_DuAn1_Nhom4_BanGiay\\PRO1041_DuAn1_Nhom4BanGiay\\src\\main\\resources\\icon\\Add.png")); // NOI18N
        btnThemMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMSActionPerformed(evt);
            }
        });

        btnThemDG.setIcon(new javax.swing.ImageIcon("D:\\FPT_POLY_IV\\DuAn1\\CodeHeThongDuAnBanGiay\\PRO1041_DuAn1_Nhom4_BanGiay\\PRO1041_DuAn1_Nhom4BanGiay\\src\\main\\resources\\icon\\Add.png")); // NOI18N
        btnThemDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDGActionPerformed(evt);
            }
        });

        btnThemDSP.setIcon(new javax.swing.ImageIcon("D:\\FPT_POLY_IV\\DuAn1\\CodeHeThongDuAnBanGiay\\PRO1041_DuAn1_Nhom4_BanGiay\\PRO1041_DuAn1_Nhom4BanGiay\\src\\main\\resources\\icon\\Add.png")); // NOI18N
        btnThemDSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCTSPLayout = new javax.swing.GroupLayout(pnlCTSP);
        pnlCTSP.setLayout(pnlCTSPLayout);
        pnlCTSPLayout.setHorizontalGroup(
            pnlCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCTSPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(pnlCTSPLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(pnlCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_sanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_mauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_giaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_giaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_xuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_xuatXu, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                .addComponent(txt_soLuong)
                                .addComponent(txt_giaBan)
                                .addComponent(txt_giaNhap))
                            .addGroup(pnlCTSPLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlCTSPLayout.createSequentialGroup()
                                .addGroup(pnlCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbo_sanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbo_mauSac, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnThemSP, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnThemMS, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 265, Short.MAX_VALUE)
                        .addGroup(pnlCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCTSPLayout.createSequentialGroup()
                                .addGroup(pnlCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbl_deGiay)
                                        .addComponent(lbl_trangThai)
                                        .addComponent(lbl_ngayNhapHang)
                                        .addComponent(lbl_kichCo)))
                                .addGap(25, 25, 25))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCTSPLayout.createSequentialGroup()
                                .addComponent(lbl_dongSP)
                                .addGap(18, 18, 18)))
                        .addGroup(pnlCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbo_trangThai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlCTSPLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_kichCo, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_ngayNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlCTSPLayout.createSequentialGroup()
                                .addGroup(pnlCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbo_deGiay, javax.swing.GroupLayout.Alignment.LEADING, 0, 158, Short.MAX_VALUE)
                                    .addComponent(cbo_dongSanPham, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnThemDG, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnThemDSP, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(15, 15, 15))
                    .addGroup(pnlCTSPLayout.createSequentialGroup()
                        .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlCTSPLayout.setVerticalGroup(
            pnlCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCTSPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_sanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbo_sanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_deGiay, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbo_deGiay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnThemSP))
                    .addComponent(btnThemDG))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemMS)
                    .addGroup(pnlCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnThemDSP)
                        .addGroup(pnlCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbo_mauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_mauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbo_dongSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_dongSP, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_giaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_giaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_ngayNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_giaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_giaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ngayNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_kichCo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_kichCo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_xuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_xuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)

                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlcards.add(pnlCTSP, "cardCTSP");


        pnlBanHang.setBackground(new java.awt.Color(255, 204, 0));

        javax.swing.GroupLayout pnlBanHangLayout = new javax.swing.GroupLayout(pnlBanHang);
        pnlBanHang.setLayout(pnlBanHangLayout);
        pnlBanHangLayout.setHorizontalGroup(
            pnlBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 931, Short.MAX_VALUE)
        );
        pnlBanHangLayout.setVerticalGroup(
            pnlBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 724, Short.MAX_VALUE)

        );

        pnlcards.add(pnlBanHang, "cardBH");

        pnlDoiTra.setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout pnlDoiTraLayout = new javax.swing.GroupLayout(pnlDoiTra);
        pnlDoiTra.setLayout(pnlDoiTraLayout);
        pnlDoiTraLayout.setHorizontalGroup(
            pnlDoiTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 931, Short.MAX_VALUE)
        );

        pnlDoiTraLayout.setVerticalGroup(
            pnlDoiTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 724, Short.MAX_VALUE)

        );

        pnlcards.add(pnlDoiTra, "cardDoiTra");

        pnlThongKe.setBackground(new java.awt.Color(64, 182, 163));

        javax.swing.GroupLayout pnlThongKeLayout = new javax.swing.GroupLayout(pnlThongKe);
        pnlThongKe.setLayout(pnlThongKeLayout);
        pnlThongKeLayout.setHorizontalGroup(
            pnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 931, Short.MAX_VALUE)
        );

        pnlThongKeLayout.setVerticalGroup(
            pnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 724, Short.MAX_VALUE)

        );

        pnlcards.add(pnlThongKe, "cardTK");

        jSplitPane1.setRightComponent(pnlcards);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1187, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))

        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKhachhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachhangActionPerformed
        cardLayout.show(pnlcards, "cardKH");

    }//GEN-LAST:event_btnKhachhangActionPerformed

    private void btnNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienActionPerformed
        cardLayout.show(pnlcards, "cardNV");

    }//GEN-LAST:event_btnNhanVienActionPerformed

    private void btnSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSanPhamActionPerformed
        cardLayout.show(pnlcards, "cardCTSP");
    }//GEN-LAST:event_btnSanPhamActionPerformed

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        // TODO add your handling code here:
        cardLayout.show(pnlcards, "cardTK");
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void btnBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanHangActionPerformed
        // TODO add your handling code here:

        cardLayout.show(pnlcards, "cardBH");

    }//GEN-LAST:event_btnBanHangActionPerformed

    private void btnDoiTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiTraActionPerformed
        // TODO add your handling code here:

        cardLayout.show(pnlcards, "cardDoiTra");

    }//GEN-LAST:event_btnDoiTraActionPerformed

    private void btnKetThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetThucActionPerformed
        // TODO add your handling code here:
//        cardLayout.show(pnlcards, "card10");
        System.exit(0);
    }//GEN-LAST:event_btnKetThucActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        ViewLogin l = new ViewLogin();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed


    private void btnUpdateNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateNVActionPerformed
        // TODO add your handling code here:
        int row = tbHienThi.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng");
        } else {
            var temp = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn cập nhật");
            if (temp == 0) {
                NhanVienCustomModel nhanVien = listNhanVienCustom.get(row);
                String ma = nhanVien.getId();
                NhanVien nv = new NhanVien();
                nv.setMa(txtMa.getText());
                nv.setHoTen(txtTen.getText());
                nv.setTaiKhoan(txtTaiKhoan.getText());
                nv.setMatKhau(txtMatKhau.getText());
                nv.setDiaChi(txtDiaChi.getText());
                nv.setEmail(txtEmail.getText());
                nv.setSdt(txtSdt.getText());
                nv.setNgaySinh(Date.valueOf(txtNgaySinh.getText()));
                
                boolean gender = radioNam.isSelected();
                String gioiTinh;
                if (gender) {
                    gioiTinh = "Nam";
                } else {
                    gioiTinh = "Nữ";
                }
                String maCV = cbbChucVu.getSelectedItem().toString();
                ChucVu cv = chucVuService.getOne(maCV);
                nv.setCv(cv);
                nv.setGioiTinh(gioiTinh);
                JOptionPane.showMessageDialog(this, nhanVienServiceImpl.update(nv, ma));
                listNhanVienCustom = nhanVienServiceImpl.getAllCustom();
                showDataNV(listNhanVienCustom);
            }
        }
    }//GEN-LAST:event_btnUpdateNVActionPerformed

    private void btnDeleteNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteNVActionPerformed
        // TODO add your handling code here:
        int row = tbHienThi.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng");
        } else {
            var temp = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa");
            if (temp == 0) {
                NhanVienCustomModel kh = listNhanVienCustom.get(row);
                String ma = kh.getId();
                JOptionPane.showMessageDialog(this, nhanVienServiceImpl.delete(ma));
                listNhanVienCustom = nhanVienServiceImpl.getAllCustom();
                showDataNV(listNhanVienCustom);
            }
        }
    }//GEN-LAST:event_btnDeleteNVActionPerformed

    private void btnClearNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearNVActionPerformed
        // TODO add your handling code here:
        lbID.setText("");
        txtMa.setText("");
        txtTen.setText("");
        txtTaiKhoan.setText("");
        txtMatKhau.setText("");
        txtNgaySinh.setText("");
        txtDiaChi.setText("");
        txtSdt.setText("");
        txtEmail.setText("");
        radioNam.setSelected(true);
        cbbChucVu.setSelectedIndex(0);
    }//GEN-LAST:event_btnClearNVActionPerformed

    private void tbHienThiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHienThiMouseClicked
        // TODO add your handling code here:
        int row = tbHienThi.getSelectedRow();
        fillDataNV(row);
    }//GEN-LAST:event_tbHienThiMouseClicked

    private void cbbChucVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbChucVuActionPerformed
        // TODO add your handling code here:
        String maCH = cbbChucVu.getSelectedItem().toString();
        ChucVu cv = (ChucVu) chucVuService.getOne(maCH);
        lbTenChucVu.setText(cv.getTen());
    }//GEN-LAST:event_cbbChucVuActionPerformed

    private void btnAddNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNVActionPerformed
        // TODO add your handling code here:
        String ma = txtMa.getText();
        String ten = txtTen.getText();
        String tk = txtTaiKhoan.getText();
        String mk = txtMatKhau.getText();
        String sdt = txtSdt.getText();
        String diaChi = txtDiaChi.getText();
        String email = txtEmail.getText();
        String ngaySinh = txtNgaySinh.getText();
        boolean gender = radioNam.isSelected();
        String gioiTinh = "";
        if (gender) {
            gioiTinh = "Nam";
        } else {
            gioiTinh = "Nữ";
        }
        String maCV = cbbChucVu.getSelectedItem().toString();
        ChucVu cv = (ChucVu) chucVuService.getOne(maCV);
        
        boolean trung = false;
        for (NhanVienCustomModel x : listNhanVienCustom) {
            if (x.getMa().contains(ma)) {
                trung = true;
            }
        }
        if (CheckDL() == false) {
            if (trung) {
                JOptionPane.showMessageDialog(this, "Mã không được trùng, vui lòng nhập lại");
            } else {
                var temp = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thêm mới");
                if (temp == 0) {
                    NhanVien nv = new NhanVien(cv, ma, ten, tk, mk, sdt, email, gioiTinh, Date.valueOf(ngaySinh), diaChi);
                    JOptionPane.showMessageDialog(this, nhanVienServiceImpl.add(nv));
                    listNhanVienCustom = nhanVienServiceImpl.getAllCustom();
                    showDataNV(listNhanVienCustom);
                }
            }
        }
    }//GEN-LAST:event_btnAddNVActionPerformed

    private void tbl_CTSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_CTSanPhamMouseClicked
        // TODO add your handling code here:
        var row = tbl_CTSanPham.getSelectedRow();
        click = tbl_CTSanPham.getModel().getValueAt(row, 1).toString();
        var temp = chiTietSanPhamService.getById(click);
        cbo_sanPham.setSelectedItem(temp.getTenSP());
        cbo_mauSac.setSelectedItem(temp.getTenMauSac());
        cbo_deGiay.setSelectedItem(temp.getTenDeGiay());
        cbo_dongSanPham.setSelectedItem(temp.getTenDongSP());
//        cbo_nhaCungCap.setSelectedItem(temp.getTenNhaCC());
        txt_ngayNhapHang.setText(temp.getNgayNhapHang());
        txt_giaNhap.setText(String.valueOf(temp.getGiaNhap()));
        txt_giaBan.setText(String.valueOf(temp.getGiaBan()));
        txt_soLuong.setText(String.valueOf(temp.getSoLuong()));
        txt_kichCo.setText(temp.getKichCo());
        txt_xuatXu.setText(temp.getXuatXu());
        cbo_trangThai.setSelectedIndex(temp.getTrangThai());
    }//GEN-LAST:event_tbl_CTSanPhamMouseClicked

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
        if (checkDL() == false) {
            var temp = JOptionPane.showConfirmDialog(this, "Bạn có chăc muốn thêm mới không ?");
            if (temp == 0) {
                JOptionPane.showMessageDialog(this, chiTietSanPhamService.add(getForm()));
                loadTable(null);
            }
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        // TODO add your handling code here:
        if (checkDL() == false) {
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
//        cbo_nhaCungCap.setSelectedIndex(0);
        txt_ngayNhapHang.setText(null);
        txt_giaNhap.setText(null);
        txt_giaBan.setText(null);
        txt_soLuong.setText(null);
        txt_kichCo.setText(null);
        txt_xuatXu.setText(null);
        cbo_trangThai.setSelectedIndex(0);
    }//GEN-LAST:event_btn_clearActionPerformed

    private void txt_timKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_timKiemCaretUpdate
        // TODO add your handling code here:
        if (txt_timKiem.getText().isEmpty()) {
            loadTable("Tìm Kiếm...");
        }
        loadTable(txt_timKiem.getText());
    }//GEN-LAST:event_txt_timKiemCaretUpdate

    private void txt_timKiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_timKiemFocusGained
        // TODO add your handling code here:
        txt_timKiem.setText("");
    }//GEN-LAST:event_txt_timKiemFocusGained

    private void txt_timKiemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_timKiemFocusLost
        // TODO add your handling code here:
        txt_timKiem.setText("Tìm Kiếm...");
    }//GEN-LAST:event_txt_timKiemFocusLost

    private void txt_ngayNhapHangFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_ngayNhapHangFocusGained
        // TODO add your handling code here:
        txt_ngayNhapHang.setText("");
    }//GEN-LAST:event_txt_ngayNhapHangFocusGained

    private void txt_ngayNhapHangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_ngayNhapHangFocusLost
        // TODO add your handling code here:
        txt_ngayNhapHang.setText(java.time.LocalDate.now() + "");
    }//GEN-LAST:event_txt_ngayNhapHangFocusLost

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtMaKH.setText("");
        txtTenKH.setText("");
        txtTimKiem.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        int row = tblKhachHang.getSelectedRow();
        fillData(row);
    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String ma = txtMaKH.getText();
        if (ma.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã không được để trống");
        } else {
            JOptionPane.showMessageDialog(this, khs.delete(ma));
            showData(listKHCM = khs.getAllCustom());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String ma = txtMaKH.getText();
        String ten = txtTenKH.getText();
        String sdt = txtSdt.getText();
        
        boolean trung = false;
        for (KhachHang cv : listKH) {
            if (cv.getMa().contains(ma)) {
                trung = true;
            }
        }
        if (ma.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã không được để trống");
        } else if (ten.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên không được để trống");
        } else if (sdt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống");
        } else if (trung) {
            JOptionPane.showMessageDialog(this, "Mã không được để trùng");
        } else {
            KhachHang kh = new KhachHang(ma, ten, sdt);
            JOptionPane.showMessageDialog(this, khs.add(kh));
            showData(listKHCM = khs.getAllCustom());
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String ma = txtMaKH.getText();
        String ten = txtTenKH.getText();
        String sdt = txtSdt.getText();
        
        if (ma.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã không được để trống");
        } else if (ten.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên không được để trống");
        } else if (sdt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống");
        } else {
            KhachHang kh = new KhachHang(ma, ten, sdt);
            JOptionPane.showMessageDialog(this, khs.update(kh, ma));
            showData(listKHCM = khs.getAllCustom());
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        String ten = txtTimKiem.getText();
        if (ten.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên tìm kiếm không được để trống");
        } else {
            
            List<KhachHangCustomModel> listNew = khs.Search(ten);
            showData(listNew);
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnThemCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCVActionPerformed
        ViewChucVu vcv = new ViewChucVu();
        vcv.setVisible(true);
        

    }//GEN-LAST:event_btnThemCVActionPerformed

    private void btnThemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSPActionPerformed
        ViewSanPham vsp = new ViewSanPham();
        vsp.setVisible(true);
    }//GEN-LAST:event_btnThemSPActionPerformed

    private void btnThemMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMSActionPerformed
        ViewMauSac vms = new ViewMauSac();
        vms.setVisible(true);
    }//GEN-LAST:event_btnThemMSActionPerformed

    private void btnThemDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDGActionPerformed
        ViewDeGiay vdg = new ViewDeGiay();
        vdg.setVisible(true);

    }//GEN-LAST:event_btnThemDGActionPerformed

    private void btnThemDSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDSPActionPerformed
        ViewDongSp vdsp = new ViewDongSp();
        vdsp.setVisible(true);
    }//GEN-LAST:event_btnThemDSPActionPerformed

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
            java.util.logging.Logger.getLogger(HomeQuanLyBG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeQuanLyBG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeQuanLyBG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeQuanLyBG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeQuanLyBG().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddNV;
    private javax.swing.JButton btnBanHang;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClearNV;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeleteNV;
    private javax.swing.JButton btnDoiTra;

    private javax.swing.JButton btnKetThuc;
    private javax.swing.JButton btnKhachhang;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnNhanVien;

    private javax.swing.JButton btnSanPham;
    private javax.swing.JButton btnThemCV;
    private javax.swing.JButton btnThemDG;
    private javax.swing.JButton btnThemDSP;
    private javax.swing.JButton btnThemMS;
    private javax.swing.JButton btnThemSP;

    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdateNV;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbChucVu;
    private javax.swing.JComboBox<String> cbo_deGiay;
    private javax.swing.JComboBox<String> cbo_dongSanPham;
    private javax.swing.JComboBox<String> cbo_mauSac;
    private javax.swing.JComboBox<String> cbo_sanPham;
    private javax.swing.JComboBox<String> cbo_trangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;

    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;

    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbTenChucVu;
    private javax.swing.JLabel lbTenCuaHang;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lbl_deGiay;
    private javax.swing.JLabel lbl_dongSP;
    private javax.swing.JLabel lbl_giaBan;
    private javax.swing.JLabel lbl_giaNhap;
    private javax.swing.JLabel lbl_kichCo;
    private javax.swing.JLabel lbl_mauSac;
    private javax.swing.JLabel lbl_ngayNhapHang;
    private javax.swing.JLabel lbl_sanPham;
    private javax.swing.JLabel lbl_soLuong;
    private javax.swing.JLabel lbl_trangThai;
    private javax.swing.JLabel lbl_xuatXu;
    private javax.swing.JPanel pnlBanHang;
    private javax.swing.JPanel pnlCTSP;
    private javax.swing.JPanel pnlDoiTra;
    private javax.swing.JPanel pnlKhachHang;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlNhanVien;
    private javax.swing.JPanel pnlThongKe;
    private javax.swing.JPanel pnlcards;
    private javax.swing.JRadioButton radioNam;
    private javax.swing.JRadioButton radioNu;
    private javax.swing.JTable tbHienThi;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTable tbl_CTSanPham;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtSdtNV;
    private javax.swing.JTextField txtTaiKhoan;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JLabel txtTenQuanLy;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTimKiem1;
    private javax.swing.JTextField txt_giaBan;
    private javax.swing.JTextField txt_giaNhap;
    private javax.swing.JTextField txt_kichCo;
    private javax.swing.JTextField txt_ngayNhapHang;
    private javax.swing.JTextField txt_soLuong;
    private javax.swing.JTextField txt_timKiem;
    private javax.swing.JTextField txt_xuatXu;
    // End of variables declaration//GEN-END:variables
}
