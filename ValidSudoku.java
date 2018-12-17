package leetcode;
/*
 * ȷ��9x9���������Ƿ���Ч��ֻ�����ĵ�Ԫ����Ҫ�������¹��������֤:
ÿ�б����������1-9�����ظ���
ÿһ�б����������1-9�����ظ���
�����ÿ��9 3x3�ӿ�����������1-9�������ظ���
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
		//�����ж�ÿһ��
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
		//�����ж�ÿһ��
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
		//�����ж�ÿһ��С����
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				int Row = 3 * (i / 3) + j / 3;
				// �к�+ƫ����
				int Col = 3 * (i % 3) + j % 3;
				//ÿ��С�Ź����ܹ�9��
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
	
	
	//�ж�ÿ�У�ÿ�У�ÿ�������Ƕ��Ƕ�����
	public boolean judge(String str) {
		//�ж��Ƿ�����1-9
		//�ж�������û���ظ�
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
