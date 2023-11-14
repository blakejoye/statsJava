package com.Databaseprac1.DriverStats.stats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/driver")
public class StatsController {

    @Autowired
    private StatsService statsService;

    @GetMapping("/stats")
    public String viewAllStats(Model model) {
        List<Stats> stats = statsService.getAllStats();
        model.addAttribute("statsList", stats);
        return "viewStats"; // Your HTML for displaying all stats
    }

    @GetMapping("/editStats/{id}")
    public String editStats(@PathVariable Long id, Model model) {
        Stats stat = statsService.getStatsById(id);
        model.addAttribute("stat", stat);
        return "editStats"; // Corresponding HTML file for editing stats
    }

    @PostMapping("/updateStats")
    public String updateStats(@ModelAttribute Stats updatedStats) {
        statsService.updateStats(updatedStats);
        return "redirect:/driver/stats";
    }

    @GetMapping("/delete/{id}")
    public String deleteStats(@PathVariable Long id) {
        statsService.deleteStats(id);
        return "redirect:/driver/stats";
    }

    @PostMapping("/createStats")
    public String createStats(@ModelAttribute Stats newStats) {
        statsService.createStats(newStats);
        return "redirect:/driver/stats";
    }
}

