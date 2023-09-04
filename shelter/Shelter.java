package shelter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Shelter {
    private int capacity;
    private List<Animal> data;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void add(Animal animal) {
        if (data.size() < capacity) {
            data.add(animal);
        }

    }

    public boolean remove(String name) {
        return data.removeIf(e->e.getName().equals(name));
    }
    public Animal getAnimal(String name,String caretaker) {
        for (Animal da : this.data) {
            if (da.getName().equals(name) && da.getCaretaker().equals(caretaker)) {
                return da;
            }
        }

        return null;
        }

    public Animal getOldestAnimal() {
        return this.data.stream().max(Comparator.comparingInt(Animal::getAge))
                .orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
     return "The shelter has the following animals:"+ System.lineSeparator() +
             this.data.stream().map(p -> String.format("%s %s", p.getName(), p.getCaretaker()))
                     .collect(Collectors.joining(System.lineSeparator()));
    }
}

