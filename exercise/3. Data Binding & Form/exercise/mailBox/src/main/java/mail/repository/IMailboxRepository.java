package mail.repository;

import mail.model.MailBox;


import java.util.List;

public interface IMailboxRepository {
    List<MailBox> findAll();

    void save(MailBox mailBox);

    public List<MailBox> findByName(String keyword);
}
