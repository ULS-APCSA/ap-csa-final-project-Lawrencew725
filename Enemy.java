public class Enemy extends Entities{
    public int currentRow = (int) (Math.random() * 5 + 1);
    public int currentCol = (int) (Math.random() * 13 + 1);
    public MapElement[][] mainMap = null;
    public int IDnumber = 0;
    public Enemy(MapElement[][] mainMap){
                //String Weapon, int HP, int Shield, String sign
        super("enemy",100,100,"#");
        this.mainMap = mainMap;
    }

    public void move(){
        int direction =(int) ((Math.random() * 4) + 1);
        //1 for up, 2 for down, 3 for left, 4 for right
        int moveToRow = currentRow;
        int moveToCol = currentCol;
        MapElement moveTo = null;
        if(HP < 1){
            return;
        }
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
        }else{
            System.out.println("not an option");
        }
        if(moveTo.canBeOverlay && moveTo.IOBE == -1){
            MapElement old = mainMap[currentRow][currentCol];
            old.IOBE = -1;
            old.canBeOverlay = true;
            old.signRestore = "+";
            old.restore();
            currentCol = moveToCol;
            currentRow = moveToRow;
            moveTo.setSign(super.getSign());
            moveTo.IOBE = IDnumber;
        }
        }

        public void DIE(){
            if(IDnumber != -1){
                setSign("+");
                IDnumber = -1;
                System.out.println("You have killed an enemy");
            }
        }

        public String toString(){
            return "enemyID: " + IDnumber + " at Row: " + currentRow + " at Col: " + currentCol;
        }
}
