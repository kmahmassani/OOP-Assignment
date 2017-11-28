package immutableRankingList;

/**
 * @author  Original - Daniel W.H. James, Modified By - Kamal Mahmassani
 * @version OOP Nov 2017
 */
public interface RankedTree<E extends Comparable<E>> extends Iterable<E>
{
    /**
     * Get the size of the tree
     * 
     * @return size of the tree
     */
    public int size();
    
    
    /**
     * Get the maximum depth of the tree
     * 
     * @return depth of the tree
     */
    public int depth();
    
    /**
     * Test if a value occurs in the tree.
     * 
     * @param elem a value to look for
     * @return true iff the element occurs
     */
    public boolean member(E elem);
    
    /**
     * Insert a value into the tree
     * 
     * @param elem a value to insert
     * @return
     */
    public RankedTree<E> insert(E elem);
    
    
    /**
     * Get downloads of an element
     * 
     * @param elem a value to get downloads for
     * @return number of downloads
     */
    public int getDownloads(E elem); 
    
    /**
     * Make an in-order traveral of this tree
     * using a visitor.
     * 
     * @param v a visitor
     */
    public void inorder(Visitor<E> v);
    
    /**
     * push all elements of the tree onto the given stack preserving the order.
     * The left-most element of the tree should be the top of the stack.
     * 
     * @param stack the stack to fill
     * @return
     */
    public LinkedStack<E> spine(LinkedStack<E> stack);
    
    /**
     * @param depth
     */
    public void dump(int depth);
}
