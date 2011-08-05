/*
 * Copyright 2011, Uri Shaked
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.urish.iphonejava.helloworld.client;

import org.urish.gwtit.client.EventCallback;
import org.urish.gwtit.client.GwtTitaniumBootstrap;
import org.urish.gwtit.client.font.Font;
import org.urish.gwtit.titanium.API;
import org.urish.gwtit.titanium.UI;
import org.urish.gwtit.titanium.ui.AlertDialog;
import org.urish.gwtit.titanium.ui.Button;
import org.urish.gwtit.titanium.ui.Label;
import org.urish.gwtit.titanium.ui.Tab;
import org.urish.gwtit.titanium.ui.TabGroup;
import org.urish.gwtit.titanium.ui.View.ClickEvent;
import org.urish.gwtit.titanium.ui.Window;

public class HelloWorldModule extends GwtTitaniumBootstrap {
	public static TabGroup tabGroup;
	
	@Override
	public void main() {
		API.info("Creating UI...");
		
		tabGroup = UI.createTabGroup();
		tabGroup.setBarColor("#006800");

		Tab tab1 = UI.createTab();
		tab1.setTitle("Hello World");
		tab1.setWindow(createHelloWorldTab());
		tabGroup.addTab(tab1);

		Tab tab2 = UI.createTab();
		tab2.setTitle("About");
		tab2.setWindow(createAboutTab());
		tabGroup.addTab(tab2);

		tabGroup.open();

		API.info("UI created, application ready!");
	}
	
	private Window createHelloWorldTab() {
		Window result = UI.createWindow();
		Button helloWorld = UI.createButton();
		helloWorld.setTitle("Hello World");
		helloWorld.addClickHandler(new EventCallback<ClickEvent>() {
			
			@Override
			public void onEvent(ClickEvent event) {
				API.info("Hello world clicked !");
		        AlertDialog alertDialog = UI.createAlertDialog();
		        alertDialog.setTitle("Example");
		        alertDialog.setMessage("Hello, World");
		        alertDialog.show();
			}
		});
		result.add(helloWorld);
		
		return result;
	}
	
	private Window createAboutTab() {
		Window result = UI.createWindow();
		Label helloWorld = UI.createLabel();
		helloWorld.setText("Hello World Java Application");
		helloWorld.setTop(60);
		helloWorld.setTextAlign(UI.TEXT_ALIGNMENT_CENTER);
		helloWorld.setFont(Font.createFont(32));
		result.add(helloWorld);
		return result;
	}
}