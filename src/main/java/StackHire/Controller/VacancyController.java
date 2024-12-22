package StackHire.Controller;

import StackHire.Entity.Vacancy;
import StackHire.Service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vacancy")
public class VacancyController {
    @Autowired
    private VacancyService vacancyService;

    @GetMapping
    public List<Vacancy> getAllVacancies() {
        return vacancyService.getAllVacancies();
    }

    @GetMapping("/{id}")
    public Vacancy getVacancyById(@PathVariable Long id) {
        return vacancyService.getVacancyById(id);
    }

    @GetMapping("/location/{location}")
    public List<Vacancy> getVacanciesByLocation(@PathVariable String location) {
        return vacancyService.getByLocation(location);
    }

    @PostMapping
    public Vacancy createVacancy(@RequestBody Vacancy vacancy) {
        return vacancyService.saveVacancy(vacancy);
    }

    @PutMapping("/{id}")
    public Vacancy updateVacancy(@PathVariable Long id, @RequestBody Vacancy vacancyDetails) {
        return vacancyService.updateVacancy(id, vacancyDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteVacancy(@PathVariable Long id) {
        vacancyService.deleteVacancy(id);
    }

}
