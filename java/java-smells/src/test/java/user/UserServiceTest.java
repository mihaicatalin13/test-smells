package user;

import java.time.LocalDate;

import model.User;
import service.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    private final UserService userService = new UserService();
    private User user1;
    private User user2;
    private User user3;

    // NOT DETECTED - general fixture - setUp initializes 3 objects, only 2 are used for testing
    // DETECTED - magic number

    @BeforeEach
    protected void setUp() throws Exception {
        user1 = userService.addUser("USER 1", LocalDate.of(2003, 6, 29));
        user2 = userService.addUser("USER 2", LocalDate.of(2010, 6, 28));
        user3 = userService.addUser("USER 3", LocalDate.of(2003, 6, 29));
    }

    @Test
    public void adult() {
        assertTrue(userService.isAdult(user1.getId()));
        // DETECTED - assertion roulette
        // assertFalse(userService.isAdult(user2.getId()));
    }

    // DETECTED - lazy test (LT) when adult method also calls isAdult
    @Test
    public void lazyTest() {
        assertTrue(userService.isAdult(user1.getId()));
    }

    // DETECTED - empty test (ET)
    // DETECTED - unknown test (UT)
    @Test
    public void emptyTest() {

    }
}
