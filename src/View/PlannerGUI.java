package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.User;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.Checkbox;

public class PlannerGUI extends JFrame {

	private JPanel w_pane;
	private static User user = new User();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlannerGUI frame = new PlannerGUI(user);
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
	public PlannerGUI(User user) {
		setTitle("Planlayıcı");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		w_pane = new JPanel();
		w_pane.setBackground(Color.PINK);
		w_pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(w_pane);
		w_pane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Hoşgeldiniz Sayın, Atike Şule AŞIK");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 24));
		lblNewLabel.setEnabled(false);
		lblNewLabel.setBounds(10, 10, 415, 47);
		w_pane.add(lblNewLabel);

		JTabbedPane w_tab = new JTabbedPane(JTabbedPane.TOP);
		w_tab.setBounds(10, 52, 766, 401);
		w_pane.add(w_tab);

		JPanel food = new JPanel();
		food.setBackground(Color.WHITE);
		w_tab.addTab("Yemek", null, food, null);
		food.setLayout(null);

		JPanel lesson = new JPanel();
		lesson.setBackground(Color.WHITE);
		w_tab.addTab("Ders", null, lesson, null);
		
				JPanel school = new JPanel();
				school.setBackground(Color.WHITE);
				w_tab.addTab("Okul", null, school, null);
				school.setLayout(null);
				
						Checkbox check_ameliyat = new Checkbox("Ameliyat");
						check_ameliyat.setFont(new Font("Bodoni MT Black", Font.BOLD, 15));
						check_ameliyat.setBackground(Color.WHITE);
						check_ameliyat.setBounds(10, 10, 160, 25);
						school.add(check_ameliyat);
						
								Checkbox check_service = new Checkbox("Servis");
								check_service.setFont(new Font("Bodoni MT Black", Font.BOLD, 15));
								check_service.setBackground(Color.WHITE);
								check_service.setBounds(10, 60, 160, 25);
								school.add(check_service);
								
										Checkbox check_clinic = new Checkbox("Poliklinik");
										check_clinic.setFont(new Font("Bodoni MT Black", Font.BOLD, 15));
										check_clinic.setBackground(Color.WHITE);
										check_clinic.setBounds(10, 110, 160, 25);
										school.add(check_clinic);
										
												Checkbox check_freeDay = new Checkbox("Boş Günüm");
												check_freeDay.setFont(new Font("Bodoni MT Black", Font.BOLD, 15));
												check_freeDay.setBackground(Color.WHITE);
												check_freeDay.setBounds(10, 160, 160, 25);
												school.add(check_freeDay);
												
														Checkbox check_nobet = new Checkbox("Nöbetçi");
														check_nobet.setFont(new Font("Bodoni MT Black", Font.BOLD, 15));
														check_nobet.setBackground(Color.WHITE);
														check_nobet.setBounds(10, 210, 160, 25);
														school.add(check_nobet);
														
														JButton btn_saveCheckBox = new JButton("Seçili Faaliyeti Kaydet");
														btn_saveCheckBox.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
														btn_saveCheckBox.setBounds(402, 89, 213, 46);
														school.add(btn_saveCheckBox);
														
														JButton btn_getCheckBox = new JButton("Seçili Faaliyeti Göster");
														btn_getCheckBox.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
														btn_getCheckBox.setBounds(402, 189, 213, 46);
														school.add(btn_getCheckBox);

		JButton btnNewButton = new JButton("Geri Dön");
		btnNewButton.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 21));
		btnNewButton.setBounds(626, 10, 150, 47);
		w_pane.add(btnNewButton);
	}
}
