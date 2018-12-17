package leetcode;
/*
 * Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4*/

/**
 * /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class TwoSortList {
	/*
	 * 在Java中，类中的静态方法不能直接调用动态方法。只有将某个内部类修饰为静态类，然后才能够在静态类中调用该类的成员变量与成员方法
	 * public  class ListNode则会报错，改成public static class ListNode就可以了
	 * */
	public static class ListNode {
		     int val;
		     ListNode next;
		     ListNode(int x) { val = x; }//初始化这个节点，next又接一个节点，从而构成链表
		  }
	public static void main(String[] args) {
		
	}
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        ListNode ln=new ListNode(0);
	        while(l1!=null) {
	        	ln.next=l1.next;
	        	l1=l1.next;
	        	ln=ln.next;
	        }
	        while(l2!=null) {
	        	ln.next=l2.next;
	        	l1=l2.next;
	        }
	        int x=0;
	        while(x<=6) {
	        	System.out.println(ln.val);
	        	ln=ln.next;
	        	x++;
	        }
				
	        return ln;
	}
}
