[![Build Status](https://travis-ci.com/mtumilowicz/java9-objects-new-methods.svg?branch=master)](https://travis-ci.com/mtumilowicz/java9-objects-new-methods)

# java9-objects-new-methods
Java9: Overview of new methods in the `Objects` class.

# preface
In Java 9, Objects class was extended with new static methods:
* `T requireNonNullElse(T obj, T defaultObj)` - 
    * Returns the first argument if it is non-null and
    * otherwise returns the non-null second argument,
    * otherwise NPE.
    ```
    public static <T> T requireNonNullElse(T obj, T defaultObj) {
        return (obj != null) ? obj : requireNonNull(defaultObj, "defaultObj");
    }
    ```
* `T requireNonNullElseGet(T obj, Supplier<? extends T> supplier)` - 
    * Returns the first argument if it is non-null
    * otherwise returns the non-null value of `supplier.get()`,
    * otherwise NPE.
    ```
    public static <T> T requireNonNullElseGet(T obj, Supplier<? extends T> supplier) {
        return (obj != null) ? obj
                : requireNonNull(requireNonNull(supplier, "supplier").get(), "supplier.get()");
    }
    ```
* `int checkIndex(int index, int length)` - 
Checks if `index e [0; length)`.
    * returns index if it is within bounds of the range
* `int checkFromToIndex(int fromIndex, int toIndex, int length)` - 
Checks if `[fromIndex; toIndex) c [0; length)`.
    * returns fromIndex if the sub-range within bounds of 
    the range
* `int checkFromIndexSize(int fromIndex, int size, int length)` - 
Checks if `[fromIndex; fromIndex + size) c [0; length)`.
    * returns fromIndex if the sub-range within bounds of the range

# project description
We provide basics tests of above mentioned methods. Below
we list the most interesting cases
* `checkIndex`
    * `checkIndex(0, 0)`
        ```
        @Test(expected = IndexOutOfBoundsException.class)
        public void checkIndex_index0_length0() {
            Objects.checkIndex(0, 0);
        }
        ```
    * `checkIndex(3, 6)`
        ```
        assertThat(Objects.checkIndex(3, 6), is(3));
        ```
* `checkFromToIndex`
    ```
    assertThat(Objects.checkFromToIndex(0, 3, 3), is(0));
    ```
* `checkFromIndexSize`
    ```
    @Test(expected = IndexOutOfBoundsException.class)
    public void checkFromIndexSize_size_lessThan0() {
        Objects.checkFromIndexSize(5, -3, 10);
    }
    ```