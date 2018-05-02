package com.homework;

public class Test10 {

	public static void main(String[] args) {
		// 1
		System.out.println("1-----------" + isMatch("aa", "a"));
		
		// 2
		System.out.println("2-----------" + isMatch("aaa", "aa*"));

		// 3
		System.out.println("3-----------" + isMatch("ab", ".*"));
		
		// 4
		System.out.println("4-----------" + isMatch("abc", "c*a*b*"));
		
		// 5
		System.out.println("5-----------" + isMatch("mississippi", "mis*is*p*."));
	}
	
    public static boolean isMatch(String s, String p) {
        
    	// 快速失败
    	if (isQuickFail(s, p)) {
    		return false;
    	}

    	Character lastP = null;
		for (int i = 0; i < s.length(); i++) {
			Character nowS = s.charAt(i);
			Character nowP = null;
			if (i <= p.length() - 1) {
				nowP = p.charAt(i);
			}

			if (nowP != null && '.' == nowP) {
				Character afterP = getNextChar(p, i);
				if (afterP != null && '*' == afterP) {
					return true;
				}
				
				continue;
			} else if (nowP != null && '*'== nowP) {
				if (!nowS.equals(lastP)) {
					return false;
				}
			} else if (!nowS.equals(nowP)) {
				Character afterP = getNextChar(p, i);
				if (afterP != null && '*' == afterP) {
					i++;
					lastP = null;
					continue;
				}
				return false;
			}
			
			if (nowP != null && '*' != nowP) {
				lastP = nowP;
			}
		}
    	
    	return true;
    }
    
    private static boolean isQuickFail(String s, String p) {
    	return p.contains(".") && s.length() != p.length() ? true : false;
    }
    
    private static Character getNextChar(String p, int index) {
    	Character result = null;
    	if (index <= p.length() - 1) {
    		result = p.charAt(index + 1);
    	}
    	
    	return result;
    }
}
