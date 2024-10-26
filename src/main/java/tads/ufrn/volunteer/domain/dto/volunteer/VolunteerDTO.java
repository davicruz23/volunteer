package tads.ufrn.volunteer.domain.dto.volunteer;

import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VolunteerDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private LocalDate dateJoined;
    private List<String> skills;
    private String location;
    private String availability;
}
