import java.util.Map;
import java.util.HashMap;
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
      return res;
   }

   @Override public String visitAssignment(StrLangParser.AssignmentContext ctx) {
      String res = visit(ctx.expr());
      String id = ctx.ID().getText();
      if (res != null){
         symbolTable.put(id, res);
      }
      return res;
   }

   @Override public String visitExprInput(StrLangParser.ExprInputContext ctx) {
      String pedido = ctx.STRING().getText();
      System.out.print(pedido.substring(1, pedido.length()-1));
      String resposta = sc.nextLine();
      if (resposta == null){
         System.err.println("ERROR: input can not be null!");
      }
      //return visitChildren(ctx);
      //sc.close();
      return resposta;
   }

   @Override public String visitExprString(StrLangParser.ExprStringContext ctx) {
      String res = ctx.STRING().getText();
      res = res.substring(1, res.length()-1);
      return res;
   }

   @Override public String visitExprID(StrLangParser.ExprIDContext ctx) {
      String res = null;
      String id = ctx.ID().getText();
      if (symbolTable.containsKey(id)){
         res = symbolTable.get(id);
      }else{
         System.err.println("ERROR: variable "+id+" not found!");
      }
      return res;
   }


   @Override public String visitExprAddSub(StrLangParser.ExprAddSubContext ctx) {
      String op1 = visit(ctx.expr(0));
      String op2 = visit(ctx.expr(1));
      String res = null;

      if (op1 != null && op2 != null){

      switch (ctx.op.getText()){
         case "+":
         res = op1+op2;
         break;

         case "-":
         res = op1.replace(op2, "");
         break;

      }
      
      }

      return res;
   }

   @Override public String visitExprTrim(StrLangParser.ExprTrimContext ctx) {
      String res = visit(ctx.expr());
      
      if (res != null){
         res = res.trim();
      }

      return res;
   }

   @Override public String visitExprPar(StrLangParser.ExprParContext ctx) {

      return visit(ctx.expr());
     
   }

   @Override public String visitExprReplace(StrLangParser.ExprReplaceContext ctx) { 
      String res = visit(ctx.expr(0));
      String target = visit(ctx.expr(1));
      String replacement = visit(ctx.expr(2));

      if (res != null && target != null && replacement != null){
         res = res.replace(target, replacement);
      }

      return res;
      
   }
}
