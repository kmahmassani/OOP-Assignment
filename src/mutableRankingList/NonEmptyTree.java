package mutableRankingList;

import java.util.Iterator;
/**
 * @author  Daniel W.H. James
 * @version OOP Nov 2011
 */
public class NonEmptyTree<E extends Comparable<E>> implements RankedTree<E>
{
    public RankedTree<E> left;
    public E       item;
    public RankedTree<E> right;

    public int downloads;
    
    public NonEmptyTree(RankedTree<E> left, E item, RankedTree<E> right)
    {
        this.left  = left;
        this.item  = item;
        this.right = right;
        this.downloads = 1;
    }
    
    public int size()
    {
        return left.size() + 1 + right.size();
    }
    
    public int depth()
    {
        return 1 + Math.max(left.depth(), right.depth());
    }

    public boolean member(E elem)
    {
        if (elem.compareTo(item) < 0)
            return left.member(elem);
        else if (elem.compareTo(item) == 0)
            return true;
        else
            return right.member(elem);
    }
    
    public RankedTree<E> insert(E elem)
    {
    		if (item.equals(elem))
    			downloads++;
    		else if (elem.compareTo(item) < 0)
            left  = left. insert(elem);
        else 
            right = right.insert(elem);
        
        return this;
    }
    
    public void inorder(Visitor<E> v)
    {
        left.inorder(v);
        v.visit(item);
        right.inorder(v);
    }
    
    public LinkedStack<E> spine(LinkedStack<E> stack)
    {
        LinkedStack<E> result = new LinkedStack<E>();
        result= right.spine(stack);
        result.push(this.item);
        result= left.spine(result);
        return result;//left.spine(new Stack<E>(this, stack));
    }
    
    public Iterator<E> iterator(){
        return this.spine(new LinkedStack<E>()).iterator();
    }
    
    public void dump(int depth)
    {
        left.dump(depth + 1);
        for (int i = 0; i < depth; i++)
            System.out.print("    ");
        System.out.println(item);
        right.dump(depth + 1);
    }

	@Override
	public int getDownloads(E elem) {
		if (this.item.equals(elem))
			return this.downloads;
		
		if (this.left.member(elem))
			return this.left.getDownloads(elem);
		
		if (this.right.member(elem))
			return this.right.getDownloads(elem);
		
		throw new java.util.NoSuchElementException();
	}
}
