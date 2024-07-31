package com.mycompany.socnetworkspring.springdata;

import com.mycompany.socnetworkspring.percistence.IDAOMessage;
import com.mycompany.socnetworkspring.percistence.enteties.Message;
import com.mycompany.socnetworkspring.percistence.repositories.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class MessageImpl implements IDAOMessage {

    private MessageRepository messageRepository;

    @Override
    public Message create(Message obj) {
        return messageRepository.save(obj);
    }

    @Override
    public Message update(Message obj) {
        return messageRepository.save(obj);
    }

    @Override
    public void delete(Long id) {
        messageRepository.deleteById(id);
    }

    @Override
    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    @Override
    public Optional<Message> findById(Long id) {
        return messageRepository.findById(id);
    }
}
