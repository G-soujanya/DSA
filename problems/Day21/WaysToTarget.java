import java.util.*;
public class WaysToTarget {
    public static void main(String args[])
    {
        int[] nums = {  3, 1, 4 };
//        System.out.println(waysToTarget(nums,0,4));
        printWays(nums,0,4,new ArrayDeque<>());
    }
    public  static int waysToTarget(int arr[],int startIndex,int num)
    {
        if(num==0 && startIndex==arr.length)
        {
            return 1;
        }
        if(startIndex==arr.length)
            return 0;
        int exclude=waysToTarget(arr,startIndex+1,num);
        int include=waysToTarget(arr,startIndex+1,num-arr[startIndex])+waysToTarget(arr,startIndex+1,num+arr[startIndex]);
        return include+exclude;
    }
    public static void printWays(int arr[],int startIndex,int target,Deque<Pair> list)
    {
        if(target==0 && startIndex==arr.length)
        {
            System.out.println(list);
            return;
        }
        if(startIndex==arr.length)
            return;
       printWays(arr,startIndex+1,target,list);
       list.addLast(new Pair(arr[startIndex],'+'));
       printWays(arr,startIndex+1,target+arr[startIndex],list);
       list.pollLast();
        list.addLast(new Pair(arr[startIndex],'-'));
        printWays(arr,startIndex+1,target-arr[startIndex],list);
        list.pollLast();
    }
}
class Pair{
    Integer num;
    Character sign;
    Pair(int num,Character c)
    {
        this.num=num;
        sign=c;
    }

    @Override
    public String toString() {
        return num+" "+sign;
    }
}
