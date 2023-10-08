package org.example.content;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class Creature {
    static final int maxHitPointsInit = 100;

    static final int maxArmor = 30;
    static final int minArmor = 1;
    static final int maxAttack = 30;
    static final int minAttack = 1;
    static final int minDamageInit = 1;
    static final int maxDamageInit = 15;

    final String name;
    final int attack;
    final int armor;
    final int maxHitPoints;
    int hitPoints;

    final int minDamage;
    final int maxDamage;


    public void setHitPoints(int hitPoints) {
        if (hitPoints > maxHitPoints) throw new IllegalArgumentException("More than max hit points");
        this.hitPoints = hitPoints;
    }

    public Creature(String name, int maxHitPoints, int attack, int armor, int minDamage, int maxDamage) {
        if (armor > maxArmor) throw new IllegalArgumentException("More than max armor");
        if (attack > maxAttack) throw new IllegalArgumentException("More than max attack");
        if (maxHitPoints > maxHitPointsInit) throw new IllegalArgumentException("More than max hit points");
        if (minDamage > minDamageInit) throw new IllegalArgumentException("More than min damage");
        if (maxDamage > maxDamageInit) throw new IllegalArgumentException("More than max damage");
        this.attack = attack;
        this.armor = armor;
        this.name = name;
        this.maxDamage = maxDamage;
        this.minDamage = minDamage;
        this.maxHitPoints = maxHitPoints;
        setHitPoints(maxHitPoints);
    }
}