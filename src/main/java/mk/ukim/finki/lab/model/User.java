package mk.ukim.finki.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.lab.model.converter.UserFullnameConverter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "cinema_users")
public class User {
    @Id
    private String username;
    @Convert(converter = UserFullnameConverter.class)
    private UserFullname fullname;
    private String password;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<ShoppingCart> carts;
    public User(){

    }

    public User(String username, String name, String surname, String password) {
        this.username = username;
        UserFullname fullname = new UserFullname();
        fullname.setName(name);
        fullname.setSurname(surname);
        this.fullname = fullname;
        this.password = password;
    }
}
