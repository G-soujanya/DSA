public static boolean checkAB(String str)
    {
        if(str.isEmpty())
            return true;
        if(str.charAt(0)=='a')
        {
            if(str.substring(1).length()>1 && str.substring(1,3).equals("bb"))
                return checkAB(str.substring(3));
            return checkAB(str.substring(1));
        }
        return false;
    }
    public static int staireCase(int n)
    {
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        if(n==3)
            return 4;
        return staireCase(n-1)+staireCase(n-2)+staireCase(n-3);
    }
    public static int stairCase(int n)
    {
        if(n<0)
            return 0;
        if(n==0)
            return 1;
        return stairCase(n-1)+stairCase(n-2)+stairCase(n-3);
    }
    public static int binarySearch(int arr[],int start,int end,int num)
    {
        if(start>end)
            return -1;
        int mid=(start+end)/2;
        if(num==arr[mid])
            return mid;
        if(num>arr[mid])
            return binarySearch(arr,mid+1,end,num);
        return binarySearch(arr,start,mid-1,num);
    }
    public static int[][] subSetsOfArray(int arr[],int startIndex)
    {
        if(arr.length==startIndex)
        {
            int[][] output=new int[1][0];
            return output;
        }
        int[][] smallAns=subSetsOfArray(arr,startIndex+1);
        int[][] newOutput=new int[smallAns.length*2][];
        int k=0;
        for(int i=0;i<smallAns.length;i++)
        {
            newOutput[k]=new int[smallAns[i].length];
            for(int j=0;j<smallAns[i].length;j++)
            {
                newOutput[k][j]= smallAns[i][j];
            }
            k++;
        }
        for(int i=0;i<smallAns.length;i++)
        {
            newOutput[k]=new int[smallAns[i].length+1];
            newOutput[k][0]=arr[startIndex];
            for(int j=0;j<smallAns[i].length;j++)
            {
                newOutput[k][j+1]= smallAns[i][j];
            }
            k++;
        }
        return newOutput;
    }
