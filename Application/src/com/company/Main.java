package com.company;

import java.text.ParseException;
import java.util.ArrayList;

/*
* Applicant: Pasecinic Nichita
* Email: nichitastrix@gmail.com
*/
public class Main {

    public static void main(String[] args) throws ParseException {

        // several User objects
        // to verify the if the output is correct you can manually change the timestamp for users (pattern: "yyyy-mm-dd hh:mm:ss")
        User user1 = new User("Nichita", "Pasecinic", 19, "nichitastrix@gmail.com", "NEW", "2020-09-30 22:56:22");
        User user2 = new User("Mark", "Tree", 18, "mark@gmail.com", "ACTIVE");
        User user3 = new User("Karl", "Vandervile", 20, "karl@gmail.com", "INACTIVE", "2020-09-01 22:23:11");
        User user4 = new User("Alice", "Ionescu", 19, "alice@gmail.com", "NEW");
        User user5 = new User("Don", "Clarlo", 22, "don@gmail.com", "ACTIVE");
        User user6 = new User("John", "Bird", 21, "john@gmail.com", "INACTIVE", "2019-09-01 21:22:32");

        // ArrayList for users
        ArrayList<User> usersList = new ArrayList<User>();
        // add user objects to the arrayList
        usersList.add(user1);
        usersList.add(user2);
        usersList.add(user3);
        usersList.add(user4);
        usersList.add(user5);
        usersList.add(user6);

        // Change status to ACTIVE for NEW users
        for (User user: usersList) {
            if (user.getStatus() == "NEW") {
                // check if the timestamp was registered more then 24h ago
                if (user.isOlderThanYesterday()){
                    user.setStatus("ACTIVE"); // update the status
                }
            }
        }
        // display results for task1 using custom toString method
        System.out.println("UPDATING NEW USERS!!\n");
        for (User user: usersList) {
            System.out.println(user.toString());
        }

        // Change status to BLOCKED for INACTIVE users
        for (User user: usersList) {
            if (user.getStatus() == "INACTIVE") {
                // if more than one month has elapsed since the day of registration
                if (user.isOlderThanOneMonth()) {
                    user.setStatus("BLOCKED"); // update status
                }
            }
        }
        // displaying results for taks2
        System.out.println("UPDATING INACTIVE USERS!!\n");
        for (User user: usersList) {
            System.out.println(user.toString());
        }

    }
}

/*
    OUTPUT:

UPDATING NEW USERS!!

User Name: Nichita Pasecinic
User Email: nichitastrix@gmail.com
User Age: 19
User TimeStamp: 2020-09-30 22:56:22.0
User Status: ACTIVE


User Name: Mark Tree
User Email: mark@gmail.com
User Age: 18
User TimeStamp: 2020-10-02 08:14:02.28
User Status: ACTIVE


User Name: Karl Vandervile
User Email: karl@gmail.com
User Age: 20
User TimeStamp: 2020-09-01 22:23:11.0
User Status: INACTIVE


User Name: Alice Ionescu
User Email: alice@gmail.com
User Age: 19
User TimeStamp: 2020-10-02 08:14:02.28
User Status: NEW


User Name: Don Clarlo
User Email: don@gmail.com
User Age: 22
User TimeStamp: 2020-10-02 08:14:02.28
User Status: ACTIVE


User Name: John Bird
User Email: john@gmail.com
User Age: 21
User TimeStamp: 2019-09-01 21:22:32.0
User Status: INACTIVE


UPDATING INACTIVE USERS!!

User Name: Nichita Pasecinic
User Email: nichitastrix@gmail.com
User Age: 19
User TimeStamp: 2020-09-30 22:56:22.0
User Status: ACTIVE


User Name: Mark Tree
User Email: mark@gmail.com
User Age: 18
User TimeStamp: 2020-10-02 08:14:02.28
User Status: ACTIVE


User Name: Karl Vandervile
User Email: karl@gmail.com
User Age: 20
User TimeStamp: 2020-09-01 22:23:11.0
User Status: BLOCKED


User Name: Alice Ionescu
User Email: alice@gmail.com
User Age: 19
User TimeStamp: 2020-10-02 08:14:02.28
User Status: NEW


User Name: Don Clarlo
User Email: don@gmail.com
User Age: 22
User TimeStamp: 2020-10-02 08:14:02.28
User Status: ACTIVE


User Name: John Bird
User Email: john@gmail.com
User Age: 21
User TimeStamp: 2019-09-01 21:22:32.0
User Status: BLOCKED



Process finished with exit code 0
*/
