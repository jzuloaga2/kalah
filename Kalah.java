import  java.util.Random;

public class Kalah{

public static void main(String[] args){

    int consoleInput;
    boolean goAgain,gameOver;
    Board thisBoard = new Board();
    thisBoard.printInstructions();
    thisBoard.initializeBoard();
    thisBoard.printBoard();

    gameOver = false;

    outerloop:    
    while(gameOver == false){

	goAgain = true;
        while(goAgain == true){
	    consoleInput = Integer.parseInt(System.console().readLine());
	    goAgain = thisBoard.moveHuman(consoleInput);
	    System.out.println("\n\n\n\n\n You chose to sow from house number " + consoleInput);
	    System.out.println("This is what the board looks like after your move:");
	    thisBoard.printBoard();
	    if(thisBoard.checkIfGameIsDone() == true){
		gameOver = true;
		break outerloop;
	    }
	    if(goAgain == true) System.out.println("Your got another turn. What house do you want to sow from?");
	}


	goAgain = true;
        while(goAgain == true){
	    System.out.println("Now it's my turn to move.");
	    goAgain = thisBoard.moveComputer();
	    System.out.println("This is what the board looks like after my move:");
	    thisBoard.printBoard();
	    if(thisBoard.checkIfGameIsDone() == true){
		gameOver = true;
		break outerloop;
	    }
	    if(goAgain == true) System.out.println("I got another turn.");	    
	}
	System.out.println("Now it's your turn to move. What house do you want to sow from?");
    }

    thisBoard.printFinalScores();
    thisBoard.printBoard();

}//end of main method


}//end of Kalah class
