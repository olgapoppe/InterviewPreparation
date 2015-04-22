package movie;

import java.util.List;

public class Main {
	
	/* * eg:     A(Rating 1.2)
     *               /   \
     *            B(2.4)  C(3.6)
     *              \     /
     *                D(4.8)
     *                  |
     *                E(4.8) 
     *                
     * Assumptions:
     * (1) If several movies have the same rating and
     * not all of them "fit" into n top rated movies, 
     * the closest of them are returned.  
     * (2) The movie graph is relatively small and 
     * getMovieRecommendations traverses it completely. */
	
	public static void main (String args[]) {
		
		Movie A = new Movie (1,1.2f);
		Movie B = new Movie (2,2.4f);
		Movie C = new Movie (3,3.6f);
		Movie D = new Movie (4,4.8f);
		Movie E = new Movie (5,4.8f);
		
		A.addSimilarMovie(B);
		A.addSimilarMovie(C);
		B.addSimilarMovie(D);
		C.addSimilarMovie(D);
		D.addSimilarMovie(E);
		
		List<Movie> result = Movie.getMovieRecommendations(A,1);
		for (Movie m : result) {
			System.out.println(m.toString());
		}		
	}
}
