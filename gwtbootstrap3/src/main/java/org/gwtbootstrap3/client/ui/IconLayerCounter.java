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

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.HasCssName;
import org.gwtbootstrap3.client.ui.base.HasInverse;
import org.gwtbootstrap3.client.ui.base.HasTransform;
import org.gwtbootstrap3.client.ui.base.helper.EnumHelper;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.constants.ButtonSize;
import org.gwtbootstrap3.client.ui.constants.Styles;
import org.gwtbootstrap3.client.ui.html.Span;

/**
 * @author Marco Speranza
 */
public class IconLayerCounter extends Span implements HasTransform, HasInverse {

    public enum CounterPosition implements HasCssName {
        TOP_LEFT("fa-layers-top-left"),
        TOP_RIGHT("fa-layers-top-right"),
        BOTTOM_LEFT("fa-layers-bottom-left"),
        BOTTOM_RIGHT("fa-layers-bottom-right"),;

        private String cssName;
        CounterPosition(String cssName) {
            this.cssName = cssName;
        }

        @Override
        public String getCssName() {
            return cssName;
        }

        public static CounterPosition fromStyleName(final String styleName) {
            return EnumHelper.fromStyleName(styleName, CounterPosition.class, TOP_RIGHT);
        }
    }


    public IconLayerCounter() {
        getElement().addClassName(Styles.ICON_LAYER_COUNTER);
    }

    public IconLayerCounter(final String html) {
        super(html);
        getElement().addClassName(Styles.ICON_LAYER_COUNTER);
    }


    @Override
    public void setTransform(String value) {
        getElement().setAttribute(Styles.DATA_FA_TRANSFORM, value);
    }

    @Override
    public String getTransform() {
        return getElement().getAttribute(Styles.DATA_FA_TRANSFORM);
    }

    @Override
    public void setInverse(final boolean inverse) {
        StyleHelper.toggleStyleName(this, inverse, Styles.ICON_INVERSE);
    }

    @Override
    public boolean isInverse() {
        return StyleHelper.containsStyle(Styles.ICON_INVERSE, getStyleName());
    }


    public void setCounterPosition(CounterPosition position) {
        StyleHelper.addUniqueEnumStyleName(this, CounterPosition.class, position);
    }

    public CounterPosition getCounterPosition() {
        return CounterPosition.fromStyleName(getStyleName());
    }
}
