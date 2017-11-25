package immutableRankingList;


/**
 * An exception to be thrown from the {@link Stack} ADT.
 * 
 * @author  Daniel W.H. James
 * @version OOP May 2011
 */
public class StackException extends Exception
{
    
    /**
     * <code>StackException</code> with no message.
     */
    public StackException()
    {
        super();
    }
    
    /**
     * <code>StackException</code> with a message
     * 
     * @param msg a message to throw with the exception
     */
    public StackException(String msg)
    {
        super(msg);
    }
}
