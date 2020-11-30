package java_problems.completable_future;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserDao {
    private static Map<Long, User> users;

    static {
        User ram = new User(1L, "Ram", "ram@gmail.com");
        User shyam = new User(2L, "Shyam", "shyam@gmail.com");
        User gopal = new User(3L, "Gopal", "gopal@gmail.com");

        users = new HashMap<>();
        users.put(ram.id, ram);
        users.put(shyam.id, shyam);
        users.put(gopal.id, gopal);
    }

    public static List<User> readUsers(List<Long> userIds) {
        System.out.println("Get Users from userId");
        return userIds.stream().map(id -> users.get(id)).collect(Collectors.toList());
    }
}
