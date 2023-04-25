public class Containers implements Comparable<Containers> {
    
    private String UUID;
    private String shortName;
    private String longName;

    Containers(){
        UUID = null;
        shortName = null;
        longName = null;
    }

    Containers(String UUID,String shortName,String longName){
        this.UUID = UUID;
        this.shortName = shortName;
        this.longName = longName;
    }

    public String getUUID() {
        return UUID;
    }
    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getShortName() {
        return shortName;
    }
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }
    public void setLongName(String longName) {
        this.longName = longName;
    }

    @Override 
    public int compareTo(Containers c){
        
        return (this.shortName).compareTo(c.shortName);
    }

    @Override
    public String toString (){
        return "    <CONTAINER UUID="+getUUID()+">\n        <SHORT-NAME>"+getShortName()+"</SHORT-NAME>\n"+
        "       <LONG-NAME>"+getLongName()+"</LONG-NAME>\n  </CONTAINER>\n";

    }
}