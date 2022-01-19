package Classes;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Match {
    private Team homeTeam;
    private Team awayTeam;
    private String resultAsString;
    private int[] resultAsIntegerArray = new int[2];
    HashMap<Boolean, Double> scoringChanceTable;
    private int scoringChanceT1;
    private int scoringChanceT2;
    String winningMessage;


    //===================================================== CONSTRUCTORS ======================================================================
    public Match(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        //+0.1 is the home advantage
        double potentialDiffWhenT1IsAttacking = homeTeam.calculateAttackingPotential() - awayTeam.calculateDefensivePotential() + 0.1;
        double potentialDiffWhenT2IsAttacking = awayTeam.calculateAttackingPotential() - homeTeam.calculateDefensivePotential();
        scoringChanceT1 = calculateChanceBasedOnPotentialDifferenceInPercentage(potentialDiffWhenT1IsAttacking);
        scoringChanceT2 = calculateChanceBasedOnPotentialDifferenceInPercentage(potentialDiffWhenT2IsAttacking);
    }

    public Match() {
    }


    //===================================================== GETTERS ======================================================================
    public String getResult() {
        return resultAsString;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public String getWinningMessage() {
        return winningMessage;
    }


    //===================================================== SETTERS ======================================================================
    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }


    //===================================================== METHODS ======================================================================
    private int calculateChanceBasedOnPotentialDifferenceInPercentage(double potDiff){
        if(potDiff < -2){
            return 10;
        }else if(potDiff >= 2 && potDiff < -1){
            return 20;
        }else if(potDiff >= -1 && potDiff < -0.5){
            return 25;
        }else if(potDiff >= -0.5 && potDiff < 0){
            return 30;
        }else if(potDiff >= 0 && potDiff < 1){
            return 40;
        }else if(potDiff >= 1 && potDiff <= 2){
            return 45;
        }else if(potDiff > 2){
            return 50;
        }

        return 0;
    }

    public boolean playAttack(int scoringChance){
        Random random = new Random();
        int scoringSituation = random.nextInt(101);

        if(scoringSituation < scoringChance){
            return true;
        }

        return false;
    }

    public void playMatch(){

        //Решаване кой ще е пръв с топката
        Random random = new Random();
        int teamWithTheBall = random.nextInt(2);

        int matchTimer = 0;

        System.out.printf("%s %s (%s) срещу %s %s (%s) \n",  homeTeam.getName(), homeTeam.getCity(),homeTeam.getNickname(),
                                                            awayTeam.getName(), awayTeam.getCity(), awayTeam.getNickname());


        //Мачът
        while(matchTimer < 12){
            int temp = matchTimer;
            Scanner scan = new Scanner(System.in);


            if(matchTimer == 0){
                System.out.print("НАЧАЛО НА ПЪРВОТО ПОЛУВРЕМЕ!");
                System.out.println();
            }else if(matchTimer == 6){
                System.out.println("НАЧАЛО НА ВТОРОТО ПОЛУВРЕМЕ!");
                if(teamWithTheBall == 0){
                    teamWithTheBall = 1;
                }else{
                    teamWithTheBall = 0;
                }
            }

            System.out.println("ТАЙМЕР: " + 5 * ++temp + "' минута");

            switch(teamWithTheBall){
                case 0 -> {
                    if(playAttack(scoringChanceT1)){
                        resultAsIntegerArray[0]++;
                        System.out.println(homeTeam.getName() + " отбелязаха гол!");
                    }
                }
                case 1 -> {
                    if(playAttack(scoringChanceT2)){
                        resultAsIntegerArray[1]++;
                        System.out.println(awayTeam.getName() + " отбелязаха гол!");

                    }
                }
            }

            resultAsString = homeTeam.getName()+ ' ' + String.valueOf(resultAsIntegerArray[0]) +
                    ':'
                    + resultAsIntegerArray[1] + ' ' + awayTeam.getName();

            System.out.println(resultAsString);

            if(teamWithTheBall == 0){
                teamWithTheBall = 1;
            }else{
                teamWithTheBall = 0;
            }

            //Използва се за замразяване на програмата
            //Когато някой бутон бива натиснат програмата продължава
            String nextAttack = scan.nextLine();
            matchTimer++;

        }

        if(resultAsIntegerArray[0] > resultAsIntegerArray[1]){
            winningMessage = homeTeam.getNickname() + " победиха " + awayTeam.getNickname() + " и взеха 3-те точки";
        }else if(resultAsIntegerArray[0] < resultAsIntegerArray[1]){
            winningMessage = awayTeam.getNickname() + " победиха " + homeTeam.getNickname() + " и взеха 3-те точки";
        }else{
            winningMessage = "Двата отбора не успяха да се победят";
        }
    }
}