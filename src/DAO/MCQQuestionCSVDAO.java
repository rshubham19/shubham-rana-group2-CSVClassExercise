package DAO;

import fr.epita.datamodel.MCQQuestion;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MCQQuestionCSVDAO {

    private static final String TOPIC_DELIMITER = "|||";
    private static final String COLUMN_DELIMITER = "@@@";

    public void create(MCQQuestion mcqQuestion){
        //format data to csv
        //ID@@@DIFFICULTY@@@QUESTION_CONTENT|||TOPICS

        String formatted = String.valueOf(mcqQuestion.getId() + COLUMN_DELIMITER);
        formatted += String.valueOf(mcqQuestion.getDifficulty() + COLUMN_DELIMITER);
        formatted += mcqQuestion.getQuestion() + COLUMN_DELIMITER;
        String topics[] = mcqQuestion.getTopics();

        for(int i = 0; i < topics.length ; i++) {
            formatted += topics[i] + TOPIC_DELIMITER;
        }
        System.out.println(formatted);
        File file = new File("MCQQuestions.txt");
            // print in the file
        PrintWriter writer;
        try {
            FileOutputStream out = new FileOutputStream(file, true);
            writer = new PrintWriter(out);
            writer.println(formatted);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("An Error Occured!");
            e.printStackTrace();
        }

    }

    public List<MCQQuestion> readAll() {

        List<MCQQuestion> results = new ArrayList<>();
        // TODO read all the "line" values from the file

        File loadedFile = new File("MCQQuestions.txt");

        try {
            System.out.println("Reading...");

            Scanner read = new Scanner(loadedFile);;
            while (read.hasNextLine()) {
                String line = read.nextLine();
                String[] parts = line.split(COLUMN_DELIMITER);

                System.out.println(Arrays.asList(parts));

                Long id = Long.valueOf(parts[0]);
                Integer difficulty = Integer.valueOf(parts[1]);
                String question = parts[2];
                String[] readTopics = parts[3].split(TOPIC_DELIMITER);

                MCQQuestion reconstructed = new MCQQuestion(id, question, readTopics, difficulty);
                results.add(reconstructed);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return results;
    }
}
