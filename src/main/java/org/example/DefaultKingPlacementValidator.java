package org.example;

public class DefaultKingPlacementValidator implements KingPlacementValidator {

    @Override
    public boolean isValid(String fen) {
        String[] ranks = fen.split("/");

        int wRow = -1, wCol = -1;
        int bRow = -1, bCol = -1;

        for (int r = 0; r < 8; r++) {
            int c = 0;
            for (char ch : ranks[r].toCharArray()) {
                if (Character.isDigit(ch)) {
                    c += ch - '0';
                } else {
                    if (ch == 'K') {
                        wRow = r; wCol = c;
                    } else if (ch == 'k') {
                        bRow = r; bCol = c;
                    }
                    c++;
                }
            }
        }

        return Math.abs(wRow - bRow) > 1 ||
                Math.abs(wCol - bCol) > 1;
    }
}