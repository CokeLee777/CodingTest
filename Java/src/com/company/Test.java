package com.company;

import java.util.*;

class Test {

    public static List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        result.add(s);
        if(s.toLowerCase().equals(s) && s.toUpperCase().equals(s)) return result;
        char[] arr = s.toCharArray();
        backTracking(result, "", arr, 0);
        return result;
    }

    public static void backTracking(List<String> result, String temp, char[] arr, int start){
        if(!result.contains(temp) && temp.length() == arr.length){
            result.add(temp);
            return;
        }
        for(int i = start; i < arr.length; i++){
            if(arr[i] - '0' < 10) temp += arr[i];
            else if(Character.toLowerCase(arr[i]) == arr[i]) {
                temp += Character.toUpperCase(arr[i]);
                arr[i] = Character.toUpperCase(arr[i]);
            }
            else if(Character.toUpperCase(arr[i]) == arr[i]) {
                temp += Character.toLowerCase(arr[i]);
                arr[i] = Character.toLowerCase(arr[i]);
            }
            backTracking(result, temp, arr, i+1);
        }
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3};

        letterCasePermutation("a1b2");

    }
}
