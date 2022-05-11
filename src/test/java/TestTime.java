import org.junit.Test;

import java.time.*;
import java.util.Date;

public class TestTime {
    @Test
    public void Time() {
        System.out.println("timestamp / date");

        Instant i = Instant.now();
        System.out.printf("Instant : %d / %s%n", i.getEpochSecond(), i.toString());

        /**
         * 객체멤버 : long timeMillis
         * timezone : 없음
         * 참고사항 : toString 은 systemDefaultZone 사용하여 출력됨
         */
        Date d = new Date(); // millis
        System.out.printf("Date : %d / %s%n", d.getTime(), d.toString());

        /**
         * 객체멤버 : long epochDay (since 1970.1.1, systemDefaultZone 기준) → year, month, day 로 변환하여 저장
         * timezone : systemDefaultZone
         */
        LocalDate ld = LocalDate.now(); // year, month, day
        System.out.printf("LocalDate : %d / %s%n", ld.toEpochDay(), ld.toString());

        /**
         * 객체멤버 : long nanoOfDay (since today 00:00, systemDefaultZone 기준) → hours, minutes, seconds, nanoOfSecond 로 변환하여 저장
         * timezone : systemDefaultZone
         */
        LocalTime lt = LocalTime.now();  // hours, minutes, seconds, nanoOfSecond
        System.out.printf("LocalTime : %d / %s%n", lt.toNanoOfDay(), lt.toString());

        /**
         * long epochSecond, int nanoOfSecond, ZoneOffset offset → LocalDate, LocalTime 으로 변환하여 저장
         * timezone : systemDefaultZone
         * 참고사항 : toEpochSecond(systemDefaultZone) 은 UTC 기준의 timestamp 를 보여줌
         */
        LocalDateTime ldt = LocalDateTime.now();
        System.out.printf("LocalDateTime : %d / %s%n", ldt.toEpochSecond(ZoneOffset.ofHours(9)), ldt.toString());
    }
}
