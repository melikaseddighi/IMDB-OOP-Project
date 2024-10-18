import java.util.ArrayList;
import java.util.Scanner;

public class People {
    private String nameLastName;
    private ArrayList<PeopleType> peopleTypes=new ArrayList<>();
    private int age=0;
    private String bio;


    public People(String nameLastName,int age){
        setNameLastName(nameLastName);
        setAge(age);
    }
    public People(String nameLastName){
        setNameLastName(nameLastName);
    }

    public People(String nameLastName,String bio){
        setNameLastName(nameLastName);
        setBio(bio);
    }
    public People(String nameLastName,String bio,int age){
        setNameLastName(nameLastName);
        setBio(bio);
        setAge(age);
    } public People(){
    }


    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getNameLastName() {
        return nameLastName;
    }

    public void setNameLastName(String nameLastName) {
        this.nameLastName = nameLastName;
    }

    public ArrayList<PeopleType> getPeopleTypes() {
        return peopleTypes;
    }

    public void setPeopleTypes(ArrayList<PeopleType> peopleTypes) {
        this.peopleTypes = peopleTypes;
    }


    public void addPeopleType(PeopleType peopleType){
        peopleTypes.add(peopleType);
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public static People searchPeople(String name){
        for (People people:Admin.getPeoples()) {
            if(people.getNameLastName().equals(name)){
                return people;
            }
        }
        System.out.println("Person Not Found !");
        return null;
    }
    public static People searchPeopleByMovie(String movieName){
        Scanner input =new Scanner(System.in);
        boolean isFound=false;
        ArrayList<People> peopleInMovie=new ArrayList<>();
        int choosePerson;
        int counter=1;
        for (Movie movie:Admin.getMovies()) {
            if (movie.getMovieName().equals(movieName)){
                isFound=true;
                for (People people: movie.getActor()) {
                    System.out.println(counter+"."+people.getNameLastName());
                    peopleInMovie.add(people);
                    counter++;
                }
                for (People people: movie.getDirector()) {
                    System.out.println(counter+"."+people.getNameLastName());
                    peopleInMovie.add(people);
                    counter++;
                }
                for (People people: movie.getWriter()) {
                    System.out.println(counter+"."+people.getNameLastName());
                    peopleInMovie.add(people);
                    counter++;
                }
                break;
            }
        }
        if (!isFound){
            System.out.println("No one found");
            return null;
        }
        System.out.println("Which one you choose (Choose number)?");
        choosePerson=Integer.parseInt(input.nextLine());

        return peopleInMovie.get(choosePerson-1);
    }

    public void seePersonDetails(){
        System.out.println("This person name is :"+getNameLastName());
        System.out.print(getPeopleTypes()+"profetions is/are :");
        for (PeopleType peopleType: getPeopleTypes()) {
            System.out.print(peopleType+"\t");
        }
        System.out.println(getNameLastName() +"is"+getAge() +"years old !");
        if (getBio() != null) {
            System.out.println("his/her Bio :"+getBio());
        }
    }
}
