public interface Deque
    extends Container
{
    Object getHead();
    Object getTail();
    void enqueueHead(Object object);
    void enqueueTail(Object object);
    Object dequeueHead();
    Object dequeueTail();
}