package app.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Konekcija {
    private final String host;
    private final String korisnik;
    private final String lozinka;
    private final String baza;

    protected Connection konekcija;

    public Konekcija () {
        this.host = "localhost:3306";
        this.korisnik = "root";
        this.lozinka = "";
        this.baza = "tna";
        this.spoji();
    }

    public Konekcija (String host, String korisnik, String lozinka, String baza) {
        this.host = host;
        this.korisnik = korisnik;
        this.lozinka = lozinka;
        this.baza = baza;
        this.spoji();
    }

    public void spoji () {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.konekcija = DriverManager.getConnection("jdbc:mysql://"+this.host+"/"+this.baza+"?"
                    + "user="+this.korisnik+"&password="+this.lozinka+"&allowMultiQueries=true");
        } catch (ClassNotFoundException e) {
            System.out.println ("Sustav nije uspio pronaći klasu za konekciju na MYSQL...");
        } catch (SQLException e) {
            System.out.println ("Sustav nije se mogao spojiti na bazu podataka...");
        }
    }

}
