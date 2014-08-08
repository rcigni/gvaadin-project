package com.bytecode.vaadin.builder

import com.vaadin.shared.ui.MarginInfo
import com.vaadin.ui.*
import org.codehaus.groovy.runtime.typehandling.GroovyCastException
import org.junit.Test

/**
 * User: rcigni
 */
class VaadinBuilderTest extends GroovyTestCase{

    @Test
    public void testValiables() {

        def builder = new VaadinBuilder();

        def view = builder.verticalLayout(id: 'outher') {
            label(value: 'label')
            button(caption: "click me")

            shouldFail {
                assert inner
            }

            verticalLayout(id: 'inner') {
                assert inner
                assert outher
            }

            assert inner
            assert outher
        }

        assert ['inner', 'outher'].every {builder.variables.containsKey(it)}

        assert view instanceof VerticalLayout
        def expectLabel = view.iterator()[0]
        assert expectLabel instanceof Label
        assert expectLabel.value == 'label'
        assert view.iterator()[1].caption == 'click me'

    }

    @Test
    public void testBuilderExpand() {

        def builder = new VaadinBuilder();
        def v0, v1, v2, v3, v4

        def view = builder.verticalLayout() {
            v0 = button(caption: "click me")
            v1 = button(caption: "click me", expandRatio: 10f)
            v2 = button(caption: "click me")
            v3 = button(caption: "click me", expandRatio: 12f)
            v4 = button(caption: "click me")

        }

        assert v1 instanceof Button

        assert view.getExpandRatio(v0) == 0f
        assert view.getExpandRatio(v1) == 10f
        assert view.getExpandRatio(v2) == 0f
        assert view.getExpandRatio(v3) == 12f
        assert view.getExpandRatio(v4) == 0f
    }


    @Test
    public void testMargins() {

        VerticalLayout layout = new VaadinBuilder().verticalLayout(margin: new MarginInfo(true));
        assertTrueMargin(layout.margin)

        shouldFail(GroovyCastException.class) {
            new VaadinBuilder().verticalLayout(margin: true);
        }

    }

    static assertTrueMargin(MarginInfo mi) {
        assert mi.hasLeft() && mi.hasRight() && mi.hasTop() && mi.hasBottom()
    }

}
