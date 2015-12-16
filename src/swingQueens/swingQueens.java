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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					swingQueens frame = new swingQueens();
					frame.setVisible(true);
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
		setBounds(100, 100, 877, 507);
		contentPane = new JPanel();
		//contentPane.setBackground(new Color(184, 134, 11));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon img = (new ImageIcon("/Users/yuvalzak/Documents/workspace/swingQueens/images/smallQueen.png"));
		G  = Grid.MakeGrid(contentPane,8);
		
		JButton cmdChange = new JButton("First Queen At");
		cmdChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//G.deleteGrid();
				
				Queens Q = new Queens(Integer.parseInt(cmbPlace.getSelectedItem().toString()));
			//	G.doGrid();
		}});
		
		cmdChange.setBounds(520, 49, 117, 29);
		contentPane.add(cmdChange);
		
		cmbPlace = new JComboBox();
		cmbPlace.setBounds(520, 20, 62, 27);
		for(int ii=0; ii<8; ii++){
			cmbPlace.addItem(ii);
		}
		contentPane.add(cmbPlace);
		G.doGrid();
		
		final JFrame frame = new JFrame("Queens");
		frame.getContentPane().setBackground(Color.WHITE);
	//	frame.getContentPane().setLayout(new GridLayout(0, 1));
      //   frame.validate();
       //  frame.repaint();
         
	}
	}
 
 