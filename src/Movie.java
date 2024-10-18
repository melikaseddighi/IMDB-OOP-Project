import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Movie {
    private String title;
    private String PlotSummeries;
    private ArrayList<String> posters=new ArrayList<>();;
    private String trailerVideo;
    private String movieName;
    private Genre genreType;
    private Date releaseDate;
    private Language language;
    private ArrayList<Rate> rates = new ArrayList<>();
    private ArrayList<Review> reviews = new ArrayList<>();
    private ArrayList<People> actors = new ArrayList<>();//
    private ArrayList<People> directors = new ArrayList<>();//
    private ArrayList<People> writers = new ArrayList<>();//
    private ArrayList<Comment> comments = new ArrayList<>();
    private ArrayList<Like> likes = new ArrayList<>();

    public void likeMovie(Like like) {
        likes.add(like);
    }

    public ArrayList<Like> getLikes() {
        return likes;
    }

    public void setLikes(ArrayList<Like> likes) {
        this.likes = likes;
    }

    public ArrayList<People> getActors() {
        return actors;
    }

    public void setActors(ArrayList<People> actors) {
        this.actors = actors;
    }

    public ArrayList<People> getDirectors() {
        return directors;
    }

    public void setDirectors(ArrayList<People> directors) {
        this.directors = directors;
    }

    public ArrayList<People> getWriters() {
        return writers;
    }

    public void setWriters(ArrayList<People> writers) {
        this.writers = writers;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    Scanner input = new Scanner(System.in);

    public Movie() {
    }

    public Movie(String movieName) {
        setMovieName(movieName);
    }

    public Movie(String name, Language language, Date releaseDate, Genre genreType) {
        setMovieName(name);
        setLanguage(language);
        setReleaseDate(releaseDate);
        setGenreType(genreType);

    }

    public Genre getGenreType() {
        return genreType;
    }

    public void setGenreType(Genre genreType) {
        this.genreType = genreType;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void addActorToMovie(People actor1) {

        actors.add(actor1);
    }

    public void addDirectorToMovie(People director1) {
        directors.add(director1);
    }

    public void addWriterToMovie(People writer1) {

        writers.add(writer1);
    }


    public void addActorToMovie(String actorName) {
        People newActor = new People(actorName);
        newActor.addPeopleType(PeopleType.ACTOR);
        actors.add(newActor);
    }

    public void addDirectorToMovie(String directorName) {
        People newDirector = new People(directorName);
        newDirector.addPeopleType(PeopleType.DIRECTOR);
        actors.add(newDirector);
    }

    public void addWriterToMovie(String writerName) {
        People newWriter = new People(writerName);
        newWriter.addPeopleType(PeopleType.WRITER);
        actors.add(newWriter);
    }

    public ArrayList<People> getActor() {
        return actors;
    }

    public void setActor(ArrayList<People> actor) {
        this.actors = actor;
    }

    public ArrayList<People> getDirector() {
        return directors;
    }

    public void setDirector(ArrayList<People> director) {
        this.directors = director;
    }

    public ArrayList<People> getWriter() {
        return writers;
    }

    public void setWriter(ArrayList<People> writer) {
        this.writers = writer;
    }

    public ArrayList<Rate> getRates() {
        return rates;
    }

    public void setRates(ArrayList<Rate> rates) {
        this.rates = rates;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    public void addRateToMovie(Rate rate) {
        for (Rate whichRate : rates) {
            if (whichRate.getRater().equals(rate.getRater())) {
                whichRate.setScore(rate.getScore());
                return;
            }
        }
        rates.add(rate);
    }

    public void addReviewToMovie(Review review) {
        reviews.add(review);
    }

    public void deleteReview(Review review) {
        reviews.remove(review);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlotSummeries() {
        return PlotSummeries;
    }

    public void setPlotSummeries(String plotSummeries) {
        PlotSummeries = plotSummeries;
    }

    public ArrayList<String> getPosters() {
        return posters;
    }

    public void setPosters(ArrayList<String> posters) {
        this.posters = posters;
    }

    public void addPosterToList(String poster) {
        posters.add(poster);
    }

    public String getTrailerVideo() {
        return trailerVideo;
    }

    public void setTrailerVideo(String trailerVideo) {
        this.trailerVideo = trailerVideo;
    }

    public float getTotalRate() {
        float totalRate = 0;
        int count = 0;
        for (Rate rate : rates) {
            totalRate += rate.getScore();
            count++;
        }
        if(count>0){
            totalRate /= count;
            return totalRate;
        }
        return 0;

    }

    public static void addMovie(Movie movie) {
        Admin.getMovies().add(movie);
    }

    public static void seeChart() {
        //Highest Rated
        System.out.println("--------Highest Rated , Most Popular Movies--------");
        if (Admin.getMovies() == null) {
            System.out.println("There is no movie ");
            return;
        }
        for (Movie movie : Admin.getMovies()) {
            if (movie.getTotalRate() >= 9) {
                System.out.println(movie.getMovieName() + "\t" + movie.getTotalRate());
            }
        }
    }

    public static void seeMoviesByGenre(Genre genreType1) {
        for (Movie movie : Admin.getMovies()) {
            if (movie.getGenreType().equals(genreType1)) {
                System.out.println(movie.getMovieName());
            }
        }
    }

    public static void seeMoviesByLanguage(Language language1) {
        for (Movie movie : Admin.getMovies()) {
            if (movie.getLanguage().equals(language1)) {
                System.out.println(movie.getMovieName());
            }
        }
    }

    public static void seeMoviesByReleaseDate(int year) {
        for (Movie movie : Admin.getMovies()) {
            if (movie.getReleaseDate().getYear()==(year)) {
                System.out.println(movie.getMovieName());
            }
        }
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void changePosterList(String posterContent, int indexToChange) {
        posters.set(indexToChange, posterContent);
    }

    public void DeletePosterList(int indexToChange) {
        posters.remove(indexToChange);
    }

    public void DeleteActorFromList(int indexToChange) {
        actors.remove(indexToChange);
    }

    public void DeleteDirectorFromList(int indexToChange) {
        directors.remove(indexToChange);
    }

    public void DeleteWriterFromList(int indexToChange) {
        writers.remove(indexToChange);
    }

    public void changeActorList(String name, int indexToChange) {
        boolean thereIs = false;
        for (People whichActor : Admin.getPeoples()) {
            if (whichActor.getNameLastName().equals(name)) {
                actors.set(indexToChange, whichActor);
                thereIs = true;
                break;
            }
        }
        if (!thereIs) {
            System.out.println("Person not found make new on");
            People people = new People(name);
            people.addPeopleType(PeopleType.ACTOR);
            actors.set(indexToChange, people);

        }

    }

    public void changeDirectorList(String name, int indexToChange) {
        boolean thereIs = false;
        for (People whichActor : Admin.getPeoples()) {
            if (whichActor.getNameLastName().equals(name)) {
                directors.set(indexToChange, whichActor);
                thereIs = true;
                break;
            }
        }
        if (!thereIs) {
            System.out.println("Person not found make new on");
            People people = new People(name);
            people.addPeopleType(PeopleType.DIRECTOR);
            directors.set(indexToChange, people);
        }

    }


    public void changeWriterList(String name, int indexToChange) {
        boolean thereIs = false;
        for (People whichActor : Admin.getPeoples()) {
            if (whichActor.getNameLastName().equals(name)) {
                writers.set(indexToChange, whichActor);
                thereIs = true;
                break;
            }
        }
        if (!thereIs) {
            System.out.println("Person not found make new on");
            People people = new People(name);
            people.addPeopleType(PeopleType.WRITER);
            writers.set(indexToChange, people);

        }
    }

    public void seeMovieDetails() {

        System.out.println("Title of movie  : " + getMovieName());
        System.out.println("Movies plot summeries : " + getPlotSummeries());
        System.out.println("Poster's are");
        for (String poster : getPosters()) {
            System.out.print(poster + "\t");
        }
        System.out.println(getTrailerVideo());
        System.out.println(getMovieName());
        System.out.println(getGenreType());
        System.out.println(getReleaseDate());
        System.out.println(getLanguage());
        System.out.println(getTrailerVideo());
        System.out.println("Total rate is :"+getTotalRate());
        System.out.println("Movie's actors are :");
        for (People actor : getActor()) {
            System.out.print(actor + "\t");
        }
        System.out.println("Movie's directors are :");

        for (People director : getDirector()) {
            System.out.print(director + "\t");
        }
        System.out.println("Movie's writers are :");

        for (People writer : getWriter()) {
            System.out.print(writer + "\t");
        }
        System.out.println("Movie's reviews are :");
        for (Review review : getReviews()) {
            System.out.println(review.getMember().getUserName()+"'s review :"+ review.getText());
            if (review.getReviewParent()!=null){
                System.out.println("and it's rereviwe");
                System.out.println(review.getReviewParent().getMember().getUserName()+"'s review :"+ review.getText());
            }
        }

    }

    public static Movie showAllMoviesAndret(ArrayList<Movie> movies) {
        int counter = 1;
        int choice;
        Scanner input = new Scanner(System.in);
        for (Movie movie : movies) {
            System.out.println(counter + "." + movie.getMovieName());
            counter++;
        }
        while (true) {
            System.out.println("Enter your choice ! or 0 to exit ");
            choice = Integer.parseInt(input.nextLine());
            if (choice == 0) {
                return null;
            }
            try {
                return movies.get(choice - 1);
            } catch (Exception e) {
                System.out.println("Wrong choice!");
            }
        }
    }

    public void seeMovieReviews(Member member) {
        int counter=1;
        Scanner input =new Scanner(System.in);
        int choice,choice1;
        String reportText;
        for (Review review : reviews) {
            System.out.println(counter+". "+review.getText());
            counter++;
        }
        System.out.println("--------Which review you choose? (Enter number)--------");
        try {
             choice=Integer.parseInt(input.nextLine());
        }catch (Exception e){
            System.out.println("Didn't enter number");
            return;
        }
        Review chosenReview=reviews.get(choice-1);
        System.out.println("--------What do you want to do with this Review ?--------");
        System.out.println("1. Mark as helpful/not helpful");
        System.out.println("2. Like review");
        System.out.println("3. Report review");
        System.out.println("4. reReview this review");
        System.out.println("0. Exit");
        try {
            choice=Integer.parseInt(input.nextLine());
        }catch (Exception e){
            System.out.println("Didn't enter number");
            return;
        }
        switch (choice){
            case 1:
                System.out.println("--------Enter '1' for helpful and '0' for not helpful--------");
                try {
                    choice1=Integer.parseInt(input.nextLine());
                }catch (Exception e){
                    System.out.println("Didn't enter number");
                    return;
                }
                if(choice1==1){
                    chosenReview.addReviewRate(ReviewRate.HELPFULL);
                }else if(choice1==0){
                    chosenReview.addReviewRate(ReviewRate.NOTHELPFULL);
                }
                break;
            case 2:
                Like like =new Like(member,chosenReview);
                chosenReview.likeReview(like);
                Admin.addLike(like);
                System.out.println("You've like this review ");
                break;
            case 3://report
                System.out.println("Write report text");
                reportText=input.nextLine();
                Report report=new Report(chosenReview,reportText);
                Admin.addReport(report);
                break;
            case 4:
                System.out.println("Enter your review content");
                String text = input.nextLine(),ch;
                System.out.println("1.if review is spoiler and 2.if review is not spoiler ");
                ch=input.nextLine();
                if (ch.equals("1")){
                    Review reReview=new Review(text,member,this,SpoilerStatus.SPOILER);
                    member.getReviews().add(reReview);
                    chosenReview.setReviewParent(reReview);
                }
                else if(ch.equals("2")){
                    Review reReview=new Review(text,member,this,SpoilerStatus.NOTSPOILER);
                    member.getReviews().add(reReview);
                    chosenReview.setReviewParent(reReview);
                }
                else{
                    System.out.println("Wrong input");
                }
                break;
            case 0:
                System.out.println("Exit the process");
                return;
            default:
                System.out.println("--------Invalid input--------");
                break;
        }
    }
    public static Movie SearchMoive(String movieName){
        int counter=1;
        Scanner input=new Scanner(System.in);
        ArrayList<Movie> searchedMovies=new ArrayList<>();
        for (Movie movie:Admin.getMovies()){
            if (movie.getMovieName().contains(movieName)){
                System.out.println(counter+" . "+movie.getMovieName());
                searchedMovies.add(movie);
                counter++;
            }
        }
        while (true) {
            System.out.println("---------Choose a movie-------- ");
            System.out.println("0. Exit");
            int num;
            try {
                num = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.out.println("Wrong input");
                continue;
            }if (num==0){
                System.out.println("Exit");
                return null;
            }
            return searchedMovies.get(num - 1);

        }
    }
    public void deleteMovieReview(){
        int counter=1;
        Scanner input =new Scanner(System.in);
        int choice,choice1;
        for (Review review : getReviews()) {
            System.out.println(counter+". "+review.getText());
            counter++;
        }
        System.out.println("--------Which review you choose? (Enter number) or '0' to exit--------");
        try {
            choice=Integer.parseInt(input.nextLine());
            if(choice==0){
                System.out.println("Exit");
            }
            else if(choice<=getReviews().size()){
                getReviews().remove(choice-1);
                System.out.println("Review deleted");
            }
            else{
                System.out.println("Review not found");
            }
        }catch (Exception e){
            System.out.println("Didn't enter number");
        }
    }

}
