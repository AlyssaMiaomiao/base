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
	 * ��Java�У����еľ�̬��������ֱ�ӵ��ö�̬������ֻ�н�ĳ���ڲ�������Ϊ��̬�࣬Ȼ����ܹ��ھ�̬���е��ø���ĳ�Ա�������Ա����
	 * public  class ListNode��ᱨ���ĳ�public static class ListNode�Ϳ�����
	 * */
	public static class ListNode {
		     int val;
		     ListNode next;
		     ListNode(int x) { val = x; }//��ʼ������ڵ㣬next�ֽ�һ���ڵ㣬�Ӷ���������
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
