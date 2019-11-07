package ch.zli.m223.punchclock.repository;

import ch.zli.m223.punchclock.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    void deleteById(Long id);
}