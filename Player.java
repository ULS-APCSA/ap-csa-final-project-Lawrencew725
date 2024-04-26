
public class Player extends Entities {
    public int currentRow = 0;
    public int currentCol = 0;
    public MapElement[][] mainMap = null;
    public Player(String Weapon, int HP, int Shield, String sign, MapElement[][] mainMap){
        //String Weapon, int HP, int Shield, String sign
        super(Weapon,HP,Shield,sign);
        this.mainMap = mainMap;
    }

    public Player(MapElement[][] mainMap){
        super("apple",10,10,"?");
        this.mainMap = mainMap;
    }

    public void move(int direction){
    //1 for up, 2 for down, 3 for left, 4 for right
    int moveToRow = currentRow;
    int moveToCol = currentCol;
    MapElement moveTo = null;
    if(direction == 1){
        moveToRow--;
        moveTo = mainMap[moveToRow][currentCol];
    }else if(direction == 2){
        moveToRow++;
        moveTo = mainMap[moveToRow][currentCol];
    }else if(direction == 3){
        moveToCol--;
        moveTo = mainMap[currentRow][moveToCol];
    }else if(direction == 4){
        moveToCol++;
        moveTo = mainMap[currentRow][moveToCol];
    }
    if(moveTo.canBeOverlay){
        MapElement old = mainMap[currentRow][currentCol];
        //restore the previous element to it's oringinal state
        old.IOBP = false;
        old.canBeOverlay = true;
        //System.out.println("the sign restore is: " + old.signRestore);
        old.restore();
        System.out.println("can the old be overlay? " + old.canBeOverlay);
        //old.setSign("+");
        currentCol = moveToCol;
        currentRow = moveToRow;
        //configure the new element
        moveTo.setSign(super.getSign());
        moveTo.IOBP = true;
        moveTo.canBeOverlay = false;
        System.out.println("can the new be overlay? " + moveTo.canBeOverlay);
        moveTo.interaction();
    }
    }
    
}
