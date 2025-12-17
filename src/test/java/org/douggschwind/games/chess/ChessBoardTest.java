package org.douggschwind.games.chess;

import org.douggschwind.games.chess.moves.CastlingMove;
import org.douggschwind.games.chess.moves.CommonMove;
import org.douggschwind.games.chess.piece.Bishop;
import org.douggschwind.games.chess.piece.ChessPiece;
import org.douggschwind.games.chess.piece.King;
import org.douggschwind.games.chess.piece.Knight;
import org.douggschwind.games.chess.piece.Pawn;
import org.douggschwind.games.chess.piece.Queen;
import org.douggschwind.games.chess.piece.Rook;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests interesting operations on ChessBoard and there are many.
 * @author Doug Gschwind
 */
public class ChessBoardTest {
    private ChessBoard underTest;

    @BeforeEach
    public void setUp() {
        underTest = new ChessBoard();
    }

    @Test
    public void testStartOfGameSetup() {
        Square leftBlackRook = underTest.getSquare(BoardPosition.Row.R8, BoardPosition.Column.a);
        assertNotNull(leftBlackRook);
        assertTrue(leftBlackRook.isOccupied());
        ChessPiece occupant = leftBlackRook.getResident().get();
        assertEquals(Player.BLACK, occupant.getOwner());
        assertTrue(occupant.isRook());

        Square leftBlackKnight = underTest.getSquare(BoardPosition.Row.R8, BoardPosition.Column.b);
        assertNotNull(leftBlackKnight);
        assertTrue(leftBlackKnight.isOccupied());
        occupant = leftBlackKnight.getResident().get();
        assertEquals(Player.BLACK, occupant.getOwner());
        assertTrue(occupant.isKnight());

        Square leftBlackBishop = underTest.getSquare(BoardPosition.Row.R8, BoardPosition.Column.c);
        assertNotNull(leftBlackBishop);
        assertTrue(leftBlackBishop.isOccupied());
        occupant = leftBlackBishop.getResident().get();
        assertEquals(Player.BLACK, occupant.getOwner());
        assertTrue(occupant.isBishop());

        Square blackQueen = underTest.getSquare(BoardPosition.Row.R8, BoardPosition.Column.d);
        assertNotNull(blackQueen);
        assertTrue(blackQueen.isOccupied());
        occupant = blackQueen.getResident().get();
        assertEquals(Player.BLACK, occupant.getOwner());
        assertTrue(occupant.isQueen());

        Square blackKing = underTest.getSquare(BoardPosition.Row.R8, BoardPosition.Column.e);
        assertNotNull(blackKing);
        assertTrue(blackKing.isOccupied());
        occupant = blackKing.getResident().get();
        assertEquals(Player.BLACK, occupant.getOwner());
        assertTrue(occupant.isKing());

        Square rightBlackBishop = underTest.getSquare(BoardPosition.Row.R8, BoardPosition.Column.f);
        assertNotNull(rightBlackBishop);
        assertTrue(rightBlackBishop.isOccupied());
        occupant = rightBlackBishop.getResident().get();
        assertEquals(Player.BLACK, occupant.getOwner());
        assertTrue(occupant.isBishop());

        Square rightBlackKnight = underTest.getSquare(BoardPosition.Row.R8, BoardPosition.Column.g);
        assertNotNull(rightBlackKnight);
        assertTrue(rightBlackKnight.isOccupied());
        occupant = rightBlackKnight.getResident().get();
        assertEquals(Player.BLACK, occupant.getOwner());
        assertTrue(occupant.isKnight());

        Square rightBlackRook = underTest.getSquare(BoardPosition.Row.R8, BoardPosition.Column.h);
        assertNotNull(rightBlackRook);
        assertTrue(rightBlackRook.isOccupied());
        occupant = rightBlackRook.getResident().get();
        assertEquals(Player.BLACK, occupant.getOwner());
        assertTrue(occupant.isRook());

        // Now, lets check all of the Black player Pawns
        for (BoardPosition.Column column : BoardPosition.Column.values()) {
            Square pawnSquare = underTest.getSquare(BoardPosition.Row.R7, column);
            assertNotNull(pawnSquare);
            assertTrue(pawnSquare.isOccupied());
            occupant = pawnSquare.getResident().get();
            assertEquals(Player.BLACK, occupant.getOwner());
            assertTrue(occupant.isPawn());
        }

        // Now lets check all of the empty squares
        for (int rowId = 3;rowId <= 6;rowId++) {
            for (BoardPosition.Column column : BoardPosition.Column.values()) {
                Square emptySquare = underTest.getSquare(BoardPosition.Row.getById(rowId), column);
                assertNotNull(emptySquare);
                assertFalse(emptySquare.isOccupied());
            }
        }

        // Now, lets check all of the White player Pawns
        for (BoardPosition.Column column : BoardPosition.Column.values()) {
            Square pawnSquare = underTest.getSquare(BoardPosition.Row.R2, column);
            assertNotNull(pawnSquare);
            assertTrue(pawnSquare.isOccupied());
            occupant = pawnSquare.getResident().get();
            assertEquals(Player.WHITE, occupant.getOwner());
            assertTrue(occupant.isPawn());
        }

        // Now, lets check all of the White player last row
        Square leftWhiteRook = underTest.getSquare(BoardPosition.Row.R1, BoardPosition.Column.a);
        assertNotNull(leftWhiteRook);
        assertTrue(leftWhiteRook.isOccupied());
        occupant = leftWhiteRook.getResident().get();
        assertEquals(Player.WHITE, occupant.getOwner());
        assertTrue(occupant.isRook());

        Square leftWhiteKnight = underTest.getSquare(BoardPosition.Row.R1, BoardPosition.Column.b);
        assertNotNull(leftWhiteKnight);
        assertTrue(leftWhiteKnight.isOccupied());
        occupant = leftWhiteKnight.getResident().get();
        assertEquals(Player.WHITE, occupant.getOwner());
        assertTrue(occupant.isKnight());

        Square leftWhiteBishop = underTest.getSquare(BoardPosition.Row.R1, BoardPosition.Column.c);
        assertNotNull(leftWhiteBishop);
        assertTrue(leftWhiteBishop.isOccupied());
        occupant = leftWhiteBishop.getResident().get();
        assertEquals(Player.WHITE, occupant.getOwner());
        assertTrue(occupant.isBishop());

        Square whiteQueen = underTest.getSquare(BoardPosition.Row.R1, BoardPosition.Column.d);
        assertNotNull(whiteQueen);
        assertTrue(whiteQueen.isOccupied());
        occupant = whiteQueen.getResident().get();
        assertEquals(Player.WHITE, occupant.getOwner());
        assertTrue(occupant.isQueen());

        Square whiteKing = underTest.getSquare(BoardPosition.Row.R1, BoardPosition.Column.e);
        assertNotNull(whiteKing);
        assertTrue(whiteKing.isOccupied());
        occupant = whiteKing.getResident().get();
        assertEquals(Player.WHITE, occupant.getOwner());
        assertTrue(occupant.isKing());

        Square rightWhiteBishop = underTest.getSquare(BoardPosition.Row.R1, BoardPosition.Column.f);
        assertNotNull(rightWhiteBishop);
        assertTrue(rightWhiteBishop.isOccupied());
        occupant = rightWhiteBishop.getResident().get();
        assertEquals(Player.WHITE, occupant.getOwner());
        assertTrue(occupant.isBishop());

        Square rightWhiteKnight = underTest.getSquare(BoardPosition.Row.R1, BoardPosition.Column.g);
        assertNotNull(rightWhiteKnight);
        assertTrue(rightWhiteKnight.isOccupied());
        occupant = rightWhiteKnight.getResident().get();
        assertEquals(Player.WHITE, occupant.getOwner());
        assertTrue(occupant.isKnight());

        Square rightWhiteRook = underTest.getSquare(BoardPosition.Row.R1, BoardPosition.Column.h);
        assertNotNull(rightWhiteRook);
        assertTrue(rightWhiteRook.isOccupied());
        occupant = rightWhiteRook.getResident().get();
        assertEquals(Player.WHITE, occupant.getOwner());
        assertTrue(occupant.isRook());

        String[] boardStateText = underTest.print();
        assertEquals(19, boardStateText.length);
        String rowDelimiter = boardStateText[1];
        for (int i = 3;i < 19;i += 2) {
            assertEquals(rowDelimiter, boardStateText[i]);
        }
        assertEquals("|   |a |b |c |d |e |f |g |h |", boardStateText[0]);
        assertEquals("|   |a |b |c |d |e |f |g |h |", boardStateText[18]);

        assertEquals("| 8 |Br|Bk|Bb|BQ|BK|Bb|Bk|Br|", boardStateText[2]);
        assertEquals("| 7 |Bp|Bp|Bp|Bp|Bp|Bp|Bp|Bp|", boardStateText[4]);
        assertEquals("| 6 |  |  |  |  |  |  |  |  |", boardStateText[6]);
        assertEquals("| 5 |  |  |  |  |  |  |  |  |", boardStateText[8]);
        assertEquals("| 4 |  |  |  |  |  |  |  |  |", boardStateText[10]);
        assertEquals("| 3 |  |  |  |  |  |  |  |  |", boardStateText[12]);
        assertEquals("| 2 |Wp|Wp|Wp|Wp|Wp|Wp|Wp|Wp|", boardStateText[14]);
        assertEquals("| 1 |Wr|Wk|Wb|WQ|WK|Wb|Wk|Wr|", boardStateText[16]);
    }

