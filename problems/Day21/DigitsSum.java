public class DigitsSum {
    public static void main(String args[])
    {
        digitsSum("",3,6);
    }
    public static void digitsSum(String str,int n,int sum)
    {
        if(n>0 && sum>=0)
        {
            char i='0';
            if(str.equals(""))
                i='1';
            for(;i<='9';i++)
                digitsSum(str+i,n-1,sum-(i-'0'));
        }
        else if(n==0 && sum==0)
            System.out.println(str);
    }
}
