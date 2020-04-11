/*

Abubakr Bhutta 21/03/20 */

import javax.swing.*;
import java.util.*;
import java.lang.Math.*;
import java.util.ArrayList;
import java.util.List;

public class MorraApp2{

	public static void main (String args[]){

	int rand; //Computer generated number
	int play=0; //player generated number
	int choice=0;
	int scorep=0;
	int scorecom=0;
	int i=0;   //The counter that determines how many games to be played

	//Create Object
	MorraT M= new MorraT();


		while(i<1){

			M.session(i);

			i++;
		} //close while loop

	M.displayFullHistory();



	}

}