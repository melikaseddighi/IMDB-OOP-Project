
import java.util.Date;
import java.util.Scanner;


public class Editor extends User {
    public Editor(String userName, String passWord) {
        setUserName(userName);
        setPassWord(passWord);
    }

    public static void MovieEditSuggestion(Movie movie) {
        Movie movieToChange = new Movie();
        movieToChange = movie;
        // Movie movieToChange= (Movie) movie.clone();
        Admin.editMovieByAdmin(movieToChange);
        EditeSuggestion editeSuggestion = new EditeSuggestion(movie, movieToChange);
        Admin.addEditeSuggestion(editeSuggestion);
    }

    public static void peopleEditSuggestion(People people) {
        People peopleToChange = new People();
        peopleToChange = people;
        // Movie movieToChange= (Movie) movie.clone();
        Admin.editePeople(peopleToChange);
        EditPeopleSuggestion editPeopleSuggestion = new EditPeopleSuggestion(people, peopleToChange);
        Admin.getEditPeopleSuggestions().add(editPeopleSuggestion);
    }

    public static void addMissedData(Movie movie) {
        System.out.println("What do you want to add?");
        System.out.println("1. Title");
        System.out.println("2. Plotsumeries");
        System.out.println("3. Posters");
        System.out.println("4. Trial video");
        System.out.println("5. Movie name");
        System.out.println("6. Genre");
        System.out.println("7. Release date");
        System.out.println("8. Language");
        System.out.println("9. Actors list");
        System.out.println("10. Director list");
        System.out.println("11. Writer list");
        System.out.println("0. Exit");
        boolean inEditorAddMiss = true;
        int number;
        Scanner input = new Scanner(System.in);
        while (inEditorAddMiss) {
            number = Integer.parseInt(input.nextLine());
            switch (number) {
                case 1:
                    if (movie.getTitle() == null) {
                        System.out.println("Enter title");
                        movie.setTitle(input.nextLine());
                    } else {
                        System.out.println("data is exist you can't add it");
                    }
                    break;
                case 2:
                    if (movie.getPlotSummeries() == null) {
                        System.out.println("Enter ploSummeries");
                        movie.setPlotSummeries(input.nextLine());
                    } else {
                        System.out.println("data is exist you can't add it");
                    }
                    break;
                case 3:
                    if (movie.getPosters() == null) {
                        System.out.println("Add  poster :");
                        movie.addPosterToList(input.nextLine());
                    } else {
                        System.out.println("data is exist you can't add it");
                    }
                    break;
                case 4:
                    if (movie.getTrailerVideo() == null) {
                        System.out.println("Enter Trial ");
                        movie.setTrailerVideo(input.nextLine());
                    } else {
                        System.out.println("data is exist you can't add it");
                    }
                    break;
                case 5:
                    if (movie.getMovieName() == null) {
                        movie.setMovieName(input.nextLine());
                    } else {
                        System.out.println("data is exist you can't add it");
                    }
                    break;
                case 6:
                    //support different type of genera
                    if (movie.getGenreType() == null) {
                        System.out.println("--------Choose one :--------\n 1. ACTION\t2. DRAMA\t3. MYSTERY\t4. HORROR\t5. FANTASY\t6. NARRATIVE\t7. FICTION\t8. HISTORICALFICTION\t9. SCIENCEFICTION\t0.Exit");
                        try {
                            int choiceM = Integer.parseInt(input.nextLine());
                            switch (choiceM) {
                                case 1:
                                    movie.setGenreType(Genre.ACTION);
                                    break;
                                case 2:
                                    movie.setGenreType(Genre.DRAMA);
                                    break;
                                case 3:
                                    movie.setGenreType(Genre.MYSTERY);
                                    break;
                                case 4:
                                    movie.setGenreType(Genre.HORROR);
                                    break;
                                case 5:
                                    movie.setGenreType(Genre.FANTASY);
                                    break;
                                case 6:
                                    movie.setGenreType(Genre.NARRATIVE);
                                    break;
                                case 7:
                                    movie.setGenreType(Genre.FICTION);
                                    break;
                                case 8:
                                    movie.setGenreType(Genre.HISTORICALFICTION);
                                    break;
                                case 9:
                                    movie.setGenreType(Genre.SCIENCEFICTION);
                                    break;

                                case 0:
                                    System.out.println("Exit");
                                    break;
                                default:
                                    System.out.println("Wrong input");

                            }
                        } catch (Exception e) {
                            System.out.println("YOU MUST ENTER NUMBER ! \t TRY AGAIN");
                        }
                    } else {
                        System.out.println("data is exist you can't add it");
                    }
                    break;
                case 7:
                    if (movie.getReleaseDate() == null) {
                        System.out.println("Enter year:\n month:\n day:");
                        movie.setReleaseDate(new Date(Integer.parseInt(IMDB.input.nextLine()), Integer.parseInt(IMDB.input.nextLine()), Integer.parseInt(IMDB.input.nextLine())));
                    } else {
                        System.out.println("data is exist you can't add it");
                    }
                    break;
                case 8:
                    //support different type of language
                    if (movie.getLanguage() == null) {
                        System.out.println("--------Choose one :--------\n 1. ENGLISH\t2. PERSIAN\t3. FRENCH\t4. RUSSIAN\t5. ITALIAN\t6. ARABIC\t0.Exit");
                        try {
                            int choiceL = Integer.parseInt(input.nextLine());

                            switch (choiceL) {
                                case 1:
                                    movie.setLanguage(Language.ENGLISH);
                                    break;
                                case 2:
                                    movie.setLanguage(Language.PERSIAN);
                                    break;
                                case 3:
                                    movie.setLanguage(Language.FRENCH);
                                    break;
                                case 4:
                                    movie.setLanguage(Language.RUSSIAN);
                                    break;
                                case 5:
                                    movie.setLanguage(Language.ITALIAN);
                                    break;
                                case 6:
                                    movie.setLanguage(Language.ARABIC);
                                    break;
                                case 0:
                                    System.out.println("Exit");
                                    break;
                                default:
                                    System.out.println("Wrong input");
                            }
                        } catch (Exception e) {
                            System.out.println("YOU MUST ENTER NUMBER ! \t TRY AGAIN");
                        }
                    } else {
                        System.out.println("data is exist you can't add it");
                    }
                    break;
                case 9:
                    if (movie.getActor() == null) {
                        System.out.println("Actor name :");
                        movie.addActorToMovie(input.nextLine());
                    } else {
                        System.out.println("data is exist you can't add it");
                    }
                    break;
                case 10:
                    if (movie.getDirector() == null) {
                        System.out.println("Director name :");
                        movie.addDirectorToMovie(input.nextLine());
                    } else {
                        System.out.println("data is exist you can't add it");
                    }
                    break;
                case 11:
                    if (movie.getWriter() == null) {
                        System.out.println("Writer name :");
                        movie.addWriterToMovie(input.nextLine());
                    } else {
                        System.out.println("data is exist you can't add it");
                    }
                    break;
                case 0:
                    inEditorAddMiss = false;
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Wrong number has entered !!!");
            }
        }
    }


