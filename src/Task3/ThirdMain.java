package Task3;

public class ThirdMain {
    public static void main(String[] args) {
        Serializator serializator = new Serializator();
        User user = new User("Belo4ka", 23, "email@gmail.com", "Male");
        serializator.serialize(user);
        User userAfterDeserialize = (User) serializator.deserialize();
        if (user.equals(userAfterDeserialize)) {
            System.out.println("Objects are equal!");
        } else {
            System.out.println("Objects are not equal");
        }
    }
}
