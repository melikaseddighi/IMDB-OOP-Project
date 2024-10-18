import java.util.ArrayList;
import java.util.Scanner;

public class GroupMassage extends Chat {
    private String groupName;
    private Member groupAdmin;
    private ArrayList<Member> groupMembers = new ArrayList<>();

    public GroupMassage(String groupName, Member groupAdmin) {
        this.groupName = groupName;
        this.groupAdmin = groupAdmin;
        groupMembers.add(groupAdmin);
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }


    public Member getGroupAdmin() {
        return groupAdmin;
    }

    public void setGroupAdmin(Member groupAdmin) {
        this.groupAdmin = groupAdmin;
    }

    public ArrayList<Member> getGroupMembers() {
        return groupMembers;
    }

    public void setGroupMembers(ArrayList<Member> groupMembers) {
        this.groupMembers = groupMembers;
    }

    public void seeMembersInChat(Member admin) {
        int count = 1;
        Scanner input = new Scanner(System.in);
        System.out.println("Admin : " + getGroupAdmin().getUserName());
        for (Member member : getGroupMembers()) {
            System.out.println(count + ". " + member.getUserName());
            count++;
        }
        System.out.println("0. Exit");
        int choose, choose1;
        while (true) {
            if (!admin.equals(getGroupAdmin())){
                System.out.println("You cant do any thing if you are not admin");
                return;
            }
            System.out.println("What do you want to do?");
            System.out.println("1. Add member to group if you are admin");
            System.out.println("2. delete member from group if you are admin");
            System.out.println("0. Exit ");
            try {
                choose1 = Integer.parseInt(input.nextLine());
                if (choose1 == 1) {
                    System.out.println("Enter member's user name you want to add");
                    User user=Admin.searchUsers(input.nextLine());
                    if(user==null){
                        System.out.println("not found");
                        break;
                    }
                    if (user instanceof Member && !getGroupMembers().contains(user)){
                        Member member=((Member) user);
                        getGroupMembers().add(member);
                        System.out.println("New member is added ");
                    }
                    else{
                        System.out.println("Founded user is not a member or member is already in group");
                    }
                } else if (choose1 == 2) {
                    while (true) {
                        System.out.println("choose member");
                        try {
                            choose = Integer.parseInt(input.nextLine());
                            if (choose == 0) {
                                System.out.println("Exit ");
                                break;
                            } else if (choose <= getGroupMembers().size()) {
                                getGroupMembers().get(choose - 1).getGroupMassagesM().remove(this);
                                getGroupMembers().remove(choose - 1);
                            }

                        } catch (Exception e) {
                            System.out.println("Wrong input");
                        }
                    }
                } else if (choose1 == 0) {
                    System.out.println("Exit");
                    break;
                } else {
                    System.out.println("Wrong input");
                }
            }catch (Exception e){
                System.out.println("Wrong input");
            }
        }
    }
}

