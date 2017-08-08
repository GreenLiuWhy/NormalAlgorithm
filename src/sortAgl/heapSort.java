/*
 * @author: lxw
 * 2017年8月7日*/
package sortAgl;

public class heapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		heapSort hs=new heapSort();
		
		int[] arr={1,3,6,4,7,2,5,8};//
		int[] result=hs.mainSort(arr);
		
		for(int i=0;i<result.length;i++)
			System.out.print(result[i]+",");
		System.out.println();
	}
	
	//算法思想：利用完全二叉树中双亲节点和孩子节点之间的内在关系，在当前无序区中选择关键字最大（或最小）的元素
	//按根节点和孩子节点的关系分为大根堆和小根堆
	//主要步骤是：初始序列建堆，从下向上的非叶子节点调整，输出堆顶元素（堆的最后一个元素与栈顶元素交换）
	// repeat{ 调整，输出}
	public int[] mainSort(int[] arr)
	{
		for(int i=0; i<arr.length; i++)
		{
			this.BuildMaxHeap(arr, arr.length-1-i); //对未排序的元素尽力大根堆
			this.swap(arr, 0, arr.length-1-i);//将最大的元素，也就是堆顶元素【0】，放在数组的最后放【len-1-i】
		}
		return arr;
	}
	
	//建立大根堆
	public void BuildMaxHeap(int[] data, int lastIndex)
	{
		for(int i=(lastIndex-1)/2; i>=0; i--)//即代表从[n/2](向下取整)个位置开始调整，一直调整到根节点
		{
			int k=i; 
			while(2*k+1<=lastIndex)
			{
				int bigDex=2*k+1; //非叶子节点的左孩子
				if(bigDex<lastIndex)//如果该非叶子节点有又孩子
				{
					if(data[bigDex]<data[bigDex+1]) //替换的时候。要替换大的值，所以此部选择左右孩子中的大值
						bigDex++;
				}
				if(data[k]<data[bigDex])//如果比父亲节点要大，则将孩子中的大值与父亲节点进行替换
				{
					this.swap(data, k, bigDex);
					k=bigDex; //这一步是要做到逐层向下替换，也就是说如果原来的父亲比孙子节点还小，则应该也和孙子替换位置
				}else
					break;
			}
		}
	}
	

	//交换数组，在网上偶尔看到的，这个秒啊，都不用另外的耗费空间
	public void swap(int[] arr, int i, int j)
	{
		if(i==j)
			return;
		arr[i]=arr[i]+arr[j];
		arr[j]=arr[i]-arr[j];
		arr[i]=arr[i]-arr[j];
	}

}
