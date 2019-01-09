package ch.hearc.ig.ta.tp.Business;

public class Deal {
    int id;
    String name;
    String titre;
    String description;

    public Deal(String name, String titre, String description) {
        this.id = id;
        this.name = name;
        this.titre = titre;
        this.description = description;
    }

    public Deal() {}

    public int getID(){ return id; }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getTitre(){
        return this.titre;
    }

    public void setTitre(String titre){
        this.titre = titre;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

}
