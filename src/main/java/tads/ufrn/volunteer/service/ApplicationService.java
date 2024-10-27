package tads.ufrn.volunteer.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tads.ufrn.volunteer.domain.Application;
import tads.ufrn.volunteer.domain.dto.application.ApplicationDTO;
import tads.ufrn.volunteer.domain.dto.oportunity.OpportunityDTO;
import tads.ufrn.volunteer.repository.ApplicationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepository repository;
    private final ModelMapper mapper;


    public List<Application> findAll(){
        return repository.findAll();
    }

    public Application findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public Page<Application> index(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
    }

    public Application store(ApplicationDTO model){
        return repository.save(mapper.map(model, Application.class));
    }

    public Application update(ApplicationDTO model){
        return repository.save(mapper.map(model, Application.class));
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
