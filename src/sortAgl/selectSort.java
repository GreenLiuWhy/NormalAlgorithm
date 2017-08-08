/*
 * @author: lxw
 * 2017年8月7日*/
package sortAgl;

public class selectSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		selectSort ss=new selectSort();
		
		int[] arr={1,3,6,4,7,2,5,8};//
		int[] result=ss.mainSort_unChange(arr);
		//int[] result=ss.mainSort_changeOrg(arr);
		
		for(int i=0;i<result.length;i++)
			System.out.print(result[i]+",");
		System.out.println();
	}

	//算法思想：每次选择最小的，再从剩下的选次小的，以此类推，直到选择到所有元素
	//改变传入数组的做法:选出最小的，与排好序部分的第二位交换
	public int[] mainSort_changeOrg(int[] arr)
	{
		for(int sd=0;sd<arr.length;sd++)
		{
			int min=arr[sd];
			int mindex=sd;
			for(int iter=sd;iter<arr.length;iter++)
			{
				if(min>arr[iter])
				{
					min=arr[iter];
					mindex=iter;
				}
			}
			arr[mindex]=arr[sd];
			arr[sd]=min;
		}
		return arr;
		
	}
	
	//不改变原有数组的做法
	public int[] mainSort_unChange(int[] org)
	{
		int[] result=new int[org.length];
		//boolean[] flag=new boolean[org.length];//标志是否已经被选走,new后默认是false
		int MAX=9999;//如果知道最大值那用这个比较简单，如果不知道就用boolean的flag
		
		
		for(int count=0; count<org.length ;count++)
		{
			int min=MAX;
			int dex=0;
			for(int i=0;i<org.length;i++)
			{
				if(min>org[i])
				{
					min=org[i];
					dex=i;
				}
			}
			result[count]=min;
			org[dex]=MAX;
		}
		return result;
	}
}
