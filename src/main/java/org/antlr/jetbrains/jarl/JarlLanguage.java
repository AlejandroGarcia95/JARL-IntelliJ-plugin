package org.antlr.jetbrains.jarl;

import com.intellij.lang.Language;

public class JarlLanguage extends Language {
    public static final JarlLanguage INSTANCE = new JarlLanguage();

    private JarlLanguage() {
        super("JARL");
    }
}
