import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;



@SuppressWarnings("CheckReturnValue")
public class Execute extends FracLangBaseVisitor<Fraction> {
   Map<String, Fraction> symbolTable = new HashMap<>();
   Scanner sc = new Scanner(System.in);

   // @Override public Fraction visitProgram(FracLangParser.ProgramContext ctx) {
   //    Fraction res = null;
   //    return visitChildren(ctx);
   //    //return res;
   // }

   // @Override public Fraction visitStat(FracLangParser.StatContext ctx) {
   //    Fraction res = null;
   //    return visitChildren(ctx);
   //    //return res;
   // }

   @Override public Fraction visitDisplay(FracLangParser.DisplayContext ctx) {
      Fraction res = visit(ctx.expr());
      if (res != null){
         System.out.println(res);
      }
      return res;
   }

   @Override public Fraction visitAssignment(FracLangParser.AssignmentContext ctx) {
      Fraction res = visit(ctx.expr());
      String id = ctx.ID().getText();
      if (res != null){
         symbolTable.put(id, res);
      }
      return res;
   }

   @Override public Fraction visitExprfraction(FracLangParser.ExprfractionContext ctx) {
      Fraction res = new Fraction(ctx.FRACTION().getText());
      if (res.getFlag()){
         System.err.println("ERROR: Fraction "+res+" is invalid!");
      }
      return res;
   }

   @Override public Fraction visitExprID(FracLangParser.ExprIDContext ctx) {
      Fraction res = null;
      String id = ctx.ID().getText();
      if (symbolTable.containsKey(id)){
         res = symbolTable.get(id);
      }
      else{
         System.err.println("ERROR: variable "+id+" not found!");
      }
      return res;
   }


   @Override public Fraction visitExprUnary(FracLangParser.ExprUnaryContext ctx) {
      Fraction res = visit(ctx.expr());
      if (res != null){
         if (ctx.op.getText().equals("-")){
            res = res.negate();
         }
      }

      return res;
   }

   @Override public Fraction visitExprMulDiv(FracLangParser.ExprMulDivContext ctx) {
      Fraction f1 = visit(ctx.expr(0));
      Fraction f2 = visit(ctx.expr(1));
      Fraction res = null;
      if ( f1 != null && f2 != null){
         if (ctx.op.getText().equals("*")){
            res = f1.mul(f2);
         }
         else if (ctx.op.getText().equals(":")){
            res = f1.div(f2);
         }
      }

      return res;
   }

   @Override public Fraction visitExprAddSub(FracLangParser.ExprAddSubContext ctx) {
      Fraction f1 = visit(ctx.expr(0));
      Fraction f2 = visit(ctx.expr(1));
      Fraction res = null;
      if ( f1 != null && f2 != null){
         if (ctx.op.getText().equals("+")){
            res = f1.add(f2);
         }
         else if (ctx.op.getText().equals("-")){
            res = f1.sub(f2);
         }
      }

      return res;
   }


   @Override public Fraction visitExprPar(FracLangParser.ExprParContext ctx) {
      return visit(ctx.expr());
   }


    @Override public Fraction visitExprRead(FracLangParser.ExprReadContext ctx) {
      Fraction res = null;
      String message = ctx.STRING().getText();
      message = message.substring(1, message.length()-1);
      System.out.print(message+": ");
      String fracao = sc.nextLine();
      res = new Fraction(fracao);
      if (res.getFlag()){
         System.err.println("ERROR: Fraction "+fracao+" is invalid!");
      }
      return res;
   }


   @Override public Fraction visitExprReduce(FracLangParser.ExprReduceContext ctx) {
      Fraction res = visit(ctx.expr());
      if (res != null){
         res = res.reduce();
      }
      return res;
   }
   
}
