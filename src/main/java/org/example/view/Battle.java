package org.example.view;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.content.Creature;
import org.example.content.Monster;
import org.example.content.Player;

import java.util.Random;
import java.util.Scanner;

@Setter
@Getter
@RequiredArgsConstructor
public class Battle {

    public static Random random = new Random();
    private boolean turnPlayer = true;
    private int turn = 1;
    private final Player player;
    private final Monster monster;

    public void startBattle() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Thread.sleep(500);
            if (turnPlayer) {
                System.out.println("Ход игрока! Номер хода " + turn);
                System.out.println("Здоровье игрока: " + player.getHitPoints() + " Здоровье противника: " + monster.getHitPoints());
                System.out.println("Атака игрока: " + player.getAttack() + " Атака противника: " + monster.getAttack());
                System.out.println("Защита игрока: " + player.getArmor() + " Защита противника: " + monster.getArmor());
                System.out.println("-----------------------------------------");
                System.out.println("1. Нанести атаку");
                System.out.println("2. Выпить исциляющее зелье");
                System.out.println("3. Ничего не делать");
                System.out.println("0. Выход\n\n");
            } else {
                System.out.println("Ход противника! Номер хода " + turn);
                System.out.println("Здоровье игрока: " + player.getHitPoints() + " Здоровье противника: " + monster.getHitPoints());
                System.out.println("Атака игрока: " + player.getAttack() + " Атака противника: " + monster.getAttack());
                System.out.println("Защита игрока: " + player.getArmor() + " Защита противника: " + monster.getArmor());
                System.out.println("-----------------------------------------");
            }


            if (turnPlayer) {
                int command = scanner.nextInt();

                switch (command) {
                    case 1 -> {
                        toAttack(player, monster);
                        setTurnPlayer();
                    }
                    case 2 -> {
                        if (player.getMaxHealsLeft() > 0) {
                            player.getHeal();
                        }
                        setTurnPlayer();
                    }
                    case 3 -> {
                        System.out.println("Вы стоите и ничего не делаете!");
                        setTurnPlayer();
                    }
                    case 0 -> System.exit(0);
                    default -> System.out.println("Команда не распознана");
                }
            } else {
                if (random.nextInt(2) == 1) toAttack(monster, player);
                setTurnPlayer();
            }
        }
    }

    static int attackModifier(int attack, int defence) {
        return attack - defence + 1;
    }

    static void toAttack(Creature attacker, Creature defender) {
        int N = attackModifier(attacker.getAttack(), defender.getArmor());
        if (N > 1) {
            for (int i = 1; i <= N; i++) {
                if (random.nextInt(7) >= 5) {
                    defender.setHitPoints(defender.getHitPoints() - random.nextInt(attacker.getMaxDamage() - attacker.getMinDamage()) + attacker.getMinDamage());
                    if (defender.getHitPoints() <= 0) {
                        System.out.println(attacker.getName() + " победил! " + defender.getName() + " убит!");
                        if (attacker instanceof Player) {
                            ((Player) attacker).setMaxHealsLeft(4);
                        }
                        attacker.setHitPoints(100);
                        defender.setHitPoints(100);
                        System.exit(0);
                    }
                    break;
                }
            }
        }
    }
    public void setTurnPlayer() {
        turn++;
        turnPlayer = !turnPlayer;
    }

}