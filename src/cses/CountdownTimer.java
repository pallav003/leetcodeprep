package cses;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CountdownTimer {
    private static int totalSeconds;

    public static void main(String[] args) {
        try {
            String timeValue = "05:03:00";
            totalSeconds = parseTimeToSeconds(timeValue);

            if (totalSeconds <= 0) {
                System.out.println("Invalid or zero time provided.");
                return;
            }

            startCountdown();
        } catch (Exception e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    private static int parseTimeToSeconds(String time) {
        String[] parts = time.split(":");
        int hours = 0, minutes = 0, seconds = 0;

        try {
            if (parts.length == 3) {  // H:M:S format
                hours = Integer.parseInt(parts[0]);
                minutes = Integer.parseInt(parts[1]);
                seconds = Integer.parseInt(parts[2]);
            } else if (parts.length == 2) {  // M:S format
                minutes = Integer.parseInt(parts[0]);
                seconds = Integer.parseInt(parts[1]);
            } else if (parts.length == 1) {  // S format
                seconds = Integer.parseInt(parts[0]);
            }
        } catch (NumberFormatException e) {
            System.err.println("Invalid time format: " + time);
            return 0;
        }

        return hours * 3600 + minutes * 60 + seconds;
    }

    private static void startCountdown() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        Runnable task = () -> {
            if (totalSeconds <= 0) {
                System.out.println("00:00:00");
                scheduler.shutdown();
                return;
            }

            int hours = totalSeconds / 3600;
            int minutes = (totalSeconds % 3600) / 60;
            int seconds = totalSeconds % 60;

            System.out.printf("\r%02d:%02d:%02d", hours, minutes, seconds);
            totalSeconds--;
        };

        scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);
    }
}

