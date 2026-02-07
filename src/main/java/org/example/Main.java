package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {

//8/pp2b1n1/p7/8/5R2/6P1/5P2/6K1
//2b3k1/6bp/2n1p1p1/2p5/2N1N3/P2r1P2/5BPP/5RK1
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        FenValidator validator = new DefaultFenValidator(
                List.of(
                        new DefaultFenStructureValidator(),
                        new DefaultPieceCountValidator(),
                        new DefaultKingPlacementValidator()
                )
        );

        System.out.println("Input FEN:");
        String fen = scanner.nextLine().trim();

        if (validator.validate(fen)) {
            System.out.println("Pozitie Corecta");
        } else {
            System.out.println("Pozitie Incorecta");
        }
    }
}

