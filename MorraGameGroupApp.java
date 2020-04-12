/*PBL GROUP PROJECT
MorraGameGroupApp.java
@Abubakr Bhutta
@Conor Dixon
@Jeanne Hurlay
@Blerta Tzafai

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
	// String playAgain;

	//Create Object
	MorraGameGroup M= new MorraGameGroup();
	MorraGameGroup myMorraT= new MorraGameGroup();


		while(i<10){

			M.session(i);
             i++;
			playAgain= JOptionPane.showInputDialog(null," END of this Round !!!! Would you like to Play again ?");

			             if(playAgain.equalsIgnoreCase("yes")){
								System.out.println(" CONTINUE WITH NEXT ROUND");


							}else {System.out.println(" CHECK YOUR HISTORY");
								break;

							   	}


		} //close while loop


	M.displayFullHistory();


	i++;

	}


}