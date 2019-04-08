package quizlet;
public class FlashCard {
    private String question;
    private String answer;

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    
    @Override
    public String toString() {
        return question;
    }
    

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public FlashCard() {
        this.question = "";
        this.answer = "";
    }
    
    
}
