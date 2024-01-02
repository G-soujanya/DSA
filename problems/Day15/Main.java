// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println(removeDuplicates1("xxxyyyzwwzzz"));
    }
    public static String removeX(String str,int startIndex,String t)
    {
        if(startIndex==str.length())
            return t;
        if(str.charAt(startIndex)!='x')
            t+=str.charAt(startIndex);
        return removeX(str,startIndex+1,t);
    }
    private static String removeX(String str)
    {
        return removeX(str,0,"");
    }
    public static String removeX1(String str)
    {
        if(str.length()==0)
            return "";
        String ans="";
        if(str.charAt(0)!='x')
            ans+=str.charAt(0);
        String small=removeX1(str.substring(1));
        return ans+small;
    }

    public static String replaceChar(String str,char c1,char c2)
    {
        if(str.isEmpty())
            return "";
        String ans="";
        if(str.charAt(0)==c1)
            ans+=c2;
        else
            ans+=str.charAt(0);
        String small=replaceChar(str.substring(1),c1,c2);
        return ans+small;
    }
    public  static String replaceChar1(String str,int startIndex,char c1,char c2,String t)
    {
        if(startIndex==str.length())
            return t;
        if(str.charAt(startIndex)==c1)
            t+=c2;
        else
            t+=str.charAt(startIndex);
        return replaceChar1(str,startIndex+1,c1,c2,t);
    }
    private static String replaceChar1(String str,char c1,char c2)
    {
        return replaceChar1(str,0,c1,c2,"");
    }
    private static String removeDuplicates(String str,int startIndex,String t)
    {
        if(startIndex==str.length()-1) {
            t+=str.charAt(str.length()-1);
            return t;
        }
        if(str.charAt(startIndex)!=str.charAt(startIndex+1))
            t+=str.charAt(startIndex);
        return  removeDuplicates(str,startIndex+1,t);
    }
    public static  String removeDuplicates(String str)
    {
        return removeDuplicates(str,0,"");
    }
    public static String removeDuplicates1(String str)
    {
        if(str.isEmpty())
            return "";
        if(str.length()==1)
        {
            return ""+str.charAt(0);
        }
        String ans="";
        if(str.charAt(0)!=str.charAt(1))
            ans+=str.charAt(0);
        String small=removeDuplicates1(str.substring(1));
        return ans+small;
    }
    public static void mergeSort(int input[])
    {
        if(input.length<=1)
            return;
        int mid=input.length/2;
        int part1[]=new int[mid];
        int part2[]=new int[input.length-mid];
        for(int i=0;i<mid;i++)
            part1[i]=input[i];
        int k=0;
        for(int i=mid;i<input.length;i++)
            part2[k++]=input[i];
        mergeSort(part1);
        mergeSort(part2);
        merge(part1,part2,input);
    }

    private static void merge(int[] part1, int[] part2,int[] input) {
        int i=0,j=0,k=0;
        while(i<part1.length && j<part2.length)
        {
            if(part1[i]<part2[j])
                input[k++]=part1[i++];
            else
                input[k++]=part2[j++];
        }
        while (i<part1.length)
            input[k++]=part1[i++];
        while (j<part2.length)
            input[k++]=part2[j++];
    }
    public static void quickSort(int input[],int start,int end)
    {
        if(start>=end)
            return;
        int pivotIndex=partition(input,start,end);
        quickSort(input,start,pivotIndex-1);
        quickSort(input,pivotIndex+1,end);
    }

    private static int partition(int[] input, int start, int end) {
        int pivot=input[start];
        int noOfLessThanPivot=0;
        for(int i=start+1;i<=end;i++)
        {
            if(input[i]<=pivot)
                noOfLessThanPivot++;
        }
        int pivotIndex=start+noOfLessThanPivot;
        input[start]=input[pivotIndex];
        input[pivotIndex]=pivot;
        int i=start;
        int j=end;
        while(i<pivotIndex && j>pivotIndex)
        {
            if(input[i]<=input[pivotIndex])
                i++;
            else if(input[j]>input[pivotIndex])
                j--;
            else
            {
                int temp=input[i];
                input[i]=input[j];
                input[j]=temp;
                i++;
                j--;
            }
        }
        return pivotIndex;
    }
}
