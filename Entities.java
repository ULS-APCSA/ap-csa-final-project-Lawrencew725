public class Entities extends MapElement  {
  public String Weapon = "none";
  public int HP = 100;
  public int Shield = 100;
  public Entities(){
    super("?", false);
  }

  public Entities(String Weapon, int HP, int Shield, String sign){
    super(sign, false);
    this.Weapon = Weapon;
    this.HP = HP;
    this.Shield = Shield;
    
  }


  // the damage methos that automatically acounts for the shield.
  public void damage(Entities gettingDamaged, int damageNumber){
    if (gettingDamaged.Shield < damageNumber){
      gettingDamaged.HP = gettingDamaged.HP - (damageNumber - gettingDamaged.Shield);
      gettingDamaged.Shield = 0;
    }else if(gettingDamaged.Shield > damageNumber){
      gettingDamaged.Shield -= damageNumber;
    }else{
      gettingDamaged.Shield = 0;
    }
  }

  public void interaction(){

  }

}
