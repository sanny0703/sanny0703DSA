package AmitSirDSA;

/**
 * {@code Tower of Hanoi Problem} : Moving {@code N} disks from Tower A to Tower B with the help of Tower C.
 * Each disk is of varying size i.e. at the bottom we got the largest disk and on top smaller one and so on.
 * While transferring disks, larger disk can't be placed on a smaller disk as it can't bare the weight of larger one
 * and it will break.
 */
public class TowerOfHanoi {

    private static void TOH(int noOfDisks, Tower A, Tower B, Tower C) {
        String x = A.toString() + "->" + B.toString();
        if (noOfDisks == 1)
            System.out.print(x + ";");
        else {
            // moving n-1 disks from A to C via B
            TOH(noOfDisks - 1, A, C, B);
            // moving last disk (nth) to B
            System.out.print(x + ";");
            // moving n-1 disks to B from C via A
            TOH(noOfDisks - 1, C, B, A);
        }
    }

    private enum Tower {
        A, B, C
    }

    public static void main(String[] args) {
        /*
        To Move n disks we need 2^(n) -1 moves exactly
         */
        TOH(3, Tower.A, Tower.B, Tower.C);
        System.out.println();
        TOH(4, Tower.A, Tower.B, Tower.C);
    }


}
