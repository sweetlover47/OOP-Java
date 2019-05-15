package Blocks;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class WriteBlockTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void execute() throws Exception{
        WriteBlock writeBlock1 = new WriteBlock();
        String expected1 = writeBlock1.execute(new String[]{"out_file.txt"}, "Z\nRb\nRba\nRaa\nA\n19");
        WriteBlock writeBlock2 = new WriteBlock();
        thrown.expect( Exception.class );
        thrown.expectMessage("Incorrect amount of arguments");
        String expected2 = writeBlock2.execute(new String[]{"out_file.txt", "out.txt"},"Z\nRb\nRba\nRaa\nA\n19" );
        WriteBlock writeBlock3 = new WriteBlock();
        String expected3 = writeBlock2.execute(null,"Z\nRb\nRba\nRaa\nA\n19" );
        WriteBlock writeBlock4 = new WriteBlock();
        thrown.expect( Exception.class );
        thrown.expectMessage("No text for WriteBlock");
        String expected4 = writeBlock3.execute(new String[]{"in_file.txt"}, null);
        Assert.assertNull(expected1);
        Assert.assertNull(expected2);
        Assert.assertNull(expected3);
        Assert.assertNull(expected4);
    }
}