package com.example.Esame.entities;

import com.example.Esame.enums.TipoPostazione;
import com.example.Esame.repositories.PrenotazioneRepository;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

@Entity
@Data
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codice;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    private TipoPostazione tipo;
    private int occupantiMax;
    @ManyToOne
    private Edificio edificio;

    public Postazione(String codice, String descrizione, TipoPostazione tipo, int occupantiMax, Edificio edificio) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.tipo = tipo;
        this.occupantiMax = occupantiMax;
        this.edificio = edificio;
    }

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public Collection<Prenotazione> getPrenotazioni() {
        return prenotazioneRepository.findByPostazione(this);
    }

    @Override
    public String toString() {
        return "Postazione{" +
                "id=" + id +
                ", codice='" + codice + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", tipo=" + tipo +
                ", occupantiMax=" + occupantiMax +
                ", edificio=" + edificio +
                ", prenotazioneRepository=" + prenotazioneRepository +
                '}';
    }
}
