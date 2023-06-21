import java.io.Serializable;

class Animal implements Serializable {
    private int code;
    private String name;
    private String type;
    private double weight;
    private int maxAge;

    public Animal(int code, String name, String type, double weight, int maxAge) {
        this.code = code;
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.maxAge = maxAge;
    }

    public String toString() {
        return "Code:" + code + "\nName:" + name + "\nType:" + type +
                "\nWeight:" + weight + "\nMax Age:" + maxAge + "\n==============";
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }
}
