package com.javier.quotes.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "quotes")
@NoArgsConstructor
@AllArgsConstructor
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Content cannot be empty")
    @Size(min = 10, max = 500, message = "El contenido debe tener entre 10 y 500 caracteres")
    @Column(nullable = false, length = 500)
    private String content;

    @NotBlank(message = "Autor no debe estar vacío")
    @Size(min = 2, max = 100, message = "El nombre de autor debe tener entre 2 y 100 caracteres")
    @Column(nullable = false, length = 100)
    private String author;

    @NotBlank(message = "Categoría no debe estar vacío")
    @Size(min = 2, max = 50, message = "Categoria debe tener entre 2 y 50 caracteres")
    @Column(nullable = false, length = 50)
    private String category;
}
