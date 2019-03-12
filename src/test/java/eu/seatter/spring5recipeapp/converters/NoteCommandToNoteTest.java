package eu.seatter.spring5recipeapp.converters;

import eu.seatter.spring5recipeapp.commands.NoteCommand;
import eu.seatter.spring5recipeapp.domain.Note;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: jas
 * Date: 13/11/2018
 * Time: 14:33
 */
public class NoteCommandToNoteTest {
    private static final Long ID_VALUE = 1L;
    private static final String RECIPE_NOTES = "Notes";
    private NoteCommandToNote converter;

    @Before
    public void setUp() {
        converter = new NoteCommandToNote();

    }

    @Test
    public void testNullParameter() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter.convert(new NoteCommand()));
    }

    @Test
    public void convert() {
        //given
        NoteCommand notesCommand = new NoteCommand();
        notesCommand.setId(ID_VALUE);
        notesCommand.setRecipeNotes(RECIPE_NOTES);

        //when
        Note note = converter.convert(notesCommand);

        //then
        assertNotNull(note);
        assertEquals(ID_VALUE, note.getId());
        assertEquals(RECIPE_NOTES, note.getRecipeNotes());
    }
}