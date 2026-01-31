package com.shura_crud.shura_stack.Controller;


import com.shura_crud.shura_stack.Model.Hero;
import com.shura_crud.shura_stack.Repository.HeroRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/heroes")
@CrossOrigin(origins = "http://localhost:5173")
public class HeroController {

private final HeroRepo heroRepo;

public HeroController(HeroRepo heroRepo){
    this.heroRepo = heroRepo;
}


@PostMapping("/addHero")

    public Hero add_Hero(@RequestBody  Hero hero){

    return heroRepo.save(hero);
}

@GetMapping("/getAll")

    public List<Hero> fetchHeroes(){
    return heroRepo.findAll();
}

@DeleteMapping("/delete/{id}")

    public ResponseEntity<Void> delete_Hero (@PathVariable Long id){
    if (!heroRepo.existsById(id)) {
        return ResponseEntity.notFound().build();
    }

    heroRepo.deleteById(id);
    return ResponseEntity.noContent().build(); //
}

}
