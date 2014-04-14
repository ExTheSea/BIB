import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class BIBGUI extends JFrame {

	private JPanel contentPane;
	private JTable Ttable;
	private JButton btnNotAvailable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BIBGUI frame = new BIBGUI();
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
	public BIBGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 390);
		setResizable(false);								//Größe festgelegt
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Ttable = new JTable(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID","Titel", "Autor", "Verlag", "Jahr", "Standort", "ausgeliehen"
			}
		));
		
		
		BIBDB.createsample();
		
		JButton btnListAll = new JButton("listAll");
		btnListAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel ModelTest = (DefaultTableModel) Ttable.getModel();
				ModelTest.setRowCount(0);
//				Ttable.setModel(new DefaultTableModel());
//				ModelTest.addRow(new Object[]{"1","Die Blutlinie",  "Cody McFadyen", "Lübek", "2008", "Mosbach", "n"});
//				ModelTest.addRow(new Object[]{"2","Der Menschenmacher",  "Cody McFadyen", "Lübek", "2010", "Mosbach", "n"});
//				ModelTest.addRow(new Object[]{"3","Ausgelöscht",  "Cody McFadyen", "Lübek", "2012", "Mosbach", "j"});
//				ModelTest.addRow(new Object[]{"4","Das Böse in Uns",  "Cody McFadyen", "Lübek", "2013", "Mosbach", "n"});
//				ModelTest.addRow(new Object[]{"5","Java for Hillbillies",  "Marius Reinwald", "Mosbach", "2014", "Mosbach", "n"});
				Object[] arr = BIBDB.getAll();
				for (int i = 0; i < arr.length; i++) {
					Object[] iarr = (Object[])arr[i];
					ModelTest.addRow(iarr);
				}
				
			}
		});
		
		JButton btnAvailable = new JButton("listAvailable");
		btnAvailable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel ModelTest = (DefaultTableModel) Ttable.getModel();
				ModelTest.setRowCount(0);
				Object[] arr = BIBDB.getNotLend();
				for (int i = 0; i < arr.length; i++) {
					Object[] iarr = (Object[])arr[i];
					ModelTest.addRow(iarr);
				}
			}
		});
		
		btnNotAvailable = new JButton("listNotAvailable");
		btnNotAvailable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				DefaultTableModel ModelTest = (DefaultTableModel) Ttable.getModel();
				Ttable.setModel(new DefaultTableModel(BIBDB.getLend(), 
			new String[] {
				"ID","Titel", "Autor", "Verlag", "Jahr", "Standort", "ausgeliehen"
			}));
//				ModelTest.setRowCount(0);
////				ModelTest.
//				Object[] arr = BIBDB.getLend();
//				for (int i = 0; i < arr.length; i++) {
//					Object[] iarr = (Object[])arr[i];
//					ModelTest.addRow(iarr);
//				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(Ttable, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnListAll, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAvailable, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNotAvailable, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(21, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnListAll)
						.addComponent(btnAvailable)
						.addComponent(btnNotAvailable))
					.addGap(18)
					.addComponent(Ttable, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
