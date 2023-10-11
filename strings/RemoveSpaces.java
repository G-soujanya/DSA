class RemoveSpaces
{
    public static void main(String args[])
    {
        String str="hereiamstackerrnk";
        //System.out.println(trimExtraSpaces(str));
        String k="hackerrank";
        findString(str, k);
    }     
    static String trimExtraSpaces(String s)
    {
        String t="";
        int start=0;
        int last=s.length()-1;
        for(start=0;start<s.length();start++)
        {
            if(s.charAt(start)!=' ')
                break;
        }
        for(;last>=0;last--)
        {
            if(s.charAt(last)!=' ')
                break;
        }
        for(int i=start;i<=last;i++)
        {
            char ch=s.charAt(i);
            if(ch!=' ')
            {
                t+=ch;
            }
            else 
            {
                if(s.charAt(i+1)!=' ')
                {
                    t=t+ch;
                }
            }
        }
        return t;
    } 
    static void findString(String s,String k)
    {
        int i=0;
        int j=0;
        while(i<s.length() && j<k.length())
        {
            if(s.charAt(i)==k.charAt(j))
            {
                i++;
                j++;
            }
            else 
                i++;
        }
        if(j==k.length())
            System.out.println("YES");
        else 
            System.out.println("NO");
    }
}
