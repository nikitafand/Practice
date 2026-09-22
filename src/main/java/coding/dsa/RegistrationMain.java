package coding.dsa;


import java.util.Scanner;

public class RegistrationMain
{

    public static void main(String[] args)
    {
        RegistrationPortal portal= RegistrationPortal.getRegistrationPortal();

        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            if(s.trim().isEmpty()){
                return;
            }

            String[]  split = s.split(" ");
            if(split[0].equals("REGISTER")){
                Boolean b = portal.registerUser(split[1]);
                System.out.println(b.toString());
            }else if(split[0].equals("GET_USERS")){
                System.out.println(portal.getRegisteredUsers());
            }
        }
    sc.close();
    }
}
