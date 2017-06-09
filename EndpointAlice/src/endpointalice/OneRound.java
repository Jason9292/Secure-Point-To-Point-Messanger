/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package endpointalice;

/**
 *
 * @author JasonatUSF
 */
import java.math.BigInteger;
import java.util.Arrays;

public class OneRound implements IDESRound{

	private static int[] expansion = {						//expansion array that was shown in powerpoint slides
        32, 1,  2,  3,  4,  5,								//lecture3, page 45/48
        4,  5,  6,  7,  8,  9,								
        8,  9,  10, 11, 12, 13,
        12, 13, 14, 15, 16, 17,
        16, 17, 18, 19, 20, 21,
        20, 21, 22, 23, 24, 25,
        24, 25, 26, 27, 28, 29,
        28, 29, 30, 31, 32, 1
   	};

    public static String hexStringToBinaryString( String in ) {			//converts a hexString to binary
      String bin = "";							//hold total string value
		String binFragment = "";						//hold individual fragment
		int x;
		for (int i = 0; i < in.length(); i++){					//iterate through the string
			if ((in.charAt(i) == 'a')||(in.charAt(i) == 'b')||(in.charAt(i) == 'c')||(in.charAt(i) == 'd')||(in.charAt(i) == 'e')||(in.charAt(i) == 'f')){								//if a hexidecimal character
				switch (in.charAt(i)){
					case 'a':					//set integer equal to 
						x = 10;					//decimal representation
						break;					//of that character
					case 'b':
						x = 11;
						break;
					case 'c':
						x = 12;
						break;
					case 'd':
						x = 13;
						break;
					case 'e':
						x = 14;
						break;
					default:
						x = 15;
						break;	
				}
			}
			else{
				x = Integer.parseInt(in.substring(i, i+1));	//if not just set equal to value of itself
			}
			binFragment = Integer.toBinaryString(x);		//convert it to string
		
			while (binFragment.length() < 4){
				binFragment = "0" + binFragment;		//make sure strings are same size
			}
				bin += binFragment;				//add it to total string size
			}
		return bin;
    	}
	
	DES myDes = new DES();								//create object of Des class for use of functions

