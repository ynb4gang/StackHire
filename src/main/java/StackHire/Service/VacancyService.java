package StackHire.Service;

import StackHire.Entity.Vacancy;
import StackHire.Repository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacancyService {
    @Autowired
    private VacancyRepository vacancyRepository;

    public Vacancy getVacancyById(Long id){
        return vacancyRepository.findById(id).orElse(null);
    }

    public List<Vacancy> getAllVacancies(){
        return vacancyRepository.findAll();
    }

    public List<Vacancy> getByLocation(String location) {
        return vacancyRepository.findByLocation(location);
    }

    public List<Vacancy> getVacanciesByEmployer(Long employerId) {
        return vacancyRepository.findByEmployerId(employerId);
    }

    public Vacancy saveVacancy(Vacancy vacancy) {
        return vacancyRepository.save(vacancy);
    }

    public void deleteVacancy(Long id) {
        vacancyRepository.deleteById(id);
    }

    public Vacancy updateVacancy(Long id, Vacancy vacancyDetails) {
        Optional<Vacancy> vacancyOpt = vacancyRepository.findById(id);
        if (vacancyOpt.isPresent()) {
            Vacancy vacancy = vacancyOpt.get();
            vacancy.setTitle(vacancyDetails.getTitle());
            vacancy.setDescription(vacancyDetails.getDescription());
            vacancy.setLocation(vacancyDetails.getLocation());
            vacancy.setSalary(vacancyDetails.getSalary());
            return vacancyRepository.save(vacancy);
        }
        return null;
    }
}
