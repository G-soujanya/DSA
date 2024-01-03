import java.util.Scanner;
import java.lang.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int arr[][]=takeInput();
        printArray(arr);
       // boundaryAndDiagonalEleSum2(arr);
        //diagonalEleSum(arr);
        //wavePrint(arr);
    }
    public static int[][] takeInput()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of rows");
        int rows=sc.nextInt();
        System.out.println("Enter the number of columns");
        int columns=sc.nextInt();
        int arr[][]=new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.println("Enter the element at "+i+" rows "+j+" column");
                arr[i][j]=sc.nextInt();
            }
        }
        return arr;
    }
    public static void printArray(int arr[][])
    {
        int rows=arr.length;
        int columns=arr[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void rowWiseSome(int arr[][])
    {
        int rows=arr.length;
        int columns=arr[0].length;
        for (int i = 0; i < rows; i++) {
            int sum=0;
            for (int j = 0; j < columns; j++) {
                sum+=arr[i][j];
            }
            System.out.print(sum+" ");
        }
    }
    public static void largestColumnOrRowSum(int arr[][])
    {
        boolean row=true;
        int rows=arr.length;
        int columns=arr[0].length;
        int max=Integer.MIN_VALUE;
        int index=-1;
        for (int i = 0; i < rows; i++) {
            int sum=0;
            for (int j = 0; j < columns; j++) {
                sum+=arr[i][j];
            }
            if(sum>max) {
                max = sum;
                index = i;
            }
        }
        for (int i = 0; i < columns; i++) {
            int sum=0;
            for (int j = 0; j < rows; j++) {
                sum+=arr[j][i];
            }
            if(sum>max) {
                max = sum;
                index=i;
                row=false;
            }
        }
        if(row)
            System.out.println("row"+index+max);
        else
            System.out.println("column "+index+" "+max);
    }
    // Assignment
    public static void boundaryAndDiagonalEleSum(int arr[][])
    {
        int rows=arr.length;
        int columns=arr[0].length;
        int sum=0;
        for(int i=0;i<columns;i++)
            sum+=arr[0][i];
        for(int i=1;i<rows;i++)
            sum+=arr[i][rows-1];
        for(int i=columns-2;i>=0;i--)
            sum+=arr[rows-1][i];
        for(int i=rows-2;i>0;i--)
            sum+=arr[i][0];
        int sum1=rows-1;
       // int eleSum=0;
        for (int i = 1; i < rows-1; i++) {
            for (int j =1; j < columns-1; j++) {
                if(i==j || i+j==sum1)
                    sum+=arr[i][j];
            }
        }
        System.out.println(sum);
    }
    public static void diagonalEleSum(int arr[][])
    {
        int rows=arr.length;
        int columns=arr[0].length;
        int sum=rows-1;
        int eleSum=0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
            if(i==j || i+j==sum)
                eleSum+=arr[i][j];
            }
        }
        System.out.println(eleSum);
    }
    public static void boundaryAndDiagonalEleSum2(int arr[][])
    {
        int dimension=arr.length;
        //first diagonal sum
        int sum=0;
        for (int i=0;i<dimension;i++)
        {
            sum+=arr[i][i];
        }
        //second diagonal sum
        int currentRow=0;
        int currentcol=dimension-1;
        while (currentcol<dimension && currentcol>=0)
        {
            sum+=arr[currentRow][currentcol];
            currentRow++;
            currentcol--;
        }
        //boundary elements
        for(int i=1;i<dimension-1;i++)
        {
            sum+=arr[0][i];
            sum+=arr[dimension-1][i];
            sum+=arr[i][dimension-1];
            sum+=arr[i][0];
        }
        if(dimension%2!=0)
            sum-=arr[dimension/2][dimension/2];
        System.out.println(sum);
    }
    public static void wavePrint(int arr[][])
    {
        int rows=arr.length;
        int columns=arr[0].length;
        for(int i=0;i<columns;i++)
        {
            if(i%2==0)
            {
                for(int j=0;j<rows;j++)
                    System.out.print(arr[j][i]+" ");
            }
            else
            {
                for (int j = rows-1; j >=0 ; j--) {
                    System.out.print(arr[j][i]+" ");
                }
            }
        }
        System.out.println();
    }
    public static void spiralPrint(int arr[][])
    {
        int rows=arr.length;
        int columns=arr[0].length;
        int count=0;
        int colStart=0,colEnd=columns-1,rowStart=0,rowEnd=rows-1;
        int noOfEle=rows*columns;
        while (count<noOfEle)
        {
            for(int i=colStart;count<noOfEle && i<=colEnd;i++)
            {
                count++;
                System.out.print(arr[rowStart][i]+" ");
            }
            rowStart++;
            for(int i=rowStart;count<noOfEle && i<=rowEnd;i++)
            {
                count++;
                System.out.print(arr[i][colEnd]+" ");
            }
            colEnd--;
            for(int i=colEnd;count<noOfEle && i>=colStart;i--)
            {
                count++;
                System.out.print(arr[rowEnd][i]+" ");
            }
            rowEnd--;
            for (int i = rowEnd;count<noOfEle &&  i >=rowStart ; i--) {
                count++;
                System.out.print(arr[i][colStart]+" ");

            }
            colStart++;
        }
    }
}
