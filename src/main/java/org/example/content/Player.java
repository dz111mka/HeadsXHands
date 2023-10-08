package org.example.content;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Player extends Creature{

    private static final int maxHealsLeftInit = 4;

    int maxHealsLeft = maxHealsLeftInit;

    public Player(String name, int hitPoints, int attack, int armor,  int minDamage, int maxDamage) {
        super(name, hitPoints, attack, armor, minDamage, maxDamage);
    }


    public void getHeal() {
        int resultHitPoints = (getMaxHitPoints() * 30 / 100) + getHitPoints();

        if (resultHitPoints > getMaxHitPoints()) {
            resultHitPoints = getMaxHitPoints();
        }
        setHitPoints(resultHitPoints);
        setMaxHealsLeft(getMaxHealsLeft() - 1);

    }



}