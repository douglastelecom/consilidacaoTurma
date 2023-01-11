import academico.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatriculaTest {

    @ParameterizedTest
    @CsvSource({
            "80, 8.5, 9.5, 5.6, APR",
            "90,8.5, 6, 5, APRN",
            "90, 5, 3, 5, REC",
            "90, 2, 2, 2, REP",
            "60, 8, 9, 10, REPF",
            "70, 4, 1, 5, REMF"
    })
    public void test1(int freq, double not1, double not2, double not3, StatusAprovacao status){
        Disciplina calc1 = new Disciplina();
        Docente marcelo = new Docente();
        Turma t1 = new Turma(calc1, marcelo,1);
        Discente doug = new Discente();
        t1.matricular(doug);
        t1.registrarFrequencia(doug, BigDecimal.valueOf(freq));
        t1.registrarPrimeiraNota(doug, BigDecimal.valueOf(not1));
        t1.registrarSegundaNota(doug, BigDecimal.valueOf(not2));
        t1.registrarTerceiraNota(doug, BigDecimal.valueOf(not3));
        t1.consolidarParcialmente();
        StatusAprovacao statusfinal = t1.matriculas().stream().collect(Collectors.toList()).get(0).statusParcial();
        assertEquals(status,statusfinal);
    }
}
