import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class FooBarTest {
    static FooBar fB;
    final int n = 15;
    final String s = System.lineSeparator();
    final String expectedOutput = "1" + s + "2" + s + "Foo" + s + "4" + s + "Bar" + s + "Foo"
            + s + "7" + s + "8" + s + "Foo" + s + "Bar" + s + "11" + s + "Foo" + s + "13"
            + s + "14" + s + "FooBar" + s;

    @BeforeAll
    static void prepare(){
        fB = new FooBar();
    }

    @Test
    void testFooBarVersion1() {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        fB.fooBarVersion1(n);

        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void testFooBarVersion2() {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        fB.fooBarVersion2(n);

        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void testFooBarVersion3() {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        fB.fooBarVersion3(n);

        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void testFooBarVersion4() {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        fB.fooBarVersion4(n);

        assertEquals(expectedOutput, outputStream.toString());
    }
}