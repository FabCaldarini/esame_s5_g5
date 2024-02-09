package com.example.Esame.services;
import com.example.Esame.entities.Postazione;
import com.example.Esame.entities.Edificio;
import com.example.Esame.repositories.PostazioneRepository;
import com.example.Esame.repositories.EdificioRepository;
import com.example.Esame.enums.TipoPostazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private EdificioRepository edificioRepository;

    public List<Postazione> trovaPostazioniPerTipoECittà(TipoPostazione tipo, String città) {
        return postazioneRepository.findByTipoAndEdificio_Citta(tipo, città);
    }

    public boolean verificaPrenotazioneEsistente(Postazione postazione, LocalDate dataPrenotazione) {
        return postazioneRepository.existsByPostazioneAndDataPrenotazione(postazione, dataPrenotazione);
    }

}

