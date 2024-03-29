package org.example;

public class Login {

    private String userName;
    private String passWord;

    public Login(String userName, String passWord){
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() { return userName; }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public boolean equal(Object Another){
        if (!(Another instanceof Login)){
            return false;
        }

        if (this == Another){
            return true;
        }

        Login test = (Login) Another;

        return (userName == test.userName && userName.equalsIgnoreCase(test.userName) && passWord.equalsIgnoreCase(test.passWord));
    }

}
