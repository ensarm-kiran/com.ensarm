package com.ensarm.cookies.client;

import com.ensarm.cookies.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sun.corba.se.impl.encoding.CodeSetConversion.BTCConverter;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SampleCookies implements EntryPoint,ClickHandler {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		/*final Button sendButton = new Button("Send");
		final TextBox nameField = new TextBox();
		nameField.setText("GWT User");
		final Label errorLabel = new Label();

		// We can add style names to widgets
		sendButton.addStyleName("sendButton");

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("nameFieldContainer").add(nameField);
		RootPanel.get("sendButtonContainer").add(sendButton);
		RootPanel.get("errorLabelContainer").add(errorLabel);

		// Focus the cursor on the name field when the app loads
		nameField.setFocus(true);
		nameField.selectAll();

		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);

		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogBox.hide();
				sendButton.setEnabled(true);
				sendButton.setFocus(true);
			}
		});

		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler {
			*//**
			 * Fired when the user clicks on the sendButton.
			 *//*
			public void onClick(ClickEvent event) {
				sendNameToServer();
			}

			*//**
			 * Fired when the user types in the nameField.
			 *//*
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					sendNameToServer();
				}
			}

			*//**
			 * Send the name from the nameField to the server and wait for a response.
			 *//*
			private void sendNameToServer() {
				// First, we validate the input.
				errorLabel.setText("");
				String textToServer = nameField.getText();
				if (!FieldVerifier.isValidName(textToServer)) {
					errorLabel.setText("Please enter at least four characters");
					return;
				}

				// Then, we send the input to the server.
				sendButton.setEnabled(false);
				textToServerLabel.setText(textToServer);
				serverResponseLabel.setText("");
				greetingService.greetServer(textToServer,
						new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {
								// Show the RPC error message to the user
								dialogBox
										.setText("Remote Procedure Call - Failure");
								serverResponseLabel
										.addStyleName("serverResponseLabelError");
								serverResponseLabel.setHTML(SERVER_ERROR);
								dialogBox.center();
								closeButton.setFocus(true);
							}

							public void onSuccess(String result) {
								dialogBox.setText("Remote Procedure Call");
								serverResponseLabel
										.removeStyleName("serverResponseLabelError");
								serverResponseLabel.setHTML(result);
								dialogBox.center();
								closeButton.setFocus(true);
							}
						});
			}
		}

		// Add a handler to send the name to the server
		MyHandler handler = new MyHandler();
		sendButton.addClickHandler(handler);
		nameField.addKeyUpHandler(handler);*/
		
		final TextBox box = new TextBox();
		box.setText("Name:-");
		final Button button = new Button("Add to cart");
		final Button btnAccessData = new Button("List of items");
		button.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Widget sender =(Widget) event.getSource();
				if(sender instanceof Button){
					if(sender.equals(button)){
					String data=box.getText();
					
					
					StringBuffer postData = new StringBuffer();
					// note param pairs are separated by a '&' 
					// and each key-value pair is separated by a '='
					postData.append(("Name")).append("=").append((data));
					RequestBuilder builder = new RequestBuilder(RequestBuilder.POST, "/cookieServlet");
					builder.setHeader("Content-type", "application/x-www-form-urlencoded");
					
					try {
						  builder.sendRequest(postData.toString(), new RequestCallback() {
							
							@Override
							public void onResponseReceived(Request request, Response response) {
								response.getText();
								
							}
							
							@Override
							public void onError(Request request, Throwable exception) {
								// TODO Auto-generated method stub
								
							}
						});/* or other RequestCallback impl*/ /* or other RequestCallback impl*/
						} catch (RequestException e) {
						  // handle this
						}
					
					
					
					
				}
				
			}
			}
		});
		
		
		btnAccessData.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Widget sender =(Widget) event.getSource();
                  if(sender.equals(btnAccessData)){
					
					
					RequestBuilder builder = new RequestBuilder(RequestBuilder.POST, "/getcookieServlet");
					builder.setHeader("Content-type", "application/x-www-form-urlencoded");
					
					try {
						  builder.sendRequest(null, new RequestCallback() {
							
							@Override
							public void onResponseReceived(Request request, Response response) {
								String items=response.getText();
								TextArea textArea = new TextArea();
								textArea.setText(items);
								textArea.setReadOnly(true);
								textArea.setHeight("200px");
								RootPanel.get().add(textArea);
								
								
							}
							
							@Override
							public void onError(Request request, Throwable exception) {
								// TODO Auto-generated method stub
								
							}
						});/* or other RequestCallback impl*/ /* or other RequestCallback impl*/
						} catch (RequestException e) {
						  // handle this
						}
					
				}
				
			}
		});
		RootPanel.get().add(box);
		RootPanel.get().add(button);
		RootPanel.get().add(btnAccessData);
		RootPanel.get("nameFieldContainer");
	}

	@Override
	public void onClick(ClickEvent event) {
		
		
		
	}
}
