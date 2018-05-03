package com.homework;

public class Test13 {

	public static void main(String[] args) {
		System.out.println(romanToInt("III"));;
	}
	
	private static int romanCharToInt(char ch) {
		int d = 0;
		switch (ch) {
		case 'I':
			d = 1;
			break;
		case 'V':
			d = 5;
			break;
		case 'X':
			d = 10;
			break;
		case 'L':
			d = 50;
			break;
		case 'C':
			d = 100;
			break;
		case 'D':
			d = 500;
			break;
		case 'M':
			d = 1000;
			break;
		}
		return d;
	}

	private static int romanToInt(String s) {
		if (s.length() <= 0)
			return 0;
		int result = romanCharToInt(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			int prev = romanCharToInt(s.charAt(i - 1));
			int curr = romanCharToInt(s.charAt(i));
			// if left<right such as : IV(4), XL(40), IX(9) ...
			if (prev < curr) {
				result = result - prev + (curr - prev);
			} else {
				result += curr;
			}
		}
		return result;
	}
}
