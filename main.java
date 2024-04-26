import java.util.Scanner;
public class main {
    public static void main(String[] args){
        //setting up the main map
        System.out.println("Welcome to Lawrences game alpha testing version!");
        int masterRow = 7;
        int masterCol = 16;
        MapElement[][] mainMap = new MapElement[masterRow][masterCol]; //row,col one additional collum for player info
        //setting up the player
        Player player = new Player(mainMap);
        Scanner stringInput = new Scanner(System.in);
        Scanner intInput = new Scanner(System.in);
        System.out.println("Choose a character to represent you in the game");
        String character = stringInput.nextLine();
        System.out.println("You have the following choices(enter a number): \n1.Knight: easy mode \n2.Viking: hard mode");
        int choice = intInput.nextInt();
        if(choice == 1){
            //parameters:String Weapon, int HP, int Shield, String sign
            player = new Player("Sword", 100, 50, character, mainMap);
        }else if(choice == 2){
            player = new Player("Ax", 75, 25, character, mainMap);
        }

        mainMap[0][15] = new MapElement("HP: " + player.HP);
        mainMap[1][15] = new MapElement("Shield: " + player.Shield);
        mainMap[2][15] = new MapElement("Weapon: " + player.Weapon);
        setUPMap.mainMapSetUp(mainMap,player);
        //setting up enemy
        Enemy[] enemyArray = new Enemy[(int)(Math.random() * 4 + 2)];
        setUPMap.enemySetUp(enemyArray);
        System.out.println("num of enemy generated: " + enemyArray.length);
        //Print out the whole map for the first time
        setUPMap.printEverything(mainMap);
        //prepain the combat system
        CombatSys.setParameter(mainMap, enemyArray, player);
        //the game loop
        while (player.HP > 0){
            System.out.println("Pick a direction to move.(1 for up, 2 for down, 3 for left, 4 for right)");
            int moveDirection = intInput.nextInt();
            if(moveDirection >= 1 && moveDirection <= 4){
                player.move(moveDirection); 
                //updating the side bar
                mainMap[0][15].setSign("HP: " + player.HP);
                mainMap[1][15].setSign("Shield: " + player.Shield);
                //parameters detect(MapElement[][] map, Enemy[] enemys, Player P)
                
            }else{
                System.out.println("not a valid option");
            }
            setUPMap.printEverything(mainMap);
        }
        System.out.println("GG");
        stringInput.close();
        intInput.close();



    }
}
