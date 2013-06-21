package com.muselab.search.com;

import com.muselab.search.com.BookSearchConst;

public class BookSearchUtil {

    /**
     * 입력받은 문자가 초성인지 체크
     */
	public static boolean isInitialSound(char c){
        for(int i=0; i<BookSearchConst.INITIAL_SOUND.length; i++){ 
            if(BookSearchConst.INITIAL_SOUND[i] == c){ 
                return true; 
            } 
        } 
        return false; 
    } 
 
    /**
     * 입력받은 문자의 자음을 추출
     */
    public static char getInitialSound(char c){ 
        int hanBegin = (c - BookSearchConst.HANGUL_BEGIN_UNICODE); 
        int index = hanBegin / BookSearchConst.HANGUL_BASE_UNIT; 
        return BookSearchConst.INITIAL_SOUND[index]; 
    } 
     
    /**
     * 입력받은 문자가 한글인지 체크
     */
    public static boolean isHangul(char c){ 
        return BookSearchConst.HANGUL_BEGIN_UNICODE <= c && c <= BookSearchConst.HANGUL_LAST_UNICODE; 
    }
     
    /**
    * 숫자, 영문(대소문자), 한글, 초성 등의 유니코드를 체크
    */
    public static boolean checkUnicode(char c){
        if ((   (c >= BookSearchConst.NUMBER_BEGIN_UNICODE && c <= BookSearchConst.NUMBER_LAST_UNICODE) 
             || (c >= BookSearchConst.ENGLISH_UPPER_BEGIN_UNICODE && c <= BookSearchConst.ENGLISH_UPPER_LAST_UNICODE) 
             || (c >= BookSearchConst.ENGLISH_ROWER_BEGIN_UNICODE && c <= BookSearchConst.ENGLISH_ROWER_LAST_UNICODE) 
             || (c >= BookSearchConst.HANGUL_BEGIN_UNICODE && c <= BookSearchConst.HANGUL_LAST_UNICODE) 
             || (c >= BookSearchConst.INITIAL_SOUND_BEGIN_UNICODE && c <= BookSearchConst.INITIAL_SOUND_LAST_UNICODE))
           ){
            return true;
        }else{
            return false;
        }
    }
    
    /**
    * 검색어와 검색 대상 값을 입력받아서 일치여부 확인
    */
    public static boolean matchString(String keyword, String value){ 
        int t = 0; 
        int seof = value.length() - keyword.length(); 
        int slen = keyword.length();
        // 검색어가 검색대상값보다 더 길거나, 검색어가 두개 이하일때 false 리턴 
        if(seof < 0 || keyword.length() < 2){
            return false;
        }
         
        for(int i = 0;i <= seof;i++){ 
            t = 0; 
            while(t < slen){ 
                // 숫자, 초성, 한글, 영문(대소문자)를 제외한 다른 값은 false 리턴 
                if(!checkUnicode(keyword.charAt(t))){
                    return false;
                }
                 
                // 검색어가 초성이이고 한글이면 초성끼리 비교
                if(isInitialSound(keyword.charAt(t)) && isHangul(value.charAt(i+t))){ 
                    // 각각의 초성이 같은지 비교 
                    if(getInitialSound(value.charAt(i+t)) == keyword.charAt(t)){ 
                        t++; 
                    }else{ 
                        break;
                    }
                } else { 
                    // 초성이 아닐경우 비교 
                    if(value.charAt(i+t) == keyword.charAt(t)){
                        t++; 
                    }else{ 
                        break;
                    }
                } 
            } 
            // 검색어의 길이만큼 모두 일치하면 true를 리턴 
            if(t == slen){
                return true;
            }
        } 
        return false; // 일치하지 않으면 false를 리턴
    }
}
