package tads.ufrn.volunteer.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tads.ufrn.volunteer.domain.Volunteer;
import tads.ufrn.volunteer.domain.dto.volunteer.VolunteerDTO;
import tads.ufrn.volunteer.repository.VolunteerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VolunteerService {

    private final VolunteerRepository repository;
    private final ModelMapper mapper;


    public List<Volunteer> findAll(){
        return repository.findAll();
    }

    public Volunteer findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public Page<Volunteer> index(int page,int size){
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
    }

    public Volunteer store(VolunteerDTO model){
        return repository.save(mapper.map(model, Volunteer.class));
    }

    public Volunteer update(VolunteerDTO model){
        return repository.save(mapper.map(model, Volunteer.class));
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
