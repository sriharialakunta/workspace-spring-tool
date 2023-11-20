package com.freshcode;

public class Book {
	
	void read(String bookname) {
		
		System.out.println(bookname+" Started Reading");
		stop(bookname);
	}

	void stop(String bookname) {
		System.out.println(bookname+" Reading Stopped");
	}
}
