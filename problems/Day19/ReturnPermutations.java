import java.util.Arrays;

public class ReturnPermutations {
    public static void main(String args[])
    {
//        String[] s=returnAllPermutations1("abc",0);
//        System.out.println(Arrays.toString(s));
    }
    public static String[] returnAllPermutations(String str)
    {
        if(str.isEmpty())
        {
            String output[]={""};
            return output;
        }
        String[] smallAns=returnAllPermutations(str.substring(1));
        String output[]=new String[smallAns.length*str.length()];
        int k=0;
        for(int i=0;i<smallAns.length;i++)
        {
            String currentString=smallAns[i];
            for(int j=0;j<=currentString.length();j++)
            {
                output[k++]=currentString.substring(0,j)+str.charAt(0)+currentString.substring(j);
            }
        }
        return output;
    }
    public static String[] returnAllPermutations1(String str,int startIndex)
    {
        if (str.isEmpty()) {
            String output[] = {""};
            return output;
        }
//        String withoutChar=str.substring(0,startIndex)+str.substring(startIndex+1);
//        String smallAns[]=returnAllPermutations1(withoutChar,startIndex+1);
//        String newOutput[]=new String[smallAns.length+withoutChar.length()];
//        int k=0;
//        int i=0;
//        for(;i<smallAns.length-withoutChar.length();i++)
//        {
//            newOutput[k++]=smallAns[i];
//        }
//        for(;i<withoutChar.length();i++)
//        {
//            newOutput[k++]=str.charAt(startIndex)+smallAns[i];
//        }
//        return newOutput;
        String smallAns[]=new String[0];
        for(int i=0;i<str.length();i++) {
            smallAns = returnAllPermutations(str.substring(0, i) + str.substring(i + 1));

        }
    }
}
