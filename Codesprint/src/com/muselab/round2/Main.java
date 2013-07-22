package com.muselab.round2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		MainDao dao = new MainDao();
		ArrayList<HashMap<String, String>> road = new ArrayList<HashMap<String, String>>();
		
		road = dao.get("1");
		
		System.out.println("count=" + road.size());
			
		try {
			
			BufferedWriter out = new BufferedWriter(new FileWriter("20130716_out.csv"));
		    String s = "";

		    for(int i=0; i<road.size(); i++) {
		    	s=road.get(i).get("CRE_DD")+","+road.get(i).get("CRE_HM")+","
		    			+road.get(i).get("UPDOWN_CD")+","+road.get(i).get("SCTN_IDX")+","
		    			+road.get(i).get("SCTN_STD_NM")+","+road.get(i).get("SCTN_END_NM")+","
		    			+road.get(i).get("SCTN_DTN")+","+road.get(i).get("SCTN_SPD");
		    	out.write(s); out.newLine();
		    }
		    out.close();
		    
		    
		    
	    } catch (IOException e) {
	        System.err.println(e); // 에러가 있다면 메시지 출력
	        System.exit(1);
	    }
		
		System.out.println("프로그램 종료");
		
	}
	
}
