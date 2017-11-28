package immutableRankingList;
import java.util.Iterator;
/**
 * @author  Original - Daniel W.H. James, Modified By - Kamal Mahmassani
 * @version OOP Nov 2017
 */
public final class ImmutableRankingList<E extends ImmutableRankingListItem<E>> implements Iterable<E> {

	    private final RankedTree<E> root;

	    public ImmutableRankingList(RankedTree<E> root) {
	    		this.root = root;
	    }

	    public ImmutableRankingList(E item)
	    {
	        root = new NonEmptyTree<E>(EmptyTree.<E>getEmptyTree(), item.DeepCopy(), EmptyTree.<E>getEmptyTree());
	    }
	    
	    public ImmutableRankingList<E> incrementDownloadsCount(E item)
	    {
	    		return new ImmutableRankingList<E>(root.insert(item.DeepCopy()));
	    }
	    
	    public int getDownloadsCount(E item)
	    {
	    		return root.getDownloads(item);
	    }
	    
	    public Iterator<E> iterator()
	    {
	        return root.iterator();
	    }
	    
	    void dump()
	    {
	        root.dump(0);
	    }
}
