package mail.service;

import mail.model.MailBox;


import java.util.List;

public interface MailBoxService {
    List<MailBox> findAll();

    void save(MailBox mailBox);

    public List<MailBox> findByName(String keyword);
}
