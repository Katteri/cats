package kseoni.ch.clswk.dao;

import kseoni.ch.clswk.models.CatModel;
import kseoni.ch.clswk.repository.CatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CatDao {

    private final CatRepository catRepository;

    public List<CatModel> getCatModels() {
        return catRepository.findAll().stream()
                .map(CatModel::fromEntity)
                .collect(Collectors.toList());
    }

}
