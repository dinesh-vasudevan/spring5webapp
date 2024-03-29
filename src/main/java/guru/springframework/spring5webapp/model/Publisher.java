package guru.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publisher)) return false;
        Publisher publisher = (Publisher) o;
        return Objects.equals(id, publisher.id) &&
                Objects.equals(getName(), publisher.getName()) &&
                Objects.equals(getAddress(), publisher.getAddress());

    }

    @Override
    public int hashCode() {

        return Objects.hash(id, getName(), getAddress());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
