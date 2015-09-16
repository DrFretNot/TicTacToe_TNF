package edu.jsu.mcis;

import java.io.*;
import java.util.Scanner;

public class TicTacToe {

	private char[][] board = new char[3][3];
	private int turn;
	
	public TicTacToe(){
		for (int row = 0; row < 3; row++){
			for (int col = 0; col < 3; col++){
				board[row][col] = ' ';}}
		turn = 0;}
		
	public char getMark(int row, int col){
		return board[row][col];}

	public char setMark(int row, int col, char mark){
		char currentMark = ' ';
		currentMark = getMark(row,col);
		if(currentMark == ' '){
			turn++;
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
		if (board[0][0] == board[0][1] && board[0][0] == board[0][2] && board[0][0] != ' '){
			return board[0][0];}
		
		else if (board[1][0] == board[1][1] && board[1][0] == board[1][2] && board[1][0] != ' '){
			return board[1][0];}
		
		else if (board[2][0] == board[2][1] && board[2][0] == board[2][2] && board[2][0] != ' '){
			return board[2][0];}
		
		else if (board[0][0] == board[1][0] && board[0][0] == board[2][0] && board[0][0] != ' '){
			return board[0][0];}
		
		else if (board[0][1] == board[1][1] && board[0][1] == board[2][1] && board[0][1] != ' '){
			return board[0][1];}
		
		else if (board[0][2] == board[1][2] && board[0][2] == board[2][2] && board[0][2] != ' '){
			return board[0][2];}
		
		else if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != ' '){
			return board[0][0];}	
		
		else if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] != ' '){
			return board[0][2];}
		
		else{return ' ';}
	}
	
	public String gameBoardPrintout(){

		String topLeft = String.valueOf(board[0][0]);
		String topMiddle = String.valueOf(board[0][1]);
		String topRight = String.valueOf(board[0][2]);
		String centerLeft = String.valueOf(board[1][0]);
		String centerMiddle = String.valueOf(board[1][1]);
		String centerRight = String.valueOf(board[1][2]);
		String bottomLeft = String.valueOf(board[2][0]);
		String bottomMiddle = String.valueOf(board[2][1]);;
		String bottomRight = String.valueOf(board[2][2]);
	
		String gameBoardLine1 = "\n   (1)(2)(3)\n";
		String gameBoardLine2 = "(1)["+topLeft+"]["+topMiddle+"]["+topRight+"]\n";
		String gameBoardLine3 = "(2)["+centerLeft+"]["+centerMiddle+"]["+centerRight+"]\n";
		String gameBoardLine4 = "(3)["+bottomLeft+"]["+bottomMiddle+"]["+bottomRight+"]\n";
	
		String gameBoardPrintout = gameBoardLine1 + gameBoardLine2 + gameBoardLine3 + gameBoardLine4;
	
		return gameBoardPrintout;
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
	
	public int turnCount(){
		return turn;}


		
	public void printMessage(){
		
		String enterYourMarkMessage= "\nEnter the row and column you would like to place your mark\n";
		System.out.println(enterYourMarkMessage);}
	
	public char properTurnMark(){
	char mark = ' ';
	if (turn == 0 || turn == 2 || turn == 4 || turn == 6 || turn == 8){
			mark = 'X';}
		else if (turn == 1 || turn == 3 || turn == 5 || turn == 7){
			mark = 'O';}
		else{
			mark = ' ';}
	
	return mark;
	}
	
	public String playerTurnPrintout(){
		String message = "";
		if (turn == 0 || turn == 2 || turn == 4 || turn == 6 || turn == 8){
			message = "Player X, it is your turn.";}
		else if (turn == 1 || turn == 3 || turn == 5 || turn == 7){
			message = "Player O, it is your turn.";}
		else{
			message = "There was an error.";}
		return message;
	}
	
	public void getInput(){
		int col;
      	int row;
      	char mark;
      	boolean choice = false;
      	int answer;
      	Scanner input = new Scanner(System.in);
      	System.out.println();
      	System.out.println();
      
		String playerTurnMessage = playerTurnPrintout();
		System.out.println(playerTurnMessage);

      	do{
      		 printMessage();
      		 System.out.println("Enter an integer (1-3) for the row:   ");
			row = input.nextInt();
			System.out.println("Enter an integer (1-3) for the column:   ");
			col = input.nextInt();
			System.out.println("You entered ("+ row +","+col+")");
			System.out.println("Is this correct? 1-Yes 2-No:    ");
	    	answer = input.nextInt();
    		
    		if(answer == 1 ){
    			
    			col = col-1;
    			row = row-1;
    			if (getMark(row,col) != ' '){
    				System.out.println("That Space is Taken.");
    				choice = false;}
    			else{
    			choice = true;}
    				
    			}
  		  	else{
  		  		System.out.println("Please try again.");
  		  		choice = false;}
    	}while (choice == false);
    	
		mark = properTurnMark();
		
		setMark(row,col,mark);
		String gameBoard = gameBoardPrintout();
		System.out.print(gameBoard);
		
		}


	public static void main(String[] args) {
		
		TicTacToe t = new TicTacToe();
		String currentBoard = t.gameBoardPrintout();
		//System.out.println(currentBoard);String gameBoard = gameBoardPrintout();
		System.out.print(currentBoard);
		
		boolean gameOverCondition = t.isGameOver();
		
		do{
		t.getInput();
		gameOverCondition = t.isGameOver();
		} while(gameOverCondition== false);
		
		String outcome = t.howGameEnds();
		System.out.println("Game Over");
      	System.out.println("Result: "+outcome);
 
		
		
		
	}
}
