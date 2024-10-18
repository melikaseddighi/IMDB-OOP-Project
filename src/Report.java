public class Report {
    private String text;
    private Movie movie;
    private Review review;

    public Report(Movie movie,String text){
        setMovie(movie);
        setText(text);
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public Report(Review review,String text){
        setReview(review);
        setText(text);
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }


}
