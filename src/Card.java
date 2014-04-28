
public class Card 
{
    int cNum;
    String cSuit;
    String pathName;
    String cName;
    
    public Card(String cName) 
    {
        pathName = "resources/" + cName + ".jpg";
        this.cName = cName;
        parseCardName();
    }

    public void parseCardName() 
    {
        cSuit = cName.substring(0, 1);
        cNum = Integer.parseInt(cName.substring(1));
    }

    public int getCNum() 
    {
        return cNum;
    }

    public String getCPath() 
    {
        return pathName;
    }

    public String getCSuit() 
    {
        return cSuit;
    }
}
