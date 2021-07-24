package pojos.requests;

public class CreateUserRequestPojo {
    public String name;
    public String gender;
    public String email;
    public String status;


    public CreateUserRequestPojo(String name, String gender, String email, String status) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.status = status;
    }
}
