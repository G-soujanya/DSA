public class WinningLottery {
    public static void main(String args[])
    {

    winningLottery(7 ,37,0,0);
    }
    public static void winningLottery(int noOfDigits,int sum,int minNum,int digitsAdded)
    {
        if(noOfDigits==1 && sum==1) {
            minNum += (int) Math.pow(10, digitsAdded);
            System.out.println(minNum);
            return;
        }
        if(noOfDigits==1)
        {
            minNum +=sum* (int) Math.pow(10, digitsAdded);
            System.out.println(minNum);
            return;
        }
        if(sum==1)
            winningLottery(noOfDigits-1,sum,minNum,digitsAdded+1);
        else {
            if (sum <= 9) {
                winningLottery(noOfDigits - 1, sum - (sum-1), minNum*10+(sum-1), digitsAdded + 1);
            } else {
                winningLottery(noOfDigits - 1, sum -9, minNum*10+(9), digitsAdded + 1);
            }
        }
    }
}
