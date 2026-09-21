package main.gymsim;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class Membership {
    User user;
    MembershipStatus membershipStatus;
    private final UUID id;
    public static final int MIN_AGE = 13;
    public static final int UNDERAGE_THRESHOLD = 14;
    public static final int MAX_AGE = 99;

    public Membership(User user) {
        this.id = UUID.randomUUID();
        this.user = user;

        int age = Period.between(user.getDateOfBirth(), LocalDate.now()).getYears();

        if (age < Membership.UNDERAGE_THRESHOLD) {
            membershipStatus = MembershipStatus.PENDING_UNDERAGE;
        } else {
            membershipStatus = MembershipStatus.ACTIVE;
        }
    }



    public String toString() {
        return user.toString() + ", " + user.getId() + ", " + membershipStatus;
    }

    public void pause() {
        this.membershipStatus = MembershipStatus.PAUSED;
    }

    public void cancel() {
        this.membershipStatus = MembershipStatus.CANCELLED;
    }

    public MembershipStatus getMembershipStatus() {
        return membershipStatus; 
    }

    




}
