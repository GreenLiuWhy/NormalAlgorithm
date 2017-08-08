/*
 * @author: lxw
 * 2017年8月7日*/
package sortAgl;

public class insertSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		insertSort insert=new insertSort();
		
		int[] arr={1,3,6,4,7,2,5,8};//
		//int[] result=insert.mainSort(arr);
		int[] result=insert.mainSort_changeOrg(arr);
		
		for(int i=0;i<result.length;i++)
			System.out.print(result[i]+",");
		System.out.println();
	}
	
	//算法思想，按下标序号选择org中的元素，依次插入到已经有序的数组中，将org中的元素依次比较sorted中的元素
	//如果不是应该插入到最后面，则前面的元素后移
	//重点：在org中选出的元素对sorted中比较时，要从sorted的后面向前面比
	public int[] mainSort(int[] org)
	{
		int[] sorted=new int[org.length];
		sorted[0]=org[0];
		for(int i=1;i<org.length;i++)
		{
			//找位置
			int dex=i-1;
			while(dex>=0)
			{
				if(sorted[dex]<=org[i])
					break;
				dex--;
			}
			//后移
			for(int dong=i-1;dong>dex;dong--)
			{
				sorted[dong+1]=sorted[dong];
			}
			//插入
			sorted[dex+1]=org[i];
		}
		return sorted;
	}
	
	//可以改变原数组的方法，也就是插入到原数组的前面
	public int[] mainSort_changeOrg(int[] arr)
	{
		int temp=0;//记录数值
		for(int i=1;i<arr.length;i++)
		{
			temp=arr[i];
			for(int dex=i-1; dex>=0; dex--)
			{
				if(arr[i]>=arr[dex])
				{
					//后移
					//System.out.println(dex);					
					for(int yidong=i; yidong>dex;yidong--)
						arr[yidong]=arr[yidong-1];
					//插入
					arr[dex+1]=temp;//此处是dex+1
					break;
				}
			}
		}
		return arr;
	}

}
