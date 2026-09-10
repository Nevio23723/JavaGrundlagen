package GymSim;

public class Membership {
    User user;

    public Membership(User user) {
        this.user = user;
    }

    public String toString() {
        return user.toString();
    }

}
