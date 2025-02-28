// Generated from C:/Users/fanmi/Downloads/ValkyrixRule.g4 by ANTLR 4.13.1
package com.valkyrix.core.base;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ValkyrixRuleLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, LOGICAL_OP=3, COMPARE_OP=4, ADDITIVE_OP=5, MULTIPLICATIVE_OP=6, 
		IDENTIFIER=7, NUMBER=8, STRING=9, WS=10;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "LOGICAL_OP", "COMPARE_OP", "ADDITIVE_OP", "MULTIPLICATIVE_OP", 
			"IDENTIFIER", "NUMBER", "STRING", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "LOGICAL_OP", "COMPARE_OP", "ADDITIVE_OP", "MULTIPLICATIVE_OP", 
			"IDENTIFIER", "NUMBER", "STRING", "WS"
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


	public ValkyrixRuleLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ValkyrixRule.g4"; }

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
		"\u0004\u0000\nU\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u0002\u001e\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003)\b"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0005\u00061\b\u0006\n\u0006\f\u00064\t\u0006\u0001\u0007\u0003"+
		"\u00077\b\u0007\u0001\u0007\u0004\u0007:\b\u0007\u000b\u0007\f\u0007;"+
		"\u0001\u0007\u0001\u0007\u0004\u0007@\b\u0007\u000b\u0007\f\u0007A\u0003"+
		"\u0007D\b\u0007\u0001\b\u0001\b\u0005\bH\b\b\n\b\f\bK\t\b\u0001\b\u0001"+
		"\b\u0001\t\u0004\tP\b\t\u000b\t\f\tQ\u0001\t\u0001\t\u0001I\u0000\n\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0001\u0000\u0007\u0002\u0000<<>>\u0002\u0000"+
		"++--\u0002\u0000**//\u0003\u0000AZ__az\u0004\u000009AZ__az\u0001\u0000"+
		"09\u0003\u0000\t\n\r\r  `\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003"+
		"\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007"+
		"\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001"+
		"\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000"+
		"\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000"+
		"\u0000\u0000\u0001\u0015\u0001\u0000\u0000\u0000\u0003\u0017\u0001\u0000"+
		"\u0000\u0000\u0005\u001d\u0001\u0000\u0000\u0000\u0007(\u0001\u0000\u0000"+
		"\u0000\t*\u0001\u0000\u0000\u0000\u000b,\u0001\u0000\u0000\u0000\r.\u0001"+
		"\u0000\u0000\u0000\u000f6\u0001\u0000\u0000\u0000\u0011E\u0001\u0000\u0000"+
		"\u0000\u0013O\u0001\u0000\u0000\u0000\u0015\u0016\u0005(\u0000\u0000\u0016"+
		"\u0002\u0001\u0000\u0000\u0000\u0017\u0018\u0005)\u0000\u0000\u0018\u0004"+
		"\u0001\u0000\u0000\u0000\u0019\u001a\u0005&\u0000\u0000\u001a\u001e\u0005"+
		"&\u0000\u0000\u001b\u001c\u0005|\u0000\u0000\u001c\u001e\u0005|\u0000"+
		"\u0000\u001d\u0019\u0001\u0000\u0000\u0000\u001d\u001b\u0001\u0000\u0000"+
		"\u0000\u001e\u0006\u0001\u0000\u0000\u0000\u001f)\u0007\u0000\u0000\u0000"+
		" !\u0005>\u0000\u0000!)\u0005=\u0000\u0000\"#\u0005<\u0000\u0000#)\u0005"+
		"=\u0000\u0000$%\u0005=\u0000\u0000%)\u0005=\u0000\u0000&\'\u0005!\u0000"+
		"\u0000\')\u0005=\u0000\u0000(\u001f\u0001\u0000\u0000\u0000( \u0001\u0000"+
		"\u0000\u0000(\"\u0001\u0000\u0000\u0000($\u0001\u0000\u0000\u0000(&\u0001"+
		"\u0000\u0000\u0000)\b\u0001\u0000\u0000\u0000*+\u0007\u0001\u0000\u0000"+
		"+\n\u0001\u0000\u0000\u0000,-\u0007\u0002\u0000\u0000-\f\u0001\u0000\u0000"+
		"\u0000.2\u0007\u0003\u0000\u0000/1\u0007\u0004\u0000\u00000/\u0001\u0000"+
		"\u0000\u000014\u0001\u0000\u0000\u000020\u0001\u0000\u0000\u000023\u0001"+
		"\u0000\u0000\u00003\u000e\u0001\u0000\u0000\u000042\u0001\u0000\u0000"+
		"\u000057\u0005-\u0000\u000065\u0001\u0000\u0000\u000067\u0001\u0000\u0000"+
		"\u000079\u0001\u0000\u0000\u00008:\u0007\u0005\u0000\u000098\u0001\u0000"+
		"\u0000\u0000:;\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000;<\u0001"+
		"\u0000\u0000\u0000<C\u0001\u0000\u0000\u0000=?\u0005.\u0000\u0000>@\u0007"+
		"\u0005\u0000\u0000?>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000"+
		"A?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000BD\u0001\u0000\u0000"+
		"\u0000C=\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000D\u0010\u0001"+
		"\u0000\u0000\u0000EI\u0005\'\u0000\u0000FH\t\u0000\u0000\u0000GF\u0001"+
		"\u0000\u0000\u0000HK\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000"+
		"IG\u0001\u0000\u0000\u0000JL\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000"+
		"\u0000LM\u0005\'\u0000\u0000M\u0012\u0001\u0000\u0000\u0000NP\u0007\u0006"+
		"\u0000\u0000ON\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QO\u0001"+
		"\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000"+
		"ST\u0006\t\u0000\u0000T\u0014\u0001\u0000\u0000\u0000\n\u0000\u001d(2"+
		"6;ACIQ\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}