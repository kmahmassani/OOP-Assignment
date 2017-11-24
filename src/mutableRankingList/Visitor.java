package mutableRankingList;

/**
 * An interface for a tree visitor
 * 
 * @author  Daniel W.H. James
 * @version OOP Nov 2011
 */
public interface Visitor<E>
{
    /**
     * @param elem
     */
    public void visit(E elem);
}
