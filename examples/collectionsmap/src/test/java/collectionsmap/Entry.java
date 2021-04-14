package collectionsmap;

import java.time.LocalDate;

public class Entry {

    private String ipAddress;
    private LocalDate entryDate;
    private String login;

    public Entry() {
    }

    public Entry(String ipAddress, LocalDate entryDate, String login) {
        this.ipAddress = ipAddress;
        this.entryDate = entryDate;
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "ipAddress='" + ipAddress + '\'' +
                ", entryDate='" + entryDate + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
