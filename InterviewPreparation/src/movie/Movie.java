package movie;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List; 
import java.util.Queue;
import java.util.TreeSet;

public class Movie {

    private final int movieId;
    private final float rating;
    private List<Movie> similarMovies; // Similarity is bidirectional
    public Color color;

    public Movie(int movieId, float rating) {
        this.movieId = movieId;
        this.rating = rating;
        similarMovies = new ArrayList<Movie>();
        this.color = Color.white;
    }

    public int getId() {
        return movieId;
    }

    public float getRating() {
        return rating;
    }

    public void addSimilarMovie(Movie movie) {
        similarMovies.add(movie);
        movie.similarMovies.add(this);
    }

    public List<Movie> getSimilarMovies() {
        return similarMovies;
    }

    /*
     * Implement a function to return top rated movies in the network of movies 
     * reachable from the current movie
     * eg:             A(Rating 1.2)
     *               /   \
     *            B(2.4)  C(3.6)
     *              \     /
     *                D(4.8)
     * In the above example edges represent similarity and the number is rating.
     * getMovieRecommendations(A,2) should return C and D (sorting order doesn't matter so it can also return D and C)
     * getMovieRecommendations(A,4) should return A, B, C, D (it can also return these in any order eg: B,C,D,A)
     * getMovieRecommendations(A,1) should return D. Note distance from A to D doesn't matter, return the highest rated.
     *     
     *     @param movie
     *     @param n is number of movies we want to return
     *     @return List of top rated similar movies
     *
	 * Runtime is O(V*log(n)+E)
	 * Space complexity is O(V+E) */
    
    public static List<Movie> getMovieRecommendations (Movie movie, int n) {
    	
    	// define a list to return
    	List<Movie> result = new ArrayList<Movie>();
    	
    	// define a balanced tree with n top rated movies as nodes
    	TreeSet<Movie> tree = new TreeSet<Movie>(new MovieComparator());

    	// call BFS to fill the tree with movies with rating as a sorting value    	
        
    	// define the queue and append this movie to it
    	Queue<Movie> queue = new LinkedList<Movie>();       
        queue.add(movie);

        while(!queue.isEmpty()) {
            // retrieve the head of the queue
        	Movie curr_movie = queue.remove(); 
            
            // visit similar movies
            for(Movie similarMovie : curr_movie.getSimilarMovies()) {
                if(similarMovie.color == Color.white) {
                	// store them in the queue
                	similarMovie.color = Color.gray;
                	queue.add(similarMovie);     
                	
                	// make sure the tree contains at most n movies
                	if (tree.size()<n) {
                		tree.add(similarMovie);
                	} else {
                		// replace movie with min rating by a movie with better rating
                		if (tree.first().rating<similarMovie.rating) {
                			tree.pollFirst();
                			tree.add(similarMovie);
                	}}
            }}
            movie.color = Color.black;
        }
    	
    	// copy results from tree to list
    	Iterator<Movie> it = tree.iterator();
    	while (it.hasNext()) { 
    		result.add(it.next());
    	}    	
        return result;
    }   
    
    public String toString() {
    	return this.movieId + " " + this.rating;
    }
 }