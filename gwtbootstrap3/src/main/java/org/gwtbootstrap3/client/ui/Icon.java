package org.gwtbootstrap3.client.ui;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 GwtBootstrap3
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.gwtbootstrap3.client.ui.base.*;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.constants.ElementTags;
import org.gwtbootstrap3.client.ui.constants.Emphasis;
import org.gwtbootstrap3.client.ui.constants.IconFlip;
import org.gwtbootstrap3.client.ui.constants.IconRotate;
import org.gwtbootstrap3.client.ui.constants.IconSize;
import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.client.ui.constants.Styles;

import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiConstructor;

/**
 * Simple put, an icon.
 *
 * @author Sven Jacobs
 * @see org.gwtbootstrap3.client.ui.constants.IconType
 * @see org.gwtbootstrap3.client.ui.constants.IconSize
 */
public class Icon extends ComplexWidget implements HasType<IconType>, HasSize<IconSize>, HasEmphasis, HasClickHandlers, HasTransform, HasInverse {

    final private String DEFAULT_STYLE = IconType.Style.SOLID.getCssName();

    public Icon() {
        setElement(Document.get().createElement(ElementTags.I));
        addStyleName(DEFAULT_STYLE);
    }

    public Icon(IconType.Style style) {
        setElement(Document.get().createElement(ElementTags.I));
        addStyleName(style == null ? DEFAULT_STYLE : style.getCssName());
    }

    @UiConstructor
    public Icon(final IconType type) {
        this();
        setType(type);
    }

    @Override
    public void setType(final IconType type) {
        StyleHelper.addUniqueEnumStyleName(this, IconType.class, type);
    }

    public void setIconStyle(IconType.Style style) {
        if (getType() != null) {
            //put the icon style in first position.
            StyleHelper.addUniqueEnumStyleName(this, IconType.Style.class, style);
            setType(getType());
        }
    }

    public IconType.Style getIconStyle() {
        return IconType.Style.fromStyleName(getStyleName());
    }


    @Override
    public IconType getType() {
        return IconType.fromStyleName(getStyleName());
    }

    public void setBorder(final boolean border) {
        StyleHelper.toggleStyleName(this, border, Styles.ICON_BORDER);
    }

    public boolean isBorder() {
        return StyleHelper.containsStyle(Styles.ICON_BORDER, getStyleName());
    }

    public void setStackBase(final boolean stackBase) {
        StyleHelper.toggleStyleName(this, stackBase, Styles.ICON_STACK_BASE);
    }

    public boolean isStackBase() {
        return StyleHelper.containsStyle(Styles.ICON_STACK_BASE, getStyleName());
    }

    public void setFixedWidth(final boolean fixedWidth) {
        StyleHelper.toggleStyleName(this, fixedWidth, Styles.ICON_FIXED_WIDTH);
    }

    public boolean isFixedWidth() {
        return StyleHelper.containsStyle(Styles.ICON_FIXED_WIDTH, getStyleName());
    }

    public void setStackTop(final boolean stackTop) {
        StyleHelper.toggleStyleName(this, stackTop, Styles.ICON_STACK_TOP);
    }

    public boolean isStackTop() {
        return StyleHelper.containsStyle(Styles.ICON_STACK_TOP, getStyleName());
    }

    @Override
    public void setInverse(final boolean inverse) {
        StyleHelper.toggleStyleName(this, inverse, Styles.ICON_INVERSE);
    }

    @Override
    public boolean isInverse() {
        return StyleHelper.containsStyle(Styles.ICON_INVERSE, getStyleName());
    }

    public void setSpin(final boolean spin) {
        StyleHelper.toggleStyleName(this, spin, Styles.ICON_SPIN);
    }

    public boolean isSpin() {
        return StyleHelper.containsStyle(Styles.ICON_SPIN, getStyleName());
    }

    public void setPulse(final boolean pulse) {
        StyleHelper.toggleStyleName(this, pulse, Styles.ICON_PULSE);
    }

    public boolean isPulse() {
        return StyleHelper.containsStyle(Styles.ICON_PULSE, getStyleName());
    }

    public void setRotate(final IconRotate iconRotate) {
        if (iconRotate == null) {
            return;
        }
        StyleHelper.addUniqueEnumStyleName(this, IconRotate.class, iconRotate);
    }

    public IconRotate getRotate() {
        return IconRotate.fromStyleName(getStyleName());
    }

    public void setFlip(final IconFlip iconFlip) {
        if (iconFlip == null) {
            return;
        }

        StyleHelper.addUniqueEnumStyleName(this, IconFlip.class, iconFlip);
    }

    public IconFlip getFlip() {
        return IconFlip.fromStyleName(getStyleName());
    }

    @Override
    public void setSize(final IconSize iconSize) {
        StyleHelper.addUniqueEnumStyleName(this, IconSize.class, iconSize);
    }

    @Override
    public IconSize getSize() {
        return IconSize.fromStyleName(getStyleName());
    }

    @Override
    public void setEmphasis(final Emphasis emphasis) {
        StyleHelper.addUniqueEnumStyleName(this, Emphasis.class, emphasis);
    }

    @Override
    public Emphasis getEmphasis() {
        return Emphasis.fromStyleName(getStyleName());
    }

    @Override
    public HandlerRegistration addClickHandler(final ClickHandler handler) {
        return addDomHandler(handler, ClickEvent.getType());
    }

    @Override
    public void setTransform(String value) {
        getElement().setAttribute(Styles.DATA_FA_TRANSFORM, value);
    }

    @Override
    public String getTransform() {
        return getElement().getAttribute(Styles.DATA_FA_TRANSFORM);
    }
}
