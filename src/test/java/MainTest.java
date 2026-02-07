import org.example.Main;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class MainTest {

    @Mock
    Scanner scannerMock;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Nested
    class EquivalencePartition{
        @Test
        public void test1() {
            mockScanner("5k2/1ppn2pp/p3bp2/2P1p3/4P3/1P2BPP1/P3B1KP/8");
            Main.validateFEN(scannerMock);
            assertTrue(outputStreamCaptor.toString().contains("Pozitie Corecta"));
        }
        @Test
        public void test2() {
            mockScanner("5k2/1ppn2pp/p3bp2/2P1p3/4P3/1P2BPP1/P2KB1KP/8");
            Main.validateFEN(scannerMock);
            assertTrue(outputStreamCaptor.toString().contains("Pozitie Incorecta"));
        }
        @Test
        public void test3() {
            mockScanner("1p2/8/8/7q");
            Main.validateFEN(scannerMock);
            assertTrue(outputStreamCaptor.toString().contains("FEN Invalid"));
        }
        @Test
        public void test4() {
            mockScanner("rnbqkbnrr/ppppppppp/pppppppp/pppppppp/pppppppp/pppppppp/pppppppp/rnbqkbnrr");
            Main.validateFEN(scannerMock);
            assertTrue(outputStreamCaptor.toString().contains("FEN Invalid"));
        }
        @Test
        public void test5() {
            mockScanner("rnbqkbnrr/ppppppppp/8/8/4P3/8");
            Main.validateFEN(scannerMock);
            assertTrue(outputStreamCaptor.toString().contains("FEN Invalid"));
        }
        @Test
        public void test6() {
            mockScanner("r1sk3r/p9pBpNp/n4n2/1p1NP2P/6P1/3P4/P1P1K3/q5b1");
            Main.validateFEN(scannerMock);
            assertTrue(outputStreamCaptor.toString().contains("FEN Invalid"));
        }

        @Test
        public void test7() {
            mockScanner("rnbqkbnrr/ppppppppp/8/8/4P3/8/PPPP1PPP/RNBQKBNR");
            Main.validateFEN(scannerMock);
            assertTrue(outputStreamCaptor.toString().contains("FEN Invalid"));
        }


    }

    @Nested
    class BoundaryValue{
        @Test
        public void test8() {
            mockScanner("8/8/8/8/8/8/8/8");
            Main.validateFEN(scannerMock);
            assertTrue(outputStreamCaptor.toString().contains("Pozitie Incorecta"));
        }
        @Test
        public void test9() {
            mockScanner("rnbqkbnr/pppppppp/NNNNNNNN/NNRRNNNN/NNRRNNNN/NNNRNNNN/PPPPPPPP/RNBQKBNN");
            Main.validateFEN(scannerMock);
            assertTrue(outputStreamCaptor.toString().contains("Pozitie Incorecta"));
        }
        @Test
        public void test10() {
            mockScanner("8/8/8/7q1/1qR");
            Main.validateFEN(scannerMock);
            assertTrue(outputStreamCaptor.toString().contains("FEN Invalid"));
        }
        @Test
        public void test11() {
            mockScanner("");
            Main.validateFEN(scannerMock);
            assertTrue(outputStreamCaptor.toString().contains("FEN Invalid"));
        }
        @Test
        public void test12() {
            mockScanner("rrrrrrrr/rrrrrrrr/rrrrrrrr/rrrrrrrr/rrrrrrrr/rrrrrrrr/rrrrrrrr/rrrrrrrrr");
            Main.validateFEN(scannerMock);
            assertTrue(outputStreamCaptor.toString().contains("FEN Invalid"));
        }
        @Test
        public void test13() {
            mockScanner("r1qk3r/p4pBpNp/n4n2/1p1NP2P/6P1/3P4/");
            Main.validateFEN(scannerMock);
            assertTrue(outputStreamCaptor.toString().contains("FEN Invalid"));
        }
        @Test
        public void test14() {
            mockScanner("r1qk3r/p4pB/Np7/n4n2/1p7N/P2P/6P1/3P4/8");
            Main.validateFEN(scannerMock);
            assertTrue(outputStreamCaptor.toString().contains("FEN Invalid"));
        }
        @Test
        public void test15() {
            mockScanner("4k3/3p4/8/3X4/3P4/8/8/4K3");
            Main.validateFEN(scannerMock);
            assertTrue(outputStreamCaptor.toString().contains("FEN Invalid"));
        }
        @Test
        public void test16() {
            mockScanner("4k3/3p4/8/8/3P4/8/8/4K2Z");
            Main.validateFEN(scannerMock);
            assertTrue(outputStreamCaptor.toString().contains("FEN Invalid"));
        }
        @Test
        public void test17() {
            mockScanner("4k3/3p4/8/8/3P4/8/8/2K4");
            Main.validateFEN(scannerMock);
            assertTrue(outputStreamCaptor.toString().contains("FEN Invalid"));
        }
        @Test
        public void test18() {
            mockScanner("4k3/3p5/8/8/3P4/8/8/4K3");
            Main.validateFEN(scannerMock);
            assertTrue(outputStreamCaptor.toString().contains("FEN Invalid"));
        } @Test
        public void test19() {
            mockScanner("4k3/3p4/8/8/3P4/8/8/3K3");
            Main.validateFEN(scannerMock);
            assertTrue(outputStreamCaptor.toString().contains("FEN Invalid"));
        } @Test
        public void test20() {
            mockScanner("4k3/8/3K4/3P4/8/8/8/8");
            Main.validateFEN(scannerMock);
            assertTrue(outputStreamCaptor.toString().contains("Pozitie Corecta"));
        } @Test
        public void test21() {
            mockScanner("4k3/4K3/8/3P4/8/8/8/8");
            Main.validateFEN(scannerMock);
            assertTrue(outputStreamCaptor.toString().contains("Pozitie Incorecta"));
        }
        @Test
        public void test22() {
            mockScanner("8/R2bk3/p1r2pp1/1p5p/3BK1PP/P1P2P2/1P3K2/8");
            Main.validateFEN(scannerMock);
            assertTrue(outputStreamCaptor.toString().contains("Pozitie Incorecta"));
        }
        @Test
        public void test23() {
            mockScanner("4k3/2k5/4K3/3P4/8/8/8/8");
            Main.validateFEN(scannerMock);
            assertTrue(outputStreamCaptor.toString().contains("Pozitie Incorecta"));
        }
        @Test
        public void test24() {
            mockScanner("4k3/1p1qbpnp/p5p1/2QP4/4PR2/5P2/6PP/8");
            Main.validateFEN(scannerMock);
            assertTrue(outputStreamCaptor.toString().contains("Pozitie Incorecta"));
        }
        @Test
        public void test25() {
            mockScanner("8/pp2b1n1/p7/8/5R2/6P1/5P2/6K1");
            Main.validateFEN(scannerMock);
            assertTrue(outputStreamCaptor.toString().contains("Pozitie Incorecta"));
        }
        @Test
        public void test26() {
            mockScanner("rnbqkbnr/pppppppp/8/8/8/8/PPPP1PPP/RNBQKBNR");
            Main.validateFEN(scannerMock);
            assertTrue(outputStreamCaptor.toString().contains("Pozitie Corecta"));
        }
        @Test
        public void test27() {
            mockScanner("rnbqkbnr/pppppppp/8/8/4P3/8/PPPPPPPP/RNBQKBNR");
            Main.validateFEN(scannerMock);
            assertTrue(outputStreamCaptor.toString().contains("Pozitie Incorecta"));
        }
        @Test
        public void test28() {
            mockScanner("8/8/8/5k2/8/2K5/8/6P1");
            Main.validateFEN(scannerMock);
            assertTrue(outputStreamCaptor.toString().contains("Pozitie Incorecta"));
        }
        @Test
        public void test29() {
            mockScanner("5p2/8/8/5k2/8/2K5/8/8");
            Main.validateFEN(scannerMock);
            assertTrue(outputStreamCaptor.toString().contains("Pozitie Incorecta"));
        }
    }

    @Nested
    class MCDCTesting{
        @Test
        public void test30() {
            mockScanner("2b3k1/6bp/2n1p1p1/2p5/2N1N3/P2r1P2/5BPP/5RK1");
            Main.validateFEN(scannerMock);
            assertTrue(outputStreamCaptor.toString().contains("Pozitie Corecta"));
        }
        @Test
        public void test31() {
            mockScanner("2b3k1/6bp/2n1p1p1/2p5/2N1N3/P2r1P2/4KBPP/5RK1");
            Main.validateFEN(scannerMock);
            assertTrue(outputStreamCaptor.toString().contains("Pozitie Incorecta"));
        }
        @Test
        public void test32() {
            mockScanner("8/8/3p2B1/3Pk3/2P2pk1/3K3n/5k2/8");
            Main.validateFEN(scannerMock);
            assertTrue(outputStreamCaptor.toString().contains("Pozitie Incorecta"));
        }
        @Test
        public void test33() {
            mockScanner("rnbqkbnr/pppppppp/8/8/8/3P4/PPPPPPPP/RNBQKBNR");
            Main.validateFEN(scannerMock);
            assertTrue(outputStreamCaptor.toString().contains("Pozitie Incorecta"));
        }
        @Test
        public void test34() {
            mockScanner("rnbqkbnr/pppppppp/4p3/3p4/3ppp2/8/PPPPPPPP/RNBQKBNR");
            Main.validateFEN(scannerMock);
            assertTrue(outputStreamCaptor.toString().contains("Pozitie Incorecta"));
        }
        @Test
        public void test35() {
            mockScanner("4qrk1/pbbp1pbp/1pp1nprn/3Np3/1N1P1RQ1/PNP1PPPP/1PBQN1R1/2B2K2");
            Main.validateFEN(scannerMock);
            assertTrue(outputStreamCaptor.toString().contains("Pozitie Incorecta"));
        }
    }

    @Nested
    class causeEffectTests{
        @Test
        public void test36() {
            mockScanner("9/8/8/8/8/8/8");
            Main.validateFEN(scannerMock);
            assertTrue(outputStreamCaptor.toString().contains("FEN Invalid"));
        }
        @Test
        public void test37() {
            mockScanner("8/8/4p3/1R2Pk2/5Nk1/2K5/8/8");
            Main.validateFEN(scannerMock);
            assertTrue(outputStreamCaptor.toString().contains("Pozitie Incorecta"));
        }
        @Test
        public void test38() {
            mockScanner("8/8/4p3/1R2Pk2/5N2/2K5/8/8");
            Main.validateFEN(scannerMock);
            assertTrue(outputStreamCaptor.toString().contains("Pozitie Corecta"));
        }
    }


    private void mockScanner(String fenPosition){
        Mockito.when(scannerMock.nextLine()).thenReturn(fenPosition);
    }
}
