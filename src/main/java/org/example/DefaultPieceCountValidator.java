package org.example;

public class DefaultPieceCountValidator implements PieceCountValidator {

    @Override
    public boolean isValid(String fen) {
        String[] ranks = fen.split("/");

        int whiteKings = 0, blackKings = 0;
        int whitePawns = 0, blackPawns = 0;
        int totalPieces = 0;

        for (int rank = 0; rank < 8; rank++) {
            for (char c : ranks[rank].toCharArray()) {
                if (Character.isDigit(c)) {
                    continue;
                }

                totalPieces++;

                switch (c) {
                    case 'K': whiteKings++; break;
                    case 'k': blackKings++; break;
                    case 'P':
                        whitePawns++;
                        if (rank == 7) return false;
                        break;
                    case 'p':
                        blackPawns++;
                        if (rank == 0) return false;
                        break;
                }
            }
        }

        return whiteKings == 1 &&
                blackKings == 1 &&
                whitePawns <= 8 &&
                blackPawns <= 8 &&
                totalPieces <= 32;
    }
}

