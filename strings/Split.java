class Split
{
    public static void main(String args[])
    {
        String str="india is my country";
        //System.out.println(countWord(str));
        String splitedWord[]=split(str);
        for(int i=0;i<splitedWord.length;i++)
        {
            System.out.print(splitedWord[i]+" ");
        }
        System.out.println();
        System.out.println("In reverse order");
        for(int i=splitedWord.length-1;i>=0;i--)
        {
            System.out.print(splitedWord[i]+" ");
        }
        System.out.println();
        System.out.println("In reverse order and reversing words");
        for(int i=splitedWord.length-1;i>=0;i--)
        {
            System.out.print(reverse(splitedWord[i])+" ");
        }
        System.out.println();
        System.out.println("concatinating string along with word");
        for(int i=0;i<splitedWord.length;i++)
        {
            System.out.print(splitedWord[i]+splitedWord[i].length()+" ");
        }
        System.out.println();
        System.out.println("printing reverse of pairs");
        if(splitedWord.length%2==0)
        {
            for(int i=0;i<splitedWord.length;i=i+2)
            {
                System.out.print(splitedWord[i+1]+" "+splitedWord[i]+" ");
            }
            System.out.println();
        }
        else 
        {
            int i=0;
            for(;i<splitedWord.length-1;i=i+2)
            {
                System.out.print(splitedWord[i+1]+" "+splitedWord[i]+" ");
            }
            System.out.print(splitedWord[i]);
            System.out.println();
        }
        System.out.println("combaining first and last....");
        for(int i=0,j=splitedWord.length-1;i<j;i++,j--)
        {
            System.out.print(splitedWord[i]+splitedWord[j]+" ");
        }
        System.out.println();
        System.out.println("combaining last and and....");
        for(int i=0,j=splitedWord.length-1;i<j;i++,j--)
        {
            System.out.print(splitedWord[j]+splitedWord[i]+" ");
        }
        System.out.println();
        System.out.println("reverse first word andcombaining first and last....");
        for(int i=0,j=splitedWord.length-1;i<j;i++,j--)
        {
            System.out.print(reverse(splitedWord[j])+splitedWord[i]+" ");
        }
        System.out.println();
    }
    static int countWord(String s)
    {
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==' ')
                count++;
        }
        if(s.charAt(0)==' ')
        return count;
        else 
        return count+1;
    }
    static String[] split(String s)
    {
        int countWords=countWord(s);
        String[] ar=new String[countWords];
        String t="";
        int j=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)!=' ')
                t+=s.charAt(i);
            else if(t.length()>1)
            {
                ar[j]=t;
                j++;
                t="";
            }
        }
        ar[j]=t;
        return ar;
    }
    static String reverse(String s)
    {
        String t="";
        for(int i=s.length()-1;i>=0;i--)
        {
            t=t+s.charAt(i);
        }
        return t;
    }
}