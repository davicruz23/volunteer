package tads.ufrn.volunteer.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tads.ufrn.volunteer.controller.mapper.VolunteerMapper;
import tads.ufrn.volunteer.domain.Volunteer;
import tads.ufrn.volunteer.domain.dto.volunteer.VolunteerDTO;
import tads.ufrn.volunteer.domain.dto.volunteer.VolunteerListingDTO;
import tads.ufrn.volunteer.service.VolunteerService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/volunteer")
@AllArgsConstructor
public class VonlunteerController {

    private final VolunteerService service;
    private final ModelMapper mapper;

    @GetMapping("/all")
    public ResponseEntity<List<Volunteer>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping
    public ResponseEntity<Page<VolunteerListingDTO>> index(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Page<Volunteer> volunteerPage = service.index(page, size);
        Page<VolunteerListingDTO> volunteerDTOS = volunteerPage.map(VolunteerMapper::listingDTO);
        return ResponseEntity.ok().body(volunteerDTOS);

    }

    @PostMapping
    public ResponseEntity<Volunteer> store(VolunteerDTO model){
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(service.store(model)).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<VolunteerDTO> update(@PathVariable Long id,@RequestBody VolunteerDTO model){
        model.setId(id);
        Volunteer volunteer = service.update(model);
        return ResponseEntity.ok().body(mapper.map(volunteer, VolunteerDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VolunteerDTO> deleteById(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }


}
