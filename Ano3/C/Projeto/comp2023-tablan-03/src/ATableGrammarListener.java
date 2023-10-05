// Generated from ATableGrammar.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ATableGrammarParser}.
 */
public interface ATableGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ATableGrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ATableGrammarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ATableGrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ATableGrammarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementTableDefinition}
	 * labeled alternative in {@link ATableGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementTableDefinition(ATableGrammarParser.StatementTableDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementTableDefinition}
	 * labeled alternative in {@link ATableGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementTableDefinition(ATableGrammarParser.StatementTableDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementAssignment}
	 * labeled alternative in {@link ATableGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementAssignment(ATableGrammarParser.StatementAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementAssignment}
	 * labeled alternative in {@link ATableGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementAssignment(ATableGrammarParser.StatementAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementPrint}
	 * labeled alternative in {@link ATableGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementPrint(ATableGrammarParser.StatementPrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementPrint}
	 * labeled alternative in {@link ATableGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementPrint(ATableGrammarParser.StatementPrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementAddRow}
	 * labeled alternative in {@link ATableGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementAddRow(ATableGrammarParser.StatementAddRowContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementAddRow}
	 * labeled alternative in {@link ATableGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementAddRow(ATableGrammarParser.StatementAddRowContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementHeader}
	 * labeled alternative in {@link ATableGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementHeader(ATableGrammarParser.StatementHeaderContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementHeader}
	 * labeled alternative in {@link ATableGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementHeader(ATableGrammarParser.StatementHeaderContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementLoop}
	 * labeled alternative in {@link ATableGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementLoop(ATableGrammarParser.StatementLoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementLoop}
	 * labeled alternative in {@link ATableGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementLoop(ATableGrammarParser.StatementLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link ATableGrammarParser#tableDefinition}.
	 * @param ctx the parse tree
	 */
	void enterTableDefinition(ATableGrammarParser.TableDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ATableGrammarParser#tableDefinition}.
	 * @param ctx the parse tree
	 */
	void exitTableDefinition(ATableGrammarParser.TableDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ATableGrammarParser#formulaDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFormulaDefinition(ATableGrammarParser.FormulaDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ATableGrammarParser#formulaDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFormulaDefinition(ATableGrammarParser.FormulaDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ATableGrammarParser#tableColumnDefinition}.
	 * @param ctx the parse tree
	 */
	void enterTableColumnDefinition(ATableGrammarParser.TableColumnDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ATableGrammarParser#tableColumnDefinition}.
	 * @param ctx the parse tree
	 */
	void exitTableColumnDefinition(ATableGrammarParser.TableColumnDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DataTypeInteger}
	 * labeled alternative in {@link ATableGrammarParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterDataTypeInteger(ATableGrammarParser.DataTypeIntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DataTypeInteger}
	 * labeled alternative in {@link ATableGrammarParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitDataTypeInteger(ATableGrammarParser.DataTypeIntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DataTypeReal}
	 * labeled alternative in {@link ATableGrammarParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterDataTypeReal(ATableGrammarParser.DataTypeRealContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DataTypeReal}
	 * labeled alternative in {@link ATableGrammarParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitDataTypeReal(ATableGrammarParser.DataTypeRealContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DataTypeText}
	 * labeled alternative in {@link ATableGrammarParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterDataTypeText(ATableGrammarParser.DataTypeTextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DataTypeText}
	 * labeled alternative in {@link ATableGrammarParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitDataTypeText(ATableGrammarParser.DataTypeTextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FieldAccessAssignment}
	 * labeled alternative in {@link ATableGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterFieldAccessAssignment(ATableGrammarParser.FieldAccessAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FieldAccessAssignment}
	 * labeled alternative in {@link ATableGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitFieldAccessAssignment(ATableGrammarParser.FieldAccessAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdentifierAssignment}
	 * labeled alternative in {@link ATableGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierAssignment(ATableGrammarParser.IdentifierAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdentifierAssignment}
	 * labeled alternative in {@link ATableGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierAssignment(ATableGrammarParser.IdentifierAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ATableGrammarParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(ATableGrammarParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ATableGrammarParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(ATableGrammarParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ATableGrammarParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(ATableGrammarParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ATableGrammarParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(ATableGrammarParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ATableGrammarParser#addRowStatement}.
	 * @param ctx the parse tree
	 */
	void enterAddRowStatement(ATableGrammarParser.AddRowStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ATableGrammarParser#addRowStatement}.
	 * @param ctx the parse tree
	 */
	void exitAddRowStatement(ATableGrammarParser.AddRowStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ATableGrammarParser#tableRef}.
	 * @param ctx the parse tree
	 */
	void enterTableRef(ATableGrammarParser.TableRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ATableGrammarParser#tableRef}.
	 * @param ctx the parse tree
	 */
	void exitTableRef(ATableGrammarParser.TableRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ATableGrammarParser#headerStatement}.
	 * @param ctx the parse tree
	 */
	void enterHeaderStatement(ATableGrammarParser.HeaderStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ATableGrammarParser#headerStatement}.
	 * @param ctx the parse tree
	 */
	void exitHeaderStatement(ATableGrammarParser.HeaderStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ATableGrammarParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void enterLoopStatement(ATableGrammarParser.LoopStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ATableGrammarParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void exitLoopStatement(ATableGrammarParser.LoopStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ATableGrammarParser#centerExpression}.
	 * @param ctx the parse tree
	 */
	void enterCenterExpression(ATableGrammarParser.CenterExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ATableGrammarParser#centerExpression}.
	 * @param ctx the parse tree
	 */
	void exitCenterExpression(ATableGrammarParser.CenterExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ATableGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ATableGrammarParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ATableGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ATableGrammarParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NewPrimary}
	 * labeled alternative in {@link ATableGrammarParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterNewPrimary(ATableGrammarParser.NewPrimaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NewPrimary}
	 * labeled alternative in {@link ATableGrammarParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitNewPrimary(ATableGrammarParser.NewPrimaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fieldAccessPrimary}
	 * labeled alternative in {@link ATableGrammarParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterFieldAccessPrimary(ATableGrammarParser.FieldAccessPrimaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fieldAccessPrimary}
	 * labeled alternative in {@link ATableGrammarParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitFieldAccessPrimary(ATableGrammarParser.FieldAccessPrimaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdentifierPrimary}
	 * labeled alternative in {@link ATableGrammarParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierPrimary(ATableGrammarParser.IdentifierPrimaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdentifierPrimary}
	 * labeled alternative in {@link ATableGrammarParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierPrimary(ATableGrammarParser.IdentifierPrimaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntegerLiteralPrimary}
	 * labeled alternative in {@link ATableGrammarParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterIntegerLiteralPrimary(ATableGrammarParser.IntegerLiteralPrimaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntegerLiteralPrimary}
	 * labeled alternative in {@link ATableGrammarParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitIntegerLiteralPrimary(ATableGrammarParser.IntegerLiteralPrimaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RealLiteralPrimary}
	 * labeled alternative in {@link ATableGrammarParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterRealLiteralPrimary(ATableGrammarParser.RealLiteralPrimaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RealLiteralPrimary}
	 * labeled alternative in {@link ATableGrammarParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitRealLiteralPrimary(ATableGrammarParser.RealLiteralPrimaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringLiteralPrimary}
	 * labeled alternative in {@link ATableGrammarParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteralPrimary(ATableGrammarParser.StringLiteralPrimaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringLiteralPrimary}
	 * labeled alternative in {@link ATableGrammarParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteralPrimary(ATableGrammarParser.StringLiteralPrimaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesisPrimary}
	 * labeled alternative in {@link ATableGrammarParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterParenthesisPrimary(ATableGrammarParser.ParenthesisPrimaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesisPrimary}
	 * labeled alternative in {@link ATableGrammarParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitParenthesisPrimary(ATableGrammarParser.ParenthesisPrimaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DataTypePrimary}
	 * labeled alternative in {@link ATableGrammarParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterDataTypePrimary(ATableGrammarParser.DataTypePrimaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DataTypePrimary}
	 * labeled alternative in {@link ATableGrammarParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitDataTypePrimary(ATableGrammarParser.DataTypePrimaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListPrimary}
	 * labeled alternative in {@link ATableGrammarParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterListPrimary(ATableGrammarParser.ListPrimaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListPrimary}
	 * labeled alternative in {@link ATableGrammarParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitListPrimary(ATableGrammarParser.ListPrimaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReadPrimary}
	 * labeled alternative in {@link ATableGrammarParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterReadPrimary(ATableGrammarParser.ReadPrimaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReadPrimary}
	 * labeled alternative in {@link ATableGrammarParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitReadPrimary(ATableGrammarParser.ReadPrimaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LengthPrimary}
	 * labeled alternative in {@link ATableGrammarParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterLengthPrimary(ATableGrammarParser.LengthPrimaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LengthPrimary}
	 * labeled alternative in {@link ATableGrammarParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitLengthPrimary(ATableGrammarParser.LengthPrimaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TableRefPrimary}
	 * labeled alternative in {@link ATableGrammarParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterTableRefPrimary(ATableGrammarParser.TableRefPrimaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TableRefPrimary}
	 * labeled alternative in {@link ATableGrammarParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitTableRefPrimary(ATableGrammarParser.TableRefPrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link ATableGrammarParser#fieldAccess}.
	 * @param ctx the parse tree
	 */
	void enterFieldAccess(ATableGrammarParser.FieldAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link ATableGrammarParser#fieldAccess}.
	 * @param ctx the parse tree
	 */
	void exitFieldAccess(ATableGrammarParser.FieldAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link ATableGrammarParser#readStatement}.
	 * @param ctx the parse tree
	 */
	void enterReadStatement(ATableGrammarParser.ReadStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ATableGrammarParser#readStatement}.
	 * @param ctx the parse tree
	 */
	void exitReadStatement(ATableGrammarParser.ReadStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ATableGrammarParser#usingClause}.
	 * @param ctx the parse tree
	 */
	void enterUsingClause(ATableGrammarParser.UsingClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ATableGrammarParser#usingClause}.
	 * @param ctx the parse tree
	 */
	void exitUsingClause(ATableGrammarParser.UsingClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ATableGrammarParser#columnMapping}.
	 * @param ctx the parse tree
	 */
	void enterColumnMapping(ATableGrammarParser.ColumnMappingContext ctx);
	/**
	 * Exit a parse tree produced by {@link ATableGrammarParser#columnMapping}.
	 * @param ctx the parse tree
	 */
	void exitColumnMapping(ATableGrammarParser.ColumnMappingContext ctx);
}