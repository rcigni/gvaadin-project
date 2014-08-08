package com.bytecode.vaadin.builder

import com.bytecode.vaadin.builder.factory.ActionPerformComponentFactory
import com.bytecode.vaadin.builder.factory.ComponentContainerFactory
import com.bytecode.vaadin.builder.factory.LeafComponentFactory
import com.bytecode.vaadin.builder.factory.OrderedComponentContainerFactory
import com.bytecode.vaadin.builder.factory.SingleComponentFactory
import com.vaadin.ui.Button
import com.vaadin.ui.FormLayout
import com.vaadin.ui.HorizontalLayout
import com.vaadin.ui.VerticalLayout

import java.util.logging.Logger

import groovy.swing.factory.MapFactory
import groovy.swing.factory.CollectionFactory

/**
 * A helper class for creating Swing widgets using GroovyMarkup
 */
public class VaadinBuilder extends FactoryBuilderSupport {

    private static final Logger LOG = Logger.getLogger(VaadinBuilder.name)

    public static final String DELEGATE_PROPERTY_OBJECT_ID = "_delegateProperty:id";
    public static final String DEFAULT_DELEGATE_PROPERTY_OBJECT_ID = "id";

    public VaadinBuilder(boolean init = true) {
        super(init)
        this[DELEGATE_PROPERTY_OBJECT_ID] = DEFAULT_DELEGATE_PROPERTY_OBJECT_ID
    }

    public objectIDAttributeDelegate(def builder, def node, def attributes) {
        def idAttr = builder.getAt(DELEGATE_PROPERTY_OBJECT_ID) ?: DEFAULT_DELEGATE_PROPERTY_OBJECT_ID
        def theID = attributes.remove(idAttr)
        if (theID) {
            builder.setVariable(theID, node)
            if(node) {
                try {
                    if (!node.name) node.name = theID
                } catch (MissingPropertyException mpe) {
                    // ignore
                }
            }
        }
    }

    def registerBasic() {

        // layouts
        registerFactory "verticalLayout", new OrderedComponentContainerFactory(VerticalLayout.class);
        registerFactory "horizontalLayout", new OrderedComponentContainerFactory(HorizontalLayout.class);
        registerFactory("formLayout", new OrderedComponentContainerFactory(FormLayout.class))
        addAttributeDelegate OrderedComponentContainerFactory.&onAttributeDelegate

        registerFactory("gridLayout", new ComponentContainerFactory(com.vaadin.ui.GridLayout.class))
        registerFactory "panel", new SingleComponentFactory(com.vaadin.ui.Panel.class);

        // simple leafs
        registerFactory "label", new LeafComponentFactory(com.vaadin.ui.Label.class);
        // inputs
        registerFactory "textField", new LeafComponentFactory(com.vaadin.ui.TextField.class);
        registerFactory "textArea", new LeafComponentFactory(com.vaadin.ui.TextArea.class);

        registerFactory("actions", new CollectionFactory())
        registerFactory("map", new MapFactory())
        //object id delegate, for propertyNotFound
        addAttributeDelegate this.&objectIDAttributeDelegate
        registerFactory("noparent", new CollectionFactory())

    }



    def registerActionPerformer() {
        def actionPerformComponentFactory = new ActionPerformComponentFactory(Button.class)
        registerFactory "button", actionPerformComponentFactory;
        //registerExplicitMethod("on", actionPerformComponentFactory.&onAction)
    }


    /**
     * Compatibility API.
     *
     * @param c run this closure in the builder
     */
    public Object build(Closure c) {
        c.setDelegate(this)
        return c.call()
    }
}
