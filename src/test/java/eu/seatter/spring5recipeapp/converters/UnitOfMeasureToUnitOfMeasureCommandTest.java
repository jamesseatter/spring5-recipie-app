package eu.seatter.spring5recipeapp.converters;

import eu.seatter.spring5recipeapp.commands.UnitOfMeasureCommand;
import eu.seatter.spring5recipeapp.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: jas
 * Date: 13/11/2018
 * Time: 14:34
 */
public class UnitOfMeasureToUnitOfMeasureCommandTest {

    private static final String DESCRIPTION = "description";
    private static final Long LONG_ID = new Long(1L);

    UnitOfMeasureToUnitOfMeasureCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @Test
    public void testNullObjectConvert() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObj() throws Exception {
        assertNotNull(converter.convert(new UnitOfMeasure()));
    }

    @Test
    public void convert() {
        //given
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(LONG_ID);
        uom.setDescription(DESCRIPTION);

        //when
        UnitOfMeasureCommand uomc  = converter.convert(uom);

        //then
        assertNotNull(uomc);
        assertEquals(LONG_ID, uomc.getId());
        assertEquals(DESCRIPTION, uomc.getDescription());
    }
}