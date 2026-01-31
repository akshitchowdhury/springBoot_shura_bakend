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

    public ResponseEntity <Hero> add_Hero(@RequestBody  Hero hero){

    Hero savedHero = heroRepo.save(hero);

    return ResponseEntity.ok(savedHero);
}

@GetMapping("/getAll")

    public List<Hero> fetchHeroes(){
    return heroRepo.findAll();
}

@PutMapping("/updateHero/{id}")

public ResponseEntity <Hero> updateHero(@PathVariable Long id,   @RequestBody Hero updatedHero){

    return heroRepo.findById(id)
            .map(existingHero -> {
                // Force ID from path (important)
                updatedHero.setId(id);

                Hero savedHero = heroRepo.save(updatedHero);
                return ResponseEntity.ok(savedHero);
            })
            .orElseGet(() -> ResponseEntity.notFound().build());
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
