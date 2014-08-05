package com.bytecode.vaadin.builder.factory

import com.vaadin.ui.Component
import com.vaadin.ui.Label

/**
 * Created with IntelliJ IDEA.
 * User: rcigni
 * Date: 10/18/13
 * Time: 1:24 PM
 * To change this template use File | Settings | File Templates.
 */
class LeafComponentFactory extends AbstractFactory {

    Class clazz

    LeafComponentFactory(Class clazz) {
        assert Component.isAssignableFrom(clazz)
        this.clazz = clazz
    }

    @Override
    boolean isLeaf() {true}

    @Override
    Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) throws InstantiationException, IllegalAccessException {
        clazz.newInstance()
    }
}
