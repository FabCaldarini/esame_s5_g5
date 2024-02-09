package com.example.Esame.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Postazione postazione;
    @ManyToOne
    private Utente utente;
    private LocalDate dataPrenotazione;

    @Override
    public String toString() {
        return "Prenotazione{" +
                "id=" + id +
                ", postazione=" + postazione +
                ", utente=" + utente +
                ", dataPrenotazione=" + dataPrenotazione +
                '}';
    }
}
