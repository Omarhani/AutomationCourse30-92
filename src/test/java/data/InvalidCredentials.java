package data;

public class InvalidCredentials {

    public InvalidUsername InvalidUsername;
    public InvalidPassword InvalidPassword;

    public class InvalidUsername extends Login.UsernameAndPassword {

    }
    public class InvalidPassword extends Login.UsernameAndPassword {

    }
}
