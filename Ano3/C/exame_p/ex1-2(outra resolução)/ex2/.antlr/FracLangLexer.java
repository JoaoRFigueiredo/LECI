// Generated from /home/joao/Desktop/ECI-Ano-3/C/exame_p/ex1-2(outra resolução)/ex2/FracLang.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FracLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, FRACTION=12, STRING=13, ID=14, WS=15, COMENT=16, ERROR=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "FRACTION", "STRING", "ID", "WS", "COMENT", "ERROR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'display'", "'<='", "'+'", "'-'", "'*'", "':'", "'('", 
			"')'", "'read'", "'reduce'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"FRACTION", "STRING", "ID", "WS", "COMENT", "ERROR"
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


	public FracLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FracLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\23~\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3"+
		"\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\r\6\rL\n\r\r\r\16\rM\3\r\3\r\6\rR\n\r\r\r\16\rS\7\rV"+
		"\n\r\f\r\16\rY\13\r\3\16\3\16\7\16]\n\16\f\16\16\16`\13\16\3\16\3\16\3"+
		"\17\6\17e\n\17\r\17\16\17f\3\20\6\20j\n\20\r\20\16\20k\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\7\21t\n\21\f\21\16\21w\13\21\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\4^u\2\23\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23\3\2\5\3\2\62;\3\2c|\5\2\13\f\17\17\"\"\2\u0084"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\3%\3\2\2\2\5\'\3\2\2\2\7/\3\2\2\2\t\62\3\2\2\2\13\64\3\2\2\2\r\66"+
		"\3\2\2\2\178\3\2\2\2\21:\3\2\2\2\23<\3\2\2\2\25>\3\2\2\2\27C\3\2\2\2\31"+
		"K\3\2\2\2\33Z\3\2\2\2\35d\3\2\2\2\37i\3\2\2\2!o\3\2\2\2#|\3\2\2\2%&\7"+
		"=\2\2&\4\3\2\2\2\'(\7f\2\2()\7k\2\2)*\7u\2\2*+\7r\2\2+,\7n\2\2,-\7c\2"+
		"\2-.\7{\2\2.\6\3\2\2\2/\60\7>\2\2\60\61\7?\2\2\61\b\3\2\2\2\62\63\7-\2"+
		"\2\63\n\3\2\2\2\64\65\7/\2\2\65\f\3\2\2\2\66\67\7,\2\2\67\16\3\2\2\28"+
		"9\7<\2\29\20\3\2\2\2:;\7*\2\2;\22\3\2\2\2<=\7+\2\2=\24\3\2\2\2>?\7t\2"+
		"\2?@\7g\2\2@A\7c\2\2AB\7f\2\2B\26\3\2\2\2CD\7t\2\2DE\7g\2\2EF\7f\2\2F"+
		"G\7w\2\2GH\7e\2\2HI\7g\2\2I\30\3\2\2\2JL\t\2\2\2KJ\3\2\2\2LM\3\2\2\2M"+
		"K\3\2\2\2MN\3\2\2\2NW\3\2\2\2OQ\7\61\2\2PR\t\2\2\2QP\3\2\2\2RS\3\2\2\2"+
		"SQ\3\2\2\2ST\3\2\2\2TV\3\2\2\2UO\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2"+
		"X\32\3\2\2\2YW\3\2\2\2Z^\7$\2\2[]\13\2\2\2\\[\3\2\2\2]`\3\2\2\2^_\3\2"+
		"\2\2^\\\3\2\2\2_a\3\2\2\2`^\3\2\2\2ab\7$\2\2b\34\3\2\2\2ce\t\3\2\2dc\3"+
		"\2\2\2ef\3\2\2\2fd\3\2\2\2fg\3\2\2\2g\36\3\2\2\2hj\t\4\2\2ih\3\2\2\2j"+
		"k\3\2\2\2ki\3\2\2\2kl\3\2\2\2lm\3\2\2\2mn\b\20\2\2n \3\2\2\2op\7/\2\2"+
		"pq\7/\2\2qu\3\2\2\2rt\13\2\2\2sr\3\2\2\2tw\3\2\2\2uv\3\2\2\2us\3\2\2\2"+
		"vx\3\2\2\2wu\3\2\2\2xy\7\f\2\2yz\3\2\2\2z{\b\21\2\2{\"\3\2\2\2|}\13\2"+
		"\2\2}$\3\2\2\2\n\2MSW^fku\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}