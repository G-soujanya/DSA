public class LongestCommonPrefix {
    public static void main(String args[])//{“geeksforgeeks”, “geeks”, “geek”, “geezer”}
    {
        String[] strArray={"apple", "ape", "april"};
        longestCommonPrefix(strArray);
    }
    public static void longestCommonPrefix(String arr[])
    {
        String commonPrefix=arr[0];
        String newCommonPrefix="";
        for (int i = 1; i <arr.length ; i++)
        {
            newCommonPrefix="";
            String currentString=arr[i];
            for (int j = 0; j < currentString.length() && j<commonPrefix.length(); j++) {
                if(currentString.charAt(j)==commonPrefix.charAt(j))
                {
                    newCommonPrefix+=currentString.charAt(j);
                }
                else {
                    commonPrefix=newCommonPrefix;
                    break;
                }
            }
        }
        System.out.println(commonPrefix);
    }
}
