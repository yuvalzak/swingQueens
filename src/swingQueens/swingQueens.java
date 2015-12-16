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

public class swingQueens extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumLabel;
	private Grid G = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					swingQueens frame = new swingQueens();
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
	public swingQueens() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 877, 507);
		contentPane = new JPanel();
		//contentPane.setBackground(new Color(184, 134, 11));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon img = (new ImageIcon("/Users/yuvalzak/Documents/workspace/swingQueens/images/smallQueen.png"));
		JLabel q1 = new JLabel("");
		q1.setBackground(Color.ORANGE);
		q1.setIcon(img);
		q1.setBounds(699, 43, 55, 55);
		contentPane.add(q1);
		
		JLabel q2 = new JLabel("");
		q2.setBackground(Color.ORANGE);
		q2.setBounds(699, 187, 55, 55);
	//	q2.setIcon(img);
		q2.setOpaque(true);
		contentPane.add(q2);
		
		JLabel q3 = new JLabel("");
		q3.setBounds(699, 110, 55, 55);
		q3.setIcon(img);
		contentPane.add(q3);
		G  = Grid.MakeGrid(contentPane,8);
		 
		txtNumLabel = new JTextField();
		txtNumLabel.setBounds(758, 3, 92, 28);
		contentPane.add(txtNumLabel);
		txtNumLabel.setColumns(10);
		
		JButton cmdChange = new JButton("New button");
		cmdChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				G.MakeQueen(Integer.parseInt(txtNumLabel.getText()), 3, true);
		}});
		
		cmdChange.setBounds(747, 43, 117, 29);
		contentPane.add(cmdChange);
		
		JButton button = new JButton("New button");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				G.MakeQueen(Integer.parseInt(txtNumLabel.getText()), 3, false);
			}
		});
		button.setBounds(757, 82, 117, 29);
		contentPane.add(button);
		G.doGrid();
		
		final JFrame frame = new JFrame("Queens");
		frame.getContentPane().setBackground(Color.WHITE);
	//	frame.getContentPane().setLayout(new GridLayout(0, 1));
      //   frame.validate();
       //  frame.repaint();
         
	}
	}
 
 