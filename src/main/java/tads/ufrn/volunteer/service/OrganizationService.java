package tads.ufrn.volunteer.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tads.ufrn.volunteer.domain.Opportunity;
import tads.ufrn.volunteer.domain.Organization;
import tads.ufrn.volunteer.domain.dto.oportunity.OpportunityDTO;
import tads.ufrn.volunteer.domain.dto.organization.OrganizationDTO;
import tads.ufrn.volunteer.domain.dto.volunteer.VolunteerDTO;
import tads.ufrn.volunteer.repository.OrganizationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final OrganizationRepository repository;
    private final ModelMapper mapper;


    public List<Organization> findAll(){
        return repository.findAll();
    }

    public Organization findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public Page<Organization> index(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
    }

    public Organization store(OrganizationDTO model){
        return repository.save(mapper.map(model, Organization.class));
    }

    public Organization update(OrganizationDTO model){
        return repository.save(mapper.map(model, Organization.class));
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
