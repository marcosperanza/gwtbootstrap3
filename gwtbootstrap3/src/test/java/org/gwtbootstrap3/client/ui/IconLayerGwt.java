package org.gwtbootstrap3.client.ui;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2014 GwtBootstrap3
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

import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.client.ui.constants.Styles;
import org.gwtbootstrap3.client.ui.html.Div;

public class IconLayerGwt extends BaseGwt {



    public void testIconLayer_AcceptsOnlyIcon_Text_Counter_Widgets() {
        final IconLayer layer = new IconLayer();
        try {
            layer.add(new Div());
            fail("Div cannot be added in the IconLayer");
        } catch (Exception e) {

        }
    }


    public void testIconLayerText() {
        final IconLayer layer = new IconLayer();
        layer.add(new Icon(IconType.ENVELOPE));

        IconLayerText text = new IconLayerText();
        text.setTransform("shrink-11.5 rotate--30");
        text.setInverse(true);

        layer.add(text);


        assertEquals("fa-layers fa-fw", layer.getStyleName());
        assertEquals("fas fa-envelope", layer.getWidget(0).getStyleName());
        assertEquals("fa-layers-text fa-inverse", layer.getWidget(1).getStyleName());
        assertEquals("shrink-11.5 rotate--30", layer.getWidget(1).getElement().getAttribute(Styles.DATA_FA_TRANSFORM));
    }


    public void testIconLayerCounter() {
        final IconLayer layer = new IconLayer();
        layer.add(new Icon(IconType.ENVELOPE));

        IconLayerCounter counter = new IconLayerCounter();
        counter.add(new Label("123.00"));
        layer.add(counter);


        assertEquals("fa-layers fa-fw", layer.getStyleName());
        assertEquals("fas fa-envelope", layer.getWidget(0).getStyleName());
        assertEquals("fa-layers-counter", layer.getWidget(1).getStyleName());
    }

}
