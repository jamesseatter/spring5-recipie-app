package eu.seatter.spring5recipeapp.repositories;

import eu.seatter.spring5recipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
