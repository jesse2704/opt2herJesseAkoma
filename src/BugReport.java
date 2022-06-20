package src;

public class BugReport {
    private String message;
    private String gebruikerType;

    public BugReport(String message, String gebruikerType) {
        this.message = message;
        this.gebruikerType = gebruikerType;
    }

    public String getGebruikerType() {
        return gebruikerType;
    }

    public String getMessage() {
        return message;
    }
}
