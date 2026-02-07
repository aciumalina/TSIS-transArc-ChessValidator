package org.example;

public class DefaultFenStructureValidator implements FenStructureValidator {

    @Override
    public boolean isValid(String fen) {
        if (fen.length() < 15 || fen.length() > 71) {
            return false;
        }

        if (fen.chars().filter(c -> c == '/').count() != 7) {
            return false;
        }

        String[] ranks = fen.split("/");
        if (ranks.length != 8) {
            return false;
        }

        for (String rank : ranks) {
            if (!isRankValid(rank)) {
                return false;
            }
        }
        return true;
    }

    private boolean isRankValid(String rank) {
        int squares = 0;
        for (char c : rank.toCharArray()) {
            if (Character.isDigit(c)) {
                int empty = c - '0';
                if (empty < 1 || empty > 8) {
                    return false;
                }
                squares += empty;
            } else if ("KQRBNPkqrbnp".indexOf(c) != -1) {
                squares++;
            } else {
                return false;
            }
        }
        return squares == 8;
    }
}

