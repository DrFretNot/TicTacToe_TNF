package edu.jsu.mcis;


import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.Scanner;

public class TicTacToeTest {
	

	@Test
	public void testInitialBoardIsEmpty() {
		TicTacToe t = new TicTacToe();
		for (int row = 0 ; row<3; row++){
			for (int col = 0; col<3; col++){
				assertEquals(' ', t.getMark(row,col));
			}
		}
	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
		TicTacToe t = new TicTacToe();
		t.setMark(0,2,'X');
		assertEquals('X', t.getMark(0,2));
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
		TicTacToe t = new TicTacToe();
		t.setMark(2,0,'O');
		assertEquals('O', t.getMark(2,0));	
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() {
		TicTacToe t = new TicTacToe();
		t.setMark(1,1,'O');
		t.setMark(1,1,'X');
		assertEquals('O', t.getMark(1,1));
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
		TicTacToe t = new TicTacToe();
		t.setMark(2,2,'X');
		if(t.isGameOver() == false){
			assertTrue(true);}
		else {
			assertTrue(false);}
	}
	
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
		TicTacToe t = new TicTacToe();
		t.setMark(0,0,'X');
		t.setMark(0,1,'X');
		t.setMark(0,2,'X');
		assertEquals('X', t.thisPlayerWon());
	}
	
	@Test
	public void testGameIsWonByODiagonallyFromBottomLeftToTopRight() {
		TicTacToe t = new TicTacToe();
		t.setMark(0,2,'O');
		t.setMark(1,1,'O');
		t.setMark(2,0,'O');
		assertEquals('O', t.thisPlayerWon());
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
		TicTacToe t = new TicTacToe();
		String how = " ";
		t.setMark(0,0,'X');
		t.setMark(0,1,'O');
		t.setMark(0,2,'X');
		t.setMark(1,0,'O');
		t.setMark(1,1,'X');
		t.setMark(1,2,'X');
		t.setMark(2,0,'O');
		t.setMark(2,1,'X');
		t.setMark(2,2,'O');

		if(t.isGameOver() == true){
			how = t.howGameEnds();
			if(how == "tie"){
			assertTrue(true);}
			else{assertTrue(false);}
			}
		else {
			assertTrue(false);}
		
	}	
	
	@Test
	public void testGameIsCountingTurnsWhenMarkIsMade(){
		TicTacToe t = new TicTacToe();
		char[] correctMark = {'X','O','X','O','X','X','O','X','O'};
		//boolean markX = true;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				int turn = t.turnCount();
				int correctTurn = 3 * i + j;
				if(turn == correctTurn) {
					char mark = correctMark[correctTurn];
					t.setMark(i, j, mark);
					//markX = !markX;
				}
				else {
					assertTrue(false);
				}
			}
			assertTrue(true);
		}
		
		
	
	
		
	}
	
	@Test
	public void testThatGameBoardIsPrintingCorrectlyWhenBlank(){
		TicTacToe t = new TicTacToe();
		String gameBoard = t.gameBoardPrintout();
		assertTrue(gameBoard.equals("\n   (1)(2)(3)\n(1)[ ][ ][ ]\n(2)[ ][ ][ ]\n(3)[ ][ ][ ]\n"));
	
	}
	
	@Test
	public void testThatGameBoardIsPrintingCorrectlyAfterEachTurn(){
		
		
		TicTacToe t = new TicTacToe();
		String gameBoard = t.gameBoardPrintout();
		
		
		t.setMark(0,0,'X');
		t.setMark(0,1,'O');
		t.setMark(0,2,'X');
		t.setMark(1,0,'O');
		t.setMark(1,1,'X');
		t.setMark(1,2,'X');
		t.setMark(2,0,'O');
		t.setMark(2,1,'X');
		t.setMark(2,2,'O');
		
		
		gameBoard = t.gameBoardPrintout();
		if(gameBoard.equals("\n   (1)(2)(3)\n(1)[X][O][X]\n(2)[O][X][X]\n(3)[O][X][O]\n")){
			assertTrue(true);}
		else{assertTrue(false);}
		
	}
	
	
	
	
}
