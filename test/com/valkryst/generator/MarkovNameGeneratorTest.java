package com.valkryst.generator;

import com.valkryst.TestHelper;
import com.valkryst.builder.MarkovBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntUnaryOperator;

public class MarkovNameGeneratorTest {
    @Test
    public void generateName() {
        try {
            final IntUnaryOperator randomInRange = ThreadLocalRandom.current()::nextInt;

            final MarkovBuilder builder = new MarkovBuilder();
            builder.setTrainingNames(TestHelper.resource("Human/Viking/Male.txt"));

            final MarkovNameGenerator nameGenerator = builder.build();

            for(int i = 0 ; i < 50 ; i++) {
                System.out.println(nameGenerator.generateName(randomInRange, 7));
            }

            for(int i = 0 ; i < 10000 ; i++) {
                nameGenerator.generateName(randomInRange, i % 50);
            }
        } catch(final IOException e) {
            e.printStackTrace();
        }
    }
}
