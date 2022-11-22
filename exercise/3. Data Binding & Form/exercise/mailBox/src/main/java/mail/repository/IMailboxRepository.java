package mail.repository;

import mail.model.MailBox;


import java.util.List;

public interface IMailboxRepository {
    List<MailBox> findMailAll();
    List<String> findLanguagesListAll();
    List<String> findPageListAll();

    void save(MailBox mailBox);

    public List<MailBox> findByName(String keyword);
}
