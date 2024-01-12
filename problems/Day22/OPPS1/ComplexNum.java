public class ComplexNum {
    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    private int real;
    private int img;
    public ComplexNum(int real,int img)
    {
        this.real=real;
        this.img=img;
    }
    public void print()
    {
        System.out.println(this.real+" "+this.img+"i");
    }
    public void add(ComplexNum n1)
    {
        this.real=this.real+n1.real;
        this.img=this.img+n1.img;
    }
    public void multiply(ComplexNum n1)
    {
        this.real=(this.real*n1.real)-(n1.img*this.img);
        this.img=(this.real*n1.img)+(this.img*n1.real);
    }
    public static void addition(ComplexNum n1,ComplexNum n2)
    {
        int real=n1.real+n2.real;
        int img=n1.img+n2.img;
        ComplexNum n3=new ComplexNum(real,img);
        n3.print();
    }
}
