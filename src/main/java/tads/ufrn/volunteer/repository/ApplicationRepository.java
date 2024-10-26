package tads.ufrn.volunteer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tads.ufrn.volunteer.domain.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
