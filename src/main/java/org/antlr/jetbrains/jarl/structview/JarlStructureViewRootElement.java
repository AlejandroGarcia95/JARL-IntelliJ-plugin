package org.antlr.jetbrains.jarl.structview;

import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

public class JarlStructureViewRootElement extends JarlStructureViewElement {
	public JarlStructureViewRootElement(PsiFile element) {
		super(element);
	}

	@NotNull
	@Override
	public ItemPresentation getPresentation() {
		return new JarlRootPresentation((PsiFile)element);
	}
}
