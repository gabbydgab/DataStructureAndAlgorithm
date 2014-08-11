public class QueueAsLinkedList
    extends AbstractContainer
    implements Queue
{
    protected LinkedList list;
    
    public QueueAsLinkedList()
    {
        list = new LinkedList();
    }
    
    public Object getHead()
    {
        return list.getHead();
    }
   
    public void enqueue(Object object)
    {
        list.append(object);
    }
    
    public Object dequeue()
    {
        return list.getTail();
    }
    
    public void purge()
    {
        list.purge();
        count = 0;
    }
    
    public final int compare(Comparable comparable)
    {
        return 1;
    }
    
    public final int compareTo(Comparable comaprable)
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