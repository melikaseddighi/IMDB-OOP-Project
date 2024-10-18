import javax.swing.border.EtchedBorder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Member extends User {
    private ArrayList<Seentimes> seenTimesList = new ArrayList<>();
    private ArrayList<PersonalList> personalLists = new ArrayList<>();
    private ArrayList<People> peoples = new ArrayList<>();
    private ArrayList<Rate> rates = new ArrayList<>();
    private ArrayList<Review> reviews = new ArrayList<>();
    private ArrayList<Member> membersWhomFollow = new ArrayList<>();
    private AcceptRule ruleAccepted = AcceptRule.DONTACCEPT_RULE;
    private  ArrayList<DirectMassage> directMassagesM=new ArrayList<>();
    private  ArrayList<GroupMassage> groupMassagesM=new ArrayList<>();
    private  ArrayList<Forum> forums=new ArrayList<>();
    Scanner input=new Scanner(System.in);
    public Chat seeYourChats(){
        int counter =1,choose;
        System.out.println("Group chats");
        for (GroupMassage group:getGroupMassagesM()) {
            System.out.println(counter+". "+group.getGroupName());
            counter++;
        }
        System.out.println("Direct chats");
        for (DirectMassage directMassage:getDirectMassagesM()) {
            System.out.println(counter+". "+directMassage.getA().getUserName()+" and "+directMassage.getB().getUserName());
            counter++;
        }
        System.out.println("0. Exit");
        while (true){
        System.out.println("Enter number");
        try{
            choose=Integer.parseInt(input.nextLine());
            if (choose==0){
                System.out.println("Exit search chat");
                return null;
            }
            else if (choose<=getDirectMassagesM().size()+getGroupMassagesM().size()){
                if(choose<=getGroupMassagesM().size()){
                    return getGroupMassagesM().get(choose-1);
                }
                else {
                    return getDirectMassagesM().get(choose-getGroupMassagesM().size()-1);
                }
            }
        }catch (Exception e){
            System.out.println("Wrong input");
        }}
    }
    public ArrayList<Forum> getForums() {
        return forums;
    }

    public void setForums(ArrayList<Forum> forums) {
        this.forums = forums;
    }

    public ArrayList<Seentimes> getSeenTimesList() {
        return seenTimesList;
    }

    public void setSeenTimesList(ArrayList<Seentimes> seenTimesList) {
        this.seenTimesList = seenTimesList;
    }

    public ArrayList<DirectMassage> getDirectMassagesM() {
        return directMassagesM;
    }

    public void setDirectMassagesM(ArrayList<DirectMassage> directMassagesM) {
        this.directMassagesM = directMassagesM;
    }

    public ArrayList<GroupMassage> getGroupMassagesM() {
        return groupMassagesM;
    }

    public void setGroupMassagesM(ArrayList<GroupMassage> groupMassagesM) {
        this.groupMassagesM = groupMassagesM;
    }

    public Member(String userName, String passWord) {
        setUserName(userName);
        setPassWord(passWord);
    }

    public ArrayList<Seentimes> getSeenTimes() {
        return seenTimesList;
    }

    public void setSeenTimes(ArrayList<Seentimes> seenTimes) {
        this.seenTimesList = seenTimes;
    }

    public void addToSeenList(Seentimes seentimes) {
        seenTimesList.add(seentimes);
    }

    public AcceptRule getRuleAccepted() {
        return ruleAccepted;
    }

    public void setRuleAccepted(AcceptRule ruleAccepted) {
        this.ruleAccepted = ruleAccepted;
    }

    public void reportContent(Report report) {
        Admin.addReport(report);
    }

    public void sendMassage(Massage massage, Forum forum) {
        forum.addMassage(massage);
    }

    public void addFriend(Member friend) {
        membersWhomFollow.add(friend);
    }

    public void addRate(Rate rate, Movie movie) {
        rates.add(rate);
        movie.addRateToMovie(rate);
    }

    public void addReview(Review review, Movie movie) {
        reviews.add(review);
        movie.addReviewToMovie(review);
    }

    public ArrayList<People> getPeoples() {
        return peoples;
    }

    public void setPeoples(ArrayList<People> peoples) {
        this.peoples = peoples;
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

    public void addListToPersonalList(PersonalList personalList) {
        personalLists.add(personalList);
    }

    public ArrayList<PersonalList> getPersonalLists() {
        return personalLists;
    }

    public void setPersonalLists(ArrayList<PersonalList> personalLists) {
        this.personalLists = personalLists;
    }

    public void MemAddRateToMovie(Movie movie, Rate rate) {
        movie.addRateToMovie(rate);
    }

    public void MemAddReviewToMovie(Movie movie, Review review) {
        movie.addReviewToMovie(review);
    }

    public ArrayList<Member> getMembersWhomFollow() {
        return membersWhomFollow;
    }

    public void setMembersWhomFollow(ArrayList<Member> membersWhomFollow) {
        this.membersWhomFollow = membersWhomFollow;
    }

    public void seeMemberDetails() {
        System.out.println(getUserName() + " name is :" + getName());
        System.out.println(getName() + " has born in " + getDateOfBirth());
        Scanner input = new Scanner(System.in);
        int choose;

        while (true) {
            System.out.println(" What do you wanna see from " + getName() + "profile ?");
            System.out.println("1.friends \t 2.people whom follow \t3.his/her reviews to movies \t4.his/her reviews to movies \t5.watch list \t 0.to exit :");
            choose = Integer.parseInt(input.nextLine());
            if (choose == 1) {
                System.out.println("List of Friends:");
                for (Member friend : getMembersWhomFollow()) {
                    System.out.println(friend.getUserName() + " is one of " + getName() + " friends ");
                }
            } else if (choose == 2) {
                System.out.println("People whom " + getName() + " follows :");
                for (People people : getPeoples()) {
                    System.out.println(getName() + " follows " + people.getNameLastName());
                }
            } else if (choose == 3) {
                System.out.println(getName() + " reviews :");
                for (Review review : getReviews()) {
                    System.out.println(getName() + "Review to " + review.getMovie() + " is :" + review.getText());
                    if (review.reviewRateOFReview().equals(ReviewRate.HELPFULL)) {
                        System.out.println("other Users think it`s HELPFULL !");
                    } else {
                        System.out.println("other Users think it`s NOTHELPFULL !");
                    }
                    if (review.getSpoilerStatus().equals(SpoilerStatus.SPOILER)) {
                        System.out.println(" ---------- it`s  SPOILER ! ----------");
                    } else {
                        System.out.println("  ---------- it`s  NOTSPOILER ! ---------- ");
                    }
                }
            } else if (choose == 4) {
                for (Rate rate : getRates()) {
                    System.out.println(getName() + " gets " + rate.getScore() + " rate to " + rate.getMovie().getMovieName());
                }
            } else if (choose == 5) {
                System.out.println(getName() + " watch list :");
                for (Seentimes seentimes : getSeenTimes()) {
                    System.out.println(seentimes.getMovie().getMovieName());
                }
            } else if (choose == 0) {
                break;
            }
        }
    }


    public void recommendation() {
        int counter = 0;
        System.out.println("MOVIES BASED ON YOU WATCH LIST :\nBased on Movies language and genera :");
        for (Movie recomMovie : Admin.getMovies()) {
            if (getSeenTimes().isEmpty()) {
                System.out.println("You haven't seen any movie in our site so we recommend you random movies !");
                while (counter < 5 && counter < Admin.getMovies().size()) {
                    System.out.println(" Movie name : " + Admin.getMovies().get(counter).getMovieName());
                    counter++;
                }
                break;
            } else if (counter < Admin.getMovies().size() && counter < 5) {
                for (Seentimes seenedMovie : getSeenTimes()) {
                    if (!recomMovie.equals(seenedMovie.getMovie()) && (recomMovie.getLanguage().equals(seenedMovie.getMovie().getLanguage()) || recomMovie.getGenreType().equals(seenedMovie.getMovie().getGenreType()))) {
                        System.out.println(" Movie name : " + recomMovie.getMovieName());
                        counter++;
                        break;
                    }

                }
            } else {
                break;
            }
        }
        System.out.println("Based on your Highest rated movies : ");

        for (Movie recomMovie : Admin.getMovies()) {
            if (recomMovie.getTotalRate() >= 8) {
                System.out.println("Movie name : " + recomMovie.getMovieName());
            }
        }
    }

    public void recomNewMovies() {
        ArrayList<Movie> newMovies = new ArrayList<>();
        Date currentDate = new Date();
        int month = currentDate.getMonth(), year = currentDate.getYear();

        int counter = 0;
        for (Movie movie : Admin.getMovies()) {
            if ((year - (movie.getReleaseDate().getYear())) == 0 && month - movie.getReleaseDate().getMonth() <= 1) {
                newMovies.add(movie);
            }
        }
        if (newMovies.isEmpty()) {
            System.out.println("There is no new movie to show !");
            return;
        }

        System.out.println("NEW MOVIES BASED ON YOU WATCH LIST :\nBased on Movies language and genera :");
        int i = 0;
        boolean isDuplicated = false;
        for (Movie recomMovie : newMovies) {
            if (getSeenTimes().isEmpty()) {
                System.out.println("You haven`t seen any movie in our site so we recommend you random movies !");
                while (counter < 5 && counter < newMovies.size()) {
                    System.out.println(" Movie name : " + newMovies.get(counter).getMovieName());
                    counter++;
                }
                break;
            } else if (counter < newMovies.size() && counter < 5) {
                for (Seentimes seenedMovie : getSeenTimes()) {
                    if (!recomMovie.equals(seenedMovie.getMovie()) && (recomMovie.getLanguage().equals(seenedMovie.getMovie().getLanguage()) || recomMovie.getGenreType().equals(seenedMovie.getMovie().getGenreType()))) {
                        System.out.println(" Movie name : " + recomMovie.getMovieName());
                        counter++;
                        break;
                    }
                }
            } else {
                break;
            }
        }
        System.out.println("Based on your Highest rated movies : ");


        for (Movie recomMovie : newMovies) {
            if (counter < newMovies.size() && counter < 5 && recomMovie.getTotalRate() >= 8) {
                System.out.println("Movie name : " + recomMovie.getMovieName());
                counter++;

            }
            if (counter >= 5) {
                break;
            }
        }

    }

    public void searchMemberAndOption(String userName) {
        int choice;
        boolean isFound=false;
        Scanner input = new Scanner(System.in);
        for (User member : Admin.getUsers()) {
            if (member instanceof Member && member.getUserName().equals(userName)) {
                //found
                isFound=true;
                boolean inSearchedMember = true;
                while (inSearchedMember) {
                    System.out.println("--------What do you want to do ?--------");
                    System.out.println("1. See profile");
                    System.out.println("2. Friend ");
                    System.out.println("3. Unfriend");
                    System.out.println("4. Creat direct massage ");
                    System.out.println("0. Exit");
                    try {
                        choice = Integer.parseInt(input.nextLine());
                    } catch (Exception e) {
                        System.out.println("YOU MUST ENTER NUMBER ! \t TRY AGAIN");
                        continue;
                    }
                    switch (choice) {
                        case 1:
                            ((Member) member).seeMemberDetails();
                            break;
                        case 2:
                            if (!getMembersWhomFollow().contains((Member) member)) {
                                addFriend((Member) member);
                            } else {
                                System.out.println("--------You are friend with this member--------");
                            }
                            break;
                        case 3:
                            if (getMembersWhomFollow().contains((Member) member)) {
                                getMembersWhomFollow().remove((Member) member);
                            } else {
                                System.out.println("--------You are not  friend with this member--------");
                            }
                        case 4:
                            DirectMassage direct=new DirectMassage(this,((Member) member));
                            this.getDirectMassagesM().add(direct);
                            ((Member)member).getDirectMassagesM().add(direct);
                            System.out.println("--------New chat created--------");
                            break;
                        case 0:
                            System.out.println("Exit");
                            inSearchedMember = false;
                            break;
                        default:
                            System.out.println("Wrong input");
                    }
                }
            }
        }
        if (!isFound){
            System.out.println("--------"+userName+" not found-------");
        }
    }

    public static Member searchMember(String userName) {
        for (User member : Admin.getUsers()) {
            if (member instanceof Member && ((Member) member).getUserName().equals(userName)) {
                return ((Member) member);
            }
        }
        return null;
    }

    public void searchPersonalList(String listName) {
        int counter = 1;
        boolean isFound=false;
        if (getPersonalLists().isEmpty()) {
            System.out.println("You don`t have any personal list to search in ! ");
            return;
        }
        for (PersonalList personalList : getPersonalLists()) {
            if (personalList.getNameOfList().equals(listName)) {
                isFound=true;
                System.out.println(personalList.getNameOfList() + " List Movies are : ");
                for (Movie movieInList : personalList.getListMovies()) {
                    System.out.println(counter + "." + movieInList.getMovieName());
                    counter++;
                }
            }
        }
        if (!isFound){
            System.out.println("--------"+listName+"not found--------");
        }

    }

    public void searchPeopleAndOption(String name) {
        int choice;
        boolean isFound=false;
        Scanner input = new Scanner(System.in);
        for (People people : Admin.getPeoples()) {
            if (people.getNameLastName().equals(name)) {
                //found
                isFound=true;
                boolean inSearchedPeple = true;
                while (inSearchedPeple) {
                    System.out.println("--------What do you want to do ?--------");
                    System.out.println("1. See profile");
                    System.out.println("2. Follow ");
                    System.out.println("3. Unfollow");
                    System.out.println("0. Exit");
                    try {
                        choice = Integer.parseInt(input.nextLine());
                    } catch (Exception e) {
                        System.out.println("YOU MUST ENTER NUMBER ! \t TRY AGAIN");
                        continue;
                    }
                    switch (choice) {
                        case 1:
                            people.seePersonDetails();
                            break;
                        case 2:
                            if (!getPeoples().contains(people)) {
                                getPeoples().add(people);
                            } else {
                                System.out.println("--------You follow this member--------");
                            }
                            break;
                        case 3:
                            if (getPeoples().contains(people)) {
                                getPeoples().remove(people);
                            } else {
                                System.out.println("--------You don't follow this member--------");
                            }
                        case 0:
                            System.out.println("Exit");
                            inSearchedPeple = false;
                            break;
                        default:
                            System.out.println("Wrong input");
                    }
                }
            }
        }
        if (!isFound){
            System.out.println("--------"+name+" not found-------");
        }
    }
}
