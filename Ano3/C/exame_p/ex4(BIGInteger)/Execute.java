import java.math.BigInteger;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("CheckReturnValue")
public class Execute extends BigIntCalcBaseVisitor<BigInteger> {
   Map<String, BigInteger> symbolTable = new HashMap<>();

   // @Override public BigInteger visitProgram(BigIntCalcParser.ProgramContext ctx) {
   //    BigInteger res = null;
   //    return visitChildren(ctx);
   //    //return res;
   // }

   // @Override public BigInteger visitStat(BigIntCalcParser.StatContext ctx) {
   //    BigInteger res = null;
   //    return visitChildren(ctx);
   //    //return res;
   // }

   @Override public BigInteger visitShow(BigIntCalcParser.ShowContext ctx) {
      BigInteger res = visit(ctx.expr());
      if (res != null){
         System.out.println(res);
      }
      //return visitChildren(ctx);
      return res;
   }

   @Override public BigInteger visitAssignment(BigIntCalcParser.AssignmentContext ctx) {
      BigInteger res = visit(ctx.expr());
      String id = ctx.ID().getText();
      if (res != null){
         symbolTable.put(id, res);
      }
      //return visitChildren(ctx);
      return res;
   }

   @Override public BigInteger visitExprBig(BigIntCalcParser.ExprBigContext ctx) {
      BigInteger res = new BigInteger(ctx.BIGINT().getText());
      
      return res;
   }

   @Override public BigInteger visitExprID(BigIntCalcParser.ExprIDContext ctx) {
      BigInteger res = null;
      String id = ctx.ID().getText();
      if (symbolTable.containsKey(id)){
         res = symbolTable.get(id);
      }
      //return visitChildren(ctx);
      return res;
   }


    @Override public BigInteger visitExprUnary(BigIntCalcParser.ExprUnaryContext ctx) {
      BigInteger res = visit(ctx.expr());
      if (res != null){
         if (ctx.op.getText().equals("-")){
            res = res.negate();
         }
      }
      
      return res;
   }


    @Override public BigInteger visitExprAddSub(BigIntCalcParser.ExprAddSubContext ctx) {
      BigInteger op1 = visit(ctx.expr(0));
      BigInteger op2 = visit(ctx.expr(1));
      BigInteger res = null;
      String op = ctx.op.getText();

      if (op1 != null && op2 != null){
         switch(op){
            case "+":
            res = op1.add(op2);
            break;

            case "-":
            res = op1.subtract(op2);
            break;
         }
      }
      
      return res;
   }


    @Override public BigInteger visitExprMulDivMod(BigIntCalcParser.ExprMulDivModContext ctx) {
      BigInteger op1 = visit(ctx.expr(0));
      BigInteger op2 = visit(ctx.expr(1));
      BigInteger res = null;
      String op = ctx.op.getText();

      if (op1 != null && op2 != null){
         switch(op){
            case "*":
            res = op1.multiply(op2);
            break;

            case "div":
            res = op1.divide(op2);
            break;

            case "mod":
            res = op1.mod(op2);
            break;
         }
      }
      
      return res;
   }

    @Override public BigInteger visitExprPar(BigIntCalcParser.ExprParContext ctx) {
      
      return visit(ctx.expr());
   }
}
