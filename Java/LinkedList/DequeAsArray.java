public class DequeAsArray
    extends QueueAsArray
    implements Deque
{
    public void enqueueHead(Object object)
    {
        if(count == array.length)
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
        
        return array.get(array.getLength());
    }
    
    public void enqueueTail(Object object)
    {
        enqueue(object);
    }
    
    public Object dequeueTail()
    {
        if(count == 0)
            throw new ContainerEmptyException();
        
        Object result = array.get(getTail());
        
        
    }
}