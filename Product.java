import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Product {

    private String characterName;
    private String initiativeRoll;
    private String extraNotes;
    private Integer dexScore;
    private Integer finalInitiative;
    private Pattern p;
    private Matcher m;


    public Product(){
        this.characterName = "";
        this.initiativeRoll = "";
        this.extraNotes = "";
        this.dexScore = 0;
        this.finalInitiative = 0;
    }

    public Product(String characterName, String initiativeRoll, String extraNotes, Integer dexScore) {
        this.characterName = characterName;
        this.initiativeRoll = initiativeRoll;
        this.extraNotes = extraNotes;
        this.dexScore = dexScore;
        calcFinalInitiative();
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String charactername) {
        this.characterName = charactername;
    }

    public String getInitiativeRoll() {
        return initiativeRoll;
    }

    public void setInitiativeRoll(String initiativeroll) {
        this.initiativeRoll = initiativeroll;
        if(dexScore != 0) calcFinalInitiative();
    }

    public String getExtraNotes() {
        return extraNotes;
    }

    public void setExtraNotes(String extranotes) {
        this.extraNotes = extranotes;
    }

    public int getDexScore() {
        return dexScore;
    }

    public void setDexScore(int dexscore) {
        this.dexScore = dexscore;
        if(initiativeRoll != "") calcFinalInitiative();
    }

    public Integer getFinalInitiative() {
        return finalInitiative;
    }

    /**This calculates the final initiative score.
     * This will get called if the dex score or initiative roll changes, but only if both have actual values.
     * Uses a regular expression to ensure that the initiativeRoll string is parsable.
     * If the initiative roll contain a *, the value of the initiative is set to 100 and the dex bonus is added to ensure being top of the list
     */
    private void calcFinalInitiative(){
        int convertedDex = (dexScore -10)/2;
        p = Pattern.compile("^[0-9]+$");
        m = p.matcher(initiativeRoll);
        if(m.find()){
            this.finalInitiative = Integer.parseInt(initiativeRoll)+convertedDex;

        }
        else{
            if(initiativeRoll.contains("*"));
            this.finalInitiative = 100+convertedDex;
        }

    }
}
