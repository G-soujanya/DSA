import java.util.HashMap;
import java.util.Map;
class HashMapIm
{
    public static void main(String args[])
    {
        Map<Integer,String> m=new HashMap();
        m.put(161,"soujanya");
        m.put(160,"vaibhav");
        m.put(159,"bhargavi");
        //m.remove(159);
        //System.out.println(m.containsKey(163));
        //m.put(null,"suguna");
        //m.put(null,"pooja");
        //m.put(null,null);
        //System.out.println(m);
        System.out.println(m.get(161));
        System.out.println(m.containsValue("soujanya"));
        for(var entry:m.entrySet())
            System.out.println(entry.getKey());
        for(var entry:m.entrySet())
            System.out.println(entry.getValue());
        for(var key:m.keySet())
            System.out.println(key);
    }
}
