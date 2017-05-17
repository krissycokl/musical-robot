package com.sg.OneOffs;

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

    public static void main(String[] args) {
        Random ran = new Random();
        Scanner sc = new Scanner(System.in);

        int rounds;
        int curRound;
        int ansUser;
        int ansComp;
        String again;

        int numWins = 0;
        int numLosses = 0;
        int numTies = 0;

        System.out.println("How many rounds do you want to play?");
        rounds = Integer.parseInt(sc.nextLine());

        // Check if the user entered valid # of rounds
        if (rounds >= 1 && rounds <= 10) {

            // While user hasn't played all rounds
            for (curRound = 0; curRound < rounds; curRound++) {
                System.out.println("\nPlease choose between");
                System.out.println("1.) Rock");
                System.out.println("2.) Paper, or");
                System.out.println("3.) Scissors");

                ansUser = Integer.parseInt(sc.nextLine());
                System.out.println("You picked " + printHand(ansUser) + ".");
                ansComp = ran.nextInt(3) + 1;

                if (ansUser == ansComp) {
                    System.out.println("Computer also picked " + printHand(ansComp) + ".\n");
                    showHands(ansUser,ansComp);
                    numTies++;
                    System.out.println("\nIt's a tie!");
                    System.out.println("You've won " + numWins + " time" + pluralHandler(numWins) + ", "
                            + "lost " + numLosses + " time" + pluralHandler(numLosses) + ", and "
                            + "tied " + numTies + " time" + pluralHandler(numTies) + ".");
                } else {
                    System.out.println("Computer picked " + printHand(ansComp) + ".\n");
                    showHands(ansUser,ansComp);
                    if (ansUser == 1 && ansComp == 2) {
                        // User: rock, Comp: paper
                        numLosses = lossHandler(numWins, numLosses, numTies);
                    } else if (ansUser == 1 && ansComp == 3) {
                        // User: rock, Comp: scissors
                        numWins = winHandler(numWins, numLosses, numTies);
                    } else if (ansUser == 2 && ansComp == 1) {
                        // User: paper, Comp: rock
                        numWins = winHandler(numWins, numLosses, numTies);
                    } else if (ansUser == 2 && ansComp == 3) {
                        // User: paper, Comp: scissors
                        numLosses = lossHandler(numWins, numLosses, numTies);
                    } else if (ansUser == 3 && ansComp == 1) {
                        // User: scissors, Comp: rock
                        numLosses = lossHandler(numWins, numLosses, numTies);
                    } else if (ansUser == 3 && ansComp == 2) {
                        // User: scissors, Comp: paper
                        numWins = winHandler(numWins, numLosses, numTies);
                    } else {
                        System.out.println("Error!");
                    }
                }

                if (curRound == rounds - 1) {
                    if (numWins > numLosses) { overall(1); }
                    else if (numWins < numLosses){ overall(2); }
                    else { overall(3); }
                    System.out.println("\nPlay again? (y/n)");

                    again = sc.nextLine().toLowerCase();

                    if (again.equals("y")) {
                        // Must set curRound to -1 because it increments
                        // when the loop finishes.
                        curRound = -1;
                        numWins = 0;
                        numTies = 0;
                        numLosses = 0;

                        System.out.println("\nHow many rounds do you want to play?");
                        rounds = Integer.parseInt(sc.nextLine());

                        if (rounds < 1 || rounds > 10) {
                            System.out.println("Error: number of rounds should "
                                    + "be between 1 and 10.");
                            break;
                        }

                    } else {
                        System.out.println("\nThanks for playing!");
                    }
                }
            }

        } else {
            System.out.println("Error: number of rounds should be between"
                    + " 1 and 10.");
        }
    }

    public static int winHandler(int numWins, int numLosses, int numTies) {
        System.out.println("\nYou win this match!");
        numWins++;
        System.out.println("You've won " + numWins + " time" + pluralHandler(numWins) + ", "
                + "lost " + numLosses + " time" + pluralHandler(numLosses) + ", and "
                + "tied " + numTies + " time" + pluralHandler(numTies) + ".");
        return numWins;
    }

    public static int lossHandler(int numWins, int numLosses, int numTies) {
        System.out.println("\nYou lose this match!");
        numLosses++;
        System.out.println("You've won " + numWins + " time" + pluralHandler(numWins) + ", "
                + "lost " + numLosses + " time" + pluralHandler(numLosses) + ", and "
                + "tied " + numTies + " time" + pluralHandler(numTies) + ".");
        return numLosses;
    }

    public static String printHand(int hand) {
        switch (hand) {
            case 1:
                return "rock";
            case 2:
                return "paper";
            case 3:
                return "scissors";
        }
        return "an invalid value";
    }

    public static String pluralHandler(int number) {
        if (number == 1) {
            return "";
        } else {
            return "s";
        }
    }
    
    public static void showHands(int hand1, int hand2) {
        if (hand1==1 && hand2==1){
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMMMMMMNdyo+/:::/ohNMMMMMMMMMMMMMMMMMMMMMMMMMMMNho/:::/+oydNMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMMNh+-      ``    .sMMMMMMMMMMMMMMMMMMMMMMMMMs.    ``      -+hNMMMMMMMMMMM\n" +
"MMMMNhoyMd+`          -/+:.``oMMMMMMMMMMMMMMMMMMMMMMMo``.:+/-          `+dMyohNMMMM\n" +
"MMMh. om/               ./oossdhyydNMMMMMMMMMMMNdyyhdssoo/.               /mo .hMMM\n" +
"MMd` oN.`.`````                    `+NMMMMMMMN+`                    `````.`.No `dMM\n" +
"MM- .N/ :sssyys:                     yMMMMMMMy                     :syysss: /N. -MM\n" +
"Mh  ym  -.``                        :NMMMMMMMN:                        ``.-  my  hM\n" +
"Mo  No  +ssssoo+:.          `.-:/+ohNMMMMMMMMMNho+/:-.`          .:+oossss+  oN  oM\n" +
"My `M/ .s/.`..-:/:          `.----.-+NMMMMMMMN+-.----.`          :/:-..`./s. /M` yM\n" +
"MMo-Ny  -+sys+-                      oMMMMMMMo                      -+sys+-  yN-oMM\n" +
"MMMNMMo`   `.:-                      sMMMMMMMs                      -:.`   `oMMNMMM\n" +
"MMMMMMMd:                          .oNMMMMMMMNo.                          :dMMMMMMM\n" +
"MMMMMMMMNh/`              `-/+ossdmNMMMMMMMMMMMNmdsso+/-`              `/hNMMMMMMMM\n" +
"MMMMMMMMMMMNy/.               ``oMMMMMMMMMMMMMMMMMo``               ./yNMMMMMMMMMMM\n" +
"MMMMMMMMMMMMMMMNhs+/:-.....-:+smMMMMMMMMMMMMMMMMMMMms+:-.....-:/+shNMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
        } else if(hand1==1 && hand2==2){
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNNMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMMMMMMNdyo+/:::/ohNMMMMMMMMMMMMMMMMMMMMMMMMMMy.   :yMMMMMMMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMMNh+-      ``    .sMMMMMMMMMMMMMMMMMMMMMMMMMh`     :mMMMMMMMMMMMMMMMMMMMM\n" +
"MMMMNhoyMd+`          -/+:.``oMMMMMMMMMMMMMMMMMMMMMMMMMN+      oMMMMMMMMMMMNdhdmMMM\n" +
"MMMh. om/               ./oossdhyydNMMMMMMMMMMNs/:/odMMMMh`     .hMMMMMMMN/     NMM\n" +
"MMd` oN.`.`````                    `+NMMMMMMMM`      `/smMm-      :dMMMMM:     /MMM\n" +
"MM- .N/ :sssyys:                     yMMMMMMMMd+.        .odo       :dMMN     -NMMM\n" +
"Mh  ym  -.``                        :NMMMMMMMMMMMmo.        :y`       -sh    `NMMMM\n" +
"Mo  No  +ssssoo+:.          `.-:/+ohNMMMMMMMMMMMMMMMmo.      `/              `MMMMM\n" +
"My `M/ .s/.`..-:/:          `.----.-+NMMMMMMNo:-/+sydmmh:                     dMMMM\n" +
"MMo-Ny  -+sys+-                      oMMMMMMN/.        `+s.             `     sMMMM\n" +
"MMMNMMo`   `.:-                      sMMMMMMMMMmy+-`      -         /:  :h+`  shmMM\n" +
"MMMMMMMd:                          .oNMMMMMMMMMMMMMMds/`            `+yo- :y-`m.:MM\n" +
"MMMMMMMMNh/`              `-/+ossdmNMMMMMMMMMMMMMMMMMMMMdo.        -s/`.+s: -d: hMM\n" +
"MMMMMMMMMMMNy/.               ``oMMMMMMMMMMMMMMMMMMMMMMMMMMh/`      `:+s+ `sy``hMMM\n" +
"MMMMMMMMMMMMMMMNhs+/:-.....-:+smMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMds/-.`  `.:sy-`+NMMMM\n" +
"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMyshNMMMMMM");
        } else if(hand1==1 && hand2==3){
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMMMMMMNdyo+/:::/ohNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMmhsoossydNMMMMMMMMMMM\n" +
"MMMMMMMMMMMNh+-      ``    .sMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMs.  `       ./yy:-sNMMM\n" +
"MMMMNhoyMd+`          -/+:.``oMMMMMMMMMMMMMMMMMMMMMMMMMMMMM+``:/`         `.sy`.dMM\n" +
"MMMh. om/               ./oossdhyydNMMMMMMMMMMMMMMMMMMMNNNmso+-       `/+oo: /h``mM\n" +
"MMd` oN.`.`````                    `+NMMMMMMMMmhyo+//::--.`           `-..-+/ +h :M\n" +
"MM- .N/ :sssyys:                     yMMMMMMN+`                       :+oo/:/- d::M\n" +
"Mh  ym  -.``                        :NMMMMMMy       ````.....`        -.`-os/` dmNM\n" +
"Mo  No  +ssssoo+:.          `.-:/+ohNMMMMMMMNsosyhhddddho/:-.`           /.   oMMMM\n" +
"My `M/ .s/.`..-:/:          `.----.-+NMMMMMMMMMMMMMNh+-`                    `sMMMMM\n" +
"MMo-Ny  -+sys+-                      oMMMMMMMMMMmy/.          `..         .+mMMMMMM\n" +
"MMMNMMo`   `.:-                      sMMMMMMMMMs`        -/shy/-`      ./yNMMMMMMMM\n" +
"MMMMMMMd:                          .oNMMMMMMMMM      -+hNNMMMNmhsoooshmNMMMMMMMMMMM\n" +
"MMMMMMMMNh/`              `-/+ossdmNMMMMMMMMMMMo--+yNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMMNy/.               ``oMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMMMMMMNhs+/:-.....-:+smMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
        } else if(hand1==2 && hand2==1){
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMNNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMMMMMMMMMMMMMy:   .yMMMMMMMMMMMMMMMMMMMMMMMMMMNho/:::/+oydNMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMMMMMMMMMMMm:     `hMMMMMMMMMMMMMMMMMMMMMMMMMs.    ``      -+hNMMMMMMMMMMM\n" +
"MMMmdhdNMMMMMMMMMMMo      +NMMMMMMMMMMMMMMMMMMMMMMMMMo``.:+/-          `+dMyohNMMMM\n" +
"MMN     /NMMMMMMMh.     `hMMMMdo/:/sNMMMMMMMMMMNdyyhdssoo/.               /mo .hMMM\n" +
"MMM/     :MMMMMd:      -mMms/`      `MMMMMMMMN+`                    `````.`.No `dMM\n" +
"MMMN-     NMMd:       odo.        .+dMMMMMMMMy                     :syysss: /N. -MM\n" +
"MMMMN`    hs-       `y:        .omMMMMMMMMMMMN:                        ``.-  my  hM\n" +
"MMMMM`              /`      .omMMMMMMMMMMMMMMMNho+/:-.`          .:+oossss+  oN  oM\n" +
"MMMMd                     :hmmdys+/-:oNMMMMMMN+-.----.`          :/:-..`./s. /M` yM\n" +
"MMMMs     `             .s+`        ./NMMMMMMo                      -+sys+-  yN-oMM\n" +
"MMmhs  `+h:  :/         -      `-+ymMMMMMMMMMs                      -:.`   `oMMNMMM\n" +
"MM:.m`-y: -oy+`            `/sdMMMMMMMMMMMMMMNo.                          :dMMMMMMM\n" +
"MMh :d- :s+.`/s-        .odMMMMMMMMMMMMMMMMMMMMNmdsso+/-`              `/hNMMMMMMMM\n" +
"MMMh``ys` +s+:       `/hMMMMMMMMMMMMMMMMMMMMMMMMMMo``               ./yNMMMMMMMMMMM\n" +
"MMMMN+`-ys:.`  `.-/sdMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMms+:-.....-:/+shNMMMMMMMMMMMMMMM\n" +
"MMMMMMNhsyMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
        } else if(hand1==2 && hand2==2){
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMNNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNNMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMMMMMMMMMMMMMy:   .yMMMMMMMMMMMMMMMMMMMMMMMMMy.   :yMMMMMMMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMMMMMMMMMMMm:     `hMMMMMMMMMMMMMMMMMMMMMMMMMh`     :mMMMMMMMMMMMMMMMMMMMM\n" +
"MMMmdhdNMMMMMMMMMMMo      +NMMMMMMMMMMMMMMMMMMMMMMMMMMMN+      oMMMMMMMMMMMNdhdmMMM\n" +
"MMN     /NMMMMMMMh.     `hMMMMdo/:/sNMMMMMMMMMNs/:/odMMMMh`     .hMMMMMMMN/     NMM\n" +
"MMM/     :MMMMMd:      -mMms/`      `MMMMMMMMM`      `/smMm-      :dMMMMM:     /MMM\n" +
"MMMN-     NMMd:       odo.        .+dMMMMMMMMMd+.        .odo       :dMMN     -NMMM\n" +
"MMMMN`    hs-       `y:        .omMMMMMMMMMMMMMMMmo.        :y`       -sh    `NMMMM\n" +
"MMMMM`              /`      .omMMMMMMMMMMMMMMMMMMMMMmo.      `/              `MMMMM\n" +
"MMMMd                     :hmmdys+/-:oNMMMMMNo:-/+sydmmh:                     dMMMM\n" +
"MMMMs     `             .s+`        ./NMMMMMN/.        `+s.             `     sMMMM\n" +
"MMmhs  `+h:  :/         -      `-+ymMMMMMMMMMMMmy+-`      -         /:  :h+`  shmMM\n" +
"MM:.m`-y: -oy+`            `/sdMMMMMMMMMMMMMMMMMMMMMds/`            `+yo- :y-`m.:MM\n" +
"MMh :d- :s+.`/s-        .odMMMMMMMMMMMMMMMMMMMMMMMMMMMMMdo.        -s/`.+s: -d: hMM\n" +
"MMMh``ys` +s+:       `/hMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMh/`      `:+s+ `sy``hMMM\n" +
"MMMMN+`-ys:.`  `.-/sdMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMds/-.`  `.:sy-`+NMMMM\n" +
"MMMMMMNhsyMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMyshNMMMMMM");
        } else if(hand1==2 && hand2==3){
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMNNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMMMMMMMMMMMMMy:   .yMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMmhsoossydNMMMMMMMMMMM\n" +
"MMMMMMMMMMMMMMMMMMMMm:     `hMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMs.  `       ./yy:-sNMMM\n" +
"MMMmdhdNMMMMMMMMMMMo      +NMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM+``:/`         `.sy`.dMM\n" +
"MMN     /NMMMMMMMh.     `hMMMMdo/:/sNMMMMMMMMMMMMMMMMMMNNNmso+-       `/+oo: /h``mM\n" +
"MMM/     :MMMMMd:      -mMms/`      `MMMMMMMMMmhyo+//::--.`           `-..-+/ +h :M\n" +
"MMMN-     NMMd:       odo.        .+dMMMMMMMN+`                       :+oo/:/- d::M\n" +
"MMMMN`    hs-       `y:        .omMMMMMMMMMMy       ````.....`        -.`-os/` dmNM\n" +
"MMMMM`              /`      .omMMMMMMMMMMMMMNsosyhhddddho/:-.`           /.   oMMMM\n" +
"MMMMd                     :hmmdys+/-:oNMMMMMMMMMMMMNh+-`                    `sMMMMM\n" +
"MMMMs     `             .s+`        ./NMMMMMMMMMmy/.          `..         .+mMMMMMM\n" +
"MMmhs  `+h:  :/         -      `-+ymMMMMMMMMMMMs`        -/shy/-`      ./yNMMMMMMMM\n" +
"MM:.m`-y: -oy+`            `/sdMMMMMMMMMMMMMMMM      -+hNNMMMNmhsoooshmNMMMMMMMMMMM\n" +
"MMh :d- :s+.`/s-        .odMMMMMMMMMMMMMMMMMMMMo--+yNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
"MMMh``ys` +s+:       `/hMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
"MMMMN+`-ys:.`  `.-/sdMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
"MMMMMMNhsyMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
        } else if(hand1==3 && hand2==1){
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMMNdyssooshmMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNho/:::/+oydNMMMMMMMMMMMMMMM\n" +
"MMMNs-:yy/.       `  .sMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMs.    ``      -+hNMMMMMMMMMMM\n" +
"MMd.`ys.`         `/:``+MMMMMMMMMMMMMMMMMMMMMMMMMMMMMo``.:+/-          `+dMyohNMMMM\n" +
"Mm``h/ :oo+/`       -+osmNNNMMMMMMMMMMMMMMMMMMMNdyyhdssoo/.               /mo .hMMM\n" +
"M: h+ /+-..-`           `.--:://+oyhmMMMMMMMMN+`                    `````.`.No `dMM\n" +
"M::d -/:/oo+:                       `+NMMMMMMy                     :syysss: /N. -MM\n" +
"MNmd `/so-`.-        `.....````       yMMMMMMN:                        ``.-  my  hM\n" +
"MMMMo   ./           `.-:/ohddddhhysosNMMMMMMMNho+/:-.`          .:+oossss+  oN  oM\n" +
"MMMMMs`                    `-+hNMMMMMMMMMMMMMN+-.----.`          :/:-..`./s. /M` yM\n" +
"MMMMMMm+.         ..`          ./ymMMMMMMMMMMo                      -+sys+-  yN-oMM\n" +
"MMMMMMMMNy/.      `-/yhs/-        `sMMMMMMMMMs                      -:.`   `oMMNMMM\n" +
"MMMMMMMMMMMNmhsoooshmNMMMNNh+-      MMMMMMMMMNo.                          :dMMMMMMM\n" +
"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNy+--oMMMMMMMMMMMNmdsso+/-`              `/hNMMMMMMMM\n" +
"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMo``               ./yNMMMMMMMMMMM\n" +
"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMms+:-.....-:/+shNMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
        } else if(hand1==3 && hand2==2){
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNNMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMMNdyssooshmMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMy.   :yMMMMMMMMMMMMMMMMMMMMMM\n" +
"MMMNs-:yy/.       `  .sMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMh`     :mMMMMMMMMMMMMMMMMMMMM\n" +
"MMd.`ys.`         `/:``+MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMN+      oMMMMMMMMMMMNdhdmMMM\n" +
"Mm``h/ :oo+/`       -+osmNNNMMMMMMMMMMMMMMMMMMNs/:/odMMMMh`     .hMMMMMMMN/     NMM\n" +
"M: h+ /+-..-`           `.--:://+oyhmMMMMMMMMM`      `/smMm-      :dMMMMM:     /MMM\n" +
"M::d -/:/oo+:                       `+NMMMMMMMd+.        .odo       :dMMN     -NMMM\n" +
"MNmd `/so-`.-        `.....````       yMMMMMMMMMMmo.        :y`       -sh    `NMMMM\n" +
"MMMMo   ./           `.-:/ohddddhhysosNMMMMMMMMMMMMMmo.      `/              `MMMMM\n" +
"MMMMMs`                    `-+hNMMMMMMMMMMMMNo:-/+sydmmh:                     dMMMM\n" +
"MMMMMMm+.         ..`          ./ymMMMMMMMMMN/.        `+s.             `     sMMMM\n" +
"MMMMMMMMNy/.      `-/yhs/-        `sMMMMMMMMMMMmy+-`      -         /:  :h+`  shmMM\n" +
"MMMMMMMMMMMNmhsoooshmNMMMNNh+-      MMMMMMMMMMMMMMMMds/`            `+yo- :y-`m.:MM\n" +
"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNy+--oMMMMMMMMMMMMMMMMMMMMdo.        -s/`.+s: -d: hMM\n" +
"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMh/`      `:+s+ `sy``hMMM\n" +
"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMds/-.`  `.:sy-`+NMMMM\n" +
"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMyshNMMMMMM");
        } else if(hand1==3 && hand2==3){
            System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMMNdyssooshmMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMmhsoossydNMMMMMMMMMMM\n" +
"MMMNs-:yy/.       `  .sMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMs.  `       ./yy:-sNMMM\n" +
"MMd.`ys.`         `/:``+MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM+``:/`         `.sy`.dMM\n" +
"Mm``h/ :oo+/`       -+osmNNNMMMMMMMMMMMMMMMMMMMMMMMMMMMNNNmso+-       `/+oo: /h``mM\n" +
"M: h+ /+-..-`           `.--:://+oyhmMMMMMMMMMmhyo+//::--.`           `-..-+/ +h :M\n" +
"M::d -/:/oo+:                       `+NMMMMMN+`                       :+oo/:/- d::M\n" +
"MNmd `/so-`.-        `.....````       yMMMMMy       ````.....`        -.`-os/` dmNM\n" +
"MMMMo   ./           `.-:/ohddddhhysosNMMMMMNsosyhhddddho/:-.`           /.   oMMMM\n" +
"MMMMMs`                    `-+hNMMMMMMMMMMMMMMMMMMMNh+-`                    `sMMMMM\n" +
"MMMMMMm+.         ..`          ./ymMMMMMMMMMMMMMmy/.          `..         .+mMMMMMM\n" +
"MMMMMMMMNy/.      `-/yhs/-        `sMMMMMMMMMMMs`        -/shy/-`      ./yNMMMMMMMM\n" +
"MMMMMMMMMMMNmhsoooshmNMMMNNh+-      MMMMMMMMMMM      -+hNNMMMNmhsoooshmNMMMMMMMMMMM\n" +
"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNy+--oMMMMMMMMMMMo--+yNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\n" +
"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
        }
    }
    
    public static void overall(int res){
        System.out.println("\n                               G A M E   O V E R");
        System.out.println("                                O V E R A L L :");
        switch (res){
            case 1: System.out.println("                                                  _\n" +
                    "                     _   _  ___  _   _  __      _(_)_ __  \n" +
                    "                    | | | |/ _ \\| | | | \\ \\ /\\ / / | '_ \\ \n" +
                    "                    | |_| | (_) | |_| |  \\ V  V /| | | | |\n" +
                    "                     \\__, |\\___/ \\__,_|   \\_/\\_/ |_|_| |_|\n" +
                    "                      |___/");
                    break;
            case 2: System.out.println("                                         _\n" +
                    "                     _   _  ___  _   _  | | ___  ___  ___ \n" +
                    "                    | | | |/ _ \\| | | | | |/ _ \\/ __|/ _ \\\n" +
                    "                    | |_| | (_) | |_| | | | (_) \\__ \\  __/\n" +
                    "                     \\__, |\\___/ \\__,_| |_|\\___/|___/\\___|\n" +
                    "                      |___/                                ");
                    break;
            case 3: System.out.println("                        _ _   _              _   _\n" +
                    "                       (_) |_( )__    __ _  | |_(_) ___ \n" +
                    "                       | | __|/ __|  / _` | | __| |/ _ \\\n" +
                    "                       | | |_ \\__ \\ | (_| | | |_| |  __/\n" +
                    "                       |_|\\__||___/  \\__,_|  \\__|_|\\___|");
        }
    }
}