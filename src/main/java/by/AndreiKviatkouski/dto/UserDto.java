package by.AndreiKviatkouski.dto;

import by.AndreiKviatkouski.models.Role;
import by.AndreiKviatkouski.models.Status;
import by.AndreiKviatkouski.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    @NotBlank(message = "Name could not empty  ")
    @Size(min = 3, max = 16, message = "Name should be between 3 and 16 characters")
    @Pattern(regexp = "^[a-zA-Z]{3,16}$", message = "Latin characters only")
    private String username;

    @NotBlank(message = "Password could not empty ")
    @Size(min = 3, max = 16, message = "Password should be between 3 and 16 characters")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9]).[a-zA-Z0-9]+$",
            message = "Password should be at least one symbol and at least one digit")
    private String password;

    @Pattern(regexp = "^[A-Z][a-z]{1,16}$", message = "Example: Li")
    @Size(min = 1, max = 16, message = "Password should be between 1 and 16 characters")
    private String firstName;

    @Pattern(regexp = "^[A-Z][a-z]{1,16}$", message = "Example: Li")
    @Size(min = 1, max = 16, message = "Password should be between 1 and 16 characters")
    private String lastName;

    private Status status;

    private Role role;

    public User convertToUserUser() {
        UserDto userDto = new UserDto();
        User user = new User();
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setFirstName(this.firstName);
        user.setLastName(this.lastName);
        user.setStatus(this.status);

        return user;
    }
}
