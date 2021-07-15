package one.digital.innovation.personapi.repository;

import one.digital.innovation.personapi.entity.AcademicBackground;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicBackgroundRepository extends JpaRepository<AcademicBackground, Long> {
}
