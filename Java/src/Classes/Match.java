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

        //This code decides who will be first on the ball
        Random random = new Random();
        int teamWithTheBall = random.nextInt(2);

        int matchTimer = 0;

        System.out.printf("%s (%s %s) срещу %s (%s %s) \n", homeTeam.getNickname(), homeTeam.getName(), homeTeam.getCity(),
                                                            awayTeam.getNickname(), awayTeam.getName(), awayTeam.getCity());


        //That's the match itself
        while(matchTimer < 12){
            Scanner scan = new Scanner(System.in);
            int temp = matchTimer;

            if(matchTimer == 6){
                System.out.println("Second half begins!");
            }else if(matchTimer == 0){
                System.out.println("First Half begins!");
            }

            System.out.println("Match timer: " + 5 * ++temp + "'");

            switch(teamWithTheBall){
                case 0 -> {
                    if(playAttack(scoringChanceT1)){
                        resultAsIntegerArray[0]++;
                        //System.out.println("GOOOOOAALLLLL!");
                        System.out.println(homeTeam.getName() + " scored a goal");
                        //System.out.println("Result ");
                    }
                }
                case 1 -> {
                    if(playAttack(scoringChanceT2)){
                        resultAsIntegerArray[1]++;
                        //System.out.println("GOOOOOAALLLLL!");
                        System.out.println(awayTeam.getName() + " scored a goal");
                    }
                }
            }

            if(teamWithTheBall == 0){
                teamWithTheBall = 1;
            }else{
                teamWithTheBall = 0;
            }

            //This is used to freeze the program while the attack is going
            //When a button is pressed the code will proceed to the next attack
            String nextAttack = scan.nextLine();
            matchTimer++;
            resultAsString = homeTeam.getName()+ ' ' + String.valueOf(resultAsIntegerArray[0]) +
                    ':'
                    + resultAsIntegerArray[1] + ' ' + awayTeam.getName();
        }


    }

    public String getResult() {
        return resultAsString;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }
}