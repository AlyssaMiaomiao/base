package leetcode;

import java.util.Scanner;

/*
 * ����һ��ֻ�����ַ���(������)������{������}������[���͡�]�����ַ�����ȷ�������ַ����Ƿ���Ч��
���:�����ַ�����Ч:
�����ű�������ͬ���͵�������������
�����ű��밴��ȷ��˳��رա�*/
public class ValidParentheses {
	public static void main(String[] args) {
		ValidParentheses vp=new ValidParentheses();
		System.out.println("�������ַ���:");
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		String s=in.next();
		System.out.println(vp.isValid(s));
	}
	 public boolean isValid(String s) {
		 //���s�ĳ�������������һ������ȷ
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
