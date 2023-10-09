class Remove
{
    public static void main(String args[])
    {
        String str="Hello@5$WORLD7";
        System.out.println(remSpecialChar(str));
        System.out.println(remSpecialCharAndNumbers(str));
        System.out.println(removeVowels(str));
        System.out.println(removeSpeNumberAddSum(str));
        System.out.println(sepearateAll(str));
    }
    static String remSpecialChar(String s)
    {
        String t="";
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if((ch>='a' &&  ch<='z') || (ch>='A' && ch<='Z') || (ch>='0' && ch<='9'))
                t+=ch;
        }
        return t;
    }
    static String remSpecialCharAndNumbers(String s)
    {
        String t="";
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if((ch>='a' &&  ch<='z') || (ch>='A' && ch<='Z'))
                t+=ch;
        }
        return t;
    }
    static String removeVowels(String s)
    {
        String t="";
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(!(ch=='a'|| ch=='e'|| ch=='i'|| ch=='o'|| ch=='u'|| ch=='A'|| ch=='E'|| ch=='I'|| ch=='O'|| ch=='U'))
                t+=ch;
        }
        return t;
    }
    static String removeSpeNumberAddSum(String s)
    {
        String t="";
        int sum=0;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if((ch>='a' &&  ch<='z') || (ch>='A' && ch<='Z'))
                t+=ch;
            else if(ch>='0' && ch<='9')
                sum+=ch-48;
        }
        if(sum!=0)
        return t+sum;
        else    
        return t;
    }
    static String sepearateAll(String s)
    {
        String uc="",lc="",num="",spc="";
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if((ch>='a' &&  ch<='z'))
                lc+=ch;
            else if(ch>='0' && ch<='9')
                num+=ch;
            else if(ch>='A' && ch<='Z')
                uc+=ch;
            else 
                spc+=ch;
        }
        return uc+lc+num+spc;
    }
}