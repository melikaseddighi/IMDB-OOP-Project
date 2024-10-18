public class Seentimes {
    private Member member;
    private Movie movie;
    private int howManyTimeDidMemberSeenThisMovie=0;

  public Seentimes(Member member,Movie movie){
      setMember(member);
      setMovie(movie);
  }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public  int getHowManyTimeDidMemberSeenThisMovie() {
        return howManyTimeDidMemberSeenThisMovie;
    }
    public void setHowManyTimeDidMemberSeenThisMovie(int howManyTimeDidMemberSeenThisMovie) {
        this.howManyTimeDidMemberSeenThisMovie = howManyTimeDidMemberSeenThisMovie;
    }
    public void addToHowMany(){
      howManyTimeDidMemberSeenThisMovie++;

    }
}
