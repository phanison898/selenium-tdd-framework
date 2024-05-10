package com.base;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		String s = "Phani";
		char[] arr = s.toCharArray();
		StringBuilder output = new StringBuilder();
		String a = "";
		for(int i=arr.length-1; i>=0; i--) {
			output.append(arr[i]);
			a += arr[i];
		}
		System.out.println(output.toString());
		System.out.println(a);

//		String s = "Selenium is used used for for automation testing testing Selenium";
//
//		String a = "SeleniumIsAVeryGoodTool";
//
//		// output = Selenium is a very good tool
//
//		// logic
//		/**
//		 * convert to charArray
//		 */
//
//		char[] arr = a.toCharArray();
//
//		StringBuilder holder = new StringBuilder();
//
//		for (int i = 0; i < arr.length; i++) {
//
//			char c = arr[i];
//
//			if ((int) c >= 65 && (int) c <= 90) {
//
//				if (i != 0) {
//					holder.append(" ");
//					c = (char) (((int) c) + 32);
//				}
//				holder.append(c);
//
//			} else {
//				if (i == 0 && (int) c >= 97) {
//					c = (char) (((int) c) - 32);
//					holder.append(c);
//				} else {
//					holder.append(c);
//				}
//			}
//		}
//
//		System.out.println(holder.toString());

		// login

		/**
		 * split the string selenium(i=0) -- compare with rest of the elements (j = i+1
		 * to j<arr.length) if selenium matches with any other word -- I will increase
		 * count
		 * 
		 * if same word exists more than once? like selenium at 0 index and selenium at
		 * 4th index once if words matched remove the current word
		 */

//		List<String> list = new LinkedList<String>(Arrays.asList(s.split(" ")));
//
//		StringBuilder output = new StringBuilder();
//		for (int i = 0; i < list.size(); i++) {
//
//			StringBuilder word = new StringBuilder();
//			word.append(list.get(i));
//			word.append("=");
//
//			int count = 1;
//			for (int j = i + 1; j < list.size(); j++) {
//				if (list.get(i).equals(list.get(j))) {
//					list.remove(j);
//					count++;
//				}
//			}
//
//			word.append(count);
//
//			output.append(word);
//			if (i < list.size() - 1) {
//				output.append(",");
//			}
//
//		}
//
//		System.out.println(output.toString());

	}
}
