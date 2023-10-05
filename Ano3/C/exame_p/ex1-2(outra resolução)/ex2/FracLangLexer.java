// Generated from FracLang.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class FracLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

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
		"\u0004\u0000\u0011|\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\u000b\u0004\u000bJ\b\u000b\u000b\u000b\f\u000bK\u0001\u000b\u0001"+
		"\u000b\u0004\u000bP\b\u000b\u000b\u000b\f\u000bQ\u0005\u000bT\b\u000b"+
		"\n\u000b\f\u000bW\t\u000b\u0001\f\u0001\f\u0005\f[\b\f\n\f\f\f^\t\f\u0001"+
		"\f\u0001\f\u0001\r\u0004\rc\b\r\u000b\r\f\rd\u0001\u000e\u0004\u000eh"+
		"\b\u000e\u000b\u000e\f\u000ei\u0001\u000e\u0001\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0005\u000fr\b\u000f\n\u000f\f\u000fu\t"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001"+
		"\u0010\u0002\\s\u0000\u0011\u0001\u0001\u0003\u0002\u0005\u0003\u0007"+
		"\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b"+
		"\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011\u0001\u0000"+
		"\u0003\u0001\u000009\u0001\u0000az\u0003\u0000\t\n\r\r  \u0082\u0000\u0001"+
		"\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000"+
		"\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000"+
		"\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000"+
		"\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000"+
		"\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000"+
		"\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000"+
		"\u0000\u0001#\u0001\u0000\u0000\u0000\u0003%\u0001\u0000\u0000\u0000\u0005"+
		"-\u0001\u0000\u0000\u0000\u00070\u0001\u0000\u0000\u0000\t2\u0001\u0000"+
		"\u0000\u0000\u000b4\u0001\u0000\u0000\u0000\r6\u0001\u0000\u0000\u0000"+
		"\u000f8\u0001\u0000\u0000\u0000\u0011:\u0001\u0000\u0000\u0000\u0013<"+
		"\u0001\u0000\u0000\u0000\u0015A\u0001\u0000\u0000\u0000\u0017I\u0001\u0000"+
		"\u0000\u0000\u0019X\u0001\u0000\u0000\u0000\u001bb\u0001\u0000\u0000\u0000"+
		"\u001dg\u0001\u0000\u0000\u0000\u001fm\u0001\u0000\u0000\u0000!z\u0001"+
		"\u0000\u0000\u0000#$\u0005;\u0000\u0000$\u0002\u0001\u0000\u0000\u0000"+
		"%&\u0005d\u0000\u0000&\'\u0005i\u0000\u0000\'(\u0005s\u0000\u0000()\u0005"+
		"p\u0000\u0000)*\u0005l\u0000\u0000*+\u0005a\u0000\u0000+,\u0005y\u0000"+
		"\u0000,\u0004\u0001\u0000\u0000\u0000-.\u0005<\u0000\u0000./\u0005=\u0000"+
		"\u0000/\u0006\u0001\u0000\u0000\u000001\u0005+\u0000\u00001\b\u0001\u0000"+
		"\u0000\u000023\u0005-\u0000\u00003\n\u0001\u0000\u0000\u000045\u0005*"+
		"\u0000\u00005\f\u0001\u0000\u0000\u000067\u0005:\u0000\u00007\u000e\u0001"+
		"\u0000\u0000\u000089\u0005(\u0000\u00009\u0010\u0001\u0000\u0000\u0000"+
		":;\u0005)\u0000\u0000;\u0012\u0001\u0000\u0000\u0000<=\u0005r\u0000\u0000"+
		"=>\u0005e\u0000\u0000>?\u0005a\u0000\u0000?@\u0005d\u0000\u0000@\u0014"+
		"\u0001\u0000\u0000\u0000AB\u0005r\u0000\u0000BC\u0005e\u0000\u0000CD\u0005"+
		"d\u0000\u0000DE\u0005u\u0000\u0000EF\u0005c\u0000\u0000FG\u0005e\u0000"+
		"\u0000G\u0016\u0001\u0000\u0000\u0000HJ\u0007\u0000\u0000\u0000IH\u0001"+
		"\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000"+
		"KL\u0001\u0000\u0000\u0000LU\u0001\u0000\u0000\u0000MO\u0005/\u0000\u0000"+
		"NP\u0007\u0000\u0000\u0000ON\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000"+
		"\u0000QO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000RT\u0001\u0000"+
		"\u0000\u0000SM\u0001\u0000\u0000\u0000TW\u0001\u0000\u0000\u0000US\u0001"+
		"\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000V\u0018\u0001\u0000\u0000"+
		"\u0000WU\u0001\u0000\u0000\u0000X\\\u0005\"\u0000\u0000Y[\t\u0000\u0000"+
		"\u0000ZY\u0001\u0000\u0000\u0000[^\u0001\u0000\u0000\u0000\\]\u0001\u0000"+
		"\u0000\u0000\\Z\u0001\u0000\u0000\u0000]_\u0001\u0000\u0000\u0000^\\\u0001"+
		"\u0000\u0000\u0000_`\u0005\"\u0000\u0000`\u001a\u0001\u0000\u0000\u0000"+
		"ac\u0007\u0001\u0000\u0000ba\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000"+
		"\u0000db\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000e\u001c\u0001"+
		"\u0000\u0000\u0000fh\u0007\u0002\u0000\u0000gf\u0001\u0000\u0000\u0000"+
		"hi\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000"+
		"\u0000jk\u0001\u0000\u0000\u0000kl\u0006\u000e\u0000\u0000l\u001e\u0001"+
		"\u0000\u0000\u0000mn\u0005-\u0000\u0000no\u0005-\u0000\u0000os\u0001\u0000"+
		"\u0000\u0000pr\t\u0000\u0000\u0000qp\u0001\u0000\u0000\u0000ru\u0001\u0000"+
		"\u0000\u0000st\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000tv\u0001"+
		"\u0000\u0000\u0000us\u0001\u0000\u0000\u0000vw\u0005\n\u0000\u0000wx\u0001"+
		"\u0000\u0000\u0000xy\u0006\u000f\u0000\u0000y \u0001\u0000\u0000\u0000"+
		"z{\t\u0000\u0000\u0000{\"\u0001\u0000\u0000\u0000\b\u0000KQU\\dis\u0001"+
		"\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}