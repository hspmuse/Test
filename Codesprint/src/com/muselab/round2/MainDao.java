package com.muselab.round2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class MainDao {

	//DB정보
	private static String db_url = "jdbc:oracle:thin:@localhost:1652:TEST";
	private static String db_id = "test";
	private static String db_pw = "test";	
	
	//주말(토,일)을 제외한 휴일
	private static String[] holiday = {"20130517","20130606"};
	
	public ArrayList<HashMap<String, String>> get(String gubun) throws ClassNotFoundException, SQLException {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		ArrayList<HashMap<String, String>> road = new ArrayList<HashMap<String, String>>();
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection c = DriverManager.getConnection(db_url,db_id,db_pw);
		
		sql= getSql(gubun);
		ps = c.prepareStatement(sql.toString());
		
		System.out.println(holiday[0].toString());
		System.out.println(holiday[1].toString());
		System.out.println(sql.toString());
		
		if(gubun.equals("1")){
			ps.setString(1, holiday[0].toString());
			ps.setString(2, holiday[1].toString());
		}
		
		rs = ps.executeQuery();
		try  {
			road = getResultMapRows(rs);
		} catch(Exception e) {
			
		}
		rs.close();
		ps.close();
		c.close();

		return road;
		
	}

	
	/**
     * ResultSet을 Row마다 Map에 저장후 List에 다시 저장.
     * @param rs DB에서 가져온 ResultSet
     * @return Listt<map> 형태로 리턴
     * @throws Exception Collection
     */
    public ArrayList<HashMap<String, String>> getResultMapRows(ResultSet rs) throws Exception
    {
        // ResultSet 의 MetaData를 가져온다.
        ResultSetMetaData metaData = rs.getMetaData();
        // ResultSet 의 Column의 갯수를 가져온다.
        int sizeOfColumn = metaData.getColumnCount();
 
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        String column;
        // rs의 내용을 돌려준다.
        while (rs.next())
        {
            // 내부에서 map을 초기화
        	HashMap<String,String> map = new HashMap<String,String>();
            // Column의 갯수만큼 회전
            for (int indexOfcolumn = 0; indexOfcolumn < sizeOfColumn; indexOfcolumn++)
            {
                column = metaData.getColumnName(indexOfcolumn + 1);
                // map에 값을 입력 map.put(columnName, columnName으로 getString)
                map.put(column, rs.getString(column));
            }
            // list에 저장
            list.add(map);
        }
        return list;
    }
	
	public StringBuffer getSql(String gubun) {
		
		StringBuffer sql = new StringBuffer();
		
		/*
		 * gubun=1
		 * 휴일을 제외한 4~6월 화요일 교통속도의 평균
		 */
		if(gubun.equals("1")) {
			sql.append("select  '20130716' cre_dd                                                          \n");
			sql.append("        , CRE_HM, UPDOWN_CD, SCTN_IDX, SCTN_STD_NM, SCTN_END_NM, SCTN_DTN          \n");
			sql.append("        , avg_spd SCTN_SPD                                                         \n");
			sql.append("from    (                                                                          \n");
			sql.append("        select  CRE_HM, UPDOWN_CD, SCTN_IDX, SCTN_STD_NM, SCTN_END_NM, SCTN_DTN    \n");
			sql.append("                , round(avg(SCTN_SPD),2) avg_spd                                   \n");
			sql.append("        from    tbtest01 a                                                         \n");
			sql.append("        where   (  a.cre_dd like '201304%'                                         \n");
			sql.append("                or a.cre_dd like '201305%'                                         \n");
			sql.append("                or a.cre_dd like '201306%' )                                       \n");
			sql.append("        and     to_char(to_date(a.cre_dd),'D') = '3'    --화요일                  			   \n ");
			sql.append("        and     a.cre_dd not in (?,?) --휴일                    								   \n");
			sql.append("        group by CRE_HM, UPDOWN_CD, SCTN_IDX, SCTN_STD_NM, SCTN_END_NM, SCTN_DTN   \n");
			sql.append("        )                                                                          \n");
			sql.append("order by UPDOWN_CD, SCTN_IDX, CRE_HM                                               \n");
		}
		return sql;
	}
}
