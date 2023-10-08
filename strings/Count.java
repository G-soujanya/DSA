class Count 
{
    public static void main(String args[])
    {
        String str="   how are u";
        System.out.println(countVowels(str));
        System.out.println(countConsonents(str));
        System.out.println(countNumbers(str));
        System.out.println(countSpecialChar(str));
        System.out.println(countSpaces(str));
        System.out.println(countWords(str));
    }    
    static int countVowels(String s)
    {
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='a' || s.charAt(i)=='e' ||  s.charAt(i)=='i' ||  s.charAt(i)=='o' ||  s.charAt(i)=='u'
             ||  s.charAt(i)=='A' ||  s.charAt(i)=='E' ||  s.charAt(i)=='U' ||  s.charAt(i)=='O' ||  s.charAt(i)=='I')
                count++;
        }
        return count;
    }
    static int countConsonents(String s)
    {
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if((s.charAt(i)>='a' && s.charAt(i)>='z') || (s.charAt(i)>='A' && s.charAt(i)>='Z'))
            {
            if(!(s.charAt(i)=='a' || s.charAt(i)=='e' ||  s.charAt(i)=='i' ||  s.charAt(i)=='o' ||  s.charAt(i)=='u'
             ||  s.charAt(i)=='A' ||  s.charAt(i)=='E' ||  s.charAt(i)=='U' ||  s.charAt(i)=='O' ||  s.charAt(i)=='I'))
                count++;
            }
        }
        return count;
    }
    static int countNumbers(String s)
    {
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)>='0' && s.charAt(i)<='9')
                count++;
        }
        return count;
    }
    static int countSpecialChar(String s)
    {
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if(!((s.charAt(i)>='0' && s.charAt(i)<='9') || (s.charAt(i)>='a' && s.charAt(i)<='z') || (s.charAt(i)>='A' && s.charAt(i)<='Z')))
                count++;
        }
        return count;
    }
    static int countSpaces(String s)
    {
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==' ')
            count++;
        }
        return count;
    }
    static int countWords(String s)
    {
        int count=0;
        int i;
        for(i=0;i<s.length()-1;i++)
        {
            if(s.charAt(i)==' ' && s.charAt(i+1)!=' ')
            count++;
        }
        if(s.charAt(0)==' ')
        return count;
        else 
        return count+1;
    }
}
