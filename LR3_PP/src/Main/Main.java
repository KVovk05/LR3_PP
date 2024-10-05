package Main;//1. Створіть базовий клас Droids.Droid, від якого будуть походити інші підкласи (види дроїдів),
//        які будуть відрізнятися різними характеристиками. Мінімальний набір характеристик:
//        name, health, damage.
//        2. Додайте можливість різних видів бою: 1 на 1, або команда на команду.
//        3. Класи потрібно грамотно розкласти по пакетах.
//        4. У програмі має бути консольне меню. Мінімальний набір команд:
//        −  створити дроїда (обраного виду);
//        − показати список створених дроїдів;
//        − запустити бій 1 на 1 (вибрати дроїдів, які будуть змагатися);
//        − запустити бій команда на команду (сформувати команди суперників з дроїдів,
//        яких ви створили у першому пункті);
//        −  записати проведений бій у файл;
//        − відтворити  проведений бій зі збереженого файлу;
//        − вийти з програми.
import Droids.Droid;
import Droids.FuriousDroid;
import Droids.HeavyDroid;
import Log.FightLogger;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
//methods

public class Main {
    static StringBuilder fightLog = new StringBuilder();  // for writing into file
    static void FightTeam(ArrayList<Droid> DroidsList){
        int whoHits;
        int amount = 0;
        Scanner sc = new Scanner(System.in);
        Droid[] Arr = DroidsList.toArray(new Droid[0]);
        Random rand = new Random();

        System.out.println("How many droids do you want to add in the first team?");
        amount = sc.nextInt();
        sc.nextLine();
        Droid[] Team1 = CreateTeam1(amount,DroidsList);;

        System.out.println("How many droids do you want to add in the second team?");
        amount = sc.nextInt();
        sc.nextLine();
        Droid[] Team2 = CreateTeam2(amount,DroidsList);
        System.out.println("    3-2-1 FIGHT!  ");
        fightLog.append("    3-2-1 FIGHT!  \n");
        System.out.println("  ______________________\n" +
                " /                      \\\n" +
                "|                        |   \n" +
                "|   \uD83E\uDD16 | vs | \uD83E\uDD16       |   \n" +
                "|                         |   \n" +
                "|  D1:"+Team1[0].getName()+" D2:"+ Team2[0].getName() +"           |\n" +
                "|  HP:" + (int) Team1[0].getHealth() + "       HP: " + (int) Team2[0].getHealth() + "   |\n" +
                "|________________________|\n" +
                " \\______________________/\n");

        while(Team1[0].IsAlive() && Team2[0].IsAlive()){
            whoHits = rand.nextInt(10);

                if (whoHits >= 5) {
                    Team1[0].Attack(Team2[0]);
                    System.out.println("Droid " + Team1[0].getName() + " Team1 attacks " + Team2[0].getName() + " team 2\t(Damage: "+ Team1[0].getDamage() +" " + Team2[0].getName() + " health:" + Team2[0].getHealth() + ")");
                    fightLog.append("Droid " + Team1[0].getName() + " Team1 attacks " + Team2[0].getName() + " team 2\t(Damage: "+ Team1[0].getDamage() +" " + Team2[0].getName() + " health:" + Team2[0].getHealth() + ")\n");
                } else {
                    Team2[0].Attack(Team1[0]);
                    System.out.println("Droid " + Team2[0].getName() + " Team2 attacks " + Team1[0].getName() + " team1\t(Damage: "+Team2[0].getDamage() +" " + Team1[0].getName() + " health:" + Team1[0].getHealth() + ")");
                    fightLog.append("Droid " + Team2[0].getName() + " Team2 attacks " + Team1[0].getName() + " team1\t(Damage: "+Team2[0].getDamage() +" " + Team1[0].getName() + " health:" + Team1[0].getHealth() + ")\n");
                }
            System.out.println("  ______________________\n" +
                    " /                      \\\n" +
                    "|                        |   \n" +
                    "|   \uD83E\uDD16 | vs | \uD83E\uDD16        |   \n" +
                    "|                       |   \n" +
                    "| D1:"+Team1[0].getName()+" D2:"+ Team2[0].getName() +"            |\n" +
                    "|  HP:" + (int) Team1[0].getHealth() + "       HP: " + (int) Team2[0].getHealth() + "     |\n" +
                    "|________________________|\n" +
                    " \\______________________/\n");
                if(!(Team1[0].IsAlive())){
                    for(int i = 0;i < Team1.length-1;i++){
                        Team1[i] = Team1[i + 1];
                    }
                }
                if(!(Team2[0].IsAlive())){
                    for(int i = 0;i < Team2.length-1;i++){
                        Team2[i] = Team2[i + 1];
                    }
                }
        }
        if(Team1[0].IsAlive()){
            System.out.println("\uD83C\uDF89Team 1 won!!\uD83C\uDF89");
            fightLog.append("Team1 1 won\n");
            System.out.println("  ______________________\n" +
                    " /                      \\\n" +
                    "|                        |   \n" +
                    "| \uD83C\uDFC6 | vs | \uD83D\uDCA5          |   \n" +
                    "|                       |   \n" +
                    "| D1:"+Team1[0].getName()+" D2:"+ Team2[0].getName() +"           |\n" +
                    "|  HP:" + (int) Team1[0].getHealth() + "       HP: " + (int) Team2[0].getHealth() + "     |\n" +
                    "|________________________|\n" +
                    " \\______________________/\n");

        }
        else if(Team2[0].IsAlive()){
            System.out.println("\uD83C\uDF89Team 2 won!!\uD83C\uDF89");
            fightLog.append("Team1 2 won\n");
            System.out.println("  ______________________\n" +
                    " /                      \\\n" +
                    "|                        |   \n" +
                    "| \uD83D\uDCA5  | vs |  \uD83C\uDFC6       |   \n" +
                    "|                         |   \n" +
                    "| D1:"+Team1[0].getName()+" D2:"+ Team2[0].getName() +"             |\n" +
                    "|  HP:" + (int) Team1[0].getHealth() + "       HP: " + (int) Team2[0].getHealth() + "     |\n" +
                    "|________________________|\n" +
                    " \\______________________/\n");

        }
        FightLogger.logFight("Fight.txt", fightLog.toString());
    }
    static Droid[]  CreateTeam1(int amount,ArrayList<Droid> DroidsList){
        String name;
        Droid[] Arr = DroidsList.toArray(new Droid[0]);
        Scanner sc = new Scanner(System.in);
        Droid Team1[] = new Droid[amount];

        for(int i = 0;i < amount;i++){
            System.out.println("Who you want to add in the first team as "+(i+1)+"player?");
            name = sc.nextLine();
            sc.nextLine();
            for(Droid droid:Arr){
                if(droid.getName().equals(name) && !(droid.isReserved())){
                    Team1[i] = droid;
                }

                else if(droid.isReserved()){
                    System.out.println("This droid is already in team");
                }
            }
        }
        return Team1;
    }
    static Droid[] CreateTeam2(int amount,ArrayList<Droid> DroidsList){
        String name;
        Droid[] Arr = DroidsList.toArray(new Droid[0]);
        Droid Team2[] = new Droid[amount];
        Scanner sc = new Scanner(System.in);
        for(int i = 0;i < amount;i++){
            System.out.println("Who you want to add in the second team as "+(i+1)+"player?");
            name = sc.nextLine();
            for(Droid droid:Arr){
                if(droid.getName().equals(name) && !(droid.isReserved())){
                    Team2[i] = droid;
                }
                else if(droid.isReserved()){
                    System.out.println("This droid is already in team");
                }
            }
        }
        return Team2;
    }
    static void Fight1V1(ArrayList<Droid> DroidsList){
        Random rand = new Random();
        Droid droid1 = ChooseFighter1(DroidsList);
        Droid droid2 = ChooseFighter2(DroidsList);
        int whoHits;

        System.out.println("    3-2-1 FIGHT!  ");
        fightLog.append("    3-2-1 FIGHT!  \n");
        System.out.println("  ______________________\n" +
                " /                      \\\n" +
                "|                        |\n" +
                "|   \uD83E\uDD16 | vs | \uD83E\uDD16         |    \n" +
                "|                        |   \n" +
                "|  D1:"+droid1.getName()+" D2:"+ droid2.getName() +"       |\n" +
                "|  HP:" + (int) droid1.getHealth() + "       HP: " + (int) droid2.getHealth() + "  |\n" +
                "|________________________|\n" +
                " \\______________________/\n");
        while(droid1.IsAlive() && droid2.IsAlive()){
            whoHits = rand.nextInt(10);
            if(whoHits >= 5){
                droid2.Attack(droid1);
                System.out.println(droid2.getName()+"attacks"+droid1.getName()+"\t"+ droid1.getName()+" health:"+ droid1.getHealth());
                fightLog.append(droid2.getName()+"attacks"+droid1.getName()+"\t"+ droid1.getName()+" health:"+ droid1.getHealth()+"\n");
            }
            else{
                droid1.Attack(droid2);
                System.out.println(droid1.getName()+" attacks "+droid2.getName()+"\t|"+ droid2.getName()+" health:"+ droid1.getHealth());
                fightLog.append(droid1.getName()+" attacks "+droid2.getName()+"\t|"+ droid2.getName()+"health:"+ droid1.getHealth()+"\n");
            }
            System.out.println("  ______________________\n" +
                    " /                      \\\n" +
                    "|                        |   \n" +
                    "|   \uD83E\uDD16 | vs | \uD83E\uDD16         |   \n" +
                    "|                        |   \n" +
                    "|  D1:"+droid1.getName()+" D2:"+ droid2.getName() +"       |\n" +
                    "|  HP:" + (int) droid1.getHealth() + "       HP: " + (int) droid2.getHealth() + "     |\n" +
                    "|________________________|\n" +
                    " \\______________________/\n");

        }
        if(droid1.IsAlive()){
            System.out.println(droid1.getName()+ " \uD83C\uDF89WON\uD83C\uDF89");
            fightLog.append(droid1.getName()+" won\n");
            System.out.println("  ______________________\n" +
                    " /                      \\\n" +
                    "|                        |   \n" +
                    "|   \uD83C\uDFC6 | vs | \uD83D\uDCA5         |   \n" +
                    "|                        |   \n" +
                    "|  D1:"+droid1.getName()+" D2:"+ droid2.getName() +"       |\n" +
                    "|  HP:" + (int) droid1.getHealth() + "       HP: " + (int) droid2.getHealth() + "     |\n" +
                    "|________________________|\n" +
                    " \\______________________/\n");
        }
        else if(droid2.IsAlive()){
            System.out.println(droid2.getName()+" \uD83C\uDF89WON\uD83C\uDF89");
            fightLog.append(droid2.getName()+" won\n");
            System.out.println("  ______________________\n" +
                    " /                      \\\n" +
                    "|                        |   \n" +
                    "|   \uD83D\uDCA5 | vs | \uD83C\uDFC6         |   \n" +
                    "|                        |   \n" +
                    "|  D1:"+droid1.getName()+" D2:"+ droid2.getName() +"       |\n" +
                    "|  HP:" + (int) droid1.getHealth() + "       HP: " + (int) droid2.getHealth() + "     |\n" +
                    "|________________________|\n" +
                    " \\______________________/\n");
        }
        FightLogger.logFight("Fight.txt", fightLog.toString());

    }
    static Droid ChooseFighter1(ArrayList<Droid> DroidsList){
        String name1;
        Droid droid1 = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose your first fighter");
        name1 = sc.nextLine();

        for(Droid droid: DroidsList){
            if(droid.getName().equals(name1)){
                droid1 = droid;
            }

        }
        return droid1;
    }
    static Droid ChooseFighter2(ArrayList<Droid> DroidsList){
        String name2;
        Scanner sc = new Scanner(System.in);
        Droid droid2 = null;

        System.out.println("Choose your second fighter");
        name2 = sc.nextLine();
        for(Droid droid: DroidsList){

             if(droid.getName().equals(name2)){
                droid2 = droid;
            }
        }
        return droid2;
    }

