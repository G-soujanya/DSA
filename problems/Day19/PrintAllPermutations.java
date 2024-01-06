public class PrintAllPermutations {
    public static void main(String agrs[])
    {
        printAllPermutations("abc","");
    }
    public static void printAllPermutations(String str,String outputSoFar)
    {
        if(str.isEmpty())
        {
            System.out.println(outputSoFar);
            return;
        }
        for(int i=0;i<str.length();i++)
            printAllPermutations(str.substring(0,i)+str.substring(i+1),outputSoFar+str.charAt(i));
    }
}
