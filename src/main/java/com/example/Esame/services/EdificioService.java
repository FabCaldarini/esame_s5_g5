package com.example.Esame.services;

import com.example.Esame.entities.Edificio;
import com.example.Esame.repositories.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EdificioService {

    @Autowired
    private EdificioRepository edificioRepository;

    public List<Edificio> getAllEdifici() {
        return edificioRepository.findAll();
    }

    public Optional<Edificio> getEdificioById(Long id) {
        return edificioRepository.findById(id);
    }

    public Edificio saveEdificio(Edificio edificio) {
        return edificioRepository.save(edificio);
    }

    public void deleteEdificioById(Long id) {
        edificioRepository.deleteById(id);
    }
}
