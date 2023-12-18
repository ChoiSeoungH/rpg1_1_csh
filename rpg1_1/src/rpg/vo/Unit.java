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

  public void setWeapon(Item weapon) {
    this.weapon = weapon;
  }

  public void setArmor(Item armor) {
    this.armor = armor;
  }

  public void setRing(Item ring) {
    this.ring = ring;
  }

  public Unit(String name, int level, int maxHp, int att, int def, int exp) {
    this.name = name;
    this.level = level;
    this.hp = maxHp;
    this.maxHp = maxHp;
    this.att = att;
    this.def = def;
    this.exp = exp;
  }

  @Override
  public String toString() {
    String data = String.format("[이름 : %s] [레벨 : %d]",name,level);
    data += ring==null ? String.format("[체력 : %d / %d]%n", hp,maxHp)
        : String.format("[체력 :%d(%d + %d) / %d(%d + %d%n)",hp+ring.getPower(),hp,ring.getPower(),maxHp+ring.getPower(),maxHp,ring.getPower() );
    data += weapon==null ? String.format("[공격력 : %d]", att)
        : String.format("[공격력 : %d(%d + %d)]",att+weapon.getPower(),att,weapon.getPower());
    data += armor==null ? String.format("[방어력 : %d]", def)
        : String.format("[방어력 : %d(%d + %d)]",def+armor.getPower(),def,armor.getPower());
    data += String.format("[경험치 : %d] [파티중 : %b]%n", exp, party);
    data += weapon == null ? "[무기 : 없음 ]" : "[무기 : " + weapon.name + "]";
    data += armor == null ? "[방어구 : 없음 ]" : "[방어구 : " + armor.name + "]";
    data += ring == null ? "[반지 : 없음 ]" : "[반지 : " + ring.name + "]";
    return data;
  }


}
