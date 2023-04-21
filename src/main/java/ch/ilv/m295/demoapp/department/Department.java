package ch.ilv.m295.demoapp.department;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Department {

    @Id

    private Long id;

    @Column(nullable = false)
    @Size(max = 255)
    @NotEmpty
    private String name;


    @Column(nullable = false)
    @Size(max = 255)
    @NotEmpty
    private String Nachname;


    public Department() {
    }
}
