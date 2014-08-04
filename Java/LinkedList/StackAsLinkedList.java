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
    
    public Object pop()
    {
        if(count==0)
            throw new ContainerEmptyException();
        
        Object result = list.getFirst();
        list.extract(result);
        --count;
        return result;
    }
    
    public Object getTop()
    {
        if(count==0)
            throw new ContainerEmptyException();
        
        return list.getFirst();
    }    
}
