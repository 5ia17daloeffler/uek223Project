package ch.zli.m223.punchclock.repository;

import ch.zli.m223.punchclock.domain.Rolle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RollenRepository extends JpaRepository<Rolle, Long> {
    void deleteById(Long id);
}
