package org.antlr.jetbrains.jarl;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class JarlFileType extends LanguageFileType {
	public static final String FILE_EXTENSION = "jarl";
		public static final JarlFileType INSTANCE = new JarlFileType();

	protected JarlFileType() {
		super(JarlLanguage.INSTANCE);
	}

	@NotNull
	@Override
	public String getName() {
		return "StringTemplate v4 template group file";
	}

	@NotNull
	@Override
	public String getDescription() {
		return "StringTemplate v4 template group file";
	}

	@NotNull
	@Override
	public String getDefaultExtension() {
		return FILE_EXTENSION;
	}

	@Nullable
	@Override
	public Icon getIcon() {
		return Icons.JARL_ICON;
	}
}
