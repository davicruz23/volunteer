package tads.ufrn.volunteer.domain.dto.application;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicationDTO {

    private Long id;
    private int statusId;
    private LocalDate applicationDate;
    private String volunteerFeedBack;
}
