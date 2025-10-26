package kseoni.ch.clswk.controller.v1;

import jakarta.annotation.PostConstruct;
import kseoni.ch.clswk.dao.CatDao;
import kseoni.ch.clswk.models.CatModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cat")
@RequiredArgsConstructor
public class MainController {

    private final CatDao catDao;

    @GetMapping("")
    public List<CatModel> getCats(){
        return catDao.getCatModels();
    }

    @PostMapping("")
    public CatModel putCat(CatModel model){
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
