package com.homework;


public class Test263 {

	public static void main(String[] args) {
		System.out.println(isUgly(6));
	}

	public static boolean isUgly(int num) {
		while (num != -1 && num != 0 && num != 1) {
			num = cal(num);
		}

		if (num == 1) {
			return true;
		}
		return false;
	}
    
	private static int cal(int num) {
		if (num / 2 * 2 == num) {
			return num / 2;
		} else if (num / 3 * 3 == num) {
			return num / 3;
		} else if (num / 5 * 5 == num) {
			return num / 5;
		} else if (num / 2 == 1 || num / 3 == 1 || num / 5 == 1) {
			return 0;
		}
		return -1;
	}
}
