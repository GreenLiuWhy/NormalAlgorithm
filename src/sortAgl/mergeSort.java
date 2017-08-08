/*
 * @author: lxw
 * 2017年8月7日*/
package sortAgl;

public class mergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mergeSort ms=new mergeSort();
		int[] arr={1,3,6,4,7,2,5,8};//
		int[] result=ms.mainSort_unDigui(arr);
		//int[] result=ss.mainSort_changeOrg(arr);
		
		for(int i=0;i<result.length;i++)
			System.out.print(result[i]+",");
		System.out.println();
		
		int[] re=ms.mainSort_Digui(arr, 0, arr.length-1);
		//int[] result=ss.mainSort_changeOrg(arr);
		
		for(int i=0;i<re.length;i++)
			System.out.print(re[i]+",");
		System.out.println();
	}
	
	//算法思想：初始(1,1)，其后合并已经部分有序的数组(2,2)，以后合并(4,4)，以此类推，只到合并完成整个数组
	//没有用递归的方案1
	public int[] mainSort_unDigui(int[] arr)
	{
		int path=1;
		while(path<arr.length)
		{
			arr=this.merge(arr, path);
			path=path*2;
		}
		return arr;
	}
	
	//用来和并两个有序的数组，其中headtail是指第一个有序数组的末尾，tailhead指的是后一个有序数组的开头
	public int[] merge(int[] arr, int path)
	{
		//调用函数得到应该的sub边界终止条件
		int head=0;
		int[] paras=this.paras(head, path, arr.length);
		int[] result=new int[arr.length];
		int rd=0;
		
		while(rd<arr.length)
		{
			//两个已经有序的数组的合并
			while(head<=paras[0] && paras[1]<=paras[2])
			{
				if(arr[head]<arr[paras[1]])
					result[rd++]=arr[head++];
				else
				{
					result[rd++]=arr[paras[1]];
					paras[1]=paras[1]+1;
				}
			}
			while(head<=paras[0])
				result[rd++]=arr[head++];
			while(paras[1]<=paras[2])
			{
				result[rd++]=arr[paras[1]];
				paras[1]=paras[1]+1;
			}
			//更新sub的边界参数
			head=paras[2]+1;
			paras=this.paras(head, path, arr.length);
		}
		return result;
	}
	
	//其中返回的[0]=headtail. [1]=tailhead. [2]=tail
	public int[] paras(int head, int path, int len)
	{
		int[] paras=new int[3];
		if(head+path-1<len-1)
		{
			paras[0]=head+path-1;
			paras[1]=head+path;
		}
		else
		{
			paras[0]=len-1;
			paras[1]=1;
			paras[2]=0;//目的是为了让条件tailhead<tail的条件为假
			return paras;
		}
		
		if(head+2*path-1>=len-1)
			paras[2]=len-1;
		else
			paras[2]=head+2*path-1;
			
//		int headtail=head+path-1;
//		int tailhead=head+path;
//		int tail=head+2*path-1;
		return paras;
	}
	
	//一般我们经常使用的归并操作
	public int[] mainSort_Digui(int[] arr, int low, int high)
	{
		if(low<high)
		{
			int mid=(low+high)/2;
			this.mainSort_Digui(arr, low, mid);
			this.mainSort_Digui(arr, mid+1, high);
			this.justMerge(arr, low, mid, high);
		}
		return arr;
	}
	
	//合并两个有序链表,比原来的方法改进之处是，不用每次生成和arr一样大小的辅助数组，这样可以节省内存
	public void justMerge(int[] arr, int low, int mid, int high)
	{
		//辅助数组
		int[] tempArr=new int[high-low+1];
		//合并
		int dt=0;
		int k=low;
		int kk=mid+1;
		while(k<=mid && kk<=high)
		{
			if(arr[k]<arr[kk])
				tempArr[dt++]=arr[k++];
			else
				tempArr[dt++]=arr[kk++];
		}
		while(k<=mid)
			tempArr[dt++]=arr[k++];
		while(kk<=high)
			tempArr[dt++]=arr[kk++];
		
		dt=0;
		while(low<=high)
			arr[low++]=tempArr[dt++];
	}
	

}
