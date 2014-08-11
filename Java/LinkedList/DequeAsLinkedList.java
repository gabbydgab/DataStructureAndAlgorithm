public class DequeAsLinkedList
    extends QueueAsLinkedList
    implements Deque
{
    public void enqueueHead(Object object)
    {
        list.prepend(object);
        ++count;
    }
    
    public Object dequeueHead()
    {
        return dequeue();
    }
    
    public Object getTail()
    {
        return list.getLast();
    }
    
    public void enqueueTail(Object object)
    {
        enqueue(object);
    }
    
    public Object dequeueTail()
    {        
        Object result = this.getTail();
        list.extract(result);
        --count;
        
        return result;        
    }
}