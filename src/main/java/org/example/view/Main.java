package org.example.view;

import org.example.content.Monster;
import org.example.content.Player;

public class Main {


    public static void main(String[] args) throws InterruptedException{
        Player player = new Player("HiMan", 100, 30, 20, 1, 15);
        Monster monster = new Monster("Godzilla", 100, 30, 20, 1, 15);
        Battle battle = new Battle(player, monster);
        battle.startBattle();
    }
}