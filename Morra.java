/*

Abubakr
Bhutta
29/02/20

*/

import javax.swing.*;
import java.util.*;
import java.lang.Math.*;
import java.util.ArrayList;
import java.util.List;

public class Morra{

	private int rand; //Computer generated number
	private int play; //player picked number
	private int choice;   //choose odd or even
	private int result; //compute result;
	private String strresult;//
	private String strchoice;
	private int scorep;    //player score counter
	private int scorecom;	//computer score counter
	private String winner;  //display who the winner is ??


	List<Morra> Marray=new ArrayList<>();

	//default constructor
	Morra(){

		rand=0;
		play=0;
	//	history = new ArrayList<Morra>();
	//	round=round+1;
		choice=0;
		strresult="";
		strchoice="";
		scorep=0;
		scorecom=0;


	 }

	Morra( int play, int choice) {

		this.play=play;
		this.choice=choice;
	}
	//set random number
	public void setRand(){
			this.rand=((int)(Math.random()*10));  //number between 1 and 10
	}

	//set players random number
	public void setPlay(int play){
		this.play= play;
	}

	//set players choice odd or even
	public void setChoice(int choice){
		this.choice= choice;
	}



	//get computers number
	public int getRand(){
		return rand;
	}

	//get the players number
	public int getPlay(){
		return play;
    }

    //get player score
    public int getScoreP(){
			return scorep;
    }

    //get computer score
     public int getScoreCom(){
			return scorecom;
    }

	 public String getChoice(){
			return strchoice;
    }

	 public String getStrResult(){
			return strresult;
    }
	public  String getWinner(){
			return winner;
	}

 //get the players Choice odd or even
	public String getStrChoice(){
				if((choice%2)==1)
				{
				  this.strchoice= "ODD";
				}

				else
				{ this.strchoice = "EVEN"; }
			return strchoice;
  		  }

/*	//get the player score
	public int getScore(int i,int j){
			return score[i][j];
    }

    //get computer score
    public int getComputerScore(int i,int j){
				return computerscore[i][j];  }
 */

	public String getstrResult(){

		 result =(rand+play)%2;
		 choice= (choice%2); //determines if choice is odd or even
		  if(result==0)
			{strresult="EVEN";}
		  else
		    {strresult="ODD";}

		 return strresult;
    }

	public String determineWinner(){

		 if( (scorep>=12) && (scorecom<12))
		 	{winner= "PLAYER";}
		 else if( (scorep<12) && (scorecom>=12))
		 	{ winner= "COM";}
		 else
		 	{ winner="BOTH";}
		 return winner;
	 }

	//prints the score for each round
    /*public void printScore(){

				for(int i=1;i<score.length;i++){
						for(int j=1; j<score[i].length;j++){
							//JOptionPane.showMessageDialog(null,"The score is: "+getScore(i,j));
							System.out.println("The player score for round   "+i+" is: "+getScore(i,j)+" total player score is:   "+( getScoreP() )+" Total Com Score: "+(getScoreCom() ) );

						}
						System.out.println();
					}

	}   */

	public void generateInputs(){

			this.play =   Integer.parseInt(JOptionPane.showInputDialog(null, "Choose a number" ));
			this.choice = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose 1 for odd or 0 for even" )); //can also take string input, and convert even(case ignore) or odd

			this.setRand();

			System.out.println("You have chosen "+(  this.getPlay() )+" fingers");
			System.out.println("You have chosen "+(  this.getChoice())+" outcome");

			//display using JOption Pane
			//JOptionPane.showMessageDialog(null,"You have chosen "( (Marray.get(i)).getPlay())+" fingers");
			//JOptionPane.showMessageDialog(null,"You have chosen "+( (Marray.get(i)).getChoice())+" outcome");

			//Display Computers choice
			System.out.println("Computer has chosen "+(this.getRand())+" fingers");
			//Display using JOption Pane
			//JOptionPane.showMessageDialog(null,"Computer has chosen "+(( Marray.get(i)).getRand())+" fingers");

	}

	public void calculateMainScore(){

		  if ( this.choice == this.result) //if choice is the same as result i.e. EVEN == EVEN or ODD=ODD
								{
									//score[a][b]=1;
									//computerscore[a][b]=0;
									scorep=scorep+3;
									System.out.println("Player wins the round");
								}

		  else
								{
										//score[a][b]=0;
										//computerscore[a][b]=1;
										scorecom=scorecom+3;
										System.out.println("Computer wins the round");
								}

	}

	public void calculateBonusScore(){

		  //calculate bonus
						   if     (  rand<play )
						  		{
						  			scorep=scorep+2;
						  		}
						   else if( rand>play  )
						  	    {
						  			scorecom=scorecom+2;
							    }
						   else
							   {

					   }
    }

	public void displayHistory(){

		for(int j=0;j<Marray.size();j++){
			System.out.println("******Printing Round History*****");
			System.out.println("Round "+(j+1)+" Player number choice: "+(Marray.get(j)).getPlay());
			System.out.println("Player Choice: "+(Marray.get(j)).getStrChoice());
			System.out.println("Computer Number Choice: "+(Marray.get(j)).getRand());
			System.out.println("Result : "+(Marray.get(j)).getStrResult());
			System.out.println("Player Score: "+(Marray.get(j)).getScoreP());
			System.out.println("Com Score: "+(Marray.get(j)).getScoreCom());
			System.out.println("Winner: "+(Marray.get(j)).getWinner());

		}

	}

	public void session(int i) {

					do	 {

				  Marray.add(new Morra());
				  (Marray.get(i)).generateInputs();
			//	  ( Marray.get(i)).setPlay(play);
			//	  ( Marray.get(i)).setChoice(choice);


				  //print out result ODD or EVEN
				  System.out.println("The result is: "+( (Marray.get(i)).getstrResult()));

				  (Marray.get(i)).calculateMainScore();
				  (Marray.get(i)).calculateBonusScore();

				  System.out.println( "The player score for round " +(i+1)+ " is: "+( (Marray.get(i)).getScoreP() )+" Total Com Score: "+( Marray.get(i) ).getScoreCom() );



					 }    //close do while loop

					while   ( ( (Marray.get(i) ).getScoreP()<12) & ( ( Marray.get(i) ).getScoreCom()<12));

					 System.out.println( "The winner for this round is "+( Marray.get(i) ).determineWinner());

				 }     //close session statement






}