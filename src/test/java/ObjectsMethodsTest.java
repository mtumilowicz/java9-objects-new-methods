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
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void checkIndex_index_lessThan0_length10() {
        Objects.checkIndex(-1, 10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void checkIndex_index0_length0() {
        Objects.checkIndex(0, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void checkIndex_index0_lengthMinus1() {
        Objects.checkIndex(0, -1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void checkIndex_index1_length1() {
        Objects.checkIndex(1, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void checkIndex_index2_length1() {
        Objects.checkIndex(2, 1);
    }

    @Test
    public void checkIndex_index3_length6() {
        assertThat(Objects.checkIndex(3, 6), is(3));
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void checkFromToIndex_fromIndex_lessThan0() {
        Objects.checkFromToIndex(-1, 6, 10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void checkFromToIndex_toIndex_lessThan0() {
        Objects.checkFromToIndex(1, -3, 10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void checkFromToIndex_length_lessThan0() {
        Objects.checkFromToIndex(1, 3, -1);
    }

    @Test
    public void checkFromToIndex_equalTo() {
        assertThat(Objects.checkFromToIndex(0, 3, 3), is(0));
    }

    @Test
    public void checkFromToIndex_subset() {
        assertThat(Objects.checkFromToIndex(1, 2, 3), is(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void checkFromToIndex_bigger() {
        Objects.checkFromToIndex(1, 10, 3);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void checkFromIndexSize_size_lessThan0() {
        Objects.checkFromIndexSize(5, -3, 10);
    }
}
