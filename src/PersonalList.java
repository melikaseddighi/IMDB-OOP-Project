import java.util.ArrayList;

public class PersonalList {
    private String nameOfList;
    private ArrayList<Movie> listMovies=new ArrayList<>();

    public PersonalList(String name){
        setNameOfList(name);
    }
    public String getNameOfList() {
        return nameOfList;
    }

    public void setNameOfList(String nameOfList) {
        this.nameOfList = nameOfList;
    }

    public ArrayList<Movie> getListMovies() {
        return listMovies;
    }

    public void setListMovies(ArrayList<Movie> listMovies) {
        this.listMovies = listMovies;
    }

    public void addMovieToList(Movie movie){
        listMovies.add(movie);
    }
}
