//Assignment
    public static String replacePi(String str) {
        if (str.length() == 1)
            return str.charAt(0) + "";
        if (str.length() < 1)
            return "";
        if (str.charAt(0) == 'p' && str.charAt(1) == 'i')
            return "3.14" + replacePi(str.substring(2));
        else
            return str.charAt(0) + replacePi(str.substring(1));
    }

    public static String replacePi2(String str) {
        if (str.length() <= 1)
            return str;
        String small = replacePi2(str.substring(1));
        if (str.charAt(0) == 'p' & small.charAt(0) == 'i')
            return "3.14" + small.substring(1);
        else
            return str.charAt(0) + small;
    }

    public static String removeX2(String str) {
        if (str.length() < 1)
            return str;
        if (str.charAt(0) == 'x')
            return "" + removeX2(str.substring(1));
        else
            return str.charAt(0) + removeX2(str.substring(1));
    }

    public static int stringToInteger(String str) {
        if (str.length() < 1)
            return 0;
        return (str.charAt(str.length() - 1) - '0') + stringToInteger(str.substring(0, str.length() - 1)) * 10;
    }

    public static int stringToInteger2(String str) {
        if (str.length() == 1)
            return str.charAt(0) - '0';
        int small = stringToInteger2(str.substring(0, str.length() - 1));
        int last = str.charAt(str.length() - 1) - '0';
        return last + small * 10;
    }
    public static int stringToInteger3(String str)
    {
        if(str.length()==1)
            return str.charAt(0)-'0';
        return (str.charAt(0)-'0')*(int)Math.pow(10,str.length()-1)+stringToInteger3(str.substring(1));
    }
    public static String pairStar(String str) {
        if (str.length() == 1)
            return str.charAt(0) + "";
        if (str.charAt(0) == str.charAt(1))
            return str.charAt(0) + "*" + pairStar(str.substring(1));
        else
            return str.charAt(0) + pairStar(str.substring(1));
    }

    public static void towerOfHanoi(int disk, String source, String destination,String auxilliary)
    {
        if(disk==0)
            return;
        towerOfHanoi(disk-1,source,auxilliary,destination);
        System.out.println(disk+source+destination+auxilliary);
        towerOfHanoi(disk-1,auxilliary,destination,source);
    }
