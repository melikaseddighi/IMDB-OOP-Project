import java.util.ArrayList;

public class Massage {
    private Member sender;
    private String MassageText;
    private ArrayList<Like> likes=new ArrayList<>();


    public ArrayList<Like> getLikes() {
        return likes;
    }
    public void setLikes(ArrayList<Like> likes) {
        this.likes = likes;
    }
    public Member getSender() {
        return sender;
    }

    public void setSender(Member sender) {
        this.sender = sender;
    }

    public String getMassageText() {
        return MassageText;
    }

    public void setMassageText(String massageText) {
        MassageText = massageText;
    }

    public Massage(String text, Member sender) {
        setMassageText(text);
        setSender(sender);
    }
}
