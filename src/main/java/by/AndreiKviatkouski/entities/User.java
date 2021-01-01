package by.AndreiKviatkouski.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_account")

public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name could not empty  ")
    @Size(min=3, max = 16, message = "Name should be between 3 and 16 characters")
    @Pattern(regexp = "^[a-zA-Z]$", message = "Latin characters only")
    private String username;

    @NotBlank(message = "Password could not empty ")
    @Size(min=3, max = 16, message = "Password should be between 3 and 16 characters")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9]).[a-zA-Z0-9]+$", message = "Password should be at least one symbol and at least one digit")
    private String password;

    @Pattern(regexp = "^[A-Z][a-z]{1,16}$", message = "Example: Li")
    @Size(min=1, max = 16, message = "Password should be between 1 and 16 characters")
    private String firstName;

    @Pattern(regexp = "^[A-Z][a-z]{1,16}$", message = "Example: Li")
    @Size(min=1, max = 16, message = "Password should be between 1 and 16 characters")
    private String lastName;

    @Transient
    Date date = new Date();
    @Transient
    SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd 'time' hh:mm:ss a zzz");
    private String createdAt = formatForDateNow.format(date);

    @Enumerated(value = EnumType.STRING)
    private Status status = Status.ACTIVE;


    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getPassword() {
        return password;
    }

}