    private void testPlayerCanMoveFrom(Player player,
                                       BoardPosition.Row fromRow,
                                       BoardPosition.Column fromColumn,
                                       boolean expectedResult) {
        Square fromSquare = underTest.getSquare(fromRow, fromColumn);
        assertEquals(expectedResult, player.canMoveFrom(fromSquare));
    }

    @Test
    public void testCanMoveFrom() {
        for (BoardPosition.Row row : BoardPosition.Row.values()) {
            boolean expectedResult = ((row == BoardPosition.Row.R8) || (row == BoardPosition.Row.R7));
            for (BoardPosition.Column column : BoardPosition.Column.values()) {
                testPlayerCanMoveFrom(Player.BLACK, row, column, expectedResult);
            }
        }

        for (BoardPosition.Row row : BoardPosition.Row.values()) {
            boolean expectedResult = ((row == BoardPosition.Row.R2) || (row == BoardPosition.Row.R1));
            for (BoardPosition.Column column : BoardPosition.Column.values()) {
                testPlayerCanMoveFrom(Player.WHITE, row, column, expectedResult);
            }
        }
    }

    private void testRookCanMoveFromStartOfGame(Player owner, BoardPosition.Column fromColumn) {
        BoardPosition.Row fromRow = owner.isBlack() ? BoardPosition.Row.R8 : BoardPosition.Row.R1;
        Square from = underTest.getSquare(fromRow, fromColumn);
        Rook subjectRook = (Rook) from.getResident().get();

        for (BoardPosition.Row row : BoardPosition.Row.values()) {
            for (BoardPosition.Column column : BoardPosition.Column.values()) {
                Square to = underTest.getSquare(row, column);
                if (!from.equals(to)) {
                    CommonMove<Rook> proposedCommonMove = new CommonMove(Rook.class, from, to);
                    assertFalse(subjectRook.canMoveTo(underTest, proposedCommonMove));
                }
            }
        }
    }

