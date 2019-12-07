package function;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FunctionDiapasonTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = new FunctionDiapason().diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        List<Double> result = new FunctionDiapason().diapason(5, 8, x -> Math.pow(x, 2)) ;
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogarithmicFunctionThenLogarithmicResults() {
        List<Double> result = new FunctionDiapason().diapason(5, 8, StrictMath::log) ;
        List<Double> expected = Arrays.asList(1.6094379124341003, 1.791759469228055, 1.9459101490553132);
        assertThat(result, is(expected));
    }


}
