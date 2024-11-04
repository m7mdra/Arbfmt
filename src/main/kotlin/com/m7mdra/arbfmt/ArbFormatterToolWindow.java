package com.m7mdra.arbfmt;

import com.m7mdra.arbfmt.panel.EditorTextPanel;
import com.intellij.openapi.project.Project;

import javax.swing.*;
import java.awt.*;

/**
 * JsonFormatterToolWindow
 *
 * @author zhangjiaxing
 */
public class ArbFormatterToolWindow {

    private final JPanel panel;

    private final EditorTextPanel editorTextPanel;

    public ArbFormatterToolWindow(Project project) {
        this.panel = new JPanel(new GridLayout(0, 1));
        this.editorTextPanel = createEditorTextPanel(project);

        init();
    }

    private void init() {
        this.panel.add(editorTextPanel);
    }

    private EditorTextPanel createEditorTextPanel(Project project) {
        return new EditorTextPanel(project, ArbFileType.INSTANCE);
    }

    public EditorTextPanel getEditorTextPanel() {
        return editorTextPanel;
    }

    public JPanel getPanel() {
        return panel;
    }
}

