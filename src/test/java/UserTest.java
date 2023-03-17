import org.example.User;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class UserTest {
    User user = new User();
    String emailField = "Ybasdra@gmail.com";
    String firstNameField = "ybas22137";

    @Test
    @DisplayName("Cоздание нового пользователя с валидными данными")
    public void testCreateUser () {
         user.createNewUser(emailField, firstNameField);
    }
    @Test
    @DisplayName("проверка добавления аватарки")
    public void  testAddAvatar(){
        user.addNewAvatar(emailField);
    }
    @Test
    @DisplayName("проверка добавления и удаления аватарки")
    public void  testDeleteAvatar(){
        user.deleteAvatar(emailField);
    }
    @Test
    @DisplayName("создает и юзера, и таски")
    public void testCreateUserAndTask(){
        user.createUserWithTasks(emailField, firstNameField, "Задача один", "Задача тридцать два");
    }
    @Test
    @DisplayName("Создание компании")
    public void testCreateCompany(){
        user.createNewCompany("yepsonas", "OAO", emailField,"kompancus");
    }
}
