import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue=new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        System.out.println(queue);
        reverseKElements(3,queue);
        System.out.println(queue);
    }
    static void reverseKElements(int k,Queue<Integer> q)
    {
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<k;i++)
        {
            stack.push(q.remove());
        }
        while(!stack.isEmpty())
        {
            q.add(stack.pop());
        }
        for(int i=0;i<q.size()-k;i++)
        {
            q.add(q.remove());
        }
    }
}
