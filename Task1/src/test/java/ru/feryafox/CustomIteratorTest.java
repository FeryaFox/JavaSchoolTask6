package ru.feryafox;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class CustomIteratorTest {
    @Test
    public void testCustomIterator() {
        Person[] people = new Person[] {
                new Person("Миша", 25),
                new Person("Коля", 30),
                new Person("Дима", 35)
        };

        CustomIterator<Person> iterator = new CustomIterator<>(people);

        assertTrue(iterator.hasNext());
        assertEquals("Миша", iterator.next().getName());

        assertTrue(iterator.hasNext());
        assertEquals("Коля", iterator.next().getName());

        assertTrue(iterator.hasNext());
        assertEquals("Дима", iterator.next().getName());

        assertFalse(iterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void testNoSuchElementException() {
        Person[] people = new Person[0];
        CustomIterator<Person> iterator = new CustomIterator<>(people);
        iterator.next();
    }
}

