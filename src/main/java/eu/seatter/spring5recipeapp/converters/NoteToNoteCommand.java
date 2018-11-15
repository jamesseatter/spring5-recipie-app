package eu.seatter.spring5recipeapp.converters;

import eu.seatter.spring5recipeapp.commands.NoteCommand;
import eu.seatter.spring5recipeapp.domain.Note;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: jas
 * Date: 13/11/2018
 * Time: 14:04
 */
@Component
public class NoteToNoteCommand implements Converter<Note, NoteCommand> {

    @Nullable
    @Override
    public NoteCommand convert(Note source) {
        if(source == null) {
            return null;
        }

        final NoteCommand noteCommand = new NoteCommand();
        noteCommand.setId(source.getId());
        noteCommand.setRecipeNotes(source.getRecipeNotes());
        return noteCommand;
    }
}
