import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

@SuppressWarnings("CheckReturnValue")
public class Execute extends FracLangBaseVisitor<Fraction> {
   Map<String, Fraction> symbolTable = new HashMap<>();
   Scanner sc = new Scanner(System.in);

   // @Override public Fraction visitCommand(FracLangParser.CommandContext ctx) {
   //    Fraction res = null;
   //    return visitChildren(ctx);
   //    //return res;
   // }

   // @Override public Fraction visitStat(FracLangParser.StatContext ctx) {
   //    Fraction res = null;
   //    return visitChildren(ctx);
   //    //return res;
   // }

   @Override public Fraction visitAssignment(FracLangParser.AssignmentContext ctx) {
      Fraction res = visit(ctx.expr());
      String id = ctx.ID().getText();
      if (res != null){
         symbolTable.put(id, res);
      }
      //return visitChildren(ctx);
      return res;
   }

   @Override public Fraction visitDisplay(FracLangParser.DisplayContext ctx) {
      Fraction res = visit(ctx.expr());
      if (res != null){
         System.out.println(res);
      }
      //return visitChildren(ctx);
      return res;
   }

   @Override public Fraction visitExprID(FracLangParser.ExprIDContext ctx) {
      Fraction res = null;
      String id = ctx.ID().getText();
      if (symbolTable.containsKey(id)){
         res = symbolTable.get(id);
      }
      //return visitChildren(ctx);
      return res;
   }

   @Override public Fraction visitExprFraction(FracLangParser.ExprFractionContext ctx) {
      Fraction res = null;
      String frac = ctx.Fraction().getText();
      res = new Fraction(frac);

      if (res.flag()){
         System.err.println("ERROR: Invalid fraction");
      }
      //return visitChildren(ctx);
      return res;
   }

   @Override public Fraction visitExprMultDiv(FracLangParser.ExprMultDivContext ctx) {
       Fraction res = null;
      Fraction f1 = visit(ctx.expr(0));
      Fraction f2 = visit(ctx.expr(1));
      String op = ctx.op.getText();
      switch (op){
         case "*":
         res = f1.mul(f2);
         break;

         case ":":
         res = f1.div(f2);
         break;
      }

      //return visitChildren(ctx);
      return res;
   }

   @Override public Fraction visitExprAddSub(FracLangParser.ExprAddSubContext ctx) {
      Fraction res = null;
      Fraction f1 = visit(ctx.expr(0));
      Fraction f2 = visit(ctx.expr(1));
      String op = ctx.op.getText();
      switch (op){
         case "+":
         res = f1.add(f2);
         break;

         case "-":
         res = f1.sub(f2);
         break;
      }

      //return visitChildren(ctx);
      return res;
   }

   @Override public Fraction visitExprUnary(FracLangParser.ExprUnaryContext ctx) {
      Fraction res = visit(ctx.expr());
      String op = ctx.op.getText();
      
      switch(op){
         case "+":
         break;


         case "-":
         res = res.negate();
         break;

      }

      //return visitChildren(ctx);
      return res;
   }

   @Override public Fraction visitExprPar(FracLangParser.ExprParContext ctx) {
     Fraction res = visit(ctx.expr());
      //return visitChildren(ctx);
      return res;
   }

   @Override public Fraction visitExprRead(FracLangParser.ExprReadContext ctx) {
    String toPrint = ctx.STRING().getText();
     if (toPrint != null){
      System.out.print(toPrint.substring(1, toPrint.length()-1)+": ");
     }
      //return visitChildren(ctx);
      return new Fraction(sc.nextLine());
   }

   @Override public Fraction visitExprReduce(FracLangParser.ExprReduceContext ctx) {
    Fraction res = visit(ctx.expr());

    res = res.reduce();

    return res;
   }

   
}
