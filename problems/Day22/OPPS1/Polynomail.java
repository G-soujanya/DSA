public class Polynomial {
    int[] coefficient;
    Polynomial(){
        coefficient=new int[10];
    }
    public void setCoefficient(int degree,int coefficient)
    {
        this.coefficient[degree]=coefficient;
    }
    public int getCoefficient(int i)
    {
        return coefficient[i];
    }
    public static Polynomial add(Polynomial p1,Polynomial p2){
        Polynomial p3=new Polynomial();
        for (int i = 0; i < 10; i++) {
            p3.setCoefficient(i,p1.getCoefficient(i)+p2.getCoefficient(i));
        }
        return p3;
    }
    public static Polynomial sub(Polynomial p1,Polynomial p2){
        Polynomial p3=new Polynomial();
        for (int i = 0; i < 10; i++) {
            p3.setCoefficient(i,p1.getCoefficient(i)-p2.getCoefficient(i));
        }
        return p3;
    }
    public void print()
    {
        for (int i = 0; i < 10; i++) {
            if(this.getCoefficient(i)!=0)
            System.out.print(this.getCoefficient(i)+" ");
        }
        System.out.println();
    }
    public Polynomial multiply(Polynomial p)
    {
        Polynomial ans=new Polynomial();
        for (int i = 0; i < this.coefficient.length; i++) {
            for (int j = 0; j < p.coefficient.length; j++) {
                int index=i+j;
                int termCoeff=this.coefficient[i]* p.getCoefficient(j);
                int oldCoeff=ans.getCoefficient(index);
                ans.setCoefficient(index,termCoeff+oldCoeff);
            }
        }
        return ans;
    }
}
