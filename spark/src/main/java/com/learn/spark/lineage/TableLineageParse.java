package com.learn.spark.lineage;

import com.learn.spark.antlr.SqlBaseBaseVisitor;
import com.learn.spark.antlr.SqlBaseParser;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class

TableLineageParse<T> extends SqlBaseBaseVisitor<T> {


    @Override
    public T visitInsertIntoTable(SqlBaseParser.InsertIntoTableContext ctx) {
        System.out.println("_+_+_+_+_+visitInsertIntoTable_+_+_+_+_+_++_+");
     //   TerminalNode table = ctx.TABLE();
        String text = ctx.getText();
        System.out.println(text);
       // TerminalNode insert = ctx.INSERT();
       // System.out.println(table.getText());
       // System.out.println(Optional.ofNullable(ctx).map(ct -> ct.TABLE().getText()).get());
        return visitChildren(ctx);
    }

    @Override
    public T visitSelectClause(SqlBaseParser.SelectClauseContext ctx) {
        System.out.println("——+——+visitSelectClause+——+——+—");
        String text = ctx.SELECT().getText();
        System.out.println("-=-=-=-=-=-=-=-=" + text);
        return super.visitSelectClause(ctx);
    }

    @Override
    public T visitFromClause(SqlBaseParser.FromClauseContext ctx) {
        System.out.println("——+——+visitFromClause+——+——+—");
        System.out.println(ctx.getText());
        List<SqlBaseParser.RelationContext> relationList = ctx.relation();
        for (SqlBaseParser.RelationContext relationContext : relationList) {

            List<ParseTree> parseTrees = Optional.ofNullable(relationContext)
                    .map(SqlBaseParser.RelationContext::relationPrimary)
                    .map(relationPrimaryContext -> relationPrimaryContext.children)
                    .orElse(null);

            List<SqlBaseParser.JoinRelationContext> joinRelationContexts = Optional.ofNullable(relationContext)
                    .map(SqlBaseParser.RelationContext::joinRelation).
                    orElse(null);
            for (SqlBaseParser.JoinRelationContext joinRelationContext : joinRelationContexts) {
                System.out.println(joinRelationContext.relationPrimary().getText());
                System.out.println(joinRelationContext.joinCriteria().getText());
                System.out.println("哈哈哈哈哈");
            }
        }


   /*     List<SqlBaseParser.RelationContext> relationList = ctx.relation();
        for (SqlBaseParser.RelationContext relationContext : relationList) {
            // System.out.println(relationContext.getText() + "-=-=-=-=-");
            //  System.out.println(relationContext.relationPrimary().getText());
            List<ParseTree> children = relationContext.relationPrimary().children;
            for (ParseTree child : children) {
                if (child instanceof SqlBaseParser.MultipartIdentifierContext) {
                    System.out.println(child.getText());
                }
            }
        }*/
        // filter(relationContext -> relationContext instanceof SqlBaseParser.RelationPrimaryContext)
        System.out.println("_++_+-=");
        return super.visitFromClause(ctx);
    }


    @Override
    public T visitFromStmt(SqlBaseParser.FromStmtContext ctx) {
        String text = ctx.fromStatement().fromClause().getText();
        System.out.println("——+——+visitFromStmt+——+——+—");
        System.out.println(text);
        return visitChildren(ctx);
    }


}
