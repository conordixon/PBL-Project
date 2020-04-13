
/*PBL GROUP PROJECT
MorraGameGroup.java
@Abubakr Bhutta
@Conor Dixon
@Jeanne Hurlay
@Blerta Tzafai
13 04 2020
*/

import javax.swing.*;
import java.util.*;
import java.lang.Math.*;
import java.util.ArrayList;
import java.util.List;

public class MorraGameGroup{

	private int randomNo; //Computer generated number
	private int playerNo; //player picked number
	private int choiceEvenOrOdd;   //choose odd or even
	private int result; //compute result;
	private String strResult;//what is the result at string question
	private String strChoice;//what is the result of the choice
	private int playerScore;    //player score counter
	private int computerScore;	//computer score counter
	private String winner;  //display who the winner is
	public int count=0;    //count the total iterations
	private int ocount;	   //count the iterations for each object

	List<MorraGameGroup> Marray=new ArrayList<>();   //The array list for storing objects

	//Arrays to store History
	List<Integer> playerChoiceArr = new ArrayList<>();
	List<Integer> computerChoiceArr = new ArrayList<>();
	List<String>  strPlayerChoiceArr = new ArrayList<>();
	List<String> arrayResult = new ArrayList<>();
	List<Integer> playerScoreArr = new ArrayList<>();
	List<Integer> computerScoreArr = new ArrayList<>();
	List<String> winnerArr = new ArrayList<>();


	//default constructor
	public MorraGameGroup(){

		randomNo=0;
		playerNo=0;
		choiceEvenOrOdd=0;
		strResult="";
		strChoice="";
		playerScore=0;
		computerScore=0;
	 }


    //override Constructor
	public MorraGameGroup(int playerNo, int choiceEvenOrOdd){
		this.playerNo=playerNo;
		this.choiceEvenOrOdd=choiceEvenOrOdd;
	}
	//set random number for computer
	public void setRandomNo(){
		this.randomNo=((int)(Math.random()*10)+1);  //number between 1 and 10
	}

	//set players random number
	public void setPlayerNo(int playerNo){
		this.playerNo=playerNo;
	}

	//set players choice odd or even
	public void setChoiceEvenOrOdd(int choiceEvenOrOdd){
		this.choiceEvenOrOdd=choiceEvenOrOdd;
	}

	 //get player score
    public int getPlayerScore(){
		return playerScore;
    }

	//get computers number
	public int getRandomNo(){
		return randomNo;
	}

	//set players random number
	public int getPlayerNo(){
		return playerNo;
	}

    //get computer score
    public int getComputerScore(){
		return computerScore;
    }

	public String getStrChoice(){
		return strChoice;
    }

	public String getStrResult(){
		return strResult;
    }
	public  String getWinner(){
		return winner;
	}

	public void setCount(int count){
		this.ocount=count;
	}

	public int getCount(){
		return ocount;
	}

 //get the players choice odd or even
	public String getChoiceStr(){
		if((choiceEvenOrOdd%2)==1){
			this.strChoice="ODD";
			}
			else{
				this.strChoice="EVEN";
			}
			return strChoice;
	}

//Determine if the result is odd or even
	public String getResultStr(){
		result=(randomNo+playerNo)%2;
		if(result==0){
			strResult="EVEN";
		}
		else{
		    strResult="ODD";
		}
		 return strResult;
	}

//determine the winner of the game
	public String determineWinner(){
		if((playerScore>=12) && (computerScore<12)){
		 	winner= "PLAYER";
		}
		else if((playerScore<12) && (computerScore>=12)){ 
			winner= "COMPUTER";
		}
		else{ 
			winner="NO WINNER DRAWN GAME";}
		return winner;
	 }

// generate inputs
	public void generateInputs(){
		try{
			playerNo=Integer.parseInt(JOptionPane.showInputDialog(null,"Choose a number between 1 and 10"));
			if(playerNo>=1 && playerNo<=10){
				this.setRandomNo();
			choiceEvenOrOdd=Integer.parseInt(JOptionPane.showInputDialog(null,"Choose 1 for odd or 0 for even" ));
			System.out.println("You have chosen "+(this.getPlayerNo())+" fingers");
			System.out.println("You have chosen "+(this.getChoiceStr())+" team choice");

			//Display the computer choice
			System.out.println("Computer has chosen "+(this.getRandomNo())+" fingers");
			}
			else{
				ImageIcon turnback=new ImageIcon("turnback.png");
				JOptionPane.showMessageDialog(null, "This is an invalid value, please start again.", "Display Image", JOptionPane.INFORMATION_MESSAGE,turnback);
				generateInputs();
		}
	}
	catch(NumberFormatException e){//catches strings when it should be an int input
			ImageIcon turnback=new ImageIcon("turnback.png");
			JOptionPane.showMessageDialog(null, "You must enter a number, please try again!", "Display Image",JOptionPane.INFORMATION_MESSAGE,turnback);
			generateInputs();
		}
}

//calculate the main score
	public void calculateMainScore(){
		if(this.choiceEvenOrOdd != this.result){
			System.out.println("There is no game winner as the number choices are the same number type odd or even.");
		}
		else if(this.choiceEvenOrOdd == this.result){ //if strChoice is the same as strResult i.e. EVEN == EVEN or ODD=ODD
			playerScore=playerScore+3;
			System.out.println("Player wins the round");
			}
		else{  
			computerScore=computerScore+3;
			System.out.println("Computer wins the round");
		}

	}

