// $ANTLR 3.3 Nov 30, 2010 12:50:56 SQL99.g 2011-06-21 10:13:26

package it.unibz.krdb.obda.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class SQL99Lexer extends Lexer {
    public static final int EOF=-1;
    public static final int SELECT=4;
    public static final int DISTINCT=5;
    public static final int ALL=6;
    public static final int ASTERISK=7;
    public static final int COMMA=8;
    public static final int DOT=9;
    public static final int AS=10;
    public static final int COUNT=11;
    public static final int LPAREN=12;
    public static final int RPAREN=13;
    public static final int AVG=14;
    public static final int MAX=15;
    public static final int MIN=16;
    public static final int SUM=17;
    public static final int EVERY=18;
    public static final int ANY=19;
    public static final int SOME=20;
    public static final int FROM=21;
    public static final int WHERE=22;
    public static final int OR=23;
    public static final int AND=24;
    public static final int IS=25;
    public static final int NOT=26;
    public static final int NULL=27;
    public static final int IN=28;
    public static final int JOIN=29;
    public static final int STRING=30;
    public static final int STRING_WITH_QUOTE=31;
    public static final int TRUE=32;
    public static final int FALSE=33;
    public static final int NUMERIC=34;
    public static final int EQUALS=35;
    public static final int LESS=36;
    public static final int GREATER=37;
    public static final int ORDER=38;
    public static final int BY=39;
    public static final int ON=40;
    public static final int LEFT=41;
    public static final int RIGHT=42;
    public static final int SEMI=43;
    public static final int LSQ_BRACKET=44;
    public static final int RSQ_BRACKET=45;
    public static final int QUESTION=46;
    public static final int DOLLAR=47;
    public static final int QUOTE_DOUBLE=48;
    public static final int QUOTE_SINGLE=49;
    public static final int APOSTROPHE=50;
    public static final int UNDERSCORE=51;
    public static final int DASH=52;
    public static final int AMPERSAND=53;
    public static final int AT=54;
    public static final int EXCLAMATION=55;
    public static final int HASH=56;
    public static final int PERCENT=57;
    public static final int PLUS=58;
    public static final int COLON=59;
    public static final int SLASH=60;
    public static final int DOUBLE_SLASH=61;
    public static final int BACKSLASH=62;
    public static final int TILDE=63;
    public static final int CARET=64;
    public static final int ALPHA=65;
    public static final int DIGIT=66;
    public static final int ALPHANUM=67;
    public static final int CHAR=68;
    public static final int WS=69;

    // delegates
    // delegators

    public SQL99Lexer() {;} 
    public SQL99Lexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public SQL99Lexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "SQL99.g"; }

    // $ANTLR start "SELECT"
    public final void mSELECT() throws RecognitionException {
        try {
            int _type = SELECT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:217:7: ( ( 'S' | 's' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'T' | 't' ) )
            // SQL99.g:217:9: ( 'S' | 's' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SELECT"

    // $ANTLR start "DISTINCT"
    public final void mDISTINCT() throws RecognitionException {
        try {
            int _type = DISTINCT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:219:9: ( ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'S' | 's' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'T' | 't' ) )
            // SQL99.g:219:11: ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'S' | 's' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DISTINCT"

    // $ANTLR start "ALL"
    public final void mALL() throws RecognitionException {
        try {
            int _type = ALL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:221:4: ( ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'L' | 'l' ) )
            // SQL99.g:221:6: ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'L' | 'l' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ALL"

    // $ANTLR start "AVG"
    public final void mAVG() throws RecognitionException {
        try {
            int _type = AVG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:223:4: ( ( 'A' | 'a' ) ( 'V' | 'v' ) ( 'G' | 'g' ) )
            // SQL99.g:223:6: ( 'A' | 'a' ) ( 'V' | 'v' ) ( 'G' | 'g' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AVG"

    // $ANTLR start "MAX"
    public final void mMAX() throws RecognitionException {
        try {
            int _type = MAX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:225:4: ( ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'X' | 'x' ) )
            // SQL99.g:225:6: ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'X' | 'x' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MAX"

    // $ANTLR start "MIN"
    public final void mMIN() throws RecognitionException {
        try {
            int _type = MIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:227:4: ( ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'N' | 'n' ) )
            // SQL99.g:227:6: ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MIN"

    // $ANTLR start "SUM"
    public final void mSUM() throws RecognitionException {
        try {
            int _type = SUM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:229:4: ( ( 'S' | 's' ) ( 'U' | 'u' ) ( 'M' | 'm' ) )
            // SQL99.g:229:6: ( 'S' | 's' ) ( 'U' | 'u' ) ( 'M' | 'm' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SUM"

    // $ANTLR start "EVERY"
    public final void mEVERY() throws RecognitionException {
        try {
            int _type = EVERY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:231:6: ( ( 'E' | 'e' ) ( 'V' | 'v' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'Y' | 'y' ) )
            // SQL99.g:231:8: ( 'E' | 'e' ) ( 'V' | 'v' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'Y' | 'y' )
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EVERY"

    // $ANTLR start "ANY"
    public final void mANY() throws RecognitionException {
        try {
            int _type = ANY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:233:4: ( ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'Y' | 'y' ) )
            // SQL99.g:233:6: ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'Y' | 'y' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ANY"

    // $ANTLR start "SOME"
    public final void mSOME() throws RecognitionException {
        try {
            int _type = SOME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:235:5: ( ( 'S' | 's' ) ( 'O' | 'o' ) ( 'M' | 'm' ) ( 'E' | 'e' ) )
            // SQL99.g:235:7: ( 'S' | 's' ) ( 'O' | 'o' ) ( 'M' | 'm' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SOME"

    // $ANTLR start "COUNT"
    public final void mCOUNT() throws RecognitionException {
        try {
            int _type = COUNT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:237:6: ( ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'T' | 't' ) )
            // SQL99.g:237:8: ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COUNT"

    // $ANTLR start "FROM"
    public final void mFROM() throws RecognitionException {
        try {
            int _type = FROM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:239:5: ( ( 'F' | 'f' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'M' | 'm' ) )
            // SQL99.g:239:7: ( 'F' | 'f' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'M' | 'm' )
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FROM"

    // $ANTLR start "WHERE"
    public final void mWHERE() throws RecognitionException {
        try {
            int _type = WHERE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:241:6: ( ( 'W' | 'w' ) ( 'H' | 'h' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'E' | 'e' ) )
            // SQL99.g:241:8: ( 'W' | 'w' ) ( 'H' | 'h' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHERE"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:243:4: ( ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'D' | 'd' ) )
            // SQL99.g:243:6: ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'D' | 'd' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:245:3: ( ( 'O' | 'o' ) ( 'R' | 'r' ) )
            // SQL99.g:245:5: ( 'O' | 'o' ) ( 'R' | 'r' )
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:247:4: ( ( 'N' | 'n' ) ( 'O' | 'o' ) ( 'T' | 't' ) )
            // SQL99.g:247:6: ( 'N' | 'n' ) ( 'O' | 'o' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "ORDER"
    public final void mORDER() throws RecognitionException {
        try {
            int _type = ORDER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:249:6: ( ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // SQL99.g:249:8: ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'R' | 'r' )
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ORDER"

    // $ANTLR start "BY"
    public final void mBY() throws RecognitionException {
        try {
            int _type = BY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:251:3: ( ( 'B' | 'b' ) ( 'Y' | 'y' ) )
            // SQL99.g:251:5: ( 'B' | 'b' ) ( 'Y' | 'y' )
            {
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BY"

    // $ANTLR start "AS"
    public final void mAS() throws RecognitionException {
        try {
            int _type = AS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:253:3: ( ( 'A' | 'a' ) ( 'S' | 's' ) )
            // SQL99.g:253:5: ( 'A' | 'a' ) ( 'S' | 's' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AS"

    // $ANTLR start "JOIN"
    public final void mJOIN() throws RecognitionException {
        try {
            int _type = JOIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:255:5: ( ( 'J' | 'j' ) ( 'O' | 'o' ) ( 'I' | 'i' ) ( 'N' | 'n' ) )
            // SQL99.g:255:7: ( 'J' | 'j' ) ( 'O' | 'o' ) ( 'I' | 'i' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='J'||input.LA(1)=='j' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "JOIN"

    // $ANTLR start "ON"
    public final void mON() throws RecognitionException {
        try {
            int _type = ON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:257:3: ( ( 'O' | 'o' ) ( 'N' | 'n' ) )
            // SQL99.g:257:5: ( 'O' | 'o' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ON"

    // $ANTLR start "IN"
    public final void mIN() throws RecognitionException {
        try {
            int _type = IN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:259:3: ( ( 'I' | 'i' ) ( 'N' | 'n' ) )
            // SQL99.g:259:5: ( 'I' | 'i' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IN"

    // $ANTLR start "LEFT"
    public final void mLEFT() throws RecognitionException {
        try {
            int _type = LEFT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:261:5: ( ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'T' | 't' ) )
            // SQL99.g:261:7: ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LEFT"

    // $ANTLR start "RIGHT"
    public final void mRIGHT() throws RecognitionException {
        try {
            int _type = RIGHT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:263:6: ( ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'T' | 't' ) )
            // SQL99.g:263:8: ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'H' | 'h' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RIGHT"

    // $ANTLR start "IS"
    public final void mIS() throws RecognitionException {
        try {
            int _type = IS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:265:3: ( ( 'I' | 'i' ) ( 'S' | 's' ) )
            // SQL99.g:265:5: ( 'I' | 'i' ) ( 'S' | 's' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IS"

    // $ANTLR start "NULL"
    public final void mNULL() throws RecognitionException {
        try {
            int _type = NULL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:267:5: ( ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'L' | 'l' ) )
            // SQL99.g:267:7: ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'L' | 'l' )
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NULL"

    // $ANTLR start "FALSE"
    public final void mFALSE() throws RecognitionException {
        try {
            int _type = FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:269:6: ( ( 'F' | 'f' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'S' | 's' ) ( 'E' | 'e' ) )
            // SQL99.g:269:8: ( 'F' | 'f' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'S' | 's' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FALSE"

    // $ANTLR start "TRUE"
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:271:5: ( ( 'T' | 't' ) ( 'R' | 'r' ) ( 'U' | 'u' ) ( 'E' | 'e' ) )
            // SQL99.g:271:7: ( 'T' | 't' ) ( 'R' | 'r' ) ( 'U' | 'u' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TRUE"

    // $ANTLR start "SEMI"
    public final void mSEMI() throws RecognitionException {
        try {
            int _type = SEMI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:273:5: ( ';' )
            // SQL99.g:273:16: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEMI"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:274:4: ( '.' )
            // SQL99.g:274:16: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:275:6: ( ',' )
            // SQL99.g:275:16: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "LSQ_BRACKET"
    public final void mLSQ_BRACKET() throws RecognitionException {
        try {
            int _type = LSQ_BRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:276:12: ( '[' )
            // SQL99.g:276:16: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LSQ_BRACKET"

    // $ANTLR start "RSQ_BRACKET"
    public final void mRSQ_BRACKET() throws RecognitionException {
        try {
            int _type = RSQ_BRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:277:12: ( ']' )
            // SQL99.g:277:16: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RSQ_BRACKET"

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:278:7: ( '(' )
            // SQL99.g:278:16: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LPAREN"

    // $ANTLR start "RPAREN"
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:279:7: ( ')' )
            // SQL99.g:279:16: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RPAREN"

    // $ANTLR start "QUESTION"
    public final void mQUESTION() throws RecognitionException {
        try {
            int _type = QUESTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:280:9: ( '?' )
            // SQL99.g:280:16: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QUESTION"

    // $ANTLR start "DOLLAR"
    public final void mDOLLAR() throws RecognitionException {
        try {
            int _type = DOLLAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:281:7: ( '$' )
            // SQL99.g:281:16: '$'
            {
            match('$'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOLLAR"

    // $ANTLR start "QUOTE_DOUBLE"
    public final void mQUOTE_DOUBLE() throws RecognitionException {
        try {
            int _type = QUOTE_DOUBLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:282:13: ( '\"' )
            // SQL99.g:282:16: '\"'
            {
            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QUOTE_DOUBLE"

    // $ANTLR start "QUOTE_SINGLE"
    public final void mQUOTE_SINGLE() throws RecognitionException {
        try {
            int _type = QUOTE_SINGLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:283:13: ( '\\'' )
            // SQL99.g:283:16: '\\''
            {
            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QUOTE_SINGLE"

    // $ANTLR start "APOSTROPHE"
    public final void mAPOSTROPHE() throws RecognitionException {
        try {
            int _type = APOSTROPHE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:284:11: ( '`' )
            // SQL99.g:284:16: '`'
            {
            match('`'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "APOSTROPHE"

    // $ANTLR start "UNDERSCORE"
    public final void mUNDERSCORE() throws RecognitionException {
        try {
            int _type = UNDERSCORE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:285:11: ( '_' )
            // SQL99.g:285:16: '_'
            {
            match('_'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UNDERSCORE"

    // $ANTLR start "DASH"
    public final void mDASH() throws RecognitionException {
        try {
            int _type = DASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:286:5: ( '-' )
            // SQL99.g:286:16: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DASH"

    // $ANTLR start "ASTERISK"
    public final void mASTERISK() throws RecognitionException {
        try {
            int _type = ASTERISK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:287:9: ( '*' )
            // SQL99.g:287:16: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ASTERISK"

    // $ANTLR start "AMPERSAND"
    public final void mAMPERSAND() throws RecognitionException {
        try {
            int _type = AMPERSAND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:288:10: ( '&' )
            // SQL99.g:288:16: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AMPERSAND"

    // $ANTLR start "AT"
    public final void mAT() throws RecognitionException {
        try {
            int _type = AT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:289:3: ( '@' )
            // SQL99.g:289:16: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AT"

    // $ANTLR start "EXCLAMATION"
    public final void mEXCLAMATION() throws RecognitionException {
        try {
            int _type = EXCLAMATION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:290:12: ( '!' )
            // SQL99.g:290:16: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EXCLAMATION"

    // $ANTLR start "HASH"
    public final void mHASH() throws RecognitionException {
        try {
            int _type = HASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:291:5: ( '#' )
            // SQL99.g:291:16: '#'
            {
            match('#'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HASH"

    // $ANTLR start "PERCENT"
    public final void mPERCENT() throws RecognitionException {
        try {
            int _type = PERCENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:292:8: ( '%' )
            // SQL99.g:292:16: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PERCENT"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:293:5: ( '+' )
            // SQL99.g:293:16: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "EQUALS"
    public final void mEQUALS() throws RecognitionException {
        try {
            int _type = EQUALS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:294:7: ( '=' )
            // SQL99.g:294:16: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQUALS"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:295:6: ( ':' )
            // SQL99.g:295:16: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "LESS"
    public final void mLESS() throws RecognitionException {
        try {
            int _type = LESS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:296:5: ( '<' )
            // SQL99.g:296:16: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LESS"

    // $ANTLR start "GREATER"
    public final void mGREATER() throws RecognitionException {
        try {
            int _type = GREATER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:297:8: ( '>' )
            // SQL99.g:297:16: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GREATER"

    // $ANTLR start "SLASH"
    public final void mSLASH() throws RecognitionException {
        try {
            int _type = SLASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:298:6: ( '/' )
            // SQL99.g:298:16: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SLASH"

    // $ANTLR start "DOUBLE_SLASH"
    public final void mDOUBLE_SLASH() throws RecognitionException {
        try {
            int _type = DOUBLE_SLASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:299:13: ( '//' )
            // SQL99.g:299:16: '//'
            {
            match("//"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOUBLE_SLASH"

    // $ANTLR start "BACKSLASH"
    public final void mBACKSLASH() throws RecognitionException {
        try {
            int _type = BACKSLASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:300:10: ( '\\\\' )
            // SQL99.g:300:16: '\\\\'
            {
            match('\\'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BACKSLASH"

    // $ANTLR start "TILDE"
    public final void mTILDE() throws RecognitionException {
        try {
            int _type = TILDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:301:6: ( '~' )
            // SQL99.g:301:16: '~'
            {
            match('~'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TILDE"

    // $ANTLR start "CARET"
    public final void mCARET() throws RecognitionException {
        try {
            int _type = CARET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:302:6: ( '^' )
            // SQL99.g:302:16: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CARET"

    // $ANTLR start "ALPHA"
    public final void mALPHA() throws RecognitionException {
        try {
            // SQL99.g:304:15: ( ( 'a' .. 'z' | 'A' .. 'Z' ) )
            // SQL99.g:304:17: ( 'a' .. 'z' | 'A' .. 'Z' )
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "ALPHA"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // SQL99.g:306:15: ( '0' .. '9' )
            // SQL99.g:306:17: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "ALPHANUM"
    public final void mALPHANUM() throws RecognitionException {
        try {
            // SQL99.g:308:18: ( ( ALPHA | DIGIT ) )
            // SQL99.g:308:20: ( ALPHA | DIGIT )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "ALPHANUM"

    // $ANTLR start "CHAR"
    public final void mCHAR() throws RecognitionException {
        try {
            // SQL99.g:310:14: ( ( ALPHANUM | UNDERSCORE | DASH ) )
            // SQL99.g:310:16: ( ALPHANUM | UNDERSCORE | DASH )
            {
            if ( input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "CHAR"

    // $ANTLR start "NUMERIC"
    public final void mNUMERIC() throws RecognitionException {
        try {
            int _type = NUMERIC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:312:8: ( ( DIGIT )+ )
            // SQL99.g:312:10: ( DIGIT )+
            {
            // SQL99.g:312:10: ( DIGIT )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // SQL99.g:312:10: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NUMERIC"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:314:7: ( ( CHAR )* )
            // SQL99.g:314:9: ( CHAR )*
            {
            // SQL99.g:314:9: ( CHAR )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='-'||(LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // SQL99.g:314:9: CHAR
            	    {
            	    mCHAR(); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "STRING_WITH_QUOTE"
    public final void mSTRING_WITH_QUOTE() throws RecognitionException {
        try {
            int _type = STRING_WITH_QUOTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:316:18: ( ( QUOTE_SINGLE | QUOTE_DOUBLE ) ( CHAR )* ( QUOTE_SINGLE | QUOTE_DOUBLE ) )
            // SQL99.g:316:20: ( QUOTE_SINGLE | QUOTE_DOUBLE ) ( CHAR )* ( QUOTE_SINGLE | QUOTE_DOUBLE )
            {
            if ( input.LA(1)=='\"'||input.LA(1)=='\'' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // SQL99.g:316:48: ( CHAR )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='-'||(LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // SQL99.g:316:48: CHAR
            	    {
            	    mCHAR(); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            if ( input.LA(1)=='\"'||input.LA(1)=='\'' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING_WITH_QUOTE"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SQL99.g:318:3: ( ( ' ' | '\\t' | ( '\\n' | '\\r' ( '\\n' ) ) )+ )
            // SQL99.g:318:5: ( ' ' | '\\t' | ( '\\n' | '\\r' ( '\\n' ) ) )+
            {
            // SQL99.g:318:5: ( ' ' | '\\t' | ( '\\n' | '\\r' ( '\\n' ) ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=4;
                switch ( input.LA(1) ) {
                case ' ':
                    {
                    alt5=1;
                    }
                    break;
                case '\t':
                    {
                    alt5=2;
                    }
                    break;
                case '\n':
                case '\r':
                    {
                    alt5=3;
                    }
                    break;

                }

                switch (alt5) {
            	case 1 :
            	    // SQL99.g:318:6: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;
            	case 2 :
            	    // SQL99.g:318:10: '\\t'
            	    {
            	    match('\t'); 

            	    }
            	    break;
            	case 3 :
            	    // SQL99.g:318:15: ( '\\n' | '\\r' ( '\\n' ) )
            	    {
            	    // SQL99.g:318:15: ( '\\n' | '\\r' ( '\\n' ) )
            	    int alt4=2;
            	    int LA4_0 = input.LA(1);

            	    if ( (LA4_0=='\n') ) {
            	        alt4=1;
            	    }
            	    else if ( (LA4_0=='\r') ) {
            	        alt4=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 4, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt4) {
            	        case 1 :
            	            // SQL99.g:318:16: '\\n'
            	            {
            	            match('\n'); 

            	            }
            	            break;
            	        case 2 :
            	            // SQL99.g:318:21: '\\r' ( '\\n' )
            	            {
            	            match('\r'); 
            	            // SQL99.g:318:25: ( '\\n' )
            	            // SQL99.g:318:26: '\\n'
            	            {
            	            match('\n'); 

            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // SQL99.g:1:8: ( SELECT | DISTINCT | ALL | AVG | MAX | MIN | SUM | EVERY | ANY | SOME | COUNT | FROM | WHERE | AND | OR | NOT | ORDER | BY | AS | JOIN | ON | IN | LEFT | RIGHT | IS | NULL | FALSE | TRUE | SEMI | DOT | COMMA | LSQ_BRACKET | RSQ_BRACKET | LPAREN | RPAREN | QUESTION | DOLLAR | QUOTE_DOUBLE | QUOTE_SINGLE | APOSTROPHE | UNDERSCORE | DASH | ASTERISK | AMPERSAND | AT | EXCLAMATION | HASH | PERCENT | PLUS | EQUALS | COLON | LESS | GREATER | SLASH | DOUBLE_SLASH | BACKSLASH | TILDE | CARET | NUMERIC | STRING | STRING_WITH_QUOTE | WS )
        int alt6=62;
        alt6 = dfa6.predict(input);
        switch (alt6) {
            case 1 :
                // SQL99.g:1:10: SELECT
                {
                mSELECT(); 

                }
                break;
            case 2 :
                // SQL99.g:1:17: DISTINCT
                {
                mDISTINCT(); 

                }
                break;
            case 3 :
                // SQL99.g:1:26: ALL
                {
                mALL(); 

                }
                break;
            case 4 :
                // SQL99.g:1:30: AVG
                {
                mAVG(); 

                }
                break;
            case 5 :
                // SQL99.g:1:34: MAX
                {
                mMAX(); 

                }
                break;
            case 6 :
                // SQL99.g:1:38: MIN
                {
                mMIN(); 

                }
                break;
            case 7 :
                // SQL99.g:1:42: SUM
                {
                mSUM(); 

                }
                break;
            case 8 :
                // SQL99.g:1:46: EVERY
                {
                mEVERY(); 

                }
                break;
            case 9 :
                // SQL99.g:1:52: ANY
                {
                mANY(); 

                }
                break;
            case 10 :
                // SQL99.g:1:56: SOME
                {
                mSOME(); 

                }
                break;
            case 11 :
                // SQL99.g:1:61: COUNT
                {
                mCOUNT(); 

                }
                break;
            case 12 :
                // SQL99.g:1:67: FROM
                {
                mFROM(); 

                }
                break;
            case 13 :
                // SQL99.g:1:72: WHERE
                {
                mWHERE(); 

                }
                break;
            case 14 :
                // SQL99.g:1:78: AND
                {
                mAND(); 

                }
                break;
            case 15 :
                // SQL99.g:1:82: OR
                {
                mOR(); 

                }
                break;
            case 16 :
                // SQL99.g:1:85: NOT
                {
                mNOT(); 

                }
                break;
            case 17 :
                // SQL99.g:1:89: ORDER
                {
                mORDER(); 

                }
                break;
            case 18 :
                // SQL99.g:1:95: BY
                {
                mBY(); 

                }
                break;
            case 19 :
                // SQL99.g:1:98: AS
                {
                mAS(); 

                }
                break;
            case 20 :
                // SQL99.g:1:101: JOIN
                {
                mJOIN(); 

                }
                break;
            case 21 :
                // SQL99.g:1:106: ON
                {
                mON(); 

                }
                break;
            case 22 :
                // SQL99.g:1:109: IN
                {
                mIN(); 

                }
                break;
            case 23 :
                // SQL99.g:1:112: LEFT
                {
                mLEFT(); 

                }
                break;
            case 24 :
                // SQL99.g:1:117: RIGHT
                {
                mRIGHT(); 

                }
                break;
            case 25 :
                // SQL99.g:1:123: IS
                {
                mIS(); 

                }
                break;
            case 26 :
                // SQL99.g:1:126: NULL
                {
                mNULL(); 

                }
                break;
            case 27 :
                // SQL99.g:1:131: FALSE
                {
                mFALSE(); 

                }
                break;
            case 28 :
                // SQL99.g:1:137: TRUE
                {
                mTRUE(); 

                }
                break;
            case 29 :
                // SQL99.g:1:142: SEMI
                {
                mSEMI(); 

                }
                break;
            case 30 :
                // SQL99.g:1:147: DOT
                {
                mDOT(); 

                }
                break;
            case 31 :
                // SQL99.g:1:151: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 32 :
                // SQL99.g:1:157: LSQ_BRACKET
                {
                mLSQ_BRACKET(); 

                }
                break;
            case 33 :
                // SQL99.g:1:169: RSQ_BRACKET
                {
                mRSQ_BRACKET(); 

                }
                break;
            case 34 :
                // SQL99.g:1:181: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 35 :
                // SQL99.g:1:188: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 36 :
                // SQL99.g:1:195: QUESTION
                {
                mQUESTION(); 

                }
                break;
            case 37 :
                // SQL99.g:1:204: DOLLAR
                {
                mDOLLAR(); 

                }
                break;
            case 38 :
                // SQL99.g:1:211: QUOTE_DOUBLE
                {
                mQUOTE_DOUBLE(); 

                }
                break;
            case 39 :
                // SQL99.g:1:224: QUOTE_SINGLE
                {
                mQUOTE_SINGLE(); 

                }
                break;
            case 40 :
                // SQL99.g:1:237: APOSTROPHE
                {
                mAPOSTROPHE(); 

                }
                break;
            case 41 :
                // SQL99.g:1:248: UNDERSCORE
                {
                mUNDERSCORE(); 

                }
                break;
            case 42 :
                // SQL99.g:1:259: DASH
                {
                mDASH(); 

                }
                break;
            case 43 :
                // SQL99.g:1:264: ASTERISK
                {
                mASTERISK(); 

                }
                break;
            case 44 :
                // SQL99.g:1:273: AMPERSAND
                {
                mAMPERSAND(); 

                }
                break;
            case 45 :
                // SQL99.g:1:283: AT
                {
                mAT(); 

                }
                break;
            case 46 :
                // SQL99.g:1:286: EXCLAMATION
                {
                mEXCLAMATION(); 

                }
                break;
            case 47 :
                // SQL99.g:1:298: HASH
                {
                mHASH(); 

                }
                break;
            case 48 :
                // SQL99.g:1:303: PERCENT
                {
                mPERCENT(); 

                }
                break;
            case 49 :
                // SQL99.g:1:311: PLUS
                {
                mPLUS(); 

                }
                break;
            case 50 :
                // SQL99.g:1:316: EQUALS
                {
                mEQUALS(); 

                }
                break;
            case 51 :
                // SQL99.g:1:323: COLON
                {
                mCOLON(); 

                }
                break;
            case 52 :
                // SQL99.g:1:329: LESS
                {
                mLESS(); 

                }
                break;
            case 53 :
                // SQL99.g:1:334: GREATER
                {
                mGREATER(); 

                }
                break;
            case 54 :
                // SQL99.g:1:342: SLASH
                {
                mSLASH(); 

                }
                break;
            case 55 :
                // SQL99.g:1:348: DOUBLE_SLASH
                {
                mDOUBLE_SLASH(); 

                }
                break;
            case 56 :
                // SQL99.g:1:361: BACKSLASH
                {
                mBACKSLASH(); 

                }
                break;
            case 57 :
                // SQL99.g:1:371: TILDE
                {
                mTILDE(); 

                }
                break;
            case 58 :
                // SQL99.g:1:377: CARET
                {
                mCARET(); 

                }
                break;
            case 59 :
                // SQL99.g:1:383: NUMERIC
                {
                mNUMERIC(); 

                }
                break;
            case 60 :
                // SQL99.g:1:391: STRING
                {
                mSTRING(); 

                }
                break;
            case 61 :
                // SQL99.g:1:398: STRING_WITH_QUOTE
                {
                mSTRING_WITH_QUOTE(); 

                }
                break;
            case 62 :
                // SQL99.g:1:416: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS =
        "\21\57\11\uffff\1\113\1\115\1\uffff\1\116\1\117\13\uffff\1\121\3"+
        "\uffff\1\122\2\uffff\7\57\1\133\7\57\1\144\1\145\2\57\1\150\1\57"+
        "\1\152\1\153\3\57\10\uffff\1\57\1\160\2\57\1\163\1\164\1\165\1\166"+
        "\1\uffff\1\167\1\170\6\57\2\uffff\1\177\1\57\1\uffff\1\57\2\uffff"+
        "\4\57\1\uffff\1\u0086\1\57\6\uffff\2\57\1\u008a\3\57\1\uffff\1\u008e"+
        "\1\u008f\1\u0090\1\57\1\u0092\1\57\1\uffff\1\57\1\u0095\1\u0096"+
        "\1\uffff\1\u0097\1\u0098\1\u0099\3\uffff\1\u009a\1\uffff\1\u009b"+
        "\1\57\7\uffff\1\57\1\u009e\1\uffff";
    static final String DFA6_eofS =
        "\u009f\uffff";
    static final String DFA6_minS =
        "\1\11\1\105\1\111\1\114\1\101\1\126\1\117\1\101\1\110\1\116\1\117"+
        "\1\131\1\117\1\116\1\105\1\111\1\122\11\uffff\2\42\1\uffff\2\55"+
        "\13\uffff\1\57\3\uffff\1\55\2\uffff\1\114\2\115\1\123\1\114\1\107"+
        "\1\104\1\55\1\130\1\116\1\105\1\125\1\117\1\114\1\105\2\55\1\124"+
        "\1\114\1\55\1\111\2\55\1\106\1\107\1\125\10\uffff\1\105\1\55\1\105"+
        "\1\124\4\55\1\uffff\2\55\1\122\1\116\1\115\1\123\1\122\1\105\2\uffff"+
        "\1\55\1\114\1\uffff\1\116\2\uffff\1\124\1\110\1\105\1\103\1\uffff"+
        "\1\55\1\111\6\uffff\1\131\1\124\1\55\2\105\1\122\1\uffff\3\55\1"+
        "\124\1\55\1\124\1\uffff\1\116\2\55\1\uffff\3\55\3\uffff\1\55\1\uffff"+
        "\1\55\1\103\7\uffff\1\124\1\55\1\uffff";
    static final String DFA6_maxS =
        "\1\176\1\165\1\151\1\166\1\151\1\166\1\157\1\162\1\150\1\162\1\165"+
        "\1\171\1\157\1\163\1\145\1\151\1\162\11\uffff\2\172\1\uffff\2\172"+
        "\13\uffff\1\57\3\uffff\1\172\2\uffff\1\154\2\155\1\163\1\154\1\147"+
        "\1\171\1\172\1\170\1\156\1\145\1\165\1\157\1\154\1\145\2\172\1\164"+
        "\1\154\1\172\1\151\2\172\1\146\1\147\1\165\10\uffff\1\145\1\172"+
        "\1\145\1\164\4\172\1\uffff\2\172\1\162\1\156\1\155\1\163\1\162\1"+
        "\145\2\uffff\1\172\1\154\1\uffff\1\156\2\uffff\1\164\1\150\1\145"+
        "\1\143\1\uffff\1\172\1\151\6\uffff\1\171\1\164\1\172\2\145\1\162"+
        "\1\uffff\3\172\1\164\1\172\1\164\1\uffff\1\156\2\172\1\uffff\3\172"+
        "\3\uffff\1\172\1\uffff\1\172\1\143\7\uffff\1\164\1\172\1\uffff";
    static final String DFA6_acceptS =
        "\21\uffff\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\2\uffff\1"+
        "\50\2\uffff\1\53\1\54\1\55\1\56\1\57\1\60\1\61\1\62\1\63\1\64\1"+
        "\65\1\uffff\1\70\1\71\1\72\1\uffff\1\74\1\76\32\uffff\1\46\1\75"+
        "\1\47\1\51\1\52\1\67\1\66\1\73\10\uffff\1\23\10\uffff\1\17\1\25"+
        "\2\uffff\1\22\1\uffff\1\26\1\31\4\uffff\1\7\2\uffff\1\3\1\4\1\11"+
        "\1\16\1\5\1\6\6\uffff\1\20\6\uffff\1\12\3\uffff\1\14\3\uffff\1\32"+
        "\1\24\1\27\1\uffff\1\34\2\uffff\1\10\1\13\1\33\1\15\1\21\1\30\1"+
        "\1\2\uffff\1\2";
    static final String DFA6_specialS =
        "\u009f\uffff}>";
    static final String[] DFA6_transitionS = {
            "\2\60\2\uffff\1\60\22\uffff\1\60\1\42\1\32\1\43\1\31\1\44\1"+
            "\40\1\33\1\26\1\27\1\37\1\45\1\23\1\36\1\22\1\52\12\56\1\47"+
            "\1\21\1\50\1\46\1\51\1\30\1\41\1\3\1\13\1\6\1\2\1\5\1\7\2\uffff"+
            "\1\15\1\14\1\uffff\1\16\1\4\1\12\1\11\2\uffff\1\17\1\1\1\20"+
            "\2\uffff\1\10\3\uffff\1\24\1\53\1\25\1\55\1\35\1\34\1\3\1\13"+
            "\1\6\1\2\1\5\1\7\2\uffff\1\15\1\14\1\uffff\1\16\1\4\1\12\1\11"+
            "\2\uffff\1\17\1\1\1\20\2\uffff\1\10\6\uffff\1\54",
            "\1\61\11\uffff\1\63\5\uffff\1\62\17\uffff\1\61\11\uffff\1\63"+
            "\5\uffff\1\62",
            "\1\64\37\uffff\1\64",
            "\1\65\1\uffff\1\67\4\uffff\1\70\2\uffff\1\66\25\uffff\1\65"+
            "\1\uffff\1\67\4\uffff\1\70\2\uffff\1\66",
            "\1\71\7\uffff\1\72\27\uffff\1\71\7\uffff\1\72",
            "\1\73\37\uffff\1\73",
            "\1\74\37\uffff\1\74",
            "\1\76\20\uffff\1\75\16\uffff\1\76\20\uffff\1\75",
            "\1\77\37\uffff\1\77",
            "\1\101\3\uffff\1\100\33\uffff\1\101\3\uffff\1\100",
            "\1\102\5\uffff\1\103\31\uffff\1\102\5\uffff\1\103",
            "\1\104\37\uffff\1\104",
            "\1\105\37\uffff\1\105",
            "\1\106\4\uffff\1\107\32\uffff\1\106\4\uffff\1\107",
            "\1\110\37\uffff\1\110",
            "\1\111\37\uffff\1\111",
            "\1\112\37\uffff\1\112",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\114\4\uffff\1\114\5\uffff\1\114\2\uffff\12\114\7\uffff\32"+
            "\114\4\uffff\1\114\1\uffff\32\114",
            "\1\114\4\uffff\1\114\5\uffff\1\114\2\uffff\12\114\7\uffff\32"+
            "\114\4\uffff\1\114\1\uffff\32\114",
            "",
            "\1\57\2\uffff\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\57\2\uffff\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\120",
            "",
            "",
            "",
            "\1\57\2\uffff\12\56\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "",
            "\1\123\37\uffff\1\123",
            "\1\124\37\uffff\1\124",
            "\1\125\37\uffff\1\125",
            "\1\126\37\uffff\1\126",
            "\1\127\37\uffff\1\127",
            "\1\130\37\uffff\1\130",
            "\1\132\24\uffff\1\131\12\uffff\1\132\24\uffff\1\131",
            "\1\57\2\uffff\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\134\37\uffff\1\134",
            "\1\135\37\uffff\1\135",
            "\1\136\37\uffff\1\136",
            "\1\137\37\uffff\1\137",
            "\1\140\37\uffff\1\140",
            "\1\141\37\uffff\1\141",
            "\1\142\37\uffff\1\142",
            "\1\57\2\uffff\12\57\7\uffff\3\57\1\143\26\57\4\uffff\1\57\1"+
            "\uffff\3\57\1\143\26\57",
            "\1\57\2\uffff\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\146\37\uffff\1\146",
            "\1\147\37\uffff\1\147",
            "\1\57\2\uffff\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\151\37\uffff\1\151",
            "\1\57\2\uffff\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\57\2\uffff\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\154\37\uffff\1\154",
            "\1\155\37\uffff\1\155",
            "\1\156\37\uffff\1\156",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\157\37\uffff\1\157",
            "\1\57\2\uffff\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\161\37\uffff\1\161",
            "\1\162\37\uffff\1\162",
            "\1\57\2\uffff\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\57\2\uffff\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\57\2\uffff\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\57\2\uffff\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "\1\57\2\uffff\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\57\2\uffff\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\171\37\uffff\1\171",
            "\1\172\37\uffff\1\172",
            "\1\173\37\uffff\1\173",
            "\1\174\37\uffff\1\174",
            "\1\175\37\uffff\1\175",
            "\1\176\37\uffff\1\176",
            "",
            "",
            "\1\57\2\uffff\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u0080\37\uffff\1\u0080",
            "",
            "\1\u0081\37\uffff\1\u0081",
            "",
            "",
            "\1\u0082\37\uffff\1\u0082",
            "\1\u0083\37\uffff\1\u0083",
            "\1\u0084\37\uffff\1\u0084",
            "\1\u0085\37\uffff\1\u0085",
            "",
            "\1\57\2\uffff\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u0087\37\uffff\1\u0087",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0088\37\uffff\1\u0088",
            "\1\u0089\37\uffff\1\u0089",
            "\1\57\2\uffff\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u008b\37\uffff\1\u008b",
            "\1\u008c\37\uffff\1\u008c",
            "\1\u008d\37\uffff\1\u008d",
            "",
            "\1\57\2\uffff\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\57\2\uffff\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\57\2\uffff\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u0091\37\uffff\1\u0091",
            "\1\57\2\uffff\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u0093\37\uffff\1\u0093",
            "",
            "\1\u0094\37\uffff\1\u0094",
            "\1\57\2\uffff\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\57\2\uffff\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "\1\57\2\uffff\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\57\2\uffff\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\57\2\uffff\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "",
            "",
            "\1\57\2\uffff\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "",
            "\1\57\2\uffff\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            "\1\u009c\37\uffff\1\u009c",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u009d\37\uffff\1\u009d",
            "\1\57\2\uffff\12\57\7\uffff\32\57\4\uffff\1\57\1\uffff\32\57",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( SELECT | DISTINCT | ALL | AVG | MAX | MIN | SUM | EVERY | ANY | SOME | COUNT | FROM | WHERE | AND | OR | NOT | ORDER | BY | AS | JOIN | ON | IN | LEFT | RIGHT | IS | NULL | FALSE | TRUE | SEMI | DOT | COMMA | LSQ_BRACKET | RSQ_BRACKET | LPAREN | RPAREN | QUESTION | DOLLAR | QUOTE_DOUBLE | QUOTE_SINGLE | APOSTROPHE | UNDERSCORE | DASH | ASTERISK | AMPERSAND | AT | EXCLAMATION | HASH | PERCENT | PLUS | EQUALS | COLON | LESS | GREATER | SLASH | DOUBLE_SLASH | BACKSLASH | TILDE | CARET | NUMERIC | STRING | STRING_WITH_QUOTE | WS );";
        }
    }
 

}