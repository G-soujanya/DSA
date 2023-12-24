class Test2
{
    public static void main(String args[])
    {
        //numberStarPattern(4);
        probability(3,1);
    }
    static void numberStarPattern(int n)
    {
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(j>=n+2-i)
                    System.out.print("*");
                else
                System.out.print(j);
            }
            for(int j=n;j>=1;j--)
            {
                if(j>=n+2-i)
                    System.out.print("*");
                else
                System.out.print(j);
            }
            System.out.println();
        }
    }
    static int fact(int n)
    {
        int result=1;
        for(int i=1;i<=n;i++)
        {
            result*=i;
        }
        return result;
    }
    //check once
    static void probability(int n,int x)
    {
        int red=(fact(4)/(fact(x)*fact(4-x)));
        int notRed=(fact(4)/(fact(n-x)*fact(4-n+x)));
        float total=((float)fact(8)/(fact(n)*fact(8-n)));
        int favorableOutcomes=(int)((red*notRed/total)*100);
        System.out.println(favorableOutcomes);
    }
}
