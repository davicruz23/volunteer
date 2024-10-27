package tads.ufrn.volunteer.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tads.ufrn.volunteer.controller.mapper.OpportunityMapper;
import tads.ufrn.volunteer.domain.Opportunity;
import tads.ufrn.volunteer.domain.dto.oportunity.OpportunityDTO;
import tads.ufrn.volunteer.domain.dto.oportunity.OpportunityListingDTO;
import tads.ufrn.volunteer.service.OpportunityService;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/opportunity")
@AllArgsConstructor
public class OpportunityController {

    private final OpportunityService service;
    private final ModelMapper mapper;

    @GetMapping("/all")
    public ResponseEntity<List<Opportunity>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Opportunity> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<Page<OpportunityListingDTO>> index(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Page<Opportunity> opportunityPage = service.index(page, size);
        Page<OpportunityListingDTO> opportunityListingDTOS = opportunityPage.map(OpportunityMapper::listingDTO);
        return ResponseEntity.ok().body(opportunityListingDTOS);

    }

    @PostMapping
    public ResponseEntity<Opportunity> store(OpportunityDTO model){
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(service.store(model)).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<OpportunityDTO> update(@PathVariable Long id,@RequestBody OpportunityDTO model){
        model.setId(id);
        Opportunity opportunity = service.update(model);
        return ResponseEntity.ok().body(mapper.map(opportunity, OpportunityDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OpportunityDTO> deleteById(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
