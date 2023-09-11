import java.util.* ;
import java.io.*; 
class Solution {
	
	public static void main(String args[]) {
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	int arr[]=new int[n];
	for(int i=0;i<n;i++)
	{
		arr[i]=sc.nextInt();
	}
	int k=sc.nextInt();
	int[] arr1=new int[k];
	int i=0;
	int temp=k;
	while(k!=0)
	{
		arr1[i]=arr[i];
		k--;
		i++;
	}
	for(i=0;i<n-temp;i++)
	{
		arr[i]=arr[i+temp];
	}
	i=0;
	while(temp!=0)
	{
		arr[n-temp]=arr1[i];
		temp--;
		i++;
	}
	for (i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
	}
}
