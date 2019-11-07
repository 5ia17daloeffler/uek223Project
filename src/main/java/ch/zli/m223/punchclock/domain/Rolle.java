package ch.zli.m223.punchclock.domain;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Rolle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type;


}
