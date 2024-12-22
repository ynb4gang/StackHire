package StackHire.Service;

import StackHire.Entity.Application;
import StackHire.Entity.Vacancy;
import StackHire.Repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

    public Application getApplicationById(Long id) {
        return applicationRepository.findById(id).orElse(null);
    }

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public List<Application> getApplicationsByResume(Long resumeId) {
        return applicationRepository.findByResumeId(resumeId);
    }

    public List<Application> getApplicationsByVacancy(Long vacancyId) {
        return applicationRepository.findByVacancyId(vacancyId);
    }

    public Application saveApplication(Application application) {
        return applicationRepository.save(application);
    }

    public void deleteApplication(Long id) {
        applicationRepository.deleteById(id);
    }

    public Application updateApplicationStatus(Long id, String newStatus) {
        Application application = applicationRepository.findById(id).orElse(null);
        if (application != null) {
            application.setStatus(newStatus);
            return applicationRepository.save(application);
        }
        return null;
    }
}
