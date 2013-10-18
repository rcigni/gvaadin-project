package com.bytecode.vaadin.builder.factory

import com.vaadin.ui.Component

/**
 * Created with IntelliJ IDEA.
 * User: rcigni
 * Date: 10/18/13
 * Time: 12:57 PM
 * To change this template use File | Settings | File Templates.
 */
abstract class NamedComponentFactory extends AbstractFactory {

    @Override
    final Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) throws InstantiationException, IllegalAccessException {
        Component instance = newInstance(builder, name, attributes);
        if (value && builder instanceof NamedComponentHandler) {
            ((NamedComponentHandler)builder).notify(value, instance);
        }
        instance
    }

    abstract Component newInstance(FactoryBuilderSupport builder, Object name, Map attributes) throws InstantiationException, IllegalAccessException
}
