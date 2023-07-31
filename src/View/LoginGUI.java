package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;


import Helper.Helper;
import Model.User;
import Repository.UserRepository;
import Repository.UserRepositoryImp;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginGUI extends JFrame {

	private JPanel w_pane;
	private JTextField fld_name;
	private UserRepository userRepository;
	private JPasswordField fld_pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginGUI() {
		
		
		this.userRepository = new UserRepositoryImp();
		setTitle("Planlayıcı");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		w_pane = new JPanel();
		w_pane.setBackground(Color.WHITE);
		w_pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(w_pane);
		w_pane.setLayout(null);

		JLabel lblNewLabel = new JLabel(new ImageIcon(getClass().getResource("plan.png")));
		lblNewLabel.setBounds(171, 10, 230, 207);
		w_pane.add(lblNewLabel);


		JLabel lblNewLabel_1 = new JLabel("Planlayıcıya Hoş Geldiniz");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(189, 222, 195, 33);
		w_pane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ad:");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 17));
		lblNewLabel_2.setBounds(36, 265, 59, 33);
		w_pane.add(lblNewLabel_2);
		
		fld_name = new JTextField();
		fld_name.setBounds(149, 268, 252, 33);
		w_pane.add(fld_name);
		fld_name.setColumns(10);
		
		JButton btn_login = new JButton("Giriş Yap");
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(fld_name.getText().length() == 0 || fld_pass.getText().length() == 0) {
					Helper.showMsg("fill");
				}else {
					String name = fld_name.getText();
					String password = fld_pass.getText();
					
					if(userRepository.getCheckPassword(name, password)) {
						User u;
						try {
							u = userRepository.getUserName(name);
							SelectDateGUI sGUI = new SelectDateGUI(u);
							sGUI.setVisible(true);
							dispose();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else {
						Helper.showMsg("error");
					}
					
				
				}
				
			}
		});
		btn_login.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 22));
		btn_login.setBounds(149, 388, 252, 47);
		w_pane.add(btn_login);
		
		JLabel lblNewLabel_2_1 = new JLabel("Şifre");
		lblNewLabel_2_1.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 17));
		lblNewLabel_2_1.setBounds(36, 312, 59, 33);
		w_pane.add(lblNewLabel_2_1);
		
		fld_pass = new JPasswordField();
		fld_pass.setBounds(149, 311, 252, 34);
		w_pane.add(fld_pass);
		
	
	}
}
