package stack;

import java.util.*;

/**
 * 
 * You're now a baseball game point recorder.
 * 
 * Given a list of strings, each string can be one of the 4 following types:
 * 
 * Integer (one round's score): Directly represents the number of points you get
 * in this round.
 * 
 * "+" (one round's score): Represents that the points you get in this round are
 * the sum of the last two valid round's points.
 * 
 * "D" (one round's score): Represents that the points you get in this round are
 * the doubled data of the last valid round's points.
 * 
 * "C" (an operation, which isn't a round's score): Represents the last valid
 * round's points you get were invalid and should be removed. Each round's
 * operation is permanent and could have an impact on the round before and the
 * round after.
 * 
 * You need to return the sum of the points you could get in all the rounds.
 * 
 */

class _682_BaseballGame {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (String s : ops) {
            if (s.equals("+")) {
                int top = stack.pop();
                int newNum = top + stack.peek();
                stack.push(top);
                stack.push(newNum);
            } else if (s.equals("D")) {
                stack.push(2 * stack.peek());
            } else if (s.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}