import org.junit.Test;

import java.util.Objects;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by mtumilowicz on 2018-12-05.
 */
public class ObjectsMethodsTest {
    @Test
    public void requireNonNullElse_notNullObj() {
        String a = Objects.requireNonNullElse("a", null);
        
        assertThat(a, is("a"));
    }

    @Test
    public void requireNonNullElse_nullObj_nonNullDefaultObj() {
        String b = Objects.requireNonNullElse(null, "b");

        assertThat(b, is("b"));
    }

    @Test(expected = NullPointerException.class)
    public void requireNonNullElse_nullObj_nullDefaultObj() {
        Objects.requireNonNullElse(null, null);
    }

    @Test
    public void requireNonNullElseGet_notNullObj() {
        String a = Objects.requireNonNullElseGet("a", null);

        assertThat(a, is("a"));
    }

    @Test
    public void requireNonNullElseGet_nullObj_nonNullSupplier_nonNullSupplierValue() {
        String b = Objects.requireNonNullElseGet(null, () -> "b");

        assertThat(b, is("b"));
    }

    @Test(expected = NullPointerException.class)
    public void requireNonNullElseGet_nullObj_nonNullSupplier_nullSupplierValue() {
        Objects.requireNonNullElseGet(null, () -> null);
    }

    @Test(expected = NullPointerException.class)
    public void requireNonNullElseGet_nullObj_nullSupplier() {
        Objects.requireNonNullElseGet(null, null);
    }
}
