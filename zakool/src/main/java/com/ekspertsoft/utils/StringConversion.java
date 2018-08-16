package com.ekspertsoft.utils;

public class StringConversion {
	
	public static Double toDouble(final String value){
		try{
			return Double.parseDouble(value);
		}catch(NumberFormatException ex){
			return 0.0;
		}
	}
	
	public static int toInt(final String value){
		try{
			return Integer.parseInt(value);
		}catch(NumberFormatException ex){
			return 0;
		}
	}

}
