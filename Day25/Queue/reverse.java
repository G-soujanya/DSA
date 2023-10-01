// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue=new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue);
        reverse(queue);
        System.out.println(queue);
        }
        static void reverse(Queue q)
        {
            Stack<Integer> stack=new Stack<>();
            while(!q.isEmpty())
                stack.push((int)q.remove());
            while(!stack.isEmpty())
                q.add(stack.pop());


        }
}
