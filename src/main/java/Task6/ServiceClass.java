package Task6;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.*;

public class ServiceClass {

    public static void getSerialize (Object obj, String fileName) throws IOException {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))){
            objectOutputStream.writeObject(obj);
        }
    }

    public static Object getDeserialize (String fileName) throws IOException, ClassNotFoundException, ClassCastException {
        Object obj;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            obj = (Object) objectInputStream.readObject();
        }
        return obj;
    }

    public static String getJackSonSerialize (House house) throws IOException{
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, house);
        return writer.toString();
    }

    public static House getJackSonDeserialize (String jsonStr) throws IOException {
        StringReader reader = new StringReader(jsonStr);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(reader, House.class);
    }
}