    public static void PeopleAddMissedData(People people) {
        System.out.println("which part do you wanna add ?");
        System.out.println("1.name and lastname\n2.age\n3.profesiones\n0.Exit");
        Scanner input = new Scanner(System.in);
        try {
            int choose = Integer.parseInt(input.nextLine());
            switch (choose) {
                case 1:
                    if (people.getNameLastName() == null) {
                        System.out.println("Enter name you want to assign ");
                        people.setNameLastName(input.nextLine());
                    } else {
                        System.out.println("data is exist you can't add it");
                    }
                    break;
                case 2:
                    if (people.getAge() == 0) {
                        System.out.println("Enter age you want to assign ");
                        people.setAge(Integer.parseInt(input.nextLine()));
                    } else {
                        System.out.println("data is exist you can't add it");
                    }
                    break;
                case 3:
                    boolean isTrue = true, inProf = true;
                    if (people.getPeopleTypes().isEmpty()) {
                        while (inProf) {
                            System.out.println("What do you want to do ?");
                            System.out.println("1. Add profetion");
                            System.out.println("0. Exit");
                            try {
                                int chooseP = Integer.parseInt(input.nextLine());
                                switch (chooseP) {
                                    case 1:
                                        while (isTrue) {
                                            System.out.println(" What he/she profetions ?");
                                            System.out.println("1.Actor\t2.Director\t3.Writer\t0.No more profetion");
                                            choose = Integer.parseInt(input.nextLine());
                                            switch (choose) {
                                                case 0:
                                                    isTrue = false;
                                                    break;
                                                case 1:
                                                    people.addPeopleType(PeopleType.ACTOR);
                                                    break;
                                                case 2:
                                                    people.addPeopleType(PeopleType.DIRECTOR);
                                                    break;
                                                case 3:
                                                    people.addPeopleType(PeopleType.WRITER);
                                                    break;
                                                default:
                                                    System.out.println("Wrong number has entered");
                                                    break;
                                            }
                                        }
                                        break;
                                    case 0:
                                        inProf = false;
                                        System.out.println("Exit");
                                        break;
                                    default:
                                        System.out.println("Wrong number");
                                }
                            } catch (Exception e) {
                                System.out.println("Wrong input");
                            }
                        }
                    } else {
                        System.out.println("data is exist you can't add it");
                    }
                    break;
                case 0:
                    System.out.println("Exit");
                default:
                    System.out.println("Wrong number has entered");
            }
        } catch (
                Exception e) {
            System.out.println("Wrong input");
        }
    }
}


