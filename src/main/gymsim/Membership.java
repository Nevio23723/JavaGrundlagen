package main.gymsim;

import java.util.UUID;

public class Membership {
    User user;
    MembershipStatus membershipStatus;
    UUID id;
    public static final int MIN_AGE = 13;
    public static final int UNDERAGE_THRESHOLD = 14;
    public static final int MAX_AGE = 99;

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
