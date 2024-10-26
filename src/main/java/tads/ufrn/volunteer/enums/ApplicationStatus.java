package tads.ufrn.volunteer.enums;

import lombok.Getter;

@Getter
public enum ApplicationStatus {

    PENDING(1),
    APROVED(2),
    REJECTED(3),
    COMPLETED(4);

    private int value;

    private ApplicationStatus(int value) {
        this.value = value;
    }

    public static ApplicationStatus applicationStatus(int value) {
        for(ApplicationStatus type : ApplicationStatus.values()) {
            if (type.getValue() == value){
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