    static void DroidList(ArrayList<Droid> DroidsList){
        for(int i = 0;i < DroidsList.size();i++){
            System.out.println("Droids.Droid" + (i+1) + ":" + DroidsList.get(i).getName());
        }
    }
    static void WriteBattle(){

        System.out.println("\nBattle has already written\n");
    }
    static void CreateDroid(ArrayList<Droid> DroidsList){
        int menu;
        int droidAmount;
        Scanner sc = new Scanner(System.in);
        System.out.println("How many droids would you like to create?");
        droidAmount = sc.nextInt();
        for(int i = 0;i < droidAmount;i++){
            System.out.println("\nChoose droid type:\n 1.Common Droid,\n2.HeavyDroid\n3.FuriousDroid ");
            menu = sc.nextInt();
            switch(menu){
                case 1:
                    DroidsList.add(CreateCommonDroid());
                    break;
                case 2:
                    DroidsList.add(CreateHeavyDroid());
                    break;
                case 3:
                    DroidsList.add(CreateFuriousDroid());
                    break;


            }
        }


    }
    static Droid CreateCommonDroid(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter droid name");
        String name = sc.nextLine();

        Droid droid = new Droid();
        droid.setHealth(100);
        droid.setDamage(30);
        droid.setName(name);
        return droid;
    }
    static HeavyDroid CreateHeavyDroid(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter droid name");
        String name = sc.nextLine();

        HeavyDroid droid = new HeavyDroid();

        droid.setHealth(100);
        droid.setDamage(15);
        droid.setName(name);
        droid.setShieldHealth(200);
        return droid;
    }
    static FuriousDroid CreateFuriousDroid(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter droid name");
        String name = sc.nextLine();

        FuriousDroid droid = new FuriousDroid();
        droid.setDamageMultiplCoeff(1.7);
        droid.setHealth(60);
        droid.setDamage(30*1.7);
        droid.setName(name);

        return droid;
    }
    static void ReadBattle(){
        FightLogger.readFightLog("Fight.txt");
    }
    public static void main(String[] args){
        ArrayList <Droid> DroidsList = new ArrayList<Droid>();
        int menu = 0;
        Scanner sc = new Scanner(System.in);


     while(menu != 7){
     System.out.println("1.Create droid");
        System.out.println("2. Show list of created droids");
        System.out.println("3. Start 1vs1 fight");
        System.out.println("4. Start team on team fight");
        System.out.println("5.Write battle into file");
        System.out.println("6.Read battle from file");
        System.out.println("7.Exit");
        menu = sc.nextInt();
        switch(menu){
        case 1->CreateDroid(DroidsList);
            case 2->DroidList(DroidsList);
            case 3->Fight1V1(DroidsList);
            case 4->FightTeam(DroidsList);
             case 5->WriteBattle();
             case 6->ReadBattle();
        }
    }
    }
}
