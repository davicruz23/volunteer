package tads.ufrn.volunteer.controller.mapper;

import tads.ufrn.volunteer.domain.Organization;
import tads.ufrn.volunteer.domain.dto.oportunity.OpportunityListingDTO;
import tads.ufrn.volunteer.domain.dto.organization.OrganizationDTO;
import tads.ufrn.volunteer.domain.dto.organization.OrganizationListingDTO;

public class OrganizationMapper {
    public static OrganizationDTO mapper(Organization src){
        return OrganizationDTO.builder()
                .id(src.getId())
                .name(src.getName())
                .location(src.getLocation())
                .contactPhone(src.getContactPhone())
                .description(src.getDescription())
                .contactEmail(src.getContactEmail())
                .webSite(src.getWebSite())
                .build();
    }

    public static OrganizationListingDTO listingDTO(Organization src){
        return OrganizationListingDTO.builder()
                .id(src.getId())
                .name(src.getName())
                .location(src.getLocation())
                .contactPhone(src.getContactPhone())
                .description(src.getDescription())
                .contactEmail(src.getContactEmail())
                .webSite(src.getWebSite())
                .build();
    }
}
