import java.util.ArrayList;

public class Review {
    private String text;
    private SpoilerStatus spoilerStatus;
    private ArrayList<ReviewRate> reviewRates=new ArrayList<>();
    private Member member;
    private Movie movie;
    private ArrayList<Like> likes = new ArrayList<>();
    private Review reviewParent;

    public Review getReviewParent() {
        return reviewParent;
    }
    public void setReviewParent(Review reviewParent) {
        this.reviewParent = reviewParent;
    }

    public void likeReview(Like like) {
        likes.add(like);
    }

    public ArrayList<Like> getLikes() {
        return likes;
    }

    public void setLikes(ArrayList<Like> likes) {
        this.likes = likes;
    }

    public ArrayList<ReviewRate> getReviewRates() {
        return reviewRates;
    }
    public void setReviewRates(ArrayList<ReviewRate> reviewRates) {
        this.reviewRates = reviewRates;
    }
    public Review(String text, Member member, Movie movie,SpoilerStatus spoilerStatus) {
        setSpoilerStatus(spoilerStatus);
        setText(text);
        setMember(member);
        setMovie(movie);
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public SpoilerStatus getSpoilerStatus() {
        return spoilerStatus;
    }

    public void setSpoilerStatus(SpoilerStatus spoilerStatus) {
        this.spoilerStatus = spoilerStatus;
    }

    public ArrayList<ReviewRate> getReviewRate() {
        return reviewRates;
    }

    public void setReviewRate(ArrayList<ReviewRate> reviewRate) {
        this.reviewRates = reviewRate;
    }

    public void addReviewRate(ReviewRate reviewRate) {
        reviewRates.add(reviewRate);
    }

    public ReviewRate reviewRateOFReview() {
        int isHelpFull = 0, notHelpFull = 0;
        for (ReviewRate reviewRate : reviewRates) {
            if (reviewRate.equals(ReviewRate.HELPFULL)) {
                isHelpFull++;
            } else {
                notHelpFull++;
            }
        }
        if (isHelpFull >= notHelpFull) {
            return ReviewRate.HELPFULL;
        } else {
            return ReviewRate.NOTHELPFULL;
        }
    }
}