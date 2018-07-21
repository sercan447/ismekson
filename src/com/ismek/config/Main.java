package com.ismek.config;

import java.util.Random;

public class Main {

	public static void main(String[] args) {

//st: 14:25
		
			
			System.out.println(Main.veri());


	}//Maýn func

	
	public static String veri()
	{
		Random ran = new Random();
		int x = 0;
		//int a = 1;  int b = 4;  int c = 5;  int d = 9;
		int a = ran.nextInt(5000);
		int b = ran.nextInt(5000);
		int c = ran.nextInt(5000);
		int d = ran.nextInt(5000);
		
	
		
		if(a <= b){
			a = a + b;
			if(a <= c) {
				a = a + c;//
				if(a <= d) {
					a = a + d;
					if(a <= d) {
						return "1.yes";
					}else {
						return "1.no";
					}
				}else if(a >= d) {
					x = b + c;
					if( a >= x) {
						x = c + d;
						if(a >= x) {
						return "2.no";
						}else if(a <= x){
							return "2.yes";
						}
					}else if(a <= d) {
						return "3.yes";
					}
				}
			}else if(a >= c){
				x = b + c;
				if(a >= x) {
					x = c + d;
					if(a >= x) {
						return "3.no";
					}else if(a <= d) {
						a = a + c;
						if(a <= d) {
						return "4.yes";
						}
					}
				}else if(a <= d) {
					a = a + d;
					if(a <= d) {
						return "5.yes";
					}else {
						return "4.no";
					}
						
					
				}
			}
		}else if(a >= b){
			x = b + c;//*
			if(a >= x) {
				x = c + d;
				if( a >= x) {
					return "5.no";
				}
			}else if(a <= c) {
				a = a + c;
				if(a <= d) {
                    a = a + d;
                    if(a <= d){
                    return "6.yes";
                    }else{
                        return "6.no";
                    }
				}else {
					return "7.no";
				}
			}	
        }
		
		return "a="+a+"-b="+b+"-c="+c+"-d="+d;
	}//
	
}
