package com.bytecode.vaadin.builder.factory

import com.vaadin.ui.AbstractOrderedLayout

/**
 * Created by rcigni on 06/08/14.
 */
class OrderedComponentContainerFactory extends ComponentContainerFactory {

    OrderedComponentContainerFactory(Class component) {
        super(component)
        assert AbstractOrderedLayout.isAssignableFrom(component)
    }

    @Override
    void setChild(FactoryBuilderSupport builder, Object parent, Object child) {
        super.setChild(builder, parent, child)
        if (builder.context.expandRatio != null) {
            parent.setExpandRatio(child, builder.context.remove('expandRatio'))
        }
    }

    static onAttributeDelegate(FactoryBuilderSupport builder, Object node, Map attributes) {
        if (attributes.containsKey('expandRatio')) {
            builder.context.expandRatio = attributes.remove('expandRatio')
        }
    }
}
