package dev.shegs.blogsite.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "authority")
@Getter
@Setter
@NoArgsConstructor
public class Authority implements Serializable {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    @Column(length = 100)
    private String authorityName;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Authority authority1 = (Authority) o;

        return authorityName.equals(authority1.authorityName);
    }

    @Override
    public int hashCode() {
        return authorityName.hashCode();
    }

    @Override
    public String toString() {
        return "Authority{" +
                "authorityName='" + authorityName + '\'' +
                '}';
    }
}
