package core.concept;

public class BuilderPatternDesignPattern {
    public static void main(String[] args) {
        Person p1 = new PersonBuilder().setId(1001).setEmail1("tushar1@gmail.com").setName("Tushar").getPerson();
        System.out.println(p1);

    }
}

class PersonBuilder{
    int id;
    String name;
    int age;
    String email1;
    String email2;
    String address;

    public PersonBuilder setId(int _id){
        this.id = _id;
        return this;
    }

    public PersonBuilder setName(String _name){
        this.name = _name;
        return this;
    }
    public PersonBuilder setAge(int _age){
        this.age = _age;
        return this;
    }
    public PersonBuilder setEmail1(String _email1){
        this.email1 = _email1;
        return this;
    }
    public PersonBuilder setEmail2(String _email2){
        this.email1 = _email2;
        return this;
    }
    public PersonBuilder setAddress(String _address){
        this.email1 = _address;
        return this;
    }

    public Person getPerson(){
        Person person = new Person(this.id, this.name, this.age, this.email1, this.email2, this.address);
        return person;
    }

}

class Person{
    int id;
    String name;
    int age;
    String email1;
    String email2;
    String address;

    Person(){
        id = 0;
        age = 0;
        name = email1 = email2 = address = null;
    }

    Person(int _id, String _name, int _age, String _email1, String _email2, String _address){
        this.id = _id;
        this.name = _name;
        this.age = _age;
        this.email1 = _email1;
        this.email2 = _email2;
        this.address = _address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email1='" + email1 + '\'' +
                ", email2='" + email2 + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}