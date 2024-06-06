package com.cw.views.recepción;

import com.cw.views.cliente.ClienteAbmView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class RecepcionForm extends VerticalLayout {
    private ClienteAbmView clienteAbmView= new ClienteAbmView();

    //cuadro de texto para ingreso de datos del cliente
    private TextField rucCliente= new TextField("RUC/CI Nro.:");
    private TextField nombreCliente= new TextField("Cliente:");
    private TextField direccionCliente= new TextField("Direccion");
    private TextField telefonoCliente= new TextField("Telefono");
    private Grid<String> serviciosGrid= new Grid<>();

    private TextField chapaVehiculo= new TextField("Chapa");
    private TextField marcaVehiculo= new TextField("Marca");
    private TextField colorVehiculo= new TextField("Color");
    private Button grabarRecepcion= new Button("Grabar");
    private Button cancelarRecepcion= new Button("Cancelar");
    private Button agregarCliente= new Button("+");
    private Button agregarVehiculo= new Button("+");
    private Button agregarServicio= new Button("Agregar Servicios");


    public RecepcionForm() {


        armarFormulario();

        setSpacing(false);

        agregarCliente.addClickListener(event -> {
            clienteAbmView= new ClienteAbmView();
            clienteAbmView.open();
        });


    }

    private void armarFormulario() {
        Header encabezado= new Header();
        encabezado.add(new H2("GESTIONAR RECEPCION PARA SERVICIO"));

        Section sectionCliente= new Section(new H2("Datos del Cliente"),
                layoutDatosClientes());
        Section sectionVehiculo= new Section(new H2("Datos Vehiculo"),
                layoutDatosVehiculo());
        Section sectionServicios= new Section(new H2("Agregar Servicios"));

        Footer pieFormulario= new Footer();
        var contenedorBotones= new HorizontalLayout();
        contenedorBotones.setWidthFull();
        contenedorBotones.setJustifyContentMode(JustifyContentMode.END);
        contenedorBotones.add(grabarRecepcion, cancelarRecepcion);
        pieFormulario.add(contenedorBotones);
        pieFormulario.setWidthFull();

        var contenedorPrincipal = new VerticalLayout();
        contenedorPrincipal.add(sectionCliente,layoutDatosClientes(),
                sectionVehiculo, layoutDatosVehiculo(), sectionServicios, layoutGridDetalle());
        contenedorPrincipal.setSizeFull();

        Scroller scroller= new Scroller();
        scroller.setScrollDirection(Scroller.ScrollDirection.VERTICAL);

        scroller.setContent(contenedorPrincipal);
        scroller.setSizeFull();

        add(encabezado,scroller,pieFormulario);

    }

    private Component layoutDatosVehiculo() {
        agregarVehiculo.addThemeVariants(ButtonVariant.LUMO_ICON);
        chapaVehiculo.setClearButtonVisible(true);
        marcaVehiculo.setClearButtonVisible(true);
        colorVehiculo.setClearButtonVisible(true);

        var forDatosVehiculo= new FormLayout();
        var conten1= new HorizontalLayout();
        conten1.setJustifyContentMode(JustifyContentMode.START);
        conten1.setAlignItems(Alignment.END);
        conten1.add(agregarVehiculo,chapaVehiculo);
        forDatosVehiculo.add(conten1, marcaVehiculo, colorVehiculo);
        return forDatosVehiculo;
    }

    private Component layoutDatosClientes() {
        agregarCliente.addThemeVariants(ButtonVariant.LUMO_ICON);
        rucCliente.setClearButtonVisible(true);
        nombreCliente.setClearButtonVisible(true);
        direccionCliente.setClearButtonVisible(true);
        telefonoCliente.setClearButtonVisible(true);
        var formDatosClientes= new FormLayout();
        var cont1= new HorizontalLayout();
        cont1.add(agregarCliente,rucCliente);
        cont1.setJustifyContentMode(JustifyContentMode.START);
        cont1.setAlignItems(Alignment.END);
        formDatosClientes.add(cont1, nombreCliente, direccionCliente, telefonoCliente);
        return formDatosClientes;
    }

    private Component layoutGridDetalle(){
        var contenedorGrid= new VerticalLayout();
        agregarServicio.addThemeVariants(ButtonVariant.LUMO_ICON);
        serviciosGrid.setSizeFull();
        serviciosGrid.addColumn(String::new)
                .setHeader("ORDEN");
        serviciosGrid.addColumn(String::new)
                .setHeader("SERVICIO");
        serviciosGrid.addColumn(String::new)
                .setHeader("OBS");
        contenedorGrid.add(agregarServicio, serviciosGrid);
        return contenedorGrid;
    }
}
