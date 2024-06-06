package com.cw.views.cliente;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import org.apache.catalina.Contained;
import org.atmosphere.interceptor.AtmosphereResourceStateRecovery;

public class ClienteAbmView extends Dialog {

    private TextField documento= new TextField("RUC/CI Nro.");
    private TextField nombre= new TextField("Nombres y Apellidos / Razón Social");
    private TextField telefono= new TextField("Telefono");
    private TextField direccion= new TextField("Direccion");
    private Button grabar= new Button("Grabar");
    private Button cancelar= new Button("Cancelar");


    public ClienteAbmView() {
        add(layoutContenedorPrincipal());
    }

    private Component layoutContenedorPrincipal() {
        grabar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        cancelar.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        documento.setClearButtonVisible(true);
        nombre.setClearButtonVisible(true);
        telefono.setClearButtonVisible(true);
        direccion.setClearButtonVisible(true);

        var form= new FormLayout();
        form.add(documento, nombre, telefono, direccion);
        form.setSizeFull();

        Footer contenBotones= new Footer();
        contenBotones.add(new HorizontalLayout(grabar, cancelar));
        
        var contenedorPrimario= new VerticalLayout();
        contenedorPrimario.add(form, contenBotones);
        contenedorPrimario.setSizeFull();

        return contenedorPrimario;
    }
}