    private void testKnightCanMoveFromStartOfGame(Player owner, BoardPosition.Column fromColumn) {
        final BoardPosition.Row fromRow = owner.isBlack() ? BoardPosition.Row.R8 : BoardPosition.Row.R1;
        final BoardPosition.Row allowedRow = owner.isBlack() ? BoardPosition.Row.R6 : BoardPosition.Row.R3;
        Square from = underTest.getSquare(fromRow, fromColumn);
        Knight subjectKnight = (Knight) from.getResident().get();

        for (BoardPosition.Row row : BoardPosition.Row.values()) {
            for (BoardPosition.Column column : BoardPosition.Column.values()) {
                Square to = underTest.getSquare(row, column);
                if (!from.equals(to)) {
                    CommonMove<Knight> proposedCommonMove = new CommonMove(Knight.class, from, to);
                    if ((allowedRow == row) &&
                        ((column.getId() == fromColumn.getId() - 1) ||
                         (column.getId() == fromColumn.getId() + 1))) {
                        assertTrue(subjectKnight.canMoveTo(underTest, proposedCommonMove));
                    } else {
                        assertFalse(subjectKnight.canMoveTo(underTest, proposedCommonMove));
                    }
                }
            }
        }
    }

    private void testBishopCanMoveFromStartOfGame(Player owner, BoardPosition.Column fromColumn) {
        BoardPosition.Row fromRow = owner.isBlack() ? BoardPosition.Row.R8 : BoardPosition.Row.R1;
        Square from = underTest.getSquare(fromRow, fromColumn);
        Bishop subjectBishop = (Bishop) from.getResident().get();

        for (BoardPosition.Row row : BoardPosition.Row.values()) {
            for (BoardPosition.Column column : BoardPosition.Column.values()) {
                Square to = underTest.getSquare(row, column);
                if (!from.equals(to)) {
                    CommonMove<Bishop> proposedCommonMove = new CommonMove(Bishop.class, from, to);
                    assertFalse(subjectBishop.canMoveTo(underTest, proposedCommonMove));
                }
            }
        }
    }

    private void testQueenCanMoveFromStartOfGame(Player owner, BoardPosition.Column fromColumn) {
        BoardPosition.Row fromRow = owner.isBlack() ? BoardPosition.Row.R8 : BoardPosition.Row.R1;
        Square from = underTest.getSquare(fromRow, fromColumn);
        Queen subjectQueen = (Queen) from.getResident().get();

        for (BoardPosition.Row row : BoardPosition.Row.values()) {
            for (BoardPosition.Column column : BoardPosition.Column.values()) {
                Square to = underTest.getSquare(row, column);
                if (!from.equals(to)) {
                    CommonMove<Queen> proposedCommonMove = new CommonMove(Queen.class, from, to);
                    assertFalse(subjectQueen.canMoveTo(underTest, proposedCommonMove));
                }
            }
        }
    }

    private void testKingCanMoveFromStartOfGame(Player owner, BoardPosition.Column fromColumn) {
        BoardPosition.Row fromRow = owner.isBlack() ? BoardPosition.Row.R8 : BoardPosition.Row.R1;
        Square from = underTest.getSquare(fromRow, fromColumn);
        King subjectKing = (King) from.getResident().get();

        for (BoardPosition.Row row : BoardPosition.Row.values()) {
            for (BoardPosition.Column column : BoardPosition.Column.values()) {
                Square to = underTest.getSquare(row, column);
                if (!from.equals(to)) {
                    CommonMove<King> proposedCommonMove = new CommonMove(King.class, from, to);
                    assertFalse(subjectKing.canMoveTo(underTest, proposedCommonMove));
                }
            }
        }
    }

