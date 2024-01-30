// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;
public class Main {
    public static void main(String[] args) {
        QueueUsingArray queue=new QueueUsingArray(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.dequeue();
        queue.enqueue(6);
        System.out.println(queue.size());
        System.out.println(queue.display());
    }
    public static void reverse(Queue q)
    {
        Stack<Integer> stack=new Stack<>();
        while (!q.isEmpty())
        {
            stack.push((int)q.remove());
        }
        while (!stack.isEmpty())
            System.out.println(stack.pop());
    }
}