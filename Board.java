import  java.util.Random;

public class Board{

int[] bArray = new int[14];

public void printInstructions(){

System.out.println("Let's play Kalah!");
System.out.println("I am a computer and I will play against you.");
System.out.println("");
System.out.println("To play against me, use the convention of numbering the board houses as follows:");

System.out.print("----------------------------------------");
System.out.println("----------------------------------------");
System.out.print("----------------------------------------");
System.out.println("----------------------------------------");
System.out.println("");
System.out.print("\t" + 13 
               + "\t" + 12
               + "\t" + 11
               + "\t" + 10
               + "\t" + 9
               + "\t" + 8 + "\n");
System.out.print(0);
System.out.println("\t\t\t\t\t\t\t" + 7);
System.out.print("\t" + 1 
               + "\t" + 2
               + "\t" + 3
               + "\t" + 4
               + "\t" + 5
               + "\t" + 6 + "\n");
System.out.println("");
System.out.print("----------------------------------------");
System.out.println("----------------------------------------");
System.out.print("----------------------------------------");
System.out.println("----------------------------------------");
System.out.println("");
System.out.println("");
System.out.println("Your houses are numbered 1 through 6. My houses are numbered 8 through 13.");
System.out.println("");
System.out.println("When it is your turn, just tell me the number of the house you want to sow from.");
System.out.println("");
System.out.println("");
System.out.println("Ready to start?");
System.out.println("");
System.out.println("Here is the initial configuration with our seeds randomly allocated to our houses.");
System.out.println("");
System.out.println("I'll let you have the first move... Go ahead...");

}//end of printInstructions method


public void initializeBoard(){

  for(int ii=0;ii<=13;ii++) bArray[ii]=0;
  
  Random randomGenerator = new Random();
  int randomInt;
  //Makes initial distribution of seeds for human player:
  for (int ii=1;ii<=30;ii++){
      randomInt = randomGenerator.nextInt(6);
      randomInt++;
      bArray[randomInt] = bArray[randomInt] + 1;
  }
  //Makes initial distribution of seeds for computer:
  for (int ii=1;ii<=30;ii++){
      randomInt = randomGenerator.nextInt(6);
      randomInt = randomInt + 8;
      bArray[randomInt] = bArray[randomInt] + 1;
  }

}//end of initializeBoard method

public void printBoard(){

System.out.print("----------------------------------------");
System.out.println("----------------------------------------");
System.out.print("----------------------------------------");
System.out.println("----------------------------------------");
System.out.println("");
System.out.print("\t" + bArray[13] 
               + "\t" + bArray[12]
               + "\t" + bArray[11]
               + "\t" + bArray[10]
               + "\t" + bArray[9]
               + "\t" + bArray[8] + "\n");
System.out.print(bArray[0]);
System.out.println("\t\t\t\t\t\t\t" + bArray[7]);
System.out.print("\t" + bArray[1] 
               + "\t" + bArray[2]
               + "\t" + bArray[3]
               + "\t" + bArray[4]
               + "\t" + bArray[5]
               + "\t" + bArray[6] + "\n");
System.out.println("");
System.out.print("----------------------------------------");
System.out.println("----------------------------------------");
System.out.print("----------------------------------------");
System.out.println("----------------------------------------");


}//end of printBoard method


public boolean moveHuman(int input){
    boolean goAgain = false;
    int visitNow,endOpposite;
    int count = bArray[input];
    bArray[input] = 0;
    visitNow = 0;
    endOpposite = 0;
    for(int ii=1;ii<=count;ii++){
	visitNow = (input + ii)%14;
	if(visitNow != 0){
	    bArray[visitNow]++;
	}else count++;
    }
    // If the last seed was dropped in one of the human's empty houses:
    if(  (bArray[visitNow]==1) && (visitNow <=6) && (visitNow >=1)  ){
      switch(visitNow){
        case 1: endOpposite = 13;
 	        break;
        case 2: endOpposite = 12;
 	        break;
        case 3: endOpposite = 11;
 	        break;
        case 4: endOpposite = 10;
 	        break;
        case 5: endOpposite = 9;
 	        break;
        case 6: endOpposite = 8;
 	        break;
      }
      bArray[7]=bArray[7]+bArray[visitNow]+bArray[endOpposite];
      bArray[visitNow] = 0;
      bArray[endOpposite] = 0;
    }
    
    if(visitNow == 7) goAgain = true;
    return goAgain;

}//end of moveHuman method


public boolean moveComputer(){

    Random randomGenerator = new Random();
    int input;
    //Randomly picks which house to sow from:
    input = randomGenerator.nextInt(6);
    input = input + 8;
    
    System.out.println("I choose to sow from house number " + input);
    
    boolean goAgain = false;
    int visitNow,endOpposite;
    int count = bArray[input];
    if(count == 0) return false;
    bArray[input] = 0;
    visitNow = 0;
    endOpposite = 0;
    for(int ii=1;ii<=count;ii++){
	visitNow = (input + ii)%14;
	if(visitNow != 7){
	    bArray[visitNow]++;
	}else count++;
    }
    // If the last seed was dropped in one of the computer's empty houses:
    if(  (bArray[visitNow]==1) && (visitNow <=13) && (visitNow >=8)  ){
      switch(visitNow){
        case 8: endOpposite = 6;
 	        break;
        case 9: endOpposite = 5;
 	        break;
        case 10: endOpposite = 4;
 	        break;
        case 11: endOpposite = 3;
 	        break;
        case 12: endOpposite = 2;
 	        break;
        case 13: endOpposite = 1;
 	        break;
      }
      bArray[0]=bArray[0]+bArray[visitNow]+bArray[endOpposite];
      bArray[visitNow] = 0;
      bArray[endOpposite] = 0;
    }
    
    if(visitNow == 0) goAgain = true;
    return goAgain;

}//end of moveComputer method


public boolean checkIfGameIsDone(){

    int count;

    count = 0;
    for(int ii=1;ii<=6;ii++){
	if(bArray[ii] == 0) count++;
    }
    if(count == 6) return true;

    count = 0;
    for(int ii=8;ii<=13;ii++){
	if(bArray[ii]==0) count++;
    }
    if(count == 6) return true;

    return false;

}//end of checkIfGameIsDone



public void printFinalScores(){

    for(int ii=1;ii<=6;ii++){
	bArray[7]=bArray[7]+bArray[ii];
	bArray[ii]=0;
    }    
    for(int ii=8;ii<=13;ii++){
	bArray[0]=bArray[0]+bArray[ii];
	bArray[ii]=0;
    }    

    System.out.println("\n\n\n The Game is over!");
    System.out.println("\n\n Your final score is: " + bArray[7]);
    System.out.println("\n\n My final score is: " + bArray[0]);

}//end of printFinalScores method


}//end of class Board
