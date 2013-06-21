package com.muselab.search.service;

import java.util.ArrayList;
import java.util.HashMap;

public interface BookSearchService {
	public ArrayList<HashMap<String, String>> getSearchBookList(String srh_str) throws Exception ;
	
}
