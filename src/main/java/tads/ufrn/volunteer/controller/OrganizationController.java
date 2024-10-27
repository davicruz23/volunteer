package tads.ufrn.volunteer.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tads.ufrn.volunteer.controller.mapper.OpportunityMapper;
import tads.ufrn.volunteer.controller.mapper.OrganizationMapper;
import tads.ufrn.volunteer.domain.Opportunity;
import tads.ufrn.volunteer.domain.Organization;
import tads.ufrn.volunteer.domain.dto.oportunity.OpportunityDTO;
import tads.ufrn.volunteer.domain.dto.organization.OrganizationDTO;
import tads.ufrn.volunteer.domain.dto.organization.OrganizationListingDTO;
import tads.ufrn.volunteer.service.OrganizationService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/organization")
@AllArgsConstructor
public class OrganizationController {

    private final OrganizationService service;
    private final ModelMapper mapper;

    @GetMapping("/all")
    public ResponseEntity<List<Organization>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Organization> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<Page<OrganizationListingDTO>> index(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Page<Organization> organizationPage = service.index(page, size);
        Page<OrganizationListingDTO> opportunityListingDTOS = organizationPage.map(OrganizationMapper::listingDTO);
        return ResponseEntity.ok().body(opportunityListingDTOS);

    }

    @PostMapping
    public ResponseEntity<Organization> store(OrganizationDTO model){
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(service.store(model)).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrganizationDTO> update(@PathVariable Long id,@RequestBody OrganizationDTO model){
        model.setId(id);
        Organization organization = service.update(model);
        return ResponseEntity.ok().body(mapper.map(organization, OrganizationDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrganizationDTO> deleteById(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
