package com.example.Esame.config;

import com.example.Esame.entities.Edificio;
import com.example.Esame.entities.Postazione;
import com.example.Esame.entities.Utente;
import com.example.Esame.enums.TipoPostazione;
import com.example.Esame.repositories.EdificioRepository;
import com.example.Esame.repositories.PostazioneRepository;
import com.example.Esame.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    private final EdificioRepository edificioRepository;
    private final PostazioneRepository postazioneRepository;
    private final UtenteRepository utenteRepository;

    @Autowired
    public ApplicationConfig(EdificioRepository edificioRepository,
                             PostazioneRepository postazioneRepository,
                             UtenteRepository utenteRepository) {
        this.edificioRepository = edificioRepository;
        this.postazioneRepository = postazioneRepository;
        this.utenteRepository = utenteRepository;
    }

    public void initializeTestData() {
        Edificio edificio1 = new Edificio("Edificio A", "Indirizzo A", "Città A");
        edificioRepository.save(edificio1);

        Edificio edificio2 = new Edificio("Edificio B", "Indirizzo B", "Città B");
        edificioRepository.save(edificio2);


        Postazione postazione1 = new Postazione("COD001", "Descrizione postazione 1", TipoPostazione.PRIVATO, 1, edificio1);
        postazioneRepository.save(postazione1);

        Postazione postazione2 = new Postazione("COD002", "Descrizione postazione 2", TipoPostazione.ONESPACE, 1, edificio2);
        postazioneRepository.save(postazione2);


        Utente utente1 = new Utente("utente1", "Utente Uno", "utente1@example.com");
        utenteRepository.save(utente1);

        Utente utente2 = new Utente("utente2", "Utente Due", "utente2@example.com");
        utenteRepository.save(utente2);
    }
}



