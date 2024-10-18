import java.util.Scanner;

public class UserManagement {
    public static User loginUser(String userName, String passWord) {
        for (User user : Admin.getUsers()) {
            if (user.getUserName().equals(userName) && user.getPassWord().equals(passWord)) {
                if (user.getBanningStatus()==Banning.BAN){
                    System.out.println("You are ban and can't login");
                    return null;
                }
                return user;
            }
        }
        return null;
    }

    public static Member singeUpUser() {
        Scanner input = new Scanner(System.in);
        String userName, passWord;
        boolean notExist ;
        System.out.println("Enter user name you want ! or 0 to exit");
        userName = input.nextLine();
        while (true) {
            notExist = true;
            if(userName.equals("0")){
                System.out.println("you exit sing up process!");
                return null;
            }
            for (User user : Admin.getUsers()) {
                if (user.getUserName().equals(userName)) {
                    notExist = false;
                    System.out.println("Entered username exist try another one !");
                    userName = input.nextLine();
                    break;
                }
            }
            if (notExist) {
                System.out.println("Enter the password !");
                passWord = input.nextLine();
                Admin.printRules();
                System.out.println("--------Enter 'Y' to accept rules and any thing else to reject--------");
                String choose=input.nextLine();
                Member member = new Member(userName, passWord);
                if (choose.equals("Y")){
                    System.out.println("You have singed up ");
                    member.setRuleAccepted(AcceptRule.ACCEPT_RULE);
                    Admin.getUsers().add(member);
                    return member;
                }else {
                    member.setRuleAccepted(AcceptRule.DONTACCEPT_RULE);
                    System.out.println("You haven't accept rules ");
                    return null;
                }

            }
        }
    }

}
