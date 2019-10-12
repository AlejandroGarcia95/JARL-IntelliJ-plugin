package org.antlr.jetbrains.jarl;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class JarlColorSettingsPage implements ColorSettingsPage {
	private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
		new AttributesDescriptor("Identifier", JarlSyntaxHighlighter.ID),
		new AttributesDescriptor("Keyword", JarlSyntaxHighlighter.KEYWORD),
		new AttributesDescriptor("String", JarlSyntaxHighlighter.STRING),
		new AttributesDescriptor("Line comment", JarlSyntaxHighlighter.LINE_COMMENT),
		new AttributesDescriptor("Block comment", JarlSyntaxHighlighter.BLOCK_COMMENT),
	};

	@Nullable
	@Override
	public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
		return null;
	}

	@Nullable
	@Override
	public Icon getIcon() {
		return Icons.JARL_ICON;
	}

	@NotNull
	@Override
	public SyntaxHighlighter getHighlighter() {
		return new JarlSyntaxHighlighter();
	}

	@NotNull
	@Override
	public String getDemoText() {
		return
			"# Example rule comment\n" +
			"rule example_rule\n" +
			"for every i and any x:\n"+
			"between foo(x) and previous bar(i)\n" +
			"  for every j, k and any y with j<i:\n" +
			"  baz(j, k, i) must happen 3 times\n";
	}

	@NotNull
	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		return DESCRIPTORS;
	}

	@NotNull
	@Override
	public ColorDescriptor[] getColorDescriptors() {
		return ColorDescriptor.EMPTY_ARRAY;
	}

	@NotNull
	@Override
	public String getDisplayName() {
		return "JARL";
	}
}
