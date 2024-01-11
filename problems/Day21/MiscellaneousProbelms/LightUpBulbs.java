public class LightUpBulbs {
    public static void main(String args[])
    {
        lightUpBulbs2("1010",1,10);
    }
    public static void lightUpBulbs(String str,int x,int y)
    {
        int zeroGroups=0;
        for (int i = 0; i < str.length()-1; i++) {
            if(str.charAt(i)=='0' && str.charAt(i+1)=='1')
                zeroGroups++;
        }
        if(str.charAt(str.length()-1)=='1')
            zeroGroups--;
        if(zeroGroups>0)
            System.out.println(zeroGroups*Math.min(x,y)+y);
        else
            System.out.println(0);
    }
    public static void lightUpBulbs2(String str,int x,int y)
    {
        int zeroGroups=0;
//        if(str.charAt(0)=='0')
//            zeroGroups+=1;
        for (int i = 1; i < str.length()-1; i++) {
            if(str.charAt(i)=='1' && str.charAt(i+1)=='0')
                zeroGroups++;
        }
        if(zeroGroups>0)
            System.out.println((zeroGroups)*Math.min(x,y)+y);
        else
            System.out.println(0);
    }
}