	public byte[/*8*/] doOneRound( byte[/*8*/] data, byte[/*6*/] key ){
	
		byte[] Ldata = Arrays.copyOfRange(data,0,4);				//used to hold left hand block
		byte[] Rdata = Arrays.copyOfRange(data,4,8);				//used to hold right hand block

		byte[] expandedRdata = new byte[6];					//used to hold new block after expansion
		
		for (int i = 0; i < 48; i++){						//loop for expansion function
			expandedRdata[i/8] <<=1;
			int loc = expansion[i] - 1;					//placeholder value, subtract 1 so equal to index
			expandedRdata[i/8] |= myDes.getBit(7-(loc%8),Rdata[loc/8]);		
		}							

		String Rdata1 = myDes.byteArrayToString(expandedRdata);			//convert expanded R into a hex string
		String Kdata1 = myDes.byteArrayToString(key);				//convert key into a hex string

		String Rblock1 = hexStringToBinaryString(Rdata1);			//hex string to binary string
		String Kblock1 = hexStringToBinaryString(Kdata1);			//same thing for key

		String result = "";							//string to hold values of xor'd values
		String temporary = "";
		for (int i = 0; i < 48; i++){						//iterate through every bit
			if (Rblock1.charAt(i) == Kblock1.charAt(i)){			//if same
				temporary = "0";					//set to 0
			}
			else{								//if different
				temporary = "1";					//set to 1
			}
			result += temporary;						//store result of XOR with key
			temporary = "";							//reset temporary variable
		}							

		int row = 0;								//to hold value of row;
		String row1 = "";
		int column = 0;								//to hold value of column
		String column1 = "";
		int[] postSbox = new int[8];						//to hold resulting values from sbox

		row1 = result.substring(0,1) + result.substring(5,6);			//row is 1st and 6th bits
		row = Integer.parseInt(row1, 2);					//convert to an integer

		column1 = result.substring(1,5);					//column is bits 2-5
		column = Integer.parseInt(column1, 2);					//convert to an integer

		postSbox[0] = myDes.SBoxContents[0][row][column];			//store resulting sbox result

		row = 0;								//reset variables
		row1 = "";
		column = 0;
		column1 = "";

		row1 = result.substring(6,7) + result.substring(11,12);			//do again for next 6 bits
		row = Integer.parseInt(row1, 2);			

		column1 = result.substring(7,11);				
		column = Integer.parseInt(column1, 2);			

		postSbox[1] = myDes.SBoxContents[1][row][column];		

		row = 0;
		row1 = "";
		column = 0;
		column1 = "";

		row1 = result.substring(12,13) + result.substring(17,18);		//do again for next 6 bits
		row = Integer.parseInt(row1, 2);			

		column1 = result.substring(13,17);				
		column = Integer.parseInt(column1, 2);			

		postSbox[2] = myDes.SBoxContents[2][row][column];		

		row = 0;
		row1 = "";
		column = 0;
		column1 = "";

		row1 = result.substring(18,19) + result.substring(23,24);		//do again for next 6 bits
		row = Integer.parseInt(row1, 2);			

		column1 = result.substring(19,23);				
		column = Integer.parseInt(column1, 2);				

		postSbox[3] = myDes.SBoxContents[3][row][column];		

		row = 0;
		row1 = "";
		column = 0;
		column1 = "";

		row1 = result.substring(24,25) + result.substring(29,30);		//do again for next 6 bits
		row = Integer.parseInt(row1, 2);			

		column1 = result.substring(25,29);				
		column = Integer.parseInt(column1, 2);				

		postSbox[4] = myDes.SBoxContents[4][row][column];		

		row = 0;
		row1 = "";
		column = 0;
		column1 = "";

		row1 = result.substring(30,31) + result.substring(35,36);		//do again for next 6 bits
		row = Integer.parseInt(row1, 2);			

		column1 = result.substring(31,35);				
		column = Integer.parseInt(column1, 2);				

		postSbox[5] = myDes.SBoxContents[5][row][column];		

		row = 0;
		row1 = "";
		column = 0;
		column1 = "";

		row1 = result.substring(36,37) + result.substring(41,42);		//do again for next 6 bits
		row = Integer.parseInt(row1, 2);			

		column1 = result.substring(37,41);				
		column = Integer.parseInt(column1, 2);				

		postSbox[6] = myDes.SBoxContents[6][row][column];		

		row = 0;
		row1 = "";
		column = 0;
		column1 = "";

		row1 = result.substring(42,43) + result.substring(47,48);		//do again for next 6 bits
		row = Integer.parseInt(row1, 2);			

		column1 = result.substring(43,47);				
		column = Integer.parseInt(column1, 2);				

		postSbox[7] = myDes.SBoxContents[7][row][column];	
		
		String s = "";								//string to hold new binary value
		for (int i = 0; i < 8; i++){						//iterate through sbox values
			String stemp = Integer.toBinaryString(postSbox[i]);		//set value to string
			while (stemp.length() < 4){
				stemp = "0" + stemp;					//make sure all the same size
			}
			s += stemp;							//add value to overall string
		}

		String hexaString = "";							//string to convert back to hexa
		int decimal;								//to hold values
		String convertS = "";							//to hold values
		for (int i = 0; i < 32; i += 4){					//8 groups of 4 binary bits
			decimal = Integer.parseInt(s.substring(i,i+4), 2);		//convert index0-index3 to an int
			convertS = Integer.toString(decimal,16);			//convert that int into a hex string
			hexaString += convertS;						//append hex string to the string
		}

		byte[] b = new byte[hexaString.length() / 2];				//convert 32 bit hexa string to byte array
		for (int i = 0; i < b.length; i++){
			int index = i *2;
			int v = Integer.parseInt(hexaString.substring(index, index + 2), 16);
			b[i] = (byte) v;
		}		
		
		byte[] postPermutation = new byte[4];
		for (int i = 0; i < 32; i++){						//for permutation
			postPermutation[i/8] <<= 1;					//shift one bit each time
			int loc = myDes.permutationBits[i];				
			postPermutation[i/8] |= myDes.getBit(7-(loc%8),b[loc/8]); 
		}

		String LdataAfter = myDes.byteArrayToString(Ldata);			//convert original lblock to hex string
		String FdataAfter = myDes.byteArrayToString(postPermutation);		//conver post permutation too

		String LAfter = hexStringToBinaryString(LdataAfter);			//now convert both to binary
		String FAfter = hexStringToBinaryString(FdataAfter);

		String finalXOR = "";
		String placeHolder = "";
		for (int i = 0; i < 32; i++){						//XOR each individual string
			if (LAfter.charAt(i) == FAfter.charAt(i)){
				placeHolder = "0";
			}
			else{
				placeHolder = "1";
			}
			finalXOR += placeHolder;					//final binary string
			placeHolder = "";
		}

		String hexaStringFinal = "";
		int decimalFinal;
		String convertFinal = "";
		for (int i = 0; i < 32; i += 4){
			decimalFinal = Integer.parseInt(finalXOR.substring(i, i+4), 2);
			convertFinal = Integer.toString(decimalFinal, 16);
			hexaStringFinal += convertFinal;
		}		

		byte[] Rblock = new byte[hexaStringFinal.length() / 2];			//convert this XOR'd value to byte array
		for (int i = 0; i < Rblock.length; i++){
			int index = i * 2;
			int v = Integer.parseInt(hexaStringFinal.substring(index, index + 2), 16);
			Rblock[i] = (byte) v;
		}
		
		byte[] returnValue = new byte[8];

		returnValue[0] = Rdata[0];						//combine these into 1 array
		returnValue[1] = Rdata[1];						//that will be returned
		returnValue[2] = Rdata[2];
		returnValue[3] = Rdata[3];
		returnValue[4] = Rblock[0];
		returnValue[5] = Rblock[1];
		returnValue[6] = Rblock[2];
		returnValue[7] = Rblock[3];

		return returnValue;
	}

}              
