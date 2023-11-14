package com.CSC340proj.CSC340Proj;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "stats")
public class Stats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String driverName;
    private int totalRaces;
    private int wins;

    public Stats(String driverName, int totalRaces, int wins) {
        this.driverName = driverName;
        this.totalRaces = totalRaces;
        this.wins = wins;
    }
    public double getWinPercentage() {
        if (totalRaces == 0) return 0;
        return ((double) wins / totalRaces) * 100;
    }
}
