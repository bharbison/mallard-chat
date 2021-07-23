public enum Emoji {
    GRIN("\uD83D\uDE00"),
    SMILE("\u263A"),
    FROWN("\u2639"),
    CRY("\uD83D\uDE22");

    private String code;

    private Emoji(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}