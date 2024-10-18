public class Comment {
    String comment;
    Member memberHowComment;
    Movie movie;
    public Comment(String commentText,Member member,Movie movie){
        setComment(commentText);
        setMemberHowComment(member);
        setMovie(movie);
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Member getMemberHowComment() {
        return memberHowComment;
    }

    public void setMemberHowComment(Member memberHowComment) {
        this.memberHowComment = memberHowComment;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
