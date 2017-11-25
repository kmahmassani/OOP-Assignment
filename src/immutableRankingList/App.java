package immutableRankingList;

public class App extends ImmutableRankingListItem<App> {

	public Title title;
	public Genre genre;
	
	/**
	 * @param title
	 * @param genre
	 */
	public App(Title title, Genre genre) {
		this.title = title;
		this.genre = genre;
	}
	
	/**
	 * @param title
	 * @param genre
	 */
	public App(String title, String genre) {
		this.title = new Title(title);
		this.genre = new Genre(genre);
	}
	
	/* 
	 * Comparison based on title for alphabetic sorting
	 * @param that non-null App, throws nullPointer for null 
	 */
	@Override
	public int compareTo(App that) {
		if (this == that)
			return 0;
		
		if (this.equals(that))
			return 0;
		
		return this.title.compareTo(that.title);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		App other = (App) obj;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return (title != null ? title + ", " : "") + (genre != null ? genre : "");
	}

	@Override
	public App DeepCopy() {
		return new App(this.title != null ? title.name : "", this.genre != null ? genre.name : "" );
	}
}
