package ru.imataras.clinic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Класс описывает клиента
 *
 * @author imataras
 * @since 22.09.2016
 */

public class Client {

    private int id;
    private String name;
    private List<Pet> pets;

    public Client() {
        this.pets = new ArrayList<Pet>();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<Pet> getPets() {
        return this.pets;
    }

    public void addPet(Pet pet) {
        this.pets.add(pet);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pets=" + pets +
                '}';
    }

    public Pet getPetById(int petId) {
        Pet result = null;
        for (Pet pet : this.pets) {
            if (pet.getId() == petId) {
                result = pet;
                break;
            }
        }
        return result;
    }

    public void editPet(Pet result) {
        this.pets.remove(this.getPetById(result.getId()));
        this.pets.add(result);
    }

    public void deletePet(int petId) {
        this.pets.remove(this.getPetById(petId));
    }

}
