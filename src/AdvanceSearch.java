import java.util.ArrayList;
import java.util.Scanner;

public class AdvanceSearch {

    public static Movie movieAdvanceSearch(){
        //pharaze filter
        int releaseYear=0;
        int minRate=0,maxRate=5;
        Scanner input =new Scanner(System.in);
        String  choose;
        int chooseNumer;
        ArrayList<Movie> movies=new ArrayList<>();
        System.out.println("Enter a phrase to search movie with \n if you dont want to enter it press '0' to skip !");
        choose=input.nextLine();
        if (!choose.equals("0")){
            for (Movie movie:Admin.getMovies()) {
                if (movie.getMovieName().contains(choose)){
                    movies.add(movie);
                }
            }
        }


        //check filters
        ArrayList<Genre> genres=new ArrayList<>();

       while (true){
           System.out.println("Choose you favorite genera or enter '0' to skip !");
           System.out.println("1.ACTION \t 2.DRAMA \t 3.MYSTERY \t 4.HORROR \t 5.FANTASY \t 6.NARRATIVE \t 7.FICTION \t 8.HISTORICALFICTION \t 9.SCIENCEFICTION ");
           chooseNumer=Integer.parseInt(input.nextLine());

           if (chooseNumer==0){
               break;
           }
           if (chooseNumer==1){
               genres.add(Genre.ACTION);
           }
           else if (chooseNumer==2){
               genres.add(Genre.DRAMA);
           }
           else if (chooseNumer==3){
               genres.add(Genre.MYSTERY);
           }
           else if (chooseNumer==4){
               genres.add(Genre.HORROR);
           }
           else if (chooseNumer==5){
               genres.add(Genre.FANTASY);
           }
           else if (chooseNumer==6){
               genres.add(Genre.NARRATIVE);
           }
           else if (chooseNumer==7){
               genres.add(Genre.FICTION);
           }
           else if (chooseNumer==8){
               genres.add(Genre.HISTORICALFICTION);
           }
           else if (chooseNumer==9){
               genres.add(Genre.SCIENCEFICTION);
           }

       }

        ArrayList<Language> languages=new ArrayList<>();

        while (true){
            System.out.println("Choose you favorite language or enter '0' to skip !");
            System.out.println("1.ENGLISH \t 2.PERSIAN \t 3.FRENCH \t 4.RUSSIAN \t 5.ITALIAN \t 6.ARABIC ");
            chooseNumer=Integer.parseInt(input.nextLine());

            if (chooseNumer==0){
                break;
            }
            if (chooseNumer==1){
                languages.add(Language.ENGLISH);
            }
            else if (chooseNumer==2){
                languages.add(Language.PERSIAN);
            }
            else if (chooseNumer==3){
                languages.add(Language.FRENCH);
            }
            else if (chooseNumer==4){
                languages.add(Language.RUSSIAN);
            }
            else if (chooseNumer==5){
                languages.add(Language.ITALIAN);
            }
            else if (chooseNumer==6){
                languages.add(Language.ARABIC);
            }
        }

        System.out.println("Enter the release year or '0' to skip ");
        releaseYear=Integer.parseInt(input.nextLine());
        System.out.println("Enter min and max rate you wanna search on or enter '-1' to skip !");

        System.out.println("Min rate :");
        minRate=Integer.parseInt(input.nextLine());
        if(minRate!=-1){
        System.out.println("Max rate :");
        maxRate=Integer.parseInt(input.nextLine());}
        else {
            minRate=0;
            maxRate=5;
        }

        boolean checkGenre=false;
        boolean checkLanguage=false;
        boolean checkReleasYear=false;
        boolean checkRate=false;


        ArrayList<Movie> movieToSelect=new ArrayList<>();

        if (movies.isEmpty()){//you havent choosen a movie name
            for (Movie searchedMovie:Admin.getMovies()) {
                for (Genre selectedGenre:genres) {
                    if (searchedMovie.getGenreType()!=null && searchedMovie.getGenreType().equals(selectedGenre)){
                        checkGenre=true;
                    }
                }
                for (Language selectedLanguage:languages) {
                    if (searchedMovie.getLanguage()!=null && searchedMovie.getLanguage().equals(selectedLanguage)){
                        checkLanguage=true;
                    }
                }
                if (searchedMovie.getReleaseDate()!=null && searchedMovie.getReleaseDate().getYear()==releaseYear){
                    checkReleasYear=true;
                }
                if (searchedMovie.getTotalRate()>=minRate && searchedMovie.getTotalRate()<=maxRate){
                    checkRate=true;
                }
                if ((checkGenre || searchedMovie.getGenreType()==null) && (checkLanguage || searchedMovie.getLanguage()==null) && (checkRate || searchedMovie.getRates().isEmpty()) && (checkReleasYear || searchedMovie.getReleaseDate()==null)){
                    movieToSelect.add(searchedMovie);
                }
            }

        }
        else{
            for (Movie searchedMovie:movies) {
                for (Genre selectedGenre:genres) {
                    if (searchedMovie.getGenreType()!=null && searchedMovie.getGenreType().equals(selectedGenre)){
                        checkGenre=true;
                    }
                }
                for (Language selectedLanguage:languages) {
                    if (searchedMovie.getLanguage()!=null && searchedMovie.getLanguage().equals(selectedLanguage)){
                        checkLanguage=true;
                    }
                }
                if (searchedMovie.getReleaseDate()!=null && searchedMovie.getReleaseDate().getYear()==releaseYear){
                    checkReleasYear=true;
                }
                if (searchedMovie.getTotalRate()>=minRate && searchedMovie.getTotalRate()<=maxRate){
                    checkRate=true;
                }
                if ((checkGenre || searchedMovie.getGenreType()==null) && (checkLanguage || searchedMovie.getLanguage()==null) && (checkRate || searchedMovie.getRates().isEmpty()) && (checkReleasYear || searchedMovie.getReleaseDate()==null)){
                    movieToSelect.add(searchedMovie);
                }
            }
        }
        int count =1;
        for (Movie printMovie:movieToSelect) {
            System.out.println(count+"."+printMovie.getMovieName());
            count++;
        }
        System.out.println("Which one do you choose ? 'Enter number'");
        chooseNumer=Integer.parseInt(input.nextLine());
        return movieToSelect.get(chooseNumer-1);
    }
}
