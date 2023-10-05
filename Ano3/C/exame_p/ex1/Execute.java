import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@SuppressWarnings("CheckReturnValue")
public class Execute extends StrLangBaseVisitor<String> {
   Map<String, String> symbolTable = new HashMap<>();
   Scanner sc = new Scanner(System.in);

   // @Override public String visitProgram(StrLangParser.ProgramContext ctx) {
   //    String res = null;
   //    return visitChildren(ctx);
   //    //return res;
   // }

   // @Override public String visitStat(StrLangParser.StatContext ctx) {
   //    String res = null;
   //    return visitChildren(ctx);
   //    //return res;
   // }

   @Override public String visitPrint(StrLangParser.PrintContext ctx) {
      String res = visit(ctx.expr());
      if (res != null){
         System.out.println(res);
      }
      //return visitChildren(ctx);
      return res;
   }

   @Override public String visitAssignment(StrLangParser.AssignmentContext ctx) {
      String res = visit(ctx.expr());
      String id = ctx.ID().getText();
      //res = visit(ctx.expr());
      //return visitChildren(ctx);
      if (res != null){
         symbolTable.put(id, res);
      }
      return res;
   }

   @Override public String visitExprString(StrLangParser.ExprStringContext ctx) {
      String res = ctx.STRING().getText();
      res = res.substring(1, res.length()-1);
      //return visitChildren(ctx);
      return res;
   }

   @Override public String visitExprID(StrLangParser.ExprIDContext ctx) {
      String id = ctx.ID().getText();
      String res = null;
      if (symbolTable.containsKey(id)){
         res = symbolTable.get(id);
      }
      //return visitChildren(ctx);
      return res;
   }

   @Override public String visitExprInput(StrLangParser.ExprInputContext ctx) {
      String pedido = ctx.expr().getText();
      // System.out.println(pedido.substring(1, pedido.length()-1));
      System.out.print(visit(ctx.expr()));
      //return visitChildren(ctx);
      String res = sc.nextLine();
      return res;
   }

   @Override public String visitExprAddSub(StrLangParser.ExprAddSubContext ctx) {
      String op1 = visit(ctx.expr(0));
      String op2 = visit(ctx.expr(1));
      String operand = ctx.op.getText();
      String res = null;

      switch (operand){

         case "+":
         res = op1+op2;
         break;

         case "-":
         res = op1.replace(op2, "");
         break;
      }

      
      return res;
   }

   @Override public String visitExprTrim(StrLangParser.ExprTrimContext ctx) {
      String res = visit(ctx.expr());
      
      return res.trim();
   }

    @Override public String visitExprPar(StrLangParser.ExprParContext ctx) {
      String res = visit(ctx.expr());
      
      return res;
   }

    @Override public String visitExprReplace(StrLangParser.ExprReplaceContext ctx) {
      String word = visit(ctx.expr(0));
      String op = visit(ctx.expr(1));
      String replacement = visit(ctx.expr(2));
      
      return word.replace(op, replacement);
   }

 
}
