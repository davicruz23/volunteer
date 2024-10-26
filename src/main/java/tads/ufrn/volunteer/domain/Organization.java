package tads.ufrn.volunteer.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String contactEmail;
    private String contactPhone;
    private String location;
    private String webSite;

    @ManyToMany(mappedBy = "organizations", fetch = FetchType.LAZY)
    private List<Volunteer> volunteers = new ArrayList<>();

    @OneToMany(mappedBy = "organization", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Opportunity> opportunities;
}
