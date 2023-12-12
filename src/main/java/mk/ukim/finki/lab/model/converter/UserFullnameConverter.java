package mk.ukim.finki.lab.model.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import mk.ukim.finki.lab.model.UserFullname;

@Converter
public class UserFullnameConverter implements AttributeConverter <UserFullname, String>{
    private static final String SEPARATOR = " ";
    @Override
    public String convertToDatabaseColumn(UserFullname userFullname) {
        if (userFullname == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (userFullname.getName() != null && !userFullname.getName().isEmpty()) {
            sb.append(userFullname.getName());
            sb.append(SEPARATOR);
        }
        if (userFullname.getName() != null && !userFullname.getSurname().isEmpty()) {
            sb.append(userFullname.getSurname());
        }
        return sb.toString();
    }

    @Override
    public UserFullname convertToEntityAttribute(String dbUserName) {
        if (dbUserName == null || dbUserName.isEmpty()) {
            return null;
        }
        String[] parts = dbUserName.split(SEPARATOR);

        if (parts == null || parts.length == 0) {
            return null;
        }
        UserFullname userFullname = new UserFullname();
        String surname = !parts[0].isEmpty() ? parts[0] : null;
        if (dbUserName.contains(SEPARATOR)) {
            userFullname.setSurname(surname);
            if (parts.length >= 2 && parts[1] != null
                    && !parts[1].isEmpty()) {
                userFullname.setName(parts[1]);
            }
        } else {
            userFullname.setName(surname);
        }
        return userFullname;
    }
}
