package leetcode;

import java.util.Scanner;

/**
 * 
 * 返回干草堆中针的第一次出现的指数，如果针不是干草堆的一部分，返回-1*/
/*Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1*/
public class ImplementstrStr {
	public static void main(String[] args) {
		ImplementstrStr i=new ImplementstrStr();
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("请输入草堆：");
		String haystack=in.next();
		System.out.println("请输入针：");
		String needle=in.next();
		System.out.println(i.strStr(haystack, needle));
	}
	public int strStr(String haystack, String needle) {
		if(haystack.indexOf(needle)<0) {
			return -1;
		}
	    return haystack.indexOf(needle);
	 }
}
