package view;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Guide extends JFrame {

	private JPanel contentPane;
	
	public Guide() {
		setVisible(true);
		setTitle("Hướng dẫn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 569);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new FlowLayout()); // Sử dụng FlowLayout
        
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(520, 5800));// Đặt kích thước ưu tiên cho panel
        panel.setBackground(Color.CYAN);
        panel.setLayout(null);
        
        JButton btnHome = new JButton("TRANG CHỦ");
        btnHome.setForeground(new Color(255, 255, 255));
        btnHome.setBackground(new Color(192, 192, 192));
        btnHome.setFont(new Font("Cambria Math", Font.BOLD, 15));
        btnHome.setIcon(new ImageIcon(Guide.class.getResource("/images/Home-32.png")));
        btnHome.setBounds(697, 0, 184, 35);
        btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btnHome.setBackground(new Color(192, 192, 192));
				btnHome.setForeground(new Color(255, 255, 255));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnHome.setBackground(new Color(255, 255, 255));
				btnHome.setForeground(new Color(0, 0, 0));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				MainPage jframeMainPage = new MainPage();
				SwingUtilities.getWindowAncestor(btnHome).dispose();
				
			}
		});
        panel.add(btnHome);
        
        JLabel jlb_title1 = new JLabel("HƯỚNG DẪN CHESS GAME");
        jlb_title1.setVerticalAlignment(SwingConstants.BOTTOM);
        jlb_title1.setHorizontalAlignment(SwingConstants.CENTER);
        jlb_title1.setFont(new Font("Cambria Math", Font.BOLD, 65));
        jlb_title1.setSize(860, 100);
        jlb_title1.setLocation(10, 20);
        jlb_title1.setForeground(new Color(255,87,87));
        panel.add(jlb_title1);
        
        JLabel jlb_titleChild1 = new JLabel("Giới thiệu về chess game");
        jlb_titleChild1.setVerticalAlignment(SwingConstants.BOTTOM);
        jlb_titleChild1.setHorizontalAlignment(SwingConstants.CENTER);
        jlb_titleChild1.setFont(new Font("Cambria Math", Font.BOLD, 55));
        jlb_titleChild1.setSize(850, 80);
        jlb_titleChild1.setLocation(20, 100);
        jlb_titleChild1.setForeground(new Color(0, 0, 0));
        panel.add(jlb_titleChild1);
        
        JLabel jlb_text1_titleChild1 = new JLabel("  + Cờ vua ( chess game) là một trò chơi board game dành cho hai người. Là một trong những trò ");
        jlb_text1_titleChild1.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text1_titleChild1.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text1_titleChild1.setSize(860, 30);
        jlb_text1_titleChild1.setLocation(10, 180);
        jlb_text1_titleChild1.setForeground(new Color(0, 0, 0));
        panel.add(jlb_text1_titleChild1);
        
        JLabel jlb_text2_titleChild1 = new JLabel("chơi phổ biến nhất thế giới, được hàng triệu người trên toàn thế giới chơi tại nhà, trên trực tuyến, . . .");
        jlb_text2_titleChild1.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text2_titleChild1.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text2_titleChild1.setSize(860, 30);
        jlb_text2_titleChild1.setLocation(10, 210);
        jlb_text2_titleChild1.setForeground(new Color(0, 0, 0));
        panel.add(jlb_text2_titleChild1);
        
        JLabel jlb_text3_titleChild1 = new JLabel("  + Cờ vua không phải là một trò chơi may rủi, nó dựa thuần túy vào chiến thuật và chiến lược. Tuy");
        jlb_text3_titleChild1.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text3_titleChild1.setForeground(Color.BLACK);
        jlb_text3_titleChild1.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text3_titleChild1.setBounds(10, 240, 860, 30);
        panel.add(jlb_text3_titleChild1);
        
        JLabel jlb_text4_titleChild1 = new JLabel("thế, trò chơi này phức tạp đến mức thậm chí cả những người chơi hay nhất cũng không thể tính hết");
        jlb_text4_titleChild1.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text4_titleChild1.setForeground(Color.BLACK);
        jlb_text4_titleChild1.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text4_titleChild1.setBounds(10, 270, 860, 30);
        panel.add(jlb_text4_titleChild1);
        
        JLabel jlb_text5_titleChild1 = new JLabel("tất cả mọi phương án.");
        jlb_text5_titleChild1.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text5_titleChild1.setForeground(Color.BLACK);
        jlb_text5_titleChild1.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text5_titleChild1.setBounds(10, 300, 860, 30);
        panel.add(jlb_text5_titleChild1);
        
        JLabel jlb_titleChild2 = new JLabel("Hướng dẫn sử dụng giao diện");
        jlb_titleChild2.setVerticalAlignment(SwingConstants.BOTTOM);
        jlb_titleChild2.setHorizontalAlignment(SwingConstants.CENTER);
        jlb_titleChild2.setForeground(Color.BLACK);
        jlb_titleChild2.setFont(new Font("Cambria Math", Font.BOLD, 55));
        jlb_titleChild2.setBounds(20, 330, 850, 80);
        panel.add(jlb_titleChild2);
        
        JLabel jlb_text1_titleChild2 = new JLabel("1. Giao diện đăng nhập :");
        jlb_text1_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text1_titleChild2.setForeground(Color.BLACK);
        jlb_text1_titleChild2.setFont(new Font("Cambria Math", Font.BOLD, 30));
        jlb_text1_titleChild2.setBounds(10, 410, 860, 30);
        panel.add(jlb_text1_titleChild2);
        
        JLabel jlb_text2_titleChild2 = new JLabel("");
        jlb_text2_titleChild2.setIcon(new ImageIcon(Guide.class.getResource("/images/UILogin(1).png")));
        jlb_text2_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text2_titleChild2.setForeground(Color.BLACK);
        jlb_text2_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text2_titleChild2.setBounds(10, 440, 480, 274);
        panel.add(jlb_text2_titleChild2);
        
        JLabel jlb_text3_titleChild2 = new JLabel("Giao diện đăng nhập khi mới chạy chương ");
        jlb_text3_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text3_titleChild2.setForeground(Color.BLACK);
        jlb_text3_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text3_titleChild2.setBounds(500, 550, 370, 30);
        panel.add(jlb_text3_titleChild2);
        
        JLabel jlb_text4_titleChild2 = new JLabel("trình");
        jlb_text4_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text4_titleChild2.setForeground(Color.BLACK);
        jlb_text4_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text4_titleChild2.setBounds(500, 580, 370, 30);
        panel.add(jlb_text4_titleChild2);
        
        JLabel jlb_text5_titleChild2 = new JLabel("");
        jlb_text5_titleChild2.setIcon(new ImageIcon(Guide.class.getResource("/images/UILogin(2).png")));
        jlb_text5_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text5_titleChild2.setForeground(Color.BLACK);
        jlb_text5_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text5_titleChild2.setBounds(10, 725, 480, 274);
        panel.add(jlb_text5_titleChild2);
        
        JLabel jlb_text6_titleChild2 = new JLabel("Nhấn vào nút đăng ký nếu bạn chưa có");
        jlb_text6_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text6_titleChild2.setForeground(Color.BLACK);
        jlb_text6_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text6_titleChild2.setBounds(500, 835, 370, 30);
        panel.add(jlb_text6_titleChild2);
        
        JLabel jlb_text7_titleChild2 = new JLabel("tài khoản");
        jlb_text7_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text7_titleChild2.setForeground(Color.BLACK);
        jlb_text7_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text7_titleChild2.setBounds(500, 865, 370, 30);
        panel.add(jlb_text7_titleChild2);
        
        JLabel jlb_tex8_titleChild2 = new JLabel("");
        jlb_tex8_titleChild2.setIcon(new ImageIcon(Guide.class.getResource("/images/UILogin(3).png")));
        jlb_tex8_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_tex8_titleChild2.setForeground(Color.BLACK);
        jlb_tex8_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_tex8_titleChild2.setBounds(10, 1010, 480, 274);
        panel.add(jlb_tex8_titleChild2);
        
        JLabel jlb_text9_titleChild2 = new JLabel("Nhập tên đăng nhập và mật khẩu của bạn");
        jlb_text9_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text9_titleChild2.setForeground(Color.BLACK);
        jlb_text9_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text9_titleChild2.setBounds(500, 1120, 370, 30);
        panel.add(jlb_text9_titleChild2);
        
        JLabel jlb_text10_titleChild2 = new JLabel("sau đó nhấn vào nút đăng nhập để tiến vào");
        jlb_text10_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text10_titleChild2.setForeground(Color.BLACK);
        jlb_text10_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text10_titleChild2.setBounds(500, 1150, 370, 30);
        panel.add(jlb_text10_titleChild2);
        
        JLabel jlb_text11_titleChild2 = new JLabel("giao diện chính của trò chơi ");
        jlb_text11_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text11_titleChild2.setForeground(Color.BLACK);
        jlb_text11_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text11_titleChild2.setBounds(500, 1180, 370, 30);
        panel.add(jlb_text11_titleChild2);
        
        JLabel jlb_text12_titleChild2 = new JLabel("2. Giao diện đăng ký :");
        jlb_text12_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text12_titleChild2.setForeground(Color.BLACK);
        jlb_text12_titleChild2.setFont(new Font("Cambria Math", Font.BOLD, 30));
        jlb_text12_titleChild2.setBounds(10, 1300, 860, 30);
        panel.add(jlb_text12_titleChild2);
        
        JLabel jlb_tex13_titleChild2 = new JLabel("");
        jlb_tex13_titleChild2.setIcon(new ImageIcon(Guide.class.getResource("/images/UIRegister(1).png")));
        jlb_tex13_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_tex13_titleChild2.setForeground(Color.BLACK);
        jlb_tex13_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_tex13_titleChild2.setBounds(10, 1340, 480, 274);
        panel.add(jlb_tex13_titleChild2);
        
        JLabel jlb_text14_titleChild2 = new JLabel("Giao diện đăng ký ");
        jlb_text14_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text14_titleChild2.setForeground(Color.BLACK);
        jlb_text14_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text14_titleChild2.setBounds(500, 1455, 370, 30);
        panel.add(jlb_text14_titleChild2);
        
        JLabel jlb_tex15_titleChild2 = new JLabel("");
        jlb_tex15_titleChild2.setIcon(new ImageIcon(Guide.class.getResource("/images/UIRegister(2).png")));
        jlb_tex15_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_tex15_titleChild2.setForeground(Color.BLACK);
        jlb_tex15_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_tex15_titleChild2.setBounds(10, 1625, 480, 274);
        panel.add(jlb_tex15_titleChild2);
        
        JLabel jlb_text16_titleChild2 = new JLabel("Nếu đã có tài khoảng hãy nhấn vào nút");
        jlb_text16_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text16_titleChild2.setForeground(Color.BLACK);
        jlb_text16_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text16_titleChild2.setBounds(500, 1730, 370, 30);
        panel.add(jlb_text16_titleChild2);
        
        JLabel jlb_text17_titleChild2 = new JLabel("'đã có tài khoản' để trở về trang đăng nhập");
        jlb_text17_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text17_titleChild2.setForeground(Color.BLACK);
        jlb_text17_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text17_titleChild2.setBounds(500, 1760, 370, 30);
        panel.add(jlb_text17_titleChild2);
        
        JLabel jlb_tex18_titleChild2 = new JLabel("");
        jlb_tex18_titleChild2.setIcon(new ImageIcon(Guide.class.getResource("/images/UIRegister(3).png")));
        jlb_tex18_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_tex18_titleChild2.setForeground(Color.BLACK);
        jlb_tex18_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_tex18_titleChild2.setBounds(10, 1910, 480, 274);
        panel.add(jlb_tex18_titleChild2);
        
        JLabel jlb_text19_titleChild2 = new JLabel("Sau khi nhập đủ thông tin cần thiết hãy ");
        jlb_text19_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text19_titleChild2.setForeground(Color.BLACK);
        jlb_text19_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text19_titleChild2.setBounds(500, 2025, 370, 30);
        panel.add(jlb_text19_titleChild2);
        
        JLabel jlb_text20_titleChild2 = new JLabel("nhấn vào 'Đăng ký' để cập nhật thông tin");
        jlb_text20_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text20_titleChild2.setForeground(Color.BLACK);
        jlb_text20_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text20_titleChild2.setBounds(500, 2055, 370, 30);
        panel.add(jlb_text20_titleChild2);
        
        JLabel jlb_text21_titleChild2 = new JLabel("của bạn vào trò chơi");
        jlb_text21_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text21_titleChild2.setForeground(Color.BLACK);
        jlb_text21_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text21_titleChild2.setBounds(500, 2085, 370, 30);
        panel.add(jlb_text21_titleChild2);
        
        JLabel jlb_text22_titleChild2 = new JLabel("3. Giao diện chính :");
        jlb_text22_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text22_titleChild2.setForeground(Color.BLACK);
        jlb_text22_titleChild2.setFont(new Font("Cambria Math", Font.BOLD, 30));
        jlb_text22_titleChild2.setBounds(10, 2195, 860, 30);
        panel.add(jlb_text22_titleChild2);
        
        JLabel jlb_tex23_titleChild2 = new JLabel("");
        jlb_tex23_titleChild2.setIcon(new ImageIcon(Guide.class.getResource("/images/UImain(1).png")));
        jlb_tex23_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_tex23_titleChild2.setForeground(Color.BLACK);
        jlb_tex23_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_tex23_titleChild2.setBounds(10, 2235, 480, 274);
        panel.add(jlb_tex23_titleChild2);
        
        JLabel jlb_text24_titleChild2 = new JLabel("Sau khi đăng nhập thành công bạn sẽ vào");
        jlb_text24_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text24_titleChild2.setForeground(Color.BLACK);
        jlb_text24_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text24_titleChild2.setBounds(500, 2350, 370, 30);
        panel.add(jlb_text24_titleChild2);
        
        JLabel jlb_text25_titleChild2 = new JLabel("trang chính của trò chơi. Ở đây bạn có thể");
        jlb_text25_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text25_titleChild2.setForeground(Color.BLACK);
        jlb_text25_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text25_titleChild2.setBounds(500, 2380, 370, 30);
        panel.add(jlb_text25_titleChild2);
        
        
        JLabel jlb_text26_titleChild2 = new JLabel("điều hướng đến nhiều trang khác của trò");
        jlb_text26_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text26_titleChild2.setForeground(Color.BLACK);
        jlb_text26_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text26_titleChild2.setBounds(500, 2410, 370, 30);
        panel.add(jlb_text26_titleChild2);
        
        JLabel jlb_text27_titleChild2 = new JLabel("chơi !");
        jlb_text27_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text27_titleChild2.setForeground(Color.BLACK);
        jlb_text27_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text27_titleChild2.setBounds(500, 2440, 370, 30);
        panel.add(jlb_text27_titleChild2);
        
        JLabel jlb_tex28_titleChild2 = new JLabel("");
        jlb_tex28_titleChild2.setIcon(new ImageIcon(Guide.class.getResource("/images/UImain(2).png")));
        jlb_tex28_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_tex28_titleChild2.setForeground(Color.BLACK);
        jlb_tex28_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_tex28_titleChild2.setBounds(10, 2520, 480, 274);
        panel.add(jlb_tex28_titleChild2);
        
        JLabel jlb_text29_titleChild2 = new JLabel("Bạn có thể xem xếp hạng của bạn thông");
        jlb_text29_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text29_titleChild2.setForeground(Color.BLACK);
        jlb_text29_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text29_titleChild2.setBounds(500, 2635, 370, 30);
        panel.add(jlb_text29_titleChild2);
        
        JLabel jlb_text30_titleChild2 = new JLabel("qua bảng xếp hạng");
        jlb_text30_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text30_titleChild2.setForeground(Color.BLACK);
        jlb_text30_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text30_titleChild2.setBounds(500, 2665, 370, 30);
        panel.add(jlb_text30_titleChild2);
        
        JLabel jlb_tex31_titleChild2 = new JLabel("");
        jlb_tex31_titleChild2.setIcon(new ImageIcon(Guide.class.getResource("/images/UImain(3).png")));
        jlb_tex31_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_tex31_titleChild2.setForeground(Color.BLACK);
        jlb_tex31_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_tex31_titleChild2.setBounds(10, 2805, 480, 274);
        panel.add(jlb_tex31_titleChild2);
        
        JLabel jlb_text32_titleChild2 = new JLabel("Vào ngay 'chế độ chơi' và thể hiện hết");
        jlb_text32_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text32_titleChild2.setForeground(Color.BLACK);
        jlb_text32_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text32_titleChild2.setBounds(500, 2920, 370, 30);
        panel.add(jlb_text32_titleChild2);
        
        JLabel jlb_text33_titleChild2 = new JLabel("khả năng của bạn nào !");
        jlb_text33_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text33_titleChild2.setForeground(Color.BLACK);
        jlb_text33_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text33_titleChild2.setBounds(500, 2950, 370, 30);
        panel.add(jlb_text33_titleChild2);
        
        JLabel jlb_tex34_titleChild2 = new JLabel("");
        jlb_tex34_titleChild2.setIcon(new ImageIcon(Guide.class.getResource("/images/UImain(4).png")));
        jlb_tex34_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_tex34_titleChild2.setForeground(Color.BLACK);
        jlb_tex34_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_tex34_titleChild2.setBounds(10, 3090, 480, 274);
        panel.add(jlb_tex34_titleChild2);
        
        JLabel jlb_text35_titleChild2 = new JLabel("vào 'hướng dẫn' để hiểu hơn về chúng tôi");
        jlb_text35_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text35_titleChild2.setForeground(Color.BLACK);
        jlb_text35_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text35_titleChild2.setBounds(500, 3205, 370, 30);
        panel.add(jlb_text35_titleChild2);
        
        JLabel jlb_tex36_titleChild2 = new JLabel("");
        jlb_tex36_titleChild2.setIcon(new ImageIcon(Guide.class.getResource("/images/UImain(5).png")));
        jlb_tex36_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_tex36_titleChild2.setForeground(Color.BLACK);
        jlb_tex36_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_tex36_titleChild2.setBounds(10, 3375, 480, 274);
        panel.add(jlb_tex36_titleChild2);
        
        JLabel jlb_text37_titleChild2 = new JLabel("Bạn muốn nghỉ ngơi rồi sao. Hãy nhấn vào");
        jlb_text37_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text37_titleChild2.setForeground(Color.BLACK);
        jlb_text37_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text37_titleChild2.setBounds(500, 3490, 370, 30);
        panel.add(jlb_text37_titleChild2);
        
        JLabel jlb_text38_titleChild2 = new JLabel("'thoát' và hẹn gặp lại bạn vào lần sau");
        jlb_text38_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text38_titleChild2.setForeground(Color.BLACK);
        jlb_text38_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text38_titleChild2.setBounds(500, 3520, 370, 30);
        panel.add(jlb_text38_titleChild2);
        
        JLabel jlb_text39_titleChild2 = new JLabel("4. Giao diện bảng xếp hạng :");
        jlb_text39_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text39_titleChild2.setForeground(Color.BLACK);
        jlb_text39_titleChild2.setFont(new Font("Cambria Math", Font.BOLD, 30));
        jlb_text39_titleChild2.setBounds(10, 3660, 860, 30);
        panel.add(jlb_text39_titleChild2);
        
        JLabel jlb_tex40_titleChild2 = new JLabel("");
        jlb_tex40_titleChild2.setIcon(new ImageIcon(Guide.class.getResource("/images/UImain(5).png")));
        jlb_tex40_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_tex40_titleChild2.setForeground(Color.BLACK);
        jlb_tex40_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_tex40_titleChild2.setBounds(10, 3690, 480, 274);
        panel.add(jlb_tex40_titleChild2);
        
        JLabel jlb_text41_titleChild2 = new JLabel("Bạn đang ở hạng thấp ư ?");
        jlb_text41_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text41_titleChild2.setForeground(Color.BLACK);
        jlb_text41_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text41_titleChild2.setBounds(500, 3775, 370, 30);
        panel.add(jlb_text41_titleChild2);
        
        JLabel jlb_text42_titleChild2 = new JLabel("Bạn muốn thăng hạng ?");
        jlb_text42_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text42_titleChild2.setForeground(Color.BLACK);
        jlb_text42_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text42_titleChild2.setBounds(500, 3805, 370, 30);
        panel.add(jlb_text42_titleChild2);
        
        JLabel jlb_text43_titleChild2 = new JLabel("Đừng lo lắng, bạn cứ việc chiến đấu hết");
        jlb_text43_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text43_titleChild2.setForeground(Color.BLACK);
        jlb_text43_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text43_titleChild2.setBounds(500, 3835, 370, 30);
        panel.add(jlb_text43_titleChild2);
        
        JLabel jlb_text44_titleChild2 = new JLabel("sức, điểm của bạn sẽ được cập nhật liên");
        jlb_text44_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text44_titleChild2.setForeground(Color.BLACK);
        jlb_text44_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text44_titleChild2.setBounds(500, 3865, 370, 30);
        panel.add(jlb_text44_titleChild2);
        
        JLabel jlb_text45_titleChild2 = new JLabel("tục tại đây !!");
        jlb_text45_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text45_titleChild2.setForeground(Color.BLACK);
        jlb_text45_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text45_titleChild2.setBounds(500, 3895, 370, 30);
        panel.add(jlb_text45_titleChild2);
        
        JLabel jlb_text46_titleChild2 = new JLabel("5. Giao diện chế độ chơi :");
        jlb_text46_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text46_titleChild2.setForeground(Color.BLACK);
        jlb_text46_titleChild2.setFont(new Font("Cambria Math", Font.BOLD, 30));
        jlb_text46_titleChild2.setBounds(10, 3975, 860, 30);
        panel.add(jlb_text46_titleChild2);
        
        JLabel jlb_tex47_titleChild2 = new JLabel("");
        jlb_tex47_titleChild2.setIcon(new ImageIcon(Guide.class.getResource("/images/UIModePlay(1).png")));
        jlb_tex47_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_tex47_titleChild2.setForeground(Color.BLACK);
        jlb_tex47_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_tex47_titleChild2.setBounds(10, 4005, 480, 274);
        panel.add(jlb_tex47_titleChild2);
        
        JLabel jlb_text48_titleChild2 = new JLabel("Offline hay Online ??");
        jlb_text48_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text48_titleChild2.setForeground(Color.BLACK);
        jlb_text48_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text48_titleChild2.setBounds(500, 4120, 370, 30);
        panel.add(jlb_text48_titleChild2);
        
        JLabel jlb_text49_titleChild2 = new JLabel("Hãy chọn chế độ bạn muốn chơi nào");
        jlb_text49_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text49_titleChild2.setForeground(Color.BLACK);
        jlb_text49_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text49_titleChild2.setBounds(500, 4150, 370, 30);
        panel.add(jlb_text49_titleChild2);
        
        JLabel jlb_text50_titleChild2 = new JLabel("");
        jlb_text50_titleChild2.setIcon(new ImageIcon(Guide.class.getResource("/images/UIModePlay(2).png")));
        jlb_text50_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text50_titleChild2.setForeground(Color.BLACK);
        jlb_text50_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text50_titleChild2.setBounds(10, 4290, 480, 274);
        panel.add(jlb_text50_titleChild2);
        
        JLabel jlb_text51_titleChild2 = new JLabel("Bạn chưa sẵn sàng thực chiến ?");
        jlb_text51_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text51_titleChild2.setForeground(Color.BLACK);
        jlb_text51_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text51_titleChild2.setBounds(500, 4405, 370, 30);
        panel.add(jlb_text51_titleChild2);
                
        JLabel jlb_text52_titleChild2 = new JLabel("Có thể luyện tập trước với AI bằng cách");
        jlb_text52_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text52_titleChild2.setForeground(Color.BLACK);
        jlb_text52_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text52_titleChild2.setBounds(500, 4435, 370, 30);
        panel.add(jlb_text52_titleChild2);
        
        JLabel jlb_text53_titleChild2 = new JLabel("nhấn vào nút 'máy'");
        jlb_text53_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text53_titleChild2.setForeground(Color.BLACK);
        jlb_text53_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text53_titleChild2.setBounds(500, 4465, 370, 30);
        panel.add(jlb_text53_titleChild2);
        
        JLabel jlb_text54_titleChild2 = new JLabel("");
        jlb_text54_titleChild2.setIcon(new ImageIcon(Guide.class.getResource("/images/UIModePlay(3).png")));
        jlb_text54_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text54_titleChild2.setForeground(Color.BLACK);
        jlb_text54_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text54_titleChild2.setBounds(10, 4575, 480, 274);
        panel.add(jlb_text54_titleChild2);
        
        JLabel jlb_text55_titleChild2 = new JLabel("Trở về trang chủ");
        jlb_text55_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text55_titleChild2.setForeground(Color.BLACK);
        jlb_text55_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text55_titleChild2.setBounds(500, 4690, 370, 30);
        panel.add(jlb_text55_titleChild2);
        
        JLabel jlb_text56_titleChild2 = new JLabel("");
        jlb_text56_titleChild2.setIcon(new ImageIcon(Guide.class.getResource("/images/UIModePlay(4).png")));
        jlb_text56_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text56_titleChild2.setForeground(Color.BLACK);
        jlb_text56_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text56_titleChild2.setBounds(10, 4860, 480, 274);
        panel.add(jlb_text56_titleChild2);
        
        JLabel jlb_text57_titleChild2 = new JLabel("Bạn đã sẵn sàng thực chiến ?");
        jlb_text57_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text57_titleChild2.setForeground(Color.BLACK);
        jlb_text57_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text57_titleChild2.setBounds(500, 4975, 370, 30);
        panel.add(jlb_text57_titleChild2);
        
        JLabel jlb_text58_titleChild2 = new JLabel("Hãy nhấn vào 'người' và tăng xếp hạng");
        jlb_text58_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text58_titleChild2.setForeground(Color.BLACK);
        jlb_text58_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text58_titleChild2.setBounds(500, 5005, 370, 30);
        panel.add(jlb_text58_titleChild2);
        
        JLabel jlb_text59_titleChild2 = new JLabel("của bạn nào");
        jlb_text59_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text59_titleChild2.setForeground(Color.BLACK);
        jlb_text59_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text59_titleChild2.setBounds(500, 5035, 370, 30);
        panel.add(jlb_text59_titleChild2);
        
        JLabel jlb_textt60_titleChild2 = new JLabel("6. Giao diện phòng chờ :");
        jlb_textt60_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_textt60_titleChild2.setForeground(Color.BLACK);
        jlb_textt60_titleChild2.setFont(new Font("Cambria Math", Font.BOLD, 30));
        jlb_textt60_titleChild2.setBounds(10, 5145, 860, 30);
        panel.add(jlb_textt60_titleChild2);
        
        JLabel jlb_text61_titleChild2 = new JLabel("");
        jlb_text61_titleChild2.setIcon(new ImageIcon(Guide.class.getResource("/images/UIWaitRoom.png")));
        jlb_text61_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text61_titleChild2.setForeground(Color.BLACK);
        jlb_text61_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text61_titleChild2.setBounds(10, 5175, 480, 274);
        panel.add(jlb_text61_titleChild2);
        
        JLabel jlb_text62_titleChild2 = new JLabel("Lựa chọn đối thủ của bạn tại đây !!");
        jlb_text62_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text62_titleChild2.setForeground(Color.BLACK);
        jlb_text62_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text62_titleChild2.setBounds(500, 5290, 370, 30);
        panel.add(jlb_text62_titleChild2);
        
        JLabel jlb_textt63_titleChild2 = new JLabel("7. Giao diện hướng dẫn :");
        jlb_textt63_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_textt63_titleChild2.setForeground(Color.BLACK);
        jlb_textt63_titleChild2.setFont(new Font("Cambria Math", Font.BOLD, 30));
        jlb_textt63_titleChild2.setBounds(10, 5460, 860, 40);
        panel.add(jlb_textt63_titleChild2);
        
        JLabel jlb_text64_titleChild2 = new JLabel("");
        jlb_text64_titleChild2.setIcon(new ImageIcon(Guide.class.getResource("/images/UIGuide.png")));
        jlb_text64_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text64_titleChild2.setForeground(Color.BLACK);
        jlb_text64_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text64_titleChild2.setBounds(10, 5500, 480, 274);
        panel.add(jlb_text64_titleChild2);
        
        JLabel jlb_text65_titleChild2 = new JLabel("Bạn chưa hiểu rõ điều gì ??");
        jlb_text65_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text65_titleChild2.setForeground(Color.BLACK);
        jlb_text65_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text65_titleChild2.setBounds(500, 5615, 370, 30);
        panel.add(jlb_text65_titleChild2);
        
        JLabel jlb_text66_titleChild2 = new JLabel("Tại trang hướng dẫn, thắc mắc của bạn");
        jlb_text66_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text66_titleChild2.setForeground(Color.BLACK);
        jlb_text66_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text66_titleChild2.setBounds(500, 5645, 370, 30);
        panel.add(jlb_text66_titleChild2);
        
        JLabel jlb_text67_titleChild2 = new JLabel("có thể được giải đáp");
        jlb_text67_titleChild2.setHorizontalAlignment(SwingConstants.LEFT);
        jlb_text67_titleChild2.setForeground(Color.BLACK);
        jlb_text67_titleChild2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        jlb_text67_titleChild2.setBounds(500, 5675, 370, 30);
        panel.add(jlb_text67_titleChild2);
        
        JScrollPane scroll = new JScrollPane(panel);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Hiển thị thanh cuộn dọc
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); // Hiển thị thanh cuộn ngang
        scroll.setPreferredSize(new Dimension(900, 500));//thanh cuộn hoạt động
        contentPane.add(scroll);
	}
}
