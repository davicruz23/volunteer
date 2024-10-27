package tads.ufrn.volunteer.controller.mapper;

import tads.ufrn.volunteer.domain.Application;
import tads.ufrn.volunteer.domain.dto.application.ApplicationDTO;
import tads.ufrn.volunteer.domain.dto.application.ApplicationListingDTO;

public class ApplicationMapper {
    public static ApplicationDTO mapper(Application src){
        return ApplicationDTO.builder()
                .id(src.getId())
                .statusId(src.getStatusId())
                .applicationDate(src.getApplicationDate())
                .volunteerFeedBack(src.getVolunteerFeedBack())
                .build();
    }

    public static ApplicationListingDTO listingDTO(Application src){
        return ApplicationListingDTO.builder()
                .id(src.getId())
                .statusId(src.getStatusId())
                .applicationDate(src.getApplicationDate())
                .volunteerFeedBack(src.getVolunteerFeedBack())
                .build();
    }
}
