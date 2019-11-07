package ch.zli.m223.punchclock.service;


import ch.zli.m223.punchclock.domain.User;
import ch.zli.m223.punchclock.repository.ApplicationUserRepository;
import org.jvnet.hk2.annotations.Service;

import java.util.List;


@Service
public class UserService {
    private ApplicationUserRepository userRepository;

    public UserService(ApplicationUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createEntry(User user) {
        return userRepository.saveAndFlush(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }


    /**
     * Löscht den Eintrag mit der mitgegebenen Id wird gelöscht.
     *
     * @param id
     */
    public void deleteEntry(long id) {
        userRepository.deleteById(id);
    }

}
