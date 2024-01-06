import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
    int arr[]={5,1,3,3};
    int output[][]=subsetsOfArrayToK(arr,0,6);
    for(int[] x:output)
        System.out.println(Arrays.toString(x));
    }
    public static String[] findSubsequences(String str)
    {
        if(str.isEmpty())
        {
            String ans[]={""};
            return ans;
        }
        String smallAns[]=findSubsequences(str.substring(1));
        String output[]=new String[smallAns.length*2];
        int k=0;
        for(int i=0;i<smallAns.length;i++)
        {
            output[k++]=smallAns[i];
        }
        for(int i=0;i<smallAns.length;i++)
        {
            output[k++]=str.charAt(0)+smallAns[i];
        }
        return output;
    }
    public static void printSubsequences(String str,String output)
    {
        if(str.isEmpty())
        {
            System.out.println(output);
            return;
        }
        printSubsequences(str.substring(1),output);
        printSubsequences(str.substring(1),output+str.charAt(0));
    }
    public static String getString(int n)
    {
        if(n==2)
            return "abc";
        if(n==3)
            return "def";
        if(n==4)
            return "ghi";
        if(n==5)
            return "jkl";
        if(n==6)
            return "mno";
        if(n==7)
            return "pqrs";
        if(n==8)
            return "tuv";
        if(n==9)
            return "wxyz";
        if(n==1 || n==0)
            return "";
        return "";
    }
    public static String[] keyPadCode(int n)
    {
        if(n==0)
        {
            String output[]={""};
            return output;
        }
        int rem=n%10;
        n=n/10;
        String[]  output1=keyPadCode(n);
        String options=getString(rem);
        String[] newOutput=new String[output1.length*options.length()];
        int k=0;
        for(int i=0;i<options.length();i++)
        {
            for (int j = 0; j < output1.length; j++) {
                newOutput[k++]=output1[j]+options.charAt(i);
            }
        }
        return newOutput;
    }
    public static int keyPadCode(int n,String output[])
    {
        if(n==0)
        {
            output[0]="";
            return 1;
        }
        int rem=n%10;
        n=n/10;
        int smallAns=keyPadCode(n,output);
        String options=getString(rem);
        for (int i = 0; i <options.length() -1; i++) {
            for (int j = 0; j < smallAns; j++) {
                output[j+(i+1)*smallAns]=output[j];
            }
        }
        int k=0;
        for (int i = 0; i <options.length(); i++) {
            for (int j = 0; j < smallAns; j++) {
                output[k++]=output[k]+options.charAt(i);
            }
        }
        return smallAns*options.length();
    }
    public static void printKeyPadCode(int n,String output)
    {
        if(n==0)
        {
            System.out.println(output);
            return;
        }
        String str=getString(n%10);
        for (int i = 0; i < str.length(); i++) {
            printKeyPadCode(n/10,str.charAt(i)+output);
        }
    }
    public static boolean checkAB(String str)
    {
        if(str.isEmpty())
            return true;
        if(str.charAt(0)=='a')
        {
            if(str.substring(1).length()>1 && str.substring(1,3).equals("bb"))
                return checkAB(str.substring(3));
            return checkAB(str.substring(1));
        }
        return false;
    }
    public static int staireCase(int n)
    {
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        if(n==3)
            return 4;
        return staireCase(n-1)+staireCase(n-2)+staireCase(n-3);
    }
    public static int stairCase(int n)
    {
        if(n<0)
            return 0;
        if(n==0)
            return 1;
        return stairCase(n-1)+stairCase(n-2)+stairCase(n-3);
    }
    public static int binarySearch(int arr[],int start,int end,int num)
    {
        if(start>end)
            return -1;
        int mid=(start+end)/2;
        if(num==arr[mid])
            return mid;
        if(num>arr[mid])
            return binarySearch(arr,mid+1,end,num);
        return binarySearch(arr,start,mid-1,num);
    }
    public static int[][] subSetsOfArray(int arr[],int startIndex)
    {
        if(arr.length==startIndex)
        {
            int[][] output=new int[1][0];
            return output;
        }
        int[][] smallAns=subSetsOfArray(arr,startIndex+1);
        int[][] newOutput=new int[smallAns.length*2][];
        int k=0;
        for(int i=0;i<smallAns.length;i++)
        {
            newOutput[k]=new int[smallAns[i].length];
            for(int j=0;j<smallAns[i].length;j++)
            {
                newOutput[k][j]= smallAns[i][j];
            }
            k++;
        }
        for(int i=0;i<smallAns.length;i++)
        {
            newOutput[k]=new int[smallAns[i].length+1];
            newOutput[k][0]=arr[startIndex];
            for(int j=0;j<smallAns[i].length;j++)
            {
                newOutput[k][j+1]= smallAns[i][j];
            }
            k++;
        }
        return newOutput;
    }
    //print
    public static void printSubSetOfArray(int arr[],int startIndex,int output[])
    {
        if(startIndex==arr.length)
        {
            System.out.println(Arrays.toString(output));
            return;
        }
        printSubSetOfArray(arr,startIndex+1,output);
        int newOutput[]=new int[output.length+1];

        for(int i=0;i<output.length;i++)
            newOutput[i]=output[i];
        newOutput[output.length]=arr[startIndex];
        printSubSetOfArray(arr,startIndex+1,newOutput);

    }
    public static int[][] subsetsOfArrayToK(int arr[],int startIndex,int k)
    {
        if(startIndex==arr.length)
        {
            if(k==0)
                return new int[1][0];
            else
                return new int[0][0];

        }
        int smallOutput1[][]=subsetsOfArrayToK(arr,startIndex+1,k);
        int smallOutput2[][]=subsetsOfArrayToK(arr,startIndex+1,k-arr[startIndex]);
        int[][] newOutput=new int[smallOutput1.length+smallOutput2.length][];
        int index=0;
        for (int i = 0; i < smallOutput1.length; i++) {
            newOutput[index]=new int[smallOutput1[i].length];
            for (int j = 0; j < smallOutput1[i].length; j++) {
                newOutput[index][j]=smallOutput1[i][j];
            }
            index++;
        }
        for(int i=0;i<smallOutput2.length;i++)
        {
            newOutput[index]=new int[smallOutput2[i].length+1];
            newOutput[index][0]=arr[startIndex];
            for (int j = 0; j < smallOutput2[i].length; j++) {
                newOutput[index][j+1]=smallOutput2[i][j];
            }
            index++;
        }
        return newOutput;
    }
    public static void printSubSetOfArrayToK(int arr[],int startIndex,int output[],int k)
    {
        if(startIndex==arr.length)
        {
            //System.out.println(Arrays.toString(output));
            int sum=0;
            for(int i=0;i<output.length;i++)
                sum+=output[i];
            //System.out.println(sum);
            if(sum==k)
                System.out.println(Arrays.toString(output));
            return;
        }
        printSubSetOfArrayToK(arr,startIndex+1,output,k);
        int newOutput[]=new int[output.length+1];

        for(int i=0;i<output.length;i++)
            newOutput[i]=output[i];
        newOutput[output.length]=arr[startIndex];
        printSubSetOfArrayToK(arr,startIndex+1,newOutput,k);

    }
}