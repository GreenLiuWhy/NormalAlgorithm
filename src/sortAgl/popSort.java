/*
 * @author: lxw
 * 2017年8月7日*/
package sortAgl;

public class popSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		popSort ps=new popSort();
		int[] arr={1,3,6,4,7,2,5,8};//
		int[] result=ps.mainSort(arr);
		//int[] result=ss.mainSort_changeOrg(arr);
		
		for(int i=0;i<result.length;i++)
			System.out.print(result[i]+",");
		System.out.println();
	}
	
	//算法思想：每次从后向往前两两比较元素的值，如果为逆序，则交换他们。
	//重点：相邻两者交换，而不是用min和mindex指针
	public int[] mainSort(int[] arr)
	{
		int temp=0;
		for(int head=0;head<arr.length;head++)
		{
			for(int tail=arr.length-1;tail>head;tail--)
			{
				if(arr[tail-1]>arr[tail])
				{
					temp=arr[tail];
					arr[tail]=arr[tail-1];
					arr[tail-1]=temp;
				}
			}
		}
		return arr;
	}

}
