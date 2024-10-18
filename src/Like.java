public class Like {
    Member member;
    Object likableEntity;
    public Like(Member member,Object likableEntity){
        setLikableEntity(likableEntity);
        setMember(member);
    }
    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Object getLikableEntity() {
        return likableEntity;
    }

    public void setLikableEntity(Object likableEntity) {
        this.likableEntity = likableEntity;
    }

}
