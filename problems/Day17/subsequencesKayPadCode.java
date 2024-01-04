import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//        String output[]=new String[1000];
//        int ans=keyPadCode(23,output);
//        for (int i = 0; i < ans; i++) {
//            System.out.print(output[i]+" ");
//
//        }
//        System.out.println();
        printKeyPadCode(23,"");
    }
    public static String[] findSubsequences(String str)
    {
        if(str.isEmpty())
        {
            String ans[]={""};
            return ans;
        }
        String smallAns[]=findSubsequences(str.substring(1));
        String output[]=new String[smallAns.length*2];
        int k=0;
        for(int i=0;i<smallAns.length;i++)
        {
            output[k++]=smallAns[i];
        }
        for(int i=0;i<smallAns.length;i++)
        {
            output[k++]=str.charAt(0)+smallAns[i];
        }
        return output;
    }
    public static void printSubsequences(String str,String output)
    {
        if(str.isEmpty())
        {
            System.out.println(output);
            return;
        }
        printSubsequences(str.substring(1),output);
        printSubsequences(str.substring(1),output+str.charAt(0));
    }
    public static String getString(int n)
    {
        if(n==2)
            return "abc";
        if(n==3)
            return "def";
        if(n==4)
            return "ghi";
        if(n==5)
            return "jkl";
        if(n==6)
            return "mno";
        if(n==7)
            return "pqrs";
        if(n==8)
            return "tuv";
        if(n==9)
            return "wxyz";
        if(n==1 || n==0)
            return "";
        return "";
    }
    public static String[] keyPadCode(int n)
    {
        if(n==0)
        {
            String output[]={""};
            return output;
        }
        int rem=n%10;
        n=n/10;
        String[]  output1=keyPadCode(n);
        String options=getString(rem);
        String[] newOutput=new String[output1.length*options.length()];
        int k=0;
        for(int i=0;i<options.length();i++)
        {
            for (int j = 0; j < output1.length; j++) {
                newOutput[k++]=output1[j]+options.charAt(i);
            }
        }
        return newOutput;
    }
    public static int keyPadCode(int n,String output[])
    {
        if(n==0)
        {
            output[0]="";
            return 1;
        }
        int rem=n%10;
        n=n/10;
        int smallAns=keyPadCode(n,output);
        String options=getString(rem);
        for (int i = 0; i <options.length() -1; i++) {
            for (int j = 0; j < smallAns; j++) {
                output[j+(i+1)*smallAns]=output[j];
            }
        }
        int k=0;
        for (int i = 0; i <options.length(); i++) {
            for (int j = 0; j < smallAns; j++) {
                output[k++]=output[k]+options.charAt(i);
            }
        }
        return smallAns*options.length();
    }
    public static void printKeyPadCode(int n,String output)
    {
        if(n==0)
        {
            System.out.println(output);
            return;
        }
        String str=getString(n%10);
        for (int i = 0; i < str.length(); i++) {
            printKeyPadCode(n/10,str.charAt(i)+output);
        }
    }
}
