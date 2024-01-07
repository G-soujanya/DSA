public class SplitArray {
    public static void main(String args[])
    {
        int arr[]={1,4,3};
        System.out.println(splitArray(arr,0,0,0));
    }
    public static boolean splitArray(int arr[],int startIndex,int lSum,int rSum)
    {
        if(startIndex==arr.length)
            return lSum==rSum;
        if(arr[startIndex]%3==0)
            lSum+=arr[startIndex];
        else if(arr[startIndex]%5==0)
            rSum+=arr[startIndex];
        else
        {
            boolean leftAns=splitArray(arr,startIndex+1,lSum+arr[startIndex],rSum);
            boolean rightAns=splitArray(arr,startIndex+1,lSum,rSum+arr[startIndex]);
            return leftAns || rightAns;
        }
        return splitArray(arr,startIndex+1,lSum,rSum);
    }
}