    /**
     * Tests where each of the Chess Pieces can move to, fron their initial start of game state.
     */
    @Test
    public void testCanMoveToStartOfGame() {
        testRookCanMoveFromStartOfGame(Player.BLACK, BoardPosition.Column.a);
        testKnightCanMoveFromStartOfGame(Player.BLACK, BoardPosition.Column.b);
        testBishopCanMoveFromStartOfGame(Player.BLACK, BoardPosition.Column.c);
        testQueenCanMoveFromStartOfGame(Player.BLACK, BoardPosition.Column.d);
        testKingCanMoveFromStartOfGame(Player.BLACK, BoardPosition.Column.e);
        testBishopCanMoveFromStartOfGame(Player.BLACK, BoardPosition.Column.f);
        testKnightCanMoveFromStartOfGame(Player.BLACK, BoardPosition.Column.g);
        testRookCanMoveFromStartOfGame(Player.BLACK, BoardPosition.Column.h);

        testRookCanMoveFromStartOfGame(Player.WHITE, BoardPosition.Column.a);
        testKnightCanMoveFromStartOfGame(Player.WHITE, BoardPosition.Column.b);
        testBishopCanMoveFromStartOfGame(Player.WHITE, BoardPosition.Column.c);
        testQueenCanMoveFromStartOfGame(Player.WHITE, BoardPosition.Column.d);
        testKingCanMoveFromStartOfGame(Player.WHITE, BoardPosition.Column.e);
        testBishopCanMoveFromStartOfGame(Player.WHITE, BoardPosition.Column.f);
        testKnightCanMoveFromStartOfGame(Player.WHITE, BoardPosition.Column.g);
        testRookCanMoveFromStartOfGame(Player.WHITE, BoardPosition.Column.h);
    }

    @Test
    public void testEnPassantToLeft() {
        Square twoB = underTest.getSquare(BoardPosition.Row.R2, BoardPosition.Column.b);
        Square fourB = underTest.getSquare(BoardPosition.Row.R4, BoardPosition.Column.b);
        Square fiveB = underTest.getSquare(BoardPosition.Row.R5, BoardPosition.Column.b);
        Square sixA = underTest.getSquare(BoardPosition.Row.R6, BoardPosition.Column.a);
        ChessPiece whitePawn = twoB.getResident().get();
        CommonMove<Pawn> firstWhiteMove = new CommonMove(Pawn.class, twoB, fourB);
        whitePawn.moveTo(underTest, firstWhiteMove);
        CommonMove<Pawn> secondWhiteMove = new CommonMove(Pawn.class, fourB, fiveB);
        whitePawn.moveTo(underTest, secondWhiteMove);

        // Now that we have set the stage for the White Pawn, move the Black Pawn from 7a to 5a so that
        // the White Pawn should be able to capture it with a subsequent En Passant move.
        Square sevenA = underTest.getSquare(BoardPosition.Row.R7, BoardPosition.Column.a);
        Square fiveA = underTest.getSquare(BoardPosition.Row.R5, BoardPosition.Column.a);
        ChessPiece blackPawn = sevenA.getResident().get();
        CommonMove<Pawn> firstBlackMove = new CommonMove(Pawn.class, sevenA, fiveA);
        assertFalse(fiveA.isOccupied());
        blackPawn.moveTo(underTest, firstBlackMove);
        assertTrue(fiveA.isOccupied());
        assertSame(blackPawn, fiveA.getResident().get());

        assertFalse(whitePawn.hasBeenCaptured());
        assertFalse(blackPawn.hasBeenCaptured());

        CommonMove<Pawn> enPassantByWhitePawn = new CommonMove(Pawn.class, fiveB, sixA);
        assertTrue(whitePawn.canMoveTo(underTest, enPassantByWhitePawn));
        assertFalse(sixA.isOccupied());
        whitePawn.moveTo(underTest, enPassantByWhitePawn);
        assertTrue(sixA.isOccupied());

        // At this point, the White Pawn should be in square R6 A, and the Black Pawn has been captured
        // leaving square R5 A empty.
        assertFalse(whitePawn.hasBeenCaptured());
        assertTrue(blackPawn.hasBeenCaptured());
        assertFalse(fiveA.isOccupied());
        assertTrue(sixA.isOccupied());
        assertSame(whitePawn, sixA.getResident().get());

        String[] boardStateText = underTest.print();
        assertEquals("| 8 |Br|Bk|Bb|BQ|BK|Bb|Bk|Br|", boardStateText[2]);
        assertEquals("| 7 |  |Bp|Bp|Bp|Bp|Bp|Bp|Bp|", boardStateText[4]);
        assertEquals("| 6 |Wp|  |  |  |  |  |  |  |", boardStateText[6]);
        assertEquals("| 5 |  |  |  |  |  |  |  |  |", boardStateText[8]);
        assertEquals("| 4 |  |  |  |  |  |  |  |  |", boardStateText[10]);
        assertEquals("| 3 |  |  |  |  |  |  |  |  |", boardStateText[12]);
        assertEquals("| 2 |Wp|  |Wp|Wp|Wp|Wp|Wp|Wp|", boardStateText[14]);
        assertEquals("| 1 |Wr|Wk|Wb|WQ|WK|Wb|Wk|Wr|", boardStateText[16]);
    }

