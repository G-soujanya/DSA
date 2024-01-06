public class PrintAllCodes {
    public static void main(String agrs[])
    {
        printAllCodes("123","");
    }
    public static void printAllCodes(String str,String outputSoFar)
    {
        if(str.isEmpty())
        {
            System.out.println(outputSoFar);
            return;
        }
        char firstChar=(char)(str.charAt(0)-'0'+'a'-1);
        printAllCodes(str.substring(1),outputSoFar+firstChar);
        if(str.length()>1)
        {
            char twoDigitsChar=(char)((str.charAt(0)-'0')*10+(str.charAt(1)-'0')+'a'-1);
	    int twoDigitsValue=(str.charAt(0)-'0')*10+(str.charAt(1)-'0');
	    if(twoDigitsValue>10 && twoDigitsValue<=26)
            printAllCodes(str.substring(2),outputSoFar+twoDigitsChar);
        }
    }
}
