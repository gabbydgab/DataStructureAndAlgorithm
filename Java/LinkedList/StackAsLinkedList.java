public class StackAsLinkedList 
    extends AbstractContainer
    implements Stack
{
    protected LinkedList list;
    
    public StackAsLinkedList()
    {
        list = new LinkedList();
    }
    
    public void purge()
    {
        list.purge();
        count = 0;
    }
   
    public void push (Object object)
    {
        list.prepend(object);
        ++count;        
    }
    
    public Object pop() throws Exception
    {
        if(getCount() == 0)
            throw new ContainerEmptyException();
        
        Object result = list.getFirst();
        list.extract(result);
        --count;
        return result;
    }
    
    public Object getTop() throws Exception
    {
        if(count==0)
            throw new ContainerEmptyException();
        
        return list.getFirst();
    }
    
    public final int compare(Comparable comparable)
    {
        return 1;
    }
    
    public final int compareTo(Comparable comparable)
    {
        return 1;
    }
    
    public Enumeration getEnumeration()
    {  
        return new Enumeration()
        {
            protected LinkedList.Element position = list.getHead();
            
            public boolean hasMoreElements()
            {
                return position != null;
            }
            
            public Object nextElement() throws NoSuchElementException
            {
                if(position == null)
                    throw new NoSuchElementException();
                
                Object result = position.getDatum();
                position = position.getNext();
                
                return result;
            }
        };
    }
}