    @Test
    public void testEnPassantToRight() {
        Square twoB = underTest.getSquare(BoardPosition.Row.R2, BoardPosition.Column.b);
        Square fourB = underTest.getSquare(BoardPosition.Row.R4, BoardPosition.Column.b);
        Square fiveB = underTest.getSquare(BoardPosition.Row.R5, BoardPosition.Column.b);
        Square sixC = underTest.getSquare(BoardPosition.Row.R6, BoardPosition.Column.c);
        ChessPiece whitePawn = twoB.getResident().get();
        CommonMove<Pawn> firstWhiteMove = new CommonMove(Pawn.class, twoB, fourB);
        whitePawn.moveTo(underTest, firstWhiteMove);
        CommonMove<Pawn> secondWhiteMove = new CommonMove(Pawn.class, fourB, fiveB);
        whitePawn.moveTo(underTest, secondWhiteMove);

        // Now that we have set the stage for the White Pawn, move the Black Pawn from 7c to 5c so that
        // the White Pawn should be able to capture it with a subsequent En Passant move.
        Square sevenC = underTest.getSquare(BoardPosition.Row.R7, BoardPosition.Column.c);
        Square fiveC = underTest.getSquare(BoardPosition.Row.R5, BoardPosition.Column.c);
        ChessPiece blackPawn = sevenC.getResident().get();
        CommonMove<Pawn> firstBlackMove = new CommonMove(Pawn.class, sevenC, fiveC);
        assertFalse(fiveC.isOccupied());
        blackPawn.moveTo(underTest, firstBlackMove);
        assertTrue(fiveC.isOccupied());
        assertSame(blackPawn, fiveC.getResident().get());

        assertFalse(whitePawn.hasBeenCaptured());
        assertFalse(blackPawn.hasBeenCaptured());

        CommonMove<Pawn> enPassantByWhitePawn = new CommonMove(Pawn.class, fiveB, sixC);
        assertTrue(whitePawn.canMoveTo(underTest, enPassantByWhitePawn));
        assertFalse(sixC.isOccupied());
        whitePawn.moveTo(underTest, enPassantByWhitePawn);
        assertTrue(sixC.isOccupied());

        // At this point, the White Pawn should be in square R6 C, and the Black Pawn has been captured
        // leaving square R5 C empty.
        assertFalse(whitePawn.hasBeenCaptured());
        assertTrue(blackPawn.hasBeenCaptured());
        assertFalse(fiveC.isOccupied());
        assertTrue(sixC.isOccupied());
        assertSame(whitePawn, sixC.getResident().get());

        String[] boardStateText = underTest.print();
        assertEquals("| 8 |Br|Bk|Bb|BQ|BK|Bb|Bk|Br|", boardStateText[2]);
        assertEquals("| 7 |Bp|Bp|  |Bp|Bp|Bp|Bp|Bp|", boardStateText[4]);
        assertEquals("| 6 |  |  |Wp|  |  |  |  |  |", boardStateText[6]);
        assertEquals("| 5 |  |  |  |  |  |  |  |  |", boardStateText[8]);
        assertEquals("| 4 |  |  |  |  |  |  |  |  |", boardStateText[10]);
        assertEquals("| 3 |  |  |  |  |  |  |  |  |", boardStateText[12]);
        assertEquals("| 2 |Wp|  |Wp|Wp|Wp|Wp|Wp|Wp|", boardStateText[14]);
        assertEquals("| 1 |Wr|Wk|Wb|WQ|WK|Wb|Wk|Wr|", boardStateText[16]);
    }

