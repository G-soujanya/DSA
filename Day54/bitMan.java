// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
       //decimalToBinary(10);
       // binaryToDecimal("101");
        //setBitAtPos(5,1);
        //unsetBitAtPos(11,1);
        toggleBitPos(11,2);
    }
    static void decimalToBinary(int x)
    {
        String res="";
        while (x>0)
        {
            int rem=x%2;
            res=rem+res;
            x=x/2;
        }
        System.out.println(res);
    }
    static void binaryToDecimal(String x)
    {
        int res=0;
        int base=1;
        for(int i=x.length()-1;i>=0;i--)
        {
            if(x.charAt(i)=='1') {
                res = res + base;
            }
            base*=2;
        }
        System.out.println(res);
    }
    static void setBitAtPos(int value,int pos)
    {
        int mask=1<<pos;
        int res=value|mask;
        System.out.println(res);
    }
    static void unsetBitAtPos(int value,int pos)
    {
        int mask=~(1<<pos);
        int res=value&mask;
        System.out.println(res);
    }
    static void toggleBitPos(int value,int pos)
    {
        int mask=1<<pos;
        int res=value^mask;
        System.out.println(res);
    }
}
