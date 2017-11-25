package immutableRankingList;
import java.util.Iterator;

public  final class ImmutableRankingList<E extends ImmutableRankingListItem<E>> implements Iterable<E> {

	    private final RankedTree<E> root;
	    
	    
	    
	    public ImmutableRankingList(RankedTree<E> root) {
	    	this.root = root;
	    }

	    public ImmutableRankingList(E item)
	    {
	        root = new NonEmptyTree<E>(EmptyTree.<E>getEmptyTree(), item, EmptyTree.<E>getEmptyTree());
	    }
	    
//	    public void insert(E item)
//	    {
//	    		root.insert(item);
//	    }
//	    
//	    public int size()
//	    {
//	        return root.size();
//	    }
//	    
//	    public boolean member(E elem)
//	    {
//	        return root.member(elem);
//	    }
//	    
//	    public void print()
//	    {
//	        root.inorder(new Visitor<E>()
//	            { 
//	                public void visit(E item) { System.out.println(item); }
//	            });
//	    }
	    
	    public ImmutableRankingList<E> incrementDownloadsCount(E item)
	    {
	    	return new ImmutableRankingList<E>(root.insert(item));
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
