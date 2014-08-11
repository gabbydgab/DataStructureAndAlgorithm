public class StackAsArray
    extends AbstractContainer
    implements Stack
{
    protected Array array;
    
    public StackAsArray()
    {
        array = new Array();
    }
    
    public Enumeration getEnumeration()
    {
        return new Enumeration()
        {
            protected int position = 0;
            
            public boolean hasMoreElements()
            {
                return position < getCount();
            }
            
            public Object nextElement() throws NoSuchElementException
            {
                if(position >= getCount())
                    throw new NoSuchElementException();
                
                return array.get(position++);
            }
        };
    }
    
    public final int compare(Comparable comparable)
    {
        return 1;
    }
    
    public final int compareTo(Comparable comparable)
    {
        return 1;
    }
    
    public void purge()
    {
    }
    
    public void push(Object object)
    {
    }
    
    public Object pop() throws Exception
    {
        return array;
    }
    
    public Object getTop() throws Exception
    {
        return array;
    }
}
