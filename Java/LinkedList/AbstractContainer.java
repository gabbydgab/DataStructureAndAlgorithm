public abstract class AbstractContainer
    extends AbstractObject
    implements Container
{
    protected int count;
    
    public int getCount()
    {
        return count;
    }
    
    public boolean isEmpty()
    {
        return getCount() == 0;
    }
    
    /**
     * Will return false by Default
     * 
     * Must be Overriden on the concrete implementation
     */
    public boolean isFull()
    {
        return false;
    }
    
    public abstract void purge();
}