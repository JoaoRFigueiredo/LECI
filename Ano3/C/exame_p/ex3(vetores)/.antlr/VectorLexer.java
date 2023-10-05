// Generated from /home/joao/Desktop/ECI-Ano-3/C/exame_p/ex3(vetores)/Vector.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class VectorLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		VECTOR=10, NUMBER=11, FLOAT=12, INT=13, ID=14, Comment=15, WS=16, ERROR=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"VECTOR", "NUMBER", "FLOAT", "INT", "ID", "Comment", "WS", "ERROR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'show'", "'->'", "'+'", "'-'", "'*'", "'.'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "VECTOR", 
			"NUMBER", "FLOAT", "INT", "ID", "Comment", "WS", "ERROR"
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


	public VectorLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Vector.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\23u\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3"+
		"\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\7\13@\n\13\f\13\16\13C\13\13\3"+
		"\13\3\13\3\f\3\f\5\fI\n\f\3\r\6\rL\n\r\r\r\16\rM\3\r\3\r\6\rR\n\r\r\r"+
		"\16\rS\3\16\6\16W\n\16\r\16\16\16X\3\17\3\17\7\17]\n\17\f\17\16\17`\13"+
		"\17\3\20\3\20\7\20d\n\20\f\20\16\20g\13\20\3\20\3\20\3\20\3\20\3\21\6"+
		"\21n\n\21\r\21\16\21o\3\21\3\21\3\22\3\22\3e\2\23\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23\3\2\6\3"+
		"\2\62;\3\2c|\4\2\62;c|\5\2\13\f\17\17\"\"\2|\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\3%\3\2\2\2\5\'\3\2\2"+
		"\2\7,\3\2\2\2\t/\3\2\2\2\13\61\3\2\2\2\r\63\3\2\2\2\17\65\3\2\2\2\21\67"+
		"\3\2\2\2\239\3\2\2\2\25;\3\2\2\2\27H\3\2\2\2\31K\3\2\2\2\33V\3\2\2\2\35"+
		"Z\3\2\2\2\37a\3\2\2\2!m\3\2\2\2#s\3\2\2\2%&\7=\2\2&\4\3\2\2\2\'(\7u\2"+
		"\2()\7j\2\2)*\7q\2\2*+\7y\2\2+\6\3\2\2\2,-\7/\2\2-.\7@\2\2.\b\3\2\2\2"+
		"/\60\7-\2\2\60\n\3\2\2\2\61\62\7/\2\2\62\f\3\2\2\2\63\64\7,\2\2\64\16"+
		"\3\2\2\2\65\66\7\60\2\2\66\20\3\2\2\2\678\7*\2\28\22\3\2\2\29:\7+\2\2"+
		":\24\3\2\2\2;<\7]\2\2<A\5\27\f\2=>\7.\2\2>@\5\27\f\2?=\3\2\2\2@C\3\2\2"+
		"\2A?\3\2\2\2AB\3\2\2\2BD\3\2\2\2CA\3\2\2\2DE\7_\2\2E\26\3\2\2\2FI\5\33"+
		"\16\2GI\5\31\r\2HF\3\2\2\2HG\3\2\2\2I\30\3\2\2\2JL\t\2\2\2KJ\3\2\2\2L"+
		"M\3\2\2\2MK\3\2\2\2MN\3\2\2\2NO\3\2\2\2OQ\7\60\2\2PR\t\2\2\2QP\3\2\2\2"+
		"RS\3\2\2\2SQ\3\2\2\2ST\3\2\2\2T\32\3\2\2\2UW\t\2\2\2VU\3\2\2\2WX\3\2\2"+
		"\2XV\3\2\2\2XY\3\2\2\2Y\34\3\2\2\2Z^\t\3\2\2[]\t\4\2\2\\[\3\2\2\2]`\3"+
		"\2\2\2^\\\3\2\2\2^_\3\2\2\2_\36\3\2\2\2`^\3\2\2\2ae\7%\2\2bd\13\2\2\2"+
		"cb\3\2\2\2dg\3\2\2\2ef\3\2\2\2ec\3\2\2\2fh\3\2\2\2ge\3\2\2\2hi\7\f\2\2"+
		"ij\3\2\2\2jk\b\20\2\2k \3\2\2\2ln\t\5\2\2ml\3\2\2\2no\3\2\2\2om\3\2\2"+
		"\2op\3\2\2\2pq\3\2\2\2qr\b\21\2\2r\"\3\2\2\2st\13\2\2\2t$\3\2\2\2\13\2"+
		"AHMSX^eo\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}