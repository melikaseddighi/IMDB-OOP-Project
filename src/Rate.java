

public class Rate {
    private Member rater;
    private int score;
    private Movie movie;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Rate(int score, Member memberRater,Movie movieToRate) {
        setRater(memberRater);
        setScore(score);
        setMovie(movieToRate);
    }

    public Member getRater() {
        return rater;
    }

    public void setRater(Member rater) {
        this.rater = rater;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