    @Test
    public void testKingSideCastling() {
        CastlingMove blackKingSideCastling = CastlingMove.newKingSideMove(Player.BLACK, underTest);
        CastlingMove whiteKingSideCastling = CastlingMove.newKingSideMove(Player.WHITE, underTest);

        // Definitely not permitted at start of game, pieces in the way.
        assertFalse(blackKingSideCastling.isPermitted(Player.BLACK, underTest));
        assertFalse(whiteKingSideCastling.isPermitted(Player.WHITE, underTest));

        // Now, lets move the necessary pieces out of the way.
        // Move the right Knight.
        final Square eightG = underTest.getSquare(BoardPosition.Row.R8, BoardPosition.Column.g);
        final Square sixF = underTest.getSquare(BoardPosition.Row.R6, BoardPosition.Column.f);
        Knight blackKnight = (Knight) eightG.getResident().get();
        CommonMove<Knight> blackKnightMove = new CommonMove(Knight.class, eightG, sixF);
        assertTrue(blackKnight.canMoveTo(underTest, blackKnightMove));
        blackKnight.moveTo(underTest, blackKnightMove);
        assertFalse(blackKingSideCastling.isPermitted(Player.BLACK, underTest));

        final Square oneG = underTest.getSquare(BoardPosition.Row.R1, BoardPosition.Column.g);
        final Square threeH = underTest.getSquare(BoardPosition.Row.R3, BoardPosition.Column.h);
        Knight whiteKnight = (Knight) oneG.getResident().get();
        CommonMove<Knight> whiteKnightMove = new CommonMove(Knight.class, oneG, threeH);
        assertTrue(whiteKnight.canMoveTo(underTest, whiteKnightMove));
        whiteKnight.moveTo(underTest, whiteKnightMove);
        assertFalse(whiteKingSideCastling.isPermitted(Player.WHITE, underTest));

        // Move a Pawn so that Bishop can get out.
        final Square sevenG = underTest.getSquare(BoardPosition.Row.R7, BoardPosition.Column.g);
        final Square sixG = underTest.getSquare(BoardPosition.Row.R6, BoardPosition.Column.g);
        Pawn blackPawn = (Pawn) sevenG.getResident().get();
        CommonMove<Pawn> blackPawnMove = new CommonMove(Pawn.class, sevenG, sixG);
        assertTrue(blackPawn.canMoveTo(underTest, blackPawnMove));
        blackPawn.moveTo(underTest, blackPawnMove);
        assertFalse(blackKingSideCastling.isPermitted(Player.BLACK, underTest));

        final Square twoE = underTest.getSquare(BoardPosition.Row.R2, BoardPosition.Column.e);
        final Square threeE = underTest.getSquare(BoardPosition.Row.R3, BoardPosition.Column.e);
        Pawn whitePawn = (Pawn) twoE.getResident().get();
        CommonMove<Pawn> whitePawnMove = new CommonMove(Pawn.class, twoE, threeE);
        assertTrue(whitePawn.canMoveTo(underTest, whitePawnMove));
        whitePawn.moveTo(underTest, whitePawnMove);
        assertFalse(whiteKingSideCastling.isPermitted(Player.WHITE, underTest));

        // Move right Bishop so that path between King and Rook is now open.
        final Square eightF = underTest.getSquare(BoardPosition.Row.R8, BoardPosition.Column.f);
        final Square sixH = underTest.getSquare(BoardPosition.Row.R6, BoardPosition.Column.h);
        Bishop blackBishop = (Bishop) eightF.getResident().get();
        CommonMove<Bishop> blackBishopMove = new CommonMove(Bishop.class, eightF, sixH);
        assertTrue(blackBishop.canMoveTo(underTest, blackBishopMove));
        blackBishop.moveTo(underTest, blackBishopMove);
        assertTrue(blackKingSideCastling.isPermitted(Player.BLACK, underTest));

        final Square oneF = underTest.getSquare(BoardPosition.Row.R1, BoardPosition.Column.f);
        final Square fourC = underTest.getSquare(BoardPosition.Row.R4, BoardPosition.Column.c);
        Bishop whiteBishop = (Bishop) oneF.getResident().get();
        CommonMove<Bishop> whiteBishopMove = new CommonMove(Bishop.class, oneF, fourC);
        assertTrue(whiteBishop.canMoveTo(underTest, whiteBishopMove));
        whiteBishop.moveTo(underTest, whiteBishopMove);
        assertTrue(whiteKingSideCastling.isPermitted(Player.WHITE, underTest));

        // Now that the path is clear between King and Rook, make the move and assert expected state.
        blackKingSideCastling.handleMove(underTest);
        assertTrue(eightG.isOccupied());
        King blackKing = (King) eightG.getResident().get();
        assertTrue(blackKing.isKing());
        assertTrue(blackKing.hasEverBeenMoved());
        assertFalse(blackKing.hasBeenCaptured());
        assertTrue(eightF.isOccupied());
        Rook blackRook = (Rook) eightF.getResident().get();
        assertTrue(blackRook.isRook());
        assertTrue(blackRook.hasEverBeenMoved());
        assertFalse(blackRook.hasBeenCaptured());
        final Square eightE = underTest.getSquare(BoardPosition.Row.R8, BoardPosition.Column.e);
        assertFalse(eightE.isOccupied());
        final Square eightH = underTest.getSquare(BoardPosition.Row.R8, BoardPosition.Column.h);
        assertFalse(eightH.isOccupied());

        whiteKingSideCastling.handleMove(underTest);
        assertTrue(oneG.isOccupied());
        King whiteKing = (King) oneG.getResident().get();
        assertTrue(whiteKing.isKing());
        assertTrue(whiteKing.hasEverBeenMoved());
        assertFalse(whiteKing.hasBeenCaptured());
        assertTrue(oneF.isOccupied());
        Rook whiteRook = (Rook) oneF.getResident().get();
        assertTrue(whiteRook.isRook());
        assertTrue(whiteRook.hasEverBeenMoved());
        assertFalse(whiteRook.hasBeenCaptured());
        final Square oneE = underTest.getSquare(BoardPosition.Row.R1, BoardPosition.Column.e);
        assertFalse(oneE.isOccupied());
        final Square oneH = underTest.getSquare(BoardPosition.Row.R1, BoardPosition.Column.h);
        assertFalse(oneH.isOccupied());

        String[] boardStateText = underTest.print();
        assertEquals("| 8 |Br|Bk|Bb|BQ|  |Br|BK|  |", boardStateText[2]);
        assertEquals("| 7 |Bp|Bp|Bp|Bp|Bp|Bp|  |Bp|", boardStateText[4]);
        assertEquals("| 6 |  |  |  |  |  |Bk|Bp|Bb|", boardStateText[6]);
        assertEquals("| 5 |  |  |  |  |  |  |  |  |", boardStateText[8]);
        assertEquals("| 4 |  |  |Wb|  |  |  |  |  |", boardStateText[10]);
        assertEquals("| 3 |  |  |  |  |Wp|  |  |Wk|", boardStateText[12]);
        assertEquals("| 2 |Wp|Wp|Wp|Wp|  |Wp|Wp|Wp|", boardStateText[14]);
        assertEquals("| 1 |Wr|Wk|Wb|WQ|  |Wr|WK|  |", boardStateText[16]);
    }

