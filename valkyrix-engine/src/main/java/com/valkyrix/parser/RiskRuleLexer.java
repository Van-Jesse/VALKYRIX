// Generated from C:/lab/RiskRule.g4 by ANTLR 4.13.1
package com.valkyrix.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class RiskRuleLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, NUMBER=14, STRING=15, IDENTIFIER=16, 
		WS=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "NUMBER", "STRING", "IDENTIFIER", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'||'", "'&&'", "'<'", "'>'", "'=='", "'!='", "'+'", "'-'", "'*'", 
			"'/'", "'('", "')'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "NUMBER", "STRING", "IDENTIFIER", "WS"
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


	public RiskRuleLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "RiskRule.g4"; }

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
		"\u0004\u0000\u0011n\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\r\u0004\rC\b\r\u000b\r\f\rD\u0001\r\u0001\r\u0004\rI"+
		"\b\r\u000b\r\f\rJ\u0003\rM\b\r\u0001\u000e\u0001\u000e\u0005\u000eQ\b"+
		"\u000e\n\u000e\f\u000eT\t\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005"+
		"\u000eY\b\u000e\n\u000e\f\u000e\\\t\u000e\u0001\u000e\u0003\u000e_\b\u000e"+
		"\u0001\u000f\u0001\u000f\u0005\u000fc\b\u000f\n\u000f\f\u000ff\t\u000f"+
		"\u0001\u0010\u0004\u0010i\b\u0010\u000b\u0010\f\u0010j\u0001\u0010\u0001"+
		"\u0010\u0002RZ\u0000\u0011\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004"+
		"\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017"+
		"\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011\u0001\u0000\u0004"+
		"\u0001\u000009\u0003\u0000AZ__az\u0004\u000009AZ__az\u0003\u0000\t\n\r"+
		"\r  u\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000"+
		"\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000"+
		"\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000"+
		"\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000"+
		"\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000"+
		"\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000"+
		"\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000"+
		"\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000"+
		"!\u0001\u0000\u0000\u0000\u0001#\u0001\u0000\u0000\u0000\u0003&\u0001"+
		"\u0000\u0000\u0000\u0005)\u0001\u0000\u0000\u0000\u0007+\u0001\u0000\u0000"+
		"\u0000\t-\u0001\u0000\u0000\u0000\u000b0\u0001\u0000\u0000\u0000\r3\u0001"+
		"\u0000\u0000\u0000\u000f5\u0001\u0000\u0000\u0000\u00117\u0001\u0000\u0000"+
		"\u0000\u00139\u0001\u0000\u0000\u0000\u0015;\u0001\u0000\u0000\u0000\u0017"+
		"=\u0001\u0000\u0000\u0000\u0019?\u0001\u0000\u0000\u0000\u001bB\u0001"+
		"\u0000\u0000\u0000\u001d^\u0001\u0000\u0000\u0000\u001f`\u0001\u0000\u0000"+
		"\u0000!h\u0001\u0000\u0000\u0000#$\u0005|\u0000\u0000$%\u0005|\u0000\u0000"+
		"%\u0002\u0001\u0000\u0000\u0000&\'\u0005&\u0000\u0000\'(\u0005&\u0000"+
		"\u0000(\u0004\u0001\u0000\u0000\u0000)*\u0005<\u0000\u0000*\u0006\u0001"+
		"\u0000\u0000\u0000+,\u0005>\u0000\u0000,\b\u0001\u0000\u0000\u0000-.\u0005"+
		"=\u0000\u0000./\u0005=\u0000\u0000/\n\u0001\u0000\u0000\u000001\u0005"+
		"!\u0000\u000012\u0005=\u0000\u00002\f\u0001\u0000\u0000\u000034\u0005"+
		"+\u0000\u00004\u000e\u0001\u0000\u0000\u000056\u0005-\u0000\u00006\u0010"+
		"\u0001\u0000\u0000\u000078\u0005*\u0000\u00008\u0012\u0001\u0000\u0000"+
		"\u00009:\u0005/\u0000\u0000:\u0014\u0001\u0000\u0000\u0000;<\u0005(\u0000"+
		"\u0000<\u0016\u0001\u0000\u0000\u0000=>\u0005)\u0000\u0000>\u0018\u0001"+
		"\u0000\u0000\u0000?@\u0005.\u0000\u0000@\u001a\u0001\u0000\u0000\u0000"+
		"AC\u0007\u0000\u0000\u0000BA\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000"+
		"\u0000DB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000EL\u0001\u0000"+
		"\u0000\u0000FH\u0005.\u0000\u0000GI\u0007\u0000\u0000\u0000HG\u0001\u0000"+
		"\u0000\u0000IJ\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000JK\u0001"+
		"\u0000\u0000\u0000KM\u0001\u0000\u0000\u0000LF\u0001\u0000\u0000\u0000"+
		"LM\u0001\u0000\u0000\u0000M\u001c\u0001\u0000\u0000\u0000NR\u0005\'\u0000"+
		"\u0000OQ\t\u0000\u0000\u0000PO\u0001\u0000\u0000\u0000QT\u0001\u0000\u0000"+
		"\u0000RS\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000SU\u0001\u0000"+
		"\u0000\u0000TR\u0001\u0000\u0000\u0000U_\u0005\'\u0000\u0000VZ\u0005\""+
		"\u0000\u0000WY\t\u0000\u0000\u0000XW\u0001\u0000\u0000\u0000Y\\\u0001"+
		"\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000\u0000"+
		"[]\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000]_\u0005\"\u0000"+
		"\u0000^N\u0001\u0000\u0000\u0000^V\u0001\u0000\u0000\u0000_\u001e\u0001"+
		"\u0000\u0000\u0000`d\u0007\u0001\u0000\u0000ac\u0007\u0002\u0000\u0000"+
		"ba\u0001\u0000\u0000\u0000cf\u0001\u0000\u0000\u0000db\u0001\u0000\u0000"+
		"\u0000de\u0001\u0000\u0000\u0000e \u0001\u0000\u0000\u0000fd\u0001\u0000"+
		"\u0000\u0000gi\u0007\u0003\u0000\u0000hg\u0001\u0000\u0000\u0000ij\u0001"+
		"\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000"+
		"kl\u0001\u0000\u0000\u0000lm\u0006\u0010\u0000\u0000m\"\u0001\u0000\u0000"+
		"\u0000\t\u0000DJLRZ^dj\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}