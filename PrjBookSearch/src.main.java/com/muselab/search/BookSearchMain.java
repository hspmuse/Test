package com.muselab.search;

import java.util.ArrayList;
import java.util.HashMap;

//import com.muselab.search.service.BookSearchService;
import com.muselab.search.service.BookSearchServiceImpl;

public class BookSearchMain {
	
	public static void main(String[] arg) {
		
		ArrayList<HashMap<String, String>> booklist = new ArrayList<HashMap<String, String>>();
		String srh = "ㅇㄴ";
		
		BookSearchServiceImpl bookSearchServiceImpl = new BookSearchServiceImpl();
		
		try {
			System.out.println("--------" );
			booklist = bookSearchServiceImpl.getSearchBookList(srh);
			
			for(int i=0; i<= booklist.size(); i++) {
				
				System.out.println("itemTitle="+ booklist.get(i).get("itemTitle"));
			}
			
			System.out.println("End");
			
		} catch ( Exception e) {
			
		}
		
	}
}
