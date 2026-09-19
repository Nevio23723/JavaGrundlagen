# Membership - Businesslogic

## 1. Membership Status Overview

- **ACTIVE**: Valid contract with full facility access.
- **PAUSED**: Temporarily inactive membership; facility access is blocked.
- **CANCELLED**: Contract cancelled, but running until the end of the current billing period with full facility access.
- **EXPIRED**: Contract ended; facility access is blocked.
- **PENDING_UNDERAGE**: Registered user under 14 years old; membership is not yet active.
- **PENDING_MEDICAL_CLEARANCE**: Grace period for submitting a required medical certificate before turning 99.

---

## 2. Facility Access

Whenever a member attempts to check in at a facility scanner or turnstile, the system evaluates the membership status and returns an access decision:

- **GRANTED**: Access immediately.
    - *Applicable Statuses*: `ACTIVE`, `CANCELLED` (while within end date).
- **GRANTED_WITH_WARNING**: Access, but the terminal shows a notice.
    - *Applicable Status*: `PENDING_MEDICAL_CLEARANCE` (reminder to submit clearance).
- **DENIED**: No access; terminal shows the reason and redirects to staff.
    - *Applicable Statuses*: `PENDING_UNDERAGE`, `PAUSED`, `EXPIRED`.

---

## 3. Case A - User is Underage (< 14 Years)

### Rule

Users under 14 years old cannot train yet, but their registrration is captured early instead of throwing an exception and losing potential revenue.

- **Account Creation**: The user account and contract are created with status **PENDING_UNDERAGE**.
- **Activation**: On the user's 14th birthday, the status automatically switches to **ACTIVE**, and the running membership officially begins.
- **Facility Access Behavior**:
    - Result: **DENIED**.
    - Message: *"Access denied: Membership activates on your 14th birthday."*

---

## 4. Case B - User Turns 99 During Active Membership

### Rule

To ensure safety and reduce liability, members turning 99 must provide a valid medical clearance from a doctor to continue training.

### Process & Notifications

- **30 Days Before 99th Birthday**:
    - The member receives an automated **email** (and an optional **SMS alert**) requesting a medical clearance certificate.
    - Status switches from **ACTIVE** to **PENDING_MEDICAL_CLEARANCE**.
- **Submission of Clearance**:
    - Once a valid clearance is approved in the system, status reverts to **ACTIVE**.
- **Deadline Reached (99th Birthday)**:
    - If no certificate is logged by the 99th birthday, the membership automatically changes to **PAUSED**.

### Facility Access Behavior

- **During Grace Period (PENDING_MEDICAL_CLEARANCE)**:
    - Result: **GRANTED_WITH_WARNING**.
    - Message: *"Notice: Please submit your medical clearance before your 99th birthday."*
- **After Deadline without Clearance (PAUSED)**:
    - Result: **DENIED**.
    - Message: *"Access denied: Medical clearance required. Please contact the front desk."*