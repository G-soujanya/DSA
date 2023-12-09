class Arrays
{
    public static void main(String[] args) {
        /*int arr[]={1,2,3,4,5};
        swapAlternative(arr);*/
        //int arr[]={1,2,3,4,5,9,10,10};
        //findUnique2(arr);
        //findduplicate2(arr);
        //int[] arr1={1,2,3,4,5,10};
        //int[] arr2={1,2,3,6,7,10};
        //intersection(arr1, arr2);
        //int[] arr={1,2,3,4,5,6,7};
        //tripletSum(arr,12);
        int arr[]={0,0,1,1,0};
        sort012(arr);
    }
    static void arrange(int n)
    {
        int odd=1;
        int arr[]=new int[n];
        for(int i=0;i<=(n-1)/2;i++)
        {
            arr[i]=odd;
            odd+=2;
        }
        int even;
        if(n%2==0)
            even=n;
        else
            even=n-1;
        for(int i=((n-1)/2)+1;i<n;i++)
        {
            arr[i]=even;
            even-=2;
        }
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    static void arrange2(int n)
    {
        int arr[]=new int[n];
        int start=0;
        int end=n-1;
        int count=1;
        while(start<=end)
        {
            if(count%2==1)
            {
            arr[start]=count++;
            start++;
            }
            else 
            {
            arr[end]=count++;
            end--;}
        }
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    static void swapAlternative(int arr[])
    {
        int n=arr.length;
        for(int i=0;i<n-1;i+=2)
        {
            int temp=arr[i];
            arr[i]=arr[i+1];
            arr[i+1]=temp;
        }
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    static void findUnique(int arr[])
    {
        int sum=0;
        for(int i=0;i<arr.length;i++)
        {
            sum^=arr[i];
        }
        System.out.println(sum);
    }
    static void findUnique2(int arr[])
    {
        int j,i;
        for(i=0;i<arr.length;i++)
        {
            for(j=0;j<arr.length;j++)
            {
                if(i!=j)
                {
                    if(arr[i]==arr[j])
                    {
                        break;
                    }
                }
            }
            if(j==arr.length)
                break;

        }
        System.out.println(arr[i]);
    }
    static void findduplicate(int arr[])
    {
        int j,i;
        boolean flag=false;
        for(i=0;i<arr.length;i++)
        {
            for(j=0;j<arr.length;j++)
            {
                if(i!=j)
                {
                    if(arr[i]==arr[j])
                    {
                        System.out.println(arr[i]);
                        flag=true;
                        break;
                    }
                }
            }
            if(flag)
                break;

        }
    }
    static void findduplicate2(int arr[])
    {
        int j,i;
        boolean flag=false;
        for(i=0;i<arr.length;i++)
        {
            for(j=i+1;j<arr.length;j++)
            {
                    if(arr[i]==arr[j])
                    {
                        System.out.println(arr[i]);
                        flag=true;
                        break;
                    }
                
            }
            if(flag)
                break;
        }
    }
    static void intersection(int arr1[],int arr2[])
    {
        for(int i=0;i<arr1.length;i++)
        {
            for(int j=0;j<arr2.length;j++)
            {
                if(arr1[i]==arr2[j])
                {
                    System.out.print(arr1[i]+" ");
                    break;
                }
            }
        }
        System.out.println();
    }
    static void pairSum(int arr[],int target)
    {
        int count=0;
        for(int i=0;i<arr.length;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[i]+arr[j]==target)
                    count++;
            }
        }
        System.out.println(count);
    }
    static void tripletSum(int arr[],int target)
    {
        int count=0;
        for(int i=0;i<arr.length;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                for(int k=j+1;k<arr.length;k++)
                {
                    if(arr[i]+arr[j]+arr[k]==target)
                        count+=1;
                }
            }
        }
        System.out.println(count);
    }
    static void sort01(int arr[])
    {
        int count=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==1)
                count++;
        }
        int temp=count;
        for(int i=arr.length-1;count-->0;i--)
        {
            arr[i]=1;
        }
        for(int i=0;i<arr.length-temp;i++)
            arr[i]=0;
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    static void sort012(int arr[])
    {
        int i=0;
        int j=arr.length-1;
        while(i<j)
        {
            while(arr[i]==0)
                i++;
            while(arr[j]==1)
                j--;
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
        for(int k=0;k<arr.length;k++)
        {
            System.out.print(arr[k]+" ");
        }
        System.out.println();
    }
}
