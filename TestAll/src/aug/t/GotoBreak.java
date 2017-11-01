package aug.t;

/**
 */
public class GotoBreak {

    /**
     */
    public static void main(String[] args) {

        out: for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 5) {
                    break out; // ©ирт
                    // break;
                }
                System.out.printf("%4d", j);
            }
            System.out.println();
        }

        // System.out.println("");
    }

}
