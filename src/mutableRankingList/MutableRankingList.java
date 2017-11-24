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
