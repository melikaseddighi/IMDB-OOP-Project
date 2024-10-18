
import java.util.Date;
import java.util.Scanner;


public class IMDB {
    static Scanner input = new Scanner(System.in);
    static Admin admin = new Admin("admin", "admin");
    static boolean isRunning;

    public static void main(String[] args) {
        IMDB imdb = new IMDB();
        Admin.getUsers().add(admin);
        System.out.println("--------HI-------- \n\t\t Welcome to 'IMDB' !");
        Movie movie=new Movie("hello",Language.ARABIC,new Date(),Genre.ACTION);
        Movie movie1=new Movie("what",Language.ITALIAN,new Date(),Genre.DRAMA);
        movie.setTitle("hello world");
        Admin.getMovies().add(movie);
        Admin.getMovies().add(movie1);
        Member member=new Member("melika","m1234");
        Admin.getUsers().add(member);
        Member member1=new Member("a","a");
        Admin.getUsers().add(member1);
        Member member2=new Member("b","b");
        Admin.getUsers().add(member2);
        member.getMembersWhomFollow().add(member1);
        member.getMembersWhomFollow().add(member2);
        People people=new People("abc",23);
        People people1=new People("def",87);
        People people2=new People("hij",42);
        Admin.addPeople(people);
        Admin.addPeople(people1);
        Admin.addPeople(people2);
        member.getPeoples().add(people);
        member.getPeoples().add(people1);

        imdb.start();
    }

