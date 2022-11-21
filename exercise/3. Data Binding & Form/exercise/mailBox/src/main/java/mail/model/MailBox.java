package mail.model;

public class MailBox {
    private String languages;
    private int page;
    private boolean spams;
    private String signature;

    public MailBox() {
    }

    public MailBox(String languages, int page, boolean spams, String signature) {
        this.languages = languages;
        this.page = page;
        this.spams = spams;
        this.signature = signature;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public boolean isSpams() {
        return spams;
    }

    public void setSpams(boolean spams) {
        this.spams = spams;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "MailBox{" +
                "languages='" + languages + '\'' +
                ", page=" + page +
                ", spams=" + spams +
                ", signature='" + signature + '\'' +
                '}';
    }
}
