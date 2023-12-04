class arrays
{
    public static void main(String args[])
    {
        int a[]={1,2,3,4,10};
        //numberOfElements(a);
        //numberOfNonZeroElements(a);
        //evenAndOdd(a);
        //largest(a);
        //samllest(a);
        //sum(a);
        //product(a);
        //sumEven(a);
        //sumOdd(a);
        //diffSESD(a);
        //secLargest(a);
        //indexOf(a, 4);
        //sort(a);
        //sortDesc(a);
        //copy(a);
        //copySquares(a);
        //largestNumIndex(a);
        //smallestNumIndex(a);
        //rev(a);
        //sumDia();
        //largestInMatrix();
        //add();
        //transpose();
        //int b[]={3,4,5,6};
        //merge(a, b);
        indexOfInSorted(a, 5);
    }
    static void numberOfElements(int a[])
    {
        System.out.println(a.length);
    }
    static void numberOfNonZeroElements(int a[])
    {
        int count=0;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]>0)
                count++;
        }
        System.out.println(count);
    }
    static void evenAndOdd(int a[])
    {
        int countEven=0;
        int countOdd=0;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]%2==0)
                countEven++;
            else 
                countOdd++;
        }
        System.out.println(countEven+" "+countOdd);
    }
    static void largest(int a[])
    {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]>max)
                max=a[i];
        }
        System.out.println(max);
    }
    static void samllest(int a[])
    {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]<min)
                min=a[i];
        }
        System.out.println(min);
    }
    static void sum(int a[])
    {
        int sum=0;
        for(int i=0;i<a.length;i++)
        {
            sum+=a[i];
        }
        System.out.println(sum);
    }
    static void product(int a[])
    {
        int p=1;
        for(int i=0;i<a.length;i++)
        {
            p*=a[i];
        }
        System.out.println(p);
    }
    static void sumEven(int a[])
    {
        int count=0;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]%2==0)
                count+=a[i];
        }
        System.out.println(count);
    }
    static void sumOdd(int a[])
    {
        int count=0;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]%2==1)
                count+=a[i];
        }
        System.out.println(count);
    }
    static void diffSESD(int a[])
    {
        int sumEven=0;
        int sumOdd=0;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]%2==0)
                sumEven+=a[i];
            else 
                sumOdd+=a[i];
        }
        System.out.println(Math.abs(sumEven-sumOdd));
    }
    static void secLargest(int a[])
    {
        int max=Integer.MIN_VALUE;
        int secMax=Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]>max)
            {
                secMax=max;
                max=a[i];
            }
            else if(a[i]>secMax)
                secMax=a[i];
        }
        System.out.println(secMax);
    }
    static void indexOf(int a[],int element)
    {
        for(int i=0;i<a.length;i++)
        {
            if(a[i]==element)
            {
                System.out.println(i);
                break;
            }
        }
    }
    static void sort(int a[])
    {
        for(int i=0;i<a.length;i++)
        {
            int min=Integer.MAX_VALUE;
            int index=i;
            for(int j=i;j<a.length;j++)
            {
                if(a[j]<min)
                {
                    min=a[j];
                    index=j;
                }
            }
            int temp=a[i];
            a[i]=a[index];
            a[index]=temp;
        }
        for(int i=0;i<a.length;i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    static void sortDesc(int a[])
    {
        for(int i=0;i<a.length;i++)
        {
            int max=Integer.MIN_VALUE;
            int index=i;
            for(int j=i;j<a.length;j++)
            {
                if(a[j]>max)
                {
                    max=a[j];
                    index=j;
                }
            }
            int temp=a[i];
            a[i]=a[index];
            a[index]=temp;
        }
        for(int i=0;i<a.length;i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    static void merge(int a[],int b[])//{1,2,3,4} {3,4,5,6};
    {
        int m[]=new int[a.length+b.length];
        for(int i=0;i<a.length;i++)
        {
            m[i]=a[i];
        }
        for(int i=0;i<b.length;i++)
        {
            m[a.length+i]=b[i];
        }
        for(int j=0;j<m.length;j++)
        {
            System.out.print(m[j]+" ");
        }
        System.out.println();
    }
    static void copy(int a[])
    {
        int b[]=new int[a.length];
        for(int i=0;i<a.length;i++)
        {
            b[i]=a[i];
        }
        for(int i=0;i<b.length;i++)
        {
            System.out.print(b[i]+" ");
        }
        System.out.println();
    }
    static void copySquares(int a[])
    {
        int b[]=new int[a.length];
        for(int i=0;i<a.length;i++)
        {
            b[i]=a[i]*a[i];
        }
        for(int i=0;i<b.length;i++)
        {
            System.out.print(b[i]+" ");
        }
        System.out.println();
    }
    static void largestNumIndex(int a[])
    {
        int max=Integer.MIN_VALUE;
        int index=-1;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]>max)
            {
                max=a[i];
                index=i;
            }
        }
        System.out.println(max+"having index"+index);
    }
    static void smallestNumIndex(int a[])
    {
        int min=Integer.MAX_VALUE;
        int index=-1;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]<min)
            {
                min=a[i];
                index=i;
            }
        }
        System.out.println(min+" having index of "+index);
    }
    static void rev(int a[])
    {
        int rev[]=new int[a.length];
        int j=0;
        for(int i=a.length-1;i>=0;i--)
        {
            rev[j++]=a[i];
        }
        for(int i=0;i<rev.length;i++)
        {
            System.out.print(rev[i]+" ");
        }
        System.out.println();
    }
    static void sumDia( )
    {
        int b[][]={{1,2,3,4},{5,6,7,8},{2,3,20,5},{4,5,6,7}};
        int sum=0;
        for(int i=0;i<4;i++)
        {
            for(int j=i;j<4;j++)
            {
                if(i==j)
                    sum+=b[j][j];
            }
        }
        System.out.println(sum);
    }
    static void largestInMatrix()
    {
        int b[][]={{1,2,30,4},{5,6,7,8},{2,3,20,5},{4,5,6,7}};
        int max=Integer.MIN_VALUE;
        for(int i=0;i<4;i++)
        {
            for(int j=i;j<4;j++)
            {
                if(b[i][j]>max)
                    max=b[i][j];
            }
        }
        System.out.println(max);
    }
    static void transpose()
    {
        int a[][]={{1,2,3},{3,4,5},{6,7,8}};
        int transpose[][]=new int[3][3];
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                transpose[i][j]=a[j][i];
            }
        }
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(transpose[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void add()
    {
        int a[][]={{1,2,3},{3,4,5},{6,7,8}};
        int b[][]={{1,2,3},{3,4,5},{6,7,8}};
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                a[i][j]+=b[i][j];
            }
        }
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void indexOfInSorted(int a[],int ele)
    {
        for(int i=0;i<a.length;i++)
        {
            if(a[i]==ele)
            {
                System.out.println("index"+i);
                break;
            }
            else if(a[i]>ele)
            {
                System.out.println("element is not present in the array");
            }
        }
    }
}
