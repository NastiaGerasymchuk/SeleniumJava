package trackster.models;

import trackster.enums.Language;

public class HomePageTestData {
    private Language language;//enum
    private String parcelHeader;
    private String number;
    private String fastTracking;
    private String intuitiveInterface;
    private String archiveParsels;
    private String ourPartners;

    public HomePageTestData(Language language, String parcelHeader, String number, String fastTracking, String intuitiveInterface, String archiveParsels, String ourPartners){

        this.language =language;
        this.parcelHeader =parcelHeader;
        this.number =number;
        this.fastTracking =fastTracking;
        this.intuitiveInterface =intuitiveInterface;
        this.archiveParsels =archiveParsels;
        this.ourPartners =ourPartners;

    }
    public Language getLanguage() {
        return language;
    }

    public String getParcelHeader() {
        return parcelHeader;
    }

    public String getFastTracking() {
        return fastTracking;
    }

    public String getIntuitiveInterface() {
        return intuitiveInterface;
    }

    public String getArchiveParsels() {
        return archiveParsels;
    }

    public String getOurPartners() {
        return ourPartners;
    }

    public String getNumber() {
        return number;
    }
}
