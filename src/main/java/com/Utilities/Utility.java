package com.Utilities;

import java.util.Date;

public class Utility {

	public static String genrateEmailwithTimestamp()
	{
		Date date=new Date();
		 String TimeStamp= date.toString().replace(" ","_").replace(":","_");	
		 return "anupat"+TimeStamp+"1993";
	}

}
