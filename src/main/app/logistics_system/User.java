package logistics_system;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private int userId;
    private String name;
    private Location adress;
    private String mobNo;
    private String emailId;
}

