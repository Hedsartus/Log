package common;

public enum LevelLog {
    INFO("INFO"),
    WRONGAUTH("AUTHENTICATION_ERROR"),
    ERROR("ERROR");


    private String level;

    LevelLog(String level) {
        this.level = level;
    }
}
