package hellojpa.domain;

import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;

@Embeddable
public class Period {

    //기간 Period
    private LocalDateTime startDate;
    private LocalDateTime endDate;


}
