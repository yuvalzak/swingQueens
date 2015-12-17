package swingQueens;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Grid   {
	private JPanel frame = null;
	private int size;
	
	public void setSize(int size) {
		this.size = size;
	}



	private static Grid G = null;
	List<JLabel> lstQueens = new ArrayList<>();
	Timer timer = null;
	
	
	private Grid(JPanel contentPane, int size) {
		this.frame = contentPane;
		this.size = size;
		
	}	
	
	  public void StartTimer(Boolean b){
		 if(b){ timer.start();}
		 else{ timer.stop();}
	 } 
	// static for singlton 
	//////////////////////
	public static Grid MakeGrid(JPanel contentPane, int size){
		if (G == null) {
			G = new Grid( contentPane,   size);
		}
		return G;
	}
	
	public static Grid GetGrid(){
		return G;
	}
	
	public void MakeQueenWithTimer(int x, int y, Boolean b){
		   timer = new Timer(1, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MakeQueen(x,y,b);
				
			}
		}); 
		   MakeQueen(x,y,b);
		// timer.start();
	}
	
	public void MakeQueen (int x, int y, Boolean b){
		int place = size * x + y;
		JLabel   tmp = new JLabel();
		tmp = lstQueens.get(place);
		if (b) {
		tmp.setIcon(new ImageIcon("img/smallQueen.png"));
	
		} else {
		tmp.setIcon(null);	
		}
	// frame.revalidate(); 
		tmp.repaint();
		 frame.repaint();
	//	 timer.stop();
	}

	
	public void deleteGrid(){
		
		for (int i = 0; i < size* size; i++) {
			 
		frame.remove(lstQueens.get(i));
		}
		frame.revalidate(); 
		frame.repaint();
			 
	}
	

	
	public void doGrid() {
		JLabel tmp = null;
		int s = 60;
		int k = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
			//	lstQueens.add(new JLabel("[" + i + "][" + j + "]"+ k++));
				lstQueens.add(new JLabel(""));
				tmp = lstQueens.get(lstQueens.size() - 1);

				tmp.setBounds(i * s, j * s, 55, 55);
				tmp.setBackground(Color.ORANGE);
				tmp.setOpaque(true);
				frame.add(tmp);
			}
		}
		frame.revalidate(); 
		frame.repaint();
	}




}
