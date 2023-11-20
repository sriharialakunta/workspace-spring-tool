package com.freshcode;

public class Stringwithoutvowels {
	    public String disemvowel(String str) {
	      String temp="";
//	      String vowels="AaEeIiOoUu";
	        for(int i=0; i<=str.length(); i++){
	        	
	          if(temp.contains("AaEeIiOoUu")){
	            break;
	          }
	          temp += str.charAt(i);
	      
	    }return temp;
	}
}
