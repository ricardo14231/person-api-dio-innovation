package one.digital.innovation.personapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String companyName;

    @Column(nullable = false, length = 30)
    private String position;

    @Column(nullable = false)
    private LocalDate startPeriod;

    @Column(nullable = false)
    private String endPeriod;

    @Column(nullable = false, length = 100)
    private String attributions;

}
