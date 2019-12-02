package View;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.security.acl.Group;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import model.Date;
import model.SanPham;

public class FrameThemHang extends JFrame{
	JLabel lbStt, lbMaHang, lbTen, lbLoaiHang, lbHang4, lbNgay, lbThang, lbNam, lbTieuDe;
	JTextField txtStt, txtMaHang, txtTen, txtSoLuong, txtNgay, txtThang, txtNam;
	JPanel hang1, hang1_1, hang2, hang3, hang4, hang5, hang6;
	JRadioButton rdMacDinh, rdEdit;
	JButton btnThem, btnlamMoi;
	JComboBox<String> jcbPhanLoai = new JComboBox<String>();
	
	public FrameThemHang() {
		super("Thêm hàng vào kho");
		giaoDien();
		xuLiSuKien();
		hienThi();
	}

	private void giaoDien() {
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		lbTieuDe = new JLabel("THÊM HÀNG");
		lbTieuDe.setAlignmentX(CENTER_ALIGNMENT);

		// hang 1
		Dimension dimLb1 = new Dimension(80, 20);
		Dimension dimtxt1 = new Dimension(80, 30);
		hang1 = new JPanel(new FlowLayout());
		lbMaHang = new JLabel("Mã sản phẩm");
		lbMaHang.setPreferredSize(dimLb1);
		txtMaHang = new JTextField(10);
		txtMaHang.setEditable(false);// mã sản phẩm không thể thay đổi
		lbStt = new JLabel("Số thứ tự");
		lbStt.setPreferredSize(dimLb1);
		txtStt = new JTextField(3);
		txtStt.setEditable(false); // không cho nhập stt khi chọn thêm mặc định
		hang1_1 = new JPanel(new GridLayout(0, 1));// thêm 2 jradioBtn vào 1 panel để hiển thị d�?c
		rdMacDinh = new JRadioButton("Mặc định");
		rdEdit = new JRadioButton("Nhập vị trí");
		ButtonGroup G = new ButtonGroup();
		G.add(rdMacDinh);
		G.add(rdEdit);
		rdMacDinh.setSelected(true);// chọn thêm mặc định
		hang1_1.add(rdMacDinh);
		hang1_1.add(rdEdit);
		hang1.add(lbMaHang);
		hang1.add(txtMaHang);
		hang1.add(lbStt);
		hang1.add(txtStt);
		hang1.add(hang1_1);

		// hàng 2
		Dimension dimLb2 = new Dimension(120, 20);
		Dimension dimtxt2 = new Dimension(300, 20);
		hang2 = new JPanel();
		lbTen = new JLabel("Tên sản phẩm");
		lbTen.setPreferredSize(dimLb2);
		txtTen = new JTextField();
		txtTen.setPreferredSize(dimtxt2);
		hang2.add(lbTen);
		hang2.add(txtTen);

		// hàng 3
		hang3 = new JPanel();
		lbLoaiHang = new JLabel("Loại hàng");
		lbLoaiHang.setPreferredSize(dimLb2);
		jcbPhanLoai.setPreferredSize(dimtxt2);
		hang3.add(lbLoaiHang);
		hang3.add(jcbPhanLoai);

		// hàng 4
		Dimension dimLb4 = new Dimension(30, 20);
		Dimension dimtxt4 = new Dimension(60, 20);
		hang4 = new JPanel();
		txtSoLuong = new JTextField();
		txtNgay = new JTextField();
		txtNgay.setPreferredSize(dimtxt4);
		txtThang = new JTextField();
		txtThang.setPreferredSize(dimtxt4);
		txtNam = new JTextField();
		txtNam.setPreferredSize(dimtxt4);
		hang4.add(lbHang4 = new JLabel("Số lượng"));
		hang4.add(txtSoLuong);
		hang4.add(lbHang4 = new JLabel("Nhập vào ngày"));
		hang4.add(txtNgay);
		hang4.add(lbHang4 = new JLabel("Tháng"));
		hang4.add(txtThang);
		hang4.add(lbHang4 = new JLabel("Năm"));
		hang4.add(txtNam);
		lbHang4.setPreferredSize(dimLb4);
		txtSoLuong.setPreferredSize(dimtxt4);

		// hàng 5
		hang5 = new JPanel();
		hang5.add(btnThem = new JButton("THÊM"));
		hang5.add(btnlamMoi = new JButton("LÀM MỚI"));

		// hàng 6
		hang6 = new JPanel();
		JLabel lbVer = new JLabel("<html><i>Version 1.0</i></html>");
		lbVer.setAlignmentX(CENTER_ALIGNMENT);
		hang6.add(lbVer);

		add(lbTieuDe);
		add(hang1);
		add(hang2);
		add(hang3);
		add(hang4);
		add(hang5);
		add(hang6);
	}

	
	
	private void xuLiSuKien() {
		//bắt sự kiện nút close
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				SanPham.id++;
			}
		});
		
		// xử lí radio Edit và Default
		rdEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtStt.setEditable(true);
			}
		});
		rdMacDinh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtStt.setEditable(false);
			}
		});
		
		// chức năng làm mới
		btnlamMoi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtTen.setText("");
				txtSoLuong.setText("");
				txtNgay.setText("");
				txtThang.setText("");
				txtNam.setText("");
			}
		});
		
		//chức năng Thêm
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					 
					int stt = Integer.parseInt(txtStt.getText());
					int id = Integer.parseInt(txtMaHang.getText());
					String tenSp = txtTen.getText();
					int soLuong = Integer.parseInt(txtSoLuong.getText());
					int ngay = Integer.parseInt(txtNgay.getText());
					int thang = Integer.parseInt(txtThang.getText());
					int nam = Integer.parseInt(txtNam.getText());
					
					SanPham sp = new SanPham(id, tenSp, soLuong, new Date(ngay, thang, nam));
					JOptionPane.showMessageDialog(null, "Thêm thành công !!!");
					dispose();
					
				} catch (Exception e2) {
					SanPham.id--;
					System.out.println(SanPham.id);
					JOptionPane.showMessageDialog(null, "vui lòng nhập lại");
				}
			}
		});
		
	}

	private void hienThi() {
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
