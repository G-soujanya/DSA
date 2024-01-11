public class WinningStrategy {
    public static void main(String args[])
    {
        int arr[]={2,5,1,3,4};
        winningStrategy(arr);
    }
    public static void winningStrategy(int arr[])
    {
       int swaps;
       int totalSwaps=0;
       boolean isValid=true;
       int i=0;
        for (; i < arr.length; i++) {
            swaps=0;
            if(i+1!=arr[i])
            {
                swaps+=arr[i]-(i+1);
                if(swaps>2 ) {
                    isValid=false;
                    break;
                }
                else if(swaps>0)
                    totalSwaps+=swaps;
            }
        }
        if(!isValid)
            System.out.println("NO");
        else
            System.out.println("YES"+" "+totalSwaps);
    }
}
