package com.muselab.search.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.muselab.search.service.BookSearchService;
import com.muselab.search.com.BookSearchConst;
import com.muselab.search.com.BookSearchUtil;

public class BookSearchServiceImpl implements BookSearchService {

	public ArrayList<HashMap<String, String>> getSearchBookList(String srh_str) {
		
		System.out.println("---BookSearchServiceImpl----" );
		//List<BookListResultVO> bookListVO = new ArrayList<BookListResultVO>();
		//BookListResultVO bookListVO[] = new BookListResultVO[BookSearchConst.ITEM_ARRAY.length];
		
		ArrayList<HashMap<String, String>> booklist = new ArrayList<HashMap<String, String>>();
		try {
			
	        String[] itemTitle = new String[20]; // 상품명을 담을 변수
	        int[] machool = new int[20];         // 매출금액을 담을 변수
	        int x = 0;
	         
	        // 총 상품의 건수만큼 for 문을 수행 
	        for(int i=0; i<BookSearchConst.ITEM_ARRAY.length; i++){
	            // 키워드와 매칭되는 상품이 존재하면, 상품명과 매출액을 배열에 각각 저장 
	            if(BookSearchUtil.matchString(srh_str, BookSearchConst.ITEM_ARRAY[i][1])){
	                itemTitle[i] = BookSearchConst.ITEM_ARRAY[i][1];
	                machool[i] = Integer.parseInt(BookSearchConst.ITEM_ARRAY[i][2])*Integer.parseInt(BookSearchConst.ITEM_ARRAY[i][3]);
	            }
	        }
	         
	        // 매출액이 큰 순서부터 내림차순 정렬 
	        for (int i = 0; i < machool.length; i++){
	            boolean changed = false;
	 
	            for (int j = i + 1; j < machool.length; j++){
	                if (machool[j] > machool[i]){
	                    // 매출액의 순서를 정렬 
	                    int tempMachool = machool[j];
	                    machool[j] = machool[i];
	                    machool[i] = tempMachool;
	                    // 상품명의 순서를 정렬
	                    String tempItemTitle = itemTitle[j];
	                    itemTitle[j] = itemTitle[i];
	                    itemTitle[i] = tempItemTitle;
	                    changed = true;
	                }
	            } // 정렬 for문 종료
	            if (!changed){ // 더이상 순서 변경이 없으면 for문을 빠져 나옴
	                break;
	            }
	            System.out.println("도서명 :"+itemTitle[i]+", 매출액 :"+machool[i]);
	            
	            HashMap<String,String> map = new HashMap<String,String>();
	    		map.put("itemTitle", itemTitle[i]);
	    		booklist.add(map);
	            
	            //bookListVO[x++].setBook_nm(itemTitle[i]);
	            
	        } // 전체 for문 종료
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//return bookListVO.toArray(new BookListResultVO[bookListVO.size()]);
		return booklist;
		
	}
}
