package com.example.Esame.repositories;

import com.example.Esame.entities.Postazione;
import com.example.Esame.enums.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {
    List<Postazione> findByTipoAndEdificio_Citta(TipoPostazione tipo, String citta);
    boolean existsByPostazioneAndDataPrenotazione(Postazione postazione, LocalDate dataPrenotazione);
}

