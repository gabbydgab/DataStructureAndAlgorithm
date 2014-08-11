public class QueueAsArray
    extends AbstractContainer
    implements Queue
{
    protected Array array;
    protected int head;
    protected int tail;
    
    public QueueAsArray(int size)
    {
        array = new Array(size);
        head = 0;
        tail = size - 1;
    }
    
    public final int compare(Comparable comparable) 
    {
        //implemantation to be discussed
        return 1;
    }
    
    public final int compareTo(Comparable comparable)
    {
        //implemantation to be discussed
        return 1;
    }
    
    public void purge()
    {
        while(array.getLength() > 0)
        {
            array.put(head, null);
            
            if (++head == array.getLength())
                head = 0;
            
            --count;
        }
    }
    
    public Object getHead() throws Exception
    {
        if(array.getLength() == 0)
            throw new ContainerEmptyException();
        
        return array.get(head);
    }
    
    public void enqueue(Object object) throws Exception
    {
        if(getCount() == array.getLength())
            throw new ContainerEmptyException();
        
        if(++tail == array.getLength())
            tail = 0;
        
        array.put(tail, object);
        ++count;
    }
    
    public Object dequeue() throws Exception
    {
        if(array.getLength() == 0)
            throw new ContainerEmptyException();
        
        Object result = array.get(head);
        array.put(head,null);
        
        if(++head == array.getLength())
            head = 0;
        
        --count;
        
        return result;
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
}