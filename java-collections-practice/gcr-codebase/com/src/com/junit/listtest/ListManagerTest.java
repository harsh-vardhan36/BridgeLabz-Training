package com.junit.listtest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ListManagerTest {

    ListManager manager;
    List<Integer> list;

    @BeforeEach
    void setup() {
        manager = new ListManager();
        list = new ArrayList<>();
    }

    @Test
    void testAddElement() {
        manager.addElement(list, 10);
        assertTrue(list.contains(10));
    }

    @Test
    void testRemoveElement() {
        list.add(10);
        list.add(20);

        manager.removeElement(list, 10);

        assertFalse(list.contains(10));
        assertEquals(1, list.size());
    }

    @Test
    void testGetSize() {
        manager.addElement(list, 5);
        manager.addElement(list, 15);

        assertEquals(2, manager.getSize(list));
    }
}
