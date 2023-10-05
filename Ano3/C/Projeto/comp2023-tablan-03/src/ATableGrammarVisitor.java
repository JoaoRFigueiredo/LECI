// Generated from ATableGrammar.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ATableGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ATableGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ATableGrammarParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(ATableGrammarParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementTableDefinition}
	 * labeled alternative in {@link ATableGrammarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementTableDefinition(ATableGrammarParser.StatementTableDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementAssignment}
	 * labeled alternative in {@link ATableGrammarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementAssignment(ATableGrammarParser.StatementAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementPrint}
	 * labeled alternative in {@link ATableGrammarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementPrint(ATableGrammarParser.StatementPrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementAddRow}
	 * labeled alternative in {@link ATableGrammarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementAddRow(ATableGrammarParser.StatementAddRowContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementHeader}
	 * labeled alternative in {@link ATableGrammarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementHeader(ATableGrammarParser.StatementHeaderContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementLoop}
	 * labeled alternative in {@link ATableGrammarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementLoop(ATableGrammarParser.StatementLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link ATableGrammarParser#tableDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableDefinition(ATableGrammarParser.TableDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ATableGrammarParser#formulaDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormulaDefinition(ATableGrammarParser.FormulaDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ATableGrammarParser#tableColumnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableColumnDefinition(ATableGrammarParser.TableColumnDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DataTypeInteger}
	 * labeled alternative in {@link ATableGrammarParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataTypeInteger(ATableGrammarParser.DataTypeIntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DataTypeReal}
	 * labeled alternative in {@link ATableGrammarParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataTypeReal(ATableGrammarParser.DataTypeRealContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DataTypeText}
	 * labeled alternative in {@link ATableGrammarParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataTypeText(ATableGrammarParser.DataTypeTextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FieldAccessAssignment}
	 * labeled alternative in {@link ATableGrammarParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldAccessAssignment(ATableGrammarParser.FieldAccessAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdentifierAssignment}
	 * labeled alternative in {@link ATableGrammarParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierAssignment(ATableGrammarParser.IdentifierAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ATableGrammarParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(ATableGrammarParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ATableGrammarParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(ATableGrammarParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ATableGrammarParser#addRowStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddRowStatement(ATableGrammarParser.AddRowStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ATableGrammarParser#tableRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableRef(ATableGrammarParser.TableRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link ATableGrammarParser#headerStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeaderStatement(ATableGrammarParser.HeaderStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ATableGrammarParser#loopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStatement(ATableGrammarParser.LoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ATableGrammarParser#centerExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCenterExpression(ATableGrammarParser.CenterExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ATableGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ATableGrammarParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NewPrimary}
	 * labeled alternative in {@link ATableGrammarParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewPrimary(ATableGrammarParser.NewPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fieldAccessPrimary}
	 * labeled alternative in {@link ATableGrammarParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldAccessPrimary(ATableGrammarParser.FieldAccessPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdentifierPrimary}
	 * labeled alternative in {@link ATableGrammarParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierPrimary(ATableGrammarParser.IdentifierPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntegerLiteralPrimary}
	 * labeled alternative in {@link ATableGrammarParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLiteralPrimary(ATableGrammarParser.IntegerLiteralPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RealLiteralPrimary}
	 * labeled alternative in {@link ATableGrammarParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealLiteralPrimary(ATableGrammarParser.RealLiteralPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringLiteralPrimary}
	 * labeled alternative in {@link ATableGrammarParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteralPrimary(ATableGrammarParser.StringLiteralPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesisPrimary}
	 * labeled alternative in {@link ATableGrammarParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesisPrimary(ATableGrammarParser.ParenthesisPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DataTypePrimary}
	 * labeled alternative in {@link ATableGrammarParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataTypePrimary(ATableGrammarParser.DataTypePrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListPrimary}
	 * labeled alternative in {@link ATableGrammarParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListPrimary(ATableGrammarParser.ListPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReadPrimary}
	 * labeled alternative in {@link ATableGrammarParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadPrimary(ATableGrammarParser.ReadPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LengthPrimary}
	 * labeled alternative in {@link ATableGrammarParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLengthPrimary(ATableGrammarParser.LengthPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TableRefPrimary}
	 * labeled alternative in {@link ATableGrammarParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableRefPrimary(ATableGrammarParser.TableRefPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link ATableGrammarParser#fieldAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldAccess(ATableGrammarParser.FieldAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link ATableGrammarParser#readStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadStatement(ATableGrammarParser.ReadStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ATableGrammarParser#usingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingClause(ATableGrammarParser.UsingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ATableGrammarParser#columnMapping}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnMapping(ATableGrammarParser.ColumnMappingContext ctx);
}