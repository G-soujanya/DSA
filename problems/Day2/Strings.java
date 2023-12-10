

class Strings 
{
    public static void main(String args[])
    {
        //countWords("hello all good evening");
        //reverse2("abcde");
        //palindrome2("abba");
        //subString("abcd");
        //reverseEachWord("hello ama string");
        //reverseEachWord2("hello ama soujanya");
        //reverseEachWordWise2("welcome to coding ninjas");
        //System.out.println(checkPermutations("abcde", "edcb")); will not work for all cases
        //System.out.println(checkPermutations2("abcda", "adcba"));
       // System.out.println(removeConscDuplicates("xxyyzxx"));
       //reverseEachWord2("Always indent your code");
       //System.out.println(removeChar("xxyyzxx", 'a'));
    //    System.out.println(highestOccuChar("xy"));
    //System.out.println(highestOccuChar("abdefbabfba"));
    System.out.println(compress("aaabbcddeeeee"));
    }
    static void countWords(String str)
    {
        int spaces=0;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)==' ')
                spaces++;
        }
        System.out.println(spaces+1);
    }
    static void reverse(String str)
    {
        String reversedString="";
        for(int i=str.length()-1;i>=0;i--)
        {
            reversedString+=str.charAt(i);
        }
        System.out.println(reversedString);
    }
    static void reverse2(String str)
    {
        String reversedString="";
        for(int i=0;i<str.length();i++)
        {
            reversedString=str.charAt(i)+reversedString;
        }
        System.out.println(reversedString);
    }
    static void palindrome(String str)
    {
        String reversedString="";
        for(int i=0;i<str.length();i++)
        {
            reversedString=str.charAt(i)+reversedString;
        }
        if(str.equals(reversedString))
            System.out.println("palindrome");
        else 
            System.out.println("not a palindrome");
    }
    static void palindrome2(String str)
    {
        int start=0;
        int end=str.length()-1;
        boolean isPlalindrome=true;
        while(start<end)
        {
            if(str.charAt(start)!=str.charAt(end))
                isPlalindrome=false;
            start++;
            end--;
        }
        if(isPlalindrome)
            System.out.println("palindrome");
        else 
            System.out.println("not palindrome");
    }
    static void subStrings(String str)
    {
        for(int i=0;i<str.length();i++)
        {
            for(int j=i;j<str.length();j++)
            {
                for(int k=i;k<=j;k++)
                    System.out.print(str.charAt(k));
                System.out.println();
            }
        }
    }
    static void subString(String str)
    {
        for(int len=1;len<str.length();len++)
        {
            for(int start=0;start<=str.length()-len;start++)
            {
                int end=start+len-1;
                System.out.println(str.substring(start, end+1));
            }
        }
    }
    static void reverseEachWord(String str)
    {
        String[] st=str.split(" ");
        for(int i=0;i<st.length;i++)
        {
            String word=st[i];
            String rev="";
            for(int j=0;j<word.length();j++)
            {
                rev=word.charAt(j)+rev;
            }
            st[i]=rev;
        }
        String newString="";
        for(int i=0;i<st.length;i++)
        {
            newString+=st[i]+" ";
        }
        System.out.println(newString);
    }
    static void reverseEachWord2(String str)
    {
        String result="";
        int currentWordStart=0;
        int currentWordEnd=0;
        int i=0;
        String revWord="";
        for(;i<str.length();i++)
        {
            if(str.charAt(i)==' ')
            {
                revWord="";
                currentWordEnd=i-1;
                for(int j=currentWordStart;j<=currentWordEnd;j++)
                {
                    revWord=str.charAt(j)+revWord;
                }
                result+=revWord+" ";
                currentWordStart=i+1;
            }
        }
        currentWordEnd=i-1;
        revWord=" ";
        for(int j=currentWordStart;j<=currentWordEnd;j++)
        {
            revWord=str.charAt(j)+revWord;
        }
        result=result+" "+revWord;
        System.out.println(result);
    }
    static void reverseEachWordWise(String str)
    {
        String result="";
        int currentWordStart=0;
        int currentWordEnd=str.length()-1;
        int i=str.length()-1;
        String revWord="";
        for(;i>=0;i--)
        {
            if(str.charAt(i)==' ')
            {
                revWord="";
                currentWordStart=i+1;
                for(int j=currentWordStart;j<=currentWordEnd;j++)
                {
                    revWord=revWord+str.charAt(j);
                }
                result+=revWord+" ";
                currentWordEnd=i-1;
            }
        }
        currentWordStart=i+1;
        revWord=" ";
        for(int j=currentWordStart;j<=currentWordEnd;j++)
        {
            revWord=revWord+str.charAt(j);
        }
        result=result+" "+revWord;
        System.out.println(result);
    }
    static void reverseEachWordWise2(String str)
    {
        String reversedString="";
        for(int i=str.length()-1;i>=0;i--)
        {
            reversedString+=str.charAt(i);
        }
        reverseEachWord(reversedString);
    }
    //will not work for all cases
    static boolean checkPermutations(String str1,String str2)
    {
        int len1=str1.length();
        int len2=str2.length();
        if(len1!=len2)
            return false;
        for(int i=0;i<len1;i++)
        {
            boolean isPresent=false;
            for(int j=0;j<len2;j++)
            {
                if(str1.charAt(i)==str2.charAt(j))
                    isPresent=true;
            }
            if(isPresent)
                return true;
            return false;
        }
        return false;
    }
    static boolean checkPermutations2(String str1,String str2)
    {
        if(str1.length()!=str2.length())
            return false;
        int[] str1FreArray=new int[256];
        for(int i=0;i<str1.length();i++)
        {
            str1FreArray[(int)str1.charAt(i)]+=1;
        }
        for(int i=0;i<str2.length();i++)
        {
            str1FreArray[(int)str2.charAt(i)]-=1;
        }
        for(int i=0;i<=255;i++)
        {
            if(str1FreArray[i]!=0)
            {
                return false;
            }
        }
        return true;
    }
    static String removeConscDuplicates(String str)
    {
        if(str.length()==0)
            return "";
        String result="";//aabbcc
        for(int i=0;i<str.length()-1;i++)//0-5
        {
            if(str.charAt(i)==str.charAt(i+1))//a==a a==b b==b b==c c==
                continue;
            else 
                result=result+str.charAt(i);//result=ab 
        }
        if(str.charAt(str.length()-2)!=str.charAt(str.length()-1))
            result+=str.charAt(str.length()-2);
        return result+str.charAt(str.length()-1);
    }
    static String removeChar(String str,char ch)
    {
        String result="";
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)!=ch)
                result+=str.charAt(i);
        }
        return result;
    }
    static char highestOccuChar(String str)
    {
        if(str.length()==0)
            return ' ';
        int max=0;
        char ch=str.charAt(0);
        for(int i=0;i<str.length();i++)
        {
            int count=0;
            for(int j=0;j<str.length();j++)
            {
                if(str.charAt(j)==str.charAt(i))
                    count++;
            }
            if(count>max)
            {
                max=count;
                ch=str.charAt(i);
            }
        }
        return ch;
    }
    static char highestOccuChar2(String str)
    {
        int frequency[]=new int[256];
        int max=0;
        for(int i=0;i<str.length();i++)
        {
            frequency[(int)str.charAt(i)]+=1;
            max=Math.max(max,frequency[(int)str.charAt(i)]);
        }
        for(int i=0;i<=255;i++)
        {
            if(frequency[i]==max)
                return (char)i;
        }
        return ' ';
    }
    static String compress(String str)
    {
        if(str.length()==0)
            return "";
        String result="";//aabbcc
        int count=1;
        for(int i=0;i<str.length()-1;i++)//0-5
        {
            if(str.charAt(i)==str.charAt(i+1))//a==a a==b b==b b==c c==
                count++;
            else if(count!=1)
            {
                result=result+str.charAt(i)+count;
                count=1;
            }
            else 
                result+=str.charAt(i);
        }
        // if(str.charAt(str.length()-2)!=str.charAt(str.length()-1))
        //     result+=str.charAt(str.length()-2);
        if(count>1)
        return result+str.charAt(str.length()-1)+count;
        return result+str.charAt(str.length()-1);

    }
}