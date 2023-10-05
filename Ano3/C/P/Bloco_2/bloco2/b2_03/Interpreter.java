@SuppressWarnings("CheckReturnValue")
public class Interpreter extends CalculatorBaseVisitor<Integer> {

   @Override public Integer visitProgram(CalculatorParser.ProgramContext ctx) {
      Integer res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Integer visitStat(CalculatorParser.StatContext ctx) {
      if (ctx.expr() != null){
         int res = visit(ctx.expr());
         System.out.println(res);
      }

      return null;
   }

   @Override public Integer visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
      switch(ctx.op.getText()){
         case "+": return visit(ctx.expr(0)) + visit(ctx.expr(1));
         case "-": return visit(ctx.expr(0)) - visit(ctx.expr(1));
         default: System.out.println("Error: visitExprSub");
      }

      return null;
   }

   @Override public Integer visitExprParent(CalculatorParser.ExprParentContext ctx) {
      int num = (Integer)visit(ctx.expr());
      return num;
      //return res;
   }

   @Override public Integer visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
      return Integer.parseInt(ctx.Integer().getText());


      //return null;
   }

   @Override public Integer visitExprMultDivMod(CalculatorParser.ExprMultDivModContext ctx) {
      int n1 = (Integer)visit(ctx.expr(0));
      int n2 = (Integer)visit(ctx.expr(1));
      int res = 0;
      String op = ctx.op.getText();


      switch(op){

         case "*":
         res = n1*n2;
         break;
         case "/":
         res = n1/n2;
         break;
         case "%":
         res = n1%n2;
         break;
      }

      return res;
   }
}
