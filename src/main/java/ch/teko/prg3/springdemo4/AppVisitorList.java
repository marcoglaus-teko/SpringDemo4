package ch.teko.prg3.springdemo4;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AppVisitorList {

    @Id
    public long id = 1L;

    @ElementCollection
    private Set<String> visitors = new HashSet<>();

    public void addVisitor(String name) {
        this.visitors.add(name);
    }

    public String getListAsString() {
        return String.join(", ",this.visitors);
    }
}
