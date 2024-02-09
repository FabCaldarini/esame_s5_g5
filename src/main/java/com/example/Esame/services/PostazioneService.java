package com.example.Esame.services;

import com.example.Esame.entities.Postazione;
import com.example.Esame.entities.Prenotazione;
import com.example.Esame.entities.Utente;
import com.example.Esame.enums.TipoPostazione;
import com.example.Esame.repositories.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;

    public List<Postazione> ricercaPostazioniPerTipoECittà(TipoPostazione tipo, String città) {
        return postazioneRepository.findByTipoAndEdificio_Citta(tipo, città);
    }

    public boolean effettuaPrenotazione(Postazione postazione, Utente utente, LocalDate dataPrenotazione) {
        if (postazioneRepository.existsByPostazioneAndDataPrenotazione(postazione, dataPrenotazione)) {
            return false;
        }

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setPostazione(postazione);
        prenotazione.setUtente(utente);
        prenotazione.setDataPrenotazione(dataPrenotazione);
        postazione.getPrenotazioni().add(prenotazione);
        postazioneRepository.save(postazione);
        return true;
    }
}
