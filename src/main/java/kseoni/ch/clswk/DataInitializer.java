package kseoni.ch.clswk;

import jakarta.annotation.PostConstruct;
import kseoni.ch.clswk.entities.Cat;
import kseoni.ch.clswk.models.CatModel;
import kseoni.ch.clswk.repository.CatRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final CatRepository catRepository;

    @PostConstruct
    public void init() {

        if(!catRepository.findAll().isEmpty()) {
            log.info("Cats already created");
            return;
        }

        ArrayList<Cat> cats = new ArrayList<>();

        cats.add(Cat.fromModel(new CatModel("Larik",3)));
        cats.add(Cat.fromModel(new CatModel("Boris",2)));
        cats.add(Cat.fromModel(new CatModel("Mosya",5)));
        cats.add(Cat.fromModel(new CatModel("Miya",1)));
        cats.add(Cat.fromModel(new CatModel("Sliva",1)));

        log.info("Cats created: {}",cats);

        List<Cat> catsEntities = catRepository.saveAll(cats);

        log.info("Cats saved: {}",catsEntities);
    }
}
