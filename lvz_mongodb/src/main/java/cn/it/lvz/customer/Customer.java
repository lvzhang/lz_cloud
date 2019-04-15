package cn.it.lvz.customer;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class Customer {

    @Id
    public String id;

    public String firstName;
    public String lastName;
    private List<Hobby> hobbies;

    public Customer() {
    }

    public Customer(String firstName, String lastName, List<Hobby> hobbies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hobbies = hobbies;
    }

}