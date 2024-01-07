public class StrLenkSub {
    public static void main(String args[])
    {
            strLenKSub("abc","",3);
    }
   public static void strLenKSub(String str,String outputSoFar,int k)
   {
       if(outputSoFar.length()==k)
       {
           System.out.println(outputSoFar);
           return;
       }
      for(int i=0;i<str.length();i++)
          strLenKSub(str,outputSoFar+str.charAt(i),k);
   }
}
