package telesens.academy.lesson10;

public class Operator implements Comparable <Operator> {
    private Long id;
    private String name;

    public Operator(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Operator other) {
        String name=this.name;
        String name2=other.name;
        return name.compareTo(name2);

    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
