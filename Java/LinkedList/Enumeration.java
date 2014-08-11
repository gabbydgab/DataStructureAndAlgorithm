public interface Enumeration
{
    boolean hasMoreElements();
    Object nextElement() throws NoSuchElementException;
}