import java.util.ArrayList;

public class Solution {
	public static int removeDuplicates(ArrayList<Integer> arr,int n) {
		int temp=0;
		for(int i=1;i<n;i++)
		{
			if(arr.get(i-1)>=arr.get(i))
			{
				temp++;
			}
		}
		return n-temp;
	}
}
