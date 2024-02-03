package com.companies;

/*A coding competition is being
organized on the HackerRank
platform. All participants need
to be grouped into teams
where each team has exactly
two candidates, and the sums
of their skills must be equal for
all teams. The efficiency of a
team is the product of the
skills of its members, e.g. for a
team with skills [2, 3], the
efficiency of the team is 2 * 3 =
6.
Find the sum of the efficiencies
of the teams. If there is no way
to create teams that satisfy the
conditions, return -1*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
• All participants must be
assigned to a team.
• The answer is always unique.

Example
The skills of the candidates are
ski// = [1, 2, 3, 2]. They can be
paired as [1, 3], [2,2] The
sum of skills for each team is
the same, i.e., 4.
The efficiency is computed as:
• Efficiency of [1, 3] = 1 * 3 =3
• Efficiency of [2, 2] = 2 * 2 = 4
Return the sum of efficiencies,
3+4=7.

n is even.
*/
public class EYCodeTeams {

    long findEfficiency(ArrayList<Integer> skills) {
        int n = skills.size();
        long totalEfficiency = 0;

        Collections.sort(skills);
        int left = 0;
        int right = n - 1;

        while (left < right) {
            if (skills.get(left) + skills.get(right) != skills.get(0) + skills.get(n - 1)) {//checking currentSum == ExtremeSums
                return -1;
            }

            totalEfficiency += (long) skills.get(left) * skills.get(right);
            left++;
            right--;
        }

        return totalEfficiency;
    }

    long findEfficiency(int[] skills) {
        int totalSum = 0;

        for (int skill : skills) {
            totalSum += skill;
        }

        if (totalSum % 2 != 0) {
            return -1;
        }

        Map<Integer, Integer> skillCount = new HashMap<>();
        long totalEfficiency = 0;

        for (int skill : skills) {
            if (skillCount.containsKey(skill) && skillCount.get(skill) > 0) {
                totalEfficiency += skill;
                skillCount.put(skill, skillCount.get(skill) - 1);
            } else {
                int complement = (totalSum / 2) - skill;
                if (skillCount.containsKey(complement) && skillCount.get(complement) > 0) {
                    totalEfficiency += skill * complement;
                    skillCount.put(complement, skillCount.get(complement) - 1);
                } else {
                    return -1;
                }
            }
        }

        return totalEfficiency;
    }

}
