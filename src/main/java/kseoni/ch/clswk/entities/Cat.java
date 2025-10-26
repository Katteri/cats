package kseoni.ch.clswk.entities;

import jakarta.persistence.*;
import kseoni.ch.clswk.models.CatModel;
import lombok.*;

@Entity
@Table(name = "cats")
@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    @Setter
    private Integer id;

    @Column
    private String name;

    @Column
    private int age;

    public static Cat fromModel(CatModel model){
        return Cat.builder()
                    .name(model.getName())
                    .age(model.getAge())
                    .build();
    }
}
