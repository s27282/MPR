import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Person person = null;
        try {
            person = new Person("Jan", 20);
        } catch (InvalidAgeExceptation e) {
            System.out.println("Złapano wyjątek: " +e.getMessage());
        }

//        try {
//            Person person2 = new Person("Adam", -5);
//        } catch (InvalidAgeExceptation e) {
//            System.out.println("Złapano wyjątek: " +e.getMessage());
//        }

        try{
            person.setAge(-10);
        } catch (InvalidAgeExceptation e) {
            System.out.println("Złapano wyjątek: " +e.getMessage());
        }

        System.out.println("Imię: " + person.getName() + " wiek: " + person.getAge());

        System.out.println("Osoba: " + person);

        Person person2 = new Person("Magda", 35);
        Person person3 = new Person("Andrzej", 28);

        List<Person> immutablePersonList = List.of(person, person2, person3);
// immutablePersonList.add(person); -
        System.out.println("Lista niemutowalna: " + immutablePersonList);

        List<Person> mutablePersonList = new ArrayList<>();
        mutablePersonList.add(person);
        mutablePersonList.add(person2);
        mutablePersonList.add(person3);

        System.out.println("Lista mutowalna: " + mutablePersonList);

Set<Person> immutablePersonSet= Set.of(person,person2,person3);
        System.out.println("Set niemutowalny: "+ immutablePersonSet);


        Set<Person> mutablePersonSet= new HashSet<>();
        mutablePersonSet.add(person);
        mutablePersonSet.add(person2);
        mutablePersonSet.add(person3);
        mutablePersonSet.add(person);

        System.out.println("Set mutowalny: " + mutablePersonSet);


        Map<Integer,Person> immutablePersonMap=Map.of(1,person,2, person2,3,person3);
        System.out.println("Mapa niemutowalna: " + immutablePersonMap);

        Map<String, Person>mutablePersonMap= new HashMap<>();
        mutablePersonMap.put("A", person);
        mutablePersonMap.put("B", person2);
        mutablePersonMap.put("C", person3);
        mutablePersonMap.put("A", person2);

        System.out.println("Mapa mutowalna: " + mutablePersonMap);

        //Streamy

        List<Integer> ageList = immutablePersonList.stream()
                .map(Person::getAge)
                .collect(Collectors.toList());
        Integer ageSum = ageList.stream()
                .reduce(0, (sum, value) -> sum + value);

        System.out.println("Suma lat: " + ageSum);

        double averageAge = (double) ageSum / ageList.size();

        System.out.println("Średnia wieku: " + averageAge);


        Integer ageSum1 = immutablePersonList.stream()
                .map(Person::getAge)
                .reduce(0, Integer::sum);

        System.out.println("Suma stream chain: " + ageSum1);

        List<String> nameList = immutablePersonList.stream()
                .map(Person::getName)
                .collect(Collectors.toList());

        System.out.println("Lista imion: " + nameList);




    }
}
