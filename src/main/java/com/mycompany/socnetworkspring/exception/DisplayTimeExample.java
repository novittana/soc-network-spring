package com.mycompany.socnetworkspring.exception;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DisplayTimeExample {
    public static void main(String[] args) {
        Instant nowInUtc = Instant.now();
        ZonedDateTime localTime = nowInUtc.atZone(ZoneId.systemDefault());
        System.out.println("Local Time: " + localTime);
    }
}