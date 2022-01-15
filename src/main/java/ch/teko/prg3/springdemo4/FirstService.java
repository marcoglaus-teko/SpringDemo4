package ch.teko.prg3.springdemo4;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class FirstService {

    @PersistenceContext
    private EntityManager entityManager;

    public FirstService() {
        System.out.println("Constructor from class FirstService is called!");
    }

    @EventListener(value = ApplicationReadyEvent.class)
    public void init() {
        System.out.println("Application is up and running!");
    }

    @Transactional
    public DTO greetings(String user) {
        String greetingsMessage = "Guten Morgen " + user + " wie geht es dir?";
        return new DTO(greetingsMessage + " Folgende Usernamen finden sich in der DB "  + this.getVisitorList(user));
    }

    private String getVisitorList(String user) {
        AppVisitorList result = this.entityManager.find(AppVisitorList.class, 1L);
        if(result == null) {
            AppVisitorList newList = new AppVisitorList();
            result = newList;
            entityManager.persist(newList);
        }
        result.addVisitor(user);
        return result.getListAsString();
    }
}
