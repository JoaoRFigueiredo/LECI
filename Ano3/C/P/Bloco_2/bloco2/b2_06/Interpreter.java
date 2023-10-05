import java.util.HashMap;

@SuppressWarnings("CheckReturnValue")
public class Interpreter extends CalculatorBaseVisitor<Object> {


   HashMap<String, Integer> vars = new HashMap<String, Integer>();

   @Override public Object visitProgram(CalculatorParser.ProgramContext ctx) {
      Object res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Object visitProcessExpr(CalculatorParser.ProcessExprContext ctx) {
      int res = (Integer)visit(ctx.expr());
      System.out.println("Result is: "+res);
      return res; 
   }

   @Override public Object visitProcessAssignment(CalculatorParser.ProcessAssignmentContext ctx) {
      Object res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Object visitAssignment(CalculatorParser.AssignmentContext ctx) {
      // Object res = null;
      // return visitChildren(ctx);
      // //return res;
      String var = (String)visit(ctx.assignment());
      System.out.println("Variable "+var+" stored");
      return var;
   }

   @Override public Object visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
      // Object res = null;
      // return visitChildren(ctx);
      // //return res;
      int n1 = (Integer)visit(ctx.expr(0));
      int n2 = (Integer)visit(ctx.expr(1));
      int res = 0;
      String op = ctx.op.getText();

      switch (op){
         case "+":
         res = n1+n2;
         break;

         case "-":
         res = n1-n2;
         break;

         default:
         break;


      }


      return res;

   }

   @Override public Object visitUnaryPlus(CalculatorParser.UnaryPlusContext ctx) {
      // Object res = null;
      // return visitChildren(ctx);
      // //return res;

      int num = (Integer)visit(ctx.expr());
      return num;
   }

   @Override public Object visitExprParent(CalculatorParser.ExprParentContext ctx) {
      // Object res = null;
      // return visitChildren(ctx);
      // //return res;

      int res = (Integer)visit(ctx.expr());
      return res;
   }

   @Override public Object visitUnaryMinus(CalculatorParser.UnaryMinusContext ctx) {
      // Object res = null;
      // return visitChildren(ctx);
      // //return res;
      int res = (Integer)visit(ctx.expr());
      return res*(-1);

   }

   @Override public Object visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
      // Object res = null;
      // return visitChildren(ctx);
      // //return res;
      int res = Integer.parseInt(ctx.Integer().getText());
      return res;
   }

   @Override public Object visitExprId(CalculatorParser.ExprIdContext ctx) {
      // Object res = null;
      // return visitChildren(ctx);
      // //return res;
      String id = ctx.ID().getText();
      int res = 0;

      if (vars.containsKey(id)){
         res = vars.get(id);
      }
      else{
         System.err.println("variable doesn't exist!");
         System.exit(0);
      }
   }

   @Override public Object visitExprMultDivMod(CalculatorParser.ExprMultDivModContext ctx) {
      // Object res = null;
      // return visitChildren(ctx);
      // //return res;

      int n1 = (Integer)visit(ctx.expr(0));
      int n2 = (Integer)visit(ctx.expr(1));
      int res = 0;
      String op = ctx.op.getText();

      switch (op){
         case "*":
         res = n1*n2;
         break;

         case "/":
         res = n1/n2;
         break;

         case "%":
         res = n1%n2;
         break;

         default:
         break;


      }


      return res;
   }
}
