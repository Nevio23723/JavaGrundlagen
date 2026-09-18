# Membership - Businesslogic

### Problem - user is underage
If a user is under 14 years old, my program will currently throw an exception, costing us potential
revenue, since the 13 year old will be frustrated and go sign up for another gym. Fixing this could be done
by implementing a new Status called **PENDING_UNDERAGE**.

### Problem - User turns 99 years old while having a running membership
A user has his 99th birthday, while still having an active membership. For this problem, the user would get 
a short notice beforehand, to let his doctor get him a medical clearance. Without this clearance, his membership
will get paused (**PAUSED**).


## New Status

### 1. Membership Status 
- **ACTIVE**: Valid Contract
- **PAUSED**: Inactive for said amount of time
- **CANCELLED**: Contract cancelled but still running until the end of the duration
- **EXPIRED**: Contract overdue - no active membership
- **PENDING_UNDERAGE**: Registered, but not running contract until 14th Birthday
- **PENDING_MEDICAL_CLEARANCE**: Short notice before turning f.e. 90 days

### 2. Case A - User is underage
- ***Creation***: User will be created with Status **PENDING_UNDERAGE**.
- ***Facility Access***: will be denied in AccessControl.java
- ***Activation***: Once the User turns 14 the membership status will automatically turn **ACTIVE**, which
will initialise the membership.

### 3. Case B - User turns 99 during active membership
- ***Creation***: Allowed. 
- ***Member turning 99:***
  - User will get an email requesting a medical certificate stating he is able to train under given circumstances
  - If 30 days beforehand no medical certificate is logged, the user's membership will be "**PENDING_MEDICAL_CLEARANCE**". 
  - User will have facility access if object "MedicalCertificate" is valid.
