package by.AndreiKviatkouski.service;

import by.AndreiKviatkouski.entities.Role;
import by.AndreiKviatkouski.entities.Status;
import by.AndreiKviatkouski.entities.User;
import by.AndreiKviatkouski.repositories.RoleRepository;
import by.AndreiKviatkouski.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @PersistenceContext
    private EntityManager em;

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    final UserRepository userRepository;

    final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    public boolean check(User user) {
        for (int i = 0; i < userRepository.findAll().size(); i++) {
            User user1 = userRepository.findAll().get(i);
            if (user1.getPassword().equals(user.getPassword()) &&
                    user1.getUsername().equals(user.getUsername())) {
                return true;
            }
        }

        return false;
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public void saveUser(User user) {
        User userFromDB = userRepository.findByUsername(user.getUsername());
        if (userFromDB == null) {
            user.setUsername(bCryptPasswordEncoder.encode(user.getUsername()));
            user.setPassword(user.getPassword());
            user.setFirstName(user.getFirstName());
            user.setLastName(user.getLastName());
            user.setCreatedAt(user.getCreatedAt());
            user.setStatus(Status.ACTIVE);
            user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
            userRepository.save(user);
        }
    }

    public boolean update(User user, long id) {
        User existUser = userRepository.getOne(id);

        boolean checkParam = false;
        if (user.getUsername() != null) {
            existUser.setUsername(user.getUsername());
            checkParam = true;
        }
        if (user.getPassword() != null) {
            existUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            checkParam = true;
        }

        if (user.getFirstName() != null) {
            existUser.setFirstName(user.getFirstName());
            checkParam = true;
        }
        if (user.getLastName() != null) {
            existUser.setLastName(user.getLastName());
            checkParam = true;
        }
        if (user.getStatus() != null) {
            existUser.setStatus(user.getStatus());
            checkParam = true;
        }
        if (user.getRoles() != null) {
            existUser.setRoles(user.getRoles());
            checkParam = true;
        }

        if (checkParam) {
            Date date = new Date();
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd 'time' hh:mm:ss a zzz");
            existUser.setUpdatedAt(formatForDateNow.format(date));
            userRepository.save(existUser);
            return true;
        }
        return false;
    }
//методы show and findUserById равнозначны и работают с страницей id
    public User show(long id) {
        return em.createQuery("SELECT u FROM User u WHERE u.id=:id", User.class)
                .setParameter("id", id).getSingleResult();
    }
    //метод getById не работает с страницей id
    public User getById(long id) {
        return userRepository.getOne(id);

    }
    //методы show and findUserById равнозначны и работают с страницей id
    public User findUserById(long userId) {
        Optional<User> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new User());
    }

//    public List<User> userList(Long idMin) {
//        return em.createQuery("SELECT u FROM User u WHERE u.id > :paramId", User.class)
//                .setParameter("paramId", idMin).getResultList();
//    }
//
//


    public void delete(long id) {
        userRepository.deleteById(id);
    }
}






