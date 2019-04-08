/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizlet;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

import java.util.*;

public class Quizlet extends JFrame implements ActionListener {
    JMenuBar mainBar = new JMenuBar();
    JMenu help = new JMenu("Help");
    JMenuItem about = new JMenuItem("About");
    JMenu file = new JMenu("File");
    JMenuItem exit = new JMenu("Exit");

    JButton response;
    JLabel answerDisplay;
    public static ArrayList<FlashCard> QuestionsList;
    static String[] questions;
    static String[] answers;
    ArrayList<Boolean> bool;
    JPanel card, FlashCardGame;
    int count = 0;
    boolean flag = false;
    int index = 0;
    String welcome = "Welcome";
    String start = "Start";
    String nextQuestion = "Next Question";
    String answer = "Answer";
    public Quizlet() {
        help.add(about);
        file.add(exit);
        about.addActionListener(this);
        exit.addActionListener(this);
        mainBar.add(file);
        mainBar.add(help);
        setJMenuBar(mainBar);
        FlashCardGame = new JPanel(new BorderLayout());
        FlashCardGame.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK),
                BorderFactory.createRaisedSoftBevelBorder()));
        QuestionsList = new ArrayList<FlashCard>();
        bool = new ArrayList<Boolean>();
        card = new JPanel(new BorderLayout());
        response = new JButton(start);
        response.setFont(new Font("Courier New", Font.BOLD, 20));
        answerDisplay = new JLabel(welcome, SwingConstants.CENTER);
        answerDisplay.setFont(new Font("Courier New", Font.BOLD + Font.ITALIC, 16));
        card.add(answerDisplay, BorderLayout.CENTER);
        card.add(response, BorderLayout.SOUTH);
        FlashCardGame.add(card, BorderLayout.CENTER);
        add(FlashCardGame);
        response.addActionListener(this);
        readData();
         System.out.println(QuestionsList.get(0).toString());

    }

    

    public void readData() {
        int count = 0;
        File file = null;
        Scanner input = null;
        String question, answer;
        FlashCard obj = null;
       try {
            file = new File("C:\\Users\\ja23\\Documents\\FlashQuestions.txt");
            input = new Scanner(file);
            while (input.hasNextLine()) {
                question = input.nextLine();
                answer = input.nextLine();
                obj = new FlashCard();
                obj.setQuestion(question);
                obj.setAnswer(answer);
                QuestionsList.add(obj);
                bool.add(false);
                count++;
            }
            input.close();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
    public static void main(String args[]) {
        Quizlet game = new Quizlet();
        game.setTitle("Flash Card Game");
        game.setSize(1000, 500);
        game.setResizable(false);
        game.setVisible(true);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Grid Grid1 = new Grid();
        System.out.println(Grid1.getText());
    }

    @Override
    public void actionPerformed(ActionEvent event) {
         
          if(event.getSource()==exit){
                    System.exit(0);
                }else if(event.getSource()==about){
                    JOptionPane.showMessageDialog(null,"Name: Quizlet \\ Date Created: 4-8-19 \\ Version: 1.0");
                }
        if (event.getSource() == response) {
            if (count < QuestionsList.size()) {
                if (!flag) {
                    index = getIndex();
                    response.setText(answer);
                    bool.set(index, true);
                    answerDisplay
                           .setText(QuestionsList.get(index).getQuestion());
                } else {
                    response.setText(nextQuestion);
                    answerDisplay.setText(QuestionsList.get(index).getAnswer());
                    count++;
                }
                flag = !flag;
            } else {
                int repeat = JOptionPane
                        .showConfirmDialog(
                                null,
                                "Would you like to go through the questions again? ",
                                "Confirmation",
                                JOptionPane.YES_NO_OPTION);
                if (repeat == JOptionPane.YES_OPTION) {
                    response.setText(start);
                    answerDisplay.setText(welcome);
                    count = 0;
                    QuestionsList = new ArrayList<FlashCard>();
                    bool = new ArrayList<Boolean>();
                    readData();
                    flag = false;
                } else {
                    answerDisplay.setText("Thanks for studying with us!");
                    response.setEnabled(false);
                }
            }
        }
    }
    public int getIndex() {
        int random = 0;
        boolean f = false;
        while (!f) {
            random = (int) (Math.random() * bool.size());
            if (bool.get(random) == false) {
               f = true;
               return random;
            }
        }
        return -1;
    }
}