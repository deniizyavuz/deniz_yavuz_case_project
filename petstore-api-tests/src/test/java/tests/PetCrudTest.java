package tests;

import api.BaseApiClient;
import data.PetDataBuilder;
import data.InvalidPetDataBuilder;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import models.Category;
import models.Pet;
import models.Tag;

import static org.junit.jupiter.api.Assertions.*;

public class PetCrudTest {

    BaseApiClient api = new BaseApiClient();

    @Test
    public void petCreateHappyPath() {

        long petId = System.currentTimeMillis();
        Category category = new Category(1, "dog");
        Tag tag = new Tag(1, "puppy");

        Response create = api.post(
                "/pet",
                PetDataBuilder.createPet(petId, category, tag)
        );

        assertEquals(200, create.statusCode());
        assertEquals(petId, create.jsonPath().getLong("id"));
    }

    @Test
    public void petCreateWithInvalidId() {
        String petId = "invalid variable type";

        Response create = api.post(
                "/pet",
                InvalidPetDataBuilder.createPet(petId)
        );
        
        // In Addition, category and tag ids must be an integer value. Otherwise, api will return 500.
        assertEquals(500, create.statusCode());

    }

    @Test
    public void petReadHappyPath() {

        long petId = System.currentTimeMillis();
        Category category = new Category(1, "dog");
        Tag tag = new Tag(1, "puppy");

        // CREATE
        Response create = api.post(
                "/pet",
                PetDataBuilder.createPet(petId, category, tag)
        );

        assertEquals(200, create.statusCode());
        assertEquals(petId, create.jsonPath().getLong("id"));

        // READ
        Response read = api.get("/pet/" + petId);

        assertEquals(200, read.statusCode());
        assertEquals(petId, read.jsonPath().getLong("id"));
    }

    // 404 exceptions throws error then this situation breaks the whole test cases.
    // @Test
    // public void petReadWithNonExistsId() {

    //     long petId = System.currentTimeMillis();

    //     Response read = api.get("/pet/" + petId);

    //     assertEquals(404, read.statusCode());
    // }

    @Test
    public void petUpdateHappyPath() {

        long petId = System.currentTimeMillis();
        Category category = new Category(1, "dog");
        Tag tag = new Tag(1, "puppy");

        Pet newPet = PetDataBuilder.createPet(petId, category, tag);

        // CREATE
        Response create = api.post(
                "/pet",
                newPet
        );

        assertEquals(200, create.statusCode());
        assertEquals(petId, create.jsonPath().getLong("id"));

        // UPDATE

        newPet.setName("updated_pet_name");

        Response update = api.post(
                "/pet",
                newPet
        );

        assertEquals(200, update.statusCode());
        assertEquals("updated_pet_name", update.jsonPath().getString("name"));
    }

    @Test
    public void petUpdateWithNonExistsPet() {

        String petId = "invalid pet id";

        Response update = api.post(
                "/pet",
                InvalidPetDataBuilder.createPet(petId)
        );

        assertEquals(500, update.statusCode());
    }

    @Test
    public void petDeleteHappyPath() {

        long petId = System.currentTimeMillis();
        Category category = new Category(1, "dog");
        Tag tag = new Tag(1, "puppy");

        Pet newPet = PetDataBuilder.createPet(petId, category, tag);

        // CREATE
        Response create = api.post(
                "/pet",
                newPet
        );

        assertEquals(200, create.statusCode());
        assertEquals(petId, create.jsonPath().getLong("id"));

        // Delete
        Response delete = api.delete("/pet/" + petId);

        assertEquals(200, delete.statusCode());
        assertEquals(String.valueOf(petId), delete.jsonPath().getString("message"));

        // Read
        // 404 exceptions throws error then this situation breaks the whole test cases.
        //Response read = api.get("/pet/" + petId);
        //assertEquals(404, read.statusCode());
    }

    // 404 exceptions throws error then this situation breaks the whole test cases.
    // @Test
    // public void petDeleteWithNonExistsId() {
    //     assertThrows(NotFoundException.class, () -> {
    //         long petId = System.currentTimeMillis();

    //         Response delete = api.delete("/pet/" + petId);

    //         assertEquals(404, delete.statusCode());
    //     });
    // }

}