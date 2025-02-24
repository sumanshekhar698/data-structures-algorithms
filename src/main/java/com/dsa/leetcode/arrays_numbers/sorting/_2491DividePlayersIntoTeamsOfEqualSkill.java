package com.dsa.leetcode.arrays_numbers.sorting;

import java.util.Arrays;

public class _2491DividePlayersIntoTeamsOfEqualSkill {

    public static void main(String[] args) {

    }

    public long dividePlayers(int[] skill) {

        Arrays.sort(skill);
        long netChemistry = 0;


        long eachSkill = skill[0] + skill[skill.length - 1];

        for (int i = 0; i < skill.length/2; i++) {

            long player1Skill = skill[i];
            long player2Skill = skill[skill.length - 1 - i];

            if (player1Skill + player2Skill != eachSkill) {
                return -1;
            }

            netChemistry +=  player1Skill * player2Skill;

        }
        return netChemistry;
    }

    public long dividePlayersUsingFrequencyTable(int[] skill) {
        int n = skill.length;
        int totalSkill = 0;
        int[] skillFrequency = new int[1001];

        // Calculate total skill and skill frequency
        for (int playerSkill : skill) {
            totalSkill += playerSkill;
            skillFrequency[playerSkill]++;
        }

        // Check if total skill can be evenly distributed among teams
        if (totalSkill % (n / 2) != 0) {
            return -1;
        }

        int targetTeamSkill = totalSkill / (n / 2);
        long totalChemistry = 0;

        // Calculate total chemistry while verifying valid team formations
        for (int playerSkill : skill) {
            int partnerSkill = targetTeamSkill - playerSkill;

            // Check if a valid partner exists
            if (skillFrequency[partnerSkill] == 0) {
                return -1;
            }

            totalChemistry += (long) playerSkill * (long) partnerSkill;
            skillFrequency[partnerSkill]--;
        }

        // Return half of totalChemistry as each pair is counted twice
        return totalChemistry / 2;
    }
}
