package tads.ufrn.volunteer.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Volunteer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private LocalDate dateJoined;

    @ElementCollection
    private List<String> skills = new ArrayList<>();

    private String location;
    private String availability;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "opportunity_volunteers", // Definindo uma única tabela de junção
            joinColumns = @JoinColumn(name = "volunteer_id"),
            inverseJoinColumns = @JoinColumn(name = "opportunity_id")
    )
    private List<Opportunity> opportunities = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "organization_volunteers",
            joinColumns = @JoinColumn(name = "volunteer_id"),
            inverseJoinColumns = @JoinColumn(name = "organization_id")
    )
    private List<Organization> organizations = new ArrayList<>();

    @OneToMany(mappedBy = "volunteer", fetch = FetchType.LAZY)
    private List<Application> applications = new ArrayList<>();
}
