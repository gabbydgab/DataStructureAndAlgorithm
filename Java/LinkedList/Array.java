public class Array
{
    protected Object[] data;
    protected int base;
    
    public Array(int baseLocation, int baseIndex)
    {
        data = new Object[baseLocation];
        base = baseIndex;
    }
    
    public Array()
    {
        this(0, 0);
    }
    
    public Array(int n)
    {
        this(n, 0);
    }
     
    public void assign(Array array)
    {
        if(array != this)
        {
            if(data.length != array.data.length)
                data = new Object[array.data.length];
            
            for(int i=0; i<data.length; i++)
                data[i] = array.data[i];
            
            base = array.base;
        }
    }
    
    public Object[] getData()
    {
        return data;
    }
    
    public void setBase(int base)
    {
        this.base = base;
    }
    
    public int getBase()
    {
        return base;
    }
    
    public void setLength(int newLength)
    {
        if(data.length != newLength) 
        {
            Object[] newData = new Object[newLength];
            int min = (data.length < newLength) ? data.length : newLength;
            
            for(int i = 0; i < min; ++i)
                newData[i] = data[i];
            
            data = newData;
        }
    }
   
    public int getLength()
    {
        return data.length;
    }
    
    public Object get(int position)
    {
        return data[position - base];
    }
    
    public void put(int position, Object object)
    {
        data[position - base] = object;
    }
}