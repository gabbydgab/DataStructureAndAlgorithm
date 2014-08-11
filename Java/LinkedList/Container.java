public interface Container
    extends Comparable
{
    int getCount ();
    boolean isEmpty ();
    boolean isFull ();
    void purge ();
    Enumeration getEnumeration();
}