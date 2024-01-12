public class ExceptionHandling {
    public static void main(String args[]) {
        try {
            divide(10, 0);
        }
        catch (ArthimatiExce e){
            System.out.println("denominator can not be zero");
        }
        System.out.println("mian");
    }
    public static void divide(int nume,int deno) throws ArthimatiExce
    {
        if(deno==0)
            throw new ArthimatiExce();
        System.out.println(nume/deno);
    }
}
