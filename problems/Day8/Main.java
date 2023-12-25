import java.util.*;
class Main
{
    public static void main(String[] args) {
        /*int arr[]={900,940,950,1100,1500,1800};
        int dept[]={910,1200,1120,1130,1900,1800};
        int arr[]={900,940};
        int dept[]={910,1200};
        int arr[] = { 100, 300, 500 };
        int dept[] = { 900, 400, 600 };
        System.out.println(noOfPlatforms1(arr, dept));
        int[] arr = { 900, 940, 950, 1100, 1500, 1800 };
        int[] dept = { 910, 1200, 1120, 1130, 1900, 2000 };
         int arr[]={50,120,200,550,700,850};
        int dept[]={500,550,600,700,900,1000};
        System.out.println(noOfPlatforms2(arr, dept));
        int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trapRainWater(arr));
        System.out.println(trapRainWater2(arr));
         System.out.println(trapRainWater3(arr));
        System.out.println(noOfPlatforms3(arr, dept));*/
        // int arr[]={5,20,3,2,50,80};
        int arr[] = {90, 70, 2, 80, 50};
        // findDifferencePairs(arr,78);
        // findDifferencePairs2(arr, 78);
        // findDifferencePairs3(arr, 78);
        // System.out.println(binarySearch(arr, 0, 20));
        // findDifferencePairs4UsingSortingAndSearching(arr, 45);
        findDifferencePairs5UsingSorting(arr, 20);
    }
    public static int noOfPlatforms1(int arr[],int dept[])
    {
        int result=1;
        for(int i=0;i<arr.length;i++)
        {
            int platformsNeeded=1;
            for(int j=0;j<arr.length;j++)
            {
                if(i!=j)
                {
                    if(arr[j]<=arr[i] && arr[i]<=dept[j])
                        platformsNeeded++;
                }
                result=Math.max(result,platformsNeeded);
            }
        }
        return result;
    }
    public static int noOfPlatforms2(int arr[],int dept[])
    {
        Arrays.sort(arr);
        Arrays.sort(dept);
        int i=1,j=0,count=1;
        while(i<arr.length)
        {
            if(dept[j]>=arr[i])
            {
                count++;
                i++;
            }
            else{
                i++;
                j++;
            }
        }
        return count;
    }
    public static int noOfPlatforms3(int arr[],int dept[])
    {
        int maxDeptTime=dept[0];
        for(int i=1;i<dept.length;i++)
        {
            maxDeptTime=Math.max(maxDeptTime,dept[i]);
        }
        ArrayList<Integer> list=new ArrayList<>(maxDeptTime+2);
        for(int i=0;i<maxDeptTime+2;i++)
            list.add(0);
        for(int i=0;i<arr.length;i++)
        {
            list.set(arr[i],list.get(i)+1);
            list.set(dept[i]+1,list.get(dept[i]+1)-1);
        }
        int count=0;
        int platformsNeeded=0;
        for(int x:list)
        {
            count+=x;
            platformsNeeded=Math.max(platformsNeeded,count);
        }
        return platformsNeeded;
    }
    public static int trapRainWater(int arr[])
    {
        int water=0;
        for(int i=0;i<arr.length-1;i++)
        {
            int current=arr[i];
            int leftMax=arr[i];
            for(int j=0;j<i;j++)
            {
                if(arr[j]>leftMax)
                    leftMax=arr[j];
            }
            int rightMax=arr[i];
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[j]>rightMax)
                    rightMax=arr[j];
            }
            water+=Math.min(leftMax,rightMax)-current;
        }
        return water;
    }
    public static int trapRainWater2(int arr[])
    {
        int len=arr.length;
        int leftMaxArr[]=new int[len];
        int rightMaxArr[]=new int[len];
        leftMaxArr[0]=arr[0];
        for(int i=1;i<len;i++)
            leftMaxArr[i]=Math.max(leftMaxArr[i-1],arr[i]);
        rightMaxArr[len-1]=arr[len-1];
        for(int i=len-2;i>=0;i--)
            rightMaxArr[i]=Math.max(rightMaxArr[i+1],arr[i]);
        int water=0;
        for(int i=0;i<len;i++)
        {
            water+=Math.min(leftMaxArr[i],rightMaxArr[i])-arr[i];
        }
        return water;
    }
    public static int trapRainWater3(int arr[])
    {
        int left=0;
        int right=arr.length-1;
        int leftMax=0;
        int rightMax=0;
        int water=0;
        while(left<=right)
        {
            if(rightMax<=leftMax)
            {
                water+=Math.max(0,rightMax-arr[right]);
                rightMax=Math.max(rightMax,arr[right]);
                right-=1;
            }
            else{
                water+=Math.max(0,leftMax-arr[left]);
                leftMax=Math.max(leftMax,arr[left]);
                left+=1;
            }
        }
        return water;
    }
    //From start
    public static void findDifferencePairs(int arr[],int diff)
    {
        // int countPairs=0;
        for(int i=0;i<arr.length-1;i++)
        {
            for(int j=0;j<arr.length;j++)
            {
                if(i!=j)
                {
                int required=Math.abs(arr[i]-arr[j]);
                // if(required==diff)
                //     countPairs++;
                if(required==diff)
                {
                    System.out.println(arr[i]+" "+arr[j]);
                    return;
                }
                }
            }
        }
        // if(countPairs!=0)
        // System.out.println(countPairs);
        // else 
        // System.out.println("No such pair");
        System.out.println("No such pair");
    }
    public static boolean findDifferencePairs2(int arr[],int diff)
    {
        HashSet<Integer> map=new HashSet<>();
        
        for(int i=0;i<arr.length;i++)
        {
            if(map.contains(arr[i]+diff) || map.contains(arr[i]-diff))
            {
                //System.out.println(" pair of this contain"+arr[i]);
                return true;
            }
            map.add(arr[i]);
        }
       // System.out.println("No such Pair");
       return false;
    }
    public static void findDifferencePairs3(int arr[],int diff)
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            map.put(arr[i],map.getOrDefault(arr[i], 0)+1);
            if(diff==0 && map.get(arr[i])>1)
            {
                System.out.println(arr[i]+" "+arr[i]);
                return;
            }
        }
        if(diff==0)
        {
            System.out.println("No such pair");
            return;
        }
        for(int i=0;i<arr.length;i++)
        {
            if(map.containsKey(arr[i]+diff))
            {
                System.out.println(arr[i]+diff+" "+arr[i]);
                return;
            }
        }
        System.out.println("No such pair");
    }
    public static void findDifferencePairs4UsingSortingAndSearching(int arr[],int diff)
    {
        Arrays.sort(arr);//nlogn
        for(int i=0;i<arr.length;i++)//o(n)
        {
            if(binarySearch(arr, i+1, diff+arr[i])!=-1)
            {
                System.out.println(arr[i]+" "+arr[binarySearch(arr, i+1, diff+arr[i])]);//logn
                return;
            }
        }
        System.out.println("No such pair");
    }
    private static int binarySearch(int arr[],int start,int num)
    {
        //Arrays.sort(arr);
        int end=arr.length-1;
        while(start<=end)
        {
            int middle=(start+end)/2;
            if(arr[middle]==num)
                return middle;
            else if(arr[middle]>num)
                end=middle-1;
            else
                start=middle+1;
        }
        return -1;
    }
    public static void findDifferencePairs5UsingSorting(int arr[],int diff)
    {
        Arrays.sort(arr);
        int i=0;
        int j=1;
        while(i<arr.length && j<arr.length)
        {
            if(i!=j && (arr[i]-arr[j])==diff || (arr[j]-arr[i])==diff)
            {
                System.out.println(arr[i]+" "+arr[j]);
                return;
            }
            else if((arr[j]-arr[i])<diff)
            {
                j++;
            }
            else if((arr[i]-arr[j])<diff)
            {
                i++;
            }
        }
        System.out.println("No such pair");
    }
}
