package tads.ufrn.volunteer.controller.mapper;

import tads.ufrn.volunteer.domain.Opportunity;
import tads.ufrn.volunteer.domain.dto.oportunity.OpportunityDTO;
import tads.ufrn.volunteer.domain.dto.oportunity.OpportunityListingDTO;

public class OpportunityMapper {
    public static OpportunityDTO mapper(Opportunity src){
        return OpportunityDTO.builder()
                .id(src.getId())
                .title(src.getTitle())
                .description(src.getDescription())
                .requirements(src.getRequirements())
                .location(src.getLocation())
                .startDate(src.getStartDate())
                .endDate(src.getEndDate())
                .isActive(src.getIsActive())
                .build();
    }

    public static OpportunityListingDTO listingDTO(Opportunity src){
        return OpportunityListingDTO.builder()
                .id(src.getId())
                .title(src.getTitle())
                .description(src.getDescription())
                .requirements(src.getRequirements())
                .location(src.getLocation())
                .startDate(src.getStartDate())
                .endDate(src.getEndDate())
                .isActive(src.getIsActive())
                .build();
    }
}
