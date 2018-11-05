package eu.seatter.spring5recipeapp.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * Created by jas on 29/10/2018
 */
@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipe;

    @Lob    // Allows JPA to use a CLOB field in the DB to larger text can be stored than a DB Sdtring field.
    private String recipeNotes;
}
