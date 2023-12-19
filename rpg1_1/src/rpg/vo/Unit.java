package rpg.vo;

public class Unit {
  private String name;
  private int level;
  private int hp;
  private int maxHp;
  private int att;
  private int def;
  private int exp;
  private boolean party;
  private Item weapon;
  private Item armor;
  private Item ring;
  private int ItemNum;

  public Unit(String name, int maxHp, int att, int def) {
    this.name = name;
    this.level = 1;
    this.hp = maxHp;
    this.maxHp = maxHp;
    this.att = att;
    this.def = def;
  }

  public void setItemNum(int itemNum) {
    ItemNum = itemNum;
  }

  public String getName() {
    return name;
  }

  public int getLevel() {
    return level;
  }

  public int getHp() {
    return hp;
  }

  public int getMaxHp() {
    return maxHp;
  }

  public int getAtt() {
    return att;
  }

  public int getDef() {
    return def;
  }

  public int getExp() {
    return exp;
  }

  public boolean isParty() {
    return party;
  }

  public void setParty(boolean party) {
    this.party = party;
  }

  public Item getItem() {
    Item item = null;
    if (ItemNum == Item.WEAPON) {
      item= weapon;
    } else if (ItemNum == Item.ARMOR) {
      item= armor;
    } else if (ItemNum == Item.RING) {
      item= ring;
    }
    return item;
  }

  public void setItem(Item item) {
    if (ItemNum == Item.WEAPON) {
      this.weapon = item;
    } else if (ItemNum == Item.ARMOR) {
      this.armor = item;
    } else if (ItemNum == Item.RING) {
      this.ring = item;
    }
  }


  public void setRing(Item ring) {
    this.ring = ring;
  }

  public void setWeapon(Item weapon) {
    this.weapon = weapon;
  }

  public void setArmor(Item armor) {
    this.armor = armor;
  }

  @Override
  public String toString() {
    String data = String.format("[이름 : %s] [레벨 : %d]", name, level);
    data += ring == null ? String.format("[체력 : %d / %d]%n", hp, maxHp)
        : String.format("[체력 :%d(%d + %d) / %d(%d + %d%n)", hp + ring.getPower(), hp, ring.getPower(), maxHp + ring.getPower(), maxHp, ring.getPower());
    data += weapon == null ? String.format("[공격력 : %d]", att)
        : String.format("[공격력 : %d(%d + %d)]", att + weapon.getPower(), att, weapon.getPower());
    data += armor == null ? String.format("[방어력 : %d]", def)
        : String.format("[방어력 : %d(%d + %d)]", def + armor.getPower(), def, armor.getPower());
    data += String.format("[경험치 : %d] [파티중 : %b]%n", exp, party);
    data += weapon == null ? "[무기 : 없음 ]" : "[무기 : " + weapon.getName() + "]";
    data += armor == null ? "[방어구 : 없음 ]" : "[방어구 : " + armor.getName() + "]";
    data += ring == null ? "[반지 : 없음 ]" : "[반지 : " + ring.getName() + "]%n";
    return data;
  }

}
