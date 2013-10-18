package com.bytecode.vaadin.builder.factory;

import com.vaadin.ui.Component;

/**
 * Created with IntelliJ IDEA.
 * User: rcigni
 * Date: 10/18/13
 * Time: 1:02 PM
 * To change this template use File | Settings | File Templates.
 */
public interface NamedComponentHandler {

    void notify(String name, Component component);
}
