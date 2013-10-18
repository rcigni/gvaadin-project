package com.bytecode.vaadin.builder.factory

import com.vaadin.ui.Button

/**
 * Created with IntelliJ IDEA.
 * User: rcigni
 * Date: 10/18/13
 * Time: 11:47 AM
 * To change this template use File | Settings | File Templates.
 */
class ButtonFactory extends AbstractFactory{

    @Override
    Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) throws InstantiationException, IllegalAccessException {
        new Button()
    }

    @Override
    boolean isLeaf() {true}
}
