import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatriculaTest {

    @ParameterizedTest
    @CsvSource({
            "80, 8.5, 9.5, 5.6, APR"
    })
    public void test1(int freq, double not1, double not2, double not3, String status){
        Turma t1 = new Turma()
        assertEquals(1, );
    }
}
