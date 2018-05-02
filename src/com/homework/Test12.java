package com.homework;

public class Test12 {

	public static void main(String[] args) {
		System.out.println(intToRoman2(1994));
	}
	
	public static String intToRoman(int num) {
		StringBuilder result = new StringBuilder();
		int a = num / 1000;
		num = num - a * 1000;
		while (a > 0) {
			result.append("M");
			a--;
		}

		a = num / 100;
		num = num - a * 100;
		cal(result, a, "C", "D", "M");

		a = num / 10;
		num = num - a * 10;
		cal(result, a, "X", "L", "C");
		cal(result, num, "I", "V", "IX");
		
		return result.toString();
	}
	
	private static String intToRoman2(int num) {
		String[] symbol = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		int[] value = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		StringBuilder result = new StringBuilder();

		for (int i = 0; num != 0; i++) {
			while (num >= value[i]) {
				num -= value[i];
				result.append(symbol[i]);
			}
		}

		return result.toString();
	}
	
	private static void cal(StringBuilder result, int num, String typeA, String typeB, String typeC) {
		if (num == 9) {
			result.append(typeA);
			result.append(typeC);
		} else if (num < 9 && num > 5) {
			result.append(typeB);
			num = num - 5;
			while (num > 0) {
				result.append(typeA);
				num--;
			}
		} else if (num == 5) {
			result.append(typeB);
		} else if (num == 4) {
			result.append(typeA);
			result.append(typeB);
		} else if (num > 0 && num < 4) {
			while (num > 0) {
				result.append(typeA);
				num--;
			}
		}
	}
}
