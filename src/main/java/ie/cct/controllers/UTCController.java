package ie.cct.controllers;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.TimeZone;
import java.sql.Date;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UTCController {

    @GetMapping("/timestamp/{timestamp}")
    public AgglomeratedData Agglomerate(@PathVariable("timestamp") Long timestamp) {

        String UTCDate = getUTC(timestamp).getDate();
        String ISODate = getISO(timestamp).getDate();
        return new AgglomeratedData(UTCDate, ISODate);
    }

    @GetMapping("/{timestamp}/utcdate")
    public static FormattedData getUTC(@PathVariable("timestamp") Long timestamp) {

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        String result = format.format(new Date(timestamp * 1000));
        return new FormattedData(result);
    }

    @GetMapping("/{timestamp}/isodate")
    public static FormattedData getISO(@PathVariable("timestamp") Long timestamp) {

        ZonedDateTime zdt = ZonedDateTime.ofInstant(Instant.ofEpochMilli(timestamp * 1000), ZoneId.systemDefault());
        String result = zdt.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        return new FormattedData(result);
        
    }

}