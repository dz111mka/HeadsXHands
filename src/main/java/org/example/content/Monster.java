package org.example.content;

import lombok.AllArgsConstructor;


public class Monster extends Creature {
    public Monster(String name, int maxHitPoints, int attack, int armor, int minDamage, int maxDamage) {
        super(name, maxHitPoints, attack, armor, minDamage, maxDamage);
    }
}
