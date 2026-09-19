package main.gymsim;

import java.util.UUID;

public class Membership {
    User user;
    MembershipStatus membershipStatus;
    UUID id;

    public Membership(User user, MembershipStatus status) {
        this.id = UUID.randomUUID();
        this.user = user;
        this.membershipStatus = status;
    }

    public String toString() {
        return user.toString() + ", " + membershipStatus;
    }


    public void pause() {
        this.membershipStatus = MembershipStatus.PAUSED;
    }

    public void cancel() {
        this.membershipStatus = MembershipStatus.CANCELLED;
    }

    public MembershipStatus getMembershipStatus() {return membershipStatus; }




}
