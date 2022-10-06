/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.domain;

import java.io.Serializable;
import javax.persistence.*;

public class Cliente {

    @Data
    @Entity

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(Strategy = GenerationType.IDENTITY)
    private Long idCliente;

    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
}
