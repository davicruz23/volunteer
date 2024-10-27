package tads.ufrn.volunteer.domain.dto.oportunity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OpportunityListingDTO {

    private Long id;
    private String title;
    private String description;
    private String requirements;
    private String location;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isActive;
}
