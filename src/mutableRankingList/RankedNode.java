package mutableRankingList;

/**
 * A linked node for a {@link LinkedStack}
 * 
 * @author  Daniel W.H. James
 * @version OOP Nov 2001
 */
public class RankedNode<E>
{
    /**
     * the item at this node
     */
    private E item;
    
    /**
     * the number of downloads/points
     */
    private int downloads;

	/**
     * reference to next node in the chain
     */
    private RankedNode<E> next;

    /**
     * Create a new node with an item
     * 
     * @param item the Object to be the item of the node
     */
    public RankedNode(E item, int downloads)
    {
        this.item = item; 
        this.next = null;
        this.downloads = downloads;
    }

    /**
     * Create a new node with an item and another node to be the next node
     * 
     * @param item the Object to be the item of the node
     * @param next the node to be the next node
     */
    public RankedNode(E item, RankedNode<E> next)
    {
        this.item = item;
        this.next = next;
    }

    /**
     * Set the item of this node
     * 
     * @param newItem the new item
     */
    public void setItem(E newItem)
    {
        this.item = newItem;
    }

    /**
     * Return the item of this node
     * 
     * @return the item of this node
     */
    public E getItem()
    {
        return this.item;
    }

    /**
     * Return the downloads of this node
     * 
     * @return the downloads of this node
     */
    public int getDownloads() {
		return downloads;
	}

    /**
     * Set the downloads of this node
     * 
     * @param the downloads of this node
     */
	public void setDownloads(int downloads) {
		this.downloads = downloads;
	}
	
    /**
     * Set the next node of this node
     * 
     * @param newNext the new next node
     */
    public void setNext(RankedNode<E> newNext)
    {
        this.next = newNext;
    }

    /**
     * Return the next node of this node
     * 
     * @return the next node of this node
     */
    public RankedNode<E> getNext()
    {
        return this.next;
    }

    @Override
	public String toString() {
		return "LinkedNode [item=" + item + ", next=" + next + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((next == null) ? 0 : next.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RankedNode other = (RankedNode) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (next == null) {
			if (other.next != null)
				return false;
		} else if (!next.equals(other.next))
			return false;
		return true;
	}
}
