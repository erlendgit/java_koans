package beginner;


import com.sandwich.koan.Koan;

import static com.sandwich.koan.constant.KoanConstants.__;
import static com.sandwich.util.Assert.assertEquals;


public class AboutLoops {

    @Koan
    public void basicForLoop1() {
        String sequence = "";
        for (int i = 0; i < 5; i++) {
            sequence += i + " ";
        }
        assertEquals(sequence, "0 1 2 3 4 ");
    }

    @Koan
    public void basicForLoop2() {
        String sequence = "";
        for (int i = -5; i < 1; i++) {
            sequence += i + " ";
        }
        assertEquals(sequence, "-5 -4 -3 -2 -1 0 ");
    }

    @Koan
    public void basicForLoop3() {
        String sequence = "";
        for (int i = 5; i > 0; i--) {
            sequence += i + " ";
        }
        assertEquals(sequence, "5 4 3 2 1 ");
    }

    @Koan
    public void basicForLoop4() {
        String sequence = "";
        for (int i = 0; i < 11; i += 2) {
            sequence += i + " ";
        }
        assertEquals(sequence, "0 2 4 6 8 10 ");
    }

    @Koan
    public void basicForLoop5() {
        String sequence = "";
        for (int i = 1; i <= 16; i *= 2) {
            sequence += i + " ";
        }
        assertEquals(sequence, "1 2 4 8 16 ");
    }

    @Koan
    public void basicForLoopWithTwoVariables1() {
        String sequence = "";
        for (int i = 0, j = 10; i < 5 && j > 5; i++, j--) {
            sequence += i + " " + j + " ";
        }
        assertEquals(sequence, "0 10 1 9 2 8 3 7 4 6 ");
    }

    @Koan
    public void nestedLoops() {
        String sequence = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sequence += "(" + i + ", " + j + ") ";
            }
            sequence += " - ";
        }
        assertEquals(sequence, "(0, 0) (0, 1) (0, 2)  - (1, 0) (1, 1) (1, 2)  - (2, 0) (2, 1) (2, 2)  - ");
    }

    @Koan
    public void extendedForLoop() {
        int[] is = {1, 2, 3, 4};
        String s = "";
        for (int j : is) {
            s += j + " ";
        }
        assertEquals(s, "1 2 3 4 ");
    }

    @Koan
    public void whileLoop() {
        int result = 0;
        while (result < 3) {
            result++;
        }
        assertEquals(result, 3);
    }

    @Koan
    public void doLoop() {
        int result = 0;
        do {
            result++;
        } while (false);
        assertEquals(result, 1);
    }

    @Koan
    public void extendedForLoopBreak() {
        String[] sa = {"Dog", "Cat", "Tiger"};
        int count = 0;
        for (String current : sa) {
            if ("Cat".equals(current)) {
                break;
            }
            count++;
        }
        assertEquals(count, 1);
    }

    @Koan
    public void extendedForLoopContinue() {
        String[] sa = {"Dog", "Cat", "Tiger"};
        int count = 0;
        for (String current : sa) {
            if ("Dog".equals(current)) {
                continue;
            } else {
                count++;
            }
        }
        assertEquals(count, 2);
    }

    public int getLineNumber() {
        return new Throwable().getStackTrace()[1].getLineNumber();
    }

    @Koan
    public void forLoopContinueLabel() {
        int count = 0;
        outerLabel:
        for (int i = 0; i < 6; i++) {
            //System.out.println(getLineNumber());
            for (int j = 0; j < 6; j++) {
                //System.out.println(getLineNumber());
                count++;
                if (count > 2) {
                    //System.out.println(getLineNumber());
                    continue outerLabel;
                }
                //System.out.println(getLineNumber());
            }
            count += 10;
            //System.out.println(getLineNumber());
        }
        //System.out.println(getLineNumber());
        // What does continue with a label mean?
        //   EM: 'goto', keep values of target scope variables
        // What gets executed? Where does the program flow continue?
        //   EM: right behind the given label.
        assertEquals(count, 8);
    }

    @Koan
    public void forLoopBreakLabel() {
        int count = 0;
        outerLabel:
        for (int i = 0; i < 4; i++) {
            //System.out.println(getLineNumber());
            for (int j = 0; j < 4; j++) {
                //System.out.println(getLineNumber());
                count++;
                if (count > 2) {
                    //System.out.println(getLineNumber());
                    break outerLabel;
                }
                //System.out.println(getLineNumber());
            }
            count += 10;
            //System.out.println(getLineNumber());
        }
        //System.out.println(getLineNumber());
        // What does break with a label mean?
        //   EM: I have not a clue. It might require someones fixing skills.
        // What gets executed? Where does the program flow continue?
        //   EM: It magically breaks two scopes down. It seems to ignore the label. This unexpected behaviour
        //   strengthens my (humble) opinion that using labels is bad practice. Avoid it by making smaller methods and
        //   use the 'return' statement to mark the end of your processing.
        int andRememberWiseLessons = 3;
        assertEquals(count, andRememberWiseLessons);
    }
}
