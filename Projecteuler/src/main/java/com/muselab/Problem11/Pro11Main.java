package com.muselab.Problem11;

import com.muselab.Problem11.com.GridConst;

public class Pro11Main {
	public static void main(String[] args) {
		
		int maxRL = 0;
		int maxUD = 0;
		int maxDiR = 0;
		int maxDiL = 0;
		
		maxRL = getMaxRightLeft();
		maxUD = getUpDown();
		maxDiR = getDiagonalR();
		maxDiL = getDiagonalL();
		System.out.println("maxRL =" + maxRL);
		System.out.println("maxUD =" + maxUD);
		System.out.println("maxDiR=" + maxDiR);
		System.out.println("maxDiL=" + maxDiL);
	}
	
	public static int getMaxRightLeft()  {
		
		int maxValue = 0;
		int value1 = 1;
		int value2 = 1;
		
		for(int i=0; i<GridConst.GRID_LEN; i++) {
			
			for(int j=0;j<GridConst.GRID_LEN-GridConst.NUM_LEN-1; j++){
				
				value1 = GridConst.GRID_ARRAY[i][j]*GridConst.GRID_ARRAY[i][j+1]*GridConst.GRID_ARRAY[i][j+2]*GridConst.GRID_ARRAY[i][j+3]; 
				value2 = GridConst.GRID_ARRAY[i][j+1]*GridConst.GRID_ARRAY[i][j+2]*GridConst.GRID_ARRAY[i][j+3]*GridConst.GRID_ARRAY[i][j+4];
				
				if(!(maxValue>=value1  && maxValue>=value1)) {
					if(value1>=value2) {
						maxValue = value1;
						//System.out.println("RLi=" + i);
						//System.out.println("RLj=" + j);
					} else {
						maxValue = value2;
						//System.out.println("RLi=" + i);
						//System.out.println("RLj=" + j);
					}
				}
//				System.out.println("value1=" + value1);
//				System.out.println("value2=" + value2);
//				System.out.println("maxValue=" + maxValue);
			}			
		}
		return maxValue;
	}
	
	public static int getUpDown()  {
		int maxValue = 0;
		int value1 = 1;
		int value2 = 1;
		
		for(int i=0; i<GridConst.GRID_LEN-GridConst.NUM_LEN-1; i++) {
			
			for(int j=0;j<GridConst.NUM_LEN; j++){
				
				System.out.println("i=" + i);
				System.out.println("j=" + j);
				
				value1 = GridConst.GRID_ARRAY[j][i]*GridConst.GRID_ARRAY[j+1][i]*GridConst.GRID_ARRAY[j+2][i]*GridConst.GRID_ARRAY[j+3][i]; 
				value2 = GridConst.GRID_ARRAY[j+1][i]*GridConst.GRID_ARRAY[j+2][i]*GridConst.GRID_ARRAY[j+3][i]*GridConst.GRID_ARRAY[j+4][i];
				
				if(!(maxValue>=value1  && maxValue>=value1)) {
					if(value1>=value2) {
						maxValue = value1;
						//System.out.println("i=" + i);
						//System.out.println("j=" + j);
					} else {
						maxValue = value2;
						//System.out.println("i=" + i);
						//System.out.println("j=" + j);
					}
				}

//				System.out.println("value1=" + value1);
//				System.out.println("value2=" + value2);
//				System.out.println("maxValue=" + maxValue);
			}			
		}
		return maxValue;
	}
	
	public static int getDiagonalR()  {
		int maxValue = 0;
		int value1 = 1;
		int value2 = 1;
		
		for(int i=0; i<GridConst.GRID_LEN-GridConst.NUM_LEN-1; i++) {
			
			for(int j=0;j<GridConst.GRID_LEN-GridConst.NUM_LEN-1; j++){
				
				value1 = GridConst.GRID_ARRAY[i][j]*GridConst.GRID_ARRAY[i+1][j+1]*GridConst.GRID_ARRAY[i+2][j+2]*GridConst.GRID_ARRAY[i+3][j+3]; 
				value2 = GridConst.GRID_ARRAY[i][j+1]*GridConst.GRID_ARRAY[i+1][j+2]*GridConst.GRID_ARRAY[i+2][j+3]*GridConst.GRID_ARRAY[i+3][j+4];
				
				if(!(maxValue>=value1  && maxValue>=value1)) {
					if(value1>=value2) {
						maxValue = value1;
						//System.out.println("RLi=" + i);
						//System.out.println("RLj=" + j);
					} else {
						maxValue = value2;
						//System.out.println("RLi=" + i);
						//System.out.println("RLj=" + j);
					}
				}
//				System.out.println("value1=" + value1);
//				System.out.println("value2=" + value2);
//				System.out.println("maxValue=" + maxValue);
			}			
		}
		return maxValue;
	}
	
	public static int getDiagonalL()  {
		int maxValue = 0;
		int value1 = 1;
		int value2 = 1;
		
		for(int i=0; i<GridConst.GRID_LEN-GridConst.NUM_LEN-1; i++) {
			
			for(int j=GridConst.GRID_LEN-1;j>GridConst.NUM_LEN-1; j--){
				
				value1 = GridConst.GRID_ARRAY[i][j]*GridConst.GRID_ARRAY[i+1][j-1]*GridConst.GRID_ARRAY[i+2][j-2]*GridConst.GRID_ARRAY[i+3][j-3]; 
				value2 = GridConst.GRID_ARRAY[i][j-1]*GridConst.GRID_ARRAY[i+1][j-2]*GridConst.GRID_ARRAY[i+2][j-3]*GridConst.GRID_ARRAY[i+3][j-4];
				
				if(!(maxValue>=value1  && maxValue>=value1)) {
					if(value1>=value2) {
						maxValue = value1;
						//System.out.println("RLi=" + i);
						//System.out.println("RLj=" + j);
					} else {
						maxValue = value2;
						//System.out.println("RLi=" + i);
						//System.out.println("RLj=" + j);
					}
				}
//				System.out.println("value1=" + value1);
//				System.out.println("value2=" + value2);
//				System.out.println("maxValue=" + maxValue);
			}			
		}
		return maxValue;
	}
}
