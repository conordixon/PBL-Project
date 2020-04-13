/*PBL GROUP PROJECT
MorraGameGroupApp.java
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

public class MorraGameGroupApp{

	public static void main (String args[]){

	int rand; //Computer generated number
	int play=0; //player generated number
	int choice=0;
	int scorep=0;
	int scorecom=0;
	String playAgain="";
	int i=0;   //The counter that determines how many games to be played

	//Create Object
	MorraGameGroup M= new MorraGameGroup();


		while(i<10){
			M.session(i);
			M.displayFullHistory();      
			playAgain=JOptionPane.showInputDialog(null,"This is the end of the game. Would you like to play the game again?");
			if(playAgain.equalsIgnoreCase("yes")){
				System.out.println("Please continue with the next game");
				i++;
				M.displayFullHistory();
			}
			else{
				System.out.println("Please see above your game history");
			break;
			}
		} //close while loop
	}


}