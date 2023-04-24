package org.example;

class User {

    private String username;
    private String password;
    private String access;

    public User(String username, String password, String access){
        this.username = username;
        this.password = password;
        this.access = access;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public boolean equals(Object Taken){
        if (!(Taken instanceof User)) {
            return false;
        }

        if (this == Taken) {
            return true;
        }

        User example = (User) Taken;
        return (username == example.getUsername() || access == example.getAccess());
    }




    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", access='" + access + '\'' +
                '}';
    }
}
