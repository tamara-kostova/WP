package mk.ukim.finki.lab.service;
import mk.ukim.finki.lab.model.User;

public interface IloginService {
    User login(String username, String password);
    User register(String username, String password, String repeatPassword, String name, String surname);
}
