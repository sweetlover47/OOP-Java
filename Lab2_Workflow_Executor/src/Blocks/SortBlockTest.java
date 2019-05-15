package Blocks;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class SortBlockTest {

    @Rule public ExpectedException thrown = ExpectedException.none();
    
    @Test
    public void execute() throws Exception{
        SortBlock sortBlock1 = new SortBlock();
        String expected1 = sortBlock1.execute(new String[]{}, "Z\nRb\nRba\nRaa\nA\n19");
        SortBlock sortBlock2 = new SortBlock();
        thrown.expect( Exception.class );
        thrown.expectMessage("Incorrect amount of arguments");
        String expected2 = sortBlock2.execute(new String[]{"Nastya"},"Z\nRb\nRba\nRaa\nA\n19" );
        SortBlock sortBlock3 = new SortBlock();
        thrown.expect( Exception.class );
        thrown.expectMessage("No text for SortBlock");
        String expected3 = sortBlock3.execute(new String[]{}, null);
        Assert.assertEquals(expected1, "19\nA\nRaa\nRb\nRba\nZ");
        Assert.assertNull(expected2);
        Assert.assertNull(expected3);
    }
}