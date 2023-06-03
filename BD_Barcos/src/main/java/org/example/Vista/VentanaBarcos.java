package org.example.Vista;

import javax.swing.*;
import java.awt.*;

public class VentanaBarcos extends JFrame {
    private JLabel lblID;
    private JLabel lblNombre;
    private JLabel lblTipo;
    private JLabel lblAnos;
    private JLabel lblPasajeros;
    private JLabel lblURL;
    private JTextField txtID;
    private JTextField txtNombre;
    private JTextField txtTipo;
    private JTextField txtAno;
    private JTextField txtPasajeros;
    private JTextField txtURL;

    private JButton btnAgregar;
    private JTable tblBarcos;
    private JScrollPane scrollPane;
    private GridLayout layout;
    private JPanel panel1;//Formulario para capturar libros
    private JPanel panel2;//Tabla para mostrar los libros
    private JLabel imagenPanel3;
    private JPanel panel3;//
    private JPanel panel4;//
    private JButton btnCargar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnActualizar2;


    public VentanaBarcos(String title) throws HeadlessException {
        super(title);
        this.setSize(800, 8000);
        layout = new GridLayout(2, 2);
        this.getContentPane().setLayout(layout);
        //Panel1
        panel1 = new JPanel(null);
        panel1.setBackground(new Color(215, 180, 255));
        lblID=new JLabel("ID:");
        lblID.setBounds(10,5,15,25);

        lblNombre=new JLabel("Nombre:");
        lblNombre.setBounds(10,35,60,25);

        lblTipo=new JLabel("Tipo:");
        lblTipo.setBounds(10,65,60,25);

        lblAnos=new JLabel("Anio:");
        lblAnos.setBounds(10,95,30,25);

        lblPasajeros=new JLabel("No. Pasajeros:");
        lblPasajeros.setBounds(10,125,100,25);

        lblURL=new JLabel("URL imagen");
        lblURL.setBounds(10,155,100,25);

        txtID=new JTextField(3);
        txtID.setBounds(100,5,270,25);
        txtID.setText("0");
        txtID.setEnabled(false);

        txtNombre=new JTextField();
        txtNombre.setBounds(100,35,270,25);

        txtTipo=new JTextField();
        txtTipo.setBounds(100,65,270,25);

        txtAno=new JTextField();
        txtAno.setBounds(100,95,270,25);

        txtPasajeros=new JTextField();
        txtPasajeros.setBounds(100,125,270,25);

        txtURL=new JTextField();
        txtURL.setBounds(100,155,270,25);

        btnAgregar=new JButton("Agregar");
        btnAgregar.setBounds(20,200,350,50);
        btnAgregar.setVisible(true);
        btnActualizar2=new JButton("Actualizar");
        btnActualizar2.setBounds(20,200,350,50);
        btnActualizar2.setVisible(false);
        panel1.add(lblID);
        panel1.add(txtID);
        panel1.add(lblNombre);
        panel1.add(txtNombre);
        panel1.add(lblTipo);
        panel1.add(txtTipo);
        panel1.add(lblAnos);
        panel1.add(txtAno);
        panel1.add(lblPasajeros);
        panel1.add(txtPasajeros);
        panel1.add(lblURL);
        panel1.add(txtURL);
        panel1.add(btnAgregar);
        panel1.add(btnActualizar2);
        //Panel2

        panel2 = new JPanel(null);
        panel2.setBackground(new Color(178, 194, 255));
        btnCargar=new JButton("Cargar");
        btnCargar.setBounds(150,5,100,30);
        panel2.add(btnCargar);
        tblBarcos=new JTable();

        scrollPane=new JScrollPane(tblBarcos);
        scrollPane.setBounds(2,40,388,330);
        panel2.add(scrollPane);
        //Panel3
        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(175, 255, 184));
        imagenPanel3=new JLabel("...");
        panel3.add(imagenPanel3);
        //Panel4
        panel4 = new JPanel(new FlowLayout());
        panel4.setBackground(new Color(229, 241, 52));
        btnActualizar=new JButton("Actualizar");
        btnEliminar=new JButton("Eliminar");
        panel4.add(btnActualizar);
        panel4.add(btnEliminar);
       
        this.getContentPane().add(panel1,0);
        this.getContentPane().add(panel2,1);
        this.getContentPane().add(panel3,2);
        this.getContentPane().add(panel4,3);
        this.setResizable(false);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JLabel getLblID() {
        return lblID;
    }

    public void setLblID(JLabel lblID) {
        this.lblID = lblID;
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    public JLabel getLblTipo() {
        return lblTipo;
    }

    public void setLblTipo(JLabel lblTipo) {
        this.lblTipo = lblTipo;
    }

    public JLabel getLblAnos() {
        return lblAnos;
    }

    public void setLblAnos(JLabel lblAnos) {
        this.lblAnos = lblAnos;
    }

    public JLabel getLblPasajeros() {
        return lblPasajeros;
    }

    public void setLblPasajeros(JLabel lblPasajeros) {
        this.lblPasajeros = lblPasajeros;
    }

    public JLabel getLblURL() {
        return lblURL;
    }

    public void setLblURL(JLabel lblURL) {
        this.lblURL = lblURL;
    }

    public JTextField getTxtID() {
        return txtID;
    }

    public void setTxtID(JTextField txtID) {
        this.txtID = txtID;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtTipo() {
        return txtTipo;
    }

    public void setTxtTipo(JTextField txtTipo) {
        this.txtTipo = txtTipo;
    }

    public JTextField getTxtAno() {
        return txtAno;
    }

    public void setTxtAno(JTextField txtAno) {
        this.txtAno = txtAno;
    }

    public JTextField getTxtPasajeros() {
        return txtPasajeros;
    }

    public void setTxtPasajeros(JTextField txtPasajeros) {
        this.txtPasajeros = txtPasajeros;
    }

    public JTextField getTxtURL() {
        return txtURL;
    }

    public void setTxtURL(JTextField txtURL) {
        this.txtURL = txtURL;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JTable getTblBarcos() {
        return tblBarcos;
    }

    public void setTblBarcos(JTable tblBarcos) {
        this.tblBarcos = tblBarcos;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JLabel getImagenPanel3() {
        return imagenPanel3;
    }

    public void setImagenPanel3(JLabel imagenPanel3) {
        this.imagenPanel3 = imagenPanel3;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }

    public void setBtnCargar(JButton btnCargar) {
        this.btnCargar = btnCargar;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JButton getBtnActualizar2() {
        return btnActualizar2;
    }

    public void setBtnActualizar2(JButton btnActualizar2) {
        this.btnActualizar2 = btnActualizar2;
    }

    public void Limpiar1(){

        txtNombre.setText("");
        txtTipo.setText("");
        txtAno.setText("");
        txtPasajeros.setText("");
        txtURL.setText("");
    }
    public void Limpiar2(){
        txtID.setText("0");
        txtNombre.setText("");
        txtTipo.setText("");
        txtAno.setText("");
        txtPasajeros.setText("");
        txtURL.setText("");
        btnAgregar.setVisible(true);
        btnActualizar2.setVisible(false);
    }
    public void Actualizar(String id,String nombre,String tipo,String ano,String pasajeros,String url){
        txtID.setText(id);
        txtNombre.setText(nombre);
        txtTipo.setText(tipo);
        txtAno.setText(ano);
        txtPasajeros.setText(pasajeros);
        txtURL.setText(url);
        btnAgregar.setVisible(false);
        btnActualizar2.setVisible(true);
    }

}
