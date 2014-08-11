public interface Queue
    extends Container
{
    Object getHead() throws Exception;
    void enqueue(Object object) throws Exception;
    Object dequeue() throws Exception;
}