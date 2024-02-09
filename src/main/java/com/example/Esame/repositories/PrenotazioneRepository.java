package com.example.Esame.repositories;

import com.example.Esame.entities.Postazione;
import com.example.Esame.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    Collection<Prenotazione> findByPostazione(Postazione postazione);
}
