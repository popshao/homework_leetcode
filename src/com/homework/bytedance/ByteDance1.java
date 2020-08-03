/**
 * Copyright (c) 111.com.cn 2019 All Rights Reserved.
 */
package com.homework.bytedance;

/**
 *                       
 * @Filename: Test1.java
 * @Version: 1.0
 * @Author: Zhang Lei
 * @Email: zhanglei03@111.com.cn
 *
 */
public class ByteDance1 {

    public static void main(String[] args) {
        ByteDance1 byteDance1 = new ByteDance1();
        String s = "helloo";
        byteDance1.method(s);
        System.out.println(s);
    }
    
    public void method(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i+1))
                continue;
            
            if (str.charAt(i + 1) == str.charAt(i + 2)) {
                this.remove(str, i + 2);
            } else if (str.charAt(i + 2) == str.charAt(i + 3)) {
                this.remove(str, i + 3);
            }
        }
    }
    
    private void remove(String str, int removeIndex) {
        String result = null;
        for (int i = 0; i < str.length(); i++) {
            if (i == removeIndex)
                continue;

            result += str.charAt(i);
        }
        
        str = result;
    }
}
