import java.util.* ;
import java.io.*; 
class Solution {
	static void reverse(int start,int end,int[] arr)
		{
			while(start<end)
			{
			int temp=arr[start];
			arr[start]=arr[end];
			arr[end]=temp;
			start++;
			end--;
			}
		}
	
	public static void main(String args[]) {
		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
		}
		int k=sc.nextInt();
		reverse(0, k-1,arr);

        reverse(k, n-1,arr);

        reverse(0, n-1,arr);
		for(int i=0;i<n;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
}

