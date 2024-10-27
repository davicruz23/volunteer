package tads.ufrn.volunteer.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tads.ufrn.volunteer.controller.mapper.ApplicationMapper;
import tads.ufrn.volunteer.domain.Application;
import tads.ufrn.volunteer.domain.dto.application.ApplicationDTO;
import tads.ufrn.volunteer.domain.dto.application.ApplicationListingDTO;
import tads.ufrn.volunteer.service.ApplicationService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/application")
@AllArgsConstructor
public class ApplicationController {

    private final ApplicationService service;
    private final ModelMapper mapper;

    @GetMapping("/all")
    public ResponseEntity<List<Application>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Application> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<Page<ApplicationListingDTO>> index(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Page<Application> applicationPage = service.index(page, size);
        Page<ApplicationListingDTO> applicationListingDTOS = applicationPage.map(ApplicationMapper::listingDTO);
        return ResponseEntity.ok().body(applicationListingDTOS);

    }

    @PostMapping
    public ResponseEntity<Application> store(ApplicationDTO model){
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(service.store(model)).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApplicationDTO> update(@PathVariable Long id,@RequestBody ApplicationDTO model){
        model.setId(id);
        Application application = service.update(model);
        return ResponseEntity.ok().body(mapper.map(application, ApplicationDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApplicationDTO> deleteById(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
