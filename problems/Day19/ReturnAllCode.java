public class ReturnAllCode {
    public static void main(String args[])
    {
        String strArray[]=returnAllCodes("1123");
        for(String x:strArray)
            System.out.println(x);
    }
    public static String[] returnAllCodes(String str)
    {
        if(str.isEmpty())
        {
            String[] o={""};
             return o;
        }
        String output1[]=returnAllCodes(str.substring(1));
        String output2[]=new String[0];
        char firstChar=(char)(str.charAt(0)-'0'+'a'-1);
        if(str.length()>1)
        {
	    int twoDigitsValue=(str.charAt(0)-'0')*10+(str.charAt(1)-'0');
	    if(twoDigitsValue>10 && twoDigitsValue<=26)
            output2=returnAllCodes(str.substring(2));
        }
        String newOutput[]=new String[output2.length+output1.length];
        int index=0;
        for(String x:output1)
        {
            newOutput[index++]=firstChar+x;
        }
        for(String x:output2)
            newOutput[index++]=(char)(((str.charAt(0)-'0')*10+(str.charAt(1)-'0'))+'a'-1)+x;
        return newOutput;
    }
}
