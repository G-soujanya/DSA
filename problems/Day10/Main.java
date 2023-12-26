public static void chocolatedis(int arr[],int m)
    {
        Arrays.sort(arr);
        int minimum=Integer.MAX_VALUE;
        for(int i=0;i<=arr.length-m;i++)
        {
            minimum=Math.min(minimum,arr[i+m-1]-arr[i]);
        }
        System.out.println(minimum);
    }
