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
		
		
		
		JButton btnTest = new JButton("Test");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel ModelTest = (DefaultTableModel) Ttable.getModel();
//				Ttable.setModel(new DefaultTableModel());
				ModelTest.addRow(new Object[]{"1","Die Blutlinie",  "Cody McFadyen", "Lübek", "2008", "Mosbach", "n"});
				ModelTest.addRow(new Object[]{"2","Der Menschenmacher",  "Cody McFadyen", "Lübek", "2010", "Mosbach", "n"});
				ModelTest.addRow(new Object[]{"3","Ausgelöscht",  "Cody McFadyen", "Lübek", "2012", "Mosbach", "j"});
				ModelTest.addRow(new Object[]{"4","Das Böse in Uns",  "Cody McFadyen", "Lübek", "2013", "Mosbach", "n"});
				ModelTest.addRow(new Object[]{"5","xxx",  "Marius Reinwald", "Mosbach", "2014", "Mosbach", "n"});
				
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnTest)
					.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
					.addComponent(Ttable, GroupLayout.PREFERRED_SIZE, 415, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(21, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(Ttable, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnTest))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

}
