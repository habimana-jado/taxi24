package rw.bk.codingchallenge.taxi24.enums;

public enum EDriverStatus {
    AVAILABLE("Available"),
    TAKEN("Taken"),
    IN_REPAIR("InRepair");

    private String description;

    EDriverStatus(String description) {
        this.description = description;
    }
}
