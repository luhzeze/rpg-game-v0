import java.util.Random;
import java.util.Scanner;
import java.util.spi.AbstractResourceBundleProvider;

public class MainApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Введите имя вашего героя: ");
        String heroName = scanner.next();
        int heroHP = 10;
        int heroAttack = 4;
        int heroMoney = 100;

        String monsterName = "Орк";
        int monsterHP = 8;
        int monsterAttack = 3;
        System.out.println("Игра началась!");
        System.out.println("Герой " + heroName + " вошел в темный лес и видит перед собой монстра " + monsterName + ". Деваться некуда, придется вступить в бой.");
        System.out.println("Бой начался");

        while (true) {
            // Ход игрока
            System.out.println("Ход героя. Выберите действие: 1. Атаковать 2. Защищаться ");
            int command = scanner.nextInt();
            if (command == 1) {
                System.out.println("Герой атакует. Монстер " + monsterName + " получил " + heroAttack + " ед. урона");
                monsterHP -= heroAttack;
                if (random.nextInt(100) < 10) {
                    System.out.println("Герой смог нанести критичные " + heroAttack + " ед. урона.");
                    monsterHP -= heroAttack;
                }
                if (monsterHP <= 0) {
                    System.out.println("Победил герой " + heroName + "Герой получил в награду 1000 монет");
                    heroMoney += 1000;
                    break;
                }
            } else if (command == 2) {
                System.out.println("Герой " + heroName + " решил защищаться и залечил  1 ед. здоровья");
                heroHP++;
            } else {
                System.out.println("Вы пропускаете ход...");
            }
            System.out.println("Герой " + heroName + " имеет " + heroHP + " ед. здоровья. Монстр " + monsterName + " имеет " + monsterHP + " ед. здоровья.");

            //  Ход монстра
            System.out.println("Ход монстра.");
            int monsterCommand = random.nextInt(2);
            if (monsterCommand == 0) {
                System.out.println("Монстр атакует. Герой " + heroName + " получил " + monsterAttack + " ед. урона.");
                heroHP -= monsterAttack;
                if (heroHP <= 0) {
                    System.out.println("Победил монстр" + monsterName);
                    break;
                }
            } else if (monsterCommand == 1) {
                System.out.println("Монстр решил отступить и выпить зелье.");
                monsterHP += 5;
            }
            System.out.println("Герой " + heroName + " имеет " + heroHP + " ед. здоровья. Монстр " + monsterName + " имеет " + monsterHP + " ед. здоровья.");
        }

        System.out.println("Игра закончилась!");
    }
}
