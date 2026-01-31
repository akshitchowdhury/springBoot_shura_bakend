package com.shura_crud.shura_stack.Repository;

import com.shura_crud.shura_stack.Model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepo extends JpaRepository<Hero , Long> {
}
