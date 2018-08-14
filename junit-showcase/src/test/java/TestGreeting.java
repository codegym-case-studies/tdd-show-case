import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestGreeting {

    @Test
    public void testThatApplicationCanSayHelloWorld() {
        String expected = "Hello world!";
        String actual = Application.greeting();
        assertEquals(expected, actual);
    }
    @Test
    public void testThatApplicationCanSayHelloToSomeOne() {
        String name = "sonnb";
        String expected = "Hello sonnb!";
        String actual = Application.greeting(name);
        assertEquals(expected, actual);
    }
}
