package Task6;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

@JsonAutoDetect

public class House implements Serializable {
    private String cadastralNumber;
    private String address;
    private Person head;
    private ArrayList<Flat> flatList;

    public House () {
        this.cadastralNumber = "0000";
        this.address = "some_address";
        this.head = new Person();
        this.flatList = new ArrayList<Flat>();
    }

    public House (String cadastralNumber, String address, Person head, ArrayList<Flat> flatList) {
        this.cadastralNumber = cadastralNumber;
        this.address = address;
        this.head = head;
        this.flatList = flatList;
    }

    public String getCadastralNumber() {
        return cadastralNumber;
    }

    public void setCadastralNumber(String cadastralNumber) {
        this.cadastralNumber = cadastralNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Person getHead() {
        return head;
    }

    public void setHead(Person head) {
        this.head = head;
    }

    public ArrayList<Flat> getFlatList() {
        return flatList;
    }

    public void setFlatList(ArrayList<Flat> flatList) {
        this.flatList = flatList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return Objects.equals(cadastralNumber, house.cadastralNumber) && Objects.equals(address, house.address) && Objects.equals(head, house.head) && Objects.equals(flatList, house.flatList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cadastralNumber, address, head, flatList);
    }

    @Override
    public String toString() {
        return "House{" +
                "cadastralNumber='" + cadastralNumber + '\'' +
                ", address='" + address + '\'' +
                ", head=" + head +
                ", flatList=" + flatList +
                '}';
    }
}
