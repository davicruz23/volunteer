package tads.ufrn.volunteer.domain.dto.organization;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrganizationListingDTO {

    private Long id;
    private String name;
    private String description;
    private String contactEmail;
    private String contactPhone;
    private String location;
    private String webSite;

}