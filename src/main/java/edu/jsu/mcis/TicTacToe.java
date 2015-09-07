package edu.jsu.mcis;

import java.io.*;


public class TicTacToe {

	private char[][] board = new char[3][3];

	public TicTacToe(){
		for (int row = 0; row < 3; row++){
			for (int col = 0; col < 3; col++){
				board[row][col] = ' ';}}}



	public char getMark(int row, int col){
		return board[row][col];}

	public char setMark(int row, int col, char mark){
		char currentMark = ' ';
		currentMark = getMark(row,col);
		if(currentMark == ' '){
			return board[row][col] = mark;}
		else {
			return board[row][col] = currentMark;}
		}

	public boolean isGameOver(){
		int turn = 0;
		for (int row = 0; row < 3; row++){
			for (int col = 0; col < 3; col++){
				if(board[row][col] == ' '){
					turn = turn;
				}
				else{
				turn++;	
				}
			}
		}
		if (thisPlayerWon() == 'X' || thisPlayerWon() == 'O'){
			return true;}
		else{
			if (turn == 9){
				return true;}
			else if (turn <= 8){
				return false;}
			else{
				
			return true;}
		}
	}
	
	public char thisPlayerWon(){
		if (board[0][0] == board[0][1] && board[0][0] == board[0][2] 
			&& board[0][0] != ' '){
			return board[0][0];}
		
		else if (board[1][0] == board[1][1] && board[1][0] == board[1][2] 
			&& board[1][0] != ' '){
			return board[1][0];}
		
		else if (board[2][0] == board[2][1] && board[2][0] == board[2][2] 
			&& board[2][0] != ' '){
			return board[2][0];}
		
		else if (board[0][0] == board[1][0] && board[0][0] == board[2][0] 
			&& board[0][0] != ' '){
			return board[0][0];}
		
		else if (board[0][1] == board[1][1] && board[0][1] == board[2][1] 
			&& board[0][1] != ' '){
			return board[0][1];}
		
		else if (board[0][2] == board[1][2] && board[0][2] == board[2][2] 
			&& board[0][2] != ' '){
			return board[0][2];}
		
		else if (board[0][0] == board[1][1] && board[0][0] == board[2][2] 
			&& board[0][0] != ' '){
			return board[0][0];}	
		
		else if (board[0][2] == board[1][1] && board[0][2] == board[2][0] 
			&& board[0][2] != ' '){
			return board[0][2];}
		
		else{return ' ';}
	}
	
	
	public String howGameEnds(){
		if(isGameOver() == false){
			return "game not over";}
		
		else if(thisPlayerWon() == 'X'){
			return "X wins";}
	
		else if(thisPlayerWon() == 'O'){
			return "O wins";}
	
		else if(isGameOver() == true){
			return "tie";}
		
		else{
			return "error";}
	}
	


	public static void main(String[] args) {
		
	}
}
