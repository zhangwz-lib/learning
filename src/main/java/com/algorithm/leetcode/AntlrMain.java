package com.algorithm.leetcode;

import com.algorithm.leetcode.antlr.CalculatorBaseVisitor;
import com.algorithm.leetcode.antlr.CalculatorLexer;
import com.algorithm.leetcode.antlr.CalculatorParser;
import com.algorithm.leetcode.antlr.HelloLexer;
import com.algorithm.leetcode.antlr.HelloParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class AntlrMain {
    public static void main1(String[] args) {
        HelloLexer lexer = new HelloLexer(CharStreams.fromString("hello worldtest"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        HelloParser parser = new HelloParser(tokens);
        ParseTree tree = parser.s();
        System.out.println(tree.toStringTree(parser));


        String expr = "a = 8\n" +
                "b = a * 2\n" +
                "a + b \n"+
                "a - b \n";

        CalculatorLexer lexer1 = new CalculatorLexer(CharStreams.fromString(expr));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer1);
        CalculatorParser parser1 = new CalculatorParser(tokenStream);
        parser.setBuildParseTree(true);
        CalculatorParser.ProgContext root = parser1.prog();
        System.out.println("-=-=-=");

      //  CalculatorBaseVisitor<Integer> vistor = new CalculatorVistorImp();
      //  root.accept(vistor);
    }

    public static void main(String[] args) {

    }
}
