package com.valkryst.generator;

import com.valkryst.TestHelper;
import com.valkryst.builder.CombinatorialBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntUnaryOperator;

public class CombinatorialNameGeneratorTest {
    @Test
    public void generateNameUsingRandom() {
        final Random random = new Random(System.currentTimeMillis());

        // Setup the Builder:
        final CombinatorialBuilder builder = new CombinatorialBuilder();

        try {
            builder.setBeginnings(TestHelper.resource("Dwarven/Fantasy/Dwarven_Khordaldrum_Fantasy_Last_A.txt"));
            builder.setEndings(TestHelper.resource("Dwarven/Fantasy/Dwarven_Khordaldrum_Fantasy_Last_B.txt"));
        } catch (final IOException e) {
            e.printStackTrace();
        }

        // Setup & Test the Generator:
        final CombinatorialNameGenerator generator = builder.build(false);

        for (int i = 0 ; i < 100 ; i++) {
            generator.generateName(random, i % 20, 0);
        }
    }

    @Test
    public void generateNameUsingIntUnaryOperator() {
        final IntUnaryOperator randomInRange = ThreadLocalRandom.current()::nextInt;

        // Setup the Builder:
        final CombinatorialBuilder builder = new CombinatorialBuilder();

        try {
            builder.setBeginnings(TestHelper.resource("Dwarven/Fantasy/Dwarven_Khordaldrum_Fantasy_Last_A.txt"));
            builder.setEndings(TestHelper.resource("Dwarven/Fantasy/Dwarven_Khordaldrum_Fantasy_Last_B.txt"));
        } catch (final IOException e) {
            e.printStackTrace();
        }

        // Setup & Test the Generator:
        final CombinatorialNameGenerator generator = builder.build(false);

        for (int i = 0 ; i < 100 ; i++) {
            generator.generateName(randomInRange, i % 20, 0);
        }
    }

    @Test
    public void longGeneration() {
        final IntUnaryOperator randomInRange = ThreadLocalRandom.current()::nextInt;

        // Setup the Builder:
        final CombinatorialBuilder builder = new CombinatorialBuilder();

        try {
            builder.setBeginnings(TestHelper.resource("Dwarven/Fantasy/Dwarven_Khordaldrum_Fantasy_Last_A.txt"));
            builder.setEndings(TestHelper.resource("Dwarven/Fantasy/Dwarven_Khordaldrum_Fantasy_Last_B.txt"));
        } catch (final IOException e) {
            e.printStackTrace();
        }

        // Setup & Test the Generator:
        final CombinatorialNameGenerator generator = builder.build(false);

        for (int i = 0 ; i < 100 ; i++) {
            System.out.println(generator.generateName(randomInRange, i, 0));
        }

        for (int i = 0 ; i < 1_000_000 ; i++) {
            generator.generateName(randomInRange, i % 20, 0);
        }
    }
}
