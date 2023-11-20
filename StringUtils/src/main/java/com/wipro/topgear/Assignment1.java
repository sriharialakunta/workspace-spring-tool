package com.wipro.topgear;

import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class Assignment1 
{
    public static void main( String[] args )
    {
    	String s="";
    	Scanner in = new Scanner(System.in);
    	System.out.println("Enter the String Data With Spaces ");
    	s = in.nextLine();
    	in.close();
        System.out.println("Result Of the String Data Without Spaces:-\n"+StringUtils.deleteWhitespace(s));
    }
}
