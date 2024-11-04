package com.m7mdra.arbfmt;


import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.openapi.wm.ex.ToolWindowEx;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import com.m7mdra.arbfmt.actions.*;
import com.m7mdra.arbfmt.panel.EditorTextPanel;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

/**
 * JsonFormatterToolWindowFactory
 *
 * @author zhangjiaxing
 */
public class ArbFormatterToolWindowFactory implements ToolWindowFactory {

    /**
     * Empty display name.
     */
    private static final String DISPLAY_NAME = "Arbfmt";

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        ArbFormatterToolWindow window = new ArbFormatterToolWindow(project);
        ContentFactory factory = ContentFactory.getInstance();
        Content jsonFormatter = factory.createContent(window.getPanel(), DISPLAY_NAME, true);
        toolWindow.getContentManager().addContent(jsonFormatter);

        EditorTextPanel editorTextPanel = window.getEditorTextPanel();

        initAction(toolWindow, editorTextPanel);
    }

    private void initAction(ToolWindow toolWindow, EditorTextPanel editorTextPanel) {
        MinifyJsonAction minifyJsonAction = new MinifyJsonAction(editorTextPanel);
        minifyJsonAction.getTemplatePresentation().setIcon(AllIcons.Actions.Collapseall);
        minifyJsonAction.getTemplatePresentation().setText(MinifyJsonAction.ACTION_TEXT);

        FormatJsonAction formatJsonAction = new FormatJsonAction(editorTextPanel);
        formatJsonAction.getTemplatePresentation().setIcon(AllIcons.Actions.Expandall);
        formatJsonAction.getTemplatePresentation().setText(FormatJsonAction.ACTION_TEXT);

        CopyContentAction copyContentAction = new CopyContentAction(editorTextPanel);
        copyContentAction.getTemplatePresentation().setIcon(AllIcons.Actions.Copy);
        copyContentAction.getTemplatePresentation().setText(CopyContentAction.ACTION_TEXT);

        VerifyJsonAction verifyJsonAction = new VerifyJsonAction(editorTextPanel);
        verifyJsonAction.getTemplatePresentation().setIcon(AllIcons.Actions.SetDefault);
        verifyJsonAction.getTemplatePresentation().setText(VerifyJsonAction.ACTION_TEXT);

        UnescapeStringAction unescapeStringAction = new UnescapeStringAction(editorTextPanel);
        unescapeStringAction.getTemplatePresentation().setIcon(AllIcons.Actions.MoveUp);
        unescapeStringAction.getTemplatePresentation().setText(UnescapeStringAction.ACTION_TEXT);

        EscapeStringAction escapeStringAction = new EscapeStringAction(editorTextPanel);
        escapeStringAction.getTemplatePresentation().setIcon(AllIcons.Actions.MoveDown);
        escapeStringAction.getTemplatePresentation().setText(EscapeStringAction.ACTION_TEXT);

        ToolWindowEx ex = (ToolWindowEx) toolWindow;
        List<AnAction> actions = Arrays.asList(minifyJsonAction,
                formatJsonAction,
                copyContentAction,
                verifyJsonAction,
                unescapeStringAction,
                escapeStringAction
        );
        ex.setTitleActions(actions);
    }
}