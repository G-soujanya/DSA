class SubStrings 
{
    public static void main(String args[])
    {
        String str="hlllo";
        //subStringSize(str, 3);
        //subStringSizePalindrome(str, 2);
        //printAllSubStrings(str);
        printAllSubStringsPalindrome(str);
    }  
    static void subStringSize(String s,int size)
    {
        for(int i=0;i<=s.length()-size;i++)
        {
            String t="";
            for(int j=i;j<i+size;j++)
            {
                t+=s.charAt(j);
            }
            System.out.println(t);
        }
    }  
    static boolean isPalindrome(String s)
    {
        int i=0,j=s.length()-1;
        while(i<j)
        {
            if(s.charAt(i)==s.charAt(j))
            {
                i++;
                j--;
            }
            else 
                return false;
        }
        return true;
    }
   static void subStringSizePalindrome(String s,int size)
    {
        for(int i=0;i<=s.length()-size;i++)
        {
            String t="";
            for(int j=i;j<i+size;j++)
            {
                t+=s.charAt(j);
            }
            if(isPalindrome(t))
            System.out.println(t);
        }
    }   
    static void printAllSubStrings(String s)
    {
        for(int size=1;size<=s.length();size++){
            subStringSize(s, size);
        }
    }
    static void printAllSubStringsPalindrome(String s)
    {
        for(int size=1;size<=s.length();size++){
            subStringSizePalindrome(s, size);
        }
    }
}
