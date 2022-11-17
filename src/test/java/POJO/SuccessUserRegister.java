package POJO;

public class SuccessUserRegister {
    private Integer id;
    private String token;

    public SuccessUserRegister() {

    }

    public SuccessUserRegister(Integer id, String token) {
        this.id = id;
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public String getToken() {
        return token;
    }
}
