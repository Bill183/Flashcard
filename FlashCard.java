package quizlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class FlashCard {
    private String question;
    private String answer;

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
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