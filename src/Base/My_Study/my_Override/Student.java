package Base.My_Study.my_Override;

public class Student extends Person{
    private String id;
    private int score;
    public Student(String name, int age, String id, int score){
        super(name,age);
        this.id = id;
        this.score = score;
    }

    public String say(){
        return super.say()+", "+"id is "+id+", score is "+score;
    }

}
