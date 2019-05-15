package Blocks;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ReadBlockTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void execute() throws  Exception {
        ReadBlock readBlock1 = new ReadBlock();
        String expected1 = readBlock1.execute(new String[]{"in_file.txt"}, "hello" );
        ReadBlock readBlock2 = new ReadBlock();
        thrown.expect( Exception.class );
        thrown.expectMessage("Incorrect amount of arguments");
        String expected2 = readBlock2.execute(new String[]{"in_file.txt", "jj.txt"},"hello" );
        ReadBlock readBlock3 = new ReadBlock();
        String expected3 = readBlock3.execute(null, "hello");
        ReadBlock readBlock4 = new ReadBlock();
        String expected4 = readBlock4.execute(new String[]{"in_file.txt"}, null);
        Assert.assertNotNull(expected1);
        Assert.assertNull(expected2);
        Assert.assertNull(expected3);
        Assert.assertNotNull(expected4);
    }
}