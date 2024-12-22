package StackHire.Repository;

import StackHire.Entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByResumeId(Long resumeId);
    List<Application> findByVacancyId(Long vacancyId);
}
