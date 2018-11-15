package eu.seatter.spring5recipeapp.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA.
 * User: jas
 * Date: 13/11/2018
 * Time: 12:45
 */
@Setter
@Getter
@NoArgsConstructor
public class NoteCommand {
    private Long id;
    private String recipeNotes;
}
