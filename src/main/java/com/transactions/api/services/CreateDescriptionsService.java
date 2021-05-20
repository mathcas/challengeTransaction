package com.transactions.api.services;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CreateDescriptionsService {
    private static final int MAX_SIZE_DESCRIPTION = 60;
    private static final int MIN_SIZE_DESCRIPTION = 10;
    private char[] consonants = "bcdfghjklmnpqrstvwxyz".toCharArray();
    private char[] vowels = "aeiou".toCharArray();
    private int consonantsSize = consonants.length;
    private int vowelsSize = vowels.length;

    public String getDescription() {
        int size = getSizeOfDescription();
        StringBuilder builder = new StringBuilder();
        String word = createAWord();
        do {
            builder.append(word);
            builder.append(" ");
            word = createAWord();
        } while (builder.length() < size);
        return builder.toString();
    }

    private String createAWord() {
        StringBuilder builder = new StringBuilder();

        Random rand = new Random();
        int number = rand.nextInt(15);
        while (builder.length() < number) {
            builder.append((consonants[rand.nextInt(consonantsSize)]));
            builder.append((vowels[rand.nextInt(vowelsSize)]));
        }
        return builder.toString();
    }

    private int getSizeOfDescription() {
        Random rand = new Random();
        return rand.nextInt(MAX_SIZE_DESCRIPTION - MIN_SIZE_DESCRIPTION) + MIN_SIZE_DESCRIPTION;

    }
}
