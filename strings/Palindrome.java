class Palindrome 
{
    public static void main(String args[])
    {
        String str="makayalam";
        int i=0;
        int j=str.length()-1;
        boolean palindrome=true;
        while(i<j)
        {
            if(str.charAt(i)!=str.charAt(j))
                palindrome=false;
            i++;
            j--;
        }
        System.out.println(palindrome);
    }
}
