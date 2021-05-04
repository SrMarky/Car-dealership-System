package dealership.messages;

public enum Messages {
    DATABASE_CONNECTION_ERROR("Connessione al database non riuscita!!!"),
    DATABASE_CREATE_TABLE_ERROR("Errore impossibile creare la tabella nel database!!"),
    INSERT_CAR_ERROR("Errore impossibile inserire l'auto!!!")
    ;
    private final String string;

    Messages(String t) {
     this.string = t;
    }

    @Override
    public String toString() {
        return this.string;
    }
}
