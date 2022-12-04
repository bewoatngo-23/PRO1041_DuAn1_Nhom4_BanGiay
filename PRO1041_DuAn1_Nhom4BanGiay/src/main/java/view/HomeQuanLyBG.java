/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import customModel.DeGiayCustomModel;
import customModel.DongSanPhamCustomModel;
import customModel.HDCTCustoModelHD;
import customModel.HoaDonChiTietCustomModel;
import customModel.HoaDonCustomModel;
import customModel.HoaDonCustomModelHD;
import customModel.KhachHangCustomModel;
import customModel.MauSacCustomModel;
import customModel.NhanVienCustomModel;
import customModelBanHang.GioHangViewModel;
import customModelBanHang.HoaDonViewModel;
import customModelBanHang.SanPhamViewModel;
import customModelDoiTra.DoiTraCustomModel;
import customModelDoiTra.HDCTDoiTraCustomModel;
import customModelDoiTra.HoaDonDoiTraCustomModel;
import domainModel.ChiTietSanPhamHiber;
import domainModel.ChucVu;
import domainModel.KhachHang;
import domainModel.NhanVien;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
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
import service.impl.BanHangServiceImpl;
import service.impl.ChiTietSanPhamServiceImpl;
import service.impl.ChucVuServiceImpl;
import service.impl.DeGiayServiecImpl;
import service.impl.DoiTraServiceImpl;
import service.impl.DongSPHiberServiceImpl;
import service.impl.DongSPServiceImpl;
import service.impl.HoaDonHDServiceImpl;
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
public class HomeQuanLyBG extends javax.swing.JFrame implements Runnable, ThreadFactory {

    private DefaultTableModel tblmodel = new DefaultTableModel();
    private List<KhachHang> listKH = new ArrayList<>();
    private List<KhachHangCustomModel> listKHCM = new ArrayList<>();
    private KhachHangServiceImpl khs = new KhachHangServiceImpl();
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
    private DefaultTableModel tblModelHoaDonBH = new DefaultTableModel();
    private DefaultTableModel tblModelHDCTBH = new DefaultTableModel();
    private List<HoaDonCustomModelHD> listHD = new ArrayList<>();
    private List<HDCTCustoModelHD> listHDCT = new ArrayList<>();
    private HoaDonHDServiceImpl hds = new HoaDonHDServiceImpl();
    private DefaultTableModel tblModelHoaDon = new DefaultTableModel();
    private DefaultTableModel tblModelGioHang = new DefaultTableModel();
    private DefaultComboBoxModel cbbModelNV = new DefaultComboBoxModel();
    private DefaultComboBoxModel cbbModelKH = new DefaultComboBoxModel();
    private DefaultTableModel tblModelSanPham = new DefaultTableModel();
    private DefaultTableModel tblModelVoucher = new DefaultTableModel();
    private List<HoaDonViewModel> listHoaDons = new ArrayList<>();
    private List<SanPhamViewModel> listSanPhams = new ArrayList<>();
    private List<SanPhamViewModel> listSoLuong = new ArrayList<>();
    private List<GioHangViewModel> listGioHangS = new ArrayList<>();
    private List<NhanVienCustomModel> listNV = new ArrayList<>();
//    private List<KhachHangCustomModel> listKHBH = new ArrayList<>();
    private List<HoaDonCustomModel> listFullHD = new ArrayList<>();
    private List<DeGiayCustomModel> ListDG = new ArrayList<>();
    private List<DongSanPhamCustomModel> listDSP = new ArrayList<>();
    private List<MauSacCustomModel> listMS = new ArrayList<>();
    private BanHangServiceImpl bhs = new BanHangServiceImpl();
    private NhanVienServiceImpl nvs = new NhanVienServiceImpl();
//    private KhachHangServiceImpl khsbh = new KhachHangServiceImpl();
    private WebcamPanel panel = null;
    private Webcam webcam = null;
    private Executor executor = Executors.newSingleThreadExecutor(this);
    private DefaultTableModel tblModelHDDT = new DefaultTableModel();
    private DefaultTableModel tblModelHDCTDT = new DefaultTableModel();
    private DefaultTableModel tblModelDoiTra = new DefaultTableModel();
    private List<HoaDonDoiTraCustomModel> listHDDT = new ArrayList<>();
    private List<HDCTDoiTraCustomModel> listHDCTDT = new ArrayList<>();
    private List<DoiTraCustomModel> listDoiTra = new ArrayList<>();
    private DoiTraServiceImpl dts = new DoiTraServiceImpl();
    private final JPopupMenu ppMenu = new JPopupMenu();
    private JMenuItem mnItem = null;
    String soLuongDTBH = "";
    private utilities.Utility uti = new Utility();
    private CardLayout cardLayout;

    public HomeQuanLyBG() {
        initComponents();
        cardLayout = (CardLayout) (pnlcards.getLayout());
        tblKhachHang.setModel(tblmodel);
        String headerKH[] = {"STT", "Mã", "HọTên", "Sđt"};
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
        txt_giaBan.requestFocus();
        String headersss[] = {"Mã hóa đơn", "Mã nhân viên", "Tên nhân viên", "Mã khách hàng", "Tên khách hàng", "Tổng tiền", "Tổng sản phẩm", "Trạng Thái"};
        tblModelHoaDonBH.setColumnIdentifiers(headersss);
        String headers[] = {"Mã Sản phẩm", "Tên Sản phẩm", "Số lượng", "Đon giá", "Thành tiền"};
        tblModelHDCTBH.setColumnIdentifiers(headers);
        tblHoaDonBanHang.setModel(tblModelHoaDonBH);
        tblHoaDonChiTietBH.setModel(tblModelHDCTBH);
        listHD = hds.getHoaDon();
        showDataHD(listHD);
        loadCBB();
        loadTable(null);
        initWedcam();
        String headerHDBH[] = {"Mã HĐ", "Ngày tạo", "Nhân viên tạo", "Khách hàng", "Tình trạng"};
        tblModelHoaDon.setColumnIdentifiers(headerHDBH);
        String headerHDCTBH[] = {"Mã SP", "Tên SP", "Số luọng", "Đon giá",};
        tblModelGioHang.setColumnIdentifiers(headerHDCTBH);
        String headerSPBH[] = {"Mã SP", "Tên SP", "Dòng sản phẩm", "Đế giày", "Mau sắc", "Đơn giá", "Số lượng", "Xuất xứ", "Size"};
        tblModelSanPham.setColumnIdentifiers(headerSPBH);
        tblHoaDon.setModel(tblModelHoaDon);
        tblGioHang.setModel(tblModelGioHang);
        tblSanPham.setModel(tblModelSanPham);
        listSanPhams = bhs.getSanPhamVM();
        listHoaDons = bhs.getHoaDon();
        listFullHD = bhs.getHoaDonFull();

        ListDG = deGiayService.getAll(null);
        listDSP = dongSPService.getAllCustom();
        listMS = mauSacService.getAllCustom();
        AutoCompleteDecorator.decorate(cbbNhanVienBH);
        AutoCompleteDecorator.decorate(cbbSoDienThoai);
        listNV = nvs.getAllCustomByMaNV();
        listNV.forEach((nv) -> {
            cbbNhanVienBH.addItem(nv.getHoTen());
        });
        cbbNhanVienBH.setSelectedItem("Tên nhân viên");

        listKHCM = khs.getAllCustom();
        listKHCM.forEach((kh) -> {
            cbbSoDienThoai.addItem(kh.getSdt());
        });
        cbbSoDienThoai.setSelectedItem("84+");
        showDataSanPham(listSanPhams);
        loadDataHoaDon(listHoaDons);
//        cbbDSPBH.removeAllItems();
//        cbbDGBH.removeAllItems();
//        cbbMSBH.removeAllItems();

        // trang thai taoHoaDon
        if (demTrangThai() > 4) {
            btnTaoHoaDon.setEnabled(false);
        }
        //Enter txt tiền khách đưa --> tiền thừa
        Action action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double thanhToan = Double.valueOf(lblThanhToan.getText());
                String tienKhachDua = txtTienKhachDua.getText();
                Double tienThua = 0.0;
                if (tienKhachDua == "0" || tienKhachDua.isEmpty()) {
                    tienThua = 0.0;
                } else {
                    tienThua = Double.valueOf(tienKhachDua) - thanhToan;
                }
                lblTienThua.setText(String.valueOf(tienThua));
            }
        };
        txtTienKhachDua.addActionListener(action);
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
        String headerVC[] = {"Mã Voucher", "Chương trình", "Giảm giá", "Ngày bắt đầu", "Ngày kết thức", "Trạng thái", "Ghi chú"};
        tblVoucher.setModel(tblModelVoucher);
        tblModelVoucher.setColumnIdentifiers(headerVC);
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

    private void initWedcam() {
        java.awt.Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0);
        webcam.setViewSize(size);
        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);
        pnlWebcam.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 170));
        executor.execute(this);
    }

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(HomeQuanLyBG.class.getName()).log(Level.SEVERE, null, ex);
            }
            Result result = null;
            BufferedImage image = null;
            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            }
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bb = new BinaryBitmap(new HybridBinarizer(source));

            try {
                result = new MultiFormatReader().decode(bb);
            } catch (NotFoundException ex) {
                Logger.getLogger(ViewBanHang.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (result != null) {
//                txtTimKiemDSSP.setText(result.getText());
                JOptionPane.showMessageDialog(this, "Sản phẩm: " + result.getText());
                listSanPhams = bhs.SearchSPBH(result.getText());
                showDataSanPham(listSanPhams);

            }
        } while (true);
    }

    //Load Table
    private void loadDataHoaDon(List<HoaDonViewModel> listHoaDons) {
        tblModelHoaDon.setRowCount(0);

        for (HoaDonViewModel listHoaDon : listHoaDons) {

            tblModelHoaDon.addRow(listHoaDon.toRowDataHD());
        }
    }

    private void showDataSanPham(List<SanPhamViewModel> listSanPhams) {
        tblModelSanPham.setRowCount(0);

        for (SanPhamViewModel sp : listSanPhams) {

            tblModelSanPham.addRow(sp.todataRowSanPham());
        }

    }

    private void showDataGioHang(List<GioHangViewModel> listGioHangS) {

        tblModelGioHang.setRowCount(0);
        for (GioHangViewModel gh : listGioHangS) {

            tblModelGioHang.addRow(gh.todataRow());
        }

    }
    // Fill data 

    private void fillDataHD(int index) {
        HoaDonViewModel hd = listHoaDons.get(index);
        lblMaHD.setText(hd.getMa());
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
        cbbNhanVienBH.setSelectedItem(hd.getNv());
        cbbSoDienThoai.setSelectedItem(hd.getSdt());
        lblNgayTao.setText(sdf.format(hd.getNgayTao()));

    }

    //Fill data txtTenKhachHang từ cbbSDT
