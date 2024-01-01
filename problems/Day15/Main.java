// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println(removeDuplicates1("xxxyyyzwwzzz"));
    }
    public static String removeX(String str,int startIndex,String t)
    {
        if(startIndex==str.length())
            return t;
        if(str.charAt(startIndex)!='x')
            t+=str.charAt(startIndex);
        return removeX(str,startIndex+1,t);
    }
    private static String removeX(String str)
    {
        return removeX(str,0,"");
    }
    public static String removeX1(String str)
    {
        if(str.length()==0)
            return "";
        String ans="";
        if(str.charAt(0)!='x')
            ans+=str.charAt(0);
        String small=removeX1(str.substring(1));
        return ans+small;
    }

    public static String replaceChar(String str,char c1,char c2)
    {
        if(str.isEmpty())
            return "";
        String ans="";
        if(str.charAt(0)==c1)
            ans+=c2;
        else
            ans+=str.charAt(0);
        String small=replaceChar(str.substring(1),c1,c2);
        return ans+small;
    }
    public  static String replaceChar1(String str,int startIndex,char c1,char c2,String t)
    {
        if(startIndex==str.length())
            return t;
        if(str.charAt(startIndex)==c1)
            t+=c2;
        else
            t+=str.charAt(startIndex);
        return replaceChar1(str,startIndex+1,c1,c2,t);
    }
    private static String replaceChar1(String str,char c1,char c2)
    {
        return replaceChar1(str,0,c1,c2,"");
    }
    private static String removeDuplicates(String str,int startIndex,String t)
    {
        if(startIndex==str.length()-1) {
            t+=str.charAt(str.length()-1);
            return t;
        }
        if(str.charAt(startIndex)!=str.charAt(startIndex+1))
            t+=str.charAt(startIndex);
        return  removeDuplicates(str,startIndex+1,t);
    }
    public static  String removeDuplicates(String str)
    {
        return removeDuplicates(str,0,"");
    }
    public static String removeDuplicates1(String str)
    {
        if(str.isEmpty())
            return "";
        if(str.length()==1)
        {
            return ""+str.charAt(0);
        }
        String ans="";
        if(str.charAt(0)!=str.charAt(1))
            ans+=str.charAt(0);
        String small=removeDuplicates1(str.substring(1));
        return ans+small;
    }
}
