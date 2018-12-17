package sample;

public class Product {

    private String charactername;
    private String initiativeroll;
    private String extranotes;
    private Integer dexscore;

    public Product(){
        this.charactername = "";
        this.initiativeroll = "";
        this.extranotes = "";
        this.dexscore = 0;
    }

    public Product(String charactername, String initiativeroll, String extranotes, Integer dexscore) {
        this.charactername = charactername;
        this.initiativeroll = initiativeroll;
        this.extranotes = extranotes;
        this.dexscore = dexscore;
    }

    public String getCharacterName() {
        return charactername;
    }

    public void setCharacterName(String charactername) {
        this.charactername = charactername;
    }

    public String getInitiativeRoll() {
        return initiativeroll;
    }

    public void setInitiativeRoll(String initiativeroll) {
        this.initiativeroll = initiativeroll;
    }

    public String getExtraNotes() {
        return extranotes;
    }

    public void setExtraNotes(String extranotes) {
        this.extranotes = extranotes;
    }

    public int getDexScore() {
        return dexscore;
    }

    public void setDexScore(int dexscore) {
        this.dexscore = dexscore;
    }

}
