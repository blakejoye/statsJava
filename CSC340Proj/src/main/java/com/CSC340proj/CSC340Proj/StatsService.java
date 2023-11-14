package com.CSC340proj.CSC340Proj;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatsService {
    @Autowired
    private StatsRepo statsRepo;

    public List<Stats> getAllStats() {
        return statsRepo.findAll();
    }


    public Stats updateStats(Stats updatedStats){

        return statsRepo.save(updatedStats);
    }
    public Stats createStats(Stats newStats){

        return statsRepo.save(newStats);
    }
    public void deleteStats(Long id){

        statsRepo.deleteById(id);
    }
    public Stats getStatsById(Long id){

        return statsRepo.findById(id).orElse(null);
    }


}
