package spring.validation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.validation.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
