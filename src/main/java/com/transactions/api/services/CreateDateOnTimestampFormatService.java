package com.transactions.api.services;

import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CreateDateOnTimestampFormatService {
    public long getDate(int ano, int mes) {
        System.out.println(ano);
        LocalDateTime firstMonth = LocalDateTime.of(ano, mes, 1, 0, 0);

        LocalDateTime finalMonth = firstMonth.plusMonths(1);
        long startMilli = firstMonth.toInstant(ZoneOffset.UTC).toEpochMilli();
        long endMilli = finalMonth.toInstant(ZoneOffset.UTC).toEpochMilli();
        long random = ThreadLocalRandom
                .current()
                .nextLong(startMilli, endMilli);
        System.out.println(Date.from(Instant.ofEpochMilli(random)));
        return random;
    }
}
