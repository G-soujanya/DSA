// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//        increasingOrder("",2,'0');
        increasingOrder2(2,1,0);
    }
    public static void increasingOrder(String str,int noOfDigits,char in)
    {
        if(noOfDigits==0)
        {
            System.out.println(str);
            return;
        }
        if(str.isEmpty())
            in=(char)(in+1);
        for (char i=in; i <='9'; i++) {
            increasingOrder(str+i,noOfDigits-1,(char)(i+1));
        }
    }
    public static void increasingOrder2(int noOfDigits,int startIndex,int numSoFar)
    {
        if(noOfDigits==0)
        {
            System.out.println(numSoFar);
            return;
        }
        for (int i = startIndex; i <=9 ; i++) {
            increasingOrder2(noOfDigits-1,i+1,numSoFar*10+i);
        }
    }
}
