package swingQueens;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Grid  implements ActionListener{
	private JPanel frame = null;
	private int size;
	private static Grid G = null;
	List<JLabel> lstQueens = new ArrayList<>();
	
	private Grid(JPanel contentPane, int size) {
		this.frame = contentPane;
		this.size = size;
		
		/*Timer timer;

		  ActionListener updateProBar;

		  public TimerBasedAnimation() {
		    

		    timer = new Timer(20 );
		    timer.setInitialDelay(190);
		    timer.start();
		  }

     }*/
		
		
		
		
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
	
	
	public void MakeQueen (int x, int y, Boolean b){
		int place = size * x + y;
		JLabel tmp = new JLabel();
		tmp = lstQueens.get(place);
		if (b) {
		tmp.setIcon(new ImageIcon("/Users/yuvalzak/Documents/workspace/swingQueens/images/smallQueen.png"));
	
		} else {
		tmp.setIcon(null);	
		}
		//frame.revalidate(); 
		tmp.repaint();
		 frame.repaint();
	 

	}

	
	public void deleteGrid(){
		
		for (int i = 0; i < size* size; i++) {
			 
		frame.remove(lstQueens.get(i));
		}
		frame.revalidate(); 
		frame.repaint();
			 
	}
	
	public void doGrid() {
		//List<JLabel> lstQueens = new ArrayList<>();
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
				/*if (i == 5) {
					tmp.setIcon(new ImageIcon("/Users/yuvalzak/Documents/workspace/swingQueens/images/smallQueen.png"));

				}*/
				tmp.setOpaque(true);
				frame.add(tmp);
			}
		}
	}
}
