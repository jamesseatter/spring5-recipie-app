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
public class NoteToNoteCommandTest {
    private static final Long ID_VALUE = 1L;
    private static final String RECIPE_NOTES = "Notes";
    private NoteToNoteCommand converter;

    @Before
    public void setUp() {
        converter = new NoteToNoteCommand();
    }

    @Test
    public void convert() {
        //given
        Note note = new Note();
        note.setId(ID_VALUE);
        note.setRecipeNotes(RECIPE_NOTES);

        //when
        NoteCommand notesCommand = converter.convert(note);

        //then
        assertEquals(ID_VALUE, notesCommand.getId());
        assertEquals(RECIPE_NOTES, notesCommand.getRecipeNotes());
    }

    @Test
    public void testNull() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter.convert(new Note()));
    }
}