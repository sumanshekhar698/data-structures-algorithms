package com.dsa.leetcode.arrays_numbers;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class _2751RobotCollisions {

    public static void main(String[] args) {
        _2751RobotCollisions solution = new _2751RobotCollisions();

        List<Integer> survivors = solution.survivedRobotsHealths(new int[] { 11, 44, 16 }, new int[] { 1, 20, 17 },
                "RLR");
        System.out.println(survivors);

    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        TreeMap<Integer, Pair> map = new TreeMap<>();

        int index = 0;
        for (int i : positions) {// sorting teh entries based on unique positions
            map.put(i, new Pair(healths[index], directions.charAt(index)));
            ++index;
        }

        ArrayDeque<Map.Entry<Integer, Pair>> stack = new ArrayDeque<>();

        // System.out.println(map);
        Set<Map.Entry<Integer, Pair>> set = map.entrySet();
        // System.out.println(set);

        boolean addEntry;// should we add entry explicitly at the end?
        for (Map.Entry<Integer, Pair> entry : set) {
            addEntry = true;

            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && entry.getValue().direction == 'L'// collison condition
                        && stack.peekLast().getValue().direction == 'R') {
                    // case 1: both have equal health
                    if (entry.getValue().health == stack.peekLast().getValue().health) {
                        stack.pollLast();
                        addEntry = false;
                        break;// the entry ans stackLast peek removed
                    }
                    // case 2: the new entry has higher health and can collide with one or more
                    // element, and this si why we needed one loop
                    else if (entry.getValue().health > stack.peekLast().getValue().health) {// surviving the new entry
                        stack.pollLast();
                        entry.getValue().health -= 1;
                        // leaving hasCollided = true; as after handling all the collisons, We need to
                        // add this element
                    }
                    // case 3: the new entry has lower health so stack.peekLast will remove it and
                    // lsoing its health by 1
                    else {// surviving the old entry from stack
                        stack.peekLast().getValue().health -= 1;
                        addEntry = false;
                        break;// only one collison happened and stack.peekLast suvived, going to process next
                              // entry
                    }
                }
                if (addEntry) {// handles case of non collison & case2
                    stack.addLast(entry);
                }
            } else {
                stack.addLast(entry);

            }
        }

        Set<Integer> survivorsPositionSet = stack.stream().map(entry -> entry.getKey()).collect(Collectors.toSet());// collecting
                                                                                                                    // the
                                                                                                                    // surviving
                                                                                                                    // positions
        List<Integer> list = Arrays.stream(positions).filter(position -> survivorsPositionSet.contains(position))
                .map(position -> map.get(position).health).boxed().collect(Collectors.toList());// collecting the
                                                                                                // surviving health in
                                                                                                // the original order

        return list;
    }

    class Pair {
        int health;
        Character direction;

        public Pair(int health, Character direction) {
            this.health = health;
            this.direction = direction;
        }

        @Override
        public String toString() {
            return "Pair [health=" + health + ", direction=" + direction + "]";
        }

    }
}
