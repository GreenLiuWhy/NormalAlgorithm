/*
 * @author: lxw
 * 2017年8月7日*/
package sortAgl;

public class quickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		quickSort qs=new quickSort();
		int[] arr={1,3,6,4,7,2,5,8};//
		int[] result=qs.mainSort(arr, 0, arr.length-1);;
		//int[] result=ss.mainSort_changeOrg(arr);
		
		for(int i=0;i<result.length;i++)
			System.out.print(result[i]+",");
		System.out.println();
	}
	
	
	//主函数：用来递归调用
	public int[] mainSort(int[] arr, int low, int high)
	{
		if(low<high)
		{
			//int pt=this.partition(arr, low, high);
			int pt=this.partition2(arr, low, high);
			this.mainSort(arr, low, pt-1);
			this.mainSort(arr, pt+1,high );
		}
		return arr;
	}
	//交换所用工具类:划分操作
	public int partition(int[] arr, int head,int tail)
	{
		//用最头上的元素当作中轴进行排序
		int pri=head++;
		while(head<tail)
		{
			while(head<tail && arr[pri]<arr[tail])
				tail--;
			if(head>=tail)
				break;
			int temp=arr[pri];
			arr[pri]=arr[tail];
			arr[tail]=temp;
			pri=tail--;
			
			while(head<tail && arr[pri]>arr[head])
				head++;
			if(head>=tail)
				break;
			temp=arr[pri];
			arr[pri]=arr[head];
			arr[head]=temp;
			pri=head++;
		}
		return pri;

	}
	
	public int partition2(int[] arr, int low, int high)
	{
		int pri=arr[low];
		while(low<high)
		{
			while(low<high && pri<arr[high])
				high--;
			arr[low]=arr[high];
			while(low<high && arr[low]<pri)
				low++;
			arr[high]=arr[low];
		}
		arr[low]=pri;
		return low;
	}
}
