import java.util.HashMap;

@SuppressWarnings("CheckReturnValue")
public class CalcFracVisitor extends CalculatorFracBaseVisitor<Fraction> {
   HashMap<String, Fraction> variables = new HashMap<>();

   @Override public Fraction visitProgram(CalculatorFracParser.ProgramContext ctx) {
      Fraction res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Fraction visitStatAssig(CalculatorFracParser.StatAssigContext ctx) {
      Fraction res = null;
      return visit(ctx.assignment());
      //return res;
   }

   @Override public Fraction visitStatprint(CalculatorFracParser.StatprintContext ctx) {
      Fraction res = null;
      return visit(ctx.print());
      //return res;
   }

   @Override public Fraction visitPrint(CalculatorFracParser.PrintContext ctx) {
      Fraction res = visit(ctx.expr());
      System.out.println(res);
      return null;
      //return res;
   }

   @Override public Fraction visitAssignment(CalculatorFracParser.AssignmentContext ctx) {
      Fraction res = null;
      String key = ctx.ID().getText();
      Fraction f = visit(ctx.expr());
      variables.put(key, f);
      return f;
      //return res;
   }

   @Override public Fraction visitExprAddSub(CalculatorFracParser.ExprAddSubContext ctx) {
      Fraction res = null;
      if (ctx.op.getText().equals("+")){
         return visit(ctx.expr(0)).addTo(visit(ctx.expr(1)));
      }
      else if (ctx.op.getText().equals("-")){
         return visit(ctx.expr(0)).subTo(visit(ctx.expr(1)));
      }

      return null;
      //return res;
   }

   @Override public Fraction visitExprParent(CalculatorFracParser.ExprParentContext ctx) {
      Fraction res = null;
      return visit(ctx.expr());  
      //return res;
   }

   @Override public Fraction visitExprMultDiv(CalculatorFracParser.ExprMultDivContext ctx) {
      Fraction res = null;
      if (ctx.op.getText().equals("*")){
         return visit(ctx.expr(0)).mulTo(visit(ctx.expr(1)));
      }
      else if (ctx.op.getText().equals("/")){
         return visit(ctx.expr(0)).divTo(visit(ctx.expr(1)));
      }

      return null;
      //return res;
   }

   @Override public Fraction visitExprPlusMinus(CalculatorFracParser.ExprPlusMinusContext ctx) {
      Fraction res = null;
      if (ctx.op.getText().equals("-")){
         return new Fraction().subTo(visit(ctx.expr()));

      }
      else if (ctx.op.getText().equals("+")){
         return visit(ctx.expr());
      }

      return null;
      //return res;
   }

   @Override public Fraction visitExprReduce(CalculatorFracParser.ExprReduceContext ctx) {
      Fraction res = null;
      return new Fraction(visit(ctx.expr()));
      //return res;
   }

   @Override public Fraction visitExprID(CalculatorFracParser.ExprIDContext ctx) {
      Fraction res = null;
      return variables.get(ctx.ID().getText());
      //return res;
   }

   @Override public Fraction visitFrac(CalculatorFracParser.FracContext ctx) {
      Fraction res = null;
      return new Fraction(Integer.parseInt(ctx.Integer(0).getText()), Integer.parseInt(ctx.Integer(1).getText()));
      //return res;
   }
}
