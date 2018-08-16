package com.ekspertsoft.utils;

public enum Category {
	
	GRADUATE_AND_ABOVE("1"),
	BARCHELOR_AND_ABOVE("2"),
	BELOW_BARCHELOR("3"),
	ASSOCIATE_CERTIFICATE("4"),
	NON_DEGREE_ABOVE_BARCHELOR("5"),
	NON_DEGREE_SUB_BARCHELOR("6");

	private final String value;
	
	Category(final String value){
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
/*	"1","Degree-granting, graduate with no undergraduate degrees"
	"2","Degree-granting, primarily baccalaureate or above"
	"3","Degree-granting, not primarily baccalaureate or above"
	"4","Degree-granting, associate's and certificates 
	"5","Nondegree-granting, above the baccalaureate"
    "6","Nondegree-granting, sub-baccalaureate"
*/	
}
