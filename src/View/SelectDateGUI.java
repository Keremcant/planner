package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Model.Date;
import Model.Day;
import Model.User;
import Repository.DateRepository;
import Repository.DateRepositoryImp;
import Repository.DayRepository;
import Repository.DayRepositoryImp;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;

import Helper.Helper;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class SelectDateGUI extends JFrame {

	private JPanel w_pane;
	private static User user = new User();
	Date date = new Date();
	private DateRepository dateRepository;
	private DayRepository dayRepository;
	private JTable table_date;
	private DefaultTableModel dateModel = null;
	private Object[] dateData = null;
	private JTextField fld_selectDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectDateGUI frame = new SelectDateGUI(user);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public SelectDateGUI(User user) throws SQLException {

		dateRepository = new DateRepositoryImp();
		this.dayRepository = new DayRepositoryImp();
		// dateModel
		dateModel = new DefaultTableModel();
		Object[] colDate = new Object[2];
		colDate[0] = "ID";
		colDate[1] = "Tarih";
		dateModel.setColumnIdentifiers(colDate);
		dateData = new Object[2];
		for (int i = 0; i < dateRepository.getList().size(); i++) {
			dateData[0] = dateRepository.getList().get(i).getId();
			dateData[1] = dateRepository.getList().get(i).getDate();
			dateModel.addRow(dateData);
		}

		setTitle("Planner Tarih Seçme");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		w_pane = new JPanel();
		w_pane.setBackground(Color.WHITE);
		w_pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(w_pane);
		w_pane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Hoş geldiniz, Sayın Intern Dr " + user.getName());
		lblNewLabel.setBounds(10, 10, 460, 51);
		lblNewLabel.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 25));
		w_pane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Çıkış Yap");
		btnNewButton.setBounds(615, 10, 161, 51);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI login = new LoginGUI();
				login.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 22));
		w_pane.add(btnNewButton);

		JTabbedPane w_tab = new JTabbedPane(JTabbedPane.TOP);
		w_tab.setBounds(10, 72, 766, 381);
		w_pane.add(w_tab);

		JPanel w_date = new JPanel();
		w_date.setBackground(Color.WHITE);
		w_tab.addTab("Tarih Seç", null, w_date, null);
		w_date.setLayout(null);

		JDateChooser select_date = new JDateChooser();
		select_date.setBounds(10, 10, 181, 27);
		w_date.add(select_date);

		JButton btn_addDate = new JButton("Ekle");
		btn_addDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String date = "";
				try {
					date = sdf.format(select_date.getDate());
				} catch (Exception e2) {

				}
				if (date.length() == 0) {
					Helper.showMsg("Lütfen geçerli bir tarih giriniz !");
				} else {
					String selectDate = date;

					try {
						boolean control = dateRepository.addDate(selectDate);
						if (control) {
							Helper.showMsg("success");
							updateDateModel();
						} else {
							Helper.showMsg("error");
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});
		btn_addDate.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		btn_addDate.setBounds(218, 10, 114, 27);
		w_date.add(btn_addDate);

		fld_selectDate = new JTextField();
		fld_selectDate.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 20));
		fld_selectDate.setBackground(Color.WHITE);
		fld_selectDate.setEnabled(false);
		fld_selectDate.setEditable(false);
		fld_selectDate.setBounds(481, 46, 270, 40);
		w_date.add(fld_selectDate);
		fld_selectDate.setColumns(10);

		JButton btn_deleteDate = new JButton("Seçili Tarihi Sil");
		btn_deleteDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fld_selectDate.getText().length() == 0) {
					Helper.showMsg("Lütfen bir tarih seçiniz !");
				} else {
					if (Helper.confirm("sure")) {
						int selectID = Integer.parseInt(fld_selectDate.getText());
						try {
							boolean control = dateRepository.deleteDate(selectID);
							if (control) {
								Helper.showMsg("success");
								fld_selectDate.setText(null);
								updateDateModel();
							}
						} catch (SQLException e2) {
							e2.printStackTrace();
						}

					}

				}

			}
		});

		btn_deleteDate.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		btn_deleteDate.setBounds(481, 176, 270, 51);
		w_date.add(btn_deleteDate);

		JScrollPane w_scrollDate = new JScrollPane();
		w_scrollDate.setBounds(10, 47, 461, 297);
		w_date.add(w_scrollDate);

		table_date = new JTable(dateModel);
		w_scrollDate.setViewportView(table_date);
		table_date.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				try {
					fld_selectDate.setText(table_date.getValueAt(table_date.getSelectedRow(), 0).toString());
				} catch (Exception e2) {
					// TODO: handle exception
				}

			}
		});

		JButton btn_selectDate = new JButton("Seçili Tarihe Git");
		btn_selectDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fld_selectDate.getText().length() == 0) {
					Helper.showMsg("Lütfen bir tarih seçiniz !");
				} else {
					int date_id = Integer.parseInt(fld_selectDate.getText());

					if (dayRepository.dayCheck(date_id)) {
						PlannerGUI pGUI = new PlannerGUI(user);
						pGUI.setVisible(true);
						dispose();

					} else {
						try {
							boolean control = dayRepository.addDay(date_id);
							if (control) {
								PlannerGUI pGUI = new PlannerGUI(user);
								pGUI.setVisible(true);
								dispose();
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}

				}

			}
		});
		btn_selectDate.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		btn_selectDate.setBounds(481, 108, 270, 51);
		w_date.add(btn_selectDate);

	}

	public void updateDateModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_date.getModel();
		clearModel.setRowCount(0);
		for (int i = 0; i < dateRepository.getList().size(); i++) {
			dateData[0] = dateRepository.getList().get(i).getId();
			dateData[1] = dateRepository.getList().get(i).getDate();
			dateModel.addRow(dateData);

		}
	}
}
