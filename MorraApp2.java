/*

Abubakr Bhutta 21/03/20 */

import javax.swing.*;
import java.util.*;
import java.lang.Math.*;

public class MorraApp2{

	public static void main (String args[]){

	int rand; //Computer generated number
	int play=0; //player generated number
	int choice=0;
	int scorep=0;
	int scorecom=0;
	int i=0;

	//Create Object
	Morra M= new Morra();

		while(i<1){
			//display choice
			M.session(i);

			i++;
		} //close while loop

	M.displayHistory();



	}

}

