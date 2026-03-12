package data;

import models.Category;
import models.Pet;
import models.Tag;

import java.util.List;

public class PetDataBuilder {

    public static Pet createPet(long id, Category category, Tag tag) {

        Pet pet = new Pet();

        pet.setId(id);
        pet.setName("dog_" + id);
        pet.setStatus("available");

        pet.setCategory(category);
        pet.setPhotoUrls(List.of("example.photo.url"));
        pet.setTags(List.of(tag));

        return pet;
    }
}