//    private void fillDataKH(int index2) {
//        KhachHangCustomModel kh = listKH.get(index2);
//        txtTenKhachHangBH.setText(kh.getHoTen());
//    }
    // Đếm trạng thái chờ sét btnTaoHoaDon
    public int demTrangThai() {
        int a = 0;
        for (HoaDonViewModel x : listHoaDons) {
            if (x.getTrangThai() == 1) {
                x.getTrangThai();
                a++;
            }
        }
        return a;
    }

    private void showDataHD(List<HoaDonCustomModelHD> lists) {
        tblModelHoaDonBH.setRowCount(0);
        for (HoaDonCustomModelHD x : lists) {
            tblModelHoaDonBH.addRow(x.toRowData());
        }
    }

    private void showDataHDCT(List<HDCTCustoModelHD> listss) {
        tblModelHDCTBH.setRowCount(0);
        for (HDCTCustoModelHD x : listss) {
            tblModelHDCTBH.addRow(x.toRowData());
        }
    }

    private void showData(List<KhachHangCustomModel> lists) {
        tblmodel.setRowCount(0);
        int i = 1;
        for (KhachHangCustomModel kh : lists) {
            Object[] data = new Object[]{
                i++, kh.getMa(), kh.getHoTen(), kh.getSdt()
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
    //vu_ctsp
    private String click;

    public void loadTable(String input) {
        DefaultTableModel mol = (DefaultTableModel) tbl_CTSanPham.getModel();
        mol.setRowCount(0);
        int stt = 1;
        for (var x : chiTietSanPhamService.getAllCustomModel(input)) {
            mol.addRow(new Object[]{
                stt++,
                x.getMaSP(),
                x.getTenSP(),
                x.getTenMauSac(),
                x.getTenDeGiay(),
                x.getTenDongSP(),
                x.getNgayNhapHang(),
                x.getDonGia(),
                x.getSoLuong(),
                x.getKichCo(),
                x.getXuatXu(),
                x.getTrangThai() == 0 ? "Đang Bán" : "Dừng Bán"

            });
        }
    }

    public void loadTableByGia(String batDau, String ketThuc) {
        DefaultTableModel mol = (DefaultTableModel) tbl_CTSanPham.getModel();
        mol.setRowCount(0);
        int stt = 1;
        for (var x : chiTietSanPhamService.getAllBetWeen(batDau, ketThuc)) {
            mol.addRow(new Object[]{
                stt++,
                x.getMaSP(),
                x.getTenSP(),
                x.getTenMauSac(),
                x.getTenDeGiay(),
                x.getTenDongSP(),
                x.getNgayNhapHang(),
                x.getDonGia(),
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
        AutoCompleteDecorator.decorate(cbo_deGiay);
        //cbo_deGiay.setSelectedIndex(0);

        cbo_dongSanPham.removeAllItems();
        for (var x : dongSPService.getAll()) {
            cbo_dongSanPham.addItem(x.getTen());
        }
        AutoCompleteDecorator.decorate(cbo_dongSanPham);
        //cbo_dongSanPham.setSelectedIndex(0);

        cbo_mauSac.removeAllItems();
        for (var x : mauSacService.getAll()) {
            cbo_mauSac.addItem(x.getTen());
        }
        AutoCompleteDecorator.decorate(cbo_mauSac);
        //cbo_mauSac.setSelectedIndex(0);

        cbo_sanPham.removeAllItems();
        for (var x : sanPhamService.getAll()) {
            cbo_sanPham.addItem(x.getTen());
        }
        AutoCompleteDecorator.decorate(cbo_sanPham);
        //cbo_sanPham.setSelectedIndex(0);

        cbo_trangThai.removeAllItems();
        cbo_trangThai.addItem("Đang Bán");
        cbo_trangThai.addItem("Dừng Bán");
        cbo_trangThai.setSelectedIndex(0);

        cbo_locDeGiay.removeAllItems();
        for (DeGiayCustomModel x : deGiayService.getAll(null)) {
            cbo_locDeGiay.addItem(x.getTen());
        }

        cbo_locDongSP.removeAllItems();
        for (var x : dongSPService.getAll()) {
            cbo_locDongSP.addItem(x.getTen());
        }

        cbo_locMauSac.removeAllItems();
        for (var x : mauSacService.getAll()) {
            cbo_locMauSac.addItem(x.getTen());
        }

        cbo_locGia.removeAllItems();
        cbo_locGia.addItem("100000 - 500000");
        cbo_locGia.addItem("500000 - 1000000");
        cbo_locGia.addItem("1000000 - 3000000");
        cbo_locGia.addItem("3000000 - 5000000");
        cbo_locGia.addItem("5000000 - 7000000");
        cbo_locGia.addItem("7000000 - 10000000");

    }

    public ChiTietSanPhamHiber getForm() {
        return new ChiTietSanPhamHiber(null,
                sanPhamHiberService.getByIndex(cbo_sanPham.getSelectedIndex()),
                dongSPHiberService.getByIndex(cbo_dongSanPham.getSelectedIndex()),
                deGiayService.getDeGiayHiberbyIndex(cbo_deGiay.getSelectedIndex()),
                mauSacHiberService.getByIndex(cbo_mauSac.getSelectedIndex()),
                txt_ngayNhapHang.getText(),
                Double.parseDouble(txt_giaBan.getText()),
                Integer.parseInt(txt_soLuong.getText()),
                txt_xuatXu.getText(),
                txt_kichCo.getText(),
                cbo_trangThai.getSelectedIndex());
    }

    public boolean checkDL() {
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

        if (uti.DemChuoi(txt_giaBan.getText()) > 20) {
            JOptionPane.showMessageDialog(this, "Giá Bán không lớn hơn 20 ký tự");
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

        if (uti.DemChuoi(txt_soLuong.getText()) > 10) {
            JOptionPane.showMessageDialog(this, "Số lượng không lớn hơn 10 ký tự");
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

        if (uti.DemChuoi(txt_xuatXu.getText()) > 50) {
            JOptionPane.showMessageDialog(this, "Xuất xứ không lớn hơn 50 ký tự");
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

        if (uti.DemChuoi(txt_kichCo.getText()) > 20) {
            JOptionPane.showMessageDialog(this, "Kích cỡ không lớn hơn 20 ký tự");
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
        btnHoaDonBanHang = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        btnKetThuc = new javax.swing.JButton();
        btnVoucher = new javax.swing.JButton();
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
        txtTimKiemKH = new javax.swing.JTextField();
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
        jLabel21 = new javax.swing.JLabel();
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
        txtTimKiemNV = new javax.swing.JTextField();
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
        pnlBanHang = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtHoaDonPDF = new javax.swing.JTextArea();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        btnXoaSanPham = new javax.swing.JButton();
        btnCapNhatSP = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        txtTimKiemDSSP = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        cbbDSPBH = new javax.swing.JComboBox<>();
        cbbDGBH = new javax.swing.JComboBox<>();
        cbbMSBH = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        btnThayDoi = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        cbbNhanVienBH = new javax.swing.JComboBox<>();
        btnThemKHBH = new javax.swing.JButton();
        btnReloadBH = new javax.swing.JButton();
        cbbSoDienThoai = new javax.swing.JComboBox<>();
        txtTenKhachHangBH = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        labelTT = new javax.swing.JLabel();
        lblGiamGia = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        btnHuyHoaDon = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        lblMaHD = new javax.swing.JLabel();
        lblNgayTao = new javax.swing.JLabel();
        lblThanhTien = new javax.swing.JLabel();
        lblThanhToan = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        txtGiamGia = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        lblTienThua = new javax.swing.JLabel();
        btnTaoHoaDon = new javax.swing.JButton();
        pnlWebcam = new javax.swing.JPanel();
        pnlDoiTra = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        btnDoiSanPham = new javax.swing.JButton();
        lblTenKHDoiTra = new javax.swing.JLabel();
        lblMaHDDoiTra = new javax.swing.JLabel();
        lblNgaDoiHangDT = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        jLabel52 = new javax.swing.JLabel();
        cbbLiDoDoi = new javax.swing.JComboBox<>();
        jLabel53 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        txtTimKiemDoiTra = new javax.swing.JTextField();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblHoaDonDoiTra = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblDoiTra = new javax.swing.JTable();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tblHDCTDoiTra = new javax.swing.JTable();
        pnlThongKe = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel66 = new javax.swing.JLabel();
        pnlSanPhamChiTiet = new javax.swing.JPanel();
        lbl_ngayNhapHang = new javax.swing.JLabel();
        lbl_locMauSac = new javax.swing.JLabel();
        txt_giaBan = new javax.swing.JTextField();
        lbl_locDeGiay = new javax.swing.JLabel();
        lbl_giaBan = new javax.swing.JLabel();
        cbo_locDeGiay = new javax.swing.JComboBox<>();
        lbl_soLuong = new javax.swing.JLabel();
        lbl_locDongSP = new javax.swing.JLabel();
        lbl_xuatXu = new javax.swing.JLabel();
        lbl_kichCo = new javax.swing.JLabel();
        cbo_locDongSP = new javax.swing.JComboBox<>();
        lbl_locGiaBan = new javax.swing.JLabel();
        lbl_trangThai = new javax.swing.JLabel();
        cbo_locGia = new javax.swing.JComboBox<>();
        txt_soLuong = new javax.swing.JTextField();
        txt_xuatXu = new javax.swing.JTextField();
        txt_kichCo = new javax.swing.JTextField();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_CTSanPham = new javax.swing.JTable();
        btn_xoa = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        lbl_sanPham = new javax.swing.JLabel();
        txt_timKiem = new javax.swing.JTextField();
        cbo_sanPham = new javax.swing.JComboBox<>();
        cbo_trangThai = new javax.swing.JComboBox<>();
        lbl_deGiay = new javax.swing.JLabel();
        cbo_deGiay = new javax.swing.JComboBox<>();
        txt_ngayNhapHang = new javax.swing.JTextField();
        btn_themSP = new javax.swing.JButton();
        cbo_dongSanPham = new javax.swing.JComboBox<>();
        btn_themMS = new javax.swing.JButton();
        cbo_mauSac = new javax.swing.JComboBox<>();
        btn_themDG1 = new javax.swing.JButton();
        lbl_mauSac = new javax.swing.JLabel();
        btn_themDSP1 = new javax.swing.JButton();
        lbl_dongSP = new javax.swing.JLabel();
        cbo_locMauSac = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        btnReloadCTSP = new javax.swing.JButton();
        pnlHoaDon = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHoaDonChiTietBH = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        txtTimKiemHoaDon = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        cbbLocTrangThaiHD = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblHoaDonBanHang = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        pnlVoucher = new javax.swing.JPanel();
        btnClearVoucher = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        txtNgayBatDau = new com.toedter.calendar.JDateChooser();
        txtNgayHetHan = new com.toedter.calendar.JDateChooser();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel70 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        txtGhiChuVoucher = new javax.swing.JTextArea();
        btnSuaVoucher = new javax.swing.JButton();
        jLabel71 = new javax.swing.JLabel();
        btnThemVoucher = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        txtMaVoucher = new javax.swing.JTextField();
        txtTenVoucher = new javax.swing.JTextField();
        cbbMucGiamGia = new javax.swing.JComboBox<>();
        jPanel23 = new javax.swing.JPanel();
        txtTimKiemVoucher = new javax.swing.JTextField();
        jScrollPane15 = new javax.swing.JScrollPane();
        tblVoucher = new javax.swing.JTable();
        jLabel75 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1400, 724));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(204, 0, 0));

        btnKhachhang.setBackground(new java.awt.Color(255, 255, 255));
        btnKhachhang.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        btnKhachhang.setForeground(new java.awt.Color(46, 128, 99));
        btnKhachhang.setText("Khách hàng");
        btnKhachhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachhangActionPerformed(evt);
            }
        });

        btnNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        btnNhanVien.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        btnNhanVien.setForeground(new java.awt.Color(46, 128, 99));
        btnNhanVien.setText("Nhân viên");
        btnNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienActionPerformed(evt);
            }
        });

        btnSanPham.setBackground(new java.awt.Color(255, 255, 255));
        btnSanPham.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        btnSanPham.setForeground(new java.awt.Color(46, 128, 99));
        btnSanPham.setText("Sản phẩm");
        btnSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSanPhamActionPerformed(evt);
            }
        });

        btnThongKe.setBackground(new java.awt.Color(255, 255, 255));
        btnThongKe.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        btnThongKe.setForeground(new java.awt.Color(46, 128, 99));
        btnThongKe.setText("Thống Kê");
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        btnBanHang.setBackground(new java.awt.Color(255, 255, 255));
        btnBanHang.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        btnBanHang.setForeground(new java.awt.Color(46, 128, 99));
        btnBanHang.setText("Bán hàng");
        btnBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanHangActionPerformed(evt);
            }
        });

        btnDoiTra.setBackground(new java.awt.Color(255, 255, 255));
        btnDoiTra.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        btnDoiTra.setForeground(new java.awt.Color(46, 128, 99));
        btnDoiTra.setText("Đổi trả");
        btnDoiTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiTraActionPerformed(evt);
            }
        });

        btnHoaDonBanHang.setBackground(new java.awt.Color(255, 255, 255));
        btnHoaDonBanHang.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        btnHoaDonBanHang.setForeground(new java.awt.Color(46, 128, 99));
        btnHoaDonBanHang.setText("Hóa đơn");
        btnHoaDonBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonBanHangActionPerformed(evt);
            }
        });

        btnLogout.setBackground(new java.awt.Color(255, 255, 255));
        btnLogout.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(46, 128, 99));
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        lblTitle.setBackground(new java.awt.Color(255, 255, 255));
        lblTitle.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("6G SNEAKER");

        btnKetThuc.setBackground(new java.awt.Color(255, 255, 255));
        btnKetThuc.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        btnKetThuc.setForeground(new java.awt.Color(46, 128, 99));
        btnKetThuc.setText("Kết thúc");
        btnKetThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetThucActionPerformed(evt);
            }
        });

        btnVoucher.setBackground(new java.awt.Color(255, 255, 255));
        btnVoucher.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        btnVoucher.setForeground(new java.awt.Color(46, 128, 99));
        btnVoucher.setText("Voucher");
        btnVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoucherActionPerformed(evt);
            }
        });

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
                            .addComponent(btnHoaDonBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(41, 41, 41)
                .addComponent(btnKhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnDoiTra, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnHoaDonBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel1.add(jPanel2);

        jSplitPane1.setLeftComponent(jPanel1);

        pnlcards.setBackground(new java.awt.Color(51, 51, 51));
        pnlcards.setPreferredSize(new java.awt.Dimension(1171, 724));
        pnlcards.setLayout(new java.awt.CardLayout());

        pnlMain.setBackground(new java.awt.Color(255, 255, 255));
        pnlMain.setPreferredSize(new java.awt.Dimension(1148, 724));

        jLabel1.setFont(new java.awt.Font("Serif", 1, 70)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("WELCOME");

        txtTenQuanLy.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        txtTenQuanLy.setForeground(new java.awt.Color(0, 102, 102));

        jLabel17.setFont(new java.awt.Font("Serif", 1, 55)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 153, 0));
        jLabel17.setText("Quản lý");

        jLabel18.setFont(new java.awt.Font("Serif", 1, 55)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 153, 0));
        jLabel18.setText("Bán giày");

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Serif", 1, 55)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 153, 0));
        jLabel19.setText("6G Sneaker");

        jLabel20.setFont(new java.awt.Font("Serif", 1, 55)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 153, 0));
        jLabel20.setText("Hệ thống ");

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlMainLayout.createSequentialGroup()
                            .addGap(412, 412, 412)
                            .addComponent(txtTenQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlMainLayout.createSequentialGroup()
                            .addGap(122, 122, 122)
                            .addComponent(jLabel20))
                        .addGroup(pnlMainLayout.createSequentialGroup()
                            .addGap(351, 351, 351)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(479, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(382, 382, 382))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(164, 164, 164))))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(txtTenQuanLy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(59, 59, 59)
                .addComponent(jLabel20)
                .addGap(75, 75, 75)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(52, 52, 52)
                .addComponent(jLabel19)
                .addGap(92, 92, 92))
        );

        pnlcards.add(pnlMain, "card8");

        pnlKhachHang.setBackground(new java.awt.Color(255, 255, 255));
        pnlKhachHang.setForeground(new java.awt.Color(255, 255, 255));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        txtTimKiemKH.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemKHCaretUpdate(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Mã Khách Hàng");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Tên Khách Hàng");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Số điện thoại");

        btnUpdate.setBackground(new java.awt.Color(255, 204, 0));
        btnUpdate.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(255, 204, 0));
        btnAdd.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Thêm ");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 204, 0));
        btnDelete.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
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

        btnClear.setBackground(new java.awt.Color(255, 204, 0));
        btnClear.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel21.setText("Khách hàng");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(59, 59, 59)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(51, 51, 51)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTimKiemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 970, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(408, 408, 408)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addGap(81, 81, 81)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(57, 57, 57)
                .addComponent(txtTimKiemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlKhachHangLayout = new javax.swing.GroupLayout(pnlKhachHang);
        pnlKhachHang.setLayout(pnlKhachHangLayout);
        pnlKhachHangLayout.setHorizontalGroup(
            pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKhachHangLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlKhachHangLayout.setVerticalGroup(
            pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlcards.add(pnlKhachHang, "cardKH");

        pnlNhanVien.setBackground(new java.awt.Color(255, 255, 255));

        btnUpdateNV.setBackground(new java.awt.Color(255, 204, 0));
        btnUpdateNV.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnUpdateNV.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateNV.setText("Update");
        btnUpdateNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateNVActionPerformed(evt);
            }
        });

        btnDeleteNV.setBackground(new java.awt.Color(255, 204, 0));
        btnDeleteNV.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnDeleteNV.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteNV.setText("Delete");
        btnDeleteNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteNVActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        jLabel4.setText("Họ Tên");

        btnClearNV.setBackground(new java.awt.Color(255, 204, 0));
        btnClearNV.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnClearNV.setForeground(new java.awt.Color(255, 255, 255));
        btnClearNV.setText("Clear");
        btnClearNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearNVActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
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

        jLabel7.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        jLabel7.setText("Tài khoản");

        jLabel8.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        jLabel8.setText("Mật khẩu");

        jLabel12.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        jLabel12.setText("Chức Vụ");

        jLabel9.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        jLabel9.setText("Ngày sinh");

        cbbChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbChucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbChucVuActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        jLabel10.setText("Địa chỉ");

        jLabel11.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        jLabel11.setText("Sdt");

        txtMa.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N

        txtTimKiemNV.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        txtTimKiemNV.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemNVCaretUpdate(evt);
            }
        });

        txtTen.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N

        txtTaiKhoan.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N

        txtMatKhau.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N

        txtNgaySinh.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N

        txtDiaChi.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N

        txtSdtNV.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N

        buttonGroup1.add(radioNam);
        radioNam.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        radioNam.setSelected(true);
        radioNam.setText("Nam");

        buttonGroup1.add(radioNu);
        radioNu.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        radioNu.setText("Nữ");

        lbID.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        jLabel13.setText("Email");

        txtEmail.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Courier New", 1, 36)); // NOI18N
        jLabel14.setText("NHÂN VIÊN");

        btnAddNV.setBackground(new java.awt.Color(255, 204, 0));
        btnAddNV.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnAddNV.setForeground(new java.awt.Color(255, 255, 255));
        btnAddNV.setText("Add");
        btnAddNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNVActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        jLabel15.setText("Id");

        jLabel16.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        jLabel16.setText("Mã");

        btnThemCV.setBackground(new java.awt.Color(255, 0, 0));
        btnThemCV.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnThemCV.setForeground(new java.awt.Color(255, 255, 255));
        btnThemCV.setText("+");
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
                .addGap(0, 68, Short.MAX_VALUE)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTimKiemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 995, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(155, 155, 155))
            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                        .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                        .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel16)
                                            .addComponent(jLabel15))
                                        .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addComponent(lbID, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                                .addGap(99, 99, 99)
                                                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                        .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel6))
                                        .addGap(51, 51, 51)
                                        .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                                .addComponent(radioNam)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(radioNu))
                                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnThemCV)))))
                            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                .addGap(251, 251, 251)
                                .addComponent(lbTenCuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(btnAddNV, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(btnUpdateNV, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel12)
                                .addGap(181, 181, 181)
                                .addComponent(lbTenChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50)
                        .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel7))
                                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                        .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel13))
                                        .addGap(4, 4, 4)))
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
                                .addGap(3, 3, 3)
                                .addComponent(btnDeleteNV, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)
                                .addComponent(btnClearNV, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                        .addGap(463, 463, 463)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlNhanVienLayout.setVerticalGroup(
            pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(lbID, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(jLabel8)
                        .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(radioNam)
                        .addComponent(radioNu)))
                .addGap(25, 25, 25)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                        .addComponent(lbTenChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNhanVienLayout.createSequentialGroup()
                        .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtSdtNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(cbbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThemCV, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)))
                .addComponent(lbTenCuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddNV, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateNV, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteNV, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClearNV, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(txtTimKiemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlcards.add(pnlNhanVien, "cardNV");

        pnlBanHang.setBackground(new java.awt.Color(255, 255, 255));
        pnlBanHang.setPreferredSize(new java.awt.Dimension(830, 700));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
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
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblHoaDon);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jScrollPane7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtHoaDonPDF.setColumns(20);
        txtHoaDonPDF.setRows(5);
        jScrollPane7.setViewportView(txtHoaDonPDF);

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(11, 42, 61));
        jLabel27.setText("Hóa đơn chờ");

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(11, 42, 61));
        jLabel28.setText("Giỏ hàng");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(tblGioHang);

        btnXoaSanPham.setBackground(new java.awt.Color(255, 204, 0));
        btnXoaSanPham.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnXoaSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaSanPham.setText("Xóa");
        btnXoaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSanPhamActionPerformed(evt);
            }
        });

        btnCapNhatSP.setBackground(new java.awt.Color(255, 204, 0));
        btnCapNhatSP.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnCapNhatSP.setForeground(new java.awt.Color(255, 255, 255));
        btnCapNhatSP.setText("Cập nhật");
        btnCapNhatSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCapNhatSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoaSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btnXoaSanPham)
                        .addGap(18, 18, 18)
                        .addComponent(btnCapNhatSP))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(11, 42, 61));
        jLabel29.setText("Danh sách sản phẩm");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel30.setText("Tìm kiếm sản phẩm");

        txtTimKiemDSSP.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemDSSPCaretUpdate(evt);
            }
        });

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tblSanPham);

        cbbDSPBH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbDSPBHMouseClicked(evt);
            }
        });
        cbbDSPBH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbDSPBHActionPerformed(evt);
            }
        });

        cbbDGBH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbDGBHMouseClicked(evt);
            }
        });
        cbbDGBH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbDGBHActionPerformed(evt);
            }
        });

        cbbMSBH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbMSBHMouseClicked(evt);
            }
        });
        cbbMSBH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMSBHActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel31.setText("Dòng sản phẩm");

        jLabel32.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel32.setText("Đế giày");

        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel33.setText("Màu");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane9))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel30)
                                .addGap(18, 18, 18)
                                .addComponent(txtTimKiemDSSP))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbDSPBH, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbDGBH, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbMSBH, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtTimKiemDSSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbDSPBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbDGBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbMSBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel33)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel34.setText("Nhân viên:");

        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel35.setText("Khách hàng:");

        btnThayDoi.setBackground(new java.awt.Color(255, 204, 0));
        btnThayDoi.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnThayDoi.setForeground(new java.awt.Color(255, 255, 255));
        btnThayDoi.setText("Thay đổi");
        btnThayDoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThayDoiActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel36.setText("Số điện thoại:");

        btnThemKHBH.setBackground(new java.awt.Color(255, 0, 51));
        btnThemKHBH.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnThemKHBH.setForeground(new java.awt.Color(255, 255, 255));
        btnThemKHBH.setText("+");
        btnThemKHBH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKHBHActionPerformed(evt);
            }
        });

        btnReloadBH.setBackground(new java.awt.Color(255, 0, 51));
        btnReloadBH.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnReloadBH.setForeground(new java.awt.Color(255, 255, 255));
        btnReloadBH.setText("Load");
        btnReloadBH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadBHActionPerformed(evt);
            }
        });

        cbbSoDienThoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSoDienThoaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(txtTenKhachHangBH, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnThemKHBH))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(cbbNhanVienBH, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnReloadBH))))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbbSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(btnThayDoi)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(cbbNhanVienBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReloadBH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThemKHBH)
                        .addComponent(txtTenKhachHangBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(cbbSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThayDoi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel37.setText("Mã hóa đơn: ");

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel38.setText("Ngày tạo:");

        labelTT.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        labelTT.setText("Thành tiền:");

        lblGiamGia.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblGiamGia.setText("Giảm giá:");

        jLabel39.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel39.setText("Thanh toán:");

        jLabel40.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel40.setText("Tiền khách đưa:");

        jLabel41.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel41.setText("Tiền thừa:");

        btnHuyHoaDon.setBackground(new java.awt.Color(255, 204, 0));
        btnHuyHoaDon.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnHuyHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnHuyHoaDon.setText("Hủy hóa đơn");
        btnHuyHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyHoaDonActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(255, 204, 0));
        btnLamMoi.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnThanhToan.setBackground(new java.awt.Color(255, 204, 0));
        btnThanhToan.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        lblMaHD.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblMaHD.setText("HD___");

        lblNgayTao.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblNgayTao.setText("dd/mm/yyyy");

        lblThanhTien.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblThanhTien.setForeground(new java.awt.Color(204, 0, 0));
        lblThanhTien.setText("0");

        lblThanhToan.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblThanhToan.setForeground(new java.awt.Color(204, 0, 0));
        lblThanhToan.setText("0");

        jLabel42.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel42.setText("%");

        txtGiamGia.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtGiamGia.setForeground(new java.awt.Color(204, 0, 0));
        txtGiamGia.setText("0");

        jLabel43.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel43.setText("VNĐ");

        jLabel44.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel44.setText("VNĐ");

        jLabel45.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel45.setText("VNĐ");

        jLabel46.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel46.setText("VNĐ");

        txtTienKhachDua.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtTienKhachDua.setForeground(new java.awt.Color(204, 0, 0));
        txtTienKhachDua.setText("0");

        lblTienThua.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblTienThua.setForeground(new java.awt.Color(204, 0, 0));
        lblTienThua.setText("0");

        btnTaoHoaDon.setBackground(new java.awt.Color(255, 204, 0));
        btnTaoHoaDon.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnTaoHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnTaoHoaDon.setText("Tạo hóa đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblGiamGia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelTT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGap(99, 99, 99)
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                                .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                                .addComponent(lblThanhTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel9Layout.createSequentialGroup()
                                                .addComponent(lblNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                                .addComponent(lblThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGroup(jPanel9Layout.createSequentialGroup()
                                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnHuyHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel9Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnTaoHoaDon))))))
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel40)
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel9Layout.createSequentialGroup()
                                    .addComponent(lblTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel9Layout.createSequentialGroup()
                                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(lblMaHD)
                    .addComponent(btnTaoHoaDon))
                .addGap(15, 15, 15)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(lblNgayTao))
                .addGap(15, 15, 15)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTT)
                    .addComponent(lblThanhTien)
                    .addComponent(jLabel43))
                .addGap(15, 15, 15)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGiamGia)
                    .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addGap(15, 15, 15)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(lblThanhToan)
                    .addComponent(jLabel44))
                .addGap(15, 15, 15)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jLabel46)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jLabel45)
                    .addComponent(lblTienThua))
                .addGap(15, 15, 15)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHuyHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlWebcam.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout pnlBanHangLayout = new javax.swing.GroupLayout(pnlBanHang);
        pnlBanHang.setLayout(pnlBanHangLayout);
        pnlBanHangLayout.setHorizontalGroup(
            pnlBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBanHangLayout.createSequentialGroup()
                .addGap(511, 511, 511)
                .addComponent(pnlWebcam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(653, Short.MAX_VALUE))
            .addGroup(pnlBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBanHangLayout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addGroup(pnlBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlBanHangLayout.createSequentialGroup()
                            .addGroup(pnlBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlBanHangLayout.createSequentialGroup()
                                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(243, 243, 243)))
                            .addGap(5, 5, 5))
                        .addComponent(jLabel29)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnlBanHangLayout.createSequentialGroup()
                            .addGap(9, 9, 9)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(82, 82, 82)))
        );
        pnlBanHangLayout.setVerticalGroup(
            pnlBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBanHangLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(pnlWebcam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(773, Short.MAX_VALUE))
            .addGroup(pnlBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBanHangLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel27)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(pnlBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlBanHangLayout.createSequentialGroup()
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane7))
                        .addGroup(pnlBanHangLayout.createSequentialGroup()
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(8, 8, 8)
                            .addComponent(jLabel28)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel29)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap()))
        );

        pnlcards.add(pnlBanHang, "cardBH");

        pnlDoiTra.setBackground(new java.awt.Color(255, 255, 255));

        jLabel47.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel47.setText("Quản lý đổi sản phẩm");

        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel48.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel48.setText("Tên khách hàng:");

        jLabel49.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel49.setText("Mã hóa đơn");

        jLabel50.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel50.setText("Ngày đổi hàng:");

        btnDoiSanPham.setBackground(new java.awt.Color(255, 204, 0));
        btnDoiSanPham.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnDoiSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnDoiSanPham.setText("Đổi sản phẩm");
        btnDoiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiSanPhamActionPerformed(evt);
            }
        });

        lblTenKHDoiTra.setText("_____");

        lblMaHDDoiTra.setText("_____");

        lblNgaDoiHangDT.setText("_____");

        jLabel51.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel51.setText("Ghi chú:");

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane10.setViewportView(txtGhiChu);

        jLabel52.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel52.setText("Lí do đổi hàng:");

        cbbLiDoDoi.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbbLiDoDoi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "bị lỗi", "kích cỡ", "màu", "dòng sản phẩm", "đế giầy", "chất lượng", "phong cách" }));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(133, 133, 133))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel52))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbLiDoDoi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMaHDDoiTra, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTenKHDoiTra, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNgaDoiHangDT, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDoiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(lblTenKHDoiTra))
                .addGap(27, 27, 27)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(lblMaHDDoiTra))
                .addGap(27, 27, 27)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(lblNgaDoiHangDT))
                .addGap(22, 22, 22)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(cbbLiDoDoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDoiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel53.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel53.setText("Hoàn trả");

        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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
        jScrollPane11.setViewportView(tblHoaDonDoiTra);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(txtTimKiemDoiTra, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiemDoiTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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
        jScrollPane12.setViewportView(tblDoiTra);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel54.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel54.setText("Hóa đơn");

        jLabel55.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel55.setText("Hóa đơn đổi hàng");

        jLabel56.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel56.setText("Hóa đơn chi tiết");

        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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
        jScrollPane13.setViewportView(tblHDCTDoiTra);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlDoiTraLayout = new javax.swing.GroupLayout(pnlDoiTra);
        pnlDoiTra.setLayout(pnlDoiTraLayout);
        pnlDoiTraLayout.setHorizontalGroup(
            pnlDoiTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoiTraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDoiTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDoiTraLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel47)
                        .addGap(380, 380, 380))
                    .addGroup(pnlDoiTraLayout.createSequentialGroup()
                        .addGroup(pnlDoiTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel54))
                        .addGap(18, 18, 18)
                        .addGroup(pnlDoiTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDoiTraLayout.createSequentialGroup()
                                .addComponent(jLabel53)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnlDoiTraLayout.createSequentialGroup()
                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(pnlDoiTraLayout.createSequentialGroup()
                        .addGroup(pnlDoiTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlDoiTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDoiTraLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(334, 334, 334))
                            .addGroup(pnlDoiTraLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        pnlDoiTraLayout.setVerticalGroup(
            pnlDoiTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoiTraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel47)
                .addGap(12, 12, 12)
                .addGroup(pnlDoiTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(jLabel53))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDoiTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlDoiTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel56)
                    .addGroup(pnlDoiTraLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel55)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDoiTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlcards.add(pnlDoiTra, "cardDoiTra");

        pnlThongKe.setBackground(new java.awt.Color(255, 255, 255));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setForeground(new java.awt.Color(255, 255, 255));

        jPanel17.setBackground(new java.awt.Color(255, 255, 51));
        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel57.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel57.setText("Doanh Thu");

        jLabel58.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(204, 0, 0));
        jLabel58.setText("20.000.000");

        jLabel59.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel59.setText("VNĐ");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel57))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel58)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel59)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel57)
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(jLabel59))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel18.setBackground(new java.awt.Color(255, 255, 51));
        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel60.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel60.setText("Hóa đơn");

        jLabel61.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(204, 0, 0));
        jLabel61.setText("209");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel60)
                .addGap(18, 18, 18)
                .addComponent(jLabel61)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel19.setBackground(new java.awt.Color(255, 255, 51));
        jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel62.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel62.setText("Sản phẩm bán ra");

        jLabel63.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(204, 0, 0));
        jLabel63.setText("270");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel62)
                .addGap(18, 18, 18)
                .addComponent(jLabel63)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel20.setBackground(new java.awt.Color(255, 255, 51));
        jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel64.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel64.setText("Lượng khách hàng");

        jLabel65.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(204, 0, 0));
        jLabel65.setText("200");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel64)
                .addGap(22, 22, 22))
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel64)
                .addGap(18, 18, 18)
                .addComponent(jLabel65)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTabbedPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane1.addTab("Sản phẩm tồn", jTabbedPane3);
        jTabbedPane1.addTab("Sản phẩm lỗi", jTabbedPane2);

        jRadioButton1.setText("Tất cả");

        jRadioButton2.setText("Theo tháng");

        jRadioButton3.setText("Theo năm");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tháng 1", "Tháng 2", "Tháng 3" }));

        jLabel66.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(0, 51, 102));
        jLabel66.setText("Thống Kê");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton1)
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTabbedPane1)
                                .addGroup(jPanel16Layout.createSequentialGroup()
                                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(54, 54, 54)
                                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(65, 65, 65)
                                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(55, 55, 55)
                                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(13, 13, 13)))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jRadioButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(434, 434, 434)
                        .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel66)
                .addGap(11, 11, 11)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlThongKeLayout = new javax.swing.GroupLayout(pnlThongKe);
        pnlThongKe.setLayout(pnlThongKeLayout);
        pnlThongKeLayout.setHorizontalGroup(
            pnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlThongKeLayout.setVerticalGroup(
            pnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlcards.add(pnlThongKe, "cardTK");

        pnlSanPhamChiTiet.setBackground(new java.awt.Color(255, 255, 255));

        lbl_ngayNhapHang.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_ngayNhapHang.setText("Ngày nhập hàng");

        lbl_locMauSac.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_locMauSac.setText("Màu sắc");

        lbl_locDeGiay.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_locDeGiay.setText("Đế giày");

        lbl_giaBan.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_giaBan.setText("Giá bán");

        cbo_locDeGiay.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_locDeGiayItemStateChanged(evt);
            }
        });

        lbl_soLuong.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_soLuong.setText("Số lượng");

        lbl_locDongSP.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_locDongSP.setText("Dòng sản phẩm");

        lbl_xuatXu.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_xuatXu.setText("Xuất xứ");

        lbl_kichCo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_kichCo.setText("Kích cỡ");

        cbo_locDongSP.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_locDongSPItemStateChanged(evt);
            }
        });

        lbl_locGiaBan.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_locGiaBan.setText("Giá");

        lbl_trangThai.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_trangThai.setText("Trạng thái");

        cbo_locGia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_locGiaItemStateChanged(evt);
            }
        });
        cbo_locGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_locGiaActionPerformed(evt);
            }
        });

        btn_them.setBackground(new java.awt.Color(255, 204, 0));
        btn_them.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_them.setForeground(new java.awt.Color(255, 255, 255));
        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_sua.setBackground(new java.awt.Color(255, 204, 0));
        btn_sua.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_sua.setForeground(new java.awt.Color(255, 255, 255));
        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        tbl_CTSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SP", "Sản Phẩm", "Màu Sắc", "Đế Giày", "Dòng Sản Phẩm", "Ngày Nhập Hàng", "Giá Bán", "Số Lượng", "Kích Cỡ", "Xuất Xứ", "Trạng Thái"
            }
        ));
        tbl_CTSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_CTSanPhamMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_CTSanPham);

        btn_xoa.setBackground(new java.awt.Color(255, 204, 0));
        btn_xoa.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_xoa.setForeground(new java.awt.Color(255, 255, 255));
        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_clear.setBackground(new java.awt.Color(255, 204, 0));
        btn_clear.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_clear.setForeground(new java.awt.Color(255, 255, 255));
        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        lbl_sanPham.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_sanPham.setText("Sản phẩm");

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

        lbl_deGiay.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_deGiay.setText("Đế giày");

        txt_ngayNhapHang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_ngayNhapHangFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_ngayNhapHangFocusLost(evt);
            }
        });

        btn_themSP.setBackground(new java.awt.Color(204, 0, 0));
        btn_themSP.setForeground(new java.awt.Color(255, 255, 255));
        btn_themSP.setText("+");
        btn_themSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themSPActionPerformed(evt);
            }
        });

        btn_themMS.setBackground(new java.awt.Color(204, 0, 0));
        btn_themMS.setForeground(new java.awt.Color(255, 255, 255));
        btn_themMS.setText("+");
        btn_themMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themMSActionPerformed(evt);
            }
        });

        btn_themDG1.setBackground(new java.awt.Color(204, 0, 0));
        btn_themDG1.setForeground(new java.awt.Color(255, 255, 255));
        btn_themDG1.setText("+");
        btn_themDG1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themDG1ActionPerformed(evt);
            }
        });

        lbl_mauSac.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_mauSac.setText("Màu sắc");

        btn_themDSP1.setBackground(new java.awt.Color(204, 0, 0));
        btn_themDSP1.setForeground(new java.awt.Color(255, 255, 255));
        btn_themDSP1.setText("+");
        btn_themDSP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themDSP1ActionPerformed(evt);
            }
        });

        lbl_dongSP.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_dongSP.setText("Dòng sản phẩm");

        cbo_locMauSac.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_locMauSacItemStateChanged(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel22.setText("Sản phẩm chi tiết");

        btnReloadCTSP.setBackground(new java.awt.Color(255, 204, 0));
        btnReloadCTSP.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnReloadCTSP.setForeground(new java.awt.Color(255, 255, 255));
        btnReloadCTSP.setText("Reload");
        btnReloadCTSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadCTSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSanPhamChiTietLayout = new javax.swing.GroupLayout(pnlSanPhamChiTiet);
        pnlSanPhamChiTiet.setLayout(pnlSanPhamChiTietLayout);
        pnlSanPhamChiTietLayout.setHorizontalGroup(
            pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSanPhamChiTietLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlSanPhamChiTietLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSanPhamChiTietLayout.createSequentialGroup()
                                .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl_mauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_sanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSanPhamChiTietLayout.createSequentialGroup()
                                .addComponent(lbl_giaBan)
                                .addGap(38, 38, 38))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSanPhamChiTietLayout.createSequentialGroup()
                                .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl_xuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_soLuong))
                                .addGap(31, 31, 31)))
                        .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlSanPhamChiTietLayout.createSequentialGroup()
                                .addComponent(cbo_sanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_themSP))
                            .addGroup(pnlSanPhamChiTietLayout.createSequentialGroup()
                                .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_xuatXu)
                                    .addComponent(txt_soLuong)
                                    .addComponent(txt_giaBan)
                                    .addComponent(cbo_mauSac, 0, 205, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_themMS)
                                    .addComponent(btnReloadCTSP)
                                    .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_dongSP)
                            .addComponent(lbl_deGiay)
                            .addComponent(lbl_ngayNhapHang)
                            .addComponent(lbl_kichCo)
                            .addComponent(lbl_trangThai))
                        .addGap(30, 30, 30)
                        .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlSanPhamChiTietLayout.createSequentialGroup()
                                .addComponent(cbo_dongSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_themDSP1))
                            .addComponent(txt_ngayNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_kichCo, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlSanPhamChiTietLayout.createSequentialGroup()
                                .addComponent(cbo_deGiay, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_themDG1)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlSanPhamChiTietLayout.createSequentialGroup()
                        .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlSanPhamChiTietLayout.createSequentialGroup()
                                .addGap(479, 479, 479)
                                .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(441, 441, Short.MAX_VALUE))
                    .addGroup(pnlSanPhamChiTietLayout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(lbl_locDeGiay)
                        .addGap(29, 29, 29)
                        .addComponent(cbo_locDeGiay, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_locDongSP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbo_locDongSP, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_locGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbo_locGia, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSanPhamChiTietLayout.createSequentialGroup()
                .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSanPhamChiTietLayout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlSanPhamChiTietLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lbl_locMauSac)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbo_locMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSanPhamChiTietLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(399, 399, 399))
            .addGroup(pnlSanPhamChiTietLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1097, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlSanPhamChiTietLayout.setVerticalGroup(
            pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSanPhamChiTietLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel22)
                .addGap(46, 46, 46)
                .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_sanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_sanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_deGiay, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_deGiay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_themSP)
                    .addComponent(btn_themDG1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_dongSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_mauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_mauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_dongSP, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_themMS)
                    .addComponent(btn_themDSP1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_giaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_giaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ngayNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_ngayNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReloadCTSP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_kichCo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_kichCo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbo_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_xuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_xuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(54, 54, 54)
                .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_locMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_locMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_locDeGiay, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_locDeGiay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_locDongSP, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_locDongSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_locGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_locGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlcards.add(pnlSanPhamChiTiet, "cardCTSP");

        pnlHoaDon.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblHoaDonChiTietBH.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblHoaDonChiTietBH);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel23.setText("Tìm kiếm hóa đơn");

        txtTimKiemHoaDon.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemHoaDonCaretUpdate(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel24.setText("Trang thái");

        cbbLocTrangThaiHD.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbbLocTrangThaiHD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã thanh toán", "Chờ thanh toán" }));
        cbbLocTrangThaiHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLocTrangThaiHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTimKiemHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbLocTrangThaiHD, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtTimKiemHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(cbbLocTrangThaiHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblHoaDonBanHang.setModel(new javax.swing.table.DefaultTableModel(
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
        tblHoaDonBanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonBanHangMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblHoaDonBanHang);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 331, Short.MAX_VALUE))
                    .addComponent(jScrollPane5))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel25.setText("Hóa đơn");

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel26.setText("Hóa đơn chi tiết");

        jLabel76.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(0, 153, 0));
        jLabel76.setText("Hóa Đơn");

        javax.swing.GroupLayout pnlHoaDonLayout = new javax.swing.GroupLayout(pnlHoaDon);
        pnlHoaDon.setLayout(pnlHoaDonLayout);
        pnlHoaDonLayout.setHorizontalGroup(
            pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHoaDonLayout.createSequentialGroup()
                .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHoaDonLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel25)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel26)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlHoaDonLayout.createSequentialGroup()
                        .addGap(476, 476, 476)
                        .addComponent(jLabel76)))
                .addContainerGap(166, Short.MAX_VALUE))
        );
        pnlHoaDonLayout.setVerticalGroup(
            pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHoaDonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel76)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pnlcards.add(pnlHoaDon, "cardHoaDon");

        pnlVoucher.setBackground(new java.awt.Color(255, 255, 255));

        btnClearVoucher.setBackground(new java.awt.Color(255, 0, 51));
        btnClearVoucher.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnClearVoucher.setForeground(new java.awt.Color(255, 255, 255));
        btnClearVoucher.setText("Clear");

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel67.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel67.setText("Ngày hết hạn");

        jLabel68.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel68.setText("Ngày bắt đầu");

        jLabel69.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel69.setText("Trạng thái");

        jComboBox2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang áp dụng", "Đã hết hạn" }));

        jLabel70.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel70.setText("Ghi chú");

        txtGhiChuVoucher.setColumns(20);
        txtGhiChuVoucher.setRows(5);
        jScrollPane14.setViewportView(txtGhiChuVoucher);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayBatDau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNgayHetHan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox2, 0, 160, Short.MAX_VALUE)
                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(jLabel70))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(txtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel67)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNgayHetHan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel69)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane14))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSuaVoucher.setBackground(new java.awt.Color(255, 0, 51));
        btnSuaVoucher.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnSuaVoucher.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaVoucher.setText("Sửa");

        jLabel71.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel71.setText("Tạo chương trình khuyến mãi");

        btnThemVoucher.setBackground(new java.awt.Color(255, 0, 51));
        btnThemVoucher.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnThemVoucher.setForeground(new java.awt.Color(255, 255, 255));
        btnThemVoucher.setText("Thêm");
        btnThemVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemVoucherActionPerformed(evt);
            }
        });

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel72.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel72.setText("Mã khuyễn mãi");

        jLabel73.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel73.setText("Tên chương trình khuyến mãi ( Áp dụng tất cả sản phẩm )");

        jLabel74.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel74.setText("Mức giá giảm (%)");

        cbbMucGiamGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5%", "10%", "15%", "20%", "30%", "35%", "45%", "50%" }));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtMaVoucher)
                        .addComponent(txtTenVoucher)
                        .addComponent(jLabel73)
                        .addComponent(jLabel74)
                        .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbbMucGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel72)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMaVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel73)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTenVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jLabel74)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbMucGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblVoucher.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblVoucher.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane15.setViewportView(tblVoucher);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(txtTimKiemVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 1103, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiemVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel75.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel75.setText("Danh sách Vouncher");

        javax.swing.GroupLayout pnlVoucherLayout = new javax.swing.GroupLayout(pnlVoucher);
        pnlVoucher.setLayout(pnlVoucherLayout);
        pnlVoucherLayout.setHorizontalGroup(
            pnlVoucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVoucherLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pnlVoucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlVoucherLayout.createSequentialGroup()
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlVoucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlVoucherLayout.createSequentialGroup()
                                .addComponent(btnThemVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97)
                                .addComponent(btnSuaVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88)
                                .addComponent(btnClearVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlVoucherLayout.createSequentialGroup()
                .addGroup(pnlVoucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlVoucherLayout.createSequentialGroup()
                        .addGap(328, 328, 328)
                        .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlVoucherLayout.setVerticalGroup(
            pnlVoucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVoucherLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel71)
                .addGap(28, 28, 28)
                .addGroup(pnlVoucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlVoucherLayout.createSequentialGroup()
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlVoucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThemVoucher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSuaVoucher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnClearVoucher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel75)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlcards.add(pnlVoucher, "cardVoucher");

        jSplitPane1.setRightComponent(pnlcards);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1474, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
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
//        ViewThongKe vtk = new ViewThongKe();
//        vtk.setVisible(true);
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void btnBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanHangActionPerformed
        // TODO add your handling code here:
//        ViewBanHang vbh = new ViewBanHang();
//        vbh.setVisible(true);
        cardLayout.show(pnlcards, "cardBH");

    }//GEN-LAST:event_btnBanHangActionPerformed

    private void btnDoiTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiTraActionPerformed
        // TODO add your handling code here:

        cardLayout.show(pnlcards, "cardDoiTra");

    }//GEN-LAST:event_btnDoiTraActionPerformed

    private void btnHoaDonBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonBanHangActionPerformed
        cardLayout.show(pnlcards, "cardHoaDon");

    }//GEN-LAST:event_btnHoaDonBanHangActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        ViewLogin l = new ViewLogin();
        var temp = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắc chắn muốn đăng xuất");
        if (temp == 0) {
            l.setVisible(true);
            this.dispose();
        }

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

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtMaKH.setText("");
        txtTenKH.setText("");
        txtTimKiemKH.setText("");
        txtSdt.setText("");
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
        for (KhachHangCustomModel cv : listKHCM) {
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

    private void btnThemCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCVActionPerformed
        ViewChucVu vcv = new ViewChucVu();
        vcv.setVisible(true);


    }//GEN-LAST:event_btnThemCVActionPerformed

    private void txtTimKiemNVCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemNVCaretUpdate
        listNhanVienCustom = nhanVienServiceImpl.SearchNV(txtTimKiemNV.getText());
        showDataNV(listNhanVienCustom);
    }//GEN-LAST:event_txtTimKiemNVCaretUpdate

    private void txtTimKiemKHCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemKHCaretUpdate
        listKHCM = khs.SearchKH(txtTimKiemKH.getText());
        showData(listKHCM);
    }//GEN-LAST:event_txtTimKiemKHCaretUpdate

    private void cbo_locDeGiayItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_locDeGiayItemStateChanged
        // TODO add your handling code here:
        loadTable((String) cbo_locDeGiay.getSelectedItem());
    }//GEN-LAST:event_cbo_locDeGiayItemStateChanged

    private void cbo_locDongSPItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_locDongSPItemStateChanged
        // TODO add your handling code here:
        loadTable((String) cbo_locDongSP.getSelectedItem());
    }//GEN-LAST:event_cbo_locDongSPItemStateChanged

    private void cbo_locGiaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_locGiaItemStateChanged
        // TODO add your handling code here:
        var batDau = uti.getNam((String) cbo_locGia.getSelectedItem());
        var ketThuc = uti.getThang((String) cbo_locGia.getSelectedItem());
        loadTableByGia(batDau, ketThuc);
    }//GEN-LAST:event_cbo_locGiaItemStateChanged

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
                chitietSP.setId(chiTietSanPhamService.getIdByIndex(row));
                JOptionPane.showMessageDialog(this, chiTietSanPhamService.update(chitietSP));
                loadTable(null);
            }
        }

    }//GEN-LAST:event_btn_suaActionPerformed

    private void tbl_CTSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_CTSanPhamMouseClicked
        // TODO add your handling code here:
        var row = tbl_CTSanPham.getSelectedRow();
        var temp = chiTietSanPhamService.getById(chiTietSanPhamService.getIdByIndex(row));
        cbo_sanPham.setSelectedItem(temp.getTenSP());
        cbo_mauSac.setSelectedItem(temp.getTenMauSac());
        cbo_deGiay.setSelectedItem(temp.getTenDeGiay());
        cbo_dongSanPham.setSelectedItem(temp.getTenDongSP());
        txt_ngayNhapHang.setText(temp.getNgayNhapHang());
        txt_giaBan.setText(String.valueOf(temp.getDonGia()));
        txt_soLuong.setText(String.valueOf(temp.getSoLuong()));
        txt_kichCo.setText(temp.getKichCo());
        txt_xuatXu.setText(temp.getXuatXu());
        cbo_trangThai.setSelectedIndex(temp.getTrangThai());
    }//GEN-LAST:event_tbl_CTSanPhamMouseClicked

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        var temp = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa thông tin không ?");
        if (temp == 0) {
            var row = tbl_CTSanPham.getSelectedRow();
            var chitietSP = new ChiTietSanPhamHiber();
            chitietSP.setId(chiTietSanPhamService.getIdByIndex(row));
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
        txt_ngayNhapHang.setText(null);
        txt_giaBan.setText(null);
        txt_soLuong.setText(null);
        txt_kichCo.setText(null);
        txt_xuatXu.setText(null);
        cbo_trangThai.setSelectedIndex(0);
    }//GEN-LAST:event_btn_clearActionPerformed

    private void txt_timKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_timKiemCaretUpdate
        // TODO add your handling code here:
        if (txt_timKiem.getText().isEmpty()) {
            loadTable(null);
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
        loadTable(null);
    }//GEN-LAST:event_txt_timKiemFocusLost

    private void txt_ngayNhapHangFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_ngayNhapHangFocusGained
        // TODO add your handling code here:
        txt_ngayNhapHang.setText("");
    }//GEN-LAST:event_txt_ngayNhapHangFocusGained

    private void txt_ngayNhapHangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_ngayNhapHangFocusLost
        // TODO add your handling code here:
        txt_ngayNhapHang.setText(java.time.LocalDate.now() + "");
    }//GEN-LAST:event_txt_ngayNhapHangFocusLost

    private void btn_themSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themSPActionPerformed
        // TODO add your handling code here:
        new ViewSanPham().setVisible(true);
    }//GEN-LAST:event_btn_themSPActionPerformed

    private void btn_themMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themMSActionPerformed
        // TODO add your handling code here:
        new ViewMauSac().setVisible(true);
    }//GEN-LAST:event_btn_themMSActionPerformed

    private void btn_themDG1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themDG1ActionPerformed
        // TODO add your handling code here:
        new ViewDeGiay().setVisible(true);
    }//GEN-LAST:event_btn_themDG1ActionPerformed

    private void btn_themDSP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themDSP1ActionPerformed
        // TODO add your handling code here:
        new ViewDongSp().setVisible(true);
    }//GEN-LAST:event_btn_themDSP1ActionPerformed

    private void cbo_locMauSacItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_locMauSacItemStateChanged
        // TODO add your handling code here:
        loadTable((String) cbo_locMauSac.getSelectedItem());
    }//GEN-LAST:event_cbo_locMauSacItemStateChanged

    private void btnReloadCTSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadCTSPActionPerformed
        loadCBB();
    }//GEN-LAST:event_btnReloadCTSPActionPerformed

    private void btnKetThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetThucActionPerformed
        var temp = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắc chắn muốn thoát");
        if (temp == 0) {
            System.exit(0);
        }

    }//GEN-LAST:event_btnKetThucActionPerformed

    private void btnVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoucherActionPerformed
