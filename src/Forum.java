import apple.laf.JRSUIConstants;
import com.sun.glass.ui.Clipboard;

import java.util.ArrayList;
import java.util.Scanner;

public class Forum {
    private String nameOfForum;
    private ArrayList<Member> MembersInForum = new ArrayList<>();
    private ArrayList<Massage> massages = new ArrayList<>();

    public Forum(String nameOfForum) {
        setNameOfForum(nameOfForum);
    }

    public String getNameOfForum() {
        return nameOfForum;
    }

    public void setNameOfForum(String nameOfForum) {
        this.nameOfForum = nameOfForum;
    }

    public void addMemberToForum(Member member) {
        MembersInForum.add(member);
    }

    public void addMassage(Massage massage) {
        massages.add(massage);
    }

    public ArrayList<Member> getMembersInForum() {
        return MembersInForum;
    }

    public void setMembersInForum(ArrayList<Member> membersInForum) {
        MembersInForum = membersInForum;
    }

    public ArrayList<Massage> getMassages() {
        return massages;
    }

    public void setMassages(ArrayList<Massage> massages) {
        this.massages = massages;
    }


    public static Forum searchForums() {
        int counter = 1;
        int choose;
        Scanner input = new Scanner(System.in);
        for (Forum forum : Admin.getForums()) {
            System.out.println(counter + ". forum name is : " + forum.getNameOfForum());
            counter++;
        }
        try {
            System.out.println("Choose number or '0' to exit :");
            choose = Integer.parseInt(input.nextLine());
            if(choose==0) {
                System.out.println("Exit");
            }
            else if(choose<=Admin.getForums().size()){return Admin.getForums().get(choose - 1);}
        } catch (Exception e) {
            System.out.println("Wrong input");
        }
        //not found
        return null;
    }

    public void deleteForumMember() {
        int counter = 1;
        int choice;
        boolean deleteMem = true;
        Scanner input = new Scanner(System.in);
        System.out.println("--------Forum members--------");
        for (Member memberInForum : getMembersInForum()) {
            System.out.println(counter + " . " + memberInForum.getUserName());
            counter++;
        }
        while (deleteMem) {
            System.out.println("Choose member to delete from this forum or '0' to exit");
            try {
                choice = Integer.parseInt(input.nextLine());
                if (choice == 0) {
                    deleteMem = false;
                    System.out.println("Exit");
                    break;
                }
                if (choice <= getMembersInForum().size()) {
                    getMembersInForum().remove(choice - 1);
                }
            } catch (Exception e) {
                System.out.println("YOU MUST ENTER NUMBER ! \t TRY AGAIN");
            }
        }

    }
   public void delelteMassegeFormForum(){
        int counter=1;
       int choose;
       Scanner input = new Scanner(System.in);
        for (Massage massage: getMassages()){
            System.out.println(counter+". "+massage.getSender().getUserName()+" sends :"+massage.getMassageText());
        }
       try {
           System.out.println("Choose massage to delete :");
           choose = Integer.parseInt(input.nextLine());
           if(choose==0) {
               System.out.println("Exit");
           }
           else if(choose<=Admin.getForums().size()){
               getMassages().remove(choose-1);
               System.out.println("Massage deleted");
           }
           else{
               System.out.println("Not found");
           }
       } catch (Exception e) {
           System.out.println("Wrong input");
       }
   }

}
