package com.cw.views.recepción;

import com.cw.views.MainLayout;
import com.cw.views.cliente.ClienteAbmView;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import jakarta.annotation.security.RolesAllowed;

@PageTitle("Recepción")
@Route(value = "sercivios-clientes", layout = MainLayout.class)
@RolesAllowed("USER")
public class RecepciónView extends HorizontalLayout {

    RecepcionForm recepcionForm= new RecepcionForm();

    public RecepciónView() {

        recepcionForm.setHeight("100%");
        recepcionForm.setMaxWidth("900px");

        add(recepcionForm);

        setSpacing(false);

        getStyle().set("text-align", "center");

        setAlignItems(Alignment.CENTER);

        setSizeFull();

    }

}
