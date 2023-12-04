package castle;

public class MonsterTask {
    private final String question;
    private final String answer;

    public MonsterTask(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public boolean ask() {
        System.out.println(question);
        System.out.print("ответ: ");
        String answer = Input.readString();
        return answer.equalsIgnoreCase(this.answer);
    }
}
