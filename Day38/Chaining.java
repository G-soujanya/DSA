import java.util.LinkedList;

class Chaining 
{
    public static void main(String args[])
    {
        HashTableImple hash=new HashTableImple();
        hash.put(1, "abc");
        hash.put(6,"xyz");
       //hash.remove(6);
        System.out.println(hash.get(6));
        //hash.remove(6);
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
        var bucket=getEntry(key);
        if(bucket!=null)
        {
            bucket.value=value;
            return;
        }
        getOrCreateBucket(key).addLast(new Entry(key, value));
    }
    public LinkedList<Entry> getOrCreateBucket(int key)
    {
        int index=hash(key);
        if(entries[index]==null)
            entries[index]=new LinkedList<>();
        return entries[index];
    }
    public Entry getEntry(int key)
    {
        var bucket=getOrCreateBucket(key);
        for(var entry:bucket)
        {
            if(entry.key==key)
                return entry;
        }
        return null;
    }
    public String get(int key)
    {
        var entry=getEntry(key);
        if(entry!=null)
            return entry.value;
        return " ";
    }
    void remove(int key)
    {
        var bucket=getOrCreateBucket(key);
        if(bucket==null)
            throw new IllegalStateException();
        for(var entry:bucket)
        {
            if(entry.key==key)
                bucket.remove(entry);
        }
    }
    boolean containsKey(int key)
    {
        var entry=getEntry(key);
        return entry!=null?true:false;
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