	public void calculateBonusScore(){
		//calculate bonus score
		if(playerNo > randomNo){  //player is closer to the sum  1,2,3,4,5,6,7,8,9,10   {11,12,13,14,15,16,17,18,19,20}

		playerScore=playerScore+2;
		}
		else if(randomNo>playerNo){  //computer is closer to these sum
				computerScore=computerScore+2;
		}
		else if (randomNo == playerNo)  // in the case that player or computer number is the same i.e. equals cases
		{
			System.out.println("the both of them will get the bonus");
			playerScore=playerScore+2;
			computerScore=computerScore+2;
		}
    }

	//display the full history
	public void displayFullHistory(){
			//This outer loop prints out all the games, each game is assigned an object.
		for(int j=0;j<Marray.size();j++){

			System.out.println();
			System.out.println("******Printing History*****");
			System.out.println("Games "+(j+1));

			System.out.println("Player Number: ");

		for(int k=count-(Marray.get(j).getCount());k<(Marray.get(j).getCount());k++){
			System.out.println(playerChoiceArr.get(k));
			}
			System.out.println("Computer Number: ");

		for(int k1=count-(Marray.get(j).getCount());k1<(Marray.get(j).getCount());k1++){
			System.out.println( computerChoiceArr.get(k1));
			}
			System.out.println("Player ODD/EVEN Choice: ");
		for(int k6=count-(Marray.get(j).getCount());k6<(Marray.get(j).getCount());k6++){
			System.out.println( strPlayerChoiceArr.get(k6));
			}
			System.out.println("ODD/EVEN Result: ");
		for(int k2=count-(Marray.get(j).getCount());k2<(Marray.get(j).getCount());k2++){
			System.out.println( arrayResult.get(k2));
			}
			System.out.println("PlayerScore: ");
		for(int k3=count-(Marray.get(j).getCount());k3<(Marray.get(j).getCount());k3++){
			System.out.println( playerScoreArr.get(k3) );
			}
			System.out.println("Computer Score: ");
		for(int k4=count-(Marray.get(j).getCount());k4<(Marray.get(j).getCount());k4++){
			System.out.println( computerScoreArr.get(k4));
			}
			System.out.println("Winner: ");
		for(int k5=0;k5<winnerArr.size();k5++){
			System.out.println( winnerArr.get(k5));
			}

			System.out.println("%%%%%%%%%%%%%%%%");
		}
	}

	public void session(int i) {
			//Creates an object for each game
			Marray.add(new MorraGameGroup());

		do{
			//Function that asks user for number and choice and sets the computer number
			(Marray.get(i)).generateInputs();

			//print out result ODD or EVEN
			System.out.println("The result is: "+((Marray.get(i)).getResultStr()));

			(Marray.get(i)).calculateMainScore();
			(Marray.get(i)).calculateBonusScore();

			System.out.println("The player score for round " +(i+1)+ " is: "+((Marray.get(i)).getPlayerScore())+" Total Computer Score: "+(Marray.get(i)).getComputerScore());
			System.out.println();//empty line in the end of the round

			 //Counter to determine position in the ArrayList
			count=count+1;

			//It allows us to get the index of the first round of this particular game
			Marray.get(i).setCount(count);

			//Adding data to history array
			playerChoiceArr.add(Marray.get(i).getPlayerNo());
			computerChoiceArr.add(Marray.get(i).getRandomNo());
			strPlayerChoiceArr.add(Marray.get(i).getChoiceStr());
			arrayResult.add(Marray.get(i).getResultStr());
			playerScoreArr.add(Marray.get(i).getPlayerScore());
			computerScoreArr.add(Marray.get(i).getComputerScore());

		} //close do while loop

			//This loops iterates as long as the score for player and computer is less than 12
		while (((Marray.get(i)).getPlayerScore()<12) & ((Marray.get(i)).getComputerScore()<12));

			System.out.println( "The winner of this game is "+(Marray.get(i)).determineWinner());
			ImageIcon winner=new ImageIcon("winner.png");
			JOptionPane.showMessageDialog(null, "The winner of the game is " +(Marray.get(i)).determineWinner(),"Display Image", JOptionPane.INFORMATION_MESSAGE,winner);
			winnerArr.add(Marray.get(i).getWinner());
            System.out.println();//empty line for better appearance
		}

}