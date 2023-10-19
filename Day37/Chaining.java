import java.util.LinkedList;

class Chaining 
{
    public static void main(String args[])
    {
        HashTableImple hash=new HashTableImple();
        hash.put(1, "abc");
        hash.put(6,"xyz");
       // hash.remove(6);
        System.out.println(hash.get(6));
        System.out.println(hash.containsKey(6));
        System.out.println(hash.containsValue("xya"));
    }    
}
class HashTableImple
{
    private class Entry
    {
        int key;
        String value;
        Entry(int data,String v)
        {
            key=data;
            value=v;
        }
    }
    LinkedList<Entry>[] entries=new  LinkedList[5];
    private int hash(int key)
    {
        return key%entries.length;
    }
    public void put(int key,String value)
    {
        int index=hash(key);
        if(entries[index]==null)
            entries[index]=new LinkedList<>();
        var current=entries[index];
        if(entries[hash(key)]!=null)
        {
            for(Entry x:current)
            {
                if(x.key==key)
                {
                    x.value=value;
                    return;
                }
            }
        }
        Entry entry=new Entry(key, value);
        current.addLast(entry);
    }
    public String get(int key)
    {
        var current=entries[hash(key)];
        if(entries[hash(key)]!=null)
        {
            for(var x:current)
            {
                if(x.key==key)
                {
                    return x.value;
                }
            }
        }
        return " ";
    }
    void remove(int key)
    {
        var current=entries[hash(key)];
        if(current==null)
            throw new IllegalStateException();
        else
        {
            for(var x:current)
            {
                if(x.key==key)
                {
                    current.remove(x);
                }
            }
        }
    }
    boolean containsKey(int key)
    {
        var current=entries[hash(key)];
        if(current==null)
            return false;
        else
        {
            for(var x:current)
            {
                if(x.key==key)
                {
                    return true;
                }
            }
        }
        return false;
    }
    boolean containsValue(String value)
    {
        for(int i=0;i<entries.length;i++)
        {
            var current=entries[i];
            if(current==null)
                continue;
            else 
            {
                for(var x:current)
                {
                    if(x.value==value)
                    {
                        return true;
                    }

                }
            }
        }
        return false;
    }
}
