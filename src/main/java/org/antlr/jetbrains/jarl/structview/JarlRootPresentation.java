package org.antlr.jetbrains.jarl.structview;

import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiFile;
import org.antlr.jetbrains.jarl.Icons;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class JarlRootPresentation implements ItemPresentation {
	protected final PsiFile element;

	protected JarlRootPresentation(PsiFile element) {
		this.element = element;
	}

	@Nullable
	@Override
	public Icon getIcon(boolean unused) {
		return Icons.JARL_ICON;
	}

	@Nullable
	@Override
	public String getPresentableText() {
		return element.getVirtualFile().getNameWithoutExtension();
	}

	@Nullable
	@Override
	public String getLocationString() {
		return null;
	}
}
