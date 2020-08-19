package model;

public class AuthInfo {
    private Long id;
    private String name;

    public AuthInfo(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
