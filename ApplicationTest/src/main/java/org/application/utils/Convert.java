package org.application.utils;

import java.text.DecimalFormat;

public class Convert {

	private static final String[] tensNames = {"", " ten", " twenty", " thirty", " forty",
			    " fifty", " sixty", " seventy", " eighty", " ninety" };

	private static final String[] numNames = { "", " one", " two", " three", " four", " five",
			    " six", " seven"," eight", " nine", " ten", " eleven", " twelve", " thirteen",
			    " fourteen", " fifteen", " sixteen", " seventeen", " eighteen", " nineteen"};


  	private static String convertLessThanOneThousand(int number) {
	    String soFar;
	
	    if (number % 100 < 20){
	      soFar = numNames[number % 100];
	      number /= 100;
	    }
	    else {
	      soFar = numNames[number % 10];
	      number /= 10;
	
	      soFar = tensNames[number % 10] + soFar;
	      number /= 10;
	    }
	    if (number == 0) return soFar;
	    return numNames[number] + " hundred" + soFar;
	  }
	
	
	  public static String convert(int number) {
	    // 0 to 999 999
	    if (number == 0) { return "zero"; }
	
	    String snumber = Long.toString(number);
	
	    // pad with "0"
	    String mask = "000000";
	    DecimalFormat df = new DecimalFormat(mask);
	    snumber = df.format(number);
	
	    // XXXnnn
	    int hundredThousands = Integer.parseInt(snumber.substring(0,3));
	    // nnnXXX
	    int thousands = Integer.parseInt(snumber.substring(3,6));
	
	    String tradHundredThousands;
	    switch (hundredThousands) {
	    case 0:
	      tradHundredThousands = "";
	      break;
	    case 1 :
	      tradHundredThousands = "one thousand ";
	      break;
	    default :
	      tradHundredThousands = convertLessThanOneThousand(hundredThousands)
	         + " thousand ";
	    }
	    String result = tradHundredThousands;
	
	    String tradThousand;
	    tradThousand = convertLessThanOneThousand(thousands);
	    result =  result + tradThousand;
	    return result;
	  }
			  
	public static String numberToWords(int value) {		
		return convert(value);
	}
}
