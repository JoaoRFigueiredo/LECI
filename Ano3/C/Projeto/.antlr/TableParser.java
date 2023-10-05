// Generated from /home/joao/Desktop/ECI-Ano-3/C/Projeto/Table.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TableParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, Identifier=27, IntegerLiteral=28, RealLiteral=29, 
		StringLiteral=30, Whitespace=31, Comment=32;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_tableDefinition = 2, RULE_tableColumnDefinition = 3, 
		RULE_dataType = 4, RULE_assignment = 5, RULE_printStatement = 6, RULE_addRowStatement = 7, 
		RULE_tableRef = 8, RULE_headerStatement = 9, RULE_loopStatement = 10, 
		RULE_expression = 11, RULE_primary = 12, RULE_conversion = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "tableDefinition", "tableColumnDefinition", "dataType", 
			"assignment", "printStatement", "addRowStatement", "tableRef", "headerStatement", 
			"loopStatement", "expression", "primary", "conversion"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'type'", "'table'", "'->'", "'{'", "'}'", "';'", "':'", "':='", 
			"'integer'", "'real'", "'text'", "'='", "'println'", "'['", "','", "']'", 
			"'>>'", "'.'", "'for'", "'in'", "'*'", "'/'", "'+'", "'-'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "Identifier", "IntegerLiteral", "RealLiteral", "StringLiteral", 
			"Whitespace", "Comment"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Table.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TableParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__12) | (1L << T__13) | (1L << T__18) | (1L << Identifier))) != 0)) {
				{
				{
				setState(28);
				statement();
				}
				}
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public TableDefinitionContext tableDefinition() {
			return getRuleContext(TableDefinitionContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public PrintStatementContext printStatement() {
			return getRuleContext(PrintStatementContext.class,0);
		}
		public AddRowStatementContext addRowStatement() {
			return getRuleContext(AddRowStatementContext.class,0);
		}
		public HeaderStatementContext headerStatement() {
			return getRuleContext(HeaderStatementContext.class,0);
		}
		public LoopStatementContext loopStatement() {
			return getRuleContext(LoopStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(40);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(34);
				tableDefinition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(35);
				assignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(36);
				printStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(37);
				addRowStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(38);
				headerStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(39);
				loopStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableDefinitionContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(TableParser.Identifier, 0); }
		public TerminalNode StringLiteral() { return getToken(TableParser.StringLiteral, 0); }
		public List<TableColumnDefinitionContext> tableColumnDefinition() {
			return getRuleContexts(TableColumnDefinitionContext.class);
		}
		public TableColumnDefinitionContext tableColumnDefinition(int i) {
			return getRuleContext(TableColumnDefinitionContext.class,i);
		}
		public TableDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableDefinition; }
	}

	public final TableDefinitionContext tableDefinition() throws RecognitionException {
		TableDefinitionContext _localctx = new TableDefinitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_tableDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(T__0);
			setState(43);
			match(T__1);
			setState(44);
			match(Identifier);
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(45);
				match(T__2);
				setState(46);
				match(StringLiteral);
				}
			}

			setState(49);
			match(T__3);
			setState(51); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(50);
				tableColumnDefinition();
				}
				}
				setState(53); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Identifier );
			setState(55);
			match(T__4);
			setState(56);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableColumnDefinitionContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(TableParser.Identifier, 0); }
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode StringLiteral() { return getToken(TableParser.StringLiteral, 0); }
		public TableColumnDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableColumnDefinition; }
	}

	public final TableColumnDefinitionContext tableColumnDefinition() throws RecognitionException {
		TableColumnDefinitionContext _localctx = new TableColumnDefinitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tableColumnDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(Identifier);
			setState(59);
			match(T__6);
			setState(60);
			dataType();
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(61);
				match(T__7);
				setState(62);
				expression();
				}
			}

			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(65);
				match(T__2);
				setState(66);
				match(StringLiteral);
				}
			}

			setState(69);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataTypeContext extends ParserRuleContext {
		public DataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataType; }
	}

	public final DataTypeContext dataType() throws RecognitionException {
		DataTypeContext _localctx = new DataTypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_dataType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(TableParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(Identifier);
			setState(74);
			match(T__11);
			setState(75);
			expression();
			setState(76);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStatement; }
	}

	public final PrintStatementContext printStatement() throws RecognitionException {
		PrintStatementContext _localctx = new PrintStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_printStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(T__12);
			setState(79);
			expression();
			setState(80);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddRowStatementContext extends ParserRuleContext {
		public TableRefContext tableRef() {
			return getRuleContext(TableRefContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(TableParser.Identifier, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AddRowStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addRowStatement; }
	}

	public final AddRowStatementContext addRowStatement() throws RecognitionException {
		AddRowStatementContext _localctx = new AddRowStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_addRowStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(82);
				match(Identifier);
				}
				break;
			case T__13:
				{
				setState(83);
				match(T__13);
				setState(84);
				expression();
				setState(85);
				match(T__14);
				setState(86);
				expression();
				setState(87);
				match(T__15);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(91);
			match(T__16);
			setState(92);
			tableRef();
			setState(93);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableRefContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(TableParser.Identifier, 0); }
		public TableRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableRef; }
	}

	public final TableRefContext tableRef() throws RecognitionException {
		TableRefContext _localctx = new TableRefContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_tableRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HeaderStatementContext extends ParserRuleContext {
		public TableRefContext tableRef() {
			return getRuleContext(TableRefContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(TableParser.Identifier, 0); }
		public TerminalNode StringLiteral() { return getToken(TableParser.StringLiteral, 0); }
		public HeaderStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_headerStatement; }
	}

	public final HeaderStatementContext headerStatement() throws RecognitionException {
		HeaderStatementContext _localctx = new HeaderStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_headerStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			tableRef();
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__17) {
				{
				setState(98);
				match(T__17);
				setState(99);
				match(Identifier);
				}
			}

			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(102);
				match(T__2);
				setState(103);
				match(StringLiteral);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoopStatementContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(TableParser.Identifier, 0); }
		public TableRefContext tableRef() {
			return getRuleContext(TableRefContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public LoopStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopStatement; }
	}

	public final LoopStatementContext loopStatement() throws RecognitionException {
		LoopStatementContext _localctx = new LoopStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_loopStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(T__18);
			setState(107);
			match(Identifier);
			setState(108);
			match(T__19);
			setState(109);
			tableRef();
			setState(110);
			match(T__3);
			setState(111);
			statement();
			setState(112);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public List<PrimaryContext> primary() {
			return getRuleContexts(PrimaryContext.class);
		}
		public PrimaryContext primary(int i) {
			return getRuleContext(PrimaryContext.class,i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			primary();
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23))) != 0)) {
				{
				{
				setState(115);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(116);
				primary();
				}
				}
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(TableParser.Identifier, 0); }
		public TerminalNode IntegerLiteral() { return getToken(TableParser.IntegerLiteral, 0); }
		public TerminalNode RealLiteral() { return getToken(TableParser.RealLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(TableParser.StringLiteral, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ConversionContext conversion() {
			return getRuleContext(ConversionContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_primary);
		try {
			setState(131);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				match(Identifier);
				}
				break;
			case IntegerLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(123);
				match(IntegerLiteral);
				}
				break;
			case RealLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(124);
				match(RealLiteral);
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(125);
				match(StringLiteral);
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 5);
				{
				setState(126);
				match(T__24);
				setState(127);
				expression();
				setState(128);
				match(T__25);
				}
				break;
			case T__8:
			case T__9:
			case T__10:
				enterOuterAlt(_localctx, 6);
				{
				setState(130);
				conversion();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConversionContext extends ParserRuleContext {
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode StringLiteral() { return getToken(TableParser.StringLiteral, 0); }
		public ConversionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conversion; }
	}

	public final ConversionContext conversion() throws RecognitionException {
		ConversionContext _localctx = new ConversionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_conversion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			dataType();
			setState(134);
			match(T__24);
			setState(135);
			expression();
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(136);
				match(T__14);
				setState(137);
				match(StringLiteral);
				}
			}

			setState(140);
			match(T__25);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\"\u0091\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\7\2 \n\2\f\2\16\2#\13\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\5\3+\n\3\3\4\3\4\3\4\3\4\3\4\5\4\62\n\4\3\4\3\4"+
		"\6\4\66\n\4\r\4\16\4\67\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\5\5B\n\5\3\5\3"+
		"\5\5\5F\n\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\5\t\\\n\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13"+
		"\5\13g\n\13\3\13\3\13\5\13k\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\7\rx\n\r\f\r\16\r{\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\5\16\u0086\n\16\3\17\3\17\3\17\3\17\3\17\5\17\u008d\n\17\3\17\3"+
		"\17\3\17\2\2\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34\2\4\3\2\13\r\3\2\27"+
		"\32\2\u0096\2!\3\2\2\2\4*\3\2\2\2\6,\3\2\2\2\b<\3\2\2\2\nI\3\2\2\2\fK"+
		"\3\2\2\2\16P\3\2\2\2\20[\3\2\2\2\22a\3\2\2\2\24c\3\2\2\2\26l\3\2\2\2\30"+
		"t\3\2\2\2\32\u0085\3\2\2\2\34\u0087\3\2\2\2\36 \5\4\3\2\37\36\3\2\2\2"+
		" #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"\3\3\2\2\2#!\3\2\2\2$+\5\6\4\2%+\5"+
		"\f\7\2&+\5\16\b\2\'+\5\20\t\2(+\5\24\13\2)+\5\26\f\2*$\3\2\2\2*%\3\2\2"+
		"\2*&\3\2\2\2*\'\3\2\2\2*(\3\2\2\2*)\3\2\2\2+\5\3\2\2\2,-\7\3\2\2-.\7\4"+
		"\2\2.\61\7\35\2\2/\60\7\5\2\2\60\62\7 \2\2\61/\3\2\2\2\61\62\3\2\2\2\62"+
		"\63\3\2\2\2\63\65\7\6\2\2\64\66\5\b\5\2\65\64\3\2\2\2\66\67\3\2\2\2\67"+
		"\65\3\2\2\2\678\3\2\2\289\3\2\2\29:\7\7\2\2:;\7\b\2\2;\7\3\2\2\2<=\7\35"+
		"\2\2=>\7\t\2\2>A\5\n\6\2?@\7\n\2\2@B\5\30\r\2A?\3\2\2\2AB\3\2\2\2BE\3"+
		"\2\2\2CD\7\5\2\2DF\7 \2\2EC\3\2\2\2EF\3\2\2\2FG\3\2\2\2GH\7\b\2\2H\t\3"+
		"\2\2\2IJ\t\2\2\2J\13\3\2\2\2KL\7\35\2\2LM\7\16\2\2MN\5\30\r\2NO\7\b\2"+
		"\2O\r\3\2\2\2PQ\7\17\2\2QR\5\30\r\2RS\7\b\2\2S\17\3\2\2\2T\\\7\35\2\2"+
		"UV\7\20\2\2VW\5\30\r\2WX\7\21\2\2XY\5\30\r\2YZ\7\22\2\2Z\\\3\2\2\2[T\3"+
		"\2\2\2[U\3\2\2\2\\]\3\2\2\2]^\7\23\2\2^_\5\22\n\2_`\7\b\2\2`\21\3\2\2"+
		"\2ab\7\35\2\2b\23\3\2\2\2cf\5\22\n\2de\7\24\2\2eg\7\35\2\2fd\3\2\2\2f"+
		"g\3\2\2\2gj\3\2\2\2hi\7\5\2\2ik\7 \2\2jh\3\2\2\2jk\3\2\2\2k\25\3\2\2\2"+
		"lm\7\25\2\2mn\7\35\2\2no\7\26\2\2op\5\22\n\2pq\7\6\2\2qr\5\4\3\2rs\7\7"+
		"\2\2s\27\3\2\2\2ty\5\32\16\2uv\t\3\2\2vx\5\32\16\2wu\3\2\2\2x{\3\2\2\2"+
		"yw\3\2\2\2yz\3\2\2\2z\31\3\2\2\2{y\3\2\2\2|\u0086\7\35\2\2}\u0086\7\36"+
		"\2\2~\u0086\7\37\2\2\177\u0086\7 \2\2\u0080\u0081\7\33\2\2\u0081\u0082"+
		"\5\30\r\2\u0082\u0083\7\34\2\2\u0083\u0086\3\2\2\2\u0084\u0086\5\34\17"+
		"\2\u0085|\3\2\2\2\u0085}\3\2\2\2\u0085~\3\2\2\2\u0085\177\3\2\2\2\u0085"+
		"\u0080\3\2\2\2\u0085\u0084\3\2\2\2\u0086\33\3\2\2\2\u0087\u0088\5\n\6"+
		"\2\u0088\u0089\7\33\2\2\u0089\u008c\5\30\r\2\u008a\u008b\7\21\2\2\u008b"+
		"\u008d\7 \2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\3\2"+
		"\2\2\u008e\u008f\7\34\2\2\u008f\35\3\2\2\2\16!*\61\67AE[fjy\u0085\u008c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}