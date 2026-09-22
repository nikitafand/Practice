package coding.dsa;

import java.util.ArrayList;
import java.util.List;

 class RegistrationPortal {

    private static RegistrationPortal registrationPortal;
    private final List<String> registeredUsers;
    //private final  String username;

    private RegistrationPortal() {

        this.registeredUsers = new ArrayList<>();
    }


    public static RegistrationPortal getRegistrationPortal() {
        synchronized (RegistrationPortal.class) {
            if (registrationPortal == null) {
                registrationPortal = new RegistrationPortal();
            }
        }

        return registrationPortal;
    }

    public Boolean registerUser(String username) {
        if(registeredUsers.contains(username)) {
            return false;
        }
        return registeredUsers.add(username);
    }

    public List<String> getRegisteredUsers() {
        return registeredUsers;
    }
}
