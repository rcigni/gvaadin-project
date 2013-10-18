package com.bytecode.vaadin.builder

import com.vaadin.ui.Button
import com.vaadin.ui.ComponentContainer
import com.vaadin.ui.VerticalLayout
import org.junit.Test

/**
 * Created with IntelliJ IDEA.
 * User: rcigni
 * Date: 10/18/13
 * Time: 11:11 AM
 * To change this template use File | Settings | File Templates.
 */
class VaadinBuilderTest {

    @Test
    public void testBuilder1() {



        def builder = new VaadinBuilder();

        def view = builder.verticalLayout {
            button(caption: "click me")
            button(caption: 'and me')
        }

        assert view instanceof VerticalLayout
        def expectButton = view.iterator()[0]
        assert expectButton instanceof Button
        assert expectButton.caption == 'click me'
        assert view.iterator()[1].caption == 'click me'
    }
}
