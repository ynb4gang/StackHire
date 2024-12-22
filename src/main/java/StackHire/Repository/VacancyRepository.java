package StackHire.Repository;

import StackHire.Entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
    List<Vacancy> findByLocation(String location);
    List<Vacancy> findByEmployerId(Long employerId);
}
