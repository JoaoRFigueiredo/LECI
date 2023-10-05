import java.util.Map;
import java.util.HashMap;




@SuppressWarnings("CheckReturnValue")
public class Execute extends LangComplexBaseVisitor<ComplexNumber> {
   Map<String, ComplexNumber> symbolTable = new HashMap<>();

   // @Override public ComplexNumber visitProgram(LangComplexParser.ProgramContext ctx) {
   //    ComplexNumber res = null;
   //    return visitChildren(ctx);
   //    //return res;
   // }

   // @Override public ComplexNumber visitStat(LangComplexParser.StatContext ctx) {
   //    ComplexNumber res = null;
   //    return visitChildren(ctx);
   //    //return res;
   // }

   @Override public ComplexNumber visitDisplay(LangComplexParser.DisplayContext ctx) {
      ComplexNumber res = visit(ctx.expr());
      if (res != null){
         System.out.println(res);
         
      }
      return res;
   }

   @Override public ComplexNumber visitAssignment(LangComplexParser.AssignmentContext ctx) {
      ComplexNumber res = visit(ctx.expr());
      String id = ctx.ID().getText();
      if (res != null){
         symbolTable.put(id, res);
      }
      return res;
   }

   @Override public ComplexNumber visitExprComplex(LangComplexParser.ExprComplexContext ctx) {
      String str = ctx.COMPLEX().getText();
      //System.out.println(str);
      ComplexNumber res = null;
      if (str != ""){
      res = new ComplexNumber(str);
      }
      //return visitChildren(ctx);
      return res;
   }

   @Override public ComplexNumber visitExprReal(LangComplexParser.ExprRealContext ctx) {
      double d = Double.parseDouble(ctx.REAL().getText());
      ComplexNumber res = new ComplexNumber(d, 0);
      //return visitChildren(ctx);
      return res;
   }

   @Override public ComplexNumber visitExprIma(LangComplexParser.ExprImaContext ctx) {
      String imaginary = ctx.IMAGINARY().getText().replace("i", "");
      int img = 1;
      if (imaginary == ""){
         img = 1;
      }

      else if (imaginary == "-"){
         img = -1;
      }

      else{
         img = Integer.parseInt(imaginary);
      }
      ComplexNumber res = new ComplexNumber(0, img);
      //return visitChildren(ctx);
      return res;
   }

   @Override public ComplexNumber visitExprPar(LangComplexParser.ExprParContext ctx) {
      
      return visit(ctx.expr());
   }

   //

   @Override public ComplexNumber visitExprMod(LangComplexParser.ExprModContext ctx) {
      
     ComplexNumber res = visit(ctx.expr());
      if (res != null){
         System.out.println(res.mod());
      }
      return null;
   }

   @Override public ComplexNumber visitExprGetReal(LangComplexParser.ExprGetRealContext ctx) {
      
      ComplexNumber res = visit(ctx.expr());
      if (res == null){
         System.err.printf("ERROR:");
      }
      return new ComplexNumber(res.getReal(), 0);
   }

   @Override public ComplexNumber visitExprGetIm(LangComplexParser.ExprGetImContext ctx) {
      ComplexNumber res = visit(ctx.expr());
      if (res == null){
         System.err.printf("ERROR:");
      }
      return new ComplexNumber(0, res.getImaginary());
   }

   @Override public ComplexNumber visitExprConjugado(LangComplexParser.ExprConjugadoContext ctx) {
      
      ComplexNumber res = visit(ctx.expr());
      if (res != null){
         res = res.conjugado();
      }
      
      return res;
   }


   @Override public ComplexNumber visitExprID(LangComplexParser.ExprIDContext ctx) {
      ComplexNumber res = null;
      String id = ctx.ID().getText();
      if (symbolTable.containsKey(id)){
         res = symbolTable.get(id);
      }
      return res;
   }


   @Override public ComplexNumber visitExprAddSub(LangComplexParser.ExprAddSubContext ctx) {
      String op = ctx.op.getText();
      ComplexNumber c1 = visit(ctx.expr(0));
      ComplexNumber c2 = visit(ctx.expr(1));
      ComplexNumber res = null;
      if (c1 != null && c2 != null){
      if (op.equals("-")){
         res = c1.sub(c2);
      }
      else if (op.equals("+")){
         res = c1.add(c2);
      }
   }
      //return visitChildren(ctx);
      return res;
   }
   

   @Override public ComplexNumber visitExprUnary(LangComplexParser.ExprUnaryContext ctx) {
      String op = ctx.op.getText();
      ComplexNumber cn = visit(ctx.expr());
      if (cn != null){
      if (op.equals("-")){
         cn = cn.negate();
      }
   }
      //return visitChildren(ctx);
      return cn;
   }

   @Override public ComplexNumber visitExprMulDiv(LangComplexParser.ExprMulDivContext ctx) {
      String op = ctx.op.getText();
      ComplexNumber c1 = visit(ctx.expr(0));
      ComplexNumber c2 = visit(ctx.expr(1));
      ComplexNumber res = null;
      if (c1 != null && c2 != null){
      if (op.equals(":")){
         res = c1.div(c2);
      }
      else if (op.equals("*")){
         res = c1.mul(c2);
      }
   }
      //return visitChildren(ctx);
      return res;
   }



   
}
