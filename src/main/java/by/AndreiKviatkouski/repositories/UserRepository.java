package by.AndreiKviatkouski.repositories;

import by.AndreiKviatkouski.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

//    User findByUsername(String username);
//
//    @Query(value = "update User set username = ?1 where id = ?2")
//    String updateUserByUserName(String name, long id);
//
//    @Query(value = "update User set lastName = ?1 where id = ?2")
//    String updateUserByLastName(String lastName, long id);
//
//    @Query(value = "update User set firstName = ?1 where id = ?2")
//    String updateUserByFirstName(String firstName, long id);
//
//    @Query(value = "update User set status = ?1 where id = ?2")
//    void updateStatusById(Status status, long id);
//
//    @Query(value = "update User set roles = ?1 where id = ?2")
//    String updateUserByRole(String role, long id);

}
