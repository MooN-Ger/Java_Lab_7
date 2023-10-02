package Task6;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceClassTest {

    @Test
    public void testGetSerializeAndGetDeserialize() throws IOException, ClassNotFoundException {
        Person pers1 = new Person("name1", "surname1", "patronymic1", new DateOfBirth(1,1,2001));
        Person pers2 = new Person("name2", "surname2", "patronymic2", new DateOfBirth(2,2,2002));
        Person pers3 = new Person("name3", "surname3", "patronymic3", new DateOfBirth(3,3,2003));
        Person pers4 = new Person("name4", "surname4", "patronymic4", new DateOfBirth(4,4,2004));
        ArrayList<Person> owners1 = new ArrayList<Person>();
        owners1.add(pers1);
        ArrayList<Person> owners2 = new ArrayList<Person>();
        owners2.add(pers2);
        ArrayList<Person> owners3 = new ArrayList<Person>();
        owners3.add(pers3);
        ArrayList<Person> owners4 = new ArrayList<Person>();
        owners4.add(pers4);
        Flat flat1 = new Flat(1, 111, owners1);
        Flat flat2 = new Flat(2, 222, owners2);
        Flat flat3 = new Flat(3, 333, owners3);
        Flat flat4 = new Flat(4, 444, owners4);
        ArrayList<Flat> flats = new ArrayList<Flat>();
        flats.add(flat1);
        flats.add(flat2);
        flats.add(flat3);
        flats.add(flat4);
        House house = new House("12345", "Omsk Mira 55", new Person("headName", "headSurname", "headPatronymic", new DateOfBirth(10,10,2000)), flats);
        ServiceClass.getSerialize(house, "house");
        assertEquals(house, ServiceClass.getDeserialize("house"));
    }

    @Test
    public void testGetJackSonSerializeAndJackSonDeserialize() throws IOException {
        Person pers1 = new Person("name1", "surname1", "patronymic1", new DateOfBirth(1,1,2001));
        Person pers2 = new Person("name2", "surname2", "patronymic2", new DateOfBirth(2,2,2002));
        Person pers3 = new Person("name3", "surname3", "patronymic3", new DateOfBirth(3,3,2003));
        Person pers4 = new Person("name4", "surname4", "patronymic4", new DateOfBirth(4,4,2004));
        ArrayList<Person> owners1 = new ArrayList<Person>();
        owners1.add(pers1);
        ArrayList<Person> owners2 = new ArrayList<Person>();
        owners2.add(pers2);
        ArrayList<Person> owners3 = new ArrayList<Person>();
        owners3.add(pers3);
        ArrayList<Person> owners4 = new ArrayList<Person>();
        owners4.add(pers4);
        Flat flat1 = new Flat(1, 111, owners1);
        Flat flat2 = new Flat(2, 222, owners2);
        Flat flat3 = new Flat(3, 333, owners3);
        Flat flat4 = new Flat(4, 444, owners4);
        ArrayList<Flat> flats = new ArrayList<Flat>();
        flats.add(flat1);
        flats.add(flat2);
        flats.add(flat3);
        flats.add(flat4);
        House house = new House("12345", "Omsk Mira 55", new Person("headName", "headSurname", "headPatronymic", new DateOfBirth(10,10,2000)), flats);
        String jsonStr = ServiceClass.getJackSonSerialize(house);
        assertEquals(house, ServiceClass.getJackSonDeserialize(jsonStr));
    }
}