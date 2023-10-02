package Task6;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

@JsonAutoDetect
public class Flat implements Serializable {
    private int number;
    private double area;
    private ArrayList<Person> tenants;

    public Flat () {
        this.number = 0;
        this.area = 0;
        this.tenants = new ArrayList<Person>();
    }

    public Flat (int number, double area, ArrayList<Person> tenants) {
        this.number = number;
        this.area = area;
        this.tenants = tenants;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public ArrayList<Person> getTenants() {
        return tenants;
    }

    public void setTenants(ArrayList<Person> tenants) {
        this.tenants = tenants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flat flat = (Flat) o;
        return number == flat.number && Double.compare(flat.area, area) == 0 && Objects.equals(tenants, flat.tenants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, area, tenants);
    }

    @Override
    public String toString() {
        return "Flat{" +
                "number=" + number +
                ", area=" + area +
                ", tenants=" + tenants +
                '}';
    }
}
