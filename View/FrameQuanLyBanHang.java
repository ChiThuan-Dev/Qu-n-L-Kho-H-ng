package View;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.SanPham;

public class FrameQuanLyBanHang extends JFrame{
	public JButton btnThemHang, btnTimKiem,btnCongCu, btnXuatHang;
	JLabel lbTieuDe, lbLoaiHang, lbversion;
	JPanel hang1,hang1_1,hang1_2,hang2,hang3;
	JTextField txtTimKiem;
	String[] tenCot = {"Số thứ tự","Mã Hàng","Tên Hàng","Loại Hàng","Số Lượng","Ngày Nhập"};
	Object[][] Data = {
			{0,1,2,3,4,5},
			{1, 6,7,8,9,10}
	};
	JComboBox<String> jcbLoaiHang = new JComboBox<String>(); // Sửa lại kiểu dữ liệu
	FrameThemHang themHangUI = new FrameThemHang();
	FrameXuatHang xuatHangUI = new FrameXuatHang();
	FrameCongCu congCu = new FrameCongCu();
	
	public FrameQuanLyBanHang() {
		super("Quản lý kho hàng");
		giaoDien();
		xuLiSuKien();
		hienThi();
	}
	
	private void giaoDien () {
		
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		//tieu de
		lbTieuDe = new JLabel("QUẢN Lý KHO HÀNG");
		lbTieuDe.setAlignmentX(CENTER_ALIGNMENT);
		
		//hang 1
		Dimension dimTxT = new Dimension(130, 25);
		Dimension dimButton = new Dimension(30, 25);
		hang1 = new JPanel(new FlowLayout());
		btnThemHang = new JButton("Thêm hàng");
		hang1.add(btnThemHang);
		hang1_1 = new JPanel();
		txtTimKiem = new JTextField();
		txtTimKiem.setPreferredSize(dimTxT);
		hang1_1.add(txtTimKiem);
		hang1_1.add(btnTimKiem = new JButton("Tìm kiếm"));
		hang1.add(hang1_1);
		hang1_2 = new JPanel();
		hang1_2.add(lbLoaiHang = new JLabel("Loại hàng"));
		jcbLoaiHang.setPreferredSize(dimTxT);
		hang1_2.add(jcbLoaiHang);
		hang1.add(hang1_2);
		hang1.add(btnCongCu = new JButton("Công cụ"));
		hang1.add(btnXuatHang = new JButton("Xuất hàng"));
		
		//hang2
		hang2 = new JPanel();
		JTable table = new JTable(Data,tenCot);
		JScrollPane hehe = new JScrollPane(table);
		hang2.add(hehe);
		
		//hang 3
		hang3 = new JPanel();
		lbversion = new JLabel("Version 1.0");
		lbversion.setAlignmentX(CENTER_ALIGNMENT);
		hang3.add(lbversion);
		
		add(lbTieuDe);
		add(hang1);
		add(hang2);
		add(hang3);
	}
	
	private void hienThi() {
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void xuLiSuKien () {
		//Thêm hàng
		btnThemHang.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				themHangUI.txtMaHang.setText("" +SanPham.id++);// tự động tăng id
				themHangUI.setVisible(true);
				
			}
		});
		
		//xuất hàng
		btnXuatHang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				xuatHangUI.setVisible(true);
			}
		});
		
		//công cụ
		btnCongCu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				congCu.setVisible(true);
			}
		});
	
	}
}
