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

import org.gwtbootstrap3.client.ui.base.HasInverse;
import org.gwtbootstrap3.client.ui.base.HasTransform;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.constants.Styles;
import org.gwtbootstrap3.client.ui.html.Span;

/**
 * @author Marco Speranza
 */
public class IconLayerText extends Span implements HasTransform, HasInverse {

    public IconLayerText() {
        getElement().addClassName(Styles.ICON_LAYER_TEXT);
    }

    public IconLayerText(final String html) {
        super(html);
        getElement().addClassName(Styles.ICON_LAYER_TEXT);
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


}
