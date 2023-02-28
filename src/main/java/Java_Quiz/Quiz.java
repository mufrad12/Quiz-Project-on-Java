package Java_Quiz;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) throws IOException, ParseException {
        System.out.println("Welcome to the SQA Quiz \n" +
                "1. Add Quiz\n" +
                "2. Start Quiz");
        Scanner input= new Scanner(System.in);
        System.out.print("Enter your option: ");
        int opt= input.nextInt();
        if(opt==1){
            addQuiz();

        } else if (opt==2) {
            startQuiz();
        }
        else {
            System.out.println("Wrong input!");
        }
    }
    private static void addQuiz() throws IOException, ParseException {
        String fileN = "./src/main/resources/QuizBank.json";
        char ch = 'c';
        while (ch != 'n') {

            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader(fileN));
            JSONObject quizObj = new JSONObject();
            Scanner sc = new Scanner(System.in);

            System.out.println("Please add your question here:");
            quizObj.put("Question", sc.nextLine());//Question
            System.out.println();

            System.out.println("Input options: ");

            System.out.println("option a");//option A
            quizObj.put("Option a", sc.nextLine());

            System.out.println("option b");//option B
            quizObj.put("Option b", sc.nextLine());

            System.out.println("option c");//option C
            quizObj.put("Option c", sc.nextLine());

            System.out.println("option d");//option D
            quizObj.put("Option d", sc.nextLine());

            System.out.println("Please input the correct answer: ");//Correct Answer
            quizObj.put("answer", sc.next());

            JSONArray jsonArray = (JSONArray) obj;
            jsonArray.add(quizObj);
            FileWriter fw = new FileWriter(fileN);
            fw.write(jsonArray.toJSONString());
            fw.flush();
            fw.close();

            System.out.println("Quiz saved at the database. Do you want to add more? (y/n)\n" +
                    "If user press y, then the previous scenario will happen again otherwise the program will be closed.\n");
            System.out.println("Enter choice: ");
            ch = sc.next().charAt(0);
        }

    }
    private static void startQuiz() throws IOException, ParseException {
        System.out.println("You will be asked 5 questions, each questions has 1 marks\n" + "");

        Scanner scn= new Scanner(System.in);
        int count=0;
        for(int i=1;i<=5;i++){
            JSONParser jsonParser=new JSONParser();
            Object obj=jsonParser.parse(new FileReader("./src/main/resources/QuizBank.json"));
            JSONArray jsonArray=(JSONArray) obj;

            Random rand= new Random();
            int max=jsonArray.size();
            int min=1;
            int pos= rand.nextInt(max-min+1)+min;

            JSONObject quizObj=(JSONObject) jsonArray.get(pos);

            System.out.println(i+". "+String.valueOf(quizObj.get("Question")));
            System.out.println("a. "+String.valueOf(quizObj.get("Option a")));
            System.out.println("b. "+String.valueOf(quizObj.get("Option b")));
            System.out.println("c. "+String.valueOf(quizObj.get("Option c")));
            System.out.println("d. "+String.valueOf(quizObj.get("Option d")));

            System.out.println("Enter option: ");

            String ch=scn.next();
            if(String.valueOf(quizObj.get("answer")).equals(ch)){
                System.out.println("Correct Answer");
                count++;
            }
            else{
                System.out.println("Not Correct Answer");
            }
            System.out.println();

        }
        System.out.println("Congratulation.You've gotten "+count +" out of 5");
    }

}

