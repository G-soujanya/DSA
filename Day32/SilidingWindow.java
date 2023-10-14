import java.util.*;
class SlidingWindow 
{
    public static void main(String args[])
    {
        int a[]={12,11,9,15,20,9,8};
        int k=3;
        maxInSlide(a, k);
    }
    static void maxInSlide(int []arr,int k)
    {
        Deque<Integer> deque=new ArrayDeque<>();
        for(int i=0;i<k;i++)
        {
            while(deque.size()>0 && arr[i]>=arr[deque.peekLast()])
            {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        for(int i=k;i<arr.length;i++)
        {
            System.out.println(arr[deque.peekFirst()]);
            while(deque.size()>0 && deque.peekFirst()<=i-k)
            {
                deque.pollFirst();
            }
            while(deque.size()>0 && arr[i]>=arr[deque.peekLast()])
            {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        System.out.println(arr[deque.peekFirst()]);
    }
}
