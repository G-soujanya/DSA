import java.util.Arrays;

class Main
{
    public static void main(String[] args) {
        // System.out.println(powerOf(2, 5));
        // System.out.println(powerOf2(3, 4));
        // number(6);
        // System.out.println(numberOfDigits(7019));
        //System.out.println(fibo(5));
        int arr[]={9,8,5,7,8,8};
        // System.out.println(checkSorted2(arr));
        // System.out.println(sumOfArray(arr));
        // System.out.println(sumOfArray2(arr));
        // System.out.println(sumOfArray3(arr,0));
        // System.out.println(checkNumberInArray(arr, 2, 0));
        // System.out.println(checkSorted3(arr, 1));
        // System.out.println(firstIndexOf(arr, 8));
        // allIndexOf(arr, 8);
        // System.out.println(lastIndexOf(arr, 3));
        // System.out.println(lastIndexOf2(arr, 3));
        // number3(3);
        // System.out.println(Arrays.toString(allIndexOf2(arr, 8)));
        // System.out.println(multi(3, 5));
        //System.out.println(countZerosFor0(0));
        // System.out.println(geometricSum(4));
        // System.out.println(sumOfDigits(9));
       System.out.println(checkPalindrome(""));
    }
    static int powerOf(int n,int pow)
    {
        if(pow==1)
            return n;
        return n*powerOf(n,pow-1);
    }
    static int powerOf2(int num,int pow)
    {
        if(num==0 && pow==0)
            return 1;
        if(num==0)
            return 0;
        if(pow==0)
            return 1;
        int smallAns=powerOf2(num, pow/2);
        if(pow%2==0)
            return smallAns*smallAns;
        else    
            return num*smallAns*smallAns;
    }
    static int number(int num)
    {
        if(num==0)
            return 0;
        int n=number(num-1);
        System.out.print(num+" ");
        return number(n);
    }
    static void number2(int num)
    {
        if(num==0)
            return;
        number(num-1);
        System.out.print(num+" ");
    }
    static void number3(int num)
    {
        if(num==1)
        {
            System.out.println(1);
            return;
        }
        number(num-1);
        System.out.print(num+" ");
    }
    static int numberOfDigits(int num)
    {
        if(num==0)
            return 0;
        return 1+numberOfDigits(num/10);
    }
    static int fibo(int n)
    {
        if(n==0 || n==1)
            return n;
        return fibo(n-1)+fibo(n-2);
    }
    static boolean checkSorted(int arr[])
    {
        if(arr.length<=1)
            return true;
        int smallArray[]=new int[arr.length-1];
        for(int i=1;i<arr.length;i++)
        {
            smallArray[i-1]=arr[i];
        }
        boolean small=checkSorted(smallArray);
        if(!small)
            return false;
        if(arr[0]<=arr[1])
            return true;
        return false;
    }
    static boolean checkSorted2(int arr[])
    {
        if(arr.length<=1)
            return true;
        if(arr[0]>arr[1])
            return false;
        int smallArray[]=new int[arr.length-1];
        for(int i=1;i<arr.length;i++)
        {
            smallArray[i-1]=arr[i];
        }
        boolean small=checkSorted(smallArray);
        return small;
    }
    static boolean checkSorted3(int arr[],int startIndex)
    {
        if(startIndex==arr.length)
            return true;
        if(arr[startIndex-1]>arr[startIndex])
            return false;
        return checkSorted3(arr, startIndex+1);
    }
    static boolean checkSorted3(int arr[])
    {
        return checkSorted3(arr, 1);
    } 
    static int sumOfArray(int arr[])
    {
        if(arr.length==0)
            return 0;
        int smallArray[]=new int[arr.length-1];
        for(int i=1;i<arr.length;i++)
        {
            smallArray[i-1]=arr[i];
        }
        return arr[0]+sumOfArray(smallArray);
    }
    static int sumOfArray2(int arr[])
    {
        if(arr.length==0)
            return 0;
        int smallArray[]=new int[arr.length-1];
        for(int i=0;i<arr.length-1;i++)
        {
            smallArray[i]=arr[i];
        }
        return arr[arr.length-1]+sumOfArray(smallArray);
    }
    static int sumOfArray3(int arr[],int startIndex)
    {
        if(startIndex==arr.length)
            return 0;
        return arr[startIndex]+sumOfArray3(arr, startIndex+1);
    }
    static boolean checkNumberInArray(int arr[],int num,int startIndex)
    {
        if(arr.length==startIndex)
            return false;
        if(arr[startIndex]==num)
            return true;
        return checkNumberInArray(arr, num, startIndex+1);

    }
    static int firstIndexOf(int arr[],int startIndex,int num)
    {
        if(startIndex==arr.length)
            return -1;
        if(arr[startIndex]==num)
            return startIndex;
        return firstIndexOf(arr, startIndex+1, num);
    }
    static int firstIndexOf(int arr[],int num)
    {
        return firstIndexOf(arr, 0, num);
    }
    static int lastIndexOf(int arr[],int startIndex,int num,int index)
    {
        if(startIndex==arr.length)
            return index;
        if(arr[startIndex]==num)
            index=startIndex;
        return lastIndexOf(arr, startIndex+1, num,index);
    }
    static int lastIndexOf(int arr[],int num)
    {
        return lastIndexOf(arr, 0, num,-1);
    }
    static int lastIndexOf2(int arr[],int startIndex,int num)
    {
        if(startIndex==arr.length)
            return -1;
        int smallAns=lastIndexOf2(arr,startIndex+1,num);
        if(smallAns!=-1)
            return smallAns;
        if(arr[startIndex]==num)
            return startIndex;
        return -1;
    }
    static int lastIndexOf2(int arr[],int num)
    {
        return lastIndexOf2(arr, 0,num);
    }
    static void allIndexOf(int arr[],int startIndex,int num)
    {
        if(startIndex==arr.length)
            return;
        if(arr[startIndex]==num)
            System.out.println(startIndex);
        allIndexOf(arr, startIndex+1, num);
    }
    static void allIndexOf(int arr[],int num)
    {
        allIndexOf(arr, 0, num);
    }
    private static int[] allIndexOf2(int arr[],int startIndex,int num)
    {
        if(startIndex==arr.length)
        {
            int output[]=new int[0];
            return output;
        }
        int smallArray[]=allIndexOf2(arr,startIndex+1,num);
        if(arr[startIndex]==num)
        {
            int output[]=new int[smallArray.length+1];
            output[0]=startIndex;
            for(int i=0;i<smallArray.length;i++)
            {
                output[i+1]=smallArray[i];
            }
            return output;
        }
        return smallArray;
    }
    static int[] allIndexOf2(int arr[],int num)
    {
        return allIndexOf2(arr, 0, num);
    }
    //Assignment
    static int multi(int num1,int num2)
    {
        if(num2==0 || num1==0)
            return 0;
        return num1+multi(num1,num2-1);
    }
    private static int countZeros(int num,int count)
    {
        if(num==0)
            return count;
        if(num%10==0)
            count++;
        return countZeros(num/10, count);
    }
    static int countZeros(int num)
    {
        return countZeros(num,0);
    }
    static int countZerosFor0(int num)
    {
        if(num<10)
        {
            if(num!=0)
                return 0;
            return 1;
        }
        if(num%10==0)
            return countZerosFor0(num/10)+1;
        return countZerosFor0(num/10);
    }
    static float geometricSum(int k)
    {
        if(k==0)
            return 1;
        return 1.0f/(powerOf(2, k))+geometricSum(k-1);
    }
    static int sumOfDigits(int num)
    {
        if(num==0)
            return 0;
        return num%10+sumOfDigits(num/10);
    }
    private static boolean checkPalindrome(String str,int startIndex)
    {
        if(startIndex==(str.length()+1)/2)
            return true;
        if(str.charAt(startIndex)!=str.charAt(str.length()-startIndex-1))
            return false;
        return checkPalindrome(str, startIndex+1);
    }
    static boolean checkPalindrome(String str)
    {
        return checkPalindrome(str, 0);
    }
}
