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
        
    }
    
    public final int compareTo(Comparable comparable)
    {
    }
    
    public Enumeration getEnumeration()
    {
        
    }
    
    public void purge()
    {
        while(count > 0)
        {
            array[head] = null;
            
            if (++head == array.length)
                head = 0;
            
            --count;
        }
    }
    
    public Object getHead()
    {
        if(count == 0)
            throw new ContainerEmptyException();
        
        return array[head];
    }
    
    public void enqueue(Object object)
    {
        if(count == array.length)
            throw new ContainerEmptyException();
        
        if(++tail == array.length)
            tail = 0;
        
        array[tail] = object;
        ++count;
    }
    
    public Object dequeue()
    {
        if(count == 0)
            throw new ContainerEmptyException();
        
        Object result = array[head];
        array[head] = null;
        
        if(++head == array.length)
            head = 0;
        
        --count;
        
        return result;
    }
}