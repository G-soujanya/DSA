// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println(longestNonPalindromeStr("makhud"));
    }
    private static boolean palindrome(String str,int index)
    {
        if(index==(str.length()/2))
            return true;
        if(str.charAt(index)!=str.charAt(str.length()-index-1))
            return  false;
        return palindrome(str,index+1);
    }
    public static String lexiFirstStr(String str)
    {
        if(!palindrome(str,0))
            return "No such string";
        int freqArray[]=new int[26];
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            freqArray[ch-'a']=freqArray[ch-'a']+1;
        }
        String frontStr="",midStr="",endStr="";
        for(int i=0;i<26;i++)
        {
            if(freqArray[i]!=0 && freqArray[i]%2==0)
            {
                freqArray[i]-=1;
                for(int j=0;j<=freqArray[i]/2;j++)
                    frontStr+=(char)(i+'a');
            }
            else if(freqArray[i]%2==1)
            {
                midStr+=(char)(i+'a');
                freqArray[i]-=1;
                i--;
            }
        }
        for(int i=frontStr.length()-1;i>=0;i--)
        {
            endStr+=frontStr.charAt(i);
        }
        return frontStr+midStr+endStr;
    }
    public static int longestNonPalindromeStr(String str)
    {
        char ch=str.charAt(0);
        boolean flag=true;
        for(int i=1;i<str.length();i++)
        {
            if(str.charAt(i)!=ch)
            {
                flag=false;
                break;
            }
        }
        if(flag)
            return 0;
        if(palindrome(str,0))
            return str.length()-1;
        return str.length();
    }
}
