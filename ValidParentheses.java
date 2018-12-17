package leetcode;

import java.util.Scanner;

/*
 * 给定一个只包含字符“(”、“)”、“{”、“}”、“[”和“]”的字符串，确定输入字符串是否有效。
如果:输入字符串有效:
开括号必须用相同类型的括号括起来。
开括号必须按正确的顺序关闭。*/
public class ValidParentheses {
	public static void main(String[] args) {
		ValidParentheses vp=new ValidParentheses();
		System.out.println("请输入字符串:");
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		String s=in.next();
		System.out.println(vp.isValid(s));
	}
	 public boolean isValid(String s) {
		 //如果s的长度是奇数，则一定不正确
		 Boolean a=true;
		 if(s.length()%2!=0) {
			 System.out.println(s.length());
			 return false;
		 }
		for(int i=0;i<s.length()/2;i++) {
				int j=s.length()-i-1;
				a=com(s.charAt(i),s.charAt(j));
		}
		 return a; 
	}
	 public boolean com(char a,char b) {
		 Boolean c=false;
		 if(a!='('||a!='{'||a!='[') {
			 c=false;
		 }
		 else {
			 if((a=='('&&b==')')||(a=='{'&&b=='}')||(a=='['&&b==']'))
					c=true;
		 }
		return c;
	}
}
