import edu.jsu.mcis.*;

public class TicTacToeKeywords {
	private TicTacToe t;
	
	
	public void startNewGame() {
		t= new TicTacToe();
	}
	
	public void markLocation(int row, int col) {
		int turn = t.turnCount();
		char mark;
		if (turn == 0 || turn == 2 || turn == 4 || turn == 6 || turn == 8){
			mark = 'X';}
		else if (turn == 1 || turn == 3 || turn == 5 || turn == 7){
			mark = 'O';}
		else{
			mark = ' ';}
		t.setMark(row, col, mark);
	}
	
	public String getMark(int row, int col) {
		char m = t.getMark(row, col);
		if (m == 'X')
			{return "X";}
		else if (m == 'O')
			{return "O";}
		else 
			{return "";}
		
		
	}
    
	public String getWinner() {
		String outcome = t.howGameEnds() ;
		if (outcome =="X wins"){
			return "X";}
		else if (outcome =="O wins"){
			return "O";}
		else if (outcome =="tie"){
			return "TIE";}
		else{
			return "";}
		
	}
}
