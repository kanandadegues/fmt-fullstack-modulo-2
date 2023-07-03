package br.senai.ex7.controllers;

import br.senai.ex7.models.Tutor;
import br.senai.ex7.services.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tutores")
public class TutorController {

    @Autowired
    private TutorService tutorService;

    @PostMapping
    public void cadastra(@RequestBody Tutor novoTutor) {
        tutorService.cadastra(novoTutor);
    }
}
