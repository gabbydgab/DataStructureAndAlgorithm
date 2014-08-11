public class DequeAsArray
    extends QueueAsArray
    implements Deque
{
    public DequeAsArray()
    {
        QueueAsArray(0);
    }
    
    public void enqueueHead(Object object)
    {
        if(count == array.getLength())
            throw new ContainerFullException();
        
        if(head-- == 0)
            head = array.getLength() - 1;
        
        array.put(head, object);
        ++count;
    }
    
    public Object dequeueHead()
    {
        return dequeue();
    }
    
    public Object getTail()
    {
        if(count == 0)
            throw new ContainerEmptyException();
        
        return array.get(tail);
    }
    
    public void enqueueTail(Object object)
    {
        enqueue(object);
    }
    
    public Object dequeueTail()
    {
        if(count == 0)
            throw new ContainerEmptyException();
        
        Object result = array.get(tail);
        array.put(tail, null);
       
        if(count-- == 0)
            tail = array.getLength() - 1;
        
        --count;
        return result;
    }
}