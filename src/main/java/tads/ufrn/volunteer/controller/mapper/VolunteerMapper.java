package tads.ufrn.volunteer.controller.mapper;

import tads.ufrn.volunteer.domain.Volunteer;
import tads.ufrn.volunteer.domain.dto.volunteer.VolunteerDTO;
import tads.ufrn.volunteer.domain.dto.volunteer.VolunteerListingDTO;

public class VolunteerMapper {
    public static VolunteerDTO mapper(Volunteer src){
        return VolunteerDTO.builder()
                .id(src.getId())
                .name(src.getName())
                .email(src.getEmail())
                .dateJoined(src.getDateJoined())
                .password(src.getPassword())
                .location(src.getLocation())
                .availability(src.getAvailability())
                .skills(src.getSkills())
                .build();

    }

    public static VolunteerListingDTO listingDTO(Volunteer src){
        return VolunteerListingDTO.builder()
                .name(src.getName())
                .email(src.getEmail())
                .dateJoined(src.getDateJoined())
                .password(src.getPassword())
                .location(src.getLocation())
                .availability(src.getAvailability())
                .skills(src.getSkills())
                .build();
    }
}
