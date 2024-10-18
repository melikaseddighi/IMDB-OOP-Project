import java.util.Date;

public class User {
    private String name;
    private String email;
    private Date dateOfBirth;
    private String userName;
    private String PassWord;
    Banning banningStatus=Banning.NOTBAN;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public Banning getBanningStatus() {
        return banningStatus;
    }

    public void setBanningStatus(Banning banningStatus) {
        this.banningStatus = banningStatus;
    }
    public boolean isBan(User user){
        return !banningStatus.equals(Banning.NOTBAN);
    }



    public User searchUser(String userName){
        for (User user:Admin.getUsers()) {
            if (user.getUserName().equals(userName)){
                return user;
            }
        }
        return null;
    }

}
