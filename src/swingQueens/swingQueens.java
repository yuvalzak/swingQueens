package swingQueens;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Cursor;

import javax.swing.SwingConstants;
import java.awt.Dimension;

public class swingQueens extends JFrame {

	private JPanel contentPane;
	private Grid G = null;
	private JTextField txtNumOfMoves;
	private int arrSize = 8;
	private int sizeQueenImage = 60;
	private JButton cmdAnotherWindow;
	private static swingQueens frame = null;
	private JComboBox cmbPlace = null;
	private JPanel pnlCmds;
	private JComboBox cmbGrid;
	private Cursor waitCursor = new Cursor(Cursor.WAIT_CURSOR);
    private Cursor defaultCursor = new Cursor(Cursor.DEFAULT_CURSOR);
	 
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				    frame = new swingQueens();
					frame.setVisible(true);
					frame.setTitle("Finding Queen Positions on Board");
					// Queens Q = new Queens(0);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public swingQueens() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 868, 507);
		contentPane = new JPanel();
		// contentPane.setBackground(new Color(184, 134, 11));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		G = Grid.MakeGrid(contentPane, arrSize);
		
		pnlCmds = new JPanel();
		pnlCmds.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pnlCmds.setBackground(new Color(143, 188, 143));
		pnlCmds.setBounds(491, 6, 249, 211);
		contentPane.add(pnlCmds);
		
		
				JButton cmdFindQueens = new JButton("First Queen At");
				cmdFindQueens.setOpaque(true);
				cmdFindQueens.setBackground(new Color(255, 127, 80));
				cmdFindQueens.setPreferredSize(new Dimension(111, 55));
				cmdFindQueens.setMinimumSize(new Dimension(134, 134));
				cmdFindQueens.setMaximumSize(new Dimension(134, 134));
				pnlCmds.add(cmdFindQueens);
						cmbPlace = new JComboBox();
						cmbPlace.setPreferredSize(new Dimension(77, 55));
						pnlCmds.add(cmbPlace);
						for (int ii = 0; ii <  2*arrSize  ; ii++) {
							cmbPlace.addItem(ii);
						}
				
					 
						JButton cmdSizeGrid = new JButton("Grid size");
						cmdSizeGrid.setPreferredSize(new Dimension(111, 29));
						pnlCmds.add(cmdSizeGrid);
										
										cmbGrid = new JComboBox();
										cmbGrid.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												cmdSizeGrid.doClick();
											}
										});
										cmbGrid.setPreferredSize(new Dimension(77, 27));
										pnlCmds.add(cmbGrid);
										{
										  for (int i = 4; i <  2*arrSize  ; i++) {
											cmbGrid.addItem(i);
										} cmbGrid.setSelectedIndex(4);
										  }
								
										JLabel lblNewLabel = new JLabel("number of iterations");
										pnlCmds.add(lblNewLabel);
										
												txtNumOfMoves = new JTextField();
												txtNumOfMoves.setHorizontalAlignment(SwingConstants.CENTER);
												pnlCmds.add(txtNumOfMoves);
												txtNumOfMoves.setColumns(10);
												
														cmdAnotherWindow = new JButton("open Another");
														cmdAnotherWindow.setPreferredSize(new Dimension(134, 29));
														pnlCmds.add(cmdAnotherWindow);
								cmdAnotherWindow.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										Runtime r = Runtime.getRuntime();
										try {
											r.exec("java -jar  /Users/yuvalzak/Desktop/jars/Queens.jar");
										} catch (IOException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
									}
								});
						cmdSizeGrid.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								G.deleteGrid();
								arrSize = Integer.parseInt(cmbGrid.getSelectedItem().toString());
								G.setSize(arrSize);
								G.doGrid();
								//cmbPlace.setSelectedIndex(0);
								frame.setTitle("Finding Queen Positions on Board " + arrSize + " X " + arrSize);
								pnlCmds.setLocation(11+ sizeQueenImage * arrSize, 0);
								frame.setSize((arrSize+ 5) * sizeQueenImage,  arrSize * sizeQueenImage + 30);
							}
						});
					 
				cmdFindQueens.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						 frame.setCursor(waitCursor);
						G.deleteGrid();
						G.doGrid();
						Queens Q = new Queens(Integer.parseInt(cmbPlace.getSelectedItem().toString()), arrSize, txtNumOfMoves);
						 frame.setCursor(defaultCursor);
					}
				});
		G.doGrid();

		final JFrame frame = new JFrame("Queens");
		frame.getContentPane().setBackground(Color.WHITE);

	}

	 
}
