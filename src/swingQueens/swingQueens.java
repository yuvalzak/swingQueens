package swingQueens;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.portable.InputStream;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class swingQueens extends JFrame {

	private JPanel contentPane;
	private Grid G = null;
	private JComboBox cmbPlace;
	private JTextField txtNumOfMoves;
	private   int    arrSize = 8;
	private JButton cmdAnotherWindow;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					swingQueens frame = new swingQueens();
					frame.setVisible(true);
					frame.setTitle("Finding Queen Positions on Board");
				//	Queens Q = new Queens(0);
					
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
		setBounds(100, 100, 654, 507);
		contentPane = new JPanel();
		//contentPane.setBackground(new Color(184, 134, 11));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 
		G  = Grid.MakeGrid(contentPane,arrSize);
		
		JButton cmdSizeGrid = new JButton("Grid size");
		cmdSizeGrid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				   G.deleteGrid();
				 
			  arrSize = Integer.parseInt(cmbPlace.getSelectedItem().toString());
			  G.setSize(arrSize);
			  G.doGrid(); 
		}});
		
		cmdSizeGrid.setBounds(520, 90, 117, 29);
		contentPane.add(cmdSizeGrid);
		
		cmbPlace = new JComboBox();
		cmbPlace.setBounds(520, 20, 62, 27);
		for(int ii=0; ii<arrSize+1; ii++){
			cmbPlace.addItem(ii);
		}
		contentPane.add(cmbPlace);
		
		txtNumOfMoves = new JTextField();
		txtNumOfMoves.setBounds(530, 167, 84, 28);
		contentPane.add(txtNumOfMoves);
		txtNumOfMoves.setColumns(10);
		
		JButton button = new JButton("First Queen At");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Queens Q = new Queens(Integer.parseInt(cmbPlace.getSelectedItem().toString()),arrSize, txtNumOfMoves);
			}
		});
		button.setBounds(520, 49, 117, 29);
		contentPane.add(button);
		
		cmdAnotherWindow = new JButton("open Another");
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
		cmdAnotherWindow.setBounds(520, 126, 117, 29);
		contentPane.add(cmdAnotherWindow);
		G.doGrid();
		
		final JFrame frame = new JFrame("Queens");
		frame.getContentPane().setBackground(Color.WHITE);
	//	frame.getContentPane().setLayout(new GridLayout(0, 1));
      //   frame.validate();
       //  frame.repaint();
         
	}
	
	public void SetNumberOfTimes(String x){
		txtNumOfMoves.setText(x);
	}
	}
 
 