// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        numberOfOneBits(13);
        System.out.println(onlyFirstAndLastSet(15));
        numberOfOneBitsUptoValue(7);
    }
    static void numberOfOneBits(int value)
    {
        int count=0;
        while(value>0){
            if((value&1)==1)
                count++;
            value>>=1;
        }
        System.out.println(count);
    }
    static boolean onlyFirstAndLastSet(int value)
    {
        int count=0;
        if((value&1)==1)
        {
            value>>=1;
            while(value>0){
                if((value&1)==1)
                    count++;
                value>>=1;
            }
            if(count==1)
                return true;
        }
        return false;
    }
    static void numberOfOneBitsUptoValue(int n)
    {
        int count=0;
        for(int value=1;value<=n;value++) {
            int value1=value;
            while (value1 > 0) {
                if ((value1 & 1) == 1)
                    count++;
                value1 >>= 1;
            }
        }
        System.out.println(count);
    }
}
