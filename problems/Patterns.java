class Patterns{
    public static void main(String[] args) {
    //basic(6);
    //basicNum(4);
    //triangle1(4);
    //basciChar(4);
    //basciCharRow(4);
    //basciCharStartRowRev(8);
    //mirrorP1(4);
    //triangleibnverted(4);
    //isosceles(4);
    //isoscelesStars(5);
    //isoscelesStartRow(5);
    //diamond(5);
    //diamondNum(5);
    //parallelogram(5);
    //sumPattern(5);
    oddSquare(5);
    }
    static void basic(int n)
    {
        int i,j;
        for(i=1;i<=n;i++)
        {
            for(j=1;j<=n;j++)
                System.out.print("*"+" ");
            System.out.println();
        }
    }
    static void basicNum(int n)
    {
        int i,j;
        for(i=1;i<=n;i++)
        {
            for(j=4;j>=1;j--)
                System.out.print(j+" ");
            System.out.println();
        }
    }
    static void triangle1(int n)
    {
        int count;
        for(int i=1;i<=n;i++)
        {
            count=i;
            for(int j=1;j<=i;j++)
            {
                System.out.print(count+++" ");
            }
            System.out.println();
        }
    }
    static void basciChar(int n)
    {
        int i,j;
        for(i=1;i<=n;i++)
        {
            for(j=65;j<=64+n;j++)
                System.out.print((char)j+" ");
            System.out.println();
        }
    }
    static void basciCharRow(int n)
    {
        int i,j;
        char c=64;
        for(i=1;i<=n;i++)
        {
            c=(char)(c+1);
            for(j=1;j<=i;j++)
                System.out.print(c+" ");
            System.out.println();
        }
    }
    static void basciCharStartRow(int n)
    {
        int i,j;
        char g='A'-1;
        char c;
        for(i=1;i<=n;i++)
        {
            c=(char)(g+i);
            for(j=1;j<=n;j++)
            {
                System.out.print(c+" ");
                c=(char)(c+1);
            }
            System.out.println();
        }
    }
    static void basciCharStartRowRev(int n)
    {
        int i,j;
        char g='A';
        char c;
        for(i=1;i<=n;i++)
        {
            c=(char)(g+n-i);
            for(j=1;j<=i;j++)
            {
                System.out.print(c+" ");
                c=(char)(c+1);
            }
            System.out.println();
        }
    }
    static void mirrorP1(int n)
    {
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n-i;j++)
            {
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++)
                System.out.print(j);
            System.out.println();
        }
    }
    static void triangleibnverted(int n)
    {
        for(int i=n;i>=1;i--)
        {
            for(int j=1;j<=i;j++)
            {
                System.out.print(n-i+1);
            }
            System.out.println();
        }
    }
    static void isosceles(int n)
    {
        for(int i=1;i<=n;i++)
        {
            for(int spaces=1;spaces<=n-i;spaces++)
            {
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++)
            {
                System.out.print(j);
            }
            for(int j=i-1;j>=1;j--)
                System.out.print(j);
            System.out.println();
        }
    }
    static void isoscelesStars(int n)
    {
        for(int i=1;i<=n;i++)
        {
            for(int spaces=1;spaces<=n-i;spaces++)
            {
                System.out.print(" ");
            }
            for(int j=1;j<=(2*i-1);j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void isoscelesStartRow(int n)
    {
        for(int i=1;i<=n;i++)
        {
            for(int spaces=1;spaces<=n-i;spaces++)
            {
                System.out.print(" ");
                System.out.print(" ");
            }
            int temp=i-1;
            for(int j=i;j<=temp+i;j++)
            {
                System.out.print(j);
            }
            int t=i-1;
            for(int j=t+i-1;j>=i;j--)
                System.out.print(j);
            System.out.println();
        }
    }
    static void diamond(int n)
    {
        for(int i=1;i<=n-(n/2);i++)
        {
            for(int space=1;space<=n-i;space++)
                System.out.print(" ");
            for(int j=1;j<=2*i-1;j++)
                System.out.print("*");
            System.out.println();
        }
        for(int i=n-(n/2)+1;i>=1;i--)
        {
            for(int space=1;space<=n-i;space++)
                System.out.print(" ");
            for(int j=1;j<=2*i-1;j++)
                System.out.print("*");
            System.out.println();
        }
    }
    static void diamondNum(int n)
    {
        System.out.println("*");
        for(int i=1;i<=n;i++)
        {
            System.out.print("*");
            for(int j=1;j<i;j++)
            {
                System.out.print(j);
            }
            for(int j=i;j>=1;j--)
            {
                System.out.print(j);
            }
            System.out.println("*");
        }
        for(int i=n-1;i>=1;i--)
        {
            System.out.print("*");
            for(int j=1;j<i;j++)
            {
                System.out.print(j);
            }
            for(int j=i;j>=1;j--)
            {
                System.out.print(j);
            }
            System.out.println("*");
        }
        System.out.println("*");
    }
    static void parallelogram(int n)
    {
        int space=0;
        for(int i=1;i<=n;i++)
        {
            for(int j=0;j<space;j++)
            {
                System.out.print(' ');
            }
            for(int j=1;j<=n;j++)
                System.out.print("*");
            System.out.println();
            space++;

        }
    }
    static void sumPattern(int n)
    {
        for(int i=1;i<=n;i++)
        {
            int sum=0;
            for(int j=1;j<=i;j++)
            {
                if(j==1)
                    System.out.print(j);
                else 
                    System.out.print("+"+j);
                sum+=j;
            }
            System.out.println("="+sum);
        }
    }
    static void oddSquare(int n)
    {
        int count1=1;
        for(int i=1;i<=n;i++)
        {
            int count2=count1;
            for(int j=1;j<=n;j++)
            {
                System.out.print(count2%(2*n));
                count2+=2;
            }
            count1+=2;
            System.out.println();
        }
    }
}