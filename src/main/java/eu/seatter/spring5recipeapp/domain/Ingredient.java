package eu.seatter.spring5recipeapp.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by jas on 29/10/2018
 */

@Getter
@Setter
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;

    @OneToOne(fetch=FetchType.EAGER)
    private UnitOfMeasure uom;

    @ManyToOne
    private Recipe recipe;

    public Ingredient() {
    }

    public Ingredient(BigDecimal amount, UnitOfMeasure uom, String description) {
        this.amount = amount;
        this.uom = uom;
        this.description = description;
    }

    public Ingredient(BigDecimal amount, UnitOfMeasure uom, String description, Recipe recipe) {
        this.amount = amount;
        this.uom = uom;
        this.description = description;
        this.recipe = recipe;
    }

}
