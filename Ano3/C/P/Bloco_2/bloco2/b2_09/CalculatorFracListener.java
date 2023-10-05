// Generated from CalculatorFrac.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalculatorFracParser}.
 */
public interface CalculatorFracListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalculatorFracParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(CalculatorFracParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorFracParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(CalculatorFracParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatAssig}
	 * labeled alternative in {@link CalculatorFracParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatAssig(CalculatorFracParser.StatAssigContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatAssig}
	 * labeled alternative in {@link CalculatorFracParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatAssig(CalculatorFracParser.StatAssigContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Statprint}
	 * labeled alternative in {@link CalculatorFracParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatprint(CalculatorFracParser.StatprintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Statprint}
	 * labeled alternative in {@link CalculatorFracParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatprint(CalculatorFracParser.StatprintContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorFracParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(CalculatorFracParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorFracParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(CalculatorFracParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorFracParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(CalculatorFracParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorFracParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(CalculatorFracParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprAddSub}
	 * labeled alternative in {@link CalculatorFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAddSub(CalculatorFracParser.ExprAddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAddSub}
	 * labeled alternative in {@link CalculatorFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAddSub(CalculatorFracParser.ExprAddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprParent}
	 * labeled alternative in {@link CalculatorFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprParent(CalculatorFracParser.ExprParentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprParent}
	 * labeled alternative in {@link CalculatorFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprParent(CalculatorFracParser.ExprParentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprMultDiv}
	 * labeled alternative in {@link CalculatorFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprMultDiv(CalculatorFracParser.ExprMultDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprMultDiv}
	 * labeled alternative in {@link CalculatorFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprMultDiv(CalculatorFracParser.ExprMultDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprPlusMinus}
	 * labeled alternative in {@link CalculatorFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprPlusMinus(CalculatorFracParser.ExprPlusMinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprPlusMinus}
	 * labeled alternative in {@link CalculatorFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprPlusMinus(CalculatorFracParser.ExprPlusMinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprReduce}
	 * labeled alternative in {@link CalculatorFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprReduce(CalculatorFracParser.ExprReduceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprReduce}
	 * labeled alternative in {@link CalculatorFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprReduce(CalculatorFracParser.ExprReduceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprID}
	 * labeled alternative in {@link CalculatorFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprID(CalculatorFracParser.ExprIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprID}
	 * labeled alternative in {@link CalculatorFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprID(CalculatorFracParser.ExprIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Frac}
	 * labeled alternative in {@link CalculatorFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFrac(CalculatorFracParser.FracContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Frac}
	 * labeled alternative in {@link CalculatorFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFrac(CalculatorFracParser.FracContext ctx);
}