package StackHire.Controller;

import StackHire.Entity.Application;
import StackHire.Service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping
    public List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }

    @GetMapping("/{id}")
    public Application getApplicationById(@PathVariable Long id) {
        return applicationService.getApplicationById(id);
    }

    @GetMapping("/resume/{resumeId}")
    public List<Application> getApplicationsByResume(@PathVariable Long resumeId) {
        return applicationService.getApplicationsByResume(resumeId);
    }

    @GetMapping("/vacancy/{vacancyId}")
    public List<Application> getApplicationsByVacancy(@PathVariable Long vacancyId) {
        return applicationService.getApplicationsByVacancy(vacancyId);
    }

    @PostMapping
    public Application createApplication(@RequestBody Application application) {
        return applicationService.saveApplication(application);
    }

    @PutMapping("/{id}/status")
    public Application updateApplicationStatus(@PathVariable Long id, @RequestBody String status) {
        return applicationService.updateApplicationStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteApplication(@PathVariable Long id) {
        applicationService.deleteApplication(id);
    }
}
