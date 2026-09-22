package coding.dsa;



import java.util.Objects;

public record  User(String name, int id, String email) {
 public User{
     Objects.nonNull(name);

 }


    public void makeCopies() {

    }
}