    private void start() {
        String content;
        isRunning = true;
        while (isRunning) {
            int choice;
            chooseWhatToDo();
            try {
                choice = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.out.println("YOU MUST ENTER NUMBER ! \t TRY AGAIN");
                continue;
            }
            String userName;
            String passWord;
            int choice2;
            switch (choice) {
                case 1://login
                    System.out.println("Please enter your username and password :");
                    userName = input.nextLine();
                    passWord = input.nextLine();
                    User user = UserManagement.loginUser(userName, passWord);
                    if (user == null) {
                        System.out.println("Person not found !");
                    } else if (user instanceof Admin) {//show admin menu
                        boolean isAdmin = true;
                        int adminChoice;
                        while (isAdmin) {
                            whatAdminDo();
                            try {
                                adminChoice = Integer.parseInt(input.nextLine());
                            } catch (Exception e) {
                                System.out.println("YOU MUST ENTER NUMBER ! \t TRY AGAIN");
                                continue;
                            }
                            switch (adminChoice) {
                                case 1://add user
                                    Admin.addUser();
                                    break;
                                case 2://add / edit movie
                                    boolean inMovieAdmin = true;
                                    while (inMovieAdmin) {
                                        System.out.println("--------What do you want to do ?--------");
                                        System.out.println("1. Add movie");
                                        System.out.println("2. Edit existing movie");//search movie
                                        System.out.println("0. Exit");
                                        try {
                                            adminChoice = Integer.parseInt(input.nextLine());
                                        } catch (Exception e) {
                                            System.out.println("YOU MUST ENTER NUMBER ! \t TRY AGAIN");
                                            continue;
                                        }
                                        switch (adminChoice) {
                                            case 1://add movie
                                                System.out.println("Write movie name you want to add :");
                                                Admin.addMovie(input.nextLine());
                                                break;
                                            case 2://edit movie
                                                //search movie
                                                System.out.println("--------Movies--------");
                                                for (Movie moiveS : Admin.getMovies()) {
                                                    System.out.println(moiveS.getMovieName());
                                                }
                                                System.out.println("--------Write movie name you want to edit-------");
                                                Movie searchedMinAdmin = Movie.SearchMoive(input.nextLine());
                                                //Movie searchedMinAdmin=Movie.showAllMoviesAndret();
                                                if (searchedMinAdmin != null) {
                                                    searchedMinAdmin.seeMovieDetails();
                                                    Admin.editMovieByAdmin(searchedMinAdmin);
                                                } else {
                                                    System.out.println("--------Movie not found--------");
                                                }
                                                break;
                                            case 0:
                                                inMovieAdmin = false;
                                                System.out.println("Exit");
                                                break;
                                            default:
                                                System.out.println("Wrong input");
                                        }
                                    }
                                    break;
                                case 3://del movie/////////////////////////////////////////////
                                    System.out.println("--------Write movie name you want to delete-------");
                                    Movie movieToDelete = Movie.SearchMoive(input.nextLine());
                                    Admin.getMovies().remove(movieToDelete);
                                    break;
                                case 4://people management
                                    boolean inAdminPeopleAdd = true;
                                    while (inAdminPeopleAdd) {
                                        System.out.println("--------What do you want to do ?--------");
                                        System.out.println("1. Add people");
                                        System.out.println("2. Edit existing people");
                                        System.out.println("3. Delete people");
                                        System.out.println("0. Exit");
                                        try {
                                            adminChoice = Integer.parseInt(input.nextLine());
                                        } catch (Exception e) {
                                            System.out.println("YOU MUST ENTER NUMBER ! \t TRY AGAIN");
                                            continue;
                                        }
                                        switch (adminChoice) {
                                            case 1:
                                                System.out.println("Who you want to add?");
                                                System.out.println("1. Actor \n2. Director \n3. Writer\n0. Exit");
                                                System.out.println("Write movie person name you want to add :");
                                                try {
                                                    adminChoice = Integer.parseInt(input.nextLine());
                                                    People addedPeople = new People(input.nextLine());
                                                    Admin.getPeoples().add(addedPeople);
                                                    switch (adminChoice) {
                                                        case 1:
                                                            addedPeople.addPeopleType(PeopleType.ACTOR);
                                                            Admin.addPeople(addedPeople);
                                                            break;
                                                        case 2:
                                                            addedPeople.addPeopleType(PeopleType.DIRECTOR);
                                                            Admin.addPeople(addedPeople);
                                                            break;
                                                        case 3:
                                                            addedPeople.addPeopleType(PeopleType.WRITER);
                                                            Admin.addPeople(addedPeople);
                                                            break;
                                                        case 0:
                                                            System.out.println("Exit");
                                                            break;
                                                    }
                                                } catch (Exception e) {
                                                    System.out.println("YOU MUST ENTER NUMBER ! \t TRY AGAIN");
                                                    continue;
                                                }
                                                break;
                                            case 2://edit person
                                                //search person
                                                System.out.println("--------Peoples--------");
                                                for (People searchedPeople : Admin.getPeoples()) {
                                                    System.out.println(searchedPeople.getNameLastName());
                                                }
                                                System.out.println("--------Write people name you want to edit-------");
                                                People foundedPeople = People.searchPeople(input.nextLine());
                                                if (foundedPeople != null) {
                                                    foundedPeople.seePersonDetails();
                                                    Admin.editePeople(foundedPeople);
                                                } else {
                                                    System.out.println("--------Person not found--------");
                                                }
                                                break;
                                            case 3:
                                                //delete person///////////////////////////////////////////
                                                System.out.println("--------Peoples--------");
                                                for (People searchedPeople : Admin.getPeoples()) {
                                                    System.out.println(searchedPeople.getNameLastName());
                                                }
                                                System.out.println("--------Write people name you want to delete-------");
                                                foundedPeople = People.searchPeople(input.nextLine());
                                                if (foundedPeople != null) {
                                                    foundedPeople.seePersonDetails();
                                                    Admin.getPeoples().remove(foundedPeople);
                                                    //edit
                                                } else {
                                                    System.out.println("--------Person not found--------");
                                                }
                                                break;
                                            case 0:
                                                inAdminPeopleAdd = false;
                                                System.out.println("Exit");
                                                break;
                                            default:
                                                System.out.println("Wrong input");
                                        }
                                    }
                                    break;
                                case 5://see reports
                                    for (Report report : Admin.getReports()) {
                                        if (report.getMovie() != null) {
                                            System.out.println(report.getMovie() + " movie reported and content is :" + report.getText());
                                        } else if (report.getReview() != null) {
                                            System.out.println(report.getReview() + " review reported and content is :" + report.getText());
                                        }
                                    }
                                    break;
                                case 6://see account
                                    int count = 1;
                                    System.out.println("--------Users--------");
                                    for (User userS : Admin.getUsers()) {
                                        System.out.println(count + " . " + userS.getUserName());
                                        count++;
                                    }
                                    System.out.println("Choose one of the or '0' to exit");
                                    User foundedUser;
                                    try {
                                        int choose = Integer.parseInt(input.nextLine());
                                        if (choose != 0 && choose <= Admin.getUsers().size()) {
                                            foundedUser = Admin.getUsers().get(choose - 1);

                                            System.out.println("What do you want to do?");
                                            System.out.println("1. Delete user");
                                            System.out.println("2. Ban user");
                                            System.out.println("0. Exit");
                                            try {
                                                int chooseOption = Integer.parseInt(input.nextLine());
                                                switch (chooseOption) {
                                                    case 1:
                                                        if (!(foundedUser instanceof Admin)) {
                                                            Admin.getUsers().remove(foundedUser);
                                                        } else {
                                                            System.out.println("You can't delete admin");
                                                        }
                                                        ////////////////////////////////////////////////////////////delete
                                                        break;
                                                    case 2:
                                                        if (!(foundedUser instanceof Admin)) {
                                                            foundedUser.setBanningStatus(Banning.BAN);
                                                        } else {
                                                            System.out.println("You can't ban admin");
                                                        }
                                                        break;
                                                    case 0:
                                                        System.out.println("Exit");
                                                        break;
                                                    default:
                                                        System.out.println("Wrong input");
                                                }
                                            } catch (Exception e) {
                                                System.out.println("YOU MUST ENTER NUMBER ! \t TRY AGAIN");
                                                continue;
                                            }
                                        } else {
                                            System.out.println("Exit");
                                        }
                                    } catch (Exception e) {
                                        System.out.println("YOU MUST ENTER NUMBER ! \t TRY AGAIN");
                                        continue;
                                    }
                                    break;
                                case 7://approve edit suggestion
                                    int approvalChoice;
                                    System.out.println("Which movie or people edit suggestions you want to see?");
                                    System.out.println("1. movie");
                                    System.out.println("2. People");
                                    System.out.println("0. Exit");
                                    try {
                                        approvalChoice = Integer.parseInt(input.nextLine());
                                        if (approvalChoice == 1) {
                                            Admin.approvalMovie();
                                        } else if (approvalChoice == 2) {
                                            Admin.approvalPeople();
                                        } else if (approvalChoice == 0) {
                                            System.out.println("Exit");
                                        } else {
                                            System.out.println("Not found");
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Wrong input");
                                    }

                                    break;
                                case 8://see rules
                                    Admin.printRules();
                                    if (Admin.getRules().isEmpty()) {
                                        break;
                                    }
                                    System.out.println("What do you want to do?");
                                    System.out.println("1. delete rule");
                                    System.out.println("2. add rule");
                                    System.out.println("0. Exit");
                                    int ruleChoice, ruleChoice2;
                                    try {
                                        ruleChoice = Integer.parseInt(input.nextLine());
                                        switch (ruleChoice) {
                                            case 1:
                                                try {
                                                    System.out.println("choose one of them to delete");
                                                    ruleChoice2 = Integer.parseInt(input.nextLine());
                                                    Admin.getRules().remove(ruleChoice2 - 1);
                                                } catch (Exception e) {
                                                    System.out.println("Wrong input");
                                                }
                                                break;
                                            case 2:
                                                System.out.println("Write new rule");
                                                Admin.addRule(input.nextLine());
                                                break;
                                            case 0:
                                                System.out.println("Exit");
                                                break;
                                            default:
                                                System.out.println("Wrong input ");
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Wrong input");
                                    }
                                    break;
                                case 9://search movie
                                    int choiceMA;
                                    System.out.println("1. Search ");
                                    System.out.println("2. Movie advanced search");
                                    System.out.println("0. Exit ");
                                    try {
                                        choiceMA = Integer.parseInt(input.nextLine());
                                        switch (choiceMA) {
                                            case 1:
                                                String nameOfMovie = input.nextLine();
                                                Movie searchedM = Movie.SearchMoive(nameOfMovie);
                                                //inMovieF(user, searchedM);
                                                searchedM.seeMovieDetails();/////////
                                                searchedM.deleteMovieReview();
                                                break;
                                            case 2:
                                                Movie advanceSearchedM = AdvanceSearch.movieAdvanceSearch();
                                                advanceSearchedM.deleteMovieReview();
                                                break;
                                            case 0:
                                                System.out.println("Exit");
                                                break;
                                            default:
                                                System.out.println("Wrong input");

                                        }
                                    } catch (Exception e) {
                                        System.out.println("Wrong input !");
                                    }
                                    break;
                                case 10://edit profile
                                    editProfile(user);
                                    break;
                                case 11://forum management
                                    int Fchoice;
                                    System.out.println("What do you want to do?");
                                    System.out.println("1. Add forum");
                                    System.out.println("2. Delete forum");
                                    System.out.println("3. Remove user from forum");
                                    System.out.println("4. Delete massage form forum");
                                    System.out.println("0. Exit");
                                    try {
                                        Fchoice = Integer.parseInt(input.nextLine());
                                        switch (Fchoice) {
                                            case 1:
                                                System.out.println("Forum name you want to add");
                                                Admin.addForum(input.nextLine());
                                                break;
                                            case 2://delete forum//////////////////////////
                                                Forum searchedForum = Forum.searchForums();
                                                Admin.getForums().remove(searchedForum);
                                                break;
                                            case 3:
                                                System.out.println("Choose forum and delete member :");
                                                if (Forum.searchForums() != null) {
                                                    Forum.searchForums().deleteForumMember();
                                                } else {
                                                    System.out.println("Forum not found");
                                                }
                                                break;
                                            case 4:
                                                System.out.println("Choose forum and delete massage :");
                                                if (Forum.searchForums() != null) {
                                                    Forum.searchForums().delelteMassegeFormForum();
                                                } else {
                                                    System.out.println("Forum not found");
                                                }
                                                break;
                                            case 0:
                                                System.out.println("Exit");
                                                break;
                                            default:
                                                System.out.println("Wrong input ");
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Wrong input");
                                    }


                                    break;
                                case 0:
                                    isAdmin = false;
                                    System.out.println("Exit Admin account");
                                    break;
                                default:
                                    System.out.println("Wrong input !");


                            }
                        }
                    } else if (user instanceof Editor) {//show editor menu
                        boolean isEditor = true;
                        int editorChoice;
                        while (isEditor) {
                            whatEditorDo();
                            try {
                                editorChoice = Integer.parseInt(input.nextLine());
                            } catch (Exception e) {
                                System.out.println("YOU MUST ENTER NUMBER ! \t TRY AGAIN");
                                continue;
                            }
                            switch (editorChoice) {
                                case 1:
                                    int choiceME, num;
                                    System.out.println("1. Search ");
                                    System.out.println("2. Movie advanced search");
                                    System.out.println("0. Exit ");
                                    try {
                                        choiceME = Integer.parseInt(input.nextLine());
                                        switch (choiceME) {
                                            case 1:
                                                String nameOfMovie = input.nextLine();
                                                Movie searchedM = Movie.SearchMoive(nameOfMovie);
                                                if (searchedM != null) {
                                                    searchedM.seeMovieDetails();/////////
                                                    System.out.println("What do you want to do as editor ? ");
                                                    System.out.println("1. Add edit suggestion for this movie");
                                                    System.out.println("2. Add missing data to this movie");
                                                    System.out.println("0. Exit ");
                                                    try {
                                                        num = Integer.parseInt(input.nextLine());
                                                        if (num == 1) {
                                                            Editor.MovieEditSuggestion(searchedM);
                                                        } else if (num == 2) {
                                                            Editor.addMissedData(searchedM);
                                                        } else if (num == 0) {
                                                            System.out.println("Exit");
                                                        } else {
                                                            System.out.println("Wrong input");
                                                        }
                                                    } catch (Exception e) {
                                                        System.out.println("Enter number ");
                                                    }

                                                }
                                                break;
                                            case 2:
                                                Movie advanceSearchedM = AdvanceSearch.movieAdvanceSearch();
                                                advanceSearchedM.seeMovieDetails();
                                                if (advanceSearchedM != null) {
                                                    advanceSearchedM.seeMovieDetails();/////////
                                                    System.out.println("What do you want to do as editor ? ");
                                                    System.out.println("1. Add edit suggestion for this movie");
                                                    System.out.println("2. Add missing data to this movie");
                                                    System.out.println("0. Exit ");
                                                    try {
                                                        num = Integer.parseInt(input.nextLine());
                                                        if (num == 1) {
                                                            Editor.MovieEditSuggestion(advanceSearchedM);
                                                        } else if (num == 2) {
                                                            advanceSearchedM.seeMovieDetails();
                                                            Editor.addMissedData(advanceSearchedM);
                                                        } else if (num == 0) {
                                                            System.out.println("Exit");
                                                        } else {
                                                            System.out.println("Wrong input");
                                                        }
                                                    } catch (Exception e) {
                                                        System.out.println("Enter number ");
                                                    }
                                                }
                                                break;
                                            case 0:
                                                System.out.println("Exit");
                                                break;
                                            default:
                                                System.out.println("Wrong input");
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Wrong input");
                                    }
                                    break;
                                case 2://see people
                                    int choose;
                                    int coun = 1;
                                    for (People people : Admin.getPeoples()) {
                                        System.out.println(coun + "." + people.getNameLastName());
                                        coun++;
                                    }
                                    try {
                                        choose = Integer.parseInt(input.nextLine());
                                        if (choose <= Admin.getPeoples().size()) {
                                            People foundP = People.searchPeople(Admin.getPeoples().get(choose - 1).getNameLastName());
                                            if (foundP != null) {
                                                foundP.seePersonDetails();/////////
                                                System.out.println("What do you want to do as editor ? ");
                                                System.out.println("1. Add edit suggestion for this People");
                                                System.out.println("2. Add missing data to this People");
                                                System.out.println("0. Exit ");
                                                try {
                                                    num = Integer.parseInt(input.nextLine());
                                                    if (num == 1) {
                                                        Editor.peopleEditSuggestion(foundP);
                                                    } else if (num == 2) {
                                                        Editor.PeopleAddMissedData(foundP);
                                                    } else if (num == 0) {
                                                        System.out.println("Exit");
                                                    } else {
                                                        System.out.println("Wrong input");
                                                    }
                                                } catch (Exception e) {
                                                    System.out.println("Enter number ");
                                                }
                                            }
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Wrong input");
                                    }
                                    break;
                                case 3:
                                    editProfile(user);
                                    break;
                                case 0:
                                    isEditor = false;
                                    System.out.println("Exit editor account");
                                    break;
                                default:
                                    System.out.println("Wrong input !");
                            }
                        }


                    } else if (user instanceof Member) {//show member menu
                        boolean isMember = true;
                        while (isMember) {
                            whatMemberDo();
                            try {
                                choice = Integer.parseInt(input.nextLine());
                            } catch (Exception e) {
                                System.out.println("YOU MUST ENTER NUMBER ! \t TRY AGAIN");
                                continue;
                            }

                            switch (choice) {
                                case 1://show all movies
                                    Movie movie = Movie.showAllMoviesAndret(Admin.getMovies());
                                    inMovieF(user, movie);
                                    break;
                                case 2://make personal lists
                                    System.out.println("Write your list name:");
                                    content = input.nextLine();
                                    PersonalList personalList = new PersonalList(content);
                                    ((Member) user).addListToPersonalList(personalList);
                                    break;
                                case 3://search members
                                    System.out.println("--------Enter user name you want to see--------");
                                    String searchedUserName = input.nextLine();
                                    ((Member) user).searchMemberAndOption(searchedUserName);
                                    break;
                                case 4://forum
                                    String forumName, forumName1;
                                    boolean inForum = true;
                                    while (inForum) {
                                        System.out.println("enter 'M' to see your forums or search for another one ");
                                        if (input.nextLine().equals("M")) {
                                            System.out.println("Your forums :");
                                            int counter = 1;
                                            for (Forum forum : ((Member) user).getForums()) {
                                                System.out.println(counter + ". " + forum.getNameOfForum());
                                                counter++;
                                            }
                                            continue;
                                        }
                                        Forum forum = Forum.searchForums();
                                        if (forum != null) {
                                            forumOptions();
                                            try {
                                                choice = Integer.parseInt(input.nextLine());
                                            } catch (Exception e) {
                                                System.out.println("YOU MUST ENTER NUMBER ! \t TRY AGAIN");
                                                continue;
                                            }
                                            switch (choice) {
                                                case 1:
                                                    System.out.println("Write forum name you want to add :");
                                                    Forum forumNew = new Forum(input.nextLine());
                                                    Admin.getForums().add(forumNew);
                                                    forumNew.getMembersInForum().add((Member) user);
                                                    break;
                                                case 2:
                                                    System.out.println("--------Forum massages--------");
                                                    if (!forum.getMassages().isEmpty()) {
                                                        for (Massage massage : forum.getMassages()) {
                                                            System.out.println(massage.getSender() + " : " + massage.getMassageText());
                                                        }
                                                    } else {
                                                        System.out.println("--------Forum has no massage--------");
                                                    }
                                                    break;
                                                case 3:
                                                    System.out.println("--------Write your massage--------");
                                                    String massage = input.nextLine();
                                                    forum.addMassage(new Massage(massage, ((Member) user)));
                                                    break;
                                                case 4://left forum
                                                    if (forum.getMembersInForum().contains((Member) user)) {
                                                        forum.getMembersInForum().remove((Member) user);
                                                    } else
                                                        System.out.println("--------You are not in this forum--------");
                                                    break;
                                                case 0:
                                                    inForum = false;
                                                    System.out.println("EXIT !");
                                                    break;
                                                default:
                                                    System.out.println("Wrong input !\tTRY ANOTHER TIME");
                                            }
                                        } else {
                                            System.out.println("--------Forum not found--------");
                                        }
                                    }
                                    break;
                                case 5:
                                    Movie.seeChart();
                                    boolean inSeeChart = true;
                                    String search;
                                    while (inSeeChart) {
                                        System.out.println("1. See movie by genre");
                                        System.out.println("2. See movie by language");
                                        System.out.println("3. See movie by release year");
                                        System.out.println("0. Exit");
                                        try {
                                            choice2 = Integer.parseInt(input.nextLine());
                                        } catch (Exception e) {
                                            System.out.println("YOU MUST ENTER NUMBER ! \t TRY AGAIN");
                                            continue;
                                        }
                                        switch (choice2) {
                                            case 1:
                                                System.out.println("--------Choose one :--------\n 1. ACTION\t2. DRAMA\t3. MYSTERY\t4. HORROR\t5. FANTASY\t6. NARRATIVE\t7. FICTION\t8. HISTORICALFICTION\t9. SCIENCEFICTION\t0.Exit");
                                                try {
                                                    choice = Integer.parseInt(input.nextLine());
                                                } catch (Exception e) {
                                                    System.out.println("YOU MUST ENTER NUMBER ! \t TRY AGAIN");
                                                    continue;
                                                }
                                                switch (choice) {
                                                    case 1:
                                                        Movie.seeMoviesByGenre(Genre.ACTION);
                                                        break;
                                                    case 2:
                                                        Movie.seeMoviesByGenre(Genre.DRAMA);
                                                        break;
                                                    case 3:
                                                        Movie.seeMoviesByGenre(Genre.MYSTERY);
                                                        break;
                                                    case 4:
                                                        Movie.seeMoviesByGenre(Genre.HORROR);
                                                        break;
                                                    case 5:
                                                        Movie.seeMoviesByGenre(Genre.FANTASY);
                                                        break;
                                                    case 6:
                                                        Movie.seeMoviesByGenre(Genre.NARRATIVE);
                                                        break;
                                                    case 7:
                                                        Movie.seeMoviesByGenre(Genre.FICTION);
                                                        break;
                                                    case 8:
                                                        Movie.seeMoviesByGenre(Genre.HISTORICALFICTION);
                                                        break;
                                                    case 9:
                                                        Movie.seeMoviesByGenre(Genre.SCIENCEFICTION);
                                                        break;

                                                    case 0:
                                                        System.out.println("Exit");
                                                        break;
                                                    default:
                                                        System.out.println("Wrong input");

                                                }
                                                break;
                                            case 2:
                                                System.out.println("--------Choose one :--------\n 1. ENGLISH\t2. PERSIAN\t3. FRENCH\t4. RUSSIAN\t5. ITALIAN\t6. ARABIC\t0.Exit");
                                                try {
                                                    choice2 = Integer.parseInt(input.nextLine());
                                                } catch (Exception e) {
                                                    System.out.println("YOU MUST ENTER NUMBER ! \t TRY AGAIN");
                                                    continue;
                                                }
                                                switch (choice2) {
                                                    case 1:
                                                        Movie.seeMoviesByLanguage(Language.ENGLISH);
                                                        break;
                                                    case 2:
                                                        Movie.seeMoviesByLanguage(Language.PERSIAN);
                                                        break;
                                                    case 3:
                                                        Movie.seeMoviesByLanguage(Language.FRENCH);
                                                        break;
                                                    case 4:
                                                        Movie.seeMoviesByLanguage(Language.RUSSIAN);
                                                        break;
                                                    case 5:
                                                        Movie.seeMoviesByLanguage(Language.ITALIAN);
                                                        break;
                                                    case 6:
                                                        Movie.seeMoviesByLanguage(Language.ARABIC);
                                                        break;
                                                    case 0:
                                                        System.out.println("Exit");
                                                        break;
                                                    default:
                                                        System.out.println("Wrong input");
                                                }
                                                break;
                                            case 3:
                                                System.out.println("--------Enter release year");
                                                try {
                                                    choice2 = Integer.parseInt(input.nextLine());
                                                } catch (Exception e) {
                                                    System.out.println("YOU MUST ENTER NUMBER ! \t TRY AGAIN");
                                                    continue;
                                                }
                                                Movie.seeMoviesByReleaseDate(choice2);
                                                break;
                                            case 0:
                                                inSeeChart = false;
                                                System.out.println("Exit");
                                                break;
                                            default:
                                                System.out.println("Wrong input");
                                        }
                                    }

                                    break;
                                case 6://search people
                                    System.out.println("Write people name");
                                    String pName = input.nextLine();
                                    ((Member) user).searchPeopleAndOption(pName);
                                    break;
                                case 7://edit profile
                                    editProfile(user);
                                    break;
                                case 8:
                                    int counter = 1;
                                    System.out.println(user.getName() + "'s friend are: ");
                                    if (((Member) user).getMembersWhomFollow().isEmpty()) {
                                        System.out.println("--------There is no friend--------");
                                    } else {
                                        for (Member friend : ((Member) user).getMembersWhomFollow()) {
                                            System.out.println(counter + ". " + friend.getUserName());
                                            counter++;
                                        }

                                        System.out.println("Enter friend number or '0' to Exit ");
                                        try {
                                            choice = Integer.parseInt(input.nextLine());
                                        } catch (Exception e) {
                                            System.out.println("Wrong input !");
                                        }
                                        if (choice != 0) {
                                            System.out.println("Enter 1 to unFriend or 2 to see profile");
                                            try {
                                                choice2 = Integer.parseInt(input.nextLine());
                                                if (choice2 == 1) {
                                                    ((Member) user).getMembersWhomFollow().remove(choice - 1);
                                                } else if (choice2 == 2) {
                                                    ((Member) user).getMembersWhomFollow().get(choice - 1).seeMemberDetails();
                                                }
                                            } catch (Exception e) {
                                                System.out.println("Wrong input !");
                                            }

                                        }
                                    }
                                    break;
                                case 9://see people you follow
                                    System.out.println(user.getUserName() + "'s followers :");
                                    for (People follower : ((Member) user).getPeoples()) {
                                        System.out.println(follower.getNameLastName());
                                    }
                                    break;
                                case 10:
                                    int num;
                                    boolean inSearchedPeople = true;
                                    while (inSearchedPeople) {
                                        System.out.println("1. Search people");
                                        System.out.println("2. Search people by movie they were in ");
                                        System.out.println("0. Exit");
                                        try {
                                            num = Integer.parseInt(input.nextLine());
                                        } catch (Exception e) {
                                            System.out.println("Wrong input !");
                                            continue;
                                        }
                                        switch (num) {
                                            case 1:
                                                System.out.println("Enter name :");
                                                People.searchPeople(input.nextLine());
                                                break;
                                            case 2:
                                                System.out.println("Enter movie name:");
                                                People.searchPeopleByMovie(input.nextLine());
                                                break;
                                            case 0:
                                                inSearchedPeople = false;
                                                System.out.println("Exit");
                                                break;
                                            default:
                                                System.out.println("Wrong input");
                                        }
                                    }
                                    break;
                                case 11:
                                    int counterS = 1;
                                    for (PersonalList personalListS : (((Member) user).getPersonalLists())) {
                                        System.out.println("--------" + personalListS.getNameOfList() + "--------");
                                        for (Movie movieP : personalListS.getListMovies()) {
                                            System.out.println("\t\t" + counterS + " . " + movieP.getMovieName());
                                            counterS++;
                                        }
                                    }
                                    break;
                                case 12:
                                    ((Member) user).recomNewMovies();
                                    ((Member) user).recommendation();
                                    break;
                                case 13:
                                    System.out.println("1. Search ");
                                    System.out.println("2. Movie advanced search");
                                    System.out.println("0. Exit ");
                                    try {
                                        choice = Integer.parseInt(input.nextLine());
                                        switch (choice) {
                                            case 1:
                                                String nameOfMovie = input.nextLine();
                                                Movie searchedM = Movie.SearchMoive(nameOfMovie);
                                                inMovieF(user, searchedM);
                                                break;
                                            case 2:
                                                Movie advanceSearchedM = AdvanceSearch.movieAdvanceSearch();
                                                inMovieF(user, advanceSearchedM);
                                                break;
                                            case 0:
                                                System.out.println("Exit");
                                                break;
                                            default:
                                                System.out.println("Wrong input");

                                        }
                                    } catch (Exception e) {
                                        System.out.println("Wrong input !");
                                    }
                                    break;
                                case 14:
                                    System.out.println("Write personal list name :");
                                    ((Member) user).searchPersonalList(input.nextLine());
                                    break;
                                case 15:
                                    boolean inChatManagement = true, inChat;
                                    int chatManageChoice, inChatChoice;
//        System.out.println("2. Search chats (direct and group chats)");//when see massage forward to another chat
//        System.out.println("3. Creat new group chat");
//        System.out.println("4. Creat new direct chat");
                                    while (inChatManagement) {
                                        memberChatManagement();
                                        try {
                                            chatManageChoice = Integer.parseInt(input.nextLine());

                                            switch (chatManageChoice) {
                                                case 1://see your chats
                                                    Chat foundChat = ((Member) user).seeYourChats();
                                                    if (foundChat!=null) {
                                                        inChat = true;
                                                        while (inChat) {
                                                            whatMemberDoInChat();
                                                            try {
                                                                inChatChoice = Integer.parseInt(input.nextLine());
                                                                switch (inChatChoice) {
                                                                    case 0:
                                                                        inChat = false;
                                                                        System.out.println("Exit");
                                                                        break;
                                                                    case 1:
                                                                        System.out.println("Enter you massage :");
                                                                        foundChat.getChatMassages().add(new Massage(input.nextLine(), ((Member) user)));

                                                                        break;
                                                                    case 2://see massages
                                                                        foundChat.seeMassagesAndDo(((Member) user), foundChat);
                                                                        break;
                                                                    case 3:
                                                                        //see chat members
                                                                        if (foundChat instanceof GroupMassage) {
                                                                            ((GroupMassage) foundChat).seeMembersInChat(((Member) user));
                                                                        } else if (foundChat instanceof DirectMassage) {
                                                                            System.out.println("Members are:" + ((DirectMassage) foundChat).getA() + " and " + ((DirectMassage) foundChat).getB());
                                                                        }
                                                                        break;
                                                                    case 4:
                                                                        if (foundChat instanceof GroupMassage) {
                                                                            if (((GroupMassage) foundChat).getGroupAdmin().equals(user)) {
                                                                                ((Member) user).getGroupMassagesM().remove(foundChat);
                                                                                ((GroupMassage) foundChat).setGroupAdmin(null);
                                                                            } else {
                                                                                ((Member) user).getGroupMassagesM().remove(foundChat);
                                                                            }
                                                                        } else if (foundChat instanceof DirectMassage) {
                                                                            ((Member) user).getDirectMassagesM().remove(foundChat);
                                                                        }
                                                                        break;
                                                                    default:
                                                                        System.out.println("Wrong input");
                                                                }
                                                            } catch (Exception e) {
                                                                System.out.println("Wrong input");
                                                                //continue;
                                                            }
                                                        }
                                                    }
                                                    break;
                                                case 3://creat new group chat
                                                    System.out.println("Write group name you want to add");
                                                    GroupMassage groupMassage = new GroupMassage(input.nextLine(), ((Member) user));
                                                    Admin.getGroupMassages().add(groupMassage);
                                                    ((Member) user).getGroupMassagesM().add(groupMassage);
                                                    System.out.println("--------New group chat created and you are admin--------");
                                                    break;
                                                case 4://creat new direct
                                                    System.out.println("Write member user name which you wanna create direct chat with");
                                                    User userDirect = Admin.searchUsers(input.nextLine());
                                                    if (userDirect instanceof Member) {
                                                        DirectMassage direct = new DirectMassage(((Member) userDirect), ((Member) user));
                                                        ((Member) user).getDirectMassagesM().add(direct);
                                                        ((Member) userDirect).getDirectMassagesM().add(direct);
                                                        System.out.println("--------New chat created--------");
                                                    }
                                                    break;
                                                case 2://search group chats by name
                                                    System.out.println("Write group chat you want to search");
                                                    GroupMassage foundGroup = Admin.searchGroups(input.nextLine());
                                                    if (foundGroup!=null) {
                                                        whatMemberDoInChat();
                                                        inChat = true;
                                                        while (inChat) {
                                                            try {
                                                                inChatChoice = Integer.parseInt(input.nextLine());
                                                                switch (inChatChoice) {
                                                                    case 0:
                                                                        inChat = false;
                                                                        System.out.println("Exit");
                                                                        break;
                                                                    case 1:
                                                                        System.out.println("Enter you massage :");
                                                                        foundGroup.getChatMassages().add(new Massage(input.nextLine(), ((Member) user)));
                                                                        break;
                                                                    case 2://see massages
                                                                        foundGroup.seeMassagesAndDo(((Member) user), foundGroup);
                                                                        break;
                                                                    case 3:
                                                                        //see chat members
                                                                        foundGroup.seeMembersInChat(((Member) user));
                                                                        break;
                                                                    case 4:
                                                                        ((Member) user).getGroupMassagesM().remove(foundGroup);
                                                                        if (foundGroup.getGroupAdmin().equals(user)) {
                                                                            foundGroup.setGroupAdmin(null);
                                                                        }
                                                                        break;
                                                                    default:
                                                                        System.out.println("Wrong input");
                                                                }
                                                            } catch (Exception e) {
                                                                System.out.println("Wrong input");
                                                            }
                                                        }
                                                    } else {
                                                        System.out.println("Group not found");
                                                    }
                                                    break;
                                                case 0:
                                                    inChatManagement = false;
                                                    System.out.println("Exit");
                                                    break;
                                                default:
                                                    System.out.println("Wrong input");
                                            }
                                        } catch (Exception e) {
                                            System.out.println("Enter number try again!");
                                        }
                                    }
                                    break;
                                case 0:
                                    isMember = false;
                                    System.out.println("EXIT !");
                                    break;
                                default:
                                    System.out.println("Wrong input !\tTRY ANOTHER TIME");
                            }
                        }
                    }

                    break;
                case 2://sing up
                    UserManagement.singeUpUser();
                    break;
                case 0:
                    System.out.println("BYE BYE ");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Wrong input !\tTRY ANOTHER TIME");
            }
        }

    }

    private void inMovieF(User user, Movie movie) {
        boolean inMovie = true;
        int choice;
        String reportText;
        while (inMovie) {
            if (movie != null) {
                movie.seeMovieDetails();
                WhatToDoWithMovie();
                try {
                    choice = Integer.parseInt(input.nextLine());
                    Seentimes seentimes = new Seentimes(((Member) user), movie);
                    seentimes.addToHowMany();
                    ((Member) user).addToSeenList(seentimes);
                } catch (Exception e) {
                    System.out.println("YOU MUST ENTER NUMBER ! \t TRY AGAIN");
                    continue;
                }
                switch (choice) {
                    case 1://rate movie
                        System.out.println("Enter this movie Rate out of 5 :");
                        int score;
                        try {
                            score = Integer.parseInt(input.nextLine());
                        } catch (Exception e) {
                            System.out.println("YOU MUST ENTER NUMBER ! \t TRY AGAIN");
                            continue;
                        }
                        Rate rate = new Rate(score, (Member) user, movie);
                        movie.addRateToMovie(rate);
                        break;
                    case 2://add review
                        System.out.println("Enter your Review :");
                        String text = input.nextLine(),ch;
                        Review review;
                        System.out.println("Enter your review content");
                        System.out.println("1.if review is spoiler and 2.if review is not spoiler ");
                        ch=input.nextLine();
                        if (ch.equals("1")){
                            review=new Review(input.nextLine(),((Member) user),movie,SpoilerStatus.SPOILER);
                            ((Member) user).getReviews().add(review);
                            movie.addReviewToMovie(review);
                        }
                        else if(ch.equals("2")){
                           review= new Review(input.nextLine(),((Member) user),movie,SpoilerStatus.NOTSPOILER);
                            ((Member) user).getReviews().add(review);
                            movie.addReviewToMovie(review);
                        }
                        else{
                            System.out.println("Wrong input");
                        }
                        break;
                    case 3:
                        System.out.println("Enter your Report text :");
                        String textReport = input.nextLine();
                        Report report = new Report(movie, textReport);
                        Admin.addReport(report);
                        break;
                    case 4:
                        System.out.println("Enter your Comment :");
                        String commentText = input.nextLine();
                        Comment comment = new Comment(commentText, (Member) user, movie);
                        movie.addComment(comment);
                        break;
                    case 5:
                        Like like = new Like((Member) user, movie);
                        movie.likeMovie(like);
                        System.out.println("Movie liked sucessfully !");
                        System.out.println("Enter 'L' to see likes");
                        if ((input.nextLine()).equals("L")) {
                            for (Like like1 : movie.getLikes()) {
                                System.out.println(like1.getMember() + " likes " + ((Movie) like1.getLikableEntity()).getMovieName());
                            }
                        }
                        break;
                    case 6:
                        int count = 1;
                        System.out.println("----your lists name----");
                        if (((Member) user).getPersonalLists() == null) {
                            System.out.println("You don't have any list to show !");

                        }
                        for (PersonalList personalList : ((Member) user).getPersonalLists()) {
                            System.out.println(count + "." + personalList.getNameOfList());
                            count++;
                        }
                        System.out.println("Choose one of them to add movie to :");
                        choice = Integer.parseInt(input.nextLine());
                        if (choice <= ((Member) user).getPersonalLists().size() && choice >= 1) {
                            ((Member) user).getPersonalLists().get(choice - 1).addMovieToList(movie);
                        } else {
                            System.out.println("You have chosen wrong number !");
                        }
                        break;
                    case 7:
                        movie.seeMovieReviews((Member) user);
                        break;
                    case 0:
                        System.out.println("EXIT !");
                        inMovie = false;
                        break;
                    default:
                        System.out.println("Wrong input !\tTRY ANOTHER TIME");
                }
            } else {
                //there is no movie to show
                System.out.println("-------Movie list is empty !--------");
                inMovie = false;
            }
        }
    }

    private void editProfile(User user) {
        int choice;
        boolean inEditProfile = true;
        while (inEditProfile) {
            editProfileOptions();
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Write your new name :");
                    String name = input.nextLine();
                    user.setName(name);
                    break;
                case 2:
                    System.out.println("Write your new email address :");
                    String email = input.nextLine();
                    user.setEmail(email);
                    break;
                case 3:
                    System.out.println("Enter your birth date  year - month - day :");
                    int year = Integer.parseInt(input.nextLine());
                    int month = Integer.parseInt(input.nextLine());
                    int day = Integer.parseInt(input.nextLine());
                    Date birthDate = new Date(year, month, day);
                    user.setDateOfBirth(birthDate);
                    break;
                case 4:
                    System.out.println("Write your new user name :");
                    String userName1 = input.nextLine();
                    user.setUserName(userName1);
                    break;
                case 5:
                    System.out.println("Write your new pass word :");
                    String passWord1 = input.nextLine();
                    user.setPassWord(passWord1);
                    break;

                case 0:
                    inEditProfile = false;
                    System.out.println("EXIT !");
                    break;
                default:
                    System.out.println("Wrong input !\tTRY ANOTHER TIME");
            }
        }
    }

    private void chooseWhatToDo() {
        System.out.println("--------What do you want to do?--------");
        System.out.println("\t1.login\t2.sing up\t0.to Exit program");
    }

    private void whatMemberDo() {
        System.out.println("--------MEMBER MENU--------");
        System.out.println("1. See Movies ");//DONE
        System.out.println("2. Make personal list ");//DONE
        System.out.println("3. Search member ");//DONE
        System.out.println("4. Search forum");//DONE
        System.out.println("5. See chart ");//DONE
        System.out.println("6. Search people");//DONE
        System.out.println("7. Edit profile");//DONE
        System.out.println("8. See friends list");//DONE
        System.out.println("9. See people you follow");//DONE
        System.out.println("10. Search people");//DONE
        System.out.println("11. See personal lists");//DONE
        System.out.println("12. recommended movies ");//DONE
        System.out.println("13. Search movie");//DONE
        System.out.println("14. Search personal lists");//DONE
        System.out.println("15. Chat management ");
        System.out.println("0. Exit");//DONE

    }

    private void WhatToDoWithMovie() {//Done
        System.out.println("--------What do you want to do with chosen movie ?--------");
        System.out.println("1. Rate movie ");//DONE
        System.out.println("2. Add review to movie ");//DONE
        System.out.println("3. Report inappropriate content ");//DONE
        System.out.println("4. Add comment to movie");//DONE
        System.out.println("5. Like movie ");//DONE
        System.out.println("6. Add to personal list ");//DONE
        System.out.println("7. See reviews ");//DONE
        System.out.println("0. Exit");//DONE
    }

    private void editProfileOptions() {//DONE
        System.out.println("--------What do you want to edit ?--------");
        System.out.println("1. name/last name ");//DONE
        System.out.println("2. email ");//DONE
        System.out.println("3. date of birth ");//DONE
        System.out.println("4. Username");//DONE
        System.out.println("5. Password");//DONE
        System.out.println("0. Exit");//DONE
    }

    private void forumOptions() {
        System.out.println("--------what do you want to do with this forum?--------");
        System.out.println("1. Add forum ");//DONE
        System.out.println("2. See forum massages ");//DONE
        System.out.println("3. Writ massage in forum ");//DONE
        System.out.println("4. Left forum ");//DONE
        System.out.println("0. Exit");//DONE
    }

    private void whatAdminDo() {
        System.out.println("--------ADMIN MENU--------");
        System.out.println("1. Add user");//DONE
        System.out.println("2. Add / edit movie");//DONE
        System.out.println("3. Delete movie ");//DONE
        System.out.println("4. People Management");//DONE
        System.out.println("5. See reports");//DONE
        System.out.println("6. see accounts");//DONE
        System.out.println("7. Edit suggestion approval");//DONe
        System.out.println("8. see sites rules "); //DONE
        System.out.println("9. search movie");//DONE
        System.out.println("10. Edit profile ");//DONE
        System.out.println("11. Forum management");//DONE
        System.out.println("0. Exit");//DONE
    }

    private void whatEditorDo() {
        System.out.println("--------EDITOR MENU--------");
        System.out.println("1. see movie");//DONE
        System.out.println("2. see people");//DONE
        System.out.println("3. Edit profile ");//DONE
        System.out.println("0. Exit");//DONE
    }

    private void memberChatManagement() {
        System.out.println("--------Massage SETTING--------");
        System.out.println("1. See your chats (direct and group chats)");//DONE
        System.out.println("2. Search group chats");//when see massage forward to another chat
        System.out.println("3. Creat new group chat");
        System.out.println("4. Creat new direct chat");
        System.out.println("0.Exit");
    }

    private void whatMemberDoInChat() {
        System.out.println("--------CHAT SETTING--------");
        System.out.println("1. Write massage");
        System.out.println("2. See chat massages");//if you are senderDelete your massage//forward if you want
        System.out.println("3. See chat members ");
        System.out.println("4. left chat ");
        System.out.println("0.Exit");
    }
    /////when del something del from every were user /people /movie /review....
    //methode for in chat//////////////////
    //member can make group or direct chat /left group chat/if Admin of chat remove or add another Member//like massages //forward massage in groups

}

