package com.bytecode.vaadin.builder

import com.vaadin.ui.Component

/**
 * Created by rcigni on 07/08/14.
 */
@Category class VaadinView {

    VaadinBuilder builder

    VaadinView() {
        this.builder = new VaadinBuilder()
        componentRoot = render()

        this.builder.variables.each {prop ->
            if (this.hasProperty(prop.key)) {
                this."${prop.key}" = prop.value
            }
        }
    }

    Component render() {}

    public Map getIdentifiedComponents() {
        return this.builder.variables
    }
}
