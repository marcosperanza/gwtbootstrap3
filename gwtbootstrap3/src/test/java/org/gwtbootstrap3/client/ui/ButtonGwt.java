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

import com.google.gwt.core.client.Scheduler;
import org.gwtbootstrap3.client.ui.constants.IconType;

public class ButtonGwt extends BaseGwt {


    public void testButtonLabel() {
        final String label = "label";
        final Button button = new Button(label);
        assertEquals(label, button.getText());
    }

    public void testButtonIcon()  {
        final String label = "label";
        final Button button = new Button(label);
        button.setIcon(IconType.ADDRESS_BOOK);
        assertEquals(label, button.getText());

        //Schedule after the render!
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
            @Override
            public void execute() {
                assertNotNull(button.getIcon());
                assertEquals("fa-address-book", button.getIcon().getCssName());
                assertEquals("fas fa-address-book", button.getWidget(0).getStyleName());
            }
        });

    }


    public void testButtonIconStyle()  {
        final String label = "label";
        final Button button = new Button(label);
        button.setIcon(IconType.ADDRESS_BOOK);
        button.setIconStyle(IconType.Style.REGULAR);
        assertEquals(label, button.getText());

        //Schedule after the render!
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
            @Override
            public void execute() {
                assertNotNull(button.getIcon());
                assertEquals("fa-address-book", button.getIcon().getCssName());
                assertEquals("far fa-address-book", button.getWidget(0).getStyleName());
            }
        });

    }

}
