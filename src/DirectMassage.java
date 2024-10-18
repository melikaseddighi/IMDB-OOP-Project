import java.util.ArrayList;

public class DirectMassage extends Chat{
    private Member A;
    private Member B;

    public DirectMassage(Member a, Member b) {
        A = a;
        B = b;
    }

    public Member getA() {
        return A;
    }

    public void setA(Member a) {
        A = a;
    }

    public Member getB() {
        return B;
    }

    public void setB(Member b) {
        B = b;
    }

}
