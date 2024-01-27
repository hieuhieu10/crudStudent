import java.util.Date;

public class Persons {
    private long id;
    private static long idCounter = 0;
    private String name;
    private String address;
    private Date birthDate;
    private double height;
    private double weight;

    public Persons() {
        idCounter++;
    }

    public Persons(long id, String name, String address, Date birthDate, double height, double weight) {
        this.id =idCounter++ ;
        this.name = name;
        this.address = address;
        this.birthDate = birthDate;
        this.height = height;
        this.weight = weight;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public static long getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(long idCounter) {
        Persons.idCounter = idCounter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Persons{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", birthDate=" + birthDate +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
