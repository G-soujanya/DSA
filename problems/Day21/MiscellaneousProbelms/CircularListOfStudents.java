public class CircularListOfStudents {
    public static void main(String args[])
    {
        circularListOfStudents(5,9);
    }
    public static void circularListOfStudents(int i,int p)
    {
        int arr[]={0,1,2,3,4,5,6,7,8,9,10,11};
        int num=i+p;
        System.out.println(arr[(num%arr.length)]);
    }
}
