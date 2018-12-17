package leetcode;
/*
 * 确定9x9的数独板是否有效。只有填充的单元格需要根据以下规则进行验证:
每行必须包含数字1-9，不重复。
每一列必须包含数字1-9而不重复。
网格的每个9 3x3子框必须包含数字1-9，而不重复。
Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true*/
public class ValidSudoku {
	public static void main(String[] args) {
		String[][] board={
				{"5","3",".",".","7",".",".",".","."},
				{"6",".",".","1","9","5",".",".","."},
				{".","9","8",".",".",".",".","6","."},
				{"8",".",".",".","6",".",".",".","3"},
				{"4",".",".","8",".","3",".",".","1"},
				{"7",".",".",".","2",".",".",".","6"},
				{".","6",".",".",".",".","2","8","."},
				{".",".",".","4","1","9",".",".","5"},
				{".",".",".",".","8",".",".","7","9"}
		};
		ValidSudoku v=new ValidSudoku();
		System.out.println(v.isValidSudoku(board));
	}
	
	
	public boolean isValidSudoku(String[][] board) {
		String str1="",str="",str3="";
		boolean a=false,b=false,c=false;
		//用来判断每一行
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(board[i][j]!=".") {
					str1+=board[i][j];
				}
			}
			//System.out.println(str1);
			a=judge(str1);
			//System.out.print(a+"\t");
			str1="";
			if(a==false) {
				break;
			}
		}
		//用来判断每一列
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(board[j][i]!=".") {
					str1+=board[j][i];
				}
			}
			b=judge(str1);
			str1="";
			if(b==false) {
				break;
			}
		}
		//用来判断每一个小矩阵
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				int Row = 3 * (i / 3) + j / 3;
				// 列号+偏移量
				int Col = 3 * (i % 3) + j % 3;
				//每个小九宫格，总共9个
					str1+=board[Row][Col];
			}
		}
		int m=0;
		while(m<str1.length()) {
			for(int i=m;i<m+9;i++) {
				if(str1.charAt(i)!='.') {
					str3+=str1.charAt(i);
				}
			}
			//System.out.println("str3:"+str3);
			c=judge(str3);
			//System.out.print(c+"\t");
			str3="";
			if(c==false) {
				break;
			}
			m=m+9;
		}
		return(a&&b&&c);
	}
	
	
	//判断每行，每列，每个矩阵是都是都符合
	public boolean judge(String str) {
		//判断是否都属于1-9
		//判断数字有没有重复
		String s="123456789";
		String s2="";
		boolean a=false;
		for(int i=0;i<str.length();i++) {
			if(s.indexOf(str.charAt(i))>=0&&s2.indexOf(str.charAt(i))<0) {
				s2+=str.charAt(i);
				a=true;
			}else {
				a=false;
				break;
			}
		}	
		return a;
	}
}
