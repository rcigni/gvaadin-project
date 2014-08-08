package com.bytecode.gvaadin.component

import com.bytecode.vaadin.builder.VaadinBuilder
import com.vaadin.ui.Button
import com.vaadin.ui.Component
import com.vaadin.ui.Label

/**
 * User: rcigni
 */
class ExampleView {

    Component build() {

        VaadinBuilder builder = new VaadinBuilder();

        Component layout = builder.verticalLayout(margin: true) {
            button(id: 'click', caption: "example.click")
        }

        builder.variables.click.addClickListener = {event ->
            layout.addComponent(new Label("Thank you for clicking"));
        } as Button.ClickListener

        layout
    }
}
