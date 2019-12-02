package View;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class FrameXuatHang extends JFrame{
	JTextField txtTimKiem, txtSoLuong;
	JButton btnTimKiem,btnXuat;
	String[] tenCot = {"Mã Hàng","Tên Hàng","Loại Hàng","Số Lượng","Ngày Nhập"};
	Object[][] Data = {
			{1,2,3,4,5},
	};
	JTable table;
	JPanel hang1, hang2, hang3, hang4;
	public FrameXuatHang() {
		super("Xuất hàng");
		giaoDien();
		hienThi();
	}
	private void giaoDien() {
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		JLabel lbTieuDe = new JLabel("XUẤT HÀNG");// tiêu đ�?
		lbTieuDe.setAlignmentX(CENTER_ALIGNMENT);
		
		//hàng 1
		hang1 = new JPanel();
		Dimension dimTxt = new Dimension(200, 27);
		txtTimKiem = new JTextField();
		txtTimKiem.setPreferredSize(dimTxt);
		btnTimKiem = new JButton("Tìm kiếm");
		hang1.add(txtTimKiem);
		hang1.add(btnTimKiem);
		
		//hàng2
		hang2 = new JPanel();
		table = new JTable(Data, tenCot);
		JScrollPane jsc = new JScrollPane(table);
		hang2.add(jsc);
		
		//hàng 3
		hang3 = new JPanel();
		hang3.add(new JLabel("Nhập số lượng"));
		hang3.add(txtSoLuong = new JTextField(4));
		hang3.add(btnXuat = new JButton("XUẤT"));
		
		//hàng 4
		hang4 = new JPanel();
		JLabel lbVer = new JLabel("<html><i>Version 1.0</i></html>");
		lbVer.setAlignmentX(CENTER_ALIGNMENT);
		hang4.add(lbVer);
		
		add(lbTieuDe);
		add(hang1);
		add(hang2);
		add(hang3);
		add(hang4);
	}
	
	private void hienThi() {
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		FrameXuatHang test = new FrameXuatHang();
	}
}
