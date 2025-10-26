package kseoni.ch.clswk.models;

import kseoni.ch.clswk.entities.Cat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CatModel {

    private String name;

    private int age;

    public static CatModel fromEntity(Cat cat){
        return new CatModel(cat.getName(), cat.getAge());
    }
}
