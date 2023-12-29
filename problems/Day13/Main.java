static void trapRainWater(int arr[])
    {
        int water=0;
        int len=arr.length;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<len;i++)
        {
            while(!stack.isEmpty() && arr[stack.peek()]<arr[i]) {
                int pop_height = arr[stack.pop()];
                if(stack.isEmpty())
                    break;
                int distance = i - stack.peek() - 1;
                int min_height = Math.min(arr[stack.peek()], arr[i]) - pop_height;
                water += min_height * distance;
            }
            stack.push(i);
        }
        System.out.println(water);
    }
    static void trapRainWater2(int arr[])
    {
        int num_blocks=0;
        int max_height=Integer.MIN_VALUE;
        int total=0;
        int left=0,right=arr.length-1;
        for(int i=0;i<arr.length;i++)
        {
            max_height=Math.max(max_height,arr[i]);
            num_blocks+=arr[i];
        }
        for(int i=1;i<=max_height;i++)
        {
            while (arr[left]<i)
                left++;
            while (arr[right]<i)
                right--;
            total+=(right-left+1);
        }
        total-=num_blocks;
        System.out.println(total);
    }
    public static void threeWayPartitionOfArray(int arr[],int low,int high)
    {
        int left=0;
        int right=arr.length-1;
        for(int i=0;i<right;)
        {
            if(arr[i]<low) {
                int temp = arr[i];
                arr[i] = arr[left];
                arr[left] = temp;
                left++;
                i++;
            }
            else if(arr[i]>high)
            {
                int temp=arr[i];
                arr[i]=arr[right];
                arr[right]=temp;
                right--;
            }
            else
                i++;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void nextPermutation(int arr[])
    {
        int index=-1;
        int len=arr.length;
        for(int i=len-2;i>=0;i--)
        {
            if(arr[i]<arr[i+1])
            {
                index=i;
                break;
            }
        }
        if(index==-1) {
            System.out.println(Arrays.toString(arr));
            reverse(arr, 0, len - 1);
            return;
        }
        int immediateNextMaxIndex=len-1;
        while (immediateNextMaxIndex>index)
        {
            if(arr[immediateNextMaxIndex]>arr[index])
                break;
            immediateNextMaxIndex--;
        }
        int temp=arr[immediateNextMaxIndex];
        arr[immediateNextMaxIndex]=arr[index];
        arr[index]=temp;
        reverse(arr,index+1,len-1);
        System.out.println(Arrays.toString(arr));
    }
    private static void reverse(int arr[],int start,int end)
    {
        while(start<end)
        {
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
