package mutableRankingList;
import java.util.Iterator;

public class MutableRankingList<E extends Comparable<E>> implements Iterable<E> {

	    private RankedTree<E> root;
	    
	    public MutableRankingList()
	    {
	        root = EmptyTree.<E>getEmptyTree();
	    }

	    public MutableRankingList(E item)
	    {
	        root = new NonEmptyTree<E>(EmptyTree.<E>getEmptyTree(), item, EmptyTree.<E>getEmptyTree());
	    }
	    
	    public void incrementDownloadsCount(E item)
	    {
	    		this.root = root.insert(item);
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
