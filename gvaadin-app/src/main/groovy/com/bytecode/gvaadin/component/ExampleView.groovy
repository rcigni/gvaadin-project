package com.bytecode.gvaadin.component

import com.bytecode.vaadin.builder.VaadinBuilder
import com.vaadin.ui.Button
import com.vaadin.ui.Component
import com.vaadin.ui.Label

/**
 * Created with IntelliJ IDEA.
 * User: rcigni
 * Date: 10/20/13
 * Time: 5:59 PM
 * To change this template use File | Settings | File Templates.
 */
class ExampleView {

    Component build() {

        VaadinBuilder builder = new VaadinBuilder();

        Component layout = builder.verticalLayout(margin: true) {
            button('click', caption: "Click Me!")
        }

        builder.registry.click.addClickListener = {event ->
            layout.addComponent(new Label("Thank you for clicking"));
        } as Button.ClickListener

        layout
    }
}
