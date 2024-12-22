package StackHire.Controller;

import StackHire.Entity.Resume;
import StackHire.Service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resume")
public class ResumeController {
    @Autowired
    private ResumeService resumeService;

    @GetMapping
    public List<Resume> getAllResumes() {
        return resumeService.getAllResumes();
    }

    @GetMapping("/{id}")
    public Resume getResumeById(@PathVariable Long id) {
        return resumeService.getResumeById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Resume> getResumesByUser(@PathVariable Long userId) {
        return resumeService.getResumesByUser(userId);
    }

    @PostMapping
    public Resume createResume(@RequestBody Resume resume) {
        return resumeService.saveResume(resume);
    }

    @PutMapping("/{id}")
    public Resume updateResume(@PathVariable Long id, @RequestBody Resume resumeDetails) {
        return resumeService.updateResume(id, resumeDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteResume(@PathVariable Long id) {
        resumeService.deleteResume(id);
    }
}
