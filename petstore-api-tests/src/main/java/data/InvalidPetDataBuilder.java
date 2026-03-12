package data;

import java.util.HashMap;
import java.util.Map;

public class InvalidPetDataBuilder {

    public static Map<String, String> createPet(String id) {

        Map<String, String> pet = new HashMap<>();

        pet.put("id", id);

        return pet;
    }
}