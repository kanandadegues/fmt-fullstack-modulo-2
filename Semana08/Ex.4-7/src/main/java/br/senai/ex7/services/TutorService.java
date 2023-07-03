package br.senai.ex7.services;

import br.senai.ex7.models.Tutor;
import br.senai.ex7.repositories.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    public void cadastra(Tutor novoTutor) {
        tutorRepository.cadastra(novoTutor);
    }

}
