public class Article {
    private final String date, text;

    public Article(String date, String text) {
        this.date = date;
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Article{" +
                "date='" + date + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
