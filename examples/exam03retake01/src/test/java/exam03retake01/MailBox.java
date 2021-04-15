package exam03retake01;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MailBox {

    private List<Mail> mails = new ArrayList<>();

    public void addMail(Mail mail) {
        mails.add(mail);
    }

    public List<Mail> getMails() {
        return mails;
    }

    public List<Mail> findByCriteria(String criteria) {
        Objects.requireNonNull(criteria);
        String criteriaFrom = "";
        String criteriaTo = "";
        if (criteria.contains(":")) {
            if (criteria.contains("from")) {
                criteriaFrom = criteria.substring(criteria.indexOf(":") + 1);
            }
            if (criteria.contains("to")) {
                criteriaTo = criteria.substring(criteria.indexOf(":") + 1);
            }
        }
        List<Mail> result = new ArrayList<>();

        for (Mail mail : mails) {
            for (Contact contact : mail.getTo()) {
                if (contact.getName().equals(criteriaTo) || contact.getEmail().equals(criteriaTo)){
                    result.add(mail);
                }
            }
            if (mail.getFrom().getName().equals(criteriaFrom) || mail.getFrom().getEmail().equals(criteriaFrom)) {
                result.add(mail);
            }
            if (mail.getMessage().contains(criteria) || mail.getSubject().contains(criteria)) {
                result.add(mail);
            }
        }
        return result;
    }
}
