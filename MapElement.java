public class MapElement{
    private String sign = "+";
    public String signRestore = null;
    public boolean canBeOverlay = true;
    public boolean IOBP = false; //Is Overlaped By Player

    //IOBE handels whether there is an enemy object is currently overlaped on this
    //element. -1 means this element is not overlaped. If it apperars any positive
    //number or zero, that is the index if the enemy object in the enemy array;
    public int IOBE = -1; //Is Overlaped By Enemy
    public MapElement(String sign, boolean canBeOverlay){
        setSign(sign);
        this.canBeOverlay = canBeOverlay;
        signRestore = sign;
    }
    public MapElement(String sign){
        setSign(sign);
        signRestore = sign;
    }

    public void setSign(String sign){
        this.sign = sign;
    }

    public String getSign(){
        return sign;
    }

    public void printSign(){
        System.out.print(sign);
    }

    public String toString(){
        return sign;
    }

    public void restore(){
        sign = signRestore;
    }

    public void interaction(){
        if(!canBeOverlay){
            System.out.println("You can not do that.");
        }
        if(IOBP && IOBE != -1){
            CombatSys.combat(IOBE);
        }
    }
}
