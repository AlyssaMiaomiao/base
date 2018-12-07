package leetcode;
/*
 * 
 * ����n���Ǹ�����a1 a2���� an��
 * ����ÿһ������ʾ����(i, ai)�ϵ�һ���㡣
 * ����n����ֱ�ߣ�ʹֱ��i�������˵���(i, ai)��(i, 0)�����ҳ�����ֱ�ߣ���x��һ���γ�һ��������ʹ�����к�������ˮ��
 * 
 * Input: [1,8,6,2,5,4,8,3,7]
	Output: 49*/
public class ContainerWithMostWater {
	public static void main(String[] args) {
		ContainerWithMostWater cws=new ContainerWithMostWater();
		int[] height= {1,8,6,2,5,4,8,3,7};
		System.out.println(cws.maxArea(height));
	}
	public int maxArea(int[] height) {
		int h=0,width=0,area=0,biggest=0;
		for(int i=0;i<height.length-1;i++) {
			for(int j=i+1;j<height.length;j++) {
				h=height[i]<height[j]?height[i]:height[j];
				width=j-i;
				area=h*width;
				biggest=area>=biggest?area:biggest;
			}
		}
	      return biggest;  
	}
}
