package has;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import javax.swing.SwingConstants;

import java.awt.SystemColor;
import java.awt.Window;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class calendar extends JFrame {

	private JPanel contentPane;
	JComboBox comboBox_1;
	public static JButton btnSave;
	static Integer month=0,year=2015,date=1,hour=1,minutes=00,am=0;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calendar frame = new calendar();
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
	public calendar() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 393, 183);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getSelectedIndex()==0 || comboBox.getSelectedIndex()==2 || comboBox.getSelectedIndex()==4||comboBox.getSelectedIndex()==6)
				{
				d31();
				}
				if(comboBox.getSelectedIndex()==7||comboBox.getSelectedIndex()==9||comboBox.getSelectedIndex()==11)
				{
					d31();
				}
				if(comboBox.getSelectedIndex()==3||comboBox.getSelectedIndex()==5||comboBox.getSelectedIndex()==8||comboBox.getSelectedIndex()==10)
				{
				d30();
				}
				if(comboBox.getSelectedIndex()==1)
				{
					feb();
				}			
				month=comboBox.getSelectedIndex();
				
			}
		});
		//comboBox.setBackground(Color.WHITE);
		comboBox.setForeground(new Color(153, 0, 204));
		comboBox.setFont(new Font("Monotype Corsiva", Font.PLAIN, 25));
		comboBox.setMaximumRowCount(6);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBox.setBounds(10, 55, 123, 31);
		contentPane.add(comboBox);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setForeground(Color.WHITE);
		lblMonth.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblMonth.setBounds(10, 31, 111, 18);
		contentPane.add(lblMonth);
		
		 comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			date=comboBox_1.getSelectedIndex()+1;
			
			}
		});
		comboBox_1.setForeground(new Color(153, 153, 51));
		comboBox_1.setFont(new Font("Monotype Corsiva", Font.PLAIN, 19));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_1.setMaximumRowCount(6);
		comboBox_1.setBounds(162, 55, 62, 28);
		contentPane.add(comboBox_1);
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setForeground(new Color(204, 0, 0));
		lblDay.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDay.setBounds(174, 31, 62, 20);
		contentPane.add(lblDay);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setForeground(Color.WHITE);
		lblYear.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblYear.setBounds(249, 31, 56, 20);
		contentPane.add(lblYear);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			year=comboBox_2.getSelectedIndex()+2015;
			}
		});
		comboBox_2.setForeground(new Color(204, 102, 0));
		comboBox_2.setFont(new Font("Monotype Corsiva", Font.PLAIN, 24));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"2015", "2016"}));
		comboBox_2.setBounds(239, 55, 83, 28);
		contentPane.add(comboBox_2);
		
		 btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			datecalendar.c.set(year, month, date, hour, minutes);			
			mymethod();
			}
		});
		btnSave.setFont(new Font("Vijaya", Font.PLAIN, 26));
		btnSave.setForeground(new Color(0, 102, 51));
		btnSave.setBounds(129, 97, 95, 28);
		contentPane.add(btnSave);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("F:\\SEMESTER-4\\Software\\Java\\Travel\\abstract-calendar-time-background-28797455 - Copy.jpg"));
		lblNewLabel.setBounds(-51, -213, 664, 425);
		contentPane.add(lblNewLabel);
	}
	void d31()
	{
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
	}
	void d30()
	{
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
	}
	void feb()
	{
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28"}));
	}
	void mymethod(){
		this.dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
		
	}
        public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		 Font font = new Font("Monotype Corsiva", Font.PLAIN, 22);
		// UIManager.put("OptionPane.background",Color.white);
        UIManager.put("OptionPane.messageFont", font);
       for(Window window : JFrame.getWindows()) {
       SwingUtilities.updateComponentTreeUI(window);}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calendar frame = new calendar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
