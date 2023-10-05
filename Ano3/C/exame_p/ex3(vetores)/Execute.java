import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("CheckReturnValue")
public class Execute extends VectorBaseVisitor<Value> {
   Map<String,Value> symbolTable = new HashMap<>();

   // @Override public Value visitProgram(VectorParser.ProgramContext ctx) {
   //    Value res = null;
   //    return visitChildren(ctx);
   //    //return res;
   // }

   // @Override public Value visitStat(VectorParser.StatContext ctx) {
   //    Value res = null;
   //    return visitChildren(ctx);
   //    //return res;
   // }

   @Override public Value visitShow(VectorParser.ShowContext ctx) {
      Value res = visit(ctx.expr());
      if (res != null){
      
      System.out.println(res);
      }
      //return visitChildren(ctx);
      return res;
   }

   @Override public Value visitAssignment(VectorParser.AssignmentContext ctx) {
      //String res = ctx.expr().getText();
      //System.out.println(ctx.expr().getText());
      Value res = visit(ctx.expr());
      //System.out.println(res);
      String id = ctx.ID().getText();
      if (res != null){
         symbolTable.put(id, res);
      }
      
      return null;
      // return visitChildren(ctx);
   }

   @Override public Value visitExprNumber(VectorParser.ExprNumberContext ctx) {
      return new Scalar(Double.parseDouble(ctx.NUMBER().getText()));
   }


   @Override public Value visitExprPar(VectorParser.ExprParContext ctx) {
      return visit(ctx.expr());
   }

   @Override public Value visitExprArray(VectorParser.ExprArrayContext ctx) {
      return new Vector(ctx.VECTOR().getText());
   }

   @Override public Value visitExprID(VectorParser.ExprIDContext ctx) {
      Value res = null;
      String id = ctx.ID().getText();
      
      if (symbolTable.containsKey(id)){
         
         res = symbolTable.get(id);
      }
      //return visitChildren(ctx);
      return res;
   }

   @Override public Value visitExprUnary(VectorParser.ExprUnaryContext ctx) {
      Value res = visit(ctx.expr());
      String op = ctx.op.getText();
      if (res != null && op == "-"){
         res = res.symmetric();
      }
      return res;
   }

   @Override public Value visitExprAddSub(VectorParser.ExprAddSubContext ctx) {
      Value res1 = visit(ctx.expr(0));
      Value res2 = visit(ctx.expr(1));
     // System.out.println(res1 +"||"+res2);
      String op = ctx.op.getText();
      Value answer = null;

      if (res1 != null && res2 != null){
      switch(op){
         case "+":
         answer = res1.add(res2);
         break;
         
         case "-":
         answer = res1.sub(res2);
         break;
      }
   }

      return answer;

      

      
   }

   @Override public Value visitExprMultInter(VectorParser.ExprMultInterContext ctx) {
      Value res1 = visit(ctx.expr(0));
      Value res2 = visit(ctx.expr(1));
      String op = ctx.op.getText();
      Value answer = null;


      if (res1 != null && res2 != null){
      switch (op) {
         case "*":
            answer = res1.mul(res2);
            break;
         case ".":
            answer = res1.intProd(res2);
            break;
         default:
            break;
      }
   }

   return answer;
      
   }
}