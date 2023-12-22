import java.util.Arrays;

class Main
{
    public static void main(String args[])
    {
        // int arr[]={1,2,3,4,5,2};
        // leaders(arr);
        //minLenWord("abc de ghihjk uvw a i j");
        // System.out.println(Arrays.toString(split("abc de ghihjk uvw a i")));
        int arr1[]={1,5,10,15,20,25};
        int arr2[]={2,4,5,9,15};
        maximizeSum(arr1, arr2);
    }
    static void leaders(int arr[])
    {
        for(int i=arr.length-1;i>=0;i--)
        {
            boolean leader=true;
            for(int j=0;j<i;j++)
            {
                if(arr[j]>arr[i])
                {
                    leader=false;
                    break;
                }
            }
            if(leader)
                System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    static int countWord(String s)
    {
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==' ')
                count++;
        }
        if(s.charAt(0)==' ')
        return count;
        else 
        return count+1;
    }
    static String[] split(String s)
    {
        int countWords=countWord(s);
        String[] ar=new String[countWords];
        String t="";
        int j=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)!=' ')
                t+=s.charAt(i);
            else if(t.length()>=1)
            {
                ar[j]=t;
                j++;
                t="";
            }
        }
        ar[j]=t;
        return ar;
    }
    static void minLenWord(String s)
    {
        String str[]=split(s);
        int min=Integer.MAX_VALUE;
        String minWord=" ";
        for(int i=0;i<str.length;i++)
        {
            if(str[i].length()<min)
            {
                min=str[i].length();
                minWord=str[i];
            }
        }
        System.out.println(minWord);
    }
    static void maximizeSum(int arr1[],int arr2[])
    {
        int maxSum=0;
        int sum1=0;
        int sum2=0;
        int i=0;
        int j=0;
        while(i<arr1.length && j<arr2.length)
        {
            if(arr1[i]<arr2[j])
            {
                sum1+=arr1[i];
                i++;
            }
            else if(arr1[i]>arr2[j])
            {
                sum2+=arr2[j];
                j++;
            }
            else if(arr1[i]==arr2[j])
            {
                sum1+=arr1[i];
                sum2+=arr2[j];
                if(sum1>sum2)
                    maxSum+=sum1;
                else 
                    maxSum+=sum2;
                sum1=0;
                sum2=0;
                i++;
                j++;
            }
        }
        while(i<arr1.length)
            maxSum+=arr1[i++];
        while(j<arr2.length)
            maxSum+=arr2[j++];
        System.out.println(maxSum);
    }
}
