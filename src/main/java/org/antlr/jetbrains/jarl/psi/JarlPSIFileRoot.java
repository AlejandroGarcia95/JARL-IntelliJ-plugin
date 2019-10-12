package org.antlr.jetbrains.jarl.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import org.antlr.intellij.adaptor.SymtabUtils;
import org.antlr.intellij.adaptor.psi.ScopeNode;
import org.antlr.jetbrains.jarl.Icons;
import org.antlr.jetbrains.jarl.JarlFileType;
import org.antlr.jetbrains.jarl.JarlLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class JarlPSIFileRoot extends PsiFileBase implements ScopeNode {
    public JarlPSIFileRoot(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, JarlLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return JarlFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "JARL Language file";
    }

    @Override
    public Icon getIcon(int flags) {
        return Icons.JARL_ICON;
    }

	/** Return null since a file scope has no enclosing scope. It is
	 *  not itself in a scope.
	 */
	@Override
	public ScopeNode getContext() {
		return null;
	}

	@Nullable
	@Override
	public PsiElement resolve(PsiNamedElement element) {
		return SymtabUtils.resolve(this, JarlLanguage.INSTANCE, element, "/script/vardef/ID");
	}
}
