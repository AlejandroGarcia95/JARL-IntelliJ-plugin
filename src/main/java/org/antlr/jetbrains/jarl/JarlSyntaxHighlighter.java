package org.antlr.jetbrains.jarl;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor;
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory;
import org.antlr.intellij.adaptor.lexer.TokenIElementType;
import org.antlr.jetbrains.jarl.parser.JarlLexer;
import org.antlr.jetbrains.jarl.parser.JarlParser;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

/** A highlighter is really just a mapping from token type to
 *  some text attributes using {@link #getTokenHighlights(IElementType)}.
 *  The reason that it returns an array, TextAttributesKey[], is
 *  that you might want to mix the attributes of a few known highlighters.
 *  A {@link TextAttributesKey} is just a name for that a theme
 *  or IDE skin can set. For example, {@link DefaultLanguageHighlighterColors#KEYWORD}
 *  is the key that maps to what identifiers look like in the editor.
 *  To change it, see dialog: Editor > Colors & Fonts > Language Defaults.
 *
 *  From <a href="http://www.jetbrains.org/intellij/sdk/docs/reference_guide/custom_language_support/syntax_highlighting_and_error_highlighting.html">doc</a>:
 *  "The mapping of the TextAttributesKey to specific attributes used
 *  in an editor is defined by the EditorColorsScheme class, and can
 *  be configured by the user if the plugin provides an appropriate
 *  configuration interface.
 *  ...
 *  The syntax highlighter returns the {@link TextAttributesKey}
 * instances for each token type which needs special highlighting.
 * For highlighting lexer errors, the standard TextAttributesKey
 * for bad characters HighlighterColors.BAD_CHARACTER can be used."
 */
public class JarlSyntaxHighlighter extends SyntaxHighlighterBase {
	private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];
	public static final TextAttributesKey ID =
		createTextAttributesKey("JARL_ID", DefaultLanguageHighlighterColors.IDENTIFIER);
	public static final TextAttributesKey KEYWORD =
		createTextAttributesKey("JARL_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
	public static final TextAttributesKey STRING =
		createTextAttributesKey("JARL_STRING", DefaultLanguageHighlighterColors.STRING);
	public static final TextAttributesKey LINE_COMMENT =
		createTextAttributesKey("JARL_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
	public static final TextAttributesKey BLOCK_COMMENT =
		createTextAttributesKey("JARL_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT);

	static {
		PSIElementTypeFactory.defineLanguageIElementTypes(JarlLanguage.INSTANCE,
				JarlParser.tokenNames,
				JarlParser.ruleNames);
	}

	@NotNull
	@Override
	public Lexer getHighlightingLexer() {
		JarlLexer lexer = new JarlLexer(null);
		return new ANTLRLexerAdaptor(JarlLanguage.INSTANCE, lexer);
	}

	@NotNull
	@Override
	public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
		if ( !(tokenType instanceof TokenIElementType) ) return EMPTY_KEYS;
		TokenIElementType myType = (TokenIElementType)tokenType;
		int ttype = myType.getANTLRTokenType();
		TextAttributesKey attrKey;
		switch ( ttype ) {
			case JarlLexer.AFTER :
			case JarlLexer.AND :
			case JarlLexer.ANY :
			case JarlLexer.AT :
			case JarlLexer.BEFORE :
			case JarlLexer.BETWEEN :
			case JarlLexer.EVERY :
			case JarlLexer.FOR :
			case JarlLexer.HAPPEN :
			case JarlLexer.LEAST :
			case JarlLexer.MOST :
			case JarlLexer.MUST :
			case JarlLexer.NEXT :
			case JarlLexer.NOT :
			case JarlLexer.PRECEDE :
			case JarlLexer.PREVIOUS :
			case JarlLexer.RULE :
			case JarlLexer.TIMES :
			case JarlLexer.WITH :
				attrKey = KEYWORD;
				break;
			case JarlLexer.COMMENT :
				attrKey = LINE_COMMENT;
				break;
			case JarlLexer.LITERAL_STR :
			case JarlLexer.NUMBER :
				attrKey = STRING;
				break;
			default :
				return EMPTY_KEYS;
		}
		return new TextAttributesKey[] {attrKey};
	}
}
