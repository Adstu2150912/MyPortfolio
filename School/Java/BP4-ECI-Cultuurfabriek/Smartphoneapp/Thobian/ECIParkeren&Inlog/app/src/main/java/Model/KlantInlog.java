package Model;

public class KlantInlog {
    private String Email = null;
    private String Wachtwoord = null;



    public KlantInlog(String Email, String Wachtwoord){

        this.Email = Email;
        this.Wachtwoord = Wachtwoord;

    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getWachtwoord() {
        return Wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        Wachtwoord = wachtwoord;
    }
}
