package rw.bk.codingchallenge.taxi24.enums;

public enum ETripStatus {
    ACTIVE("Active"),
    COMPLETED("Completed");

    private String description;

    ETripStatus(String description) {
        this.description = description;
    }
}
