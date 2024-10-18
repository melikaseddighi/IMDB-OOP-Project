
public class EditeSuggestion {
    private Movie movie;
    private Movie changedMovie;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Movie getChangedMovie() {
        return changedMovie;
    }

    public void setChangedMovie(Movie changedMovie) {
        this.changedMovie = changedMovie;
    }

    public EditeSuggestion(Movie movie, Movie changedMovie) {
        setMovie(movie);
        setChangedMovie(changedMovie);
    }
    public EditeSuggestion(Movie movie) {
        setMovie(movie);
    }

}
