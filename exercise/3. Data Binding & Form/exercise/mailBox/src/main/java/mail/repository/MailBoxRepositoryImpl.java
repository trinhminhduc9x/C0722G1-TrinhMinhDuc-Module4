package mail.repository;

import mail.model.MailBox;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;


@Repository
public class MailBoxRepositoryImpl implements IMailboxRepository {

    private static List<MailBox> mailBoxList;

    static {
        mailBoxList = new ArrayList<>();
        mailBoxList.add(new MailBox("Anh", 1, true, "JAVA"));
        mailBoxList.add(new MailBox("Viet", 1, false, "C#"));
        mailBoxList.add(new MailBox("Trung", 1, true, "C#"));
    }

    @Override
    public List<MailBox> findAll() {
        return mailBoxList;
    }

    @Override
    public void save(MailBox mailBox) {
        mailBoxList.add(mailBox);
    }

    public List<MailBox> findByName(String keyword) {
        List<MailBox> result = new ArrayList<>();
        for (MailBox mailBox : mailBoxList) {
            if (mailBox.getLanguages().contains(keyword)) {
                result.add(mailBox);
            }
        }
        return result;
    }
}
