package com.company;

public class Utility {
    public static boolean compareStrings(String str1, String str2){
        if(str1.equals(str2)) {
            return true;
        }
        else{
            str1 = str1.toLowerCase();
            str2 = str2.toLowerCase();
            str1 = str1.strip();
            str2 = str2.strip();
            if(str1.equals(str2)) {
                return true;
            }
            int l1 = str1.length();
            int l2 = str2.length();
            if(l1 > l2 + 3 || l2 > l1 + 3){
                return false;
            }

            StringBuilder strb1 = new StringBuilder(str1);
            StringBuilder strb2 = new StringBuilder(str2);

            int err = 0;
            int lmin;
            if(l1!=l2){
                lmin = Math.min(l1, l2);
                for(int i = 0; i < lmin && err <= 3; i++){
                    if(strb1.charAt(i) != strb2.charAt(i)) {
                        err += 1;
                        if(i + 1 < strb1.length() && strb1.charAt(i+1) == strb2.charAt(i)){
                            strb1.deleteCharAt(i);
                        }
                        else if(i + 1 < strb2.length() && strb1.charAt(i) == strb2.charAt(i+1)){
                            strb2.deleteCharAt(i);
                        }
                    }
                }
            }
            if(l1 == l2){
                for(int i = 0; i < l1 && err <= 3; i++){
                    if(strb1.charAt(i) != strb2.charAt(i)) {
                        err += 1;
                    }
                }
            }
            return err <= 3;

        }
    }
}
