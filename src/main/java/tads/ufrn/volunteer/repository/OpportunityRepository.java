package tads.ufrn.volunteer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tads.ufrn.volunteer.domain.Opportunity;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {
}
