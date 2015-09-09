package edu.jsu.mcis;


import org.junit.*;
import static org.junit.Assert.*;

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
		int turn = t.turnCount();
		if(turn == 0){
			t.setMark(0,0,'X');
			turn = t.turnCount();
			if(turn == 1){
				t.setMark(0,1,'O');
				turn = t.turnCount();
				if(turn == 2){
					t.setMark(0,2,'X');
					turn = t.turnCount();
					if(turn == 3){
						t.setMark(1,0,'O');
						turn = t.turnCount();
						if(turn == 4){
							t.setMark(1,1,'X');
							turn = t.turnCount();
							if(turn == 5){
								t.setMark(1,2,'X');
								turn = t.turnCount();
								if(turn == 6){
									t.setMark(2,0,'O');
									turn = t.turnCount();
									if(turn == 7){
										t.setMark(2,1,'X');
										turn = t.turnCount();
										if(turn == 8){
											t.setMark(2,2,'O');
											turn = t.turnCount();
											
											if(turn == 9){
												assertTrue(true);}
											else{assertTrue(false);}
										}
										else{assertTrue(false);}
									}
									else{assertTrue(false);}
								}
								else{assertTrue(false);}
							}
							else{assertTrue(false);}
						}
						else{assertTrue(false);}
					}
					else{assertTrue(false);}
				}
				else{assertTrue(false);}
			}
			else{assertTrue(false);}
		}
		else{assertTrue(false);}
	
	
	
	
	
		
	}
}
