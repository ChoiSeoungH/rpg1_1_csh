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

  public Unit(String name, int maxHp, int att, int def) {
    this.name = name;
    this.level = 1;
    this.hp = maxHp;
    this.maxHp = maxHp;
    this.att = att;
    this.def = def;
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

  public Item getWeapon() {
    return weapon;
  }

  public Item getArmor() {
    return armor;
  }

  public Item getRing() {
    return ring;
  }

  public void setParty(boolean party) {
    this.party = party;
  }

  public Item getItem(int kind) {
    Item item = null;
    if (kind == Item.WEAPON) {
      item= weapon;
    } else if (kind == Item.ARMOR) {
      item= armor;
    } else if (kind == Item.RING) {
      item= ring;
    }
    return item;
  }

  public void setItem(Item item) {
    if (item.getKind() == Item.WEAPON) {
      this.weapon = item;
    } else if (item.getKind() == Item.ARMOR) {
      this.armor = item;
    } else if (item.getKind() == Item.RING) {
      this.ring = item;
    }
  }

  @Override
  public String toString() {
    String data = String.format("[이름 : %s] [레벨 : %d]", name, level);
    data += ring == null ? String.format("[체력 : %d / %d]%n", hp, maxHp)
        : String.format("[체력 :%d(%d + %d) / %d(%d + %d)%n", hp + ring.getPower(), hp, ring.getPower(), maxHp + ring.getPower(), maxHp, ring.getPower());
    data += weapon == null ? String.format("[공격력 : %d]", att)
        : String.format("[공격력 : %d(%d + %d)]", att + weapon.getPower(), att, weapon.getPower());
    data += armor == null ? String.format("[방어력 : %d]", def)
        : String.format("[방어력 : %d(%d + %d)]", def + armor.getPower(), def, armor.getPower());
    data += String.format("[경험치 : %d] [파티중 : %b]%n", exp, party);
    data += weapon == null ? "[무기 : 없음 ]" : "[무기 : " + weapon.getName() + "]";
    data += armor == null ? "[방어구 : 없음 ]" : "[방어구 : " + armor.getName() + "]";
    data += ring == null ? "[반지 : 없음 ]" : "[반지 : " + ring.getName() + "]";
    return data;
  }

}
