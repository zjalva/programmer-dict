package com.ben.service;

public interface Reader {
	void init(String filePath) throws  Exception ;
	String nextLine() throws  Exception ;
	
	public void release() throws Exception;
}
