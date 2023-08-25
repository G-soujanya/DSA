class dynamicArray 
{
    public static void main(String args[])
    {
        array a=new array();
        /*a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(7);
        a.add(8);
        a.add(9);
        System.out.println(a.displayLength()); 
        System.out.println(a.displaySize());
        a.add(10); 
        a.add(11);
        a.add(12);   
        System.out.println(a.displayLength()); 
        System.out.println(a.displaySize());
        a.display();
        a.removeElement();
        System.out.println("");
        System.out.println("After removing");
        a.display();
        System.out.println("");
        System.out.println("Adding at beginning");
        a.addBegin(100);
        a.display();
        System.out.println("");
        System.out.println("Adding at end");
        a.addEnd(1000);
        a.display();*/
        a.add(10);
        a.add(100);
        a.add(80);
        a.add(76);
        a.add(45);
        a.display();
        System.out.println("");
        System.out.println("sorting");
        a.sort();
        a.display();
        System.out.println("");
        System.out.println("subwith begining index");
        a.subArraay(1);
         System.out.println("");
        System.out.println("subwith begining index and ending index");
        a.subArraay(2, 4);
        System.out.println("");
        System.out.println("delect element at begininng");
        a.delBegin();
        a.display();
        System.out.println("");
        System.out.println("maximum element in the array");
        System.out.println(a.maxElement());
        System.out.println("");
        System.out.println("minimum element in the array");
        System.out.println(a.minElement());
    }
}
class array 
{
    int[] a;
    public array()
    {
        a=new int[10];
    }
    int count=0;
    public void add(int n)
    {
        a[count++]=n;
        if(count==a.length)
        {
            int[] anew=new int[count*2];
            for(int i=0;i<count;i++)
            {
                anew[i]=a[i];
            }
            a=anew;
        }
    }
    public void display()
    {
        System.out.print("[");
        for(int i=0;i<count;i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.print("]");
    }
    public int displayLength()
    {
        return count;
    }
    public int displaySize()
    {
        return a.length;
    }
    public void removeElement()
    {
        count--;
    }
    public void addBegin(int n)
    {
        for(int i=count+1;i>=1;i--)
        {
            a[i]=a[i-1];
        }
        a[0]=n;
        count++;
    }
    public void addEnd(int n)
    {
        a[count++]=n;
    }
    public void sort()
    {
        for(int i=0;i<count;i++)
        {
            int index=i,temp;
            for(int j=i+1;j<count;j++)
            {
                if(a[j]<a[index])
                    index=j;
            }
            temp=a[index];
            a[index]=a[i];
            a[i]=temp;
        }
        for(int i=0;i<count;i++)
        {
            System.out.print(a[i]+" ");
        }
    }
    public void subArraay(int begin)
    {
        System.out.print("[");
        for(int i=begin;i<count;i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.print("]");
    }
    public void subArraay(int b,int e)
    {
        System.out.print("[");
        for(int i=b;i<e;i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.print("]");
    }
    public void delBegin()
    {
        for(int i=0;i<count;i++)
        {
            a[i]=a[i+1];
        }
        count--;
    }
    public int maxElement()
    {
        int max=0;
        for(int i=0;i<=count;i++)
        {
            if(a[i]>max)
            {
                max=a[i];
            }
        }
        return max;
    }
    public int minElement()
    {
        int min=a[0];
        for(int i=0;i<count;i++)
        {
            if(a[i]<min)
                min=a[i];
        }
        return min;
    }
}
