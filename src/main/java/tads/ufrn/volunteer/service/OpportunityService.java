package tads.ufrn.volunteer.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tads.ufrn.volunteer.domain.Opportunity;
import tads.ufrn.volunteer.domain.Volunteer;
import tads.ufrn.volunteer.domain.dto.oportunity.OpportunityDTO;
import tads.ufrn.volunteer.domain.dto.volunteer.VolunteerDTO;
import tads.ufrn.volunteer.repository.OpportunityRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OpportunityService {

    private final OpportunityRepository repository;
    private final ModelMapper mapper;


    public List<Opportunity> findAll(){
        return repository.findAll();
    }

    public Opportunity findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public Page<Opportunity> index(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
    }

    public Opportunity store(OpportunityDTO model){
        return repository.save(mapper.map(model, Opportunity.class));
    }

    public Opportunity update(OpportunityDTO model){
        return repository.save(mapper.map(model, Opportunity.class));
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
