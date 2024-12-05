package com.learn.spark;

import com.learn.spark.antlr.SqlBaseLexer;
import com.learn.spark.antlr.SqlBaseParser;
import com.learn.spark.listener.SparkBaseListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.Map;
import java.util.Set;

public class TestListener {

    public static void main(String[] args) {
        String sql = "CREATE table order_details AS\n" +
                "SELECT\n" +
                "    o.order_id,\n" +
                "    o.order_date,\n" +
                "    o.order_amount,\n" +
                "    u.user_name,\n" +
                "    u.user_email,\n" +
                "    p.product_name,\n" +
                "    p.product_category\n" +
                "FROM\n" +
                "    orders o\n" +
                "JOIN\n" +
                "    users u\n" +
                "ON\n" +
                "    o.user_id = u.user_id\n" +
                "JOIN\n" +
                "    products p\n" +
                "ON\n" +
                "    o.product_id = p.product_id;";
        getDataBaseTablenameAndOper(sql);
    }


    public static void getDataBaseTablenameAndOper(String sql) {

        // ANTLRNoCaseStringStream aa = new ANTLRNoCaseStringStream(sql);
        SqlBaseLexer lexer = new SqlBaseLexer(CharStreams.fromString(sql.toUpperCase()));

        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        SqlBaseParser parser = new SqlBaseParser(tokenStream);
        ParseTreeWalker walker = new ParseTreeWalker();
        SparkBaseListener mySqlBaseBaseListener = new SparkBaseListener();

        SqlBaseParser.StatementContext bb = parser.statement();

        walker.walk(mySqlBaseBaseListener, bb);
    }
}
