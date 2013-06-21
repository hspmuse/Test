package com.muselab.search.com;

public final class BookSearchConst {

	public static final char INITIAL_SOUND_BEGIN_UNICODE = 12593; // 초성 유니코드 시작 값
	public static final char INITIAL_SOUND_LAST_UNICODE = 12622;  // 초성 유니코드 마지막 값
	public static final char HANGUL_BEGIN_UNICODE = 44032;        // 한글 유니코드 시작 값
	public static final char HANGUL_LAST_UNICODE = 55203;         // 한글 유니코드 마지막 값
	public static final char NUMBER_BEGIN_UNICODE = 48;           // 숫자 유니코드 시작 값
	public static final char NUMBER_LAST_UNICODE = 57;            // 숫자 유니코드 마지막 값
	public static final char ENGLISH_ROWER_BEGIN_UNICODE = 65;    // 영문(소문자) 유니코드 시작 값 
	public static final char ENGLISH_ROWER_LAST_UNICODE = 90;     // 영문(소문자) 유니코드 마지막 값
	public static final char ENGLISH_UPPER_BEGIN_UNICODE = 97;    // 영문(대문자) 유니코드 시작 값
	public static final char ENGLISH_UPPER_LAST_UNICODE = 122;    // 영문(대문자) 유니코드 마지막 값
	public static final char HANGUL_BASE_UNIT = 588;              // 자음 마다 가지는 글자수
                                                                   // 초성
    public static final char[] INITIAL_SOUND = 
        {'ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ'
       , 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'};
 
    // 초성 검색에 대한 상품 리스트 
    public static final String[][] ITEM_ARRAY = new String[][]{
      //  상품번호 , 도서명 , 도서가격 , 판매건수
         {"100", "샐러드를 좋아하는 사자, 사슴", "11700", "5"}
       , {"101", "아날로그 사랑법", "12600", "32"}
       , {"102", "엄마가 있어줄게", "12420", "72"}
       , {"103", "하고 싶다, 연애", "12600", "12"}
       , {"104", "버스 타고 제주여행 제주 구석구석 즐기는 법", "12600", "5"}
       , {"105", "대한민국 사진여행지 100", "15120", "21"}
       , {"106", "베스트 오브 유럽  230", "11900", "22"}
       , {"107", "지면서 이기는 관계술", "13500", "6"}
       , {"108", "공부와 열정", "11700", "9"}
       , {"109", "소셜 웹 마이닝", "21600", "121"}
       , {"110", "학문의 즐거움", "7120", "851"}
       };
}

