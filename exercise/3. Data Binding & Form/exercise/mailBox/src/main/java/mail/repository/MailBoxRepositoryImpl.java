package mail.repository;

import mail.model.MailBox;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;


@Repository
public class MailBoxRepositoryImpl implements IMailboxRepository {

    private static List<MailBox> mailBoxList;
    private static List<String> languagesList;
    private static List<String> pageList;

    static {
        mailBoxList = new ArrayList<>();
        mailBoxList.add(new MailBox("Anh", "5", true, "JAVA"));
        mailBoxList.add(new MailBox("Viet", "10", false, "C#"));
        mailBoxList.add(new MailBox("Trung", "15", true, "C#"));
    }
    static {
        languagesList = new ArrayList<>();
        languagesList.add(new String("Anh"));
        languagesList.add(new String("Viet" ));
        languagesList.add(new String("Trung"));
    }
    static {
        pageList = new ArrayList<>();
        pageList.add(new String("1"));
        pageList.add(new String("5" ));
        pageList.add(new String("10"));
        pageList.add(new String("50"));
        pageList.add(new String("100"));
        pageList.add(new String("150"));
    }

    @Override
    public List<MailBox> findMailAll() {
        return mailBoxList;
    }

    @Override
    public List<String> findLanguagesListAll() {
        return languagesList;
    }

    @Override
    public List<String> findPageListAll() {
        return pageList;
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
