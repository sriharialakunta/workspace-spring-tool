package com.example.demo;

public class ElecSlab {

	public  Double billAmount(int units) {
		
		if(units <60)
			return (double) (65);
		if(100>units&&units <60)
			return (double) (units*3);
		else  
			return (double) (units*5);

	}

	public boolean billAmountCheck(int i) {
		if(200>billAmount(i))
		return true;
		else 
			return true;
	}

}
