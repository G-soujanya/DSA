import java.util.*;
public class Matrix {
    public static void main(String args[])
    {
        int[][] a={{1,2},
                {1,3}};
        int[][] b={{4,3},
                {1,5}};
        int[][] c=multiplication(a,b);
        for (int i = 0; i < c.length; i++) {
            System.out.println(Arrays.toString(c[i]));
        }
//        for (int i = 0; i < c.length; i++) {
//            System.out.println(Arrays.toString(c[i]));
//        transpose(a);
//        rotate90(a);

//        for (int i = 0; i < a.length; i++) {
//           System.out.println(Arrays.toString(a[i]));
//        }
    }
    public static int[][] addition(int a[][],int b[][])
    {
        int[][] c=new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                c[i][j]=a[i][j]+b[i][j];
            }
        }
        return c;
    }
    public static int[][] multiplication(int[][] a,int[][] b)
    {
        int[][] c=new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < b.length; k++) {
                    c[i][j]+=a[i][k]*b[k][j];
                }
            }
        }
        return c;
    }
    public static void transpose(int[][] a)
    {
        for (int i = 0; i < a.length-1; i++) {
            for (int j = i; j < a[i].length; j++) {
                if(i!=j)
                {
                    int temp=a[i][j];
                    a[i][j]=a[j][i];
                    a[j][i]=temp;
                }
            }
        }
    }
    public static void rotate90(int[][] a)
    {
        for (int i = 0; i < a.length; i++) {
            reverse(a[i]);
        }
        transpose(a);
    }
    public static void reverse(int a[])
    {
        int start=0;
        int end=a.length-1;
        while (start<end)
        {
            int temp=a[start];
            a[start]=a[end];
            a[end]=temp;
            start++;
            end--;
        }
    }
}
