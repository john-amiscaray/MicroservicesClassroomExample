package io.john.amiscaray.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // Keeping only the student IDs, the rest of the data will be in the Student Service
    @ManyToMany(mappedBy = "takenBy")
    private List<Course> courses;

}
