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
        String[] pieces = dbUserName.split(SEPARATOR);

        if (pieces == null || pieces.length == 0) {
            return null;
        }
        UserFullname userFullname = new UserFullname();
        String firstPiece = !pieces[0].isEmpty() ? pieces[0] : null;
        if (dbUserName.contains(SEPARATOR)) {
            userFullname.setSurname(firstPiece);
            if (pieces.length >= 2 && pieces[1] != null
                    && !pieces[1].isEmpty()) {
                userFullname.setName(pieces[1]);
            }
        } else {
            userFullname.setName(firstPiece);
        }
        return userFullname;
    }
}
