package ru.imataras.clinic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO: comment
 *
 * @author imataras
 * @since 21.09.2015
 */

public class Clinic implements IClinic {

    private final AtomicInteger clientIds = new AtomicInteger();
    private final AtomicInteger petIds = new AtomicInteger();
    final Map<Integer, Client> clients = new LinkedHashMap<Integer, Client>();

    @Override
    public void addClient(final Client client) {
        client.setId(clientIds.incrementAndGet());
        this.clients.put(client.getId(), client);
    }

    @Override
    public void addPet(final int id, final Pet pet) {
        pet.setId(petIds.incrementAndGet());
        this.clients.get(id).addPet(pet);
    }

    @Override
    public void editClient(final Client client) {
        this.clients.put(client.getId(), client);
    }

    @Override
    public void editPet(final int id, final Pet pet) {
        this.clients.get(id).editPet(pet);
    }

    @Override
    public void deleteClient(final int id) {
        this.clients.remove(this.getById(id));
    }

    @Override
    public void deletePet(final int clientId, final int petId) {
        this.getById(clientId).deletePet(petId);
    }

    @Override
    public Collection<Client> searchClient(final String name) {
        List<Client> result = new ArrayList<Client>();
        for (Client client : this.clients.values()) {
            if (client.getName().contains(name)) {
                result.add(client);
            }
        }
        return result;
    }

    @Override
    public Collection<Client> searchPet(final String nick) {
        List<Client> result = new ArrayList<Client>();
        for (Client client : this.clients.values()) {
            for (Pet pet : client.getPets()) {
                if (pet.getName().contains(nick)) {
                    result.add(client);
                }
            }
        }
        return result;
    }

    @Override
    public Collection<Client> getClients() {
        return new ArrayList<Client>(clients.values());
    }

    @Override
    public Client getById(int clientId) {
        return this.clients.get(clientId);
    }

}
