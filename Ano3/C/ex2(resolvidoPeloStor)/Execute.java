import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


@SuppressWarnings("CheckReturnValue")
public class Execute extends FracLangBaseVisitor<Fraction> {

   // @Override public Fraction visitProgram(FracLangParser.ProgramContext ctx) {
   //    Fraction res = null;
   //    return visitChildren(ctx);
   //    //return res;
   // }

   // @Override public Fraction visitCommand(FracLangParser.CommandContext ctx) {
   //    Fraction res = null;
   //    //return visitChildren(ctx);
   //    return res;
   // }

   @Override public Fraction visitDisplay(FracLangParser.DisplayContext ctx) {
      Fraction res = visit(ctx.expr());
      if (res != null){
         System.out.println(res);
      }
      //return visitChildren(ctx);
      return res;
   }

   @Override public Fraction visitAssignment(FracLangParser.AssignmentContext ctx) {
      Fraction res = visit(ctx.expr());
      String id = ctx.ID().getText();
      if (res != null){
         System.out.println(res);
         symbolTable.put(id, res);
      }
      
      //return visitChildren(ctx);
      return res;
   }

     @Override public Fraction visitExprUnary(FracLangParser.ExprUnaryContext ctx) {
      Fraction res = visit(ctx.expr());

      if (res != null){
         if ("-".equals(ctx.op.getText())){
            res = new Fraction(-res.num(), res.den());
         }
      }
      
      return res;
   }

     @Override public Fraction visitExprMultDiv(FracLangParser.ExprMultDivContext ctx) {
      Fraction res = null;

      Fraction e1 = visit(ctx.expr(0));
      Fraction e2 = visit(ctx.expr(1));
      if (e1 != null && e2 != null){
         switch(ctx.op.getText()){
            case "*":
            res = new Fraction(e1.num()*e2.num(), e1.den()*e2.den());
            break;

            case ":":
            res = new Fraction(e1.num()*e2.den(), e1.den()*e2.num());
            break;


         }
      }

      return res;
   }

   @Override public Fraction visitExprAddSub(FracLangParser.ExprAddSubContext ctx) {
      Fraction res = null;
      Fraction e1 = visit(ctx.expr(0));
      Fraction e2 = visit(ctx.expr(1));
      if (e1 != null && e2 != null) {
         switch (ctx.op.getText()) {
            case "+":
               res = new Fraction(e1.num() * e2.den() + e2.num() * e1.den(), e1.den() * e2.den());
               break;
            case "-":
               res = new Fraction(e1.num() * e2.den() - e2.num() * e1.den(), e1.den() * e2.den());
               break;
            default:
               break;
         }
      }
      return res;
   }

      
      
   


   @Override public Fraction visitExprFraction(FracLangParser.ExprFractionContext ctx) {
      String frac = ctx.FRACTION().getText();
      Fraction res = new Fraction(frac);
      if (res.error()){
         System.out.println("ERROR: invalid literal fraction \""+frac+"\"!");
      }
      //return visitChildren(ctx);
      return res;
   }

   @Override public Fraction visitExprID(FracLangParser.ExprIDContext ctx) {
      Fraction res = null;
      String id = ctx.ID().getText();
      if (!symbolTable.containsKey(id)){
         System.err.println("ERROR: variable \""+ id +"\" not found!");
      }
      else{
         res = symbolTable.get(id);
      }
      //return visitChildren(ctx);
      return res;
   }

   private Map<String, Fraction> symbolTable = new HashMap<>();
   private static Scanner in = new Scanner(System.in);
}
