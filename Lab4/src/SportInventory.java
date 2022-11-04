import java.util.Comparator;

public class SportInventory {
    String name, color;
    Integer cost;
    Double weight;
    Boolean available;

    SportInventory(String name, String color, Integer cost, Double weight, Boolean available) {
        this.name = name;
        this.color = color;
        this.cost = cost;
        this.weight = weight;
        this.available = available;
    }

    protected static Comparator<SportInventory> sortByName(){
        return Comparator.comparing(o -> o.name);
    }

    protected static Comparator<SportInventory> sortByCost(){
        return (o1, o2) -> o1.cost.compareTo(o2.cost);
    }

    protected static Comparator<SportInventory> sortByWeight(){
        return (o1, o2) -> o2.weight.compareTo(o1.weight);
    }

    @Override
    public String toString() {
        return "Name: " + name + "; Color: " + color + "; Cost: " + cost + "; Weight: " + weight + "; Available: " + available;
    }
}
