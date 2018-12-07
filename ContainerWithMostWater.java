package leetcode;
/*
 * 
 * 给定n个非负整数a1 a2…， an，
 * 其中每一个都表示坐标(i, ai)上的一个点。
 * 画了n条垂直线，使直线i的两个端点在(i, ai)和(i, 0)处，找出两条直线，与x轴一起形成一个容器，使容器中含有最多的水。
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
