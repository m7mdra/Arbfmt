package com.m7mdra.arbfmt;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.NlsContexts.Label;
import com.intellij.openapi.util.NlsSafe;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class ArbFileType extends LanguageFileType {
    public static final ArbFileType INSTANCE = new ArbFileType();

    protected ArbFileType() {
        super(ArbLanguage.INSTANCE);
    }

    @Override
    public @NonNls @NotNull String getName() {
        return "ARB";
    }

    @SuppressWarnings("UnstableApiUsage")
    @Override
    public @Label @NotNull String getDescription() {
        return "Arb file";
    }

    @SuppressWarnings("UnstableApiUsage")
    @Override
    public @NlsSafe @NotNull String getDefaultExtension() {
        return "arb";
    }

    @Override
    public Icon getIcon() {
        return AllIcons.FileTypes.Json;
    }
}
