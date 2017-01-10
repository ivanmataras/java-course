package ru.imataras.storages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.imataras.models.Message;
import ru.imataras.models.Role;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * TODO: comment
 *
 * @author imataras
 * @since 04.01.2017
 */

public class MessageStorage {

    private static final Logger log = LoggerFactory.getLogger(MessageStorage.class);
    private static final MessageStorage instance = new MessageStorage();
    private List<Message> messages = new CopyOnWriteArrayList<Message>();
    private final AtomicInteger ids = new AtomicInteger(0);

    private MessageStorage() {
    }

    public static MessageStorage getInstance() {
        return instance;
    }

    public void add(Message message) {
        message.setId(this.ids.incrementAndGet());
        this.messages.add(message);
    }

    public List<Message> findByOwner(final int id) {
        return this.messages.stream()
                .filter(message -> message.getOwner().getId() == id)
                .collect(Collectors.toList());
    }

    public List<Message> getAll() {
        return this.messages;
    }

    public void deleteByOwner(int id) {
        this.messages.removeIf(message -> message.getOwner().getId() == id);
    }

    public void delete(int messageId) {
        Message message = new Message();
        message.setId(messageId);
        this.messages.remove(message);
    }
}
