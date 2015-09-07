package edu.jsu.mcis;

public class TicTacToe {

	public TicTacToe(){
		for (int row = 0; row < 3; row++){
			for (int col = 0; col < 3; col++){
				board[row][col] = ' ';}}}

	public char getMark(int row, int col){
		return board[row][col];}

	public static void main(String[] args) {
		
	}
}
