package ie.cct.controllers;

public class AgglomeratedData {
    private String ISODate;
    private String UTCDate;

    public AgglomeratedData(String UTCDate, String ISODate) {
        this.ISODate = ISODate;
        this.UTCDate = UTCDate;
    }

    public String getISODate() {
        return this.ISODate;
    }

    public String getUTCDate() {
        return this.UTCDate;
    }
}