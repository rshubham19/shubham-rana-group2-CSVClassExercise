package Test;

import DAO.MCQQuestionCSVDAO;
import fr.epita.datamodel.MCQQuestion;

import java.util.List;
import java.util.Scanner;
public class TestMCQQuestionDAO {

    public static void main(String[] args) {

        MCQQuestionCSVDAO dao = new MCQQuestionCSVDAO();

        MCQQuestion mcqQuestion = new MCQQuestion();
        System.out.println("Enter the Question: ");
        Scanner input = new Scanner(System.in);
        mcqQuestion.setQuestion(input.nextLine());

        System.out.println("Now enter the difficulty level (1 or 2 or 3):");
        mcqQuestion.setDifficulty(input.nextInt());

        System.out.println("Enter the topics (seperated by ,)");
        String topics[]= input.next().split(",");
        mcqQuestion.setTopics(topics);

        mcqQuestion.setId(1l);

        dao.create(mcqQuestion);

        List<MCQQuestion> allQuestions = dao.readAll();
        for (int i = 0; i < allQuestions.size(); i++) {
            System.out.println(allQuestions.get(i).getQuestion());

        }
    }

}

