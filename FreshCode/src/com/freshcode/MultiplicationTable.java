package com.freshcode;

public class MultiplicationTable {
	
	public void table(int table, int start,int end) {
		
		for(int i=start; i<=end; i++) {
			
			System.out.printf("%d * %d = %d",table,i,table*i).println();
			
//			System.out.println(table+" * "+i+" = "+table*i);
			
		}
		
	}
}
