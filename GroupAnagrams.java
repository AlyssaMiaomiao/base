package leetcode;

import java.util.LinkedList;
import java.util.List;

/*
 * 给定一个字符串数组，将字谜组合在一起。
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]*/
public class GroupAnagrams {
	public static void main(String[] args) {
		String[] strs= {"paw","dadhh","bogg","day","day","mig","len","rat"};
		GroupAnagrams ga=new GroupAnagrams();
		ga.groupAnagrams(strs);
	}
	public List<List<String>> groupAnagrams(String[] strs) {
		
		List<List<String>> res = new LinkedList<>();
		List<String> list=new LinkedList<>();
		int length=0,l=0,b=0;
		while(length<strs.length) {
			for(int a=0;a<strs.length;a++) {
				if(strs[a]!="*"&&l<1) {
					list.add(strs[a]);
					b=a;
					l++;
				}
			}
			length++;
			for(int i=b+1;i<strs.length;i++) {
				String s=strs[i];
				int j=0;
				for(j=0;j<list.get(0).length();) {
					//判断语句有问题，要改正
					if(s.indexOf(list.get(0).charAt(j))>=0&&list.get(0).indexOf(s.charAt(j))>=0) {
						j++;
					}else {
						break;
					}
				}
				if(j==s.length()&&j==list.get(0).length()) {
					list.add(s);
					strs[i]="*";
					length++;
				}
			}
			res.add(list);
			strs[b]="*";
			list=new LinkedList<>();
			l=0;
		}
		for(int c=0;c<res.size();c++) {
			System.out.println(res.get(c));
		}
        return res;
    }
}
