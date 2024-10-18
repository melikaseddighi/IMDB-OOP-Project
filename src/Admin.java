import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Admin extends User {
    private static ArrayList<Like> likes = new ArrayList<>();
    private static ArrayList<Movie> movies = new ArrayList<>();//movies in program
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Report> reports = new ArrayList<>();
    private static ArrayList<Forum> forums = new ArrayList<>();
    private static ArrayList<People> peoples = new ArrayList<>();
    private static ArrayList<EditeSuggestion> editeSuggestions = new ArrayList<>();
    private static ArrayList<String> rules = new ArrayList<>();
    private static ArrayList<EditPeopleSuggestion> editPeopleSuggestions=new ArrayList<>();

    private static ArrayList<DirectMassage> directMassages=new ArrayList<>();
    private static ArrayList<GroupMassage> groupMassages=new ArrayList<>();

    public static ArrayList<DirectMassage> getDirectMassages() {
        return directMassages;
    }

    public static void setDirectMassages(ArrayList<DirectMassage> directMassages) {
        Admin.directMassages = directMassages;
    }

    public static ArrayList<GroupMassage> getGroupMassages() {
        return groupMassages;
    }

    public static void setGroupMassages(ArrayList<GroupMassage> groupMassages) {
        Admin.groupMassages = groupMassages;
    }

    public static ArrayList<EditPeopleSuggestion> getEditPeopleSuggestions() {
        return editPeopleSuggestions;
    }

    public static void setEditPeopleSuggestions(ArrayList<EditPeopleSuggestion> editPeopleSuggestions) {
        Admin.editPeopleSuggestions = editPeopleSuggestions;
    }

    public Admin(String userName, String passWord) {
        setUserName(userName);
        setPassWord(passWord);
    }

    public static void addLike(Like like) {
        likes.add(like);
    }

    public static ArrayList<Like> getLikes() {
        return likes;
    }

    public static void setLikes(ArrayList<Like> likes) {
        Admin.likes = likes;
    }

    public static void approvalMovie() {
        int counter = 1;
        int choose;
        int setIndex ;
        System.out.println("This movies has edite suggestion which one you want to check ?!");
        for (EditeSuggestion editeSuggestion : editeSuggestions) {
            System.out.println(counter + "." + editeSuggestion.getChangedMovie().getMovieName());
            counter++;
        }
        Scanner input = new Scanner(System.in);
        try{
        choose = Integer.parseInt(input.nextLine());
        System.out.println("Actual movie !");
        editeSuggestions.get(choose - 1).getMovie().seeMovieDetails();
        System.out.println("Changed movie !");
        editeSuggestions.get(choose - 1).getChangedMovie().seeMovieDetails();
        System.out.println("What do you want do ?\n1.Approve\t2.Reject");
        while (true) {
            try {
            setIndex = Integer.parseInt(input.nextLine());
            if (setIndex == 1) {
                editeSuggestions.get(choose - 1).setMovie(editeSuggestions.get(choose - 1).getChangedMovie());
                break;
            } else if (setIndex == 2) {
                editeSuggestions.remove(choose - 1);
                break;
            }
            else if (setIndex==0){
                System.out.println("Exit");
            }
            else{
                System.out.println("Wrong input");
            }
            }catch (Exception e){
                System.out.println("Wrong input");

            }
        }}catch (Exception e){
            System.out.println("Enter number");
        }
    }

    public static User searchUsers(String userName) {
        for (User whichUser : users) {
            if (whichUser.getUserName().equals(userName)) {
                return whichUser;
            }
        }
        return null;
    }
    public static GroupMassage searchGroups(String groupName) {
        for (GroupMassage group:getGroupMassages()) {
            if (group.getGroupName().equals(groupName)) {
                return group;
            }
        }
        return null;
    }

    public static void deleteUser(String userName) {
        for (User whichUser : users) {
            if (whichUser.getUserName().equals(userName)) {
                users.remove(whichUser);
                break;
            }
        }
    }

    public static void addUser() {
        System.out.println("Choose the user type you wanna add:\n1.Member\t2.Editor\t3.Admin");
        Scanner input = new Scanner(System.in);
        int choose = Integer.parseInt(input.nextLine());
        String userName = input.nextLine();

        while (searchUsers(userName) != null) {
            System.out.println("Entered username exist try another one !");
            userName = input.nextLine();
        }
        String passWord = input.nextLine();
        switch (choose) {
            case 1:
                users.add(new Member(userName, passWord));
                break;
            case 2:
                users.add(new Editor(userName, passWord));
                break;
            case 3:
                users.add(new Admin(userName, passWord));
                break;

        }
    }


    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<User> users) {
        Admin.users = users;
    }

    public static ArrayList<EditeSuggestion> getEditeSuggestions() {
        return editeSuggestions;
    }

    public static void setEditeSuggestions(ArrayList<EditeSuggestion> editeSuggestions) {
        Admin.editeSuggestions = editeSuggestions;
    }

    private static void deleteReview(Movie movie, Review review) {
        movie.deleteReview(review);
    }

    public static void deleteForum(int indexOfForum) {
        forums.remove(indexOfForum);
    }

    public static void addForum(String name) {
        forums.add(new Forum(name));
    }

    public static ArrayList<Forum> getForums() {
        return forums;
    }

    public static void setForums(ArrayList<Forum> forums) {
        Admin.forums = forums;
    }

    public static ArrayList<Movie> getMovies() {
        return movies;
    }

    public static void setMovies(ArrayList<Movie> movies) {
        Admin.movies = movies;
    }

    public static ArrayList<User> getUsesrs() {
        return users;
    }

    public static void setUsesrs(ArrayList<User> usesrs) {
        Admin.users = usesrs;
    }

    public static ArrayList<People> getPeoples() {
        return peoples;
    }

    public static void setPeoples(ArrayList<People> peoples) {
        Admin.peoples = peoples;
    }

    public static ArrayList<Report> getReports() {
        return reports;
    }

    public static void setReports(ArrayList<Report> reports) {
        Admin.reports = reports;
    }

    public static ArrayList<String> getRules() {
        return rules;
    }

    public static void setRules(ArrayList<String> rules) {
        Admin.rules = rules;
    }

    public static void addRule(String rule) {
        rules.add(rule);
    }

    public static void addReport(Report report) {
        reports.add(report);
    }

    public static void addEditeSuggestion(EditeSuggestion editeSuggestion) {
        editeSuggestions.add(editeSuggestion);
    }


    public static void addMovie(String name) {
        movies.add(new Movie(name));
    }

    public static void deleteMovie(int indexOfMovie) {
        movies.remove(indexOfMovie);
    }

    public static void addPeople(People people) {
        peoples.add(people);
    }

    public static void deletePeople(int indexOfPeople) {
        peoples.remove(indexOfPeople);
    }

    public static void editePeople(People people) {
        System.out.println("which part do you wanna edit ?");
        System.out.println("1.name and lastname\n2.age\n3.profesiones\n0.Exit");
        Scanner input = new Scanner(System.in);
        try {
            int choose = Integer.parseInt(input.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("Enter new name you want to assign ");
                    people.setNameLastName(input.nextLine());
                    break;
                case 2:
                    System.out.println("Enter age you want to assign ");
                    people.setAge(Integer.parseInt(input.nextLine()));
                    break;
                case 3:
                    boolean isTrue = true, inProf = true;
                    int counter = 1;
                    System.out.println("Person profetions");
                    for (PeopleType peopleType : people.getPeopleTypes()) {
                        System.out.println(counter + " . " + peopleType);
                    }
                    while (inProf) {
                        System.out.println("What do you want to do ?");
                        System.out.println("1. Add profetion");
                        System.out.println("2. Edit Profetion");
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
                                case 2:
                                    while (isTrue) {
                                        System.out.println(" Which profetion you want to edit ? form profetion list");
                                        try {
                                            int index = Integer.parseInt(input.nextLine());
                                            System.out.println("Edit profetion to : 1.Actor\t2.Director\t3.Writer\t0.No more profetion");
                                            choose = Integer.parseInt(input.nextLine());
                                            switch (choose) {
                                                case 0:
                                                    isTrue = false;
                                                    break;
                                                case 1:
                                                    people.getPeopleTypes().set(index,PeopleType.ACTOR);
                                                    break;
                                                case 2:
                                                    people.getPeopleTypes().set(index,PeopleType.DIRECTOR);
                                                    break;
                                                case 3:
                                                    people.getPeopleTypes().set(index,PeopleType.WRITER);
                                                    break;
                                                default:
                                                    System.out.println("Wrong number has entered");
                                                    break;
                                            }
                                        } catch (Exception e) {
                                            System.out.println("Wrong input");
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


    public static void printRules() {
        int counter = 1;
        if (!rules.isEmpty()) {
            for (String rule : rules) {
                System.out.println(counter + "." + rule);
                counter++;
            }
        } else {
            System.out.println("There is no rule !");
        }
    }

    public static void editMovieByAdmin(Movie movie) {
        System.out.println("What do you want to edit?");
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
        boolean inAdminMovieEdit = true;
        int number;
        Scanner input = new Scanner(System.in);
        int choose, indexToChange, counter;
        while (inAdminMovieEdit) {
            System.out.println("Enter number");
            try {
                number = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.out.println("Wrong input");
                continue;
            }
            switch (number) {
                case 1:
                    movie.setTitle(input.nextLine());
                    break;
                case 2:
                    movie.setPlotSummeries(input.nextLine());
                    break;
                case 3:
                    counter = 1;//posters list
                    System.out.println("What do you want to do?\n1.add\n2.delete ");
                    try {
                        choose = Integer.parseInt(input.nextLine());
                        for (String poster : movie.getPosters()) {
                            System.out.println(counter + " . " + poster);
                            counter++;
                        }
                        System.out.println("Which one you one to choose?");
                        try {
                            indexToChange = Integer.parseInt(input.nextLine());

                            if (choose == 1) {
                                System.out.println("Enter changes :");
                                movie.changePosterList(input.nextLine(), indexToChange);
                            } else if (choose == 2) {
                                movie.DeletePosterList(indexToChange);
                            }
                        } catch (Exception e) {
                            System.out.println("YOU MUST ENTER NUMBER ! \t TRY AGAIN");
                        }
                    } catch (Exception e) {
                        System.out.println("YOU MUST ENTER NUMBER ! \t TRY AGAIN");
                    }
                    break;
                case 4:
                    movie.setTrailerVideo(input.nextLine());
                    break;
                case 5:
                    movie.setMovieName(input.nextLine());
                    break;
                case 6:
                    //support different type of genera

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
                    break;
                case 7:
                    System.out.println("Enter year:\n month:\n day:");
                    movie.setReleaseDate(new Date(Integer.parseInt(IMDB.input.nextLine()), Integer.parseInt(IMDB.input.nextLine()), Integer.parseInt(IMDB.input.nextLine())));
                    break;
                case 8:
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
                    break;
                case 9://actor list
                    counter = 1;
                    System.out.println("What do you want to do?\n1.add\n2.delete ");
                    try {
                        choose = Integer.parseInt(input.nextLine());
                        for (People actor : movie.getActor()) {
                            System.out.println(counter + " . " + actor.getNameLastName());
                            counter++;
                        }
                        System.out.println("Which one you one to choose?");
                        try {
                            indexToChange = Integer.parseInt(input.nextLine());

                            if (choose == 1) {
                                System.out.println("Write changes");
                                movie.changeActorList((String) input.nextLine(), indexToChange);
                            } else if (choose == 2) {
                                movie.DeleteActorFromList(indexToChange);
                            }
                        } catch (Exception e) {
                            System.out.println("YOU MUST ENTER NUMBER ! \t TRY AGAIN");
                        }
                    } catch (Exception e) {
                        System.out.println("YOU MUST ENTER NUMBER ! \t TRY AGAIN");
                    }
                    break;
                case 10://director
                    counter = 1;
                    System.out.println("What do you want to do?\n1.add\n2.delete ");
                    try {
                        choose = Integer.parseInt(input.nextLine());
                        for (People director : movie.getDirector()) {
                            System.out.println(counter + " . " + director.getNameLastName());
                            counter++;
                        }
                        System.out.println("Which one you one to choose?");
                        try {
                            indexToChange = Integer.parseInt(input.nextLine());

                            if (choose == 1) {
                                System.out.println("Write changes");
                                movie.changeDirectorList(input.nextLine(), indexToChange);
                            } else if (choose == 2) {
                                movie.DeleteDirectorFromList(indexToChange);
                            }
                        } catch (Exception e) {
                            System.out.println("YOU MUST ENTER NUMBER ! \t TRY AGAIN");
                        }
                    } catch (Exception e) {
                        System.out.println("YOU MUST ENTER NUMBER ! \t TRY AGAIN");
                    }
                    break;
                case 11:
                    counter = 1;//writer list
                    System.out.println("What do you want to do?\n1.add\n2.delete ");
                    try {
                        choose = Integer.parseInt(input.nextLine());
                        for (People writer : movie.getWriter()) {
                            System.out.println(counter + " . " + writer.getNameLastName());
                            counter++;
                        }
                        System.out.println("Which one you one to choose?");
                        try {
                            indexToChange = Integer.parseInt(input.nextLine());

                            if (choose == 1) {
                                System.out.println("Write changes");
                                movie.changeWriterList(input.nextLine(), indexToChange);
                            } else if (choose == 2) {
                                movie.DeleteWriterFromList(indexToChange);
                            }
                        } catch (Exception e) {
                            System.out.println("YOU MUST ENTER NUMBER ! \t TRY AGAIN");
                        }
                    } catch (Exception e) {
                        System.out.println("YOU MUST ENTER NUMBER ! \t TRY AGAIN");
                    }
                    break;
                case 12://reviews
                    counter = 1;
                    for (Review review : movie.getReviews()) {
                        System.out.println(counter + " . " + review.getMember() + " : " + review.getText());
                        counter++;
                    }
                    System.out.println("Enter number to delete or '0' to exit");
                    try {
                        choose = Integer.parseInt(input.nextLine());
                        if (choose != 0) {
                            movie.getReviews().remove(choose - 1);
                        } else {
                            System.out.println("Exit ");
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("YOU MUST ENTER NUMBER ! \t TRY AGAIN");
                    }
                    break;
                case 0:
                    inAdminMovieEdit = false;
                    System.out.println("Exit ");
                    break;
                default:
                    System.out.println("Wrong number has entered !!!");
            }
        }
    }

    public static void approvalPeople() {
        int counter = 1;
        int choose;
        int setIndex = 0;
        System.out.println("This people has edite suggestion which one you want to check ?!");
        for (EditPeopleSuggestion editPeopleSuggestion : getEditPeopleSuggestions()) {
            System.out.println(counter + "." + editPeopleSuggestion.getChangedPeople().getNameLastName());
            counter++;
        }
        Scanner input = new Scanner(System.in);
        try {
        choose = Integer.parseInt(input.nextLine());
        System.out.println("Actual person !");
        editPeopleSuggestions.get(choose - 1).getPeople().seePersonDetails();
        System.out.println("Changed person !");
        editPeopleSuggestions.get(choose - 1).getChangedPeople().seePersonDetails();
        System.out.println("What do you want do ?\n1.Approve\t2.Reject\t0.Exit");
        while (true) {
            try {
                setIndex = Integer.parseInt(input.nextLine());
                if (setIndex == 1) {
                    getEditPeopleSuggestions().get(choose - 1).setPeople(getEditPeopleSuggestions().get(choose - 1).getChangedPeople());
                    break;
                } else if (setIndex == 2) {
                    getEditPeopleSuggestions().remove(choose - 1);
                    break;
                }
                else if(setIndex==0){
                    System.out.println("Exit");
                    break;
                }
                else {
                    System.out.println("not found try again");
                }
            }catch (Exception e){
                System.out.println("Wrong input");
            }
        }
        }catch (Exception e){
            System.out.println("Enter number");
        }
    }
}
