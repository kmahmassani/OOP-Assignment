package mutableRankingList;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * An implementation of the {@link Stack} ADT
 * as a linked list
 * 
 * @author Daniel W. H. James
 * @version OOP May 2011
 */
public class LinkedStack<E> implements Iterable<E>
{
    /**
     * reference to top of stack
     */
    private RankedNode<E> top;

    /**
     * Create an empty stack
     */
    public LinkedStack()
    { 
        top =  null;
    }

    /**
     * Push an item onto the top of the stack
     * 
     * @param item an object to push onto the top of the stack
     */
    public void push (E item)
    {
        top = new RankedNode<>(item,top);
    }

    /**
     * Remove and return the item on the top of the stack
     * <p>
     * A {@link StackException} is thrown if the stack is empty
     * 
     * @return the item at the top of the stack
     * @throws StackException if stack is empty
     */
    public E pop() throws StackException
    {
        if (this.isEmpty())
        {
            throw new StackException("empty stack!");
        }
        E head = this.top();
        top = top.getNext();
        return head;
    }

    /**
     * Returns the top element of the stack
     * <p>
     * A {@link StackException} is thrown if the stack is empty
     * 
     * @return the element on the top of the stack
     * @throws StackException if stack is empty
     */
    public E top() throws StackException
    {
        if (this.isEmpty())
        {
            throw new StackException("empty stack!");
        }
        else
        {
            return top.getItem();
        }
    }

    /**
     * Test if the stack is empty
     * 
     * @return true iff the stack is empty
     */
    public boolean isEmpty()
    {
        return (top == null);
    }

    /**
     * Returns the size of the stack
     * 
     * @return the size of the stack
     */
    public int size()
    {
        int size = 0;
        RankedNode<E> curr = top;

        while (curr != null)
        {
            size++;
            curr = curr.getNext();
        }

        return size;
    }
    
    
    /**
     * Reverse the elements of the stack
     */
    public void reverse()
    {
        LinkedStack<E> stack = new LinkedStack<>();

        try
        {
            while (!this.isEmpty())
            {
                stack.push(this.pop());
            }
        }
        catch (StackException ex)
        {
            System.err.println("stack was empty when pop() is called");
        }

        this.top = stack.top;
    }
    
    
    
    
    
     /**
     * Overloaded version of append which takes a LinkedStack and appends it on the bottom of this stack.
     * This implementation is simpler than the more general one since we can acces the field top of LinkedStack 
     * on the argument stack.
     * 
     * @param stack a stack to append
     */
    public void append(LinkedStack<E> stack)
    {
        try
        {
            LinkedStack<E> combined = new LinkedStack<>();
            LinkedStack<E> save = new LinkedStack<>();
            stack.reverse();
            this.reverse();
            while (!stack.isEmpty())
            {
                E obj = stack.pop();
                combined.push(obj);
                save.push(obj);
            }
            while (!isEmpty())
            {
                combined.push(pop());
            }
            this.top=combined.top;
            stack.top=save.top;
        }catch (StackException ex)
        {            
            System.err.println("stack was empty when pop() is called");
        }
    }
    

    /**
     * @return a string representation
     */
    @Override
    public String toString()
    {
        /*
         * Format:
         * [] for empty stack
         * [str] for singleton stack
         * [str, str, ...] otherwise
         */
        StringBuilder builder = new StringBuilder();

        builder.append("[");

        RankedNode<E> node = top;
        if (node != null)
        {
            builder.append(node.getItem().toString());
            node = node.getNext();
        }

        while (node != null)
        {
            builder.append(", ");
            builder.append(node.getItem().toString());
            node = node.getNext();
        }

        builder.append("]");

        return builder.toString();
    }
    
    @Override
    public Iterator<E> iterator(){
        
        return new Iterator<E>(){
            
            RankedNode<E> curr=top;
            
            public boolean hasNext(){ return curr!=null;}
            
            public E next(){
                
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                E nextEl=curr.getItem();
                curr=curr.getNext();
                return nextEl;
            }
        };
    }
}
