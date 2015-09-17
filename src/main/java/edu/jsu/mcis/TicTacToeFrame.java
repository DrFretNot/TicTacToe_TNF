package edu.jsu.mcis;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.JOptionPane; 


public class TicTacToeFrame implements ActionListener {



private TicTacToe t;
private JFrame frame;
private JPanel panel;
private JButton[][] buttonArray;

public TicTacToeFrame(){
	t = new TicTacToe();
	frame = new JFrame();
	panel = new JPanel();
	panel.setLayout(new GridLayout(3,3));
	buttonArray = new JButton[3][3];
	for (int row = 0; row < 3; row++){
				for (int col = 0; col < 3; col++){
					buttonArray[row][col]= new JButton();
					buttonArray[row][col].setName("location"+row+col);
					buttonArray[row][col].addActionListener(this);
					panel.add(buttonArray[row][col]);
				}
	}
	panel.setPreferredSize(new Dimension(400, 400));
	frame.add(panel);
	frame.pack();
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}
public void actionPerformed(ActionEvent event) {
		
		JButton src = (JButton) event.getSource();
		for (int row = 0; row < 3; row++){
				for (int col = 0; col < 3; col++){
					if (buttonArray[row][col] == src && !(t.isGameOver())){
						
						char turnmark = t.properTurnMark();
						t.setMark2(row,col);
						
						if ('X' == turnmark){
							buttonArray[row][col].setText("X");
						}
						else{
							buttonArray[row][col].setText("O");
						}
						
						
					}
				
					
				}
		}
		
		String winner = t.howGameEnds();
		if(winner == "X wins"){
			JOptionPane.showMessageDialog(frame,"The winner is X","Game Over",JOptionPane.PLAIN_MESSAGE);
			}
		else if(winner == "O wins"){
			
			JOptionPane.showMessageDialog(frame,"The winner is O","Game Over",JOptionPane.PLAIN_MESSAGE);
			}
	
		else if(winner == "tie"){
			JOptionPane.showMessageDialog(frame,"The winner is TIE","Game Over",JOptionPane.PLAIN_MESSAGE);
			}
		
	}
     
     


}