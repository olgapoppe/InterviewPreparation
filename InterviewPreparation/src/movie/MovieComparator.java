package movie;

import java.util.Comparator;

public class MovieComparator implements Comparator<Movie> {

	public int compare (Movie m1, Movie m2) {
	    return (m1.getRating() >= m2.getRating()) ? 1 : -1;        
	}
}
