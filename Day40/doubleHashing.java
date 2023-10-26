import java.util.*;
class doubleHashing 
{
    public static void main(String args[])
    {
        HashTable table=new HashTable();
        table.put(115,"abc");
        table.put(12,"gji");
        table.put(87,"lpo");
        table.put(66,"jkf");
        table.put(123,"insert");
        System.out.println(table);
        table.remove(123);
        table.remove(87);
        table.remove(66);
        System.out.println(table);
    }
}
class HashTable
{
    private class Entry 
    {
        int key;
        String value;
        Entry(int k,String v)
        {
            key=k;
            value=v;
        }
        public String toString()
        {
            return key+" : "+value;
        }
    }
    Entry[] entries=new Entry[13];
    private int count=0;
    private boolean isFull()
    {
        return count==entries.length;
    }
    private boolean isEmpty()
    {
        return count==0;
    }
    public void put(int key,String value)
    {
        if(isFull())
            throw new IllegalStateException();
        int index=hash(key);
        if(entries[index]!=null)
            entries[index].value=value;
        else
        {
        entries[index]=new Entry(key, value);
        count++;
        }
        
    }
    private int hash1(int key)
    {
        return key%entries.length;
    }
    private int primeGen(int key)
    {
        int i=key;
        for(;i>=0;i++)
        {
            int flag=0;
            for(int j=1;j<i;j++)
            {
                if(i%j==0)
                    flag=1;
            }
            if(flag==1)
                break;
        }
        return i;
    }
    private int hash2(int key)
    {
        int prime=primeGen(key);
        return prime-(key%prime);
    }
    private int hash(int key)
    {
        int index=key%entries.length;
        int start=0;
        while(entries[start]!=null && start<entries.length)
        {
            if(entries[start].key==key)
                return key;
            start++;
        }
        int j=1;
        while(entries[index]!=null)
        {
            index=(hash1(key)+(j*hash2(key)))%entries.length;
            j++;
        }
        return index;
    }
    private int getIndex(int key)
    {
        int index=key%entries.length;
        if(entries[index]==null)
            return index;
        if(entries[index].key==key)
            return index;
        int start=0;
        while(start<entries.length)
        {
            if(entries[start]!=null && entries[start].key==key)
                return start;
            start++;
        }
        return -1;
    }
    public String get(int key)
    {
        if(isEmpty())
            throw new IllegalStateException();
        int index=getIndex(key);
        if(index==-1 || entries[index]==null)
          throw new NoSuchElementException();
        return entries[index].value;
    }
    public boolean containsKey(int key)
    {
        if(isEmpty())
            throw new IllegalStateException();
        int index=getIndex(key);
        if(index==-1 || entries[index]==null)
          return false;
        return true;
    }
    public boolean containsValue(String va)
    {
        if(isEmpty())
            throw new IllegalStateException();
        int start=0;
        while(start<entries.length)
        {
            if(entries[start]!=null && entries[start].value==va)
            {
                return true;
            }
            start++;
        }
        return false;
    }
    public String toString()
    {
        return Arrays.toString(entries);
    }
    public void remove(int key)
    {
        if(isEmpty())
            throw new IllegalStateException();
        int index=getIndex(key);
        if(entries[index]==null)
            throw new NoSuchElementException();
        entries[index]=null;
        count--;
    }
}