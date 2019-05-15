package Blocks;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ReplaceBlockTest {

    @Rule public ExpectedException thrown = ExpectedException.none();
    @Test
    public void execute() throws Exception {
        ReplaceBlock replaceBlock1 = new ReplaceBlock();
        String expected1 = replaceBlock1.execute(new String[]{"Nastya", "Katya"}, "Hello\n\rMy name is Nastya\n\rI think people with name Nastya is beautiful\n\rWhat about you?");
        ReplaceBlock replaceBlock2 = new ReplaceBlock();
        thrown.expect( Exception.class );
        thrown.expectMessage("Incorrect amount of arguments");
        String expected2 = replaceBlock2.execute(new String[]{"Nastya"},"Hello\n\rMy name is Nastya\n\rI think people with name Nastya is beautiful\n\rWhat about you?" );
        ReplaceBlock replaceBlock3 = new ReplaceBlock();
        String expected3 = replaceBlock3.execute(null, "Hello\n\rMy name is Nastya\n\rI think people with name Nastya is beautiful\n\rWhat about you?");
        ReplaceBlock replaceBlock4 = new ReplaceBlock();
        thrown.expect( Exception.class );
        thrown.expectMessage("No text for ReplaceBlock");
        String expected4 = replaceBlock4.execute(new String[]{"Nastya" , " Katya"}, null);
        Assert.assertEquals(expected1, "Hello\n\rMy name is Katya\n\rI think people with name Katya is beautiful\n\rWhat about you?");
        Assert.assertNull(expected2);
        Assert.assertNull(expected3);
        Assert.assertNull(expected4);
    }

}