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

public class MorraT{

	private int rand; //Computer generated number
	private int play; //player picked number
	private int choice;   //choose odd or even
	private int result; //compute result;
	private String strresult;//
	private String strchoice;
	private int scorep;    //player score counter
	private int scorecom;	//computer score counter
	private String winner;  //display who the winner is ??
	public int count=0;    //count the total iterations
	private int ocount;	   //count the iterations for each object
	List<MorraT> Marray=new ArrayList<>();   //The array list for storing objects

	//Arrays to store History
	List<Integer> ChoiceP = new ArrayList<>();
	List<Integer> ChoiceCom =new ArrayList<>();
	List<String>  ChoicePStr= new ArrayList<>();
	List<String> Resultarr =new ArrayList<>();
	List<Integer> ScoreP   =new ArrayList<>();
	List<Integer> ScoreCom =new ArrayList<>();
	List<String> WinnerArr =new ArrayList<>();


	//default constructor
	public MorraT(){

		rand=0;
		play=0;
		choice=0;
		strresult="";
		strchoice="";
		scorep=0;
		scorecom=0;

	 }

	public MorraT( int play, int choice) {

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

	 //get player score
    public int getScoreP(){
			return scorep;
    }

	//get computers number
	public int getRand(){
		return rand;
	}

	//set players random number
		public int getPlay(){
			return play;
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

	public void setCount(int count) {
			this.ocount= count;
	}

	public int getCount() {
			return ocount;
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


//Determine if the result is odd or even
	public String getstrResult(){

		  result =(rand+play)%2;

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

	public void generateInputs(){

			this.play =   Integer.parseInt(JOptionPane.showInputDialog(null, "Choose a number" ));
			this.choice = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose 1 for odd or 0 for even" )); //can also take string input, and convert even(case ignore) or odd

			this.setRand();

			System.out.println("You have chosen "+(  this.getPlay() )+" fingers");
			System.out.println("You have chosen "+(  this.getStrChoice())+" outcome");

			//display using JOption Pane
			//JOptionPane.showMessageDialog(null,"You have chosen "( (Marray.get(i)).getPlay())+" fingers");
			//JOptionPane.showMessageDialog(null,"You have chosen "+( (Marray.get(i)).getChoice())+" outcome");

			//Display Computers choice
			System.out.println("Computer has chosen "+(this.getRand())+" fingers");
			//Display using JOption Pane
			//JOptionPane.showMessageDialog(null,"Computer has chosen "+(( Marray.get(i)).getRand())+" fingers");

	}

	public void calculateMainScore(){

		  if ( this.choice == this.result) //if strchoice is the same as strresult i.e. EVEN == EVEN or ODD=ODD
								{
									scorep=scorep+3;
									System.out.println("Player wins the round");
								}

		  else
								{
									scorecom=scorecom+3;
									System.out.println("Computer wins the round");
								}

	}


	public void calculateBonusScore(){

		  						   //calculate bonus score
						   if     (  play>rand )  //player is closer to the sum  1,2,3,4,5,6,7,8,9,10   {11,12,13,14,15,16,17,18,19,20}
						  		{
						  			scorep=scorep+2;
						  		}
						   else if(  rand>play  )  //computer is closer to these sum
						  	    {
						  			scorecom=scorecom+2;
							    }
						   else   // in the case that player or computer number is the same i.e. Equals cases
							    {
								  //Player and Computer both get the bonus
								  // scorep=scorep+2;
								  // scorecom=scorecom+2;
					   			}
    }

	//The old display history function
	/*public void displayHistory(){

		for(int j=0;j<Marray.size();j++){
			System.out.println("******Printing History*****");
			System.out.println("Round "+(j+1)+" Player number choice: "+(Marray.get(j)).getPlay());
			System.out.println("Player choice: "+(Marray.get(j)).getStrChoice());
			System.out.println("Computer number choice: "+(Marray.get(j)).getRand());
			System.out.println("Result : "+(Marray.get(j)).getStrResult());
			System.out.println("Player Score: "+(Marray.get(j)).getScoreP());
			System.out.println("Com Score: "+(Marray.get(j)).getScoreCom());
			System.out.println("Winner: "+(Marray.get(j)).getWinner());

			}

	}  */
	public void displayFullHistory(){
			//This outer loop prints out all the games, each game is assigned an object.
			for(int j=0;j<Marray.size();j++){
				System.out.println();
				System.out.println("******Printing History*****");
				System.out.println("Round "+(j+1));

				System.out.println("Player Number: ");
				for(int k=count-(Marray.get(j).getCount());k<( Marray.get(j).getCount());k++){
					System.out.println(ChoiceP.get(k));
				}
				System.out.println("Computer Number: ");
				for(int k1=count-(Marray.get(j).getCount());k1<( Marray.get(j).getCount());k1++){
					System.out.println( ChoiceCom.get(k1));
				}
				System.out.println("Player ODD/EVEN Choice: ");
				for(int k6=count-(Marray.get(j).getCount());k6<( Marray.get(j).getCount());k6++){
					System.out.println( ChoicePStr.get(k6));
				}
				System.out.println("ODD/EVEN Result: ");
				for(int k2=count-(Marray.get(j).getCount());k2<( Marray.get(j).getCount());k2++){
					System.out.println( Resultarr.get(k2));
				}
			 	System.out.println("PlayerScore: ");
				for(int k3=count-(Marray.get(j).getCount());k3<( Marray.get(j).getCount());k3++){
					System.out.println( ScoreP.get(k3) );
				}
				System.out.println("Computer Score: ");
				for(int k4=count-(Marray.get(j).getCount());k4<( Marray.get(j).getCount());k4++){
					System.out.println( ScoreCom.get(k4) );
				}
				System.out.println("Winner: ");
				for(int k5=0;k5<WinnerArr.size();k5++){
					System.out.println( WinnerArr.get(k5));
				}

				System.out.println("%%%%%%%%%%%%%%%%");


		}


	}

	public void session(int i) {

				  //Creates an object for each game
				  Marray.add(i,new MorraT());

					do	 {

				  //Function that asks user for number and choice and sets the computer number
				  (Marray.get(i)).generateInputs();

				  //print out result ODD or EVEN
				  System.out.println("The result is: "+( (Marray.get(i)).getstrResult()));

				  (Marray.get(i)).calculateMainScore();
				  (Marray.get(i)).calculateBonusScore();

				  System.out.println( "The player score for round " +(i+1)+ " is: "+( (Marray.get(i)).getScoreP() )+" Total Com Score: "+( Marray.get(i) ).getScoreCom() );
				  //JOptionPane.showMessageDialog(null,"You have chosen );


				  //Counter to determine position in the ArrayList
				  count=count+1;

				  //It allows us to get the index of the first round of this particular game
				  Marray.get(i).setCount( count );

				  //Adding data to history array
				  ChoiceP.add( Marray.get(i).getPlay() );
				  ChoiceCom.add( Marray.get(i).getRand() );
				  ChoicePStr.add( Marray.get(i).getStrChoice());
				  Resultarr.add( Marray.get(i).getstrResult() );
				  ScoreP.add( Marray.get(i).getScoreP() );
				  ScoreCom.add( Marray.get(i).getScoreCom());
				  //WinnerArr.add( Marray.get(i).getWinner());

				  }    //close do while loop

				  //This loops iterates as long as the score for player and computer is less than 12
				  while   ( ( (Marray.get(i) ).getScoreP()<12) & ( ( Marray.get(i) ).getScoreCom()<12));

				  System.out.println( "The winner for this round is "+( Marray.get(i) ).determineWinner());
				  WinnerArr.add( Marray.get(i).getWinner());

				 }     //close session statement






}

/*   game
  <----->
  |7,7,9|9,8,5|5,3,6|

       3|    6|    9|
  <---------------->
        count

  <----><-----><---->
  ocount ocount ocount

*/