//        ViewVoucher vvc = new ViewVoucher();
//        vvc.setVisible(true);
        cardLayout.show(pnlcards, "cardVoucher");
    }//GEN-LAST:event_btnVoucherActionPerformed

    private void txtTimKiemHoaDonCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemHoaDonCaretUpdate
        listHD = hds.SearchHD(txtTimKiemHoaDon.getText());
        showDataHD(listHD);
    }//GEN-LAST:event_txtTimKiemHoaDonCaretUpdate

    private void cbbLocTrangThaiHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLocTrangThaiHDActionPerformed
        String trangThai = cbbLocTrangThaiHD.getSelectedItem().toString();
        String tt = "";
        if (trangThai.equals("Đã thanh toán")) {
            tt = "3";
        } else {
            tt = "1";
        }
        listHD = hds.SearchCBB(tt);
        showDataHD(listHD);
    }//GEN-LAST:event_cbbLocTrangThaiHDActionPerformed

    private void tblHoaDonBanHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonBanHangMouseClicked
        int index = tblHoaDonBanHang.getSelectedRow();
        HoaDonCustomModelHD hd = listHD.get(index);
        listHDCT = hds.getHDCT(hd.getId());
        showDataHDCT(listHDCT);
    }//GEN-LAST:event_tblHoaDonBanHangMouseClicked

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        int index = tblHoaDon.getSelectedRow();
        HoaDonViewModel hd = listHoaDons.get(index);
        String idHD = hd.getId();
        listGioHangS = bhs.getGioHang(idHD);
        showDataGioHang(listGioHangS);
        double thanhTien = 0;
        double thanhToan = 0;
        double giamGia = 0;
        String phanTram = "";
        for (GioHangViewModel gh : listGioHangS) {
            thanhTien += gh.getSoLuong() * gh.getDonGia();
        }
        if (thanhTien > 700000) {
            giamGia = 0.95;
            phanTram = " (5%)";
            txtGiamGia.setEnabled(false);
        } else if (thanhTien > 2000000) {
            giamGia = 0.90;
            phanTram = " (10%)";
            txtGiamGia.setEnabled(false);
        } else if (thanhTien > 4000000) {
            txtGiamGia.setEnabled(true);
        } else {
            txtGiamGia.setEnabled(false);
            giamGia = 1;
            phanTram = " (0%)";
        }
        txtGiamGia.setText(String.valueOf(giamGia + phanTram));
        lblThanhTien.setText(String.valueOf(thanhTien));
        lblThanhToan.setText(String.valueOf(thanhToan = thanhTien * giamGia));
        fillDataHD(index);

        txtTienKhachDua.setText("0");
        lblTienThua.setText("0");
        txtHoaDonPDF.setText("");
        btnThanhToan.setEnabled(true);
        btnHuyHoaDon.setEnabled(true);
        btnLamMoi.setEnabled(true);

    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnXoaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSanPhamActionPerformed

        int indexHD = tblHoaDon.getSelectedRow();
        int indexGH = tblGioHang.getSelectedRow();
        if (indexGH < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần xóa");

        } else {

            GioHangViewModel gh = listGioHangS.get(indexGH);
            HoaDonViewModel hd = listHoaDons.get(indexHD);
            int soLuongGH = gh.getSoLuong();
            String idHD = hd.getId();

            String id = gh.getId();
            String idCTSP = gh.getIdCtsp();
            var tempTT = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa sản phẩm khỏi giỏ hàng không ?");
            if (tempTT == 0) {

                ChiTietSanPhamHiber ctsp = new ChiTietSanPhamHiber(soLuongGH);
                bhs.capNhatSoLuong(ctsp, idCTSP);
                JOptionPane.showMessageDialog(this, bhs.deleteGioHang(id));
                listSanPhams = bhs.getSanPhamVM();
                listGioHangS = bhs.getGioHang(idHD);

                showDataGioHang(listGioHangS);
                showDataSanPham(listSanPhams);

                double thanhTien = 0;
                double thanhToan = 0;
                double giamGia = 0;
                String phanTram = "";
                for (GioHangViewModel gha : listGioHangS) {
                    thanhTien += gha.getSoLuong() * gh.getDonGia();

                }

                if (thanhTien > 700000) {
                    giamGia = 0.95;
                    phanTram = " (5%)";
                    txtGiamGia.setEnabled(false);
                } else if (thanhTien > 2000000) {
                    giamGia = 0.90;
                    phanTram = " (10%)";
                    txtGiamGia.setEnabled(false);
                } else if (thanhTien > 4000000) {
                    txtGiamGia.setEnabled(true);
                } else {
                    txtGiamGia.setEnabled(false);
                    giamGia = 1;
                    phanTram = " (0%)";
                }
                txtGiamGia.setText(String.valueOf(giamGia + phanTram));
                lblThanhTien.setText(String.valueOf(thanhTien));
                lblThanhToan.setText(String.valueOf(thanhToan = thanhTien * giamGia));

            }
        }
    }//GEN-LAST:event_btnXoaSanPhamActionPerformed

    private void btnCapNhatSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatSPActionPerformed
        int indexHD = tblHoaDon.getSelectedRow();
        int indexGH = tblGioHang.getSelectedRow();
        SanPhamViewModel sp = new SanPhamViewModel();

        if (indexGH < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần cập nhật số lượng");

        } else {
            GioHangViewModel ghsl = listGioHangS.get(indexGH);
            String idSL = ghsl.getIdCtsp();
            int sl = bhs.laySoLuong(idSL);
            String soLuongMoi = JOptionPane.showInputDialog("Mời nhập số lượng cần cập nhật: ");
            if (soLuongMoi != null) {
                if (!soLuongMoi.matches("[0-9]+")) {
                    JOptionPane.showMessageDialog(this, "Nhập đúng định dạng");
                } else if (Integer.valueOf(soLuongMoi) > sl) {
                    JOptionPane.showMessageDialog(this, "Số lượng vượt quá");
                } else if (Integer.valueOf(soLuongMoi) == 0) {
                    JOptionPane.showMessageDialog(this, "Vui lòng chọn chức năng xóa");
                } else {
                    GioHangViewModel gh = listGioHangS.get(indexGH);
                    HoaDonViewModel hd = listHoaDons.get(indexHD);
                    String idCTSP = gh.getIdCtsp();
                    String id = gh.getId();
                    String idHD = hd.getId();
                    int soLuongCu = gh.getSoLuong();
                    int soLuongCapNhat = 0;
                    if (Integer.valueOf(soLuongMoi) < soLuongCu) {
                        soLuongCapNhat = soLuongCu - Integer.valueOf(soLuongMoi);
                        ChiTietSanPhamHiber ctsp = new ChiTietSanPhamHiber(soLuongCapNhat);
                        bhs.capNhatSoLuong(ctsp, idCTSP);
                    } else {
                        soLuongCapNhat = Integer.valueOf(soLuongMoi) - soLuongCu;
                        ChiTietSanPhamHiber ctsp = new ChiTietSanPhamHiber(soLuongCapNhat);
                        bhs.capNhatSoLuong2(ctsp, idCTSP);
                    }
                    gh.setSoLuong(Integer.valueOf(soLuongMoi));
                    bhs.updateSoLuongHDCT(gh, id);
                    listGioHangS = bhs.getGioHang(idHD);
                    showDataGioHang(listGioHangS);
                    listSanPhams = bhs.getSanPhamVM();
                    showDataSanPham(listSanPhams);

                    double thanhTien = 0;
                    double thanhToan = 0;
                    double giamGia = 0;
                    String phanTram = "";
                    for (GioHangViewModel gha : listGioHangS) {
                        thanhTien += gha.getSoLuong() * gh.getDonGia();

                    }

                    if (thanhTien > 700000) {
                        giamGia = 0.95;
                        phanTram = " (5%)";
                        txtGiamGia.setEnabled(false);
                    } else if (thanhTien > 2000000) {
                        giamGia = 0.90;
                        phanTram = " (10%)";
                        txtGiamGia.setEnabled(false);
                    } else if (thanhTien > 4000000) {
                        txtGiamGia.setEnabled(true);
                    } else {
                        txtGiamGia.setEnabled(false);
                        giamGia = 1;
                        phanTram = " (0%)";
                    }
                    txtGiamGia.setText(String.valueOf(giamGia + phanTram));
                    lblThanhTien.setText(String.valueOf(thanhTien));
                    lblThanhToan.setText(String.valueOf(thanhToan = thanhTien * giamGia));

                }
            }
        }
    }//GEN-LAST:event_btnCapNhatSPActionPerformed

    private void txtTimKiemDSSPCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemDSSPCaretUpdate
        listSanPhams = bhs.SearchSPBH(txtTimKiemDSSP.getText());
        showDataSanPham(listSanPhams);
    }//GEN-LAST:event_txtTimKiemDSSPCaretUpdate

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        //Lấy row table --> Dữ liệu
        String tenNV = cbbNhanVienBH.getSelectedItem().toString();
        String tenKH = cbbSoDienThoai.getSelectedItem().toString();
        GioHangViewModel gh = new GioHangViewModel();
        int rowHD = tblHoaDon.getSelectedRow();
        int row = tblSanPham.getSelectedRow();
        SanPhamViewModel sp = listSanPhams.get(row);
        if (rowHD < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn muốn thêm sản phẩm");
        } else {
            String soLuong = JOptionPane.showInputDialog("Mời bạn nhập số lượng: ");
            if (tenNV.contains("Tên nhân viên") || tenKH.contains("84+")) {
                JOptionPane.showMessageDialog(this, "Vui lòng thay đổi tên nhân viên hoặc khách hàng");
            } else {
                if (soLuong != null) {
                    if (!soLuong.matches("[0-9]+")) {
                        JOptionPane.showMessageDialog(this, "Nhập đúng định dạng");
                    } else if (Integer.valueOf(soLuong) > sp.getSoLuong()) {
                        JOptionPane.showMessageDialog(this, "Số lượng vượt quá -.-");
                    } else {
                        // Thêm sản phẩm vào giỏ hàng
                        HoaDonViewModel hd = listHoaDons.get(rowHD);
                        gh.setSoLuong(Integer.valueOf(soLuong));
                        gh.setMaSP(sp.getMaSP());
                        gh.setTenSP(sp.getTenSP());
                        gh.setDonGia(sp.getDonGia());
                        boolean trung = false;
                        for (GioHangViewModel x : listGioHangS) {
                            if (x.getMaSP().contains(sp.getMaSP())) {
                                trung = true;
                            }
                        }
                        if (trung) {
                            JOptionPane.showMessageDialog(this, "Sản phẩm đã có trong giỏ hàng, để thêm số lượng vui lòng chọn chức năng cập nhật");
                        } else {
                            // Thêm sản phẩm vào list giỏ hàng
                            listGioHangS.add(gh);

                            sp.setSoLuong(sp.getSoLuong() - Integer.valueOf(soLuong));
                            showDataSanPham(listSanPhams);

                            String idHD = hd.getId();
                            String idCtsp = sp.getId();
                            int soLuong1 = Integer.valueOf(soLuong);
                            Double donGia = sp.getDonGia();

                            // add giỏ hàng vào HDCT
                            HoaDonChiTietCustomModel hdct = new HoaDonChiTietCustomModel(idHD, idCtsp, soLuong1, donGia);
                            JOptionPane.showMessageDialog(this, bhs.addHDCT(hdct));
                            listGioHangS = bhs.getGioHang(idHD);
                            showDataGioHang(listGioHangS);

                            //Cập nhật số lượng trong bảng Sản phẩm CT
                            ChiTietSanPhamHiber ctsp = new ChiTietSanPhamHiber(sp.getSoLuong());
                            bhs.updateSoLuong(ctsp, idCtsp);

                            //Fill thành tiền, thanh toán, giảm giá
                            double thanhTien = 0;
                            double thanhToan = 0;
                            double giamGia = 0;
                            String phanTram = "";
                            for (GioHangViewModel gha : listGioHangS) {
                                thanhTien += gha.getSoLuong() * gh.getDonGia();

                            }

                            if (thanhTien > 700000) {
                                giamGia = 0.95;
                                phanTram = " (5%)";
                                txtGiamGia.setEnabled(false);
                            } else if (thanhTien > 2000000) {
                                giamGia = 0.90;
                                phanTram = " (10%)";
                                txtGiamGia.setEnabled(false);
                            } else if (thanhTien > 4000000) {
                                txtGiamGia.setEnabled(true);
                            } else {
                                txtGiamGia.setEnabled(false);
                                giamGia = 1;
                                phanTram = " (0%)";
                            }
                            txtGiamGia.setText(String.valueOf(giamGia + phanTram));
                            lblThanhTien.setText(String.valueOf(thanhTien));
                            lblThanhToan.setText(String.valueOf(thanhToan = thanhTien * giamGia));

                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void cbbDSPBHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbDSPBHMouseClicked
        listDSP = dongSPService.getAllCustom();

        listDSP.forEach((dsp) -> {
            cbbDSPBH.addItem(dsp.getTen());
        });
    }//GEN-LAST:event_cbbDSPBHMouseClicked

    private void cbbDSPBHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbDSPBHActionPerformed

        List<SanPhamViewModel> listNew = bhs.SearchSPBH(cbbDSPBH.getSelectedItem().toString());
        showDataSanPham(listNew);
    }//GEN-LAST:event_cbbDSPBHActionPerformed

    private void cbbDGBHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbDGBHMouseClicked
        ListDG = deGiayService.getAll(null);
        ListDG.forEach((dg) -> {
            cbbDGBH.addItem(dg.getTen());
        });
    }//GEN-LAST:event_cbbDGBHMouseClicked

    private void cbbDGBHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbDGBHActionPerformed

        List<SanPhamViewModel> listNew = bhs.SearchSPBH(cbbDGBH.getSelectedItem().toString());
        showDataSanPham(listNew);
    }//GEN-LAST:event_cbbDGBHActionPerformed

    private void cbbMSBHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbMSBHMouseClicked
        listMS = mauSacService.getAllCustom();
        listMS.forEach((ms) -> {
            cbbMSBH.addItem(ms.getTen());
        });
    }//GEN-LAST:event_cbbMSBHMouseClicked

    private void cbbMSBHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMSBHActionPerformed

        List<SanPhamViewModel> listNew = bhs.SearchSPBH(cbbMSBH.getSelectedItem().toString());
        showDataSanPham(listNew);
    }//GEN-LAST:event_cbbMSBHActionPerformed

    private void btnThayDoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThayDoiActionPerformed

        int indexNV = cbbNhanVienBH.getSelectedIndex();
        NhanVienCustomModel nv = listNV.get(indexNV);

        int indexKHSDT = cbbSoDienThoai.getSelectedIndex();
        KhachHangCustomModel khSDT = listKHCM.get(indexKHSDT);

        String ma = lblMaHD.getText();
        if (ma.equals("HD___")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn muốn thay đổi");
        } else {
            HoaDonCustomModel hdUpdate2 = new HoaDonCustomModel(khSDT.getId(), nv.getId());
            JOptionPane.showMessageDialog(this, bhs.updateNVKH(hdUpdate2, ma));
            listHoaDons = bhs.getHoaDon();
            loadDataHoaDon(listHoaDons);
        }
    }//GEN-LAST:event_btnThayDoiActionPerformed

    private void btnThemKHBHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKHBHActionPerformed
        DailogKhachHangBH dkh = new DailogKhachHangBH(this, true);
        dkh.setVisible(true);
    }//GEN-LAST:event_btnThemKHBHActionPerformed

    private void btnReloadBHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadBHActionPerformed

        listKHCM = khs.getAllCustom();
        int itemCount3 = cbbSoDienThoai.getItemCount();
        for (int i = 0; i < itemCount3; i++) {
            cbbSoDienThoai.removeItemAt(0);
        }
        listKHCM.forEach((kh) -> {
            cbbSoDienThoai.addItem(kh.getSdt());
        });
        cbbSoDienThoai.setSelectedIndex(0);
    }//GEN-LAST:event_btnReloadBHActionPerformed

    private void cbbSoDienThoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSoDienThoaiActionPerformed
        int index = cbbSoDienThoai.getSelectedIndex();
        KhachHangCustomModel kh = listKHCM.get(index);
        txtTenKhachHangBH.setText(kh.getHoTen());
    }//GEN-LAST:event_cbbSoDienThoaiActionPerformed

    private void btnHuyHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyHoaDonActionPerformed
        int index = tblHoaDon.getSelectedRow();
        int sl = listGioHangS.size();

        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn muốn hủy");
        } else {
            var temp = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn hủy hóa đơn không ?");
            if (temp == 0) {
                if (listHoaDons != null) {
                    for (GioHangViewModel ghu : listGioHangS) {
                        int soLuongGH = ghu.getSoLuong();
                        String idCTSP = ghu.getIdCtsp();
                        ChiTietSanPhamHiber ctsp = new ChiTietSanPhamHiber(soLuongGH);
                        bhs.capNhatSoLuong(ctsp, idCTSP);

                    }
                    HoaDonViewModel hdid = listHoaDons.get(index);
                    String idHD = hdid.getId();
                    bhs.deleteHDCT(idHD);
                    bhs.deleteHD(idHD);
                    listSanPhams = bhs.getSanPhamVM();
                    listHoaDons = bhs.getHoaDon();
                    listGioHangS = bhs.getGioHang(idHD);
                    loadDataHoaDon(listHoaDons);
                    showDataSanPham(listSanPhams);
                    showDataGioHang(listGioHangS);
                    if (demTrangThai() < 6) {
                        btnTaoHoaDon.setEnabled(true);
                    }
                    lblMaHD.setText("Tạo");
                    lblThanhTien.setText("0");
                    txtGiamGia.setText("0");
                    lblThanhToan.setText("0");
                    txtTienKhachDua.setText("0");
                    lblTienThua.setText("0");
                }
            }
        }
    }//GEN-LAST:event_btnHuyHoaDonActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        var tempTT = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn làm mới không ?");
        if (tempTT == 0) {
            txtTienKhachDua.setText("0");
        }
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        long millis = System.currentTimeMillis();
        Date ngayThanhToan = new Date(millis);
        String ngayTaoHoaDOn = lblNgayTao.getText();
        String tenKH = txtTenKhachHangBH.getText();
        String sdtKH = cbbSoDienThoai.getSelectedItem().toString();
        String thanhToan = lblThanhToan.getText();
        String tienKhachDua = txtTienKhachDua.getText();
        String tienThua = lblTienThua.getText();
        int temp = 3;

        int soLuong = 0;
        for (GioHangViewModel gh : listGioHangS) {
            soLuong += gh.getSoLuong();
        }

        if (lblThanhTien.getText().equals("0.0")) {
            JOptionPane.showMessageDialog(this, "Vui lòng thêm sản phẩm trước khi thanh toán");
        } else if (txtTienKhachDua.getText().equals("0") || txtTienKhachDua.getText().matches("\\s+")) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin");
            txtTienKhachDua.setText("0");
        } else if (Double.valueOf(tienKhachDua) < Double.valueOf(thanhToan)) {
            JOptionPane.showMessageDialog(this, "Thiếu tiền, vui lòng nhập lại");
        } else {
            var tempTT = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thanh toán không ?");
            if (tempTT == 0) {
                String maHd = lblMaHD.getText();
                HoaDonViewModel hd = new HoaDonViewModel();
                hd.setNgayThanhToan(new Date(millis));
                hd.setTongTien(Double.valueOf(lblThanhToan.getText()));
                hd.setTongSanPham(soLuong);
                hd.setTrangThai(3);

                JOptionPane.showMessageDialog(this, bhs.updateTrangThai(hd, maHd));

                listHoaDons = bhs.getHoaDon();
                loadDataHoaDon(listHoaDons);

                listGioHangS = bhs.getGioHang(maHd);
                showDataGioHang(listGioHangS);
                txtHoaDonPDF.append("\nSHOP 6G SNEAKER\n"
                        + "\n              Hóa Đơn Thanh Toán \n"
                        + "---------------------------------------------------\n"
                        + "Ngày thanh toán:    " + ngayThanhToan + "\n"
                        + "Tên khách hàng:    " + tenKH + "\n"
                        + "Số điện thoại:         " + sdtKH + "\n"
                        + "Thành tiền:             " + thanhToan + "   VNĐ" + "\n"
                        + "Tiền khách đưa:     " + tienKhachDua + "   VNĐ" + "\n"
                        + "Tiền thừa:              " + tienThua + "   VNĐ" + "\n"
                        + "---------------------------------------------------\n"
                        + "              Cảm Ơn Quý Khách\n"
                );
                temp = JOptionPane.showConfirmDialog(this, "Bạn có muốn in hóa đơn không");
                btnThanhToan.setEnabled(false);
                btnHuyHoaDon.setEnabled(false);
                btnLamMoi.setEnabled(false);

            }
        }
        if (temp == 0) {
            try {
                txtHoaDonPDF.print();
            } catch (PrinterException ex) {
                Logger.getLogger(ViewBanHang.class.getName()).log(Level.SEVERE, null, ex);
            }
            lblMaHD.setText("Tạo");
            lblThanhTien.setText("0");
            txtGiamGia.setText("0");
            lblThanhToan.setText("0");
            txtTienKhachDua.setText("0");
            lblTienThua.setText("0");

        }
        if (demTrangThai() < 5) {
            btnTaoHoaDon.setEnabled(true);
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        // Tạo hóa đơn
        if (demTrangThai() > 3) {
            btnTaoHoaDon.setEnabled(false);
        }
        // Dùng cả random + listSize để không bị trùng
        Random random = new Random();
        int x = random.nextInt(10);
        int i = listFullHD.size();
        i++;
        long millis = System.currentTimeMillis();
        String maHD = "HD" + x + i;
        HoaDonViewModel hd = new HoaDonViewModel();
        hd.setKh("5e1b2703-d963-4aa4-b077-2cd04bcede6a");
        hd.setNv("4a2c2774-fc4f-4969-96ba-ce76b3ffdb0e");
        hd.setMa(maHD);
        hd.setNgayTao(new Date(millis));
        hd.setTrangThai(1);
        //Lưu hóa đơn tạo vào bảng hóa đơn
        bhs.saveHoaDon(hd);
        //Hóa đơn chờ
        listHoaDons = bhs.getHoaDon();

        //lấy listSize HD dầy đủ
        listFullHD = bhs.getHoaDonFull();
        loadDataHoaDon(listHoaDons);
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void cbo_locGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_locGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_locGiaActionPerformed

    private void btnDoiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiSanPhamActionPerformed
        int indexHDCT = tblHDCTDoiTra.getSelectedRow();
        int indexDT = tblDoiTra.getSelectedRow();

        DoiTraCustomModel dt = new DoiTraCustomModel();
        int indexHD = tblHoaDonDoiTra.getSelectedRow();
        if (indexHD < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn muốn đổi sản phẩm");
        } else if (indexHDCT < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phảm muốn đổi");
        } else {
            JOptionPane.showMessageDialog(this, "Đổi sản phẩm thành công");
            listDoiTra.clear();
            showDataDoiTra(listDoiTra);
            lblMaHDDoiTra.setText("_____");
            lblNgaDoiHangDT.setText("_____");
            lblTenKHDoiTra.setText("_____");
            txtGhiChu.setText("");
            cbbLiDoDoi.setSelectedIndex(0);
        }
    }//GEN-LAST:event_btnDoiSanPhamActionPerformed

    private void txtTimKiemDoiTraCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemDoiTraCaretUpdate
        listHDDT = dts.SearchHDDT(txtTimKiemDoiTra.getText());
        showDataHDDoiTra(listHDDT);
    }//GEN-LAST:event_txtTimKiemDoiTraCaretUpdate

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
        var temp = 0;
        long noDay = (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);
        if (noDay > 3) {
            temp = JOptionPane.showConfirmDialog(this, "Hóa đơn đã quá hạn đổi, bạn vẫn muốn tiếp tục đổi ?");
        }
        if (temp == 0) {
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
        long millis = System.currentTimeMillis();
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
                //                if (listDoiTra.size() == 1) {
                //                    JOptionPane.showMessageDialog(this, "Để thêm sản phẩm, hãy đổi sản phẩm trước đó");
                //                } else {
                soLuongDTBH = JOptionPane.showInputDialog("Mời nhập số lượng: ");
                if (soLuongDTBH != null) {
                    if (!soLuongDTBH.matches("[0-9]+")) {
                        JOptionPane.showMessageDialog(this, "Nhập đúng định dạng");
                    } else if (Integer.valueOf(soLuongDTBH) > hdct.getSoLuong()) {
                        JOptionPane.showMessageDialog(this, "Số lượng vượt quá");
                    } else if (txtGhiChu.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Vui lòng điền ghi chú");
                    } else {
                        var chon = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn đổi sản phẩm");

                        if (chon == 0) {
                            HoaDonDoiTraCustomModel hd = listHDDT.get(indexHD);
                            dt.setMaHD(lblMaHDDoiTra.getText());
                            dt.setTenKH(lblTenKHDoiTra.getText());
                            dt.setSanPhamDoi(hdct.getTenSP());
                            dt.setSoLuongDoi(Integer.valueOf(soLuongDTBH));
                            listDoiTra.add(dt);
                            showDataDoiTra(listDoiTra);

                            HoaDonDoiTraCustomModel hdc = listHDDT.get(indexHD);
                            String idCTSP = hdct.getIdCTSP();
                            String idHD = hdc.getId();
                            String idKH = hdc.getIdKH();
                            Date ngayDoi = new Date(millis);
                            String ghiChu = txtGhiChu.getText();
                            HoaDonDoiTraCustomModel hdadd = new HoaDonDoiTraCustomModel(idCTSP, idHD, idKH, ngayDoi, Integer.valueOf(soLuongDTBH), ghiChu);
                            HDCTDoiTraCustomModel hdctadd = new HDCTDoiTraCustomModel(Integer.valueOf(soLuongDTBH));
                            dts.doiTra(hdadd);
                            dts.capNhatSoLuong(hdctadd, idCTSP);
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_tblHDCTDoiTraMouseClicked

    private void btnThemVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemVoucherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemVoucherActionPerformed

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

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddNV;
    private javax.swing.JButton btnBanHang;
    private javax.swing.JButton btnCapNhatSP;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClearNV;
    private javax.swing.JButton btnClearVoucher;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeleteNV;
    private javax.swing.JButton btnDoiSanPham;
    private javax.swing.JButton btnDoiTra;
    private javax.swing.JButton btnHoaDonBanHang;
    private javax.swing.JButton btnHuyHoaDon;
    private javax.swing.JButton btnKetThuc;
    private javax.swing.JButton btnKhachhang;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnNhanVien;
    private javax.swing.JButton btnReloadBH;
    private javax.swing.JButton btnReloadCTSP;
    private javax.swing.JButton btnSanPham;
    private javax.swing.JButton btnSuaVoucher;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThayDoi;
    private javax.swing.JButton btnThemCV;
    private javax.swing.JButton btnThemKHBH;
    private javax.swing.JButton btnThemVoucher;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdateNV;
    private javax.swing.JButton btnVoucher;
    private javax.swing.JButton btnXoaSanPham;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_themDG1;
    private javax.swing.JButton btn_themDSP1;
    private javax.swing.JButton btn_themMS;
    private javax.swing.JButton btn_themSP;
    private javax.swing.JButton btn_xoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbChucVu;
    private javax.swing.JComboBox<String> cbbDGBH;
    private javax.swing.JComboBox<String> cbbDSPBH;
    private javax.swing.JComboBox<String> cbbLiDoDoi;
    private javax.swing.JComboBox<String> cbbLocTrangThaiHD;
    private javax.swing.JComboBox<String> cbbMSBH;
    private javax.swing.JComboBox<String> cbbMucGiamGia;
    private javax.swing.JComboBox<String> cbbNhanVienBH;
    private javax.swing.JComboBox<String> cbbSoDienThoai;
    private javax.swing.JComboBox<String> cbo_deGiay;
    private javax.swing.JComboBox<String> cbo_dongSanPham;
    private javax.swing.JComboBox<String> cbo_locDeGiay;
    private javax.swing.JComboBox<String> cbo_locDongSP;
    private javax.swing.JComboBox<String> cbo_locGia;
    private javax.swing.JComboBox<String> cbo_locMauSac;
    private javax.swing.JComboBox<String> cbo_mauSac;
    private javax.swing.JComboBox<String> cbo_sanPham;
    private javax.swing.JComboBox<String> cbo_trangThai;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JLabel labelTT;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbTenChucVu;
    private javax.swing.JLabel lbTenCuaHang;
    private javax.swing.JLabel lblGiamGia;
    private javax.swing.JLabel lblMaHD;
    private javax.swing.JLabel lblMaHDDoiTra;
    private javax.swing.JLabel lblNgaDoiHangDT;
    private javax.swing.JLabel lblNgayTao;
    private javax.swing.JLabel lblTenKHDoiTra;
    private javax.swing.JLabel lblThanhTien;
    private javax.swing.JLabel lblThanhToan;
    private javax.swing.JLabel lblTienThua;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lbl_deGiay;
    private javax.swing.JLabel lbl_dongSP;
    private javax.swing.JLabel lbl_giaBan;
    private javax.swing.JLabel lbl_kichCo;
    private javax.swing.JLabel lbl_locDeGiay;
    private javax.swing.JLabel lbl_locDongSP;
    private javax.swing.JLabel lbl_locGiaBan;
    private javax.swing.JLabel lbl_locMauSac;
    private javax.swing.JLabel lbl_mauSac;
    private javax.swing.JLabel lbl_ngayNhapHang;
    private javax.swing.JLabel lbl_sanPham;
    private javax.swing.JLabel lbl_soLuong;
    private javax.swing.JLabel lbl_trangThai;
    private javax.swing.JLabel lbl_xuatXu;
    private javax.swing.JPanel pnlBanHang;
    private javax.swing.JPanel pnlDoiTra;
    private javax.swing.JPanel pnlHoaDon;
    private javax.swing.JPanel pnlKhachHang;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlNhanVien;
    private javax.swing.JPanel pnlSanPhamChiTiet;
    private javax.swing.JPanel pnlThongKe;
    private javax.swing.JPanel pnlVoucher;
    private javax.swing.JPanel pnlWebcam;
    private javax.swing.JPanel pnlcards;
    private javax.swing.JRadioButton radioNam;
    private javax.swing.JRadioButton radioNu;
    private javax.swing.JTable tbHienThi;
    private javax.swing.JTable tblDoiTra;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHDCTDoiTra;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblHoaDonBanHang;
    private javax.swing.JTable tblHoaDonChiTietBH;
    private javax.swing.JTable tblHoaDonDoiTra;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTable tblVoucher;
    private javax.swing.JTable tbl_CTSanPham;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextArea txtGhiChuVoucher;
    private javax.swing.JTextField txtGiamGia;
    private javax.swing.JTextArea txtHoaDonPDF;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMaVoucher;
    private javax.swing.JTextField txtMatKhau;
    private com.toedter.calendar.JDateChooser txtNgayBatDau;
    private com.toedter.calendar.JDateChooser txtNgayHetHan;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtSdtNV;
    private javax.swing.JTextField txtTaiKhoan;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTenKhachHangBH;
    private javax.swing.JLabel txtTenQuanLy;
    private javax.swing.JTextField txtTenVoucher;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTimKiemDSSP;
    private javax.swing.JTextField txtTimKiemDoiTra;
    private javax.swing.JTextField txtTimKiemHoaDon;
    private javax.swing.JTextField txtTimKiemKH;
    private javax.swing.JTextField txtTimKiemNV;
    private javax.swing.JTextField txtTimKiemVoucher;
    private javax.swing.JTextField txt_giaBan;
    private javax.swing.JTextField txt_kichCo;
    private javax.swing.JTextField txt_ngayNhapHang;
    private javax.swing.JTextField txt_soLuong;
    private javax.swing.JTextField txt_timKiem;
    private javax.swing.JTextField txt_xuatXu;
    // End of variables declaration//GEN-END:variables
}
