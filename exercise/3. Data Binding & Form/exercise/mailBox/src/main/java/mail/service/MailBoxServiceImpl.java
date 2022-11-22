package mail.service;

import mail.model.MailBox;
import mail.repository.IMailboxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailBoxServiceImpl implements MailBoxService {

    @Autowired
    private IMailboxRepository repository;

    @Override
    public List<MailBox> findAll() {
        return repository.findMailAll();
    }

    @Override
    public void save(MailBox mailBox) {
        repository.save(mailBox);
    }

    @Override
    public List<MailBox> findByName(String keyword) {
        return repository.findByName(keyword);
    }

    @Override
    public List<String> findLanguagesListAll() {
        return repository.findLanguagesListAll();
    }

    @Override
    public List<String> findPageListAll() {
        return repository.findPageListAll();
    }


}
