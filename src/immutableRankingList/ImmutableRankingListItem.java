package immutableRankingList;

public abstract class ImmutableRankingListItem <E> implements Comparable<E>{
	
	public abstract E DeepCopy();
}
