package Blocks;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class GrepBlockTest {

    @Rule public ExpectedException thrown = ExpectedException.none();
    @Test
    public void execute() throws Exception {
        GrepBlock grepBlock1 = new GrepBlock();
        String expected1 = grepBlock1.execute(new String[]{"Nastya"}, "Hello\n\rMy name is Nastya\n\rI think people with name Nastya is beautiful\n\rWhat about you?");
        GrepBlock grepBlock2 = new GrepBlock();
        thrown.expect( Exception.class );
        thrown.expectMessage("Incorrect amount of arguments");
        String expected2 = grepBlock2.execute(new String[]{"Nastya", "Katya"},"Hello\n\rMy name is Nastya\n\rI think people with name Nastya is beautiful\n\rWhat about you?" );
        GrepBlock grepBlock3 = new GrepBlock();
        String expected3 = grepBlock3.execute(null, "Hello\n\rMy name is Nastya\n\rI think people with name Nastya is beautiful\n\rWhat about you?");
        GrepBlock grepBlock4 = new GrepBlock();
        thrown.expect( Exception.class );
        thrown.expectMessage("No text for GrepBlock");
        String expected4 = grepBlock4.execute(new String[]{"Nastya"}, null);
        Assert.assertEquals(expected1, "Hello\n\rMy name is Katya\n\rI think people with name Katya is beautiful\n\rWhat about you?");
        Assert.assertNull(expected2);
        Assert.assertNull(expected3);
        Assert.assertNull(expected4);
    }
}