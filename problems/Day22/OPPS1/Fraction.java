public class Fraction {
    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    private int numerator;
    private int denominator;
    public Fraction(int numerator,int denominator)
    {
        this.numerator=numerator;
        this.denominator=denominator;
    }
    public void print()
    {
        simplify();
        System.out.println(this.numerator+"/"+this.denominator);
    }
    private void simplify()
    {
        int gcd=1;
        for(int i=2;i<=Math.min(numerator,denominator);i++)
        {
            if(numerator%i==0 && denominator%i==0)
                gcd=i;
        }
        numerator=numerator/gcd;
        denominator=denominator/gcd;
    }
    public void increment()
    {
        numerator=numerator+denominator;
    }
    public void addition(Fraction f1,Fraction f2)
    {
        int n=f1.numerator*f2.denominator+(f2.numerator*f1.denominator);
        int d=f1.denominator*f2.denominator;
        Fraction f3=new Fraction(n,d);
        f3.print();
    }

}
