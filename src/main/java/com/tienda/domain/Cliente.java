package com.tienda.domain;

import java.io.Serializable;
import javax.persistence.*;


@Data
@Entity




private static final long serialVersionUID = 1L;

@Id
@GeneratedValue (Strategy = GenerationType.IDENTITY)
private Long idCliente;


private String nombre;
private String apellidos;
private String correo;
private String telefono;