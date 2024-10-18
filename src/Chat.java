import java.util.ArrayList;
import java.util.Scanner;

public class Chat {
    private ArrayList<Massage> chatMassages=new ArrayList<>();

    public ArrayList<Massage> getChatMassages() {
        return chatMassages;
    }

    public void setChatMassages(ArrayList<Massage> chatMassages) {
        this.chatMassages = chatMassages;
    }
    public  void seeMassagesAndDo(Member member,Chat chat){
       Massage massageFound;
       int choose;
        int count=1;
        for (Massage massage:chatMassages){
            System.out.println(count+". "+massage.getSender().getUserName()+" : "+massage.getMassageText());
            count++;
        }
        Scanner input=new Scanner(System.in);
        if (chat.getChatMassages().isEmpty()){
            System.out.println("there is no chat ");
            return;
        }
        while (true){
            System.out.println("Enter number");
            try{
                choose=Integer.parseInt(input.nextLine());
                if (choose==0){
                    System.out.println("Exit search chat");
                   break;
                }
                else if (choose<=getChatMassages().size()){
                    massageFound =getChatMassages().get(choose-1);
                    if (massageFound!=null){
                        System.out.println("What do you want to do?");
                        System.out.println("1. delete massage ");
                        System.out.println("2. forward massage ");
                        System.out.println("3. like massage");
                        System.out.println("0. Exit");
                        try {
                            choose = Integer.parseInt(input.nextLine());
                            if (choose == 0) {
                                System.out.println("Exit search chat");
                                break;
                            }
                            else if (choose==1){
                                if(massageFound.getSender().equals(member) || ((chat instanceof GroupMassage) && ((GroupMassage)chat).getGroupAdmin().equals(member))){
                                getChatMassages().remove(massageFound);
                                System.out.println("Massage deleted");}
                                else {
                                    System.out.println("You cant delete other members massages");
                                }
                            }else if (choose==2){
                                member.seeYourChats().getChatMassages().add(massageFound);
                                System.out.println("Massage forwarded");
                            }else if (choose==3){
                                massageFound.getLikes().add(new Like(member,massageFound));
                                System.out.println("Massage liked");
                            }else {
                                System.out.println("Wrong input");
                            }
                        }catch (Exception e){
                            System.out.println("Write number");

                        }
                    }
                    else {
                        System.out.println("not found");
                    }
                }
                else{
                    System.out.println("Wrong input ");
                }
            }catch (Exception e){
                System.out.println("Wrong input");
            }}


    }
}
