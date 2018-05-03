package com.homework;

public class Test14 {

	public static void main(String[] args) {
		Test14 test = new Test14();
		
		System.out.println(test.longestCommonPrefix(new String[] {"aca","cba"}));;
	}

    public String longestCommonPrefix(String[] strs) {
    	StringBuilder result = new StringBuilder();
    	if (strs.length == 0) {
    		return "";
    	}
        String firstStr = strs[0];
        
        if (strs.length == 1) {
        	return firstStr;
        }
        
        for (int i = 0; i < firstStr.length(); i++) {
        	Character targetChar = firstStr.charAt(i);
        	for (int j = 1; j < strs.length; j++) {
        		String tempStr = strs[j];
				if (tempStr.length() - 1 < i || !targetChar.equals(tempStr.charAt(i))) {
					return result.toString();
				}
				
				if (j == strs.length - 1) {
					result.append(targetChar);
				}
        	}
        }
    	
    	return result.toString();
    }
}
