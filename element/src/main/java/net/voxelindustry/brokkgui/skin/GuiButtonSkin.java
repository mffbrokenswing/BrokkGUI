package net.voxelindustry.brokkgui.skin;

import net.voxelindustry.brokkgui.behavior.GuiButtonBehavior;
import net.voxelindustry.brokkgui.control.GuiButtonBase;
import net.voxelindustry.brokkgui.data.RelativeBindingHelper;
import net.voxelindustry.brokkgui.internal.IGuiRenderer;
import net.voxelindustry.brokkgui.paint.RenderPass;

public class GuiButtonSkin<C extends GuiButtonBase, B extends GuiButtonBehavior<C>> extends GuiBehaviorSkinBase<C, B>
{
    public GuiButtonSkin(final C model, final B behaviour)
    {
        super(model, behaviour);

        this.getModel().getLabel().getStyleClass().add("label");
        this.bindLabel();
    }

    protected void bindLabel()
    {
        if (!getModel().expandToLabel())
            getModel().getLabel().getWidthProperty().bind(getModel().getWidthProperty());
        else
        {
            getModel().getLabel().setExpandToText(true);
            getModel().getWidthProperty().bind(getModel().getLabel().getWidthProperty());
        }

        getModel().getLabel().getHeightProperty().bind(getModel().getHeightProperty());

        RelativeBindingHelper.bindToPos(getModel().getLabel(), getModel());

        getModel().getExpandToLabelProperty().addListener(obs ->
        {
            getModel().getLabel().getWidthProperty().unbind();
            getModel().getLabel().setExpandToText(true);
            getModel().getWidthProperty().bind(getModel().getLabel().getWidthProperty());
        });
    }

    @Override
    public void render(RenderPass pass, IGuiRenderer renderer, int mouseX, int mouseY)
    {
        super.render(pass, renderer, mouseX, mouseY);
    }
}