package ch.hearc.ig.ta.tp.Business;

public class Deal {
    int id;
    String name;
    String titre;
    String categorie;

    public Deal(String name, String titre, String categorie) {
        this.id = id;
        this.name = name;
        this.titre = titre;
        this.categorie = categorie;
    }

    public Deal() {

    }

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

    public String getCategorie(){
        return this.categorie;
    }

    public void setCategorie(String categore){
        this.categorie = categore;
    }

}
