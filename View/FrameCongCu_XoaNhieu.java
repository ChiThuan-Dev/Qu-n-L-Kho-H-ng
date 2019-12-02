package View;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class FrameCongCu_XoaNhieu extends JFrame{
	JTextField txtTimKiem;
	JButton btnTimKiem,btnThem,btnXoa;
	JTextArea areaKQ, areaXoa;
	JPanel hang1, hang2, hang3, hang4,hang5;
	JScrollPane jscHang2, jscHang3;
	
	public FrameCongCu_XoaNhieu() {
		super("Xóa nhi�?u sản phẩm");
		giaoDien();
		hienThi();
	}
	
	private void giaoDien() {
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		JLabel lbTieuDe = new JLabel("XÓA");
		lbTieuDe.setAlignmentX(CENTER_ALIGNMENT);
		
		//hàng 1
		hang1 = new JPanel();
		Dimension dimTimKiem = new Dimension(220, 27);
		hang1.add(txtTimKiem = new JTextField());
		txtTimKiem.setPreferredSize(dimTimKiem);
		hang1.add(btnTimKiem = new JButton("Tìm Kiếm"));
		
		//hàng 2
		hang2 = new JPanel();
		JPanel hang2_1 = new JPanel(); // chuyển dấu cộng qua cuối bên phải
		hang2_1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		hang2.setLayout(new BoxLayout(hang2, BoxLayout.Y_AXIS));;
		hang2.setBorder(new TitledBorder("Kết Quả"));
		areaKQ = new JTextArea(10,50);
		jscHang2 = new JScrollPane(areaKQ);
		hang2.add(jscHang2);
		hang2_1.add(btnThem = new JButton("+"));
		hang2.add(hang2_1);
		
		//hàng 3
		hang3 = new JPanel();
		hang3.setBorder(new TitledBorder("Sản phẩm đã ch�?n"));
		areaXoa = new JTextArea(10,50);
		jscHang3 = new JScrollPane(areaXoa);
		hang3.add(jscHang3);
		
		//hàng 4
		hang4 = new JPanel();
		hang4.add(btnXoa = new JButton("XÓA TẤT CẢ"));
		//hàng 5
		hang5 = new JPanel();
		JLabel lbVer = new JLabel("<html><i>Version 1.0</i></html>");
		lbVer.setAlignmentX(CENTER_ALIGNMENT);
		hang5.add(lbVer);
		
		add(lbTieuDe);
		add(hang1);
		add(hang2);
		add(hang3);
		add(hang4);
		add(hang5);

	}
	
	private void hienThi() {
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
