package tads.ufrn.volunteer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tads.ufrn.volunteer.domain.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long>{
}
