package com.ben.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;

import com.ben.service.Reader;

public class TxtReader implements Reader{

	 FileReader fr =null;
	 BufferedReader bufferedreader = null;
	@Override
	public void init(String filePath) throws  Exception {
		fr = new FileReader(filePath);  
        bufferedreader = new BufferedReader(fr);
	}

	@Override
	public String nextLine() throws  Exception  {
		 String instring=  bufferedreader.readLine();
		 if(instring!=null){
			 return instring.trim();
		 }
	        return null;
	}
	@Override
	public void release() throws Exception{
	    fr.close();
	}
	
}
