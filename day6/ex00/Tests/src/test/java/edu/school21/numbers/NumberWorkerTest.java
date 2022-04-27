package edu.school21.numbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class NumberWorkerTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 991, 2147483647})
    public void isPrimeForPrimes(int prime) throws Exception {
        assertTrue(new NumberWorker().isPrime(prime));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 6, 8, 10, 33, 35, 36, 38, 39, 40, 42, 322, 999})
    public void isPrimeForNotPrimes(int notPrime) throws Exception {
        assertFalse(new NumberWorker().isPrime(notPrime));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, Integer.MIN_VALUE, -12105, -1, -0, -42})
    public void isPrimeForIncorrectNumbers(int incorrectNum) throws Exception {
        assertThrows(RuntimeException.class, () -> new NumberWorker().isPrime(incorrectNum));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    public void isSumCorrect(int input, int expected) throws Exception {
        assertEquals(expected, new NumberWorker().digitsSum(input));
    }

}