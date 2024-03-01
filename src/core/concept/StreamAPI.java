package core.concept;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "Tushar", 7.2, 934893489, "Delhi"));
        list.add(new Student(2, "Vedang", 9.2, 454893489, "Punjab"));
        list.add(new Student(3, "Pavan", 8.2, 654893489, "Assam"));
        list.add(new Student(4, "Satyam", 6.2, 434453489, "Delhi"));


        List<Student> stream = list.stream().filter((st)-> st.cgpa > 7 ? true : false).sorted((a, b)->a.name.compareTo(b.name)).collect(Collectors.toList());

        System.out.println(stream);

        Map<String, List<Student>> map = list.stream().collect(Collectors.groupingBy(st-> st.state));
        System.out.println(map);

        Map<Boolean, List<Student>> map2 = list.stream().collect(Collectors.partitioningBy(st -> (st.id % 2 == 0)? true: false));
        System.out.println(map2);

    }

}

class Student{
    int id;
    String name;
    double cgpa;
    long contact;
    String state;

    Student(int _id, String _name, double _cgpa, long _contact, String _state){
        this.id = _id;
        this.name = _name;
        this.cgpa = _cgpa;
        this.contact = _contact;
        this.state = _state;
    }
}
