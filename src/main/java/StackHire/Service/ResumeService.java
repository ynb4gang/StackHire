package StackHire.Service;

import StackHire.Entity.Resume;
import StackHire.Repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResumeService {
    @Autowired
    private ResumeRepository resumeRepository;

    public Resume getResumeById(Long id) {
        return resumeRepository.findById(id).orElse(null);
    }

    public List<Resume> getAllResumes() {
        return resumeRepository.findAll();
    }

    public List<Resume> getResumesByUser(Long userId) {
        return resumeRepository.findByUserId(userId);
    }

    public Resume saveResume(Resume resume) {
        return resumeRepository.save(resume);
    }

    public void deleteResume(Long id) {
        resumeRepository.deleteById(id);
    }

    public Resume updateResume(Long id, Resume resumeDetails) {
        Optional<Resume> resumeOpt = resumeRepository.findById(id);
        if (resumeOpt.isPresent()) {
            Resume resume = resumeOpt.get();
            resume.setTitle(resumeDetails.getTitle());
            resume.setSkills(resumeDetails.getSkills());
            resume.setExperience(resumeDetails.getExperience());
            return resumeRepository.save(resume);
        }
        return null;
    }
}
