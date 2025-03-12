package study.data_jpa.repository;

import org.springframework.cglib.core.Local;

public interface MemberProjection {

    Long getId();
    String getUsername();
    String getTeamName();

}
