public class LinkedList
{
    protected Element head;
  
    public LinkedList()
    {
        purge();
    }
  
    public void purge()
    {
        head = null;
    }
  
    public Element getHead()
    {
        return head;
    }
  
    public Element getTail()
    {
        Element elementTracker = head;
     
        while(elementTracker.getNext() != null)
        {
            elementTracker = elementTracker.getNext();
        }
    
        return elementTracker;
    }
  
    public boolean isEmpty()
    {
        return (head == null);
    }
  
    public Object getFirst() throws Exception
    {
        if(isEmpty())
            throw new ContainerEmptyException();
            
        return getHead().getDatum();
    }
  
    public Object getLast() throws Exception
    {
        if(isEmpty())
          throw new ContainerEmptyException();
          
        return getTail().getDatum();
    }
  
    public void prepend(Object obj)
    {     
        head = new Element(obj, head);
    }
  
    public void append(Object obj)
    {
        if(getHead() == null)
            head = new Element(obj, null);
        else
            getTail().setNext(new Element(obj,null));
    }
  
    public void assign(LinkedList list)
    {
        if(list != this)
        {
            purge();
        
            for(Element ptr = list.head; ptr != null; ptr = ptr.next)
                append(ptr.datum);
        }
    }
  
    public void extract(Object item) throws Exception
    {
        if(isEmpty())
            throw new ContainerEmptyException();
        
        Element ptr=head;
        Element prevPtr=null;
        
        while (ptr!=null && !ptr.datum.equals(item))
        {
            prevPtr=ptr;
            ptr=ptr.next;
        }
        
        if (ptr==null)
            throw new IllegalArgumentException();
            
        if (ptr==head)
            head=ptr.next;
        else
            prevPtr.next=ptr.next;
    }
  
    public final class Element
    {
        protected Object datum;
        protected Element next;
    
        Element(Object datum, Element next)
        {
            this.datum = datum;
            this.next = next;
        }
    
        public Object getDatum()
        {
            return datum;
        }
    
        public Element getNext()
        {
            return next;
        }
    
        public void setNext(Element next)
        {
            this.next = next;
        }
    
        public void setDatum(Object datum)
        {
            this.datum = datum;
        }
    
        public void insertAfter(Object item)
        {      
            next=new Element (item, next);
            
            if (getTail()==this)
                getTail().setNext(next);     
        }
    
        public void insertBefore(Object item)
        {
            Element tmp=new Element (item,this);
            
            if (this==getHead())
                head=tmp;
            else
            {
                Element prevPtr= getHead();
        
                while (prevPtr!=null && prevPtr.next!=this)
                    prevPtr=prevPtr.next;
                
                prevPtr.next=tmp;
            }
        }
    }
}


