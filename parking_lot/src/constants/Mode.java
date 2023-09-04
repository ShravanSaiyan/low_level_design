package constants;

public enum Mode {
    FILE(0),
    INTERACTIVE_SHELL(1);

    public final int mode;

    Mode(int mode) {
        this.mode = mode;
    }
}
