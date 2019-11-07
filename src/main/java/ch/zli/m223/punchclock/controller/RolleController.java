package ch.zli.m223.punchclock.controller;


import ch.zli.m223.punchclock.domain.Rolle;
import ch.zli.m223.punchclock.repository.RollenRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rollen")
public class RolleController {

    private RollenRepository rollenRepository;

    public RolleController(RollenRepository rollenRepository) {
        this.rollenRepository = rollenRepository;
    }

    @PostMapping("/add-rolle")
    public void addRolle(@RequestBody Rolle rolle) {
        rollenRepository.save(rolle);
    }


    @PostMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        rollenRepository.deleteById(id);
    }



    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Rolle> getAllEvents() {
        return rollenRepository.findAll();
    }

}

