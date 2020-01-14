package fr.epita.datamodel;

public class MCQQuestion {

    private Long id;
    private String question;
    private String[] topics;
    private Integer difficulty;

    public MCQQuestion() {
    }

    public MCQQuestion(Long id, String question, String[] topics, Integer difficulty) {
        this.id = id;
        this.question = question;
        this.topics = topics;
        this.difficulty = difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getTopics() {
        return topics;
    }

    public void setTopics(String[] topics) {
        this.topics = topics;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
