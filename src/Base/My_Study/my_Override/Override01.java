package Base.My_Study.my_Override;

public class Override01 {
    public static void main(String []args){
        Person p = new Person("pangchao",22);
        System.out.println(p.say());
        Student s = new Student("pangchao",22,"1234",100);
        System.out.println(s.say());
    }
}
