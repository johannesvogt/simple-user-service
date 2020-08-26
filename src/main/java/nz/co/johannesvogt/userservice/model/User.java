package nz.co.johannesvogt.userservice.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
@EqualsAndHashCode
@Getter
@Setter
public class User {

    @Id
    private Long id;

    @NotNull
    private String surname;

    @NotNull
    private String firstname;

    @NotNull
    private String email;

}
