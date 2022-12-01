package me.rachzy.simplecommands.models;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class TeleportRequest {
    Integer id;
    String playerSender;
    String playerTarget;

    LocalDateTime expireDate;

    public TeleportRequest(String pS, String pT) {
        this.id = new Random().nextInt(9999);
        this.playerSender = pS;
        this.playerTarget = pT;
        this.expireDate = LocalDateTime.now().plus(Duration.of(2, ChronoUnit.MINUTES));
    }

    public String getSenderUsername() {
        return playerSender;
    }
    public String getTargetUsername() {
        return playerTarget;
    }

    public Boolean checkIfRequestIsStillValid() {
        return LocalDateTime.now().isBefore(expireDate);
    }
}
