package com.bytecode.gvaadin.component

import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;

/**
 * Created by rcigni on 07/08/14.
 */
@SqView
public class SampleView extends CustomComponent {

    Button okButton

//    SampleView() {
//
//        def builder = new VaadinBuilder()
//
//        design(builder)
//
//        compositionRoot = builder.current
//
//        this.properties = builder.variables
//
//    }

    {

    }

    private void design() {

        verticalLayout {
            textField(id: "theTextField")
            button(id: "okButton", caption: "ok", events: [click: 'suka'])
        }

    }




}
