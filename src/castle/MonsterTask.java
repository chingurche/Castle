package castle;

import java.util.Locale;

public class MonsterTask {
    private String question;
    private String answer;

    public MonsterTask() { }
    public MonsterTask(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public boolean Ask() {
        System.out.println(question);
        System.out.print("ответ: ");
        String answer = Input.readString();
        if (answer.toLowerCase() == this.answer.toLowerCase()) {
            return true;
        }
        return false;
    }
}
