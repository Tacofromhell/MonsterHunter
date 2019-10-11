package com.company.tests.factories;

import com.company.game.cards.MonsterCard;
import com.company.game.factories.MonsterCardFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MonsterCardFactoryTest {

    MonsterCardFactory monsterCardFactory = new MonsterCardFactory();
    int id = 0;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void addId() {
        id++;
    }

    @Test
    void buildCard() {
//        MonsterCard m = new MonsterCardFactory().buildCard(id);
//        assertNotNull(m);
    }

    @Test
    void testBuildCard() {
    }

    @Test
    void getRandomValue() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
//        monsterCardFactory.getClass().getDeclaredMethod("getRandomValue", 1, 3);
        Method method = monsterCardFactory.getClass().getDeclaredMethod("getRandomValue", int.class, int.class);
        method.setAccessible(true);

        for (int i = 0; i < 10; i++) {
            int test = (int) method.invoke(monsterCardFactory, 1, 4);
            assertTrue(test >= 1 && test <= 4);
        }

    }

    @Test
    void getRandomMonsterName() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        Field field = monsterCardFactory.getClass().getDeclaredField("monsterCardNames");
        field.setAccessible(true);
        List<String> listOfNames = (List<String>) field.get(monsterCardFactory);
        Method method = monsterCardFactory.getClass().getDeclaredMethod("getRandomMonsterName");
        method.setAccessible(true);

        for (int i = 0; i < 10; i++) {
            String test = (String) method.invoke(monsterCardFactory);
            System.out.println(test);
            assertTrue(listOfNames.contains(test));
        }


    }
}