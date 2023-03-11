package Base.My_Study.my_Override;

public class Person {
    private String name;
    private int age;
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String say(){
        return "My name is "+name+" , and I was "+age+" years old";
    }

}
