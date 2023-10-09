import java.util.ArrayDeque;
import java.util.Deque;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Deque<Integer> queue=new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.addFirst(30);
        //queue.remove();
        queue.removeLast();
        System.out.println(queue.peekLast());
        System.out.println(queue);
    }
}
