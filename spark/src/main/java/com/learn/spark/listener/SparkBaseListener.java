package com.learn.spark.listener;

import com.learn.spark.antlr.SqlBaseBaseListener;
import com.learn.spark.antlr.SqlBaseParser;
import org.antlr.v4.runtime.tree.ParseTreeWalker;


public class SparkBaseListener extends SqlBaseBaseListener {

    @Override
    public void enterCreateTableHeader(SqlBaseParser.CreateTableHeaderContext ctx) {

        ParseTreeWalker queryWalker = new ParseTreeWalker();
        queryWalker.walk(new SqlBaseBaseListener() {
            public void enterIdentifier(SqlBaseParser.IdentifierContext ctx) {
                System.out.println(ctx.getText());
            }
        }, ctx);
    }

}
