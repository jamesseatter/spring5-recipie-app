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
 * Time: 14:02
 */
@Component
public class NoteCommandToNote implements Converter<NoteCommand, Note> {

    @Nullable
    @Override
    public Note convert(NoteCommand source) {
        if (source == null ) {
            return null;
        }

        final Note note = new Note();
        note.setId(source.getId());
        note.setRecipeNotes(source.getRecipeNotes());
        return note;
    }
}
