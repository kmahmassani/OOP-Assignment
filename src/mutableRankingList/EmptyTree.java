package mutableRankingList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author  Daniel W.H. James
 * @version OOP Nov 2011
 */
public class EmptyTree<E extends Comparable<E>> implements RankedTree<E>
{
	
    @SuppressWarnings("rawtypes")
	private static final EmptyTree empty = new EmptyTree();
    
    private EmptyTree()
    {
    }
    
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> RankedTree<T> getEmptyTree()
    {
        return empty;
    }
    
    public int size()
    {
        return 0;
    }
    
    public int depth()
    {
        return 0;
    }

    public boolean member(E elem)
    {
        return false;
    }
    
    
    public RankedTree<E> insert(E elem)
    {
        return new NonEmptyTree<E>(EmptyTree.<E>getEmptyTree(), elem, EmptyTree.<E>getEmptyTree());
    }
    
    public void inorder(Visitor<E> v)
    {
        return;
    }
    
    public LinkedStack<E> spine(LinkedStack<E> stack)
    {
        return stack;
    }
    
    public void dump(int depth)
    {
    }
    
    public Iterator<E> iterator(){
        return new Iterator<E>(){
            public boolean hasNext(){ return false;}
            public E next(){
                throw new NoSuchElementException();}
        };
    }

	@Override
	public int getDownloads(E elem) {
		// TODO Auto-generated method stub
		return 0;
	}
}
