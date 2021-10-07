import java.io.*;
import java_cup.runtime.*;  // defines Symbol

/**
 * This program is to be used to test the cflat scanner.
 * This version is set up to test all tokens, but more code is needed to test 
 * other aspects of the scanner (e.g., input that causes errors, character 
 * numbers, values associated with tokens).
 */
public class P2 {
    public static void main(String[] args) throws IOException {
    		// exception may be thrown by yylex
        
				CharNum.num = 1;
				testAllTokens("allTokens", ".in");
				
				CharNum.num = 1;
        testAllTokens("eof", ".txt");

    }

    /**
     * testAllTokens
     *
     * Open and read from file allTokens.in
     * For each token read, write the corresponding string to allTokens.out
     * If the input file contains all tokens, one per line, we can verify
     * correctness of the scanner by comparing the input and output files
     * (e.g., using a 'diff' command).
    */
    private static void testAllTokens(String filename, String extension) throws IOException {
        // open input and output files
        FileReader inFile = null;
        PrintWriter outFile = null;

        try {
            inFile = new FileReader(filename + extension);
            outFile = new PrintWriter(new FileWriter(filename + ".out"));
        } catch (FileNotFoundException ex) {
            System.err.println("File " + filename + extension + " not found.");
            System.exit(-1);
        } catch (IOException ex) {
            System.err.println(filename + " .out cannot be opened.");
            System.exit(-1);
        }

        // create and call the scanner
        Yylex my_scanner = new Yylex(inFile);
        Symbol my_token = my_scanner.next_token();
        while (my_token.sym != sym.EOF) {
						switch (my_token.sym) {
								case sym.BOOL:
										outFile.println("bool: Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum));
										break;
								case sym.INT:
										outFile.println("int Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum));
										break;
								case sym.VOID:
										outFile.println("void Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum));
										break;
								case sym.TRUE:
										outFile.println("true Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum)); 
										break;
								case sym.FALSE:
										outFile.println("false Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum)); 
										break;
								case sym.STRUCT:
										outFile.println("struct Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum)); 
										break;
								case sym.RECEIVE:
										outFile.println("receive Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum)); 
										break;
								case sym.PRINT:
										outFile.println("print Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum));
										break;				
								case sym.IF:
										outFile.println("if Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum));
										break;
								case sym.ELSE:
										outFile.println("else Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum));
										break;
								case sym.WHILE:
										outFile.println("while Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum));
										break;
								case sym.RETURN:
										outFile.println("return Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum));
										break;
								case sym.ID:
										outFile.println(((IdTokenVal)my_token.value).idVal + " Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum));
										break;
								case sym.INTLITERAL:  
										outFile.println(((IntLitTokenVal)my_token.value).intVal + " Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum));
										break;
								case sym.STRINGLITERAL: 
										outFile.println(((StrLitTokenVal)my_token.value).strVal + " Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum));
										break;    
								case sym.LCURLY:
										outFile.println("{ Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum));
										break;
								case sym.RCURLY:
										outFile.println("} Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum));
										break;
								case sym.LPAREN:
										outFile.println("( Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum));
										break;
								case sym.RPAREN:
										outFile.println(") Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum));
										break;
								case sym.SEMICOLON:
										outFile.println("; Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum));
										break;
								case sym.COMMA:
										outFile.println(", Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum));
										break;
								case sym.DOT:
										outFile.println(". Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum));
										break;
								case sym.WRITE:
										outFile.println("<< Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum));
										break;
								case sym.READ:
										outFile.println(">> Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum));
										break;				
								case sym.PLUSPLUS:
										outFile.println("++ Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum));
										break;
								case sym.MINUSMINUS:
										outFile.println("-- Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum));
										break;	
								case sym.PLUS:
										outFile.println("+ Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum));
										break;
								case sym.MINUS:
										outFile.println("- Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum));
										break;
								case sym.TIMES:
										outFile.println("* Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum));
										break;
								case sym.DIVIDE:
										outFile.println("/ Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum));
										break;
								case sym.NOT:
										outFile.println("! Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum));
										break;
								case sym.AND:
										outFile.println("&& Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum));
										break;
								case sym.OR:
										outFile.println("|| Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum));
										break;
								case sym.EQUALS:
										outFile.println("== Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum));
										break;
								case sym.NOTEQUALS:
										outFile.println("!= Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum));
										break;
								case sym.LESS:
										outFile.println("< Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum));
										break;
								case sym.GREATER:
										outFile.println("> Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum));
										break;
								case sym.LESSEQ:
										outFile.println("<= Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum));
										break;
								case sym.GREATEREQ:
										outFile.println(">= Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum));
										break;
								case sym.ASSIGN:
										outFile.println("= Line: " + (((TokenVal)my_token.value).linenum) + "  |  Char: " + (((TokenVal)my_token.value).charnum));
										break;
								default:
										outFile.println("UNKNOWN TOKEN");
										break;
						} // end switch
          	my_token = my_scanner.next_token();
        } // end while
        outFile.close();
    }
}
