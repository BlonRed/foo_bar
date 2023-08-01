import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FooBarTest {
    private static FooBar fB;
    private ByteArrayOutputStream outputStream;
    private final int n = 15;
    private final String s = System.lineSeparator();
    private final String expectedOutputFooBar = "1" + s + "2" + s + "Foo" + s + "4" + s + "Bar" + s + "Foo"
            + s + "7" + s + "8" + s + "Foo" + s + "Bar" + s + "11" + s + "Foo" + s + "13"
            + s + "14" + s + "FooBar" + s;

    private void recordTextFromConsole() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }
    private void closeRecordFromConsole() {
        try {
            outputStream.close();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    @BeforeEach
    private void prepare() {
        recordTextFromConsole();
        fB = new FooBar();
    }

    @AfterEach
    private void after(){
        closeRecordFromConsole();
    }

    @Test
    void testFooBarVersion1() {
        int version = 1;
        fB.processed(n, version);

        assertEquals(expectedOutputFooBar, outputStream.toString());
    }

    @Test
    void testFooBarVersion2() {
        int version = 2;
        fB.processed(n, version);

        assertEquals(expectedOutputFooBar, outputStream.toString());
    }

    @Test
    void testFooBarVersion3() {
        int version = 3;
        fB.processed(n, version);

        assertEquals(expectedOutputFooBar, outputStream.toString());
    }

    @Test
    void testFooBarVersion4() {
        int version = 4;
        fB.processed(n, version);

        assertEquals(expectedOutputFooBar, outputStream.toString());
    }

    @Test
    void test1Processed() {
        int number = 0;
        int version = 4;
        fB.processed(number, version);

        String expectedOutput = "Number less or equal 0. Try again." + s;
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void test2Processed() {
        int number = 1;
        int version = 0;
        fB.processed(number, version);

        String expectedOutput = "Value is 'version' invalid. Please choice value from 1 to 4." + s;
        assertEquals(expectedOutput, outputStream.toString());
    }
}