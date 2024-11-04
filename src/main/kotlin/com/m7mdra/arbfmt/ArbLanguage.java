package com.m7mdra.arbfmt;

import com.intellij.lang.Language;

public class ArbLanguage extends Language {
  public static final ArbLanguage INSTANCE = new ArbLanguage();

  public ArbLanguage() {
    super("arb", "application/json", "application/vnd.api+json", "application/hal+json", "application/ld+json");
  }

  @Override
  public boolean isCaseSensitive() {
    return true;
  }

  public boolean hasPermissiveStrings() { return false; }
}