    @Test
    public void testQueenSideCastling() {
        CastlingMove blackQueenSideCastling = CastlingMove.newQueenSideMove(Player.BLACK, underTest);
        CastlingMove whiteQueenSideCastling = CastlingMove.newQueenSideMove(Player.WHITE, underTest);

        // Definitely not permitted at start of game, pieces in the way.
        assertFalse(blackQueenSideCastling.isPermitted(Player.BLACK, underTest));
        assertFalse(whiteQueenSideCastling.isPermitted(Player.WHITE, underTest));

        // Now, lets move the necessary pieces out of the way.
        // Move the left Knight.
        final Square eightB = underTest.getSquare(BoardPosition.Row.R8, BoardPosition.Column.b);
        final Square sixA = underTest.getSquare(BoardPosition.Row.R6, BoardPosition.Column.a);
        Knight blackKnight = (Knight) eightB.getResident().get();
        CommonMove<Knight> blackKnightMove = new CommonMove(Knight.class, eightB, sixA);
        assertTrue(blackKnight.canMoveTo(underTest, blackKnightMove));
        blackKnight.moveTo(underTest, blackKnightMove);
        assertFalse(blackQueenSideCastling.isPermitted(Player.BLACK, underTest));

        final Square oneB = underTest.getSquare(BoardPosition.Row.R1, BoardPosition.Column.b);
        final Square threeA = underTest.getSquare(BoardPosition.Row.R3, BoardPosition.Column.a);
        Knight whiteKnight = (Knight) oneB.getResident().get();
        CommonMove<Knight> whiteKnightMove = new CommonMove(Knight.class, oneB, threeA);
        assertTrue(whiteKnight.canMoveTo(underTest, whiteKnightMove));
        whiteKnight.moveTo(underTest, whiteKnightMove);
        assertFalse(whiteQueenSideCastling.isPermitted(Player.WHITE, underTest));

        // Move a Pawn so that Bishop can get out.
        final Square sevenD = underTest.getSquare(BoardPosition.Row.R7, BoardPosition.Column.d);
        final Square sixD = underTest.getSquare(BoardPosition.Row.R6, BoardPosition.Column.d);
        Pawn blackPawn = (Pawn) sevenD.getResident().get();
        CommonMove<Pawn> blackPawnMove = new CommonMove(Pawn.class, sevenD, sixD);
        assertTrue(blackPawn.canMoveTo(underTest, blackPawnMove));
        blackPawn.moveTo(underTest, blackPawnMove);
        assertFalse(blackQueenSideCastling.isPermitted(Player.BLACK, underTest));

        final Square twoD = underTest.getSquare(BoardPosition.Row.R2, BoardPosition.Column.d);
        final Square threeD = underTest.getSquare(BoardPosition.Row.R3, BoardPosition.Column.d);
        Pawn whitePawn = (Pawn) twoD.getResident().get();
        CommonMove<Pawn> whitePawnMove = new CommonMove(Pawn.class, twoD, threeD);
        assertTrue(whitePawn.canMoveTo(underTest, whitePawnMove));
        whitePawn.moveTo(underTest, whitePawnMove);
        assertFalse(whiteQueenSideCastling.isPermitted(Player.WHITE, underTest));

        // Move left Bishop so that path between King and Rook is now only blocked by the Queen.
        final Square eightC = underTest.getSquare(BoardPosition.Row.R8, BoardPosition.Column.c);
        final Square sixE = underTest.getSquare(BoardPosition.Row.R6, BoardPosition.Column.e);
        Bishop blackBishop = (Bishop) eightC.getResident().get();
        CommonMove<Bishop> blackBishopMove = new CommonMove(Bishop.class, eightC, sixE);
        assertTrue(blackBishop.canMoveTo(underTest, blackBishopMove));
        blackBishop.moveTo(underTest, blackBishopMove);
        assertFalse(blackQueenSideCastling.isPermitted(Player.BLACK, underTest));

        final Square oneC = underTest.getSquare(BoardPosition.Row.R1, BoardPosition.Column.c);
        final Square threeE = underTest.getSquare(BoardPosition.Row.R3, BoardPosition.Column.e);
        Bishop whiteBishop = (Bishop) oneC.getResident().get();
        CommonMove<Bishop> whiteBishopMove = new CommonMove(Bishop.class, oneC, threeE);
        assertTrue(whiteBishop.canMoveTo(underTest, whiteBishopMove));
        whiteBishop.moveTo(underTest, whiteBishopMove);
        assertFalse(whiteQueenSideCastling.isPermitted(Player.WHITE, underTest));

        // Move Queen so that path between King and Rook is now clear.
        final Square eightD = underTest.getSquare(BoardPosition.Row.R8, BoardPosition.Column.d);
        Queen blackQueen = (Queen) eightD.getResident().get();
        CommonMove<Bishop> blackQueenMove = new CommonMove(Queen.class, eightD, sevenD);
        assertTrue(blackQueen.canMoveTo(underTest, blackQueenMove));
        blackQueen.moveTo(underTest, blackQueenMove);
        assertTrue(blackQueenSideCastling.isPermitted(Player.BLACK, underTest));

        final Square oneD = underTest.getSquare(BoardPosition.Row.R1, BoardPosition.Column.d);
        Queen whiteQueen = (Queen) oneD.getResident().get();
        CommonMove<Queen> whiteQueenMove = new CommonMove(Queen.class, oneD, twoD);
        assertTrue(whiteQueen.canMoveTo(underTest, whiteQueenMove));
        whiteQueen.moveTo(underTest, whiteQueenMove);
        assertTrue(whiteQueenSideCastling.isPermitted(Player.WHITE, underTest));

        // Now that the path is clear between King and Rook, make the move and assert expected state.
        blackQueenSideCastling.handleMove(underTest);
        assertTrue(eightC.isOccupied());
        King blackKing = (King) eightC.getResident().get();
        assertTrue(blackKing.isKing());
        assertTrue(blackKing.hasEverBeenMoved());
        assertFalse(blackKing.hasBeenCaptured());
        assertTrue(eightD.isOccupied());
        Rook blackRook = (Rook) eightD.getResident().get();
        assertTrue(blackRook.isRook());
        assertTrue(blackRook.hasEverBeenMoved());
        assertFalse(blackRook.hasBeenCaptured());
        final Square eightE = underTest.getSquare(BoardPosition.Row.R8, BoardPosition.Column.e);
        assertFalse(eightE.isOccupied());
        final Square eightA = underTest.getSquare(BoardPosition.Row.R8, BoardPosition.Column.a);
        assertFalse(eightA.isOccupied());

        whiteQueenSideCastling.handleMove(underTest);
        assertTrue(oneC.isOccupied());
        King whiteKing = (King) oneC.getResident().get();
        assertTrue(whiteKing.isKing());
        assertTrue(whiteKing.hasEverBeenMoved());
        assertFalse(whiteKing.hasBeenCaptured());
        assertTrue(oneD.isOccupied());
        Rook whiteRook = (Rook) oneD.getResident().get();
        assertTrue(whiteRook.isRook());
        assertTrue(whiteRook.hasEverBeenMoved());
        assertFalse(whiteRook.hasBeenCaptured());
        final Square oneE = underTest.getSquare(BoardPosition.Row.R1, BoardPosition.Column.e);
        assertFalse(oneE.isOccupied());
        final Square oneA = underTest.getSquare(BoardPosition.Row.R1, BoardPosition.Column.a);
        assertFalse(oneA.isOccupied());

        String[] boardStateText = underTest.print();
        assertEquals("| 8 |  |  |BK|Br|  |Bb|Bk|Br|", boardStateText[2]);
        assertEquals("| 7 |Bp|Bp|Bp|BQ|Bp|Bp|Bp|Bp|", boardStateText[4]);
        assertEquals("| 6 |Bk|  |  |Bp|Bb|  |  |  |", boardStateText[6]);
        assertEquals("| 5 |  |  |  |  |  |  |  |  |", boardStateText[8]);
        assertEquals("| 4 |  |  |  |  |  |  |  |  |", boardStateText[10]);
        assertEquals("| 3 |Wk|  |  |Wp|Wb|  |  |  |", boardStateText[12]);
        assertEquals("| 2 |Wp|Wp|Wp|WQ|Wp|Wp|Wp|Wp|", boardStateText[14]);
        assertEquals("| 1 |  |  |WK|Wr|  |Wb|Wk|Wr|", boardStateText[16]);
    